package com.ancient.patchup.block.snowy_spirit;

import com.ninni.dye_depot.registry.DDDyes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
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

    public static void init() {
        if (!ENTRIES.isEmpty()) return;

        for (DDDyes dye : DDDyes.values()) {
            Identifier glowId = Identifier.of("snowyspirit", "glow_lights_" + dye.asString());
            Identifier gumdropId = Identifier.of("snowyspirit", "gumdrop_" + dye.asString());

            Supplier<? extends Block> glowLightsBlock = () -> Registries.BLOCK.get(glowId);
            Supplier<? extends Item> glowLightsItem = () -> Registries.ITEM.get(glowId);
            Supplier<? extends Block> gumdrop = () -> Registries.BLOCK.get(gumdropId);

            ENTRIES.add(new Entry(
                    dye, glowLightsBlock, glowLightsItem, gumdrop
            ));
        }
    }
}
