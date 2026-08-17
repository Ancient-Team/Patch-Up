package com.ancient.patchup.block.arts_and_crafts;

import com.kekecreations.arts_and_crafts.common.block.DyedDecoratedPotBlock;
import com.kekecreations.arts_and_crafts.common.item.DyedDecoratedPotBlockItem;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACEntityTypes;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import com.ninni.dye_depot.registry.DDDyes;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
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
            Block chalk = ACBlocks.CHALK.get(dyeId).get();
            Block chalkDust = ACBlocks.CHALK_DUST.get(dyeId).get();
            Item chalkStick = ACItems.CHALK_STICKS.get(dyeId).get();

            // 2. Paintbrush
            Item paintbrush = ACItems.PAINT_BRUSHES.get(color).get();

            // 3. Plaster
            Block plaster = ACBlocks.DYED_PLASTER.get(color).get();

            // 4. Pots
            Block flowerPot = ACBlocks.DYED_FLOWER_POTS.get(color).get();
            Item flowerPotItem = ACItems.FLOWER_POTS.get(dyeId).get();

            Block decoratedPot = Registry.register(Registries.BLOCK, Identifier.of("arts_and_crafts", name + "_decorated_pot"),
                    new DyedDecoratedPotBlock(color, AbstractBlock.Settings.copy(Blocks.DECORATED_POT)));
            Item decoratedPotItem = Registry.register(Registries.ITEM, Identifier.of("arts_and_crafts", name + "_decorated_pot"),
                    new DyedDecoratedPotBlockItem(decoratedPot, new Item.Settings().maxCount(1)));

            ACBlocks.DYED_DECORATED_POTS.put(color, () -> decoratedPot);
            ACItems.DYED_DECORATED_POT_BLOCK_ITEMS.put(color, () -> (DyedDecoratedPotBlockItem) decoratedPotItem);
            ACEntityTypes.CUSTOM_DECORATED_POT_BLOCK_ENTITY.get().addSupportedBlock(decoratedPot);

            // 5. Mud Bricks
            Block mudBricks = ACBlocks.DYED_MUD_BRICKS.get(color).get();
            Block mudBrickSlab = ACBlocks.DYED_MUD_BRICK_SLAB.get(color).get();
            Block mudBrickStairs = ACBlocks.DYED_MUD_BRICK_STAIRS.get(color).get();
            Block mudBrickWall = ACBlocks.DYED_MUD_BRICK_WALL.get(color).get();

            // 6. Terracotta Shingles
            Block terracottaShingles = ACBlocks.DYED_TERRACOTTA_SHINGLES.get(color).get();
            Block terracottaShingleSlab = ACBlocks.DYED_TERRACOTTA_SHINGLE_SLAB.get(color).get();
            Block terracottaShingleStairs = ACBlocks.DYED_TERRACOTTA_SHINGLE_STAIRS.get(color).get();
            Block terracottaShingleWall = ACBlocks.DYED_TERRACOTTA_SHINGLE_WALL.get(color).get();

            // 7. Soapstone
            Block soapstone = ACBlocks.DYED_SOAPSTONE.get(color).get();
            Block soapstoneSlab = ACBlocks.DYED_SOAPSTONE_SLAB.get(color).get();
            Block soapstoneStairs = ACBlocks.DYED_SOAPSTONE_STAIRS.get(color).get();
            Block soapstoneWall = ACBlocks.DYED_SOAPSTONE_WALL.get(color).get();

            // 8. Polished Soapstone
            Block polishedSoapstone = ACBlocks.DYED_POLISHED_SOAPSTONE.get(color).get();
            Block polishedSoapstoneSlab = ACBlocks.DYED_POLISHED_SOAPSTONE_SLAB.get(color).get();
            Block polishedSoapstoneStairs = ACBlocks.DYED_POLISHED_SOAPSTONE_STAIRS.get(color).get();
            Block polishedSoapstoneWall = ACBlocks.DYED_POLISHED_SOAPSTONE_WALL.get(color).get();

            // 9. Soapstone Bricks
            Block soapstoneBricks = ACBlocks.DYED_SOAPSTONE_BRICKS.get(color).get();
            Block soapstoneBrickSlab = ACBlocks.DYED_SOAPSTONE_BRICK_SLAB.get(color).get();
            Block soapstoneBrickStairs = ACBlocks.DYED_SOAPSTONE_BRICK_STAIRS.get(color).get();
            Block soapstoneBrickWall = ACBlocks.DYED_SOAPSTONE_BRICK_WALL.get(color).get();

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
}
