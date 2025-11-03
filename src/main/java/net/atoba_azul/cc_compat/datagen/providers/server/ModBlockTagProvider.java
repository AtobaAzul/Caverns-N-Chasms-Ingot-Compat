package net.atoba_azul.cc_compat.datagen.providers.server;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.atoba_azul.cc_compat.CCCompat.MOD_ID;
import static net.atoba_azul.cc_compat.registries.CompatBlocks.ALL_INGOT_BLOCKS;


public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        IntrinsicTagAppender<Block> mineable = tag(BlockTags.MINEABLE_WITH_PICKAXE);


        ALL_INGOT_BLOCKS.forEach((ingot) -> {

            mineable.addOptional(ingot.getId());
        });
    }
}
