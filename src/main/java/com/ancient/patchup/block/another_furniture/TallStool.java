package com.ancient.patchup.block.another_furniture;

import com.ninni.dye_depot.registry.DDDyes;
import com.starfish_studios.another_furniture.block.TallStoolBlock;
import com.starfish_studios.another_furniture.registry.AFBlocks;
import com.starfish_studios.another_furniture.registry.AFRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class TallStool {
    public static final Map<DDDyes, Supplier<Block>> TALL_STOOLS = new EnumMap<>(DDDyes.class);

    private static Supplier<Block> registerTallStool(DDDyes dye) {
        String name = dye.asString() + "_tall_stool";
        Supplier<Block> supplier = registerBlock(name, () -> new TallStoolBlock(AFBlocks.Properties.weak_wood));
        TALL_STOOLS.put(dye, supplier);
        return supplier;
    }

    public static final Supplier<Block> MAROON_TALL_STOOL = registerTallStool(DDDyes.MAROON);
    public static final Supplier<Block> ROSE_TALL_STOOL = registerTallStool(DDDyes.ROSE);
    public static final Supplier<Block> CORAL_TALL_STOOL = registerTallStool(DDDyes.CORAL);
    public static final Supplier<Block> GINGER_TALL_STOOL = registerTallStool(DDDyes.GINGER);
    public static final Supplier<Block> TAN_TALL_STOOL = registerTallStool(DDDyes.TAN);
    public static final Supplier<Block> BEIGE_TALL_STOOL = registerTallStool(DDDyes.BEIGE);
    public static final Supplier<Block> AMBER_TALL_STOOL = registerTallStool(DDDyes.AMBER);
    public static final Supplier<Block> OLIVE_TALL_STOOL = registerTallStool(DDDyes.OLIVE);
    public static final Supplier<Block> FOREST_TALL_STOOL = registerTallStool(DDDyes.FOREST);
    public static final Supplier<Block> VERDANT_TALL_STOOL = registerTallStool(DDDyes.VERDANT);
    public static final Supplier<Block> TEAL_TALL_STOOL = registerTallStool(DDDyes.TEAL);
    public static final Supplier<Block> MINT_TALL_STOOL = registerTallStool(DDDyes.MINT);
    public static final Supplier<Block> AQUA_TALL_STOOL = registerTallStool(DDDyes.AQUA);
    public static final Supplier<Block> SLATE_TALL_STOOL = registerTallStool(DDDyes.SLATE);
    public static final Supplier<Block> NAVY_TALL_STOOL = registerTallStool(DDDyes.NAVY);
    public static final Supplier<Block> INDIGO_TALL_STOOL = registerTallStool(DDDyes.INDIGO);

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
        for (Supplier<Block> tallStool : TALL_STOOLS.values()) {
            AFRegistry.setFlammable(tallStool, 5, 20);
        }
    }

    public static void init() {}
}
