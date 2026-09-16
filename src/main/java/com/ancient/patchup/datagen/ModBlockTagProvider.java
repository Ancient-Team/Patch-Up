package com.ancient.patchup.datagen;

import com.ancient.patchup.block.another_furniture.*;
import com.ancient.patchup.block.farmers_delight.CanvasSigns;
import com.starfish_studios.another_furniture.registry.AFBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import com.ninni.dye_depot.registry.DDDyes;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private void addOptional(FabricTagBuilder builder, Block... blocks) {
        for (Block block : blocks) {
            if (block != null && block != net.minecraft.block.Blocks.AIR) {
                builder.addOptional(Registries.BLOCK.getId(block));
            }
        }
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
            addOptional(stools, stool.get());
            addOptional(axeMineable, stool.get());
        }

        for (Supplier<Block> tallStool : TallStool.TALL_STOOLS.values()) {
            addOptional(tallStools, tallStool.get());
            addOptional(axeMineable, tallStool.get());
        }

        for (Supplier<Block> sofa : Sofa.SOFAS.values()) {
            addOptional(sofas, sofa.get());
            addOptional(axeMineable, sofa.get());
        }

        for (Supplier<Block> lamp : Lamp.LAMPS.values()) {
            addOptional(lamps, lamp.get());
            addOptional(axeMineable, lamp.get());
        }

        for (Supplier<Block> curtain : Curtain.CURTAINS.values()) {
            addOptional(curtains, curtain.get());
        }

        /* Farmer's Delight Canvas Signs */
        CanvasSigns.init();
        var standingSigns = this.getOrCreateTagBuilder(BlockTags.STANDING_SIGNS);
        var wallSigns = this.getOrCreateTagBuilder(BlockTags.WALL_SIGNS);
        var ceilingHangingSigns = this.getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS);
        var wallHangingSigns = this.getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS);

        for (CanvasSigns.CanvasSignEntry entry : CanvasSigns.ENTRIES) {
            addOptional(standingSigns, entry.standingSign());
            addOptional(wallSigns, entry.wallSign());
            addOptional(ceilingHangingSigns, entry.ceilingHangingSign());
            addOptional(wallHangingSigns, entry.wallHangingSign());
            addOptional(axeMineable, entry.standingSign(), entry.wallSign(), entry.ceilingHangingSign(), entry.wallHangingSign());
        }

        /* Comforts */
        com.ancient.patchup.block.comforts.ComfortsItems.init();
        for (com.ancient.patchup.block.comforts.ComfortsItems.ComfortsEntry entry : com.ancient.patchup.block.comforts.ComfortsItems.ENTRIES) {
            addOptional(axeMineable, entry.hammockBlock().get(), entry.sleepingBagBlock().get());
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
            addOptional(pickaxeMineable,
                    entry.chalk(), entry.plaster(), entry.flowerPot(), entry.decoratedPot(),
                    entry.mudBricks(), entry.mudBrickSlab(), entry.mudBrickStairs(), entry.mudBrickWall(),
                    entry.terracottaShingles(), entry.terracottaShingleSlab(), entry.terracottaShingleStairs(), entry.terracottaShingleWall(),
                    entry.soapstone(), entry.soapstoneSlab(), entry.soapstoneStairs(), entry.soapstoneWall(),
                    entry.polishedSoapstone(), entry.polishedSoapstoneSlab(), entry.polishedSoapstoneStairs(), entry.polishedSoapstoneWall(),
                    entry.soapstoneBricks(), entry.soapstoneBrickSlab(), entry.soapstoneBrickStairs(), entry.soapstoneBrickWall()
            );

            addOptional(slabs, entry.mudBrickSlab(), entry.terracottaShingleSlab(), entry.soapstoneSlab(), entry.polishedSoapstoneSlab(), entry.soapstoneBrickSlab());
            addOptional(stairs, entry.mudBrickStairs(), entry.terracottaShingleStairs(), entry.soapstoneStairs(), entry.polishedSoapstoneStairs(), entry.soapstoneBrickStairs());
            addOptional(walls, entry.mudBrickWall(), entry.terracottaShingleWall(), entry.soapstoneWall(), entry.polishedSoapstoneWall(), entry.soapstoneBrickWall());
            addOptional(flowerPots, entry.flowerPot());
            addOptional(chalkDustTag, entry.chalkDust());
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
                addOptional(suppFlags, entry.flag().get());
                addOptional(axeMineable, entry.flag().get());
            }
            if (entry.present() != null) {
                addOptional(suppPresents, entry.present().get());
                addOptional(axeMineable, entry.present().get());
            }
            if (entry.trappedPresent() != null) {
                addOptional(suppTrappedPresents, entry.trappedPresent().get());
                addOptional(axeMineable, entry.trappedPresent().get());
            }
            if (entry.awning() != null) {
                addOptional(suppAwnings, entry.awning().get());
                addOptional(axeMineable, entry.awning().get());
            }
            if (entry.candleHolder() != null) {
                addOptional(suppCandleHolders, entry.candleHolder().get());
                addOptional(pickaxeMineable, entry.candleHolder().get());
            }
            if (entry.bunting() != null) {
                addOptional(suppBuntings, entry.bunting().get());
                addOptional(axeMineable, entry.bunting().get());
            }
            if (entry.buntingWall() != null) {
                addOptional(suppBuntings, entry.buntingWall().get());
                addOptional(axeMineable, entry.buntingWall().get());
            }
        }

        /* SuppSquared */
        com.ancient.patchup.block.suppsquared.SuppSquaredEntries.init();
        var suppSacks = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("supplementaries", "sacks")));
        var suppGoldCandleHolders = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("suppsquared", "golden_candle_holders")));

        for (com.ancient.patchup.block.suppsquared.SuppSquaredEntries.Entry entry : com.ancient.patchup.block.suppsquared.SuppSquaredEntries.ENTRIES) {
            if (entry.sack() != null) {
                addOptional(suppSacks, entry.sack().get());
                addOptional(axeMineable, entry.sack().get());
            }
            if (entry.goldenCandleHolder() != null) {
                addOptional(suppGoldCandleHolders, entry.goldenCandleHolder().get());
                addOptional(pickaxeMineable, entry.goldenCandleHolder().get());
            }
        }

        /* Amendments */
        com.ancient.patchup.block.amendments.AmendmentsEntries.init();
        var amCeilingBanners = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("amendments", "ceiling_banners")));
        var banners = this.getOrCreateTagBuilder(BlockTags.BANNERS);

        for (com.ancient.patchup.block.amendments.AmendmentsEntries.Entry entry : com.ancient.patchup.block.amendments.AmendmentsEntries.ENTRIES) {
            if (entry.ceilingBanner() != null) {
                addOptional(amCeilingBanners, entry.ceilingBanner().get());
                addOptional(banners, entry.ceilingBanner().get());
                addOptional(axeMineable, entry.ceilingBanner().get());
            }
        }

        /* Sleep Tight */
        if (com.ancient.patchup.Compats.SLEEP_TIGHT.isLoaded()) {
            com.ancient.patchup.block.sleep_tight.SleepTightEntries.init();
            var sleepTightHammocks = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("sleep_tight", "hammocks")));

            for (com.ancient.patchup.block.sleep_tight.SleepTightEntries.Entry entry : com.ancient.patchup.block.sleep_tight.SleepTightEntries.ENTRIES) {
                if (entry.hammock() != null) {
                    addOptional(sleepTightHammocks, entry.hammock().get());
                    addOptional(axeMineable, entry.hammock().get());
                }
            }
        }

        /* Snowy Spirit */
        if (com.ancient.patchup.Compats.SNOWY_SPIRIT.isLoaded()) {
            com.ancient.patchup.block.snowy_spirit.SnowySpiritEntries.init();
            var snowyGlowLights = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("snowyspirit", "glow_lights")));
            var snowyGumdrops = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("snowyspirit", "gumdrops")));
            var buttons = this.getOrCreateTagBuilder(BlockTags.BUTTONS);

            for (com.ancient.patchup.block.snowy_spirit.SnowySpiritEntries.Entry entry : com.ancient.patchup.block.snowy_spirit.SnowySpiritEntries.ENTRIES) {
                if (entry.glowLightsBlock() != null) {
                    addOptional(snowyGlowLights, entry.glowLightsBlock().get());
                }
                if (entry.gumdrop() != null) {
                    addOptional(snowyGumdrops, entry.gumdrop().get());
                    addOptional(buttons, entry.gumdrop().get());
                }
            }
        }

        /* Refined Storage */
        String[] rsBlocks = {
                "autocrafter", "autocrafter_manager", "autocrafting_monitor",
                "cable", "constructor", "controller", "crafting_grid",
                "creative_controller", "destructor", "detector", "disk_interface",
                "exporter", "external_storage", "grid", "importer",
                "network_receiver", "network_transmitter", "pattern_grid",
                "relay", "security_manager", "wireless_transmitter"
        };
        for (DDDyes dye : DDDyes.values()) {
            String color = dye.asString();
            for (String block : rsBlocks) {
                pickaxeMineable.addOptional(Identifier.of("refinedstorage", color + "_" + block));
            }
        }
    }
}