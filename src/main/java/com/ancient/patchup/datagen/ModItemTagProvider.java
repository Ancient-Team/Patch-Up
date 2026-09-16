package com.ancient.patchup.datagen;

import com.ancient.patchup.block.another_furniture.*;
import com.ancient.patchup.block.farmers_delight.CanvasSigns;
import com.ninni.dye_depot.registry.DDDyes;
import com.starfish_studios.another_furniture.registry.AFItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public static final TagKey<Item> FD_CANVAS_SIGNS = TagKey.of(RegistryKeys.ITEM, Identifier.of("farmersdelight", "canvas_signs"));
    public static final TagKey<Item> FD_HANGING_CANVAS_SIGNS = TagKey.of(RegistryKeys.ITEM, Identifier.of("farmersdelight", "hanging_canvas_signs"));

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    private void addOptional(FabricTagBuilder builder, ItemConvertible... items) {
        for (ItemConvertible item : items) {
            if (item != null && item.asItem() != net.minecraft.item.Items.AIR) {
                builder.addOptional(Registries.ITEM.getId(item.asItem()));
            }
        }
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        /* Another Furniture */
        var stools = this.getOrCreateTagBuilder(AFItemTags.STOOLS);
        var tallStools = this.getOrCreateTagBuilder(AFItemTags.TALL_STOOLS);
        var sofas = this.getOrCreateTagBuilder(AFItemTags.SOFAS);
        var lamps = this.getOrCreateTagBuilder(AFItemTags.LAMPS);
        var curtains = this.getOrCreateTagBuilder(AFItemTags.CURTAINS);

        for (Supplier<Block> stool : Stool.STOOLS.values()) {
            addOptional(stools, stool.get());
        }

        for (Supplier<Block> tallStool : TallStool.TALL_STOOLS.values()) {
            addOptional(tallStools, tallStool.get());
        }

        for (Supplier<Block> sofa : Sofa.SOFAS.values()) {
            addOptional(sofas, sofa.get());
        }

        for (Supplier<Block> lamp : Lamp.LAMPS.values()) {
            addOptional(lamps, lamp.get());
        }

        for (Supplier<Block> curtain : Curtain.CURTAINS.values()) {
            addOptional(curtains, curtain.get());
        }

        /* Farmer's Delight Canvas Signs */
        CanvasSigns.init();
        var signs = this.getOrCreateTagBuilder(ItemTags.SIGNS);
        var hangingSigns = this.getOrCreateTagBuilder(ItemTags.HANGING_SIGNS);
        var fdCanvasSigns = this.getOrCreateTagBuilder(FD_CANVAS_SIGNS);
        var fdHangingCanvasSigns = this.getOrCreateTagBuilder(FD_HANGING_CANVAS_SIGNS);

        for (CanvasSigns.CanvasSignEntry entry : CanvasSigns.ENTRIES) {
            addOptional(signs, entry.signItem());
            addOptional(hangingSigns, entry.hangingSignItem());
            addOptional(fdCanvasSigns, entry.signItem());
            addOptional(fdHangingCanvasSigns, entry.hangingSignItem());
        }

        /* Comforts */
        com.ancient.patchup.block.comforts.ComfortsItems.init();
        var hammocks = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("comforts", "hammocks")));
        var sleepingBags = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("comforts", "sleeping_bags")));

        for (com.ancient.patchup.block.comforts.ComfortsItems.ComfortsEntry entry : com.ancient.patchup.block.comforts.ComfortsItems.ENTRIES) {
            addOptional(hammocks, entry.hammockItem().get());
            addOptional(sleepingBags, entry.sleepingBagItem().get());
        }

        /* Arts & Crafts */
        com.ancient.patchup.block.arts_and_crafts.ArtsAndCraftsEntries.init();
        var itemSlabs = this.getOrCreateTagBuilder(ItemTags.SLABS);
        var itemStairs = this.getOrCreateTagBuilder(ItemTags.STAIRS);
        var itemWalls = this.getOrCreateTagBuilder(ItemTags.WALLS);
        var chalkSticks = this.getOrCreateTagBuilder(com.kekecreations.arts_and_crafts.core.init.ACTags.ItemTags.CHALK_STICKS);
        var paintbrushes = this.getOrCreateTagBuilder(com.kekecreations.arts_and_crafts.core.init.ACTags.ItemTags.PAINTBRUSHES);
        var decoratedPots = this.getOrCreateTagBuilder(com.kekecreations.arts_and_crafts.core.init.ACTags.ItemTags.DECORATED_POTS);

        for (com.ancient.patchup.block.arts_and_crafts.ArtsAndCraftsEntries.Entry entry : com.ancient.patchup.block.arts_and_crafts.ArtsAndCraftsEntries.ENTRIES) {
            addOptional(itemSlabs, entry.mudBrickSlab(), entry.terracottaShingleSlab(), entry.soapstoneSlab(), entry.polishedSoapstoneSlab(), entry.soapstoneBrickSlab());
            addOptional(itemStairs, entry.mudBrickStairs(), entry.terracottaShingleStairs(), entry.soapstoneStairs(), entry.polishedSoapstoneStairs(), entry.soapstoneBrickStairs());
            addOptional(itemWalls, entry.mudBrickWall(), entry.terracottaShingleWall(), entry.soapstoneWall(), entry.polishedSoapstoneWall(), entry.soapstoneBrickWall());
            addOptional(chalkSticks, entry.chalkStick());
            addOptional(paintbrushes, entry.paintbrush());
            addOptional(decoratedPots, entry.decoratedPotItem());
        }

        /* Supplementaries */
        com.ancient.patchup.block.supplementaries.SupplementariesEntries.init();
        var suppFlags = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("supplementaries", "flags")));
        var suppPresents = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("supplementaries", "presents")));
        var suppTrappedPresents = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("supplementaries", "trapped_presents")));
        var suppAwnings = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("supplementaries", "awnings")));
        var suppCandleHolders = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("supplementaries", "candle_holders")));
        var suppBuntings = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("supplementaries", "buntings")));

        for (com.ancient.patchup.block.supplementaries.SupplementariesEntries.Entry entry : com.ancient.patchup.block.supplementaries.SupplementariesEntries.ENTRIES) {
            if (entry.flag() != null) addOptional(suppFlags, entry.flag().get());
            if (entry.present() != null) addOptional(suppPresents, entry.present().get());
            if (entry.trappedPresent() != null) addOptional(suppTrappedPresents, entry.trappedPresent().get());
            if (entry.awning() != null) addOptional(suppAwnings, entry.awning().get());
            if (entry.candleHolder() != null) addOptional(suppCandleHolders, entry.candleHolder().get());
            if (entry.buntingItem() != null) addOptional(suppBuntings, entry.buntingItem().get());
        }

        /* SuppSquared */
        com.ancient.patchup.block.suppsquared.SuppSquaredEntries.init();
        var suppSacks = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("supplementaries", "sacks")));
        var suppGoldCandleHolders = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("suppsquared", "golden_candle_holders")));

        for (com.ancient.patchup.block.suppsquared.SuppSquaredEntries.Entry entry : com.ancient.patchup.block.suppsquared.SuppSquaredEntries.ENTRIES) {
            if (entry.sackItem() != null) addOptional(suppSacks, entry.sackItem().get());
            if (entry.goldenCandleHolder() != null) addOptional(suppGoldCandleHolders, entry.goldenCandleHolder().get());
        }

        /* Amendments */
        com.ancient.patchup.block.amendments.AmendmentsEntries.init();
        var amCeilingBanners = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("amendments", "ceiling_banners")));
        var banners = this.getOrCreateTagBuilder(ItemTags.BANNERS);

        for (com.ancient.patchup.block.amendments.AmendmentsEntries.Entry entry : com.ancient.patchup.block.amendments.AmendmentsEntries.ENTRIES) {
            if (entry.ceilingBanner() != null) {
                addOptional(amCeilingBanners, entry.ceilingBanner().get());
                addOptional(banners, entry.ceilingBanner().get());
            }
        }

        /* Sleep Tight */
        if (com.ancient.patchup.Compats.SLEEP_TIGHT.isLoaded()) {
            com.ancient.patchup.block.sleep_tight.SleepTightEntries.init();
            var sleepTightHammocks = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("sleep_tight", "hammocks")));

            for (com.ancient.patchup.block.sleep_tight.SleepTightEntries.Entry entry : com.ancient.patchup.block.sleep_tight.SleepTightEntries.ENTRIES) {
                if (entry.hammock() != null) {
                    addOptional(sleepTightHammocks, entry.hammock().get());
                }
            }
        }

        /* Snowy Spirit */
        if (com.ancient.patchup.Compats.SNOWY_SPIRIT.isLoaded()) {
            com.ancient.patchup.block.snowy_spirit.SnowySpiritEntries.init();
            var snowyGlowLightsItems = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("snowyspirit", "glow_lights")));
            var snowyGumdropsItems = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("snowyspirit", "gumdrops")));
            var itemButtons = this.getOrCreateTagBuilder(ItemTags.BUTTONS);

            for (com.ancient.patchup.block.snowy_spirit.SnowySpiritEntries.Entry entry : com.ancient.patchup.block.snowy_spirit.SnowySpiritEntries.ENTRIES) {
                if (entry.glowLightsItem() != null) {
                    addOptional(snowyGlowLightsItems, entry.glowLightsItem().get());
                }
                if (entry.gumdrop() != null) {
                    addOptional(snowyGumdropsItems, entry.gumdrop().get());
                    addOptional(itemButtons, entry.gumdrop().get());
                }
            }
        }

        /* Refined Storage */
        String[] rsItemTypes = {
                "autocrafter", "autocrafter_manager", "autocrafting_monitor",
                "cable", "constructor", "controller", "crafting_grid",
                "creative_controller", "destructor", "detector", "disk_interface",
                "exporter", "external_storage", "grid", "importer",
                "network_receiver", "network_transmitter", "pattern_grid",
                "relay", "security_manager", "wireless_transmitter"
        };
        for (String type : rsItemTypes) {
            var tagBuilder = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("refinedstorage", type + "s")));
            for (DDDyes dye : DDDyes.values()) {
                tagBuilder.addOptional(Identifier.of("refinedstorage", dye.asString() + "_" + type));
            }
        }
    }
}

