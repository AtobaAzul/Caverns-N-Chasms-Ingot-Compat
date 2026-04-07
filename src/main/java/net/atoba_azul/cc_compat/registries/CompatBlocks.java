package net.atoba_azul.cc_compat.registries;

import net.atoba_azul.cc_compat.common.block.CompatIngotBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static net.atoba_azul.cc_compat.CCCompat.MOD_ID;
import static net.atoba_azul.cc_compat.CCCompat.REGISTRY_HELPER;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CompatBlocks {
    public static final CCCompatBlockSubRegistryHelper HELPER = REGISTRY_HELPER.getBlockSubHelper();

    /*
     * checklist
     * [x] Create
     * [x] Galosphere
     * [x] Iron's Spells
     * [x] Tinker's
     * [x] Oreganized
     * [x] Create Crafts & Additions
     * [x] Immersive Engineering
     * [x] Sculk Horde
     * [x] BiC
     * [x] Samurai Dynasty
     * [x] Gobber
     * [x] Malum
     * [x] Scorched Guns
     */

    public static final List<RegistryObject<Block>> ALL_INGOT_BLOCKS = List.of(
            // create
            ingotBlock("create:brass_ingot", "create:brass_block"),
            ingotBlock("create:zinc_ingot", "create:zinc_block"),

            // galosphere
            ingotBlock("galosphere:silver_ingot", "galosphere:silver_block"),

            //irons
            ingotBlock("irons_spellbooks:arcane_ingot"),
            ingotBlock("irons_spellbooks:pyrium_ingot"),
            ingotBlock("irons_spellbooks:mithril_ingot"),

            //tconstruct
            ingotBlock("tconstruct:cobalt_ingot", "tconstruct:cobalt_block"),
            ingotBlock("tconstruct:steel_ingot", "tconstruct:steel_block"),
            ingotBlock("tconstruct:slimesteel_ingot", "tconstruct:slimesteel_block"),
            ingotBlock("tconstruct:amethyst_bronze_ingot", "tconstruct:amethyst_bronze_block"),
            ingotBlock("tconstruct:rose_gold_ingot", "tconstruct:rose_gold_block"),
            ingotBlock("tconstruct:pig_iron_ingot", "tconstruct:pig_iron_block"),
            ingotBlock("tconstruct:cinderslime_ingot", "tconstruct:cinderslime_block"),
            ingotBlock("tconstruct:queens_slime_ingot", "tconstruct:queens_slime_block"),
            ingotBlock("tconstruct:manyullyn_ingot", "tconstruct:manyullyn_block"),
            ingotBlock("tconstruct:hepatizon_ingot", "tconstruct:hepatizon_block"),
            ingotBlock("tconstruct:seared_brick", "tconstruct:seared_bricks"),
            ingotBlock("tconstruct:scorched_brick", "tconstruct:scorched_bricks"),

            //Supplementaries
            ingotBlock("supplementaries:ash_brick", "supplementaries:ash_bricks"),

            //oreganized
            ingotBlock("oreganized:lead_ingot"),
            ingotBlock("oreganized:silver_ingot", "oreganized:silver_block"),
            ingotBlock("oreganized:electrum_ingot"), //seemingly running into the same issue as lead :(

            //createaddition
            ingotBlock("createaddition:electrum_ingot"),

            //born_in_chaos_v1
            ingotBlock("born_in_chaos_v1:dark_metal_ingot", "born_in_chaos_v1:dark_metal_block"),

            //samurai_dynasty
            ingotBlock("samurai_dynasty:silver_ingot", "samurai_dynasty:silver_block"),
            ingotBlock("samurai_dynasty:steel_ingot", "samurai_dynasty:steel_block"), //why does it only have a block for steel and silver :sob:
            ingotBlock("samurai_dynasty:amethyst_ingot"),
            ingotBlock("samurai_dynasty:quartz_ingot"),

            //gobber2
            ingotBlock("gobber2:gobber2_ingot", "gobber2:gobber2_block"),
            ingotBlock("gobber2:gobber2_ingot_nether", "gobber2:gobber2_block_nether"),
            ingotBlock("gobber2:gobber2_ingot_end", "gobber2:gobber2_block_end"),

            //malum
            ingotBlock("malum:hallowed_gold_ingot", "malum:block_of_hallowed_gold"),
            ingotBlock("malum:soul_stained_steel_ingot", "malum:block_of_soul_stained_steel"),
            ingotBlock("malum:malignant_pewter_ingot", "malum:block_of_malignant_pewter"),

            //immersive engineering
            ingotBlock("immersiveengineering:ingot_hop_graphite"),
            ingotBlock("immersiveengineering:ingot_aluminum", "immersiveengineering:storage_aluminum"),
            ingotBlock("immersiveengineering:ingot_lead", "immersiveengineering:storage_lead"),
            ingotBlock("immersiveengineering:ingot_silver", "immersiveengineering:storage_silver"),
            ingotBlock("immersiveengineering:ingot_nickel", "immersiveengineering:storage_nickel"),
            ingotBlock("immersiveengineering:ingot_uranium", "immersiveengineering:storage_uranium"),
            ingotBlock("immersiveengineering:ingot_constantan", "immersiveengineering:storage_constantan"),
            ingotBlock("immersiveengineering:ingot_electrum", "immersiveengineering:storage_electrum"),
            ingotBlock("immersiveengineering:ingot_steel", "immersiveengineering:storage_steel"),

            //scguns
            ingotBlock("scguns:scorched_ingot", "scguns:scorched_block"),
            ingotBlock("scguns:anthralite_ingot", "scguns:anthralite_block"),
            ingotBlock("scguns:treated_iron_ingot", "scguns:treated_iron_block"),
            ingotBlock("scguns:treated_brass_ingot", "scguns:treated_brass_block"),
            ingotBlock("scguns:diamond_steel_ingot", "scguns:diamond_steel_block"),
            ingotBlock("scguns:depleted_diamond_steel_ingot", "scguns:diamond_steel_block"),

            //SH
            ingotBlock("sculkhorde:ferriscite"),

            //cataclysm
            ingotBlock("cataclysm:cursium_ingot", "cataclysm:cursium_block"),
            ingotBlock("cataclysm:ignitium_ingot", "cataclysm:ignitium_block"),
            ingotBlock("cataclysm:black_steel_ingot", "cataclysm:black_steel_block"),
            ingotBlock("cataclysm:ancient_metal_ingot", "cataclysm:ancient_metal_block"),
            ingotBlock("cataclysm:witherite_ingot", "cataclysm:witherite_block"),

            //thermal
            ingotBlock("thermal:tin_ingot", "thermal:tin_block"),
            ingotBlock("thermal:nickel_ingot", "thermal:nickel_block"),
            ingotBlock("thermal:bronze_ingot", "thermal:bronze_block"),
            ingotBlock("thermal:invar_ingot", "thermal:invar_block"),
            ingotBlock("thermal:silver_ingot", "thermal:silver_block"),
            ingotBlock("thermal:lead_ingot", "thermal:lead_block"),
            ingotBlock("thermal:constantan_ingot", "thermal:constantan_block"),
            ingotBlock("thermal:lumium_ingot", "thermal:lumium_block"),
            ingotBlock("thermal:electrum_ingot", "thermal:electrum_block"),
            ingotBlock("thermal:enderium_ingot", "thermal:enderium_block"),
            ingotBlock("thermal:signalum_ingot", "thermal:signalum_block"),

            //thermal integration, technically a seperate mod
            ingotBlock("thermal:steel_ingot", "thermal:steel_block"),
            ingotBlock("thermal:rose_gold_ingot", "thermal:rose_gold_block"),

            //metal works
            ingotBlock("metal_works:tin_ingot", "thermal:tin_block"),
            ingotBlock("metal_works:bronze_ingot", "thermal:bronze_block"),
            ingotBlock("metal_works:rose_gold_ingot", "thermal:rose_gold_block"),

            //ad astra
            ingotBlock("ad_astra:steel_ingot"),
            ingotBlock("ad_astra:etrium_ingot"),
            ingotBlock("ad_astra:desh_ingot"),
            ingotBlock("ad_astra:ostrum_ingot"),
            ingotBlock("ad_astra:calorite_ingot"),

            //mekanism
            ingotBlock("mekanism:ingot_bronze", "mekanism:block_bronze"),
            ingotBlock("mekanism:ingot_refined_obsidian", "mekanism:block_refined_obsidian"),
            ingotBlock("mekanism:ingot_refined_glowstone", "mekanism:block_refined_glowstone"),
            ingotBlock("mekanism:ingot_steel", "mekanism:block_steel"),
            ingotBlock("mekanism:ingot_osmium", "mekanism:block_osmium"),
            ingotBlock("mekanism:ingot_tin", "mekanism:block_tin"),
            ingotBlock("mekanism:ingot_lead", "mekanism:block_lead"),
            ingotBlock("mekanism:ingot_uranium", "mekanism:block_uranium"),

            //extra shiny
            ingotBlock("extrashiny:vanadium_ingot", "extrashiny:vanadium_block"),

            //alex"s caves
            ingotBlock("alexscaves:scarlet_neodymium_ingot", "alexscaves:block_of_scarlet_neodymium"),
            ingotBlock("alexscaves:azure_neodymium_ingot", "alexscaves:block_of_azure_neodymium"),
            ingotBlock("alexscaves:cinder_brick", "alexscaves:cinder_block"),

            //deeper and darker
            ingotBlock("deeperdarker:grime_brick", "deeperdarker:sculk_grime_bricks"),

            //create alloyed
            ingotBlock("alloyed:steel_ingot", "alloyed:steel_block"),
            ingotBlock("alloyed:bronze_ingot", "alloyed:bronze_block"),

            //nourished nether aka netherific
            ingotBlock("nourished_nether:necronium_ingot", "nourished_nether:necronium_block"),
            ingotBlock("nourished_nether:red_nether_brick", "minecraft:red_nether_bricks"),
            ingotBlock("nourished_nether:warped_nether_brick", "nourished_nether:warped_bricks"),
            ingotBlock("nourished_nether:sludge_brick", "nourished_nether:sludge_bricks"),

            //twilight
            ingotBlock("twilightforest:ironwood_ingot", "twilightforest:ironwood_block"),
            ingotBlock("twilightforest:knightmetal_ingot", "twilightforest:knightmetal_block"),
            ingotBlock("twilightforest:fiery_ingot", "twilightforest:fiery_block"),

            //terramity
            ingotBlock("terramity:dimlite_ingot", "terramity:dimlite_block"),
            ingotBlock("terramity:conductite", "terramity:hellspec_alloy_block"),
            ingotBlock("terramity:hellspec_alloy", "terramity:dimlite_block"),
            ingotBlock("terramity:virentium_alloy_ingot", "terramity:virentium_alloy_block"),
            ingotBlock("terramity:cosmilite_ingot", "terramity:cosmilite_block"),
            ingotBlock("terramity:nyxium", "terramity:nyxium_block"),
            ingotBlock("terramity:exodium_superalloy", "terramity:exodium_block"),
            ingotBlock("terramity:reverium", "terramity:reverium_block"),
            ingotBlock("terramity:iridium", "terramity:iridium_block"),
            ingotBlock("terramity:void_alloy", "terramity:void_alloy_block"),
            ingotBlock("terramity:profanum"),

            //more critters
            ingotBlock("more_critters:black_resin_brick", "more_critters:black_resin_bricks"),

            //soulful nether
            ingotBlock("soulfulnether:gloomy_amber_brick", "soulfulnether:gloomy_amber_bricks"),

            //netherlurgy
            ingotBlock("nethelurgy:tungsten_ingot", "nethelurgy:tungsten_block"),
            ingotBlock("nethelurgy:red_nether_brick", "minecraft:red_nether_bricks"),

            //vanilla backport
            ingotBlock("minecraft:resin_brick", "minecraft:resin_bricks"),

            //betterend
            ingotBlock("betterend:aeternium_ingot", "betterend:aeternium_block"),
            ingotBlock("betterend:thallasium_ingot", "betterend:thallasium_block"),
            ingotBlock("betterend:terminite_ingot", "betterend:terminite_block"),

            //betternether
            ingotBlock("betternether:cincinnasite_ingot", "betternether:cincinnasite_forged"),

            //endelurgy
            ingotBlock("endelurgy:adamantite_ingot", "endelurgy:adamantite_block"),
            ingotBlock("endelurgy:enderite_ingot", "endelurgy:enderite_block"),

            //twigs
            ingotBlock("twigs:silt_brick", "twigs:silt_bricks"),

            //tfmg
            ingotBlock("tfmg:steel_ingot", "tfmg:steel_block"),
            ingotBlock("tfmg:cast_iron_ingot", "tfmg:cast_iron_block"),
            ingotBlock("tfmg:aluminum_ingot", "tfmg:aluminum_block"),
            ingotBlock("tfmg:lead_ingot", "tfmg:lead_block"),
            ingotBlock("tfmg:nickel_ingot", "tfmg:nickel_block"),
            ingotBlock("tfmg:constantan_ingot", "tfmg:constantan_block"),
            ingotBlock("tfmg:lithium_ingot", "tfmg:lithium_block"),
            ingotBlock("tfmg:silicon_ingot"),
            ingotBlock("tfmg:magnetic_alloy_ingot"),
            ingotBlock("tfmg:fireproof_brick", "tfmg:fireproof_bricks"),

            //aquaculture
            ingotBlock("aquaculture:neptunium_ingot", "aquaculture:neptunium_block"),

            //undergarten
            ingotBlock("undergarden:cloggrum_ingot", "undergarden:cloggrum_block"),
            ingotBlock("undergarden:froststeel_ingot", "undergarden:froststeel_block"),
            ingotBlock("undergarden:forgotten_ingot", "undergarden:forgotten_block"),

            //dreams and desires
            //it tags andesite alloy as a ingot so, uh, it also gets added ig.
            ingotBlock("create_dd:mithril_ingot","create_dd:mithril_block"),
            ingotBlock("create_dd:bronze_ingot", "create_dd:bronze_block"),
            ingotBlock("create_dd:steel_ingot",  "create_dd:steel_block"),
            ingotBlock("create_dd:tin_ingot","create_dd:tin_block"),
            ingotBlock("create_dd:industrial_iron_ingot", "create_dd:industrial_iron_block"),
            ingotBlock("create_dd:lapis_alloy", "create_dd:lapis_alloy_block"),
            ingotBlock("create_dd:chromatic_compound", "create_dd:chromatic_block"),
            ingotBlock("create_dd:shadow_steel", "create_dd:shadow_steel_block"),
            ingotBlock("create_dd:refined_radiance", "create_dd:refined_radiance_block"),

            //darker depths
            ingotBlock("darkerdepths:forsaken_bronze_ingot", "darkerdepths:forsaken_bronze_block")
    );


    static RegistryObject<Block> ingotBlock(String ingotItem, String ingotBlock) {
        //temp
        //oh god everything sucks now :(
        return HELPER.createPlacedItem(ingotItem.replace(":", "_"), () -> new CompatIngotBlock(modItem(ingotItem), modItem(ingotBlock.contains("brick") ? "minecraft:bricks" : "minecraft:iron_block")));
    }

    static RegistryObject<Block> ingotBlock(String ingotItem) {
        return HELPER.createPlacedItem(ingotItem.replace(":", "_"), () -> new CompatIngotBlock(modItem(ingotItem)));
    }

    static ResourceLocation modItem(String name) {
        return new ResourceLocation(name);
    }
}
