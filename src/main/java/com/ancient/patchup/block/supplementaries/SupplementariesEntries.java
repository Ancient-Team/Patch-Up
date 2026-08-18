package com.ancient.patchup.block.supplementaries;

import com.ninni.dye_depot.registry.DDDyes;
import net.mehvahdjukaar.supplementaries.reg.ModRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.DyeColor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplementariesEntries {

    public record Entry(
            DDDyes dye,
            Supplier<? extends Block> flag,
            Supplier<? extends Block> present,
            Supplier<? extends Block> trappedPresent,
            Supplier<? extends Block> awning,
            Supplier<? extends Block> candleHolder,
            Supplier<? extends Block> bunting,
            Supplier<? extends Item> buntingItem,
            Supplier<? extends Block> buntingWall
    ) {}

    public static final List<Entry> ENTRIES = new ArrayList<>();

    public static void init() {
        if (!ENTRIES.isEmpty()) return;

        for (DDDyes dye : DDDyes.values()) {
            DyeColor color = dye.get();

            Supplier<? extends Block> flag = ModRegistry.FLAGS.get(color);
            Supplier<? extends Block> present = ModRegistry.PRESENTS.get(color);
            Supplier<? extends Block> trappedPresent = ModRegistry.TRAPPED_PRESENTS.get(color);
            Supplier<? extends Block> awning = ModRegistry.AWNINGS.get(color);
            Supplier<? extends Block> candleHolder = ModRegistry.CANDLE_HOLDERS.get(color);
            Supplier<? extends Block> bunting = ModRegistry.BUNTING_BLOCKS.get(color);
            Supplier<? extends Item> buntingItem = ModRegistry.BUNTING_ITEMS.get(color);
            Supplier<? extends Block> buntingWall = ModRegistry.BUNTING_WALL_BLOCKS.get(color);

            ENTRIES.add(new Entry(
                    dye, flag, present, trappedPresent, awning, candleHolder, bunting, buntingItem, buntingWall
            ));
        }
    }
}
