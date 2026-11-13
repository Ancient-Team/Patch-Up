package com.ancient.patchup.block.another_furniture;

import com.ninni.dye_depot.registry.DDDyes;
import com.starfish_studios.another_furniture.block.SofaBlock;
import com.starfish_studios.another_furniture.registry.AFBlocks;
import net.minecraft.block.Block;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class Sofa {
    public static final Map<DDDyes, Supplier<Block>> SOFAS = new EnumMap<>(DDDyes.class);

    static {
        for (DDDyes dye : DDDyes.values()) {
            String name = dye.asString() + "_sofa";
            SOFAS.put(dye, AFCompatRegistry.registerBlock(name, () -> new SofaBlock(AFBlocks.Properties.weak_wood)));
        }
    }

    public static void registerFlammables() {
        AFCompatRegistry.registerFlammables(SOFAS.values());
    }

    public static void init() {}
}
