package com.ancient.patchup.block.another_furniture;

import com.ninni.dye_depot.registry.DDDyes;
import com.starfish_studios.another_furniture.block.StoolBlock;
import com.starfish_studios.another_furniture.registry.AFBlocks;
import com.starfish_studios.another_furniture.registry.AFRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class Stool {
    public static final Map<DDDyes, Supplier<Block>> STOOLS = new EnumMap<>(DDDyes.class);

    private static Supplier<Block> registerStool(DDDyes dye) {
        String name = dye.asString() + "_stool";
        Supplier<Block> supplier = registerBlock(name, () -> new StoolBlock(AFBlocks.Properties.weak_wood));
        STOOLS.put(dye, supplier);
        return supplier;
    }

    public static final Supplier<Block> MAROON_STOOL = registerStool(DDDyes.MAROON);
    public static final Supplier<Block> ROSE_STOOL = registerStool(DDDyes.ROSE);
    public static final Supplier<Block> CORAL_STOOL = registerStool(DDDyes.CORAL);
    public static final Supplier<Block> GINGER_STOOL = registerStool(DDDyes.GINGER);
    public static final Supplier<Block> TAN_STOOL = registerStool(DDDyes.TAN);
    public static final Supplier<Block> BEIGE_STOOL = registerStool(DDDyes.BEIGE);
    public static final Supplier<Block> AMBER_STOOL = registerStool(DDDyes.AMBER);
    public static final Supplier<Block> OLIVE_STOOL = registerStool(DDDyes.OLIVE);
    public static final Supplier<Block> FOREST_STOOL = registerStool(DDDyes.FOREST);
    public static final Supplier<Block> VERDANT_STOOL = registerStool(DDDyes.VERDANT);
    public static final Supplier<Block> TEAL_STOOL = registerStool(DDDyes.TEAL);
    public static final Supplier<Block> MINT_STOOL = registerStool(DDDyes.MINT);
    public static final Supplier<Block> AQUA_STOOL = registerStool(DDDyes.AQUA);
    public static final Supplier<Block> SLATE_STOOL = registerStool(DDDyes.SLATE);
    public static final Supplier<Block> NAVY_STOOL = registerStool(DDDyes.NAVY);
    public static final Supplier<Block> INDIGO_STOOL = registerStool(DDDyes.INDIGO);

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
        for (Supplier<Block> stool : STOOLS.values()) {
            AFRegistry.setFlammable(stool, 5, 20);
        }
    }

    /**
     * @deprecated Use {@link #registerFlammables()} instead.
     */
    @Deprecated
    public static void registerFlammable() {
        registerFlammables();
    }

    public static void init() {}
}
