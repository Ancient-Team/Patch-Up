package com.ancient.patchup.item;

import com.ancient.patchup.Compats;
import com.ancient.patchup.PatchUp;
import com.ancient.patchup.block.amendments.AmendmentsEntries;
import com.ancient.patchup.block.another_furniture.*;
import com.ancient.patchup.block.arts_and_crafts.ArtsAndCraftsEntries;
import com.ancient.patchup.block.comforts.ComfortsItems;
import com.ancient.patchup.block.farmers_delight.CanvasSigns;
import com.ancient.patchup.block.refined_storage.RefinedStorageEntries;
import com.ancient.patchup.block.sleep_tight.SleepTightEntries;
import com.ancient.patchup.block.snowy_spirit.SnowySpiritEntries;
import com.ancient.patchup.block.supplementaries.SupplementariesEntries;
import com.ancient.patchup.block.suppsquared.SuppSquaredEntries;
import com.ninni.dye_depot.registry.DDDyes;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class ModItemGroups {

    public static ItemGroup ANOTHER_FURNITURE_GROUP;
    public static ItemGroup FARMERS_DELIGHT_GROUP;
    public static ItemGroup COMFORTS_GROUP;
    public static ItemGroup ARTS_AND_CRAFTS_GROUP;
    public static ItemGroup SUPPLEMENTARIES_GROUP;
    public static ItemGroup SUPP_SQUARED_GROUP;
    public static ItemGroup AMENDMENTS_GROUP;
    public static ItemGroup SLEEP_TIGHT_GROUP;
    public static ItemGroup SNOWY_SPIRIT_GROUP;
    public static ItemGroup REFINED_STORAGE_GROUP;

    private static void addIfPresent(ItemGroup.Entries entries, Supplier<? extends ItemConvertible> supplier) {
        if (supplier == null) return;
        ItemConvertible item = supplier.get();
        if (item != null && item.asItem() != Items.AIR) {
            entries.add(item);
        }
    }

    private static ItemStack iconOrBarrier(Supplier<? extends ItemConvertible> supplier) {
        if (supplier != null) {
            ItemConvertible item = supplier.get();
            if (item != null && item.asItem() != Items.AIR) {
                return new ItemStack(item);
            }
        }
        return new ItemStack(Items.BARRIER);
    }

    public static void registerItemGroups() {
        PatchUp.LOGGER.info("Registering Item Groups for " + PatchUp.MOD_ID);

        if (Compats.ANOTHER_FURNITURE.isLoaded()) {
            ANOTHER_FURNITURE_GROUP = Registry.register(Registries.ITEM_GROUP,
                    Identifier.of(PatchUp.MOD_ID, "another_furniture"),
                    FabricItemGroup.builder()
                            .displayName(Text.translatable("itemgroup.patchup.another_furniture"))
                            .icon(() -> iconOrBarrier(Sofa.SOFAS.get(DDDyes.FOREST)))
                            .entries((displayContext, entries) -> {
                                for (Supplier<Block> stool : Stool.STOOLS.values()) {
                                    addIfPresent(entries, stool);
                                }
                                for (Supplier<Block> tallStool : TallStool.TALL_STOOLS.values()) {
                                    addIfPresent(entries, tallStool);
                                }
                                for (Supplier<Block> sofa : Sofa.SOFAS.values()) {
                                    addIfPresent(entries, sofa);
                                }
                                for (Supplier<Block> lamp : Lamp.LAMPS.values()) {
                                    addIfPresent(entries, lamp);
                                }
                                for (Supplier<Block> curtain : Curtain.CURTAINS.values()) {
                                    addIfPresent(entries, curtain);
                                }
                            }).build());
        }

        if (Compats.FARMERS_DELIGHT.isLoaded() && !CanvasSigns.ENTRIES.isEmpty()) {
            FARMERS_DELIGHT_GROUP = Registry.register(Registries.ITEM_GROUP,
                    Identifier.of(PatchUp.MOD_ID, "farmers_delight"),
                    FabricItemGroup.builder()
                            .displayName(Text.translatable("itemgroup.patchup.farmers_delight"))
                            .icon(() -> new ItemStack(CanvasSigns.ENTRIES.get(0).signItem()))
                            .entries((displayContext, entries) -> {
                                for (CanvasSigns.CanvasSignEntry entry : CanvasSigns.ENTRIES) {
                                    entries.add(entry.signItem());
                                    entries.add(entry.hangingSignItem());
                                }
                            }).build());
        }

        if (Compats.COMFORTS.isLoaded() && !ComfortsItems.ENTRIES.isEmpty()) {
            COMFORTS_GROUP = Registry.register(Registries.ITEM_GROUP,
                    Identifier.of(PatchUp.MOD_ID, "comforts"),
                    FabricItemGroup.builder()
                            .displayName(Text.translatable("itemgroup.patchup.comforts"))
                            .icon(() -> iconOrBarrier(ComfortsItems.ENTRIES.get(0).sleepingBagItem()))
                            .entries((displayContext, entries) -> {
                                for (ComfortsItems.ComfortsEntry entry : ComfortsItems.ENTRIES) {
                                    addIfPresent(entries, entry.hammockItem());
                                    addIfPresent(entries, entry.sleepingBagItem());
                                }
                            }).build());
        }

        if (Compats.ARTS_AND_CRAFTS.isLoaded() && !ArtsAndCraftsEntries.ENTRIES.isEmpty()) {
            ARTS_AND_CRAFTS_GROUP = Registry.register(Registries.ITEM_GROUP,
                    Identifier.of(PatchUp.MOD_ID, "arts_and_crafts"),
                    FabricItemGroup.builder()
                            .displayName(Text.translatable("itemgroup.patchup.arts_and_crafts"))
                            .icon(() -> new ItemStack(ArtsAndCraftsEntries.ENTRIES.get(0).decoratedPotItem()))
                            .entries((displayContext, entries) -> {
                                for (ArtsAndCraftsEntries.Entry entry : ArtsAndCraftsEntries.ENTRIES) {
                                    entries.add(entry.chalk());
                                    entries.add(entry.chalkStick());
                                    entries.add(entry.paintbrush());
                                    entries.add(entry.plaster());
                                    entries.add(entry.flowerPotItem());
                                    entries.add(entry.decoratedPotItem());
                                    entries.add(entry.mudBricks());
                                    entries.add(entry.mudBrickSlab());
                                    entries.add(entry.mudBrickStairs());
                                    entries.add(entry.mudBrickWall());
                                    entries.add(entry.terracottaShingles());
                                    entries.add(entry.terracottaShingleSlab());
                                    entries.add(entry.terracottaShingleStairs());
                                    entries.add(entry.terracottaShingleWall());
                                    entries.add(entry.soapstone());
                                    entries.add(entry.soapstoneSlab());
                                    entries.add(entry.soapstoneStairs());
                                    entries.add(entry.soapstoneWall());
                                    entries.add(entry.polishedSoapstone());
                                    entries.add(entry.polishedSoapstoneSlab());
                                    entries.add(entry.polishedSoapstoneStairs());
                                    entries.add(entry.polishedSoapstoneWall());
                                    entries.add(entry.soapstoneBricks());
                                    entries.add(entry.soapstoneBrickSlab());
                                    entries.add(entry.soapstoneBrickStairs());
                                    entries.add(entry.soapstoneBrickWall());
                                }
                            }).build());
        }

        if (Compats.SUPPLEMENTARIES.isLoaded() && !SupplementariesEntries.ENTRIES.isEmpty()) {
            SUPPLEMENTARIES_GROUP = Registry.register(Registries.ITEM_GROUP,
                    Identifier.of(PatchUp.MOD_ID, "supplementaries"),
                    FabricItemGroup.builder()
                            .displayName(Text.translatable("itemgroup.patchup.supplementaries"))
                            .icon(() -> iconOrBarrier(SupplementariesEntries.ENTRIES.get(0).present()))
                            .entries((displayContext, entries) -> {
                                for (SupplementariesEntries.Entry entry : SupplementariesEntries.ENTRIES) {
                                    addIfPresent(entries, entry.flag());
                                    addIfPresent(entries, entry.present());
                                    addIfPresent(entries, entry.trappedPresent());
                                    addIfPresent(entries, entry.awning());
                                    addIfPresent(entries, entry.candleHolder());
                                    addIfPresent(entries, entry.buntingItem());
                                }
                            }).build());
        }

        if (Compats.SUPP_SQUARED.isLoaded() && !SuppSquaredEntries.ENTRIES.isEmpty()) {
            SUPP_SQUARED_GROUP = Registry.register(Registries.ITEM_GROUP,
                    Identifier.of(PatchUp.MOD_ID, "suppsquared"),
                    FabricItemGroup.builder()
                            .displayName(Text.translatable("itemgroup.patchup.suppsquared"))
                            .icon(() -> iconOrBarrier(SuppSquaredEntries.ENTRIES.get(0).sackItem()))
                            .entries((displayContext, entries) -> {
                                for (SuppSquaredEntries.Entry entry : SuppSquaredEntries.ENTRIES) {
                                    addIfPresent(entries, entry.sackItem());
                                    addIfPresent(entries, entry.goldenCandleHolder());
                                }
                            }).build());
        }

        if (Compats.AMENDMENTS.isLoaded() && !AmendmentsEntries.ENTRIES.isEmpty()) {
            AMENDMENTS_GROUP = Registry.register(Registries.ITEM_GROUP,
                    Identifier.of(PatchUp.MOD_ID, "amendments"),
                    FabricItemGroup.builder()
                            .displayName(Text.translatable("itemgroup.patchup.amendments"))
                            .icon(() -> iconOrBarrier(AmendmentsEntries.ENTRIES.get(0).ceilingBanner()))
                            .entries((displayContext, entries) -> {
                                for (AmendmentsEntries.Entry entry : AmendmentsEntries.ENTRIES) {
                                    addIfPresent(entries, entry.ceilingBanner());
                                }
                            }).build());
        }

        if (Compats.SLEEP_TIGHT.isLoaded() && !SleepTightEntries.ENTRIES.isEmpty()) {
            SLEEP_TIGHT_GROUP = Registry.register(Registries.ITEM_GROUP,
                    Identifier.of(PatchUp.MOD_ID, "sleep_tight"),
                    FabricItemGroup.builder()
                            .displayName(Text.translatable("itemgroup.patchup.sleep_tight"))
                            .icon(() -> iconOrBarrier(SleepTightEntries.ENTRIES.get(0).hammock()))
                            .entries((displayContext, entries) -> {
                                for (SleepTightEntries.Entry entry : SleepTightEntries.ENTRIES) {
                                    addIfPresent(entries, entry.hammock());
                                }
                            }).build());
        }

        if (Compats.SNOWY_SPIRIT.isLoaded() && !SnowySpiritEntries.ENTRIES.isEmpty()) {
            SNOWY_SPIRIT_GROUP = Registry.register(Registries.ITEM_GROUP,
                    Identifier.of(PatchUp.MOD_ID, "snowy_spirit"),
                    FabricItemGroup.builder()
                            .displayName(Text.translatable("itemgroup.patchup.snowy_spirit"))
                            .icon(() -> iconOrBarrier(SnowySpiritEntries.ENTRIES.get(0).glowLightsItem()))
                            .entries((displayContext, entries) -> {
                                for (SnowySpiritEntries.Entry entry : SnowySpiritEntries.ENTRIES) {
                                    addIfPresent(entries, entry.glowLightsItem());
                                    addIfPresent(entries, entry.gumdrop());
                                }
                            }).build());
        }

        if (Compats.REFINED_STORAGE.isLoaded() && !RefinedStorageEntries.ENTRIES.isEmpty()) {
            REFINED_STORAGE_GROUP = Registry.register(Registries.ITEM_GROUP,
                    Identifier.of(PatchUp.MOD_ID, "refined_storage"),
                    FabricItemGroup.builder()
                            .displayName(Text.translatable("itemgroup.patchup.refined_storage"))
                            .icon(() -> iconOrBarrier(RefinedStorageEntries.ENTRIES.get(0).controller()))
                            .entries((displayContext, entries) -> {
                                for (RefinedStorageEntries.Entry entry : RefinedStorageEntries.ENTRIES) {
                                    for (Supplier<? extends Block> blockSupplier : entry.getAllBlocks()) {
                                        addIfPresent(entries, blockSupplier);
                                    }
                                }
                            }).build());
        }
    }
}
