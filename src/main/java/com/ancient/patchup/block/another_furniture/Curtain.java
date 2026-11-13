package com.ancient.patchup.block.another_furniture;

import com.ninni.dye_depot.registry.DDDyes;
import com.starfish_studios.another_furniture.block.CurtainBlock;
import com.starfish_studios.another_furniture.registry.AFBlocks;
import net.minecraft.block.Block;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class Curtain {
    public static final Map<DDDyes, Supplier<Block>> CURTAINS = new EnumMap<>(DDDyes.class);

    static {
        for (DDDyes dye : DDDyes.values()) {
            String name = dye.asString() + "_curtain";
            CURTAINS.put(dye, AFCompatRegistry.registerBlock(name, () -> new CurtainBlock(AFBlocks.Properties.curtain)));
        }
    }

    public static void registerFlammables() {
        AFCompatRegistry.registerFlammables(CURTAINS.values());
    }

    public static void init() {}
}
