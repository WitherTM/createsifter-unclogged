package com.oierbravo.createsifterunclogged.register;

import com.oierbravo.createsifterunclogged.CreateSifterUnclogged;
import com.oierbravo.createsifterunclogged.content.contraptions.components.sifter.SifterBlockEntity;
import com.oierbravo.createsifterunclogged.content.contraptions.components.sifter.SifterInstance;
import com.oierbravo.createsifterunclogged.content.contraptions.components.sifter.SifterRenderer;
import com.oierbravo.createsifterunclogged.content.contraptions.components.brasss_sifter.BrassSifterBlockEntity;
import com.oierbravo.createsifterunclogged.content.contraptions.components.brasss_sifter.BrassSifterInstance;
import com.oierbravo.createsifterunclogged.content.contraptions.components.brasss_sifter.BrassSifterRenderer;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
public class ModBlockEntities {
    public static final BlockEntityEntry<SifterBlockEntity> SIFTER = CreateSifterUnclogged.registrate()
            .blockEntity("sifter", SifterBlockEntity::new)
            .instance(() -> SifterInstance::new)
            .validBlocks(ModBlocks.SIFTER)
            .renderer(() -> SifterRenderer::new)
            .register();

    public static final BlockEntityEntry<BrassSifterBlockEntity> BRASS_SIFTER = CreateSifterUnclogged.registrate()
            .blockEntity("brass_sifter", BrassSifterBlockEntity::new)
            .instance(() -> BrassSifterInstance::new)
            .validBlocks(ModBlocks.BRASS_SIFTER)
            .renderer(() -> BrassSifterRenderer::new)
            .register();
    public static void register() {}
}