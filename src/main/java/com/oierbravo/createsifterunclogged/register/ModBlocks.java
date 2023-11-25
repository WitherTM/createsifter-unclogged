package com.oierbravo.createsifterunclogged.register;

import com.oierbravo.createsifterunclogged.content.contraptions.components.brasss_sifter.BrassSifterBlock;
import com.oierbravo.createsifterunclogged.content.contraptions.components.brasss_sifter.BrassSifterConfig;
import com.oierbravo.createsifterunclogged.content.contraptions.components.sifter.SifterBlock;
import com.oierbravo.createsifterunclogged.content.contraptions.components.sifter.SifterConfig;
import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MapColor;

import static com.oierbravo.createsifterunclogged.CreateSifterUnclogged.REGISTRATE;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

public class ModBlocks {


    static { REGISTRATE.setCreativeTab(ModCreativeTabs.MAIN_TAB); }


    public static void register() {

    }
    public static final BlockEntry<SifterBlock> SIFTER = REGISTRATE.block("sifter", SifterBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.mapColor(MapColor.METAL))
            .transform(pickaxeOnly())
            .blockstate((c, p) -> p.simpleBlock(c.getEntry(), AssetLookup.partialBaseModel(c, p)))
            .transform(BlockStressDefaults.setImpact(SifterConfig.SIFTER_STRESS_IMPACT.get()))
            .item()
            .transform(customItemModel())
            .register();
    public static final BlockEntry<BrassSifterBlock> BRASS_SIFTER = REGISTRATE.block("brass_sifter", BrassSifterBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.mapColor(MapColor.METAL))
            .properties(p -> p.noOcclusion())
            .properties(p -> p.isRedstoneConductor((level, pos, state) -> false))
            .transform(pickaxeOnly())
            .blockstate((c, p) -> BlockStateGen.simpleBlock(c, p, AssetLookup.forPowered(c, p)))
            .transform(BlockStressDefaults.setImpact(BrassSifterConfig.BRASS_SIFTER_MINIMUM_SPEED.get()))
            .item()
            .transform(customItemModel())
            .register();


    public static final BlockEntry<Block> DUST = REGISTRATE.block("dust", Block::new)
            .initialProperties(() ->Blocks.SAND)
            .lang("Dust block")
            .properties(p -> p.mapColor(MapColor.SAND))
            .tag(BlockTags.MINEABLE_WITH_SHOVEL)
            .simpleItem()
            .register();

    public static final BlockEntry<Block> CRUSHED_END_STONE = REGISTRATE.block("crushed_end_stone", Block::new)
            .lang("Crushed end stone")
            .initialProperties(() ->Blocks.SAND)
            .properties(p -> p.mapColor(MapColor.SAND))
            .tag(BlockTags.MINEABLE_WITH_SHOVEL)
            .simpleItem()
            .register();
}
