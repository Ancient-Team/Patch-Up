package com.ancient.patchup.block.arts_and_crafts;

import com.ancient.patchup.PatchUp;
import com.kekecreations.arts_and_crafts.common.block.ACFlowerPotBlock;
import com.kekecreations.arts_and_crafts.common.block.ChalkDustBlock;
import com.kekecreations.arts_and_crafts.common.block.DyedDecoratedPotBlock;
import com.kekecreations.arts_and_crafts.common.block.PlasterBlock;
import com.kekecreations.arts_and_crafts.common.item.ChalkStickItem;
import com.kekecreations.arts_and_crafts.common.item.DyedDecoratedPotBlockItem;
import com.kekecreations.arts_and_crafts.common.item.DyedFlowerPotBlockItem;
import com.kekecreations.arts_and_crafts.common.item.PaintbrushItem;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACEntityTypes;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import com.ninni.dye_depot.registry.DDDyes;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ArtsAndCraftsEntries {

    public record Entry(
            DDDyes dye,
            // Chalk
            Block chalk,
            Block chalkDust,
            Item chalkStick,
            // Paintbrush
            Item paintbrush,
            // Plaster
            Block plaster,
            // Pots
            Block flowerPot,
            Item flowerPotItem,
            Block decoratedPot,
            Item decoratedPotItem,
            // Mud Bricks
            Block mudBricks,
            Block mudBrickSlab,
            Block mudBrickStairs,
            Block mudBrickWall,
            // Terracotta Shingles
            Block terracottaShingles,
            Block terracottaShingleSlab,
            Block terracottaShingleStairs,
            Block terracottaShingleWall,
            // Soapstone
            Block soapstone,
            Block soapstoneSlab,
            Block soapstoneStairs,
            Block soapstoneWall,
            // Polished Soapstone
            Block polishedSoapstone,
            Block polishedSoapstoneSlab,
            Block polishedSoapstoneStairs,
            Block polishedSoapstoneWall,
            // Soapstone Bricks
            Block soapstoneBricks,
            Block soapstoneBrickSlab,
            Block soapstoneBrickStairs,
            Block soapstoneBrickWall
    ) {}

    public static final List<Entry> ENTRIES = new ArrayList<>();

    public static void init() {
        if (!ENTRIES.isEmpty()) return;

        for (DDDyes dye : DDDyes.values()) {
            DyeColor color = dye.get();
            String name = dye.asString();
            int dyeId = dye.getId();

            // 1. Chalk & Chalk Dust & Chalk Stick
            Block chalk = registerBlockWithItem(name + "_chalk",
                    new Block(AbstractBlock.Settings.copy(Blocks.CALCITE).mapColor(dye.getMapColor()).sounds(BlockSoundGroup.CALCITE)));
            Block chalkDust = registerBlockOnly(name + "_chalk_dust",
                    new ChalkDustBlock(dyeId, AbstractBlock.Settings.copy(Blocks.REDSTONE_WIRE).mapColor(dye.getMapColor())));
            Item chalkStick = registerItem(name + "_chalk_stick",
                    new ChalkStickItem(dyeId, new Item.Settings()));

            // 2. Paintbrush
            Item paintbrush = registerItem(name + "_paintbrush",
                    new PaintbrushItem(new Item.Settings().maxDamage(64)));

            // 3. Plaster
            Block plaster = registerBlockWithItem(name + "_plaster",
                    new PlasterBlock(color, AbstractBlock.Settings.copy(Blocks.WHITE_CONCRETE).mapColor(dye.getMapColor())));

            // 4. Pots
            Block flowerPot = registerBlockOnly(name + "_flower_pot",
                    new ACFlowerPotBlock(Blocks.AIR, color, AbstractBlock.Settings.copy(Blocks.FLOWER_POT)));
            Item flowerPotItem = registerItem(name + "_flower_pot",
                    new DyedFlowerPotBlockItem(flowerPot, new Item.Settings()));

            Block decoratedPot = registerBlockOnly(name + "_decorated_pot",
                    new DyedDecoratedPotBlock(color, AbstractBlock.Settings.copy(Blocks.DECORATED_POT)));
            Item decoratedPotItem = registerItem(name + "_decorated_pot",
                    new DyedDecoratedPotBlockItem(decoratedPot, new Item.Settings().maxCount(1)));

            // 5. Mud Bricks
            Block mudBricks = registerBlockWithItem(name + "_mud_bricks",
                    new Block(AbstractBlock.Settings.copy(Blocks.MUD_BRICKS).mapColor(dye.getMapColor())));
            Block mudBrickSlab = registerBlockWithItem(name + "_mud_brick_slab",
                    new SlabBlock(AbstractBlock.Settings.copy(mudBricks)));
            Block mudBrickStairs = registerBlockWithItem(name + "_mud_brick_stairs",
                    new StairsBlock(mudBricks.getDefaultState(), AbstractBlock.Settings.copy(mudBricks)));
            Block mudBrickWall = registerBlockWithItem(name + "_mud_brick_wall",
                    new WallBlock(AbstractBlock.Settings.copy(mudBricks)));

            // 6. Terracotta Shingles
            Block terracottaShingles = registerBlockWithItem(name + "_terracotta_shingles",
                    new Block(AbstractBlock.Settings.copy(Blocks.TERRACOTTA).mapColor(dye.getMapColor()).sounds(BlockSoundGroup.STONE)));
            Block terracottaShingleSlab = registerBlockWithItem(name + "_terracotta_shingle_slab",
                    new SlabBlock(AbstractBlock.Settings.copy(terracottaShingles)));
            Block terracottaShingleStairs = registerBlockWithItem(name + "_terracotta_shingle_stairs",
                    new StairsBlock(terracottaShingles.getDefaultState(), AbstractBlock.Settings.copy(terracottaShingles)));
            Block terracottaShingleWall = registerBlockWithItem(name + "_terracotta_shingle_wall",
                    new WallBlock(AbstractBlock.Settings.copy(terracottaShingles)));

            // 7. Soapstone
            Block soapstone = registerBlockWithItem(name + "_soapstone",
                    new Block(AbstractBlock.Settings.copy(Blocks.STONE).mapColor(dye.getMapColor())));
            Block soapstoneSlab = registerBlockWithItem(name + "_soapstone_slab",
                    new SlabBlock(AbstractBlock.Settings.copy(soapstone)));
            Block soapstoneStairs = registerBlockWithItem(name + "_soapstone_stairs",
                    new StairsBlock(soapstone.getDefaultState(), AbstractBlock.Settings.copy(soapstone)));
            Block soapstoneWall = registerBlockWithItem(name + "_soapstone_wall",
                    new WallBlock(AbstractBlock.Settings.copy(soapstone)));

            // 8. Polished Soapstone
            Block polishedSoapstone = registerBlockWithItem(name + "_polished_soapstone",
                    new Block(AbstractBlock.Settings.copy(Blocks.POLISHED_ANDESITE).mapColor(dye.getMapColor())));
            Block polishedSoapstoneSlab = registerBlockWithItem(name + "_polished_soapstone_slab",
                    new SlabBlock(AbstractBlock.Settings.copy(polishedSoapstone)));
            Block polishedSoapstoneStairs = registerBlockWithItem(name + "_polished_soapstone_stairs",
                    new StairsBlock(polishedSoapstone.getDefaultState(), AbstractBlock.Settings.copy(polishedSoapstone)));
            Block polishedSoapstoneWall = registerBlockWithItem(name + "_polished_soapstone_wall",
                    new WallBlock(AbstractBlock.Settings.copy(polishedSoapstone)));

            // 9. Soapstone Bricks
            Block soapstoneBricks = registerBlockWithItem(name + "_soapstone_bricks",
                    new Block(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS).mapColor(dye.getMapColor())));
            Block soapstoneBrickSlab = registerBlockWithItem(name + "_soapstone_brick_slab",
                    new SlabBlock(AbstractBlock.Settings.copy(soapstoneBricks)));
            Block soapstoneBrickStairs = registerBlockWithItem(name + "_soapstone_brick_stairs",
                    new StairsBlock(soapstoneBricks.getDefaultState(), AbstractBlock.Settings.copy(soapstoneBricks)));
            Block soapstoneBrickWall = registerBlockWithItem(name + "_soapstone_brick_wall",
                    new WallBlock(AbstractBlock.Settings.copy(soapstoneBricks)));

            // Connect to Arts & Crafts registry lookups
            ACBlocks.CHALK.put(dyeId, () -> chalk);
            ACBlocks.CHALK_DUST.put(dyeId, () -> chalkDust);
            ACItems.CHALK_STICKS.put(dyeId, () -> (ChalkStickItem) chalkStick);
            ACItems.PAINT_BRUSHES.put(color, () -> (PaintbrushItem) paintbrush);
            ACBlocks.DYED_PLASTER.put(color, () -> plaster);

            ACBlocks.DYED_FLOWER_POTS.put(color, () -> flowerPot);
            ACItems.FLOWER_POTS.put(dyeId, () -> (DyedFlowerPotBlockItem) flowerPotItem);
            ACFlowerPotBlock.addPotManually(color, Blocks.AIR, flowerPot);

            ACBlocks.DYED_DECORATED_POTS.put(color, () -> decoratedPot);
            ACItems.DYED_DECORATED_POT_BLOCK_ITEMS.put(color, () -> (DyedDecoratedPotBlockItem) decoratedPotItem);
            ACEntityTypes.CUSTOM_DECORATED_POT_BLOCK_ENTITY.get().addSupportedBlock(decoratedPot);

            ACBlocks.DYED_MUD_BRICKS.put(color, () -> mudBricks);
            ACBlocks.DYED_MUD_BRICK_SLAB.put(color, () -> mudBrickSlab);
            ACBlocks.DYED_MUD_BRICK_STAIRS.put(color, () -> mudBrickStairs);
            ACBlocks.DYED_MUD_BRICK_WALL.put(color, () -> mudBrickWall);

            ACBlocks.DYED_TERRACOTTA_SHINGLES.put(color, () -> terracottaShingles);
            ACBlocks.DYED_TERRACOTTA_SHINGLE_SLAB.put(color, () -> terracottaShingleSlab);
            ACBlocks.DYED_TERRACOTTA_SHINGLE_STAIRS.put(color, () -> terracottaShingleStairs);
            ACBlocks.DYED_TERRACOTTA_SHINGLE_WALL.put(color, () -> terracottaShingleWall);

            ACBlocks.DYED_SOAPSTONE.put(color, () -> soapstone);
            ACBlocks.DYED_SOAPSTONE_SLAB.put(color, () -> soapstoneSlab);
            ACBlocks.DYED_SOAPSTONE_STAIRS.put(color, () -> soapstoneStairs);
            ACBlocks.DYED_SOAPSTONE_WALL.put(color, () -> soapstoneWall);

            ACBlocks.DYED_POLISHED_SOAPSTONE.put(color, () -> polishedSoapstone);
            ACBlocks.DYED_POLISHED_SOAPSTONE_SLAB.put(color, () -> polishedSoapstoneSlab);
            ACBlocks.DYED_POLISHED_SOAPSTONE_STAIRS.put(color, () -> polishedSoapstoneStairs);
            ACBlocks.DYED_POLISHED_SOAPSTONE_WALL.put(color, () -> polishedSoapstoneWall);

            ACBlocks.DYED_SOAPSTONE_BRICKS.put(color, () -> soapstoneBricks);
            ACBlocks.DYED_SOAPSTONE_BRICK_SLAB.put(color, () -> soapstoneBrickSlab);
            ACBlocks.DYED_SOAPSTONE_BRICK_STAIRS.put(color, () -> soapstoneBrickStairs);
            ACBlocks.DYED_SOAPSTONE_BRICK_WALL.put(color, () -> soapstoneBrickWall);

            ENTRIES.add(new Entry(
                    dye, chalk, chalkDust, chalkStick, paintbrush, plaster,
                    flowerPot, flowerPotItem, decoratedPot, decoratedPotItem,
                    mudBricks, mudBrickSlab, mudBrickStairs, mudBrickWall,
                    terracottaShingles, terracottaShingleSlab, terracottaShingleStairs, terracottaShingleWall,
                    soapstone, soapstoneSlab, soapstoneStairs, soapstoneWall,
                    polishedSoapstone, polishedSoapstoneSlab, polishedSoapstoneStairs, polishedSoapstoneWall,
                    soapstoneBricks, soapstoneBrickSlab, soapstoneBrickStairs, soapstoneBrickWall
            ));
        }
    }

    private static <T extends Block> T registerBlockOnly(String name, T block) {
        return Registry.register(Registries.BLOCK, Identifier.of(PatchUp.MOD_ID, name), block);
    }

    private static <T extends Block> T registerBlockWithItem(String name, T block) {
        T registered = Registry.register(Registries.BLOCK, Identifier.of(PatchUp.MOD_ID, name), block);
        Registry.register(Registries.ITEM, Identifier.of(PatchUp.MOD_ID, name), new BlockItem(registered, new Item.Settings()));
        return registered;
    }

    private static <T extends Item> T registerItem(String name, T item) {
        return Registry.register(Registries.ITEM, Identifier.of(PatchUp.MOD_ID, name), item);
    }
}
