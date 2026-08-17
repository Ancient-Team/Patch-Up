package com.ancient.patchup.datagen;

import com.ancient.patchup.block.another_furniture.*;
import com.ancient.patchup.block.farmers_delight.CanvasSigns;
import com.starfish_studios.another_furniture.registry.AFBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        /* Another Furniture */
        var axeMineable = this.getOrCreateTagBuilder(BlockTags.AXE_MINEABLE);
        var stools = this.getOrCreateTagBuilder(AFBlockTags.STOOLS);
        var tallStools = this.getOrCreateTagBuilder(AFBlockTags.TALL_STOOLS);
        var sofas = this.getOrCreateTagBuilder(AFBlockTags.SOFAS);
        var lamps = this.getOrCreateTagBuilder(AFBlockTags.LAMPS);
        var curtains = this.getOrCreateTagBuilder(AFBlockTags.CURTAINS);

        for (Supplier<Block> stool : Stool.STOOLS.values()) {
            stools.add(stool.get());
            axeMineable.add(stool.get());
        }

        for (Supplier<Block> tallStool : TallStool.TALL_STOOLS.values()) {
            tallStools.add(tallStool.get());
            axeMineable.add(tallStool.get());
        }

        for (Supplier<Block> sofa : Sofa.SOFAS.values()) {
            sofas.add(sofa.get());
            axeMineable.add(sofa.get());
        }

        for (Supplier<Block> lamp : Lamp.LAMPS.values()) {
            lamps.add(lamp.get());
            axeMineable.add(lamp.get());
        }

        for (Supplier<Block> curtain : Curtain.CURTAINS.values()) {
            curtains.add(curtain.get());
        }

        /* Farmer's Delight Canvas Signs */
        CanvasSigns.init();
        var standingSigns = this.getOrCreateTagBuilder(BlockTags.STANDING_SIGNS);
        var wallSigns = this.getOrCreateTagBuilder(BlockTags.WALL_SIGNS);
        var ceilingHangingSigns = this.getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS);
        var wallHangingSigns = this.getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS);

        for (CanvasSigns.CanvasSignEntry entry : CanvasSigns.ENTRIES) {
            standingSigns.add(entry.standingSign());
            wallSigns.add(entry.wallSign());
            ceilingHangingSigns.add(entry.ceilingHangingSign());
            wallHangingSigns.add(entry.wallHangingSign());
            axeMineable.add(entry.standingSign(), entry.wallSign(), entry.ceilingHangingSign(), entry.wallHangingSign());
        }

        /* Comforts */
        com.ancient.patchup.block.comforts.ComfortsItems.init();
        for (com.ancient.patchup.block.comforts.ComfortsItems.ComfortsEntry entry : com.ancient.patchup.block.comforts.ComfortsItems.ENTRIES) {
            axeMineable.add(entry.hammockBlock().get(), entry.sleepingBagBlock().get());
        }

        /* Arts & Crafts */
        com.ancient.patchup.block.arts_and_crafts.ArtsAndCraftsEntries.init();
        var pickaxeMineable = this.getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE);
        var slabs = this.getOrCreateTagBuilder(BlockTags.SLABS);
        var stairs = this.getOrCreateTagBuilder(BlockTags.STAIRS);
        var walls = this.getOrCreateTagBuilder(BlockTags.WALLS);
        var flowerPots = this.getOrCreateTagBuilder(BlockTags.FLOWER_POTS);
        var chalkDustTag = this.getOrCreateTagBuilder(com.kekecreations.arts_and_crafts.core.init.ACTags.BlockTags.CHALK_DUST);

        for (com.ancient.patchup.block.arts_and_crafts.ArtsAndCraftsEntries.Entry entry : com.ancient.patchup.block.arts_and_crafts.ArtsAndCraftsEntries.ENTRIES) {
            pickaxeMineable.add(
                    entry.chalk(), entry.plaster(), entry.flowerPot(), entry.decoratedPot(),
                    entry.mudBricks(), entry.mudBrickSlab(), entry.mudBrickStairs(), entry.mudBrickWall(),
                    entry.terracottaShingles(), entry.terracottaShingleSlab(), entry.terracottaShingleStairs(), entry.terracottaShingleWall(),
                    entry.soapstone(), entry.soapstoneSlab(), entry.soapstoneStairs(), entry.soapstoneWall(),
                    entry.polishedSoapstone(), entry.polishedSoapstoneSlab(), entry.polishedSoapstoneStairs(), entry.polishedSoapstoneWall(),
                    entry.soapstoneBricks(), entry.soapstoneBrickSlab(), entry.soapstoneBrickStairs(), entry.soapstoneBrickWall()
            );

            slabs.add(entry.mudBrickSlab(), entry.terracottaShingleSlab(), entry.soapstoneSlab(), entry.polishedSoapstoneSlab(), entry.soapstoneBrickSlab());
            stairs.add(entry.mudBrickStairs(), entry.terracottaShingleStairs(), entry.soapstoneStairs(), entry.polishedSoapstoneStairs(), entry.soapstoneBrickStairs());
            walls.add(entry.mudBrickWall(), entry.terracottaShingleWall(), entry.soapstoneWall(), entry.polishedSoapstoneWall(), entry.soapstoneBrickWall());
            flowerPots.add(entry.flowerPot());
            chalkDustTag.add(entry.chalkDust());
        }
    }
}