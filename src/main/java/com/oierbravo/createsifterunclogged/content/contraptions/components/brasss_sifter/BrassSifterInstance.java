package com.oierbravo.createsifterunclogged.content.contraptions.components.brasss_sifter;

import com.jozufozu.flywheel.api.Instancer;
import com.jozufozu.flywheel.api.MaterialManager;
import com.oierbravo.createsifterunclogged.register.ModPartials;
import com.simibubi.create.content.kinetics.base.flwdata.RotatingData;
import com.simibubi.create.content.kinetics.base.SingleRotatingInstance;

public class BrassSifterInstance extends SingleRotatingInstance<BrassSifterBlockEntity> {
    public BrassSifterInstance(MaterialManager materialManager, BrassSifterBlockEntity blockEntity) {
        super(materialManager, blockEntity);
    }

    @Override
    protected Instancer<RotatingData> getModel() {
        return getRotatingMaterial().getModel(ModPartials.BRASS_SIFTER_COG, blockEntity.getBlockState());
    }
}
