package com.ancient.patchup.block.another_furniture;

import com.ancient.patchup.block.another_furniture.custom.LampBlock;
import com.ancient.patchup.block.another_furniture.custom.LampConnectorBlock;
import com.ninni.dye_depot.registry.DDDyes;
import com.starfish_studios.another_furniture.registry.AFBlocks;
import net.minecraft.block.Block;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class Lamp {
    public static final Map<DDDyes, Supplier<Block>> LAMPS = new EnumMap<>(DDDyes.class);
    public static final Map<DDDyes, Supplier<Block>> LAMP_CONNECTORS = new EnumMap<>(DDDyes.class);

    static {
        for (DDDyes dye : DDDyes.values()) {
            String lampName = dye.asString() + "_lamp";
            LAMPS.put(dye, AFCompatRegistry.registerBlock(lampName,
                    () -> new LampBlock(dye, () -> LAMP_CONNECTORS.get(dye).get(), AFBlocks.Properties.lamp)));

            String connectorName = dye.asString() + "_lamp_connector";
            LAMP_CONNECTORS.put(dye, AFCompatRegistry.registerBlockOnly(connectorName,
                    () -> new LampConnectorBlock(dye, () -> LAMPS.get(dye).get(), AFBlocks.Properties.weak_wood)));
        }
    }

    public static void registerFlammables() {
        AFCompatRegistry.registerFlammables(LAMPS.values());
        AFCompatRegistry.registerFlammables(LAMP_CONNECTORS.values());
    }

    public static void init() {}
}
