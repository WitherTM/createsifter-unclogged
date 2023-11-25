package com.oierbravo.createsifterunclogged.foundation.data.recipe;


import com.oierbravo.createsifterunclogged.CreateSifterUnclogged;
import com.oierbravo.createsifterunclogged.ModRecipeTypes;
import com.oierbravo.createsifterunclogged.content.contraptions.components.sifter.SiftingRecipeSerializer;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import com.simibubi.create.foundation.utility.RegisteredObjects;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public abstract class ModProcessingRecipeGen extends CreateRecipeProvider {
    protected static final List<ModProcessingRecipeGen> GENERATORS = new ArrayList<>();
    public ModProcessingRecipeGen(PackOutput generator) {
        super(generator);
    }
    public static void registerAll(DataGenerator gen, PackOutput output) {
        GENERATORS.add(new SiftingRecipeGen(output));

        gen.addProvider(true, new DataProvider() {

            @Override
            public @NotNull String getName() {
                return "Create Sifter's Processing Recipes";
            }

            @Override
            public CompletableFuture<?> run(CachedOutput dc) {
                return CompletableFuture.allOf(GENERATORS.stream()
                        .map(gen -> gen.run(dc))
                        .toArray(CompletableFuture[]::new));
            }
        });
    }
    protected GeneratedRecipe create(String namespace,
                                                                     Supplier<ItemLike> singleIngredient, UnaryOperator<SiftingRecipeBuilder> transform) {
        SiftingRecipeSerializer serializer = getSerializer();
        GeneratedRecipe generatedRecipe = c -> {
            ItemLike itemLike = singleIngredient.get();
            transform
                    .apply(new SiftingRecipeBuilder(serializer.getFactory(),
                            new ResourceLocation(namespace, RegisteredObjects.getKeyOrThrow(itemLike.asItem())
                                    .getPath())).withItemIngredients(Ingredient.of(itemLike)))
                    .build(c);
        };
        all.add(generatedRecipe);
        return generatedRecipe;
    }

    /**
     * Create a processing recipe with a single itemstack ingredient, using its id
     * as the name of the recipe
     */
     GeneratedRecipe create(Supplier<ItemLike> singleIngredient,
                                                           UnaryOperator<SiftingRecipeBuilder> transform) {
        return create(CreateSifterUnclogged.MODID, singleIngredient, transform);
    }

    protected GeneratedRecipe createWithDeferredId(Supplier<ResourceLocation> name,
                                                                                   UnaryOperator<SiftingRecipeBuilder> transform) {
        SiftingRecipeSerializer serializer = getSerializer();
        GeneratedRecipe generatedRecipe =
                c -> transform.apply(new SiftingRecipeBuilder(serializer.getFactory(), name.get()))
                        .build(c);
        all.add(generatedRecipe);
        return generatedRecipe;
    }

    /**
     * Create a new processing recipe, with recipe definitions provided by the
     * function
     */
    protected GeneratedRecipe create(ResourceLocation name,
                                                                     UnaryOperator<SiftingRecipeBuilder> transform) {
        return createWithDeferredId(() -> name, transform);
    }

    /**
     * Create a new processing recipe, with recipe definitions provided by the
     * function
     */
    GeneratedRecipe create(String name,
                                                           UnaryOperator<SiftingRecipeBuilder> transform) {
        return create(CreateSifterUnclogged.asResource(name), transform);
    }

    protected IRecipeTypeInfo getRecipeType() {
        return ModRecipeTypes.SIFTING.getType();
    };

    protected SiftingRecipeSerializer getSerializer() {
        return getRecipeType().getSerializer();
    }

    protected Supplier<ResourceLocation> idWithSuffix(Supplier<ItemLike> item, String suffix) {
        return () -> {
            ResourceLocation registryName = RegisteredObjects.getKeyOrThrow(item.get()
                    .asItem());
            return CreateSifterUnclogged.asResource(registryName.getPath() + suffix);
        };
    }
}