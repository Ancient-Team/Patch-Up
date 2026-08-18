package com.ancient.patchup.item;

import com.ancient.patchup.Compats;
import com.ancient.patchup.PatchUp;
import com.ancient.patchup.block.another_furniture.*;
import com.ancient.patchup.block.farmers_delight.CanvasSigns;
import com.ancient.patchup.block.comforts.ComfortsItems;
import com.ancient.patchup.block.arts_and_crafts.ArtsAndCraftsEntries;
import com.ancient.patchup.block.supplementaries.SupplementariesEntries;
import com.ancient.patchup.block.suppsquared.SuppSquaredEntries;
import com.ancient.patchup.block.amendments.AmendmentsEntries;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
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

    public static void registerItemGroups() {
        PatchUp.LOGGER.info("Registering Item Groups for " + PatchUp.MOD_ID);

        if (Compats.ANOTHER_FURNITURE.isLoaded()) {
            ANOTHER_FURNITURE_GROUP = Registry.register(Registries.ITEM_GROUP,
                    Identifier.of(PatchUp.MOD_ID, "another_furniture"),
                    FabricItemGroup.builder()
                            .displayName(Text.translatable("itemgroup.patchup.another_furniture"))
                            .icon(() -> new ItemStack(Sofa.FOREST_SOFA.get()))
                            .entries((displayContext, entries) -> {
                                for (Supplier<Block> stool : Stool.STOOLS.values()) {
                                    entries.add(stool.get());
                                }
                                for (Supplier<Block> tallStool : TallStool.TALL_STOOLS.values()) {
                                    entries.add(tallStool.get());
                                }
                                for (Supplier<Block> sofa : Sofa.SOFAS.values()) {
                                    entries.add(sofa.get());
                                }
                                for (Supplier<Block> lamp : Lamp.LAMPS.values()) {
                                    entries.add(lamp.get());
                                }
                                for (Supplier<Block> curtain : Curtain.CURTAINS.values()) {
                                    entries.add(curtain.get());
                                }
                            }).build());
        }

        if (Compats.FARMERS_DELIGHT.isLoaded()) {
            CanvasSigns.init();
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

        if (Compats.COMFORTS.isLoaded()) {
            ComfortsItems.init();
            COMFORTS_GROUP = Registry.register(Registries.ITEM_GROUP,
                    Identifier.of(PatchUp.MOD_ID, "comforts"),
                    FabricItemGroup.builder()
                            .displayName(Text.translatable("itemgroup.patchup.comforts"))
                            .icon(() -> new ItemStack(ComfortsItems.ENTRIES.get(0).sleepingBagItem().get()))
                            .entries((displayContext, entries) -> {
                                for (ComfortsItems.ComfortsEntry entry : ComfortsItems.ENTRIES) {
                                    entries.add(entry.hammockItem().get());
                                    entries.add(entry.sleepingBagItem().get());
                                }
                            }).build());
        }

        if (Compats.ARTS_AND_CRAFTS.isLoaded()) {
            ArtsAndCraftsEntries.init();
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

        if (Compats.SUPPLEMENTARIES.isLoaded()) {
            SupplementariesEntries.init();
            SUPPLEMENTARIES_GROUP = Registry.register(Registries.ITEM_GROUP,
                    Identifier.of(PatchUp.MOD_ID, "supplementaries"),
                    FabricItemGroup.builder()
                            .displayName(Text.translatable("itemgroup.patchup.supplementaries"))
                            .icon(() -> new ItemStack(SupplementariesEntries.ENTRIES.get(0).present().get()))
                            .entries((displayContext, entries) -> {
                                for (SupplementariesEntries.Entry entry : SupplementariesEntries.ENTRIES) {
                                    if (entry.flag() != null) entries.add(entry.flag().get());
                                    if (entry.present() != null) entries.add(entry.present().get());
                                    if (entry.trappedPresent() != null) entries.add(entry.trappedPresent().get());
                                    if (entry.awning() != null) entries.add(entry.awning().get());
                                    if (entry.candleHolder() != null) entries.add(entry.candleHolder().get());
                                    if (entry.buntingItem() != null) entries.add(entry.buntingItem().get());
                                }
                            }).build());
        }

        if (Compats.SUPP_SQUARED.isLoaded()) {
            SuppSquaredEntries.init();
            SUPP_SQUARED_GROUP = Registry.register(Registries.ITEM_GROUP,
                    Identifier.of(PatchUp.MOD_ID, "suppsquared"),
                    FabricItemGroup.builder()
                            .displayName(Text.translatable("itemgroup.patchup.suppsquared"))
                            .icon(() -> new ItemStack(SuppSquaredEntries.ENTRIES.get(0).sackItem().get()))
                            .entries((displayContext, entries) -> {
                                for (SuppSquaredEntries.Entry entry : SuppSquaredEntries.ENTRIES) {
                                    if (entry.sackItem() != null) entries.add(entry.sackItem().get());
                                    if (entry.goldenCandleHolder() != null) entries.add(entry.goldenCandleHolder().get());
                                }
                            }).build());
        }

        if (Compats.AMENDMENTS.isLoaded()) {
            AmendmentsEntries.init();
            AMENDMENTS_GROUP = Registry.register(Registries.ITEM_GROUP,
                    Identifier.of(PatchUp.MOD_ID, "amendments"),
                    FabricItemGroup.builder()
                            .displayName(Text.translatable("itemgroup.patchup.amendments"))
                            .icon(() -> new ItemStack(AmendmentsEntries.ENTRIES.get(0).ceilingBanner().get()))
                            .entries((displayContext, entries) -> {
                                for (AmendmentsEntries.Entry entry : AmendmentsEntries.ENTRIES) {
                                    if (entry.ceilingBanner() != null) entries.add(entry.ceilingBanner().get());
                                }
                            }).build());
        }
    }
}
