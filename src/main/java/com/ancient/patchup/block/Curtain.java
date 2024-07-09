package com.ancient.patchup.block;

import com.starfish_studios.another_furniture.block.CurtainBlock;
import com.starfish_studios.another_furniture.registry.AFBlocks;
import com.starfish_studios.another_furniture.registry.AFRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import java.util.function.Supplier;

public class Curtain {

    public static final Supplier<Block> MAROON_CURTAIN = registerBlock("maroon_curtain", () -> new CurtainBlock(AFBlocks.Properties.curtain));
    public static final Supplier<Block> ROSE_CURTAIN = registerBlock("rose_curtain", () -> new CurtainBlock(AFBlocks.Properties.curtain));

    public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        Supplier<T> supplier = AFRegistry.registerBlock(name, block);
        AFRegistry.registerItem(name, () -> new BlockItem(supplier.get(), new Item.Settings()), "tab");
        return supplier;
}


    public static <T extends Block> Supplier<T> registerBlockHidden(String name, Supplier<T> block) {
    Supplier<T> supplier = AFRegistry.registerBlock(name, block);
    AFRegistry.registerItem(name, () -> new BlockItem(supplier.get(), new Item.Settings()), null);
    return supplier;
}

    public static <T extends Block> Supplier<T> registerBlockOnly(String name, Supplier<T> block) {
    return AFRegistry.registerBlock(name, block);
}
    public static void registerFlammables() {
    //AFRegistry.setFlammable(MAROON_LAMP, 5, 20);

}
    public static void init() {}
}