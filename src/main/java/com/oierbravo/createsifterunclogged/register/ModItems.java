package com.oierbravo.createsifterunclogged.register;

import com.oierbravo.createsifterunclogged.content.contraptions.components.meshes.*;
import com.simibubi.create.foundation.data.AssetLookup;
import com.tterrag.registrate.util.entry.ItemEntry;

import static com.oierbravo.createsifterunclogged.CreateSifterUnclogged.REGISTRATE;

public class ModItems {
    static { REGISTRATE.setCreativeTab(ModCreativeTabs.MAIN_TAB); }
    public static void register() {}
    public static final ItemEntry<StringMesh> STRING_MESH =
            REGISTRATE.item("string_mesh", StringMesh::new)
                    .model(AssetLookup.existingItemModel())
                    .tag(ModTags.ModItemTags.MESHES.tag)
                    .register();
    public static final ItemEntry<AndesiteMesh> ANDESITE_MESH =
            REGISTRATE.item("andesite_mesh", AndesiteMesh::new)
                    .model(AssetLookup.existingItemModel())
                    .tag(ModTags.ModItemTags.MESHES.tag)
                    .register();
    public static final ItemEntry<ZincMesh> ZINC_MESH =
            REGISTRATE.item("zinc_mesh", ZincMesh::new)
                    .model(AssetLookup.existingItemModel())
                    .tag(ModTags.ModItemTags.MESHES.tag)
                    .register();
    public static final ItemEntry<BrassMesh> BRASS_MESH =
            REGISTRATE.item("brass_mesh", BrassMesh::new)
                    .model(AssetLookup.existingItemModel())
                    .tag(ModTags.ModItemTags.MESHES.tag)
                    .register();
    public static final ItemEntry<CustomMesh> CUSTOM_MESH =
            REGISTRATE.item("custom_mesh", CustomMesh::new)
                    .model(AssetLookup.existingItemModel())
                    .tag(ModTags.ModItemTags.MESHES.tag)
                    .register();

    public static final ItemEntry<AdvancedBrassMesh> ADVANCED_BRASS_MESH =
            REGISTRATE.item("advanced_brass_mesh", AdvancedBrassMesh::new)
                    .model(AssetLookup.existingItemModel())
                    .tag(ModTags.ModItemTags.MESHES.tag)
                    .register();

    public static final ItemEntry<AdvancedBrassMesh> ADVANCED_CUSTOM_MESH =
            REGISTRATE.item("advanced_custom_mesh", AdvancedBrassMesh::new)
                    .model(AssetLookup.existingItemModel())
                    .tag(ModTags.ModItemTags.MESHES.tag)
                    .register();

}
