package com.ancient.patchup.datagen;

import com.ancient.patchup.block.another_furniture.*;
import com.ancient.patchup.block.farmers_delight.CanvasSigns;
import com.ninni.dye_depot.registry.DDDyes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class EnglishLangProvider extends FabricLanguageProvider {
    public EnglishLangProvider(FabricDataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataGenerator, "en_us", registryLookup);
    }

    private static String formatColorName(String name) {
        if (name == null || name.isEmpty()) return "";
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {

        /* Another Furniture */
        for (DDDyes dye : DDDyes.values()) {
            String color = formatColorName(dye.asString());
            translationBuilder.add("block.another_furniture." + dye.asString() + "_stool", color + " Stool");
            translationBuilder.add("block.another_furniture." + dye.asString() + "_tall_stool", color + " Tall Stool");
            translationBuilder.add("block.another_furniture." + dye.asString() + "_sofa", color + " Sofa");
            translationBuilder.add("block.another_furniture." + dye.asString() + "_lamp", color + " Lamp");
            translationBuilder.add("block.another_furniture." + dye.asString() + "_curtain", color + " Curtain");
        }

        /* Other */
        translationBuilder.add("itemgroup.patchup_group", "Patch Up");

        /* Farmer's Delight Canvas Signs */
        CanvasSigns.init();
        for (CanvasSigns.CanvasSignEntry entry : CanvasSigns.ENTRIES) {
            String color = formatColorName(entry.dye().asString());
            translationBuilder.add(entry.standingSign(), color + " Canvas Sign");
            translationBuilder.add(entry.ceilingHangingSign(), color + " Hanging Canvas Sign");
        }
    }
}
