package com.ancient.patchup.datagen;

import com.ancient.patchup.block.another_furniture.*;
import com.ninni.dye_depot.registry.DDDyes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        /* Stool */
        for (Supplier<Block> stool : Stool.STOOLS.values()) {
            addDrop(stool.get());
        }

        /* Tall Stool */
        for (Supplier<Block> tallStool : TallStool.TALL_STOOLS.values()) {
            addDrop(tallStool.get());
        }

        /* Sofa */
        for (Supplier<Block> sofa : Sofa.SOFAS.values()) {
            addDrop(sofa.get());
        }

        /* Lamp & Lamp Connector */
        for (DDDyes dye : DDDyes.values()) {
            Block lamp = Lamp.LAMPS.get(dye).get();
            Block connector = Lamp.LAMP_CONNECTORS.get(dye).get();
            addDrop(lamp);
            addDrop(connector, lamp.asItem());
        }

        /* Curtain */
        for (Supplier<Block> curtain : Curtain.CURTAINS.values()) {
            addDrop(curtain.get());
        }

        /* Farmer's Delight Canvas Signs */
        com.ancient.patchup.block.farmers_delight.CanvasSigns.init();
        for (com.ancient.patchup.block.farmers_delight.CanvasSigns.CanvasSignEntry entry : com.ancient.patchup.block.farmers_delight.CanvasSigns.ENTRIES) {
            addDrop(entry.standingSign(), entry.signItem());
            addDrop(entry.wallSign(), entry.signItem());
            addDrop(entry.ceilingHangingSign(), entry.hangingSignItem());
            addDrop(entry.wallHangingSign(), entry.hangingSignItem());
        }

        /* Comforts */
        com.ancient.patchup.block.comforts.ComfortsItems.init();
        for (com.ancient.patchup.block.comforts.ComfortsItems.ComfortsEntry entry : com.ancient.patchup.block.comforts.ComfortsItems.ENTRIES) {
            addDrop(entry.hammockBlock().get(), dropsWithProperty(entry.hammockBlock().get(), net.minecraft.block.BedBlock.PART, net.minecraft.block.enums.BedPart.HEAD));
            addDrop(entry.sleepingBagBlock().get(), dropsWithProperty(entry.sleepingBagBlock().get(), net.minecraft.block.BedBlock.PART, net.minecraft.block.enums.BedPart.HEAD));
        }

        /* Arts & Crafts */
        com.ancient.patchup.block.arts_and_crafts.ArtsAndCraftsEntries.init();
        for (com.ancient.patchup.block.arts_and_crafts.ArtsAndCraftsEntries.Entry entry : com.ancient.patchup.block.arts_and_crafts.ArtsAndCraftsEntries.ENTRIES) {
            addDrop(entry.chalk());
            addDrop(entry.plaster());
            addDrop(entry.flowerPot(), entry.flowerPotItem());
            addDrop(entry.decoratedPot(), entry.decoratedPotItem());
            addDrop(entry.mudBricks());
            addDrop(entry.mudBrickSlab(), slabDrops(entry.mudBrickSlab()));
            addDrop(entry.mudBrickStairs());
            addDrop(entry.mudBrickWall());
            addDrop(entry.terracottaShingles());
            addDrop(entry.terracottaShingleSlab(), slabDrops(entry.terracottaShingleSlab()));
            addDrop(entry.terracottaShingleStairs());
            addDrop(entry.terracottaShingleWall());
            addDrop(entry.soapstone());
            addDrop(entry.soapstoneSlab(), slabDrops(entry.soapstoneSlab()));
            addDrop(entry.soapstoneStairs());
            addDrop(entry.soapstoneWall());
            addDrop(entry.polishedSoapstone());
            addDrop(entry.polishedSoapstoneSlab(), slabDrops(entry.polishedSoapstoneSlab()));
            addDrop(entry.polishedSoapstoneStairs());
            addDrop(entry.polishedSoapstoneWall());
            addDrop(entry.soapstoneBricks());
            addDrop(entry.soapstoneBrickSlab(), slabDrops(entry.soapstoneBrickSlab()));
            addDrop(entry.soapstoneBrickStairs());
            addDrop(entry.soapstoneBrickWall());
        }
    }
}