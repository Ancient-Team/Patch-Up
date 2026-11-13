package com.ancient.patchup.block.another_furniture;

import com.starfish_studios.another_furniture.registry.AFRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import java.util.Collection;
import java.util.function.Supplier;

final class AFCompatRegistry {

    private AFCompatRegistry() {}

    static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        Supplier<T> supplier = AFRegistry.registerBlock(name, block);
        AFRegistry.registerItem(name, () -> new BlockItem(supplier.get(), new Item.Settings()), "tab");
        return supplier;
    }

    static <T extends Block> Supplier<T> registerBlockOnly(String name, Supplier<T> block) {
        return AFRegistry.registerBlock(name, block);
    }

    static void registerFlammables(Collection<Supplier<Block>> blocks) {
        for (Supplier<Block> block : blocks) {
            AFRegistry.setFlammable(block, 5, 20);
        }
    }
}
