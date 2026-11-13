package com.ancient.patchup.block.snowy_spirit;

import com.ninni.dye_depot.registry.DDDyes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SnowySpiritEntries {

    public record Entry(
            DDDyes dye,
            Supplier<? extends Block> glowLightsBlock,
            Supplier<? extends Item> glowLightsItem,
            Supplier<? extends Block> gumdrop
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

    private static Supplier<Item> lazyItem(Identifier id) {
        return new Supplier<>() {
            private Item cached;

            @Override
            public Item get() {
                if (cached == null) {
                    Item resolved = Registries.ITEM.get(id);
                    if (resolved != Items.AIR) {
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
            Identifier glowId = Identifier.of("snowyspirit", "glow_lights_" + dye.asString());
            Identifier gumdropId = Identifier.of("snowyspirit", "gumdrop_" + dye.asString());

            ENTRIES.add(new Entry(
                    dye, lazyBlock(glowId), lazyItem(glowId), lazyBlock(gumdropId)
            ));
        }
    }
}
