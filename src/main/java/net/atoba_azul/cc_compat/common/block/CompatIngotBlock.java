package net.atoba_azul.cc_compat.common.block;

import com.teamabnormals.caverns_and_chasms.common.block.IngotBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.ForgeRegistries;

public class CompatIngotBlock extends IngotBlock {
    private final ResourceLocation item_resource;

    public CompatIngotBlock(ResourceLocation item, ResourceLocation blockCopy) {
        super(() -> ForgeRegistries.ITEMS.getValue(item) != null ? ForgeRegistries.ITEMS.getValue(item) : Items.BARRIER,
                ForgeRegistries.BLOCKS.getValue(blockCopy) != null ? BlockBehaviour.Properties.copy(ForgeRegistries.BLOCKS.getValue(blockCopy)) : BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK));
        this.item_resource = item;
    }

    public CompatIngotBlock(ResourceLocation item) {
        super(() -> ForgeRegistries.ITEMS.getValue(item) != null ? ForgeRegistries.ITEMS.getValue(item) : Items.BARRIER, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK));
        this.item_resource = item;
    }

    public ResourceLocation getItemResourceLocation() {
        return this.item_resource;
    }
}
