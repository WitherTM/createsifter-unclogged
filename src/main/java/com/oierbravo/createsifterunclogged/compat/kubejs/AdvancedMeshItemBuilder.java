package com.oierbravo.createsifterunclogged.compat.kubejs;

import com.oierbravo.createsifterunclogged.CreateSifterUnclogged;
import com.oierbravo.createsifterunclogged.content.contraptions.components.meshes.CustomMesh;
import com.oierbravo.createsifterunclogged.register.ModCreativeTabs;
import com.simibubi.create.foundation.data.CreateRegistrate;
import dev.latvian.mods.kubejs.item.ItemBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class AdvancedMeshItemBuilder extends ItemBuilder {
    private static final CreateRegistrate REGISTRATE = CreateSifterUnclogged.registrate()
            .setCreativeTab(ModCreativeTabs.MAIN_TAB);

    private ResourceLocation resourceLocation;
    public AdvancedMeshItemBuilder(ResourceLocation resourceLocation) {
        super(resourceLocation);
        this.resourceLocation = resourceLocation;
    }

    @Override
    public Item createObject() {
        return new CustomMesh(createItemProperties()) ;
    }
}
