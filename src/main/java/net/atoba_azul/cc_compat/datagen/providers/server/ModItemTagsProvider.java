package net.atoba_azul.cc_compat.datagen.providers.server;


import com.teamabnormals.caverns_and_chasms.core.other.tags.CCItemTags;
import net.atoba_azul.cc_compat.common.block.CompatIngotBlock;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

import static net.atoba_azul.cc_compat.CCCompat.MOD_ID;
import static net.atoba_azul.cc_compat.CCCompat.REGISTRY_HELPER;


public class ModItemTagsProvider extends net.minecraft.data.tags.ItemTagsProvider {
    public ModItemTagsProvider(@NotNull PackOutput output, @NotNull CompletableFuture<HolderLookup.Provider> lookupProvider, @NotNull CompletableFuture<TagLookup<Block>> blockTags, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, MOD_ID, existingFileHelper);
    }

    private static ResourceLocation modItem(String name) {
        String[] split = name.split(":");
        return new ResourceLocation(split[0], split[1]);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        IntrinsicTagAppender<Item> placeable = tag(CCItemTags.PLACEABLE_ITEMS);

        Collection<RegistryObject<Item>> items = REGISTRY_HELPER.getItemSubHelper().getDeferredRegister().getEntries();
        for (RegistryObject<Item> reg : items) {
            if (reg.get() instanceof BlockItem blockItem) {
                CompatIngotBlock block = (CompatIngotBlock) blockItem.getBlock();
                placeable.addOptional(block.getItemResourceLocation());
            }
        }
    }
}
