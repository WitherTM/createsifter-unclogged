package com.oierbravo.createsifterunclogged;

import com.oierbravo.createsifterunclogged.foundation.data.recipe.ModProcessingRecipeGen;
import com.oierbravo.createsifterunclogged.register.*;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CreateSifterUnclogged.MODID)
public class CreateSifterUnclogged {
    public static final String MODID = "createsifter_unclogged";
    public static final String DISPLAY_NAME = "Create: Sifter - Unclogged";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger(MODID);
    public static IEventBus modEventBus;

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MODID);

    public CreateSifterUnclogged() {
        modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        REGISTRATE.registerEventListeners(modEventBus);

        ModConfigs.register();

        ModBlocks.register();
        ModItems.register();
        ModBlockEntities.register();
        ModCreativeTabs.register(modEventBus);
        ModRecipeTypes.register(modEventBus);
        modEventBus.addListener(this::doClientStuff);

        generateLangEntries();

        modEventBus.addListener(EventPriority.LOWEST, CreateSifterUnclogged::gatherData);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT,
                () -> ModPartials::init);
    }
    private void generateLangEntries(){

        registrate().addRawLang("createsifter.recipe.sifting", "Sifting recipe");
        registrate().addRawLang("create.recipe.sifting", "Sifting recipe");
        registrate().addRawLang("create.createsifter.recipe.sifting.minimumspeed", "%1$s RPM");
        registrate().addRawLang("createsifter.recipe.sifting.waterlogged", "Waterlogged");
        registrate().addRawLang("createsifter.recipe.sifting.brass_required", "Brass sifter required");
        registrate().addRawLang("itemGroup.createsifter:main", "Create sifting");
        //Ponder
        registrate().addRawLang("createsifter.ponder.sifter.header", "Block sifting");
        registrate().addRawLang("createsifter.ponder.sifter.text_1", "Sifter process items by sifting them");
        registrate().addRawLang("createsifter.ponder.sifter.text_2", "They can be powered from the side using cogwheels");
        registrate().addRawLang("createsifter.ponder.sifter.text_3", "Throw or Insert items at the top");
        registrate().addRawLang("createsifter.ponder.sifter.text_4", "After some time, the result can be obtained via Right-click");
        registrate().addRawLang("createsifter.ponder.sifter.text_5", "The outputs can also be extracted by automation");

        registrate().addRawLang("createsifter.recipe.sifting.brass_required", "Brass sifter required");

    }
    public static CreateRegistrate registrate() {
        return REGISTRATE;
    }

    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        if (event.includeClient()) {

        }
        if (event.includeServer()) {
            ModProcessingRecipeGen.registerAll(gen,output);
        }

    }
    private void doClientStuff(final FMLClientSetupEvent event) {
       event.enqueueWork(ModPonders::register);
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MODID, path);
    }

}
