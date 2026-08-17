package com.ancient.patchup.block.another_furniture;

import com.ancient.patchup.block.another_furniture.custom.LampBlock;
import com.ancient.patchup.block.another_furniture.custom.LampConnectorBlock;
import com.ninni.dye_depot.registry.DDDyes;
import com.starfish_studios.another_furniture.registry.AFBlocks;
import com.starfish_studios.another_furniture.registry.AFRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class Lamp {
    public static final Map<DDDyes, Supplier<Block>> LAMPS = new EnumMap<>(DDDyes.class);
    public static final Map<DDDyes, Supplier<Block>> LAMP_CONNECTORS = new EnumMap<>(DDDyes.class);

    private static Supplier<Block> registerLamp(DDDyes dye) {
        String name = dye.asString() + "_lamp";
        Supplier<Block> supplier = registerBlock(name, () -> new LampBlock(dye, () -> LAMP_CONNECTORS.get(dye).get(), AFBlocks.Properties.lamp));
        LAMPS.put(dye, supplier);
        return supplier;
    }

    private static Supplier<Block> registerConnector(DDDyes dye) {
        String name = dye.asString() + "_lamp_connector";
        Supplier<Block> supplier = registerBlockOnly(name, () -> new LampConnectorBlock(dye, () -> LAMPS.get(dye).get(), AFBlocks.Properties.weak_wood));
        LAMP_CONNECTORS.put(dye, supplier);
        return supplier;
    }

    // Static fields for backward compatibility
    public static final Supplier<Block> MAROON_LAMP = registerLamp(DDDyes.MAROON);
    public static final Supplier<Block> ROSE_LAMP = registerLamp(DDDyes.ROSE);
    public static final Supplier<Block> CORAL_LAMP = registerLamp(DDDyes.CORAL);
    public static final Supplier<Block> GINGER_LAMP = registerLamp(DDDyes.GINGER);
    public static final Supplier<Block> TAN_LAMP = registerLamp(DDDyes.TAN);
    public static final Supplier<Block> BEIGE_LAMP = registerLamp(DDDyes.BEIGE);
    public static final Supplier<Block> AMBER_LAMP = registerLamp(DDDyes.AMBER);
    public static final Supplier<Block> OLIVE_LAMP = registerLamp(DDDyes.OLIVE);
    public static final Supplier<Block> FOREST_LAMP = registerLamp(DDDyes.FOREST);
    public static final Supplier<Block> VERDANT_LAMP = registerLamp(DDDyes.VERDANT);
    public static final Supplier<Block> TEAL_LAMP = registerLamp(DDDyes.TEAL);
    public static final Supplier<Block> MINT_LAMP = registerLamp(DDDyes.MINT);
    public static final Supplier<Block> AQUA_LAMP = registerLamp(DDDyes.AQUA);
    public static final Supplier<Block> SLATE_LAMP = registerLamp(DDDyes.SLATE);
    public static final Supplier<Block> NAVY_LAMP = registerLamp(DDDyes.NAVY);
    public static final Supplier<Block> INDIGO_LAMP = registerLamp(DDDyes.INDIGO);

    public static final Supplier<Block> MAROON_LAMP_CONNECTOR = registerConnector(DDDyes.MAROON);
    public static final Supplier<Block> ROSE_LAMP_CONNECTOR = registerConnector(DDDyes.ROSE);
    public static final Supplier<Block> CORAL_LAMP_CONNECTOR = registerConnector(DDDyes.CORAL);
    public static final Supplier<Block> GINGER_LAMP_CONNECTOR = registerConnector(DDDyes.GINGER);
    public static final Supplier<Block> TAN_LAMP_CONNECTOR = registerConnector(DDDyes.TAN);
    public static final Supplier<Block> BEIGE_LAMP_CONNECTOR = registerConnector(DDDyes.BEIGE);
    public static final Supplier<Block> AMBER_LAMP_CONNECTOR = registerConnector(DDDyes.AMBER);
    public static final Supplier<Block> OLIVE_LAMP_CONNECTOR = registerConnector(DDDyes.OLIVE);
    public static final Supplier<Block> FOREST_LAMP_CONNECTOR = registerConnector(DDDyes.FOREST);
    public static final Supplier<Block> VERDANT_LAMP_CONNECTOR = registerConnector(DDDyes.VERDANT);
    public static final Supplier<Block> TEAL_LAMP_CONNECTOR = registerConnector(DDDyes.TEAL);
    public static final Supplier<Block> MINT_LAMP_CONNECTOR = registerConnector(DDDyes.MINT);
    public static final Supplier<Block> AQUA_LAMP_CONNECTOR = registerConnector(DDDyes.AQUA);
    public static final Supplier<Block> SLATE_LAMP_CONNECTOR = registerConnector(DDDyes.SLATE);
    public static final Supplier<Block> NAVY_LAMP_CONNECTOR = registerConnector(DDDyes.NAVY);
    public static final Supplier<Block> INDIGO_LAMP_CONNECTOR = registerConnector(DDDyes.INDIGO);

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

    public static Block getLampConnectorByColor(DDDyes color) {
        Supplier<Block> supplier = LAMP_CONNECTORS.get(color);
        return supplier != null ? supplier.get() : null;
    }

    public static Block getLampByColor(DDDyes color) {
        Supplier<Block> supplier = LAMPS.get(color);
        return supplier != null ? supplier.get() : null;
    }

    public static void registerFlammables() {
        for (Supplier<Block> lamp : LAMPS.values()) {
            AFRegistry.setFlammable(lamp, 5, 20);
        }
        for (Supplier<Block> connector : LAMP_CONNECTORS.values()) {
            AFRegistry.setFlammable(connector, 5, 20);
        }
    }

    public static void init() {}
}
