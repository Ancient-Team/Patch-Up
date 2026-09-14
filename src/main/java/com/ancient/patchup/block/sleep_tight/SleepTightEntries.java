package com.ancient.patchup.block.sleep_tight;

import com.ninni.dye_depot.registry.DDDyes;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SleepTightEntries {

    public record Entry(
            DDDyes dye,
            Supplier<? extends Block> hammock
    ) {}

    public static final List<Entry> ENTRIES = new ArrayList<>();

    public static void init() {
        if (!ENTRIES.isEmpty()) return;

        for (DDDyes dye : DDDyes.values()) {
            Identifier id = Identifier.of("sleep_tight", "hammock_" + dye.asString());
            Supplier<? extends Block> hammock = () -> Registries.BLOCK.get(id);

            ENTRIES.add(new Entry(dye, hammock));
        }
    }
}
