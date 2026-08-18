package com.ancient.patchup.block.amendments;

import com.ninni.dye_depot.registry.DDDyes;
import net.mehvahdjukaar.amendments.reg.ModRegistry;
import net.minecraft.block.Block;
import net.minecraft.util.DyeColor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class AmendmentsEntries {

    public record Entry(
            DDDyes dye,
            Supplier<? extends Block> ceilingBanner
    ) {}

    public static final List<Entry> ENTRIES = new ArrayList<>();

    public static void init() {
        if (!ENTRIES.isEmpty()) return;

        for (DDDyes dye : DDDyes.values()) {
            DyeColor color = dye.get();

            Supplier<? extends Block> ceilingBanner = ModRegistry.CEILING_BANNERS.get(color);

            ENTRIES.add(new Entry(dye, ceilingBanner));
        }
    }
}
