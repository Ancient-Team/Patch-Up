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

        /* Creative Tabs */
        translationBuilder.add("itemgroup.patchup.another_furniture", "Patch Up: Another Furniture");
        translationBuilder.add("itemgroup.patchup.farmers_delight", "Patch Up: Farmer's Delight");
        translationBuilder.add("itemgroup.patchup.comforts", "Patch Up: Comforts");
        translationBuilder.add("itemgroup.patchup.arts_and_crafts", "Patch Up: Arts & Crafts");
        translationBuilder.add("itemgroup.patchup.supplementaries", "Patch Up: Supplementaries");
        translationBuilder.add("itemgroup.patchup.suppsquared", "Patch Up: Supplementaries Squared");
        translationBuilder.add("itemgroup.patchup.amendments", "Patch Up: Amendments");

        /* Farmer's Delight Canvas Signs */
        CanvasSigns.init();
        for (CanvasSigns.CanvasSignEntry entry : CanvasSigns.ENTRIES) {
            String color = formatColorName(entry.dye().asString());
            translationBuilder.add(entry.standingSign(), color + " Canvas Sign");
            translationBuilder.add(entry.ceilingHangingSign(), color + " Hanging Canvas Sign");
        }

        /* Arts & Crafts */
        com.ancient.patchup.block.arts_and_crafts.ArtsAndCraftsEntries.init();
        for (com.ancient.patchup.block.arts_and_crafts.ArtsAndCraftsEntries.Entry entry : com.ancient.patchup.block.arts_and_crafts.ArtsAndCraftsEntries.ENTRIES) {
            String color = formatColorName(entry.dye().asString());
            translationBuilder.add(entry.chalk(), color + " Chalk");
            translationBuilder.add(entry.chalkDust(), color + " Chalk Dust");
            translationBuilder.add(entry.chalkStick(), color + " Chalk Stick");
            translationBuilder.add(entry.paintbrush(), color + " Paintbrush");
            translationBuilder.add(entry.plaster(), color + " Plaster");
            translationBuilder.add(entry.flowerPot(), color + " Flower Pot");
            translationBuilder.add(entry.decoratedPot(), color + " Decorated Pot");
            translationBuilder.add(entry.mudBricks(), color + " Mud Bricks");
            translationBuilder.add(entry.mudBrickSlab(), color + " Mud Brick Slab");
            translationBuilder.add(entry.mudBrickStairs(), color + " Mud Brick Stairs");
            translationBuilder.add(entry.mudBrickWall(), color + " Mud Brick Wall");
            translationBuilder.add(entry.terracottaShingles(), color + " Terracotta Shingles");
            translationBuilder.add(entry.terracottaShingleSlab(), color + " Terracotta Shingle Slab");
            translationBuilder.add(entry.terracottaShingleStairs(), color + " Terracotta Shingle Stairs");
            translationBuilder.add(entry.terracottaShingleWall(), color + " Terracotta Shingle Wall");
            translationBuilder.add(entry.soapstone(), color + " Soapstone");
            translationBuilder.add(entry.soapstoneSlab(), color + " Soapstone Slab");
            translationBuilder.add(entry.soapstoneStairs(), color + " Soapstone Stairs");
            translationBuilder.add(entry.soapstoneWall(), color + " Soapstone Wall");
            translationBuilder.add(entry.polishedSoapstone(), color + " Polished Soapstone");
            translationBuilder.add(entry.polishedSoapstoneSlab(), color + " Polished Soapstone Slab");
            translationBuilder.add(entry.polishedSoapstoneStairs(), color + " Polished Soapstone Stairs");
            translationBuilder.add(entry.polishedSoapstoneWall(), color + " Polished Soapstone Wall");
            translationBuilder.add(entry.soapstoneBricks(), color + " Soapstone Bricks");
            translationBuilder.add(entry.soapstoneBrickSlab(), color + " Soapstone Brick Slab");
            translationBuilder.add(entry.soapstoneBrickStairs(), color + " Soapstone Brick Stairs");
            translationBuilder.add(entry.soapstoneBrickWall(), color + " Soapstone Brick Wall");
        }

        /* Supplementaries */
        com.ancient.patchup.block.supplementaries.SupplementariesEntries.init();
        for (com.ancient.patchup.block.supplementaries.SupplementariesEntries.Entry entry : com.ancient.patchup.block.supplementaries.SupplementariesEntries.ENTRIES) {
            String color = formatColorName(entry.dye().asString());
            if (entry.flag() != null) translationBuilder.add(entry.flag().get(), color + " Flag");
            if (entry.present() != null) translationBuilder.add(entry.present().get(), color + " Present");
            if (entry.trappedPresent() != null) translationBuilder.add(entry.trappedPresent().get(), color + " Trapped Present");
            if (entry.awning() != null) translationBuilder.add(entry.awning().get(), color + " Awning");
            if (entry.candleHolder() != null) translationBuilder.add(entry.candleHolder().get(), color + " Candle Holder");
            if (entry.bunting() != null) translationBuilder.add(entry.bunting().get(), color + " Bunting");
        }

        /* SuppSquared */
        com.ancient.patchup.block.suppsquared.SuppSquaredEntries.init();
        for (com.ancient.patchup.block.suppsquared.SuppSquaredEntries.Entry entry : com.ancient.patchup.block.suppsquared.SuppSquaredEntries.ENTRIES) {
            String color = formatColorName(entry.dye().asString());
            if (entry.sack() != null) translationBuilder.add(entry.sack().get(), color + " Sack");
            if (entry.goldenCandleHolder() != null) translationBuilder.add(entry.goldenCandleHolder().get(), color + " Gold Candle Holder");
        }

        /* Amendments */
        com.ancient.patchup.block.amendments.AmendmentsEntries.init();
        for (com.ancient.patchup.block.amendments.AmendmentsEntries.Entry entry : com.ancient.patchup.block.amendments.AmendmentsEntries.ENTRIES) {
            String color = formatColorName(entry.dye().asString());
            if (entry.ceilingBanner() != null) translationBuilder.add(entry.ceilingBanner().get(), color + " Ceiling Banner");
        }
    }
}
