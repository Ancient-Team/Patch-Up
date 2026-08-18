package com.ancient.patchup.block.suppsquared;

import com.ninni.dye_depot.registry.DDDyes;
import net.mehvahdjukaar.suppsquared.SuppSquared;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.DyeColor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SuppSquaredEntries {

    public record Entry(
            DDDyes dye,
            Supplier<? extends Block> sack,
            Supplier<? extends Item> sackItem,
            Supplier<? extends Block> goldenCandleHolder
    ) {}

    public static final List<Entry> ENTRIES = new ArrayList<>();

    public static void init() {
        if (!ENTRIES.isEmpty()) return;

        for (DDDyes dye : DDDyes.values()) {
            DyeColor color = dye.get();

            Supplier<? extends Block> sack = SuppSquared.SACKS.get(color);
            Supplier<? extends Item> sackItem = SuppSquared.SACK_ITEMS.get(color);
            Supplier<? extends Block> goldenCandleHolder = SuppSquared.GOLDEN_CANDLE_HOLDERS.get(color);

            ENTRIES.add(new Entry(dye, sack, sackItem, goldenCandleHolder));
        }
    }
}
