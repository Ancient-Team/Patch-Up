package com.ancient.patchup.block.another_furniture;

import com.ninni.dye_depot.registry.DDDyes;
import com.starfish_studios.another_furniture.block.CurtainBlock;
import com.starfish_studios.another_furniture.registry.AFBlocks;
import com.starfish_studios.another_furniture.registry.AFRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class Curtain {
    public static final Map<DDDyes, Supplier<Block>> CURTAINS = new EnumMap<>(DDDyes.class);

    private static Supplier<Block> registerCurtain(DDDyes dye) {
        String name = dye.asString() + "_curtain";
        Supplier<Block> supplier = registerBlock(name, () -> new CurtainBlock(AFBlocks.Properties.curtain));
        CURTAINS.put(dye, supplier);
        return supplier;
    }

    public static final Supplier<Block> MAROON_CURTAIN = registerCurtain(DDDyes.MAROON);
    public static final Supplier<Block> ROSE_CURTAIN = registerCurtain(DDDyes.ROSE);
    public static final Supplier<Block> CORAL_CURTAIN = registerCurtain(DDDyes.CORAL);
    public static final Supplier<Block> GINGER_CURTAIN = registerCurtain(DDDyes.GINGER);
    public static final Supplier<Block> TAN_CURTAIN = registerCurtain(DDDyes.TAN);
    public static final Supplier<Block> BEIGE_CURTAIN = registerCurtain(DDDyes.BEIGE);
    public static final Supplier<Block> AMBER_CURTAIN = registerCurtain(DDDyes.AMBER);
    public static final Supplier<Block> OLIVE_CURTAIN = registerCurtain(DDDyes.OLIVE);
    public static final Supplier<Block> FOREST_CURTAIN = registerCurtain(DDDyes.FOREST);
    public static final Supplier<Block> VERDANT_CURTAIN = registerCurtain(DDDyes.VERDANT);
    public static final Supplier<Block> TEAL_CURTAIN = registerCurtain(DDDyes.TEAL);
    public static final Supplier<Block> MINT_CURTAIN = registerCurtain(DDDyes.MINT);
    public static final Supplier<Block> AQUA_CURTAIN = registerCurtain(DDDyes.AQUA);
    public static final Supplier<Block> SLATE_CURTAIN = registerCurtain(DDDyes.SLATE);
    public static final Supplier<Block> NAVY_CURTAIN = registerCurtain(DDDyes.NAVY);
    public static final Supplier<Block> INDIGO_CURTAIN = registerCurtain(DDDyes.INDIGO);

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
        for (Supplier<Block> curtain : CURTAINS.values()) {
            AFRegistry.setFlammable(curtain, 5, 20);
        }
    }

    public static void init() {}
}