package com.ancient.patchup.block.sleep_tight;

import com.ninni.dye_depot.registry.DDDyes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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

    private static Supplier<Block> lazyBlock(Identifier id) {
        return new Supplier<>() {
            private Block cached;

            @Override
            public Block get() {
                if (cached == null) {
                    Block resolved = Registries.BLOCK.get(id);
                    if (resolved != Blocks.AIR) {
                        cached = resolved;
                    }
                    return resolved;
                }
                return cached;
            }
        };
    }

    public static void init() {
        if (!ENTRIES.isEmpty()) return;

        for (DDDyes dye : DDDyes.values()) {
            Identifier id = Identifier.of("sleep_tight", "hammock_" + dye.asString());
            ENTRIES.add(new Entry(dye, lazyBlock(id)));
        }
    }
}
