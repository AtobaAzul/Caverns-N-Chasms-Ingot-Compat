package net.atoba_azul.cc_compat.datagen.asset_gen;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.mehvahdjukaar.moonlight.api.resources.RPUtils;
import net.mehvahdjukaar.moonlight.api.resources.ResType;
import net.mehvahdjukaar.moonlight.api.resources.StaticResource;
import net.mehvahdjukaar.moonlight.api.resources.pack.DynClientResourcesGenerator;
import net.mehvahdjukaar.moonlight.api.resources.pack.DynamicTexturePack;
import net.mehvahdjukaar.moonlight.api.resources.pack.ResourceGenTask;
import net.mehvahdjukaar.moonlight.api.resources.textures.TextureImage;
import net.mehvahdjukaar.moonlight.core.Moonlight;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import static net.atoba_azul.cc_compat.CCCompat.MOD_ID;
import static net.atoba_azul.cc_compat.registries.CompatBlocks.ALL_INGOT_BLOCKS;

public class ModDynamicResources {
    // call during mod init
    public static void init_client() {
        ClientAssetsGenerator generator = new ClientAssetsGenerator();
        generator.register();
    }

    // Class responsible to generate assets into your dynamic pack
    public static class ClientAssetsGenerator extends DynClientResourcesGenerator {


        protected ClientAssetsGenerator() {
            //here you pass the dynamic texture pack instance
            super(new DynamicTexturePack(new ResourceLocation(MOD_ID, "generated_resources"), Pack.Position.TOP, false, false));
        }

        // generate here your assets

        TextureImage getIngotTexture(ResourceManager manager, RegistryObject<Block> ingot) {
            try {
                return ModTextureUtils.generateIngotTextures(manager, ingot);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void regenerateDynamicAssets(Consumer<ResourceGenTask> executor) {

            //add tasks of reasonable size for max performance

            executor.accept(((manager, sink) -> {

                Set<String> modelsLoc = new HashSet<>();
                Set<String> otherModelsLoc = new HashSet<>();

                ALL_INGOT_BLOCKS.forEach(ingot -> {
                    ResourceLocation textureName = new ResourceLocation(MOD_ID, "block/" + ingot.getId().getPath());

                    sink.addTexture(textureName, getIngotTexture(manager, ingot));

                    JsonElement blockState = RPUtils.deserializeJson(new ByteArrayInputStream(StaticResource.getOrLog(manager, ResType.BLOCKSTATES.getPath("caverns_and_chasms:silver_ingot")).data));
                    modelsLoc.addAll(RPUtils.findAllResourcesInJsonRecursive(blockState, s -> s.equals("model")));


                    JsonElement newBlockState = blockState.deepCopy();
                    JsonObject oBlockState = newBlockState.getAsJsonObject();
                    JsonArray multipart = oBlockState.get("multipart").getAsJsonArray();

                    otherModelsLoc.addAll(RPUtils.findAllResourcesInJsonRecursive(multipart, s -> s.equals("model")));

                    multipart.forEach(key -> {
                        String oldModel = key.getAsJsonObject().get("apply").getAsJsonObject().get("model").getAsString();

                        String newModel = oldModel.replace("caverns_and_chasms", MOD_ID).replace("silver_ingot", ingot.getId().getPath());


                        key.getAsJsonObject().get("apply").getAsJsonObject().addProperty("model", newModel);
                    });

                    //model
                    modelsLoc.forEach((test) -> {
                        String modelId = test.split("ingot_")[1];

                        JsonObject modelJson = new JsonObject();
                        modelJson.addProperty("parent", test);

                        JsonObject textures = new JsonObject();
                        textures.addProperty("ingot", textureName.toString());

                        modelJson.add("textures", textures);


                        sink.addBlockModel(new ResourceLocation(MOD_ID, ingot.getId().getPath() + "_" + modelId), modelJson);
                    });


                    sink.addBlockState(new ResourceLocation(MOD_ID, ingot.getId().getPath()), newBlockState);
                });
            }));

        }


        @Override
        public Logger getLogger() {
            return Moonlight.LOGGER;
        }
    }
}
