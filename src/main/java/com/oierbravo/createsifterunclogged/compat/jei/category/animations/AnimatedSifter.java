package com.oierbravo.createsifterunclogged.compat.jei.category.animations;

import com.jozufozu.flywheel.core.PartialModel;
import com.oierbravo.createsifterunclogged.content.contraptions.components.sifter.SifterBlock;
import com.oierbravo.createsifterunclogged.register.ModBlocks;
import com.oierbravo.createsifterunclogged.register.ModPartials;
import com.tterrag.registrate.util.entry.BlockEntry;

public class AnimatedSifter  extends BaseAnimatedSifter<SifterBlock> {
    @Override
    PartialModel getMeshModel() {
        return ModPartials.SIFTER_MESH;
    }

    @Override
    PartialModel getCogModel() {
        return ModPartials.SIFTER_COG;
    }

    @Override
    BlockEntry<SifterBlock> getSifterBlock() {
        return ModBlocks.SIFTER;
    }
}
