package net.atoba_azul.cc_compat.datagen;


import net.atoba_azul.cc_compat.datagen.providers.server.ModBlockTagProvider;
import net.atoba_azul.cc_compat.datagen.providers.server.ModItemTagsProvider;
import net.atoba_azul.cc_compat.datagen.providers.server.ModLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

import static net.atoba_azul.cc_compat.CCCompat.MOD_ID;


@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {

        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();


        boolean server = event.includeServer();

        ModBlockTagProvider blockTagProvider = generator.addProvider(event.includeServer(), new ModBlockTagProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(server, new ModItemTagsProvider(packOutput, lookupProvider, blockTagProvider.contentsGetter(), existingFileHelper));
        //This can't generate loot tables for items that aren't in the registry here in the dev env.
        //however, it did get *most* of them. There's just a couple mods that don't work.
        //generator.addProvider(server, new ModLootTableProvider(packOutput));
    }
}
