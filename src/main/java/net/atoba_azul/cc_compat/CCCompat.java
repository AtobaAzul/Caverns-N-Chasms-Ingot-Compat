package net.atoba_azul.cc_compat;

import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.atoba_azul.cc_compat.common.data.OptionalLootItem;
import net.atoba_azul.cc_compat.datagen.asset_gen.ModDynamicResources;
import net.atoba_azul.cc_compat.registries.CCCompatBlockSubRegistryHelper;
import net.mehvahdjukaar.moonlight.api.platform.PlatHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CCCompat.MOD_ID)
public class CCCompat
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "cc_compat";

    private static final DeferredRegister<LootPoolEntryType> POOL_ENTRY_TYPES = DeferredRegister.create(Registries.LOOT_POOL_ENTRY_TYPE, MOD_ID);
    public static final RegistryHelper REGISTRY_HELPER = RegistryHelper.create(MOD_ID, helper -> helper.putSubHelper(ForgeRegistries.BLOCKS, new CCCompatBlockSubRegistryHelper(helper)));
    public static final RegistryObject<LootPoolEntryType> OPTIONAL_LOOT_ITEM = POOL_ENTRY_TYPES.register(
            "optional_item",
            () -> new LootPoolEntryType(new OptionalLootItem.Serializer())
    );

    public CCCompat(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        if (PlatHelper.getPhysicalSide().isClient()) {
            ModDynamicResources.init_client();
        }

        // Register the subregistry helper
        REGISTRY_HELPER.register(modEventBus);
        POOL_ENTRY_TYPES.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

}
