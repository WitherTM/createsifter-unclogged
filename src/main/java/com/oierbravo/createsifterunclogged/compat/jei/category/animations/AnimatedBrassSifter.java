package com.oierbravo.createsifterunclogged.compat.jei.category.animations;

import com.jozufozu.flywheel.core.PartialModel;
import com.oierbravo.createsifterunclogged.content.contraptions.components.brasss_sifter.BrassSifterBlock;
import com.oierbravo.createsifterunclogged.register.ModBlocks;
import com.oierbravo.createsifterunclogged.register.ModPartials;
import com.tterrag.registrate.util.entry.BlockEntry;

public class AnimatedBrassSifter extends BaseAnimatedSifter<BrassSifterBlock> {

    @Override
    PartialModel getMeshModel() {
        return ModPartials.BRASS_SIFTER_MESH;
    }

    @Override
    PartialModel getCogModel() {
        return ModPartials.BRASS_SIFTER_COG;
    }

    @Override
    BlockEntry<BrassSifterBlock> getSifterBlock() {
        return ModBlocks.BRASS_SIFTER;
    }
}
