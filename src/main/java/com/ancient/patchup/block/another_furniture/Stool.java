package com.ancient.patchup.block.another_furniture;

import com.ninni.dye_depot.registry.DDDyes;
import com.starfish_studios.another_furniture.block.StoolBlock;
import com.starfish_studios.another_furniture.registry.AFBlocks;
import net.minecraft.block.Block;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class Stool {
    public static final Map<DDDyes, Supplier<Block>> STOOLS = new EnumMap<>(DDDyes.class);

    static {
        for (DDDyes dye : DDDyes.values()) {
            String name = dye.asString() + "_stool";
            STOOLS.put(dye, AFCompatRegistry.registerBlock(name, () -> new StoolBlock(AFBlocks.Properties.weak_wood)));
        }
    }

    public static void registerFlammables() {
        AFCompatRegistry.registerFlammables(STOOLS.values());
    }

    public static void init() {}
}
