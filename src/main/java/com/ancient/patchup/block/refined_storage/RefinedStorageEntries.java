package com.ancient.patchup.block.refined_storage;

import com.ninni.dye_depot.registry.DDDyes;
import com.refinedmods.refinedstorage.common.content.Blocks;
import net.minecraft.block.Block;
import net.minecraft.util.DyeColor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class RefinedStorageEntries {

    public record Entry(
            DDDyes dye,
            Supplier<? extends Block> cable,
            Supplier<? extends Block> controller,
            Supplier<? extends Block> creativeController,
            Supplier<? extends Block> grid,
            Supplier<? extends Block> craftingGrid,
            Supplier<? extends Block> patternGrid,
            Supplier<? extends Block> importer,
            Supplier<? extends Block> exporter,
            Supplier<? extends Block> externalStorage,
            Supplier<? extends Block> detector,
            Supplier<? extends Block> destructor,
            Supplier<? extends Block> constructor,
            Supplier<? extends Block> wirelessTransmitter,
            Supplier<? extends Block> networkReceiver,
            Supplier<? extends Block> networkTransmitter,
            Supplier<? extends Block> securityManager,
            Supplier<? extends Block> relay,
            Supplier<? extends Block> diskInterface,
            Supplier<? extends Block> autocrafter,
            Supplier<? extends Block> autocrafterManager,
            Supplier<? extends Block> autocraftingMonitor
    ) {
        public List<Supplier<? extends Block>> getAllBlocks() {
            return List.of(
                    cable, controller, creativeController,
                    grid, craftingGrid, patternGrid,
                    importer, exporter, externalStorage,
                    detector, destructor, constructor,
                    wirelessTransmitter, networkReceiver, networkTransmitter,
                    securityManager, relay, diskInterface,
                    autocrafter, autocrafterManager, autocraftingMonitor
            );
        }
    }

    public static final List<Entry> ENTRIES = new ArrayList<>();

    public static void init() {
        if (!ENTRIES.isEmpty()) return;

        Blocks b = Blocks.INSTANCE;
        for (DDDyes dye : DDDyes.values()) {
            DyeColor color = dye.get();

            ENTRIES.add(new Entry(
                    dye,
                    () -> b.getCable().get(color),
                    () -> b.getController().get(color),
                    () -> b.getCreativeController().get(color),
                    () -> b.getGrid().get(color),
                    () -> b.getCraftingGrid().get(color),
                    () -> b.getPatternGrid().get(color),
                    () -> b.getImporter().get(color),
                    () -> b.getExporter().get(color),
                    () -> b.getExternalStorage().get(color),
                    () -> b.getDetector().get(color),
                    () -> b.getDestructor().get(color),
                    () -> b.getConstructor().get(color),
                    () -> b.getWirelessTransmitter().get(color),
                    () -> b.getNetworkReceiver().get(color),
                    () -> b.getNetworkTransmitter().get(color),
                    () -> b.getSecurityManager().get(color),
                    () -> b.getRelay().get(color),
                    () -> b.getDiskInterface().get(color),
                    () -> b.getAutocrafter().get(color),
                    () -> b.getAutocrafterManager().get(color),
                    () -> b.getAutocraftingMonitor().get(color)
            ));
        }
    }
}
