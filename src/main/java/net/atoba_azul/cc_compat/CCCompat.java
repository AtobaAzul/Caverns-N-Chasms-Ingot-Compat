package net.atoba_azul.cc_compat;

import com.mojang.logging.LogUtils;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import com.teamabnormals.caverns_and_chasms.common.block.IngotLayer;
import net.atoba_azul.cc_compat.common.data.OptionalLootItem;
import net.atoba_azul.cc_compat.datagen.asset_gen.ModDynamicResources;
import net.atoba_azul.cc_compat.registries.CCCompatBlockSubRegistryHelper;
import net.mehvahdjukaar.moonlight.api.platform.PlatHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import static com.teamabnormals.caverns_and_chasms.common.block.IngotBlock.LAYERS;
import static com.teamabnormals.caverns_and_chasms.common.block.IngotBlock.TOP_INGOT;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CCCompat.MOD_ID)
public class CCCompat
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "cc_compat";
    public static final Logger LOGGER = LogUtils.getLogger();

    private static final DeferredRegister<LootPoolEntryType> POOL_ENTRY_TYPES = DeferredRegister.create(Registries.LOOT_POOL_ENTRY_TYPE, MOD_ID);
    public static final RegistryHelper REGISTRY_HELPER = RegistryHelper.create(MOD_ID, helper -> helper.putSubHelper(ForgeRegistries.BLOCKS, new CCCompatBlockSubRegistryHelper(helper)));
    public static final RegistryObject<LootPoolEntryType> OPTIONAL_LOOT_ITEM = POOL_ENTRY_TYPES.register(
            "optional_item",
            () -> new LootPoolEntryType(new OptionalLootItem.Serializer())
    );

    public CCCompat()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext context = ModLoadingContext.get();
        MinecraftForge.EVENT_BUS.register(this);

        // Register the commonSetup method for modloading
        bus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        if (PlatHelper.getPhysicalSide().isClient()) {
            ModDynamicResources.init_client();
        }

        // Register the subregistry helper
        REGISTRY_HELPER.register(bus);
        POOL_ENTRY_TYPES.register(bus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    public static int getIngotCount(BlockState state) {
        int top_layer = (state.getValue(TOP_INGOT) == IngotLayer.BOTH) ? 2 : 1;
        return (state.getValue(LAYERS)*2) + top_layer;

    }

    public static BlockBehaviour.Properties copyProperties(ResourceLocation blockCopy) {
        @Nullable Block block = ForgeRegistries.BLOCKS.getValue(blockCopy);
        //We only want to copy the sound, light,  emissive rendering and strenght
        if (block != null) {
            BlockState state = block.defaultBlockState();
            return BlockBehaviour.Properties.of()
                    .destroyTime(state.getDestroySpeed(null, null))
                    .explosionResistance(state.getExplosionResistance(null, null, null))
                    .sound(state.getSoundType())
                    .lightLevel((blockstate) -> (int) Math.ceil(Mth.lerp(state.getLightEmission(null, null), 0, (float) getIngotCount(blockstate) /8)));
        }
        return null;
    }

}
