package com.ancient.patchup.block.farmers_delight;

import com.ancient.patchup.PatchUp;
import com.ninni.dye_depot.registry.DDDyes;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.HangingSignItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import vectorwing.farmersdelight.common.block.CeilingHangingCanvasSignBlock;
import vectorwing.farmersdelight.common.block.StandingCanvasSignBlock;
import vectorwing.farmersdelight.common.block.WallCanvasSignBlock;
import vectorwing.farmersdelight.common.block.WallHangingCanvasSignBlock;

import java.util.ArrayList;
import java.util.List;

public class CanvasSigns {

    public record CanvasSignEntry(
            DDDyes dye,
            Block standingSign,
            Block wallSign,
            Block ceilingHangingSign,
            Block wallHangingSign,
            Item signItem,
            Item hangingSignItem
    ) {}

    public static final List<CanvasSignEntry> ENTRIES = new ArrayList<>();

    public static void init() {
        if (!ENTRIES.isEmpty()) return;

        for (DDDyes dye : DDDyes.values()) {
            DyeColor dyeColor = dye.get();
            String name = dye.asString();

            Block standing = registerBlock(name + "_canvas_sign", new StandingCanvasSignBlock(dyeColor));
            Block wall = registerBlock(name + "_canvas_wall_sign",
                    new WallCanvasSignBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_WALL_SIGN).dropsLike(standing), dyeColor));

            Block ceiling = registerBlock(name + "_hanging_canvas_sign", new CeilingHangingCanvasSignBlock(dyeColor));
            Block wallHanging = registerBlock(name + "_wall_hanging_canvas_sign",
                    new WallHangingCanvasSignBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_WALL_HANGING_SIGN).dropsLike(ceiling), dyeColor));

            Item signItem = registerItem(name + "_canvas_sign",
                    new SignItem(new Item.Settings().maxCount(16), standing, wall));
            Item hangingSignItem = registerItem(name + "_hanging_canvas_sign",
                    new HangingSignItem(ceiling, wallHanging, new Item.Settings().maxCount(16)));

            vectorwing.farmersdelight.common.registry.ModBlockEntityTypes.CANVAS_SIGN.get().addSupportedBlock(standing);
            vectorwing.farmersdelight.common.registry.ModBlockEntityTypes.CANVAS_SIGN.get().addSupportedBlock(wall);
            vectorwing.farmersdelight.common.registry.ModBlockEntityTypes.HANGING_CANVAS_SIGN.get().addSupportedBlock(ceiling);
            vectorwing.farmersdelight.common.registry.ModBlockEntityTypes.HANGING_CANVAS_SIGN.get().addSupportedBlock(wallHanging);

            ENTRIES.add(new CanvasSignEntry(dye, standing, wall, ceiling, wallHanging, signItem, hangingSignItem));
        }
    }

    private static <T extends Block> T registerBlock(String name, T block) {
        return Registry.register(Registries.BLOCK, Identifier.of(PatchUp.MOD_ID, name), block);
    }

    private static <T extends Item> T registerItem(String name, T item) {
        return Registry.register(Registries.ITEM, Identifier.of(PatchUp.MOD_ID, name), item);
    }
}
