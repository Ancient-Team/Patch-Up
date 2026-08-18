package com.ancient.patchup.datagen;

import com.ancient.patchup.block.another_furniture.*;
import com.ancient.patchup.block.farmers_delight.CanvasSigns;
import com.starfish_studios.another_furniture.registry.AFItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
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

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        /* Another Furniture */
        var stools = this.getOrCreateTagBuilder(AFItemTags.STOOLS);
        var tallStools = this.getOrCreateTagBuilder(AFItemTags.TALL_STOOLS);
        var sofas = this.getOrCreateTagBuilder(AFItemTags.SOFAS);
        var lamps = this.getOrCreateTagBuilder(AFItemTags.LAMPS);
        var curtains = this.getOrCreateTagBuilder(AFItemTags.CURTAINS);

        for (Supplier<Block> stool : Stool.STOOLS.values()) {
            stools.add(stool.get().asItem());
        }

        for (Supplier<Block> tallStool : TallStool.TALL_STOOLS.values()) {
            tallStools.add(tallStool.get().asItem());
        }

        for (Supplier<Block> sofa : Sofa.SOFAS.values()) {
            sofas.add(sofa.get().asItem());
        }

        for (Supplier<Block> lamp : Lamp.LAMPS.values()) {
            lamps.add(lamp.get().asItem());
        }

        for (Supplier<Block> curtain : Curtain.CURTAINS.values()) {
            curtains.add(curtain.get().asItem());
        }

        /* Farmer's Delight Canvas Signs */
        CanvasSigns.init();
        var signs = this.getOrCreateTagBuilder(ItemTags.SIGNS);
        var hangingSigns = this.getOrCreateTagBuilder(ItemTags.HANGING_SIGNS);
        var fdCanvasSigns = this.getOrCreateTagBuilder(FD_CANVAS_SIGNS);
        var fdHangingCanvasSigns = this.getOrCreateTagBuilder(FD_HANGING_CANVAS_SIGNS);

        for (CanvasSigns.CanvasSignEntry entry : CanvasSigns.ENTRIES) {
            signs.add(entry.signItem());
            hangingSigns.add(entry.hangingSignItem());
            fdCanvasSigns.add(entry.signItem());
            fdHangingCanvasSigns.add(entry.hangingSignItem());
        }

        /* Comforts */
        com.ancient.patchup.block.comforts.ComfortsItems.init();
        var hammocks = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("comforts", "hammocks")));
        var sleepingBags = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("comforts", "sleeping_bags")));

        for (com.ancient.patchup.block.comforts.ComfortsItems.ComfortsEntry entry : com.ancient.patchup.block.comforts.ComfortsItems.ENTRIES) {
            hammocks.add(entry.hammockItem().get());
            sleepingBags.add(entry.sleepingBagItem().get());
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
            itemSlabs.add(entry.mudBrickSlab().asItem(), entry.terracottaShingleSlab().asItem(), entry.soapstoneSlab().asItem(), entry.polishedSoapstoneSlab().asItem(), entry.soapstoneBrickSlab().asItem());
            itemStairs.add(entry.mudBrickStairs().asItem(), entry.terracottaShingleStairs().asItem(), entry.soapstoneStairs().asItem(), entry.polishedSoapstoneStairs().asItem(), entry.soapstoneBrickStairs().asItem());
            itemWalls.add(entry.mudBrickWall().asItem(), entry.terracottaShingleWall().asItem(), entry.soapstoneWall().asItem(), entry.polishedSoapstoneWall().asItem(), entry.soapstoneBrickWall().asItem());
            chalkSticks.add(entry.chalkStick());
            paintbrushes.add(entry.paintbrush());
            decoratedPots.add(entry.decoratedPotItem());
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
            if (entry.flag() != null) suppFlags.add(entry.flag().get().asItem());
            if (entry.present() != null) suppPresents.add(entry.present().get().asItem());
            if (entry.trappedPresent() != null) suppTrappedPresents.add(entry.trappedPresent().get().asItem());
            if (entry.awning() != null) suppAwnings.add(entry.awning().get().asItem());
            if (entry.candleHolder() != null) suppCandleHolders.add(entry.candleHolder().get().asItem());
            if (entry.buntingItem() != null) suppBuntings.add(entry.buntingItem().get());
        }

        /* SuppSquared */
        com.ancient.patchup.block.suppsquared.SuppSquaredEntries.init();
        var suppSacks = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("supplementaries", "sacks")));
        var suppGoldCandleHolders = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("suppsquared", "golden_candle_holders")));

        for (com.ancient.patchup.block.suppsquared.SuppSquaredEntries.Entry entry : com.ancient.patchup.block.suppsquared.SuppSquaredEntries.ENTRIES) {
            if (entry.sackItem() != null) suppSacks.add(entry.sackItem().get());
            if (entry.goldenCandleHolder() != null) suppGoldCandleHolders.add(entry.goldenCandleHolder().get().asItem());
        }

        /* Amendments */
        com.ancient.patchup.block.amendments.AmendmentsEntries.init();
        var amCeilingBanners = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("amendments", "ceiling_banners")));
        var banners = this.getOrCreateTagBuilder(ItemTags.BANNERS);

        for (com.ancient.patchup.block.amendments.AmendmentsEntries.Entry entry : com.ancient.patchup.block.amendments.AmendmentsEntries.ENTRIES) {
            if (entry.ceilingBanner() != null) {
                amCeilingBanners.add(entry.ceilingBanner().get().asItem());
                banners.add(entry.ceilingBanner().get().asItem());
            }
        }
    }
}
