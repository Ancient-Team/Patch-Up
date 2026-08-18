package com.ancient.patchup.datagen;

import com.ancient.patchup.block.another_furniture.*;
import com.ancient.patchup.block.farmers_delight.CanvasSigns;
import com.starfish_studios.another_furniture.registry.AFBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

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

        /* Supplementaries */
        com.ancient.patchup.block.supplementaries.SupplementariesEntries.init();
        var suppFlags = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("supplementaries", "flags")));
        var suppPresents = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("supplementaries", "presents")));
        var suppTrappedPresents = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("supplementaries", "trapped_presents")));
        var suppAwnings = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("supplementaries", "awnings")));
        var suppCandleHolders = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("supplementaries", "candle_holders")));
        var suppBuntings = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("supplementaries", "buntings")));

        for (com.ancient.patchup.block.supplementaries.SupplementariesEntries.Entry entry : com.ancient.patchup.block.supplementaries.SupplementariesEntries.ENTRIES) {
            if (entry.flag() != null) {
                suppFlags.add(entry.flag().get());
                axeMineable.add(entry.flag().get());
            }
            if (entry.present() != null) {
                suppPresents.add(entry.present().get());
                axeMineable.add(entry.present().get());
            }
            if (entry.trappedPresent() != null) {
                suppTrappedPresents.add(entry.trappedPresent().get());
                axeMineable.add(entry.trappedPresent().get());
            }
            if (entry.awning() != null) {
                suppAwnings.add(entry.awning().get());
                axeMineable.add(entry.awning().get());
            }
            if (entry.candleHolder() != null) {
                suppCandleHolders.add(entry.candleHolder().get());
                pickaxeMineable.add(entry.candleHolder().get());
            }
            if (entry.bunting() != null) {
                suppBuntings.add(entry.bunting().get());
                axeMineable.add(entry.bunting().get());
            }
            if (entry.buntingWall() != null) {
                suppBuntings.add(entry.buntingWall().get());
                axeMineable.add(entry.buntingWall().get());
            }
        }

        /* SuppSquared */
        com.ancient.patchup.block.suppsquared.SuppSquaredEntries.init();
        var suppSacks = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("supplementaries", "sacks")));
        var suppGoldCandleHolders = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("suppsquared", "golden_candle_holders")));

        for (com.ancient.patchup.block.suppsquared.SuppSquaredEntries.Entry entry : com.ancient.patchup.block.suppsquared.SuppSquaredEntries.ENTRIES) {
            if (entry.sack() != null) {
                suppSacks.add(entry.sack().get());
                axeMineable.add(entry.sack().get());
            }
            if (entry.goldenCandleHolder() != null) {
                suppGoldCandleHolders.add(entry.goldenCandleHolder().get());
                pickaxeMineable.add(entry.goldenCandleHolder().get());
            }
        }

        /* Amendments */
        com.ancient.patchup.block.amendments.AmendmentsEntries.init();
        var amCeilingBanners = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("amendments", "ceiling_banners")));
        var banners = this.getOrCreateTagBuilder(BlockTags.BANNERS);

        for (com.ancient.patchup.block.amendments.AmendmentsEntries.Entry entry : com.ancient.patchup.block.amendments.AmendmentsEntries.ENTRIES) {
            if (entry.ceilingBanner() != null) {
                amCeilingBanners.add(entry.ceilingBanner().get());
                banners.add(entry.ceilingBanner().get());
                axeMineable.add(entry.ceilingBanner().get());
            }
        }
    }
}