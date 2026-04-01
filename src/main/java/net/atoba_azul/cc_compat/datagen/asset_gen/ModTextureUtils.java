package net.atoba_azul.cc_compat.datagen.asset_gen;

import net.mehvahdjukaar.moonlight.api.resources.RPUtils;
import net.mehvahdjukaar.moonlight.api.resources.textures.Palette;
import net.mehvahdjukaar.moonlight.api.resources.textures.Respriter;
import net.mehvahdjukaar.moonlight.api.resources.textures.TextureImage;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.io.IOException;

import static net.atoba_azul.cc_compat.CCCompat.MOD_ID;

public class ModTextureUtils {
    public static TextureImage generateIngotTextures(ResourceManager manager, RegistryObject<Block> item) throws IOException {

        TextureImage ingotBase = TextureImage.open(manager, new ResourceLocation("caverns_and_chasms", "block/gold_ingot"));

        if (item.get().asItem() != Items.AIR) {
            if (item.getId().getPath().contains("brick")) {
                ingotBase = TextureImage.open(manager, new ResourceLocation("caverns_and_chasms", "block/brick"));
            } else if (item.getId().getPath().contains("mekanism")) { //mek's textures work better with this.
                ingotBase = TextureImage.open(manager, new ResourceLocation("caverns_and_chasms", "block/copper_ingot"));
            }

            ResourceLocation ingotItemTextureLocation = RPUtils.findFirstItemTextureLocation(manager, item.get().asItem());

            TextureImage ingotItemTexture = TextureImage.open(manager, ingotItemTextureLocation);

            Respriter respriter = Respriter.of(ingotBase);
            Palette ingotPallete = ModPallete.modifyPaletteExample(ingotItemTexture);

            return respriter.recolor(ingotPallete);
        }
        return ingotBase;
    }
}
