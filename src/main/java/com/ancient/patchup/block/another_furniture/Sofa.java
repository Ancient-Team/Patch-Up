package com.ancient.patchup.block.another_furniture;

import com.ninni.dye_depot.registry.DDDyes;
import com.starfish_studios.another_furniture.block.SofaBlock;
import com.starfish_studios.another_furniture.registry.AFBlocks;
import com.starfish_studios.another_furniture.registry.AFRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class Sofa {
    public static final Map<DDDyes, Supplier<Block>> SOFAS = new EnumMap<>(DDDyes.class);

    private static Supplier<Block> registerSofa(DDDyes dye) {
        String name = dye.asString() + "_sofa";
        Supplier<Block> supplier = registerBlock(name, () -> new SofaBlock(AFBlocks.Properties.weak_wood));
        SOFAS.put(dye, supplier);
        return supplier;
    }

    public static final Supplier<Block> MAROON_SOFA = registerSofa(DDDyes.MAROON);
    public static final Supplier<Block> ROSE_SOFA = registerSofa(DDDyes.ROSE);
    public static final Supplier<Block> CORAL_SOFA = registerSofa(DDDyes.CORAL);
    public static final Supplier<Block> GINGER_SOFA = registerSofa(DDDyes.GINGER);
    public static final Supplier<Block> TAN_SOFA = registerSofa(DDDyes.TAN);
    public static final Supplier<Block> BEIGE_SOFA = registerSofa(DDDyes.BEIGE);
    public static final Supplier<Block> AMBER_SOFA = registerSofa(DDDyes.AMBER);
    public static final Supplier<Block> OLIVE_SOFA = registerSofa(DDDyes.OLIVE);
    public static final Supplier<Block> FOREST_SOFA = registerSofa(DDDyes.FOREST);
    public static final Supplier<Block> VERDANT_SOFA = registerSofa(DDDyes.VERDANT);
    public static final Supplier<Block> TEAL_SOFA = registerSofa(DDDyes.TEAL);
    public static final Supplier<Block> MINT_SOFA = registerSofa(DDDyes.MINT);
    public static final Supplier<Block> AQUA_SOFA = registerSofa(DDDyes.AQUA);
    public static final Supplier<Block> SLATE_SOFA = registerSofa(DDDyes.SLATE);
    public static final Supplier<Block> NAVY_SOFA = registerSofa(DDDyes.NAVY);
    public static final Supplier<Block> INDIGO_SOFA = registerSofa(DDDyes.INDIGO);

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
        for (Supplier<Block> sofa : SOFAS.values()) {
            AFRegistry.setFlammable(sofa, 5, 20);
        }
    }

    public static void init() {}
}
