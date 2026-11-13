package com.ancient.patchup.block.arts_and_crafts;

import com.kekecreations.arts_and_crafts.common.block.DyedDecoratedPotBlock;
import com.kekecreations.arts_and_crafts.common.block.DyedFlowerPotBlock;
import com.kekecreations.arts_and_crafts.common.item.DyedDecoratedPotBlockItem;
import com.kekecreations.arts_and_crafts.common.item.DyedFlowerPotBlockItem;
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
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

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

    private static <K, V> V requireEntry(Map<K, ? extends Supplier<? extends V>> map, K key, String name) {
        Supplier<? extends V> supplier = map.get(key);
        return Objects.requireNonNull(supplier, "Missing Arts & Crafts registry entry for " + name + " (" + key + ")").get();
    }

    public static void init() {
        if (!ENTRIES.isEmpty()) return;

        for (DDDyes dye : DDDyes.values()) {
            DyeColor color = dye.get();
            String name = dye.asString();
            int dyeId = dye.getId();

            // 1. Chalk & Chalk Dust & Chalk Stick
            Block chalk = requireEntry(ACBlocks.CHALK, dyeId, "chalk");
            Block chalkDust = requireEntry(ACBlocks.CHALK_DUST, dyeId, "chalk_dust");
            Item chalkStick = requireEntry(ACItems.CHALK_STICKS, dyeId, "chalk_stick");

            // 2. Paintbrush
            Item paintbrush = requireEntry(ACItems.PAINT_BRUSHES, color, "paintbrush");

            // 3. Plaster
            Block plaster = requireEntry(ACBlocks.DYED_PLASTER, color, "plaster");

            // 4. Pots
            Supplier<Block> potSupplier = ACBlocks.DYED_FLOWER_POTS.get(color);
            Supplier<DyedFlowerPotBlockItem> potItemSupplier = ACItems.FLOWER_POTS.get(dyeId);
            Block flowerPot;
            Item flowerPotItem;
            if (potSupplier != null && potItemSupplier != null) {
                flowerPot = potSupplier.get();
                flowerPotItem = potItemSupplier.get();
            } else {
                flowerPot = potSupplier != null ? potSupplier.get()
                        : Registry.register(Registries.BLOCK, Identifier.of("arts_and_crafts", name + "_flower_pot"),
                                new DyedFlowerPotBlock(AbstractBlock.Settings.copy(Blocks.FLOWER_POT)));
                flowerPotItem = Registry.register(Registries.ITEM, Identifier.of("arts_and_crafts", name + "_flower_pot"),
                        new DyedFlowerPotBlockItem(flowerPot, new Item.Settings()));

                if (potSupplier == null) {
                    ACBlocks.DYED_FLOWER_POTS.put(color, () -> flowerPot);
                    ACEntityTypes.CUSTOM_FLOWER_POT_BLOCK_ENTITY.get().addSupportedBlock(flowerPot);
                }
                ACItems.FLOWER_POTS.put(dyeId, () -> (DyedFlowerPotBlockItem) flowerPotItem);
            }

            Supplier<Block> decPotSupplier = ACBlocks.DYED_DECORATED_POTS.get(color);
            Supplier<DyedDecoratedPotBlockItem> decPotItemSupplier = ACItems.DYED_DECORATED_POT_BLOCK_ITEMS.get(color);
            Block decoratedPot;
            Item decoratedPotItem;
            if (decPotSupplier != null && decPotItemSupplier != null) {
                decoratedPot = decPotSupplier.get();
                decoratedPotItem = decPotItemSupplier.get();
            } else {
                decoratedPot = decPotSupplier != null ? decPotSupplier.get()
                        : Registry.register(Registries.BLOCK, Identifier.of("arts_and_crafts", name + "_decorated_pot"),
                                new DyedDecoratedPotBlock(color, AbstractBlock.Settings.copy(Blocks.DECORATED_POT)));
                decoratedPotItem = Registry.register(Registries.ITEM, Identifier.of("arts_and_crafts", name + "_decorated_pot"),
                        new DyedDecoratedPotBlockItem(decoratedPot, new Item.Settings().maxCount(1)));

                if (decPotSupplier == null) {
                    ACBlocks.DYED_DECORATED_POTS.put(color, () -> decoratedPot);
                    ACEntityTypes.CUSTOM_DECORATED_POT_BLOCK_ENTITY.get().addSupportedBlock(decoratedPot);
                }
                ACItems.DYED_DECORATED_POT_BLOCK_ITEMS.put(color, () -> (DyedDecoratedPotBlockItem) decoratedPotItem);
            }

            // 5. Mud Bricks
            Block mudBricks = requireEntry(ACBlocks.DYED_MUD_BRICKS, color, "mud_bricks");
            Block mudBrickSlab = requireEntry(ACBlocks.DYED_MUD_BRICK_SLAB, color, "mud_brick_slab");
            Block mudBrickStairs = requireEntry(ACBlocks.DYED_MUD_BRICK_STAIRS, color, "mud_brick_stairs");
            Block mudBrickWall = requireEntry(ACBlocks.DYED_MUD_BRICK_WALL, color, "mud_brick_wall");

            // 6. Terracotta Shingles
            Block terracottaShingles = requireEntry(ACBlocks.DYED_TERRACOTTA_SHINGLES, color, "terracotta_shingles");
            Block terracottaShingleSlab = requireEntry(ACBlocks.DYED_TERRACOTTA_SHINGLE_SLAB, color, "terracotta_shingle_slab");
            Block terracottaShingleStairs = requireEntry(ACBlocks.DYED_TERRACOTTA_SHINGLE_STAIRS, color, "terracotta_shingle_stairs");
            Block terracottaShingleWall = requireEntry(ACBlocks.DYED_TERRACOTTA_SHINGLE_WALL, color, "terracotta_shingle_wall");

            // 7. Soapstone
            Block soapstone = requireEntry(ACBlocks.DYED_SOAPSTONE, color, "soapstone");
            Block soapstoneSlab = requireEntry(ACBlocks.DYED_SOAPSTONE_SLAB, color, "soapstone_slab");
            Block soapstoneStairs = requireEntry(ACBlocks.DYED_SOAPSTONE_STAIRS, color, "soapstone_stairs");
            Block soapstoneWall = requireEntry(ACBlocks.DYED_SOAPSTONE_WALL, color, "soapstone_wall");

            // 8. Polished Soapstone
            Block polishedSoapstone = requireEntry(ACBlocks.DYED_POLISHED_SOAPSTONE, color, "polished_soapstone");
            Block polishedSoapstoneSlab = requireEntry(ACBlocks.DYED_POLISHED_SOAPSTONE_SLAB, color, "polished_soapstone_slab");
            Block polishedSoapstoneStairs = requireEntry(ACBlocks.DYED_POLISHED_SOAPSTONE_STAIRS, color, "polished_soapstone_stairs");
            Block polishedSoapstoneWall = requireEntry(ACBlocks.DYED_POLISHED_SOAPSTONE_WALL, color, "polished_soapstone_wall");

            // 9. Soapstone Bricks
            Block soapstoneBricks = requireEntry(ACBlocks.DYED_SOAPSTONE_BRICKS, color, "soapstone_bricks");
            Block soapstoneBrickSlab = requireEntry(ACBlocks.DYED_SOAPSTONE_BRICK_SLAB, color, "soapstone_brick_slab");
            Block soapstoneBrickStairs = requireEntry(ACBlocks.DYED_SOAPSTONE_BRICK_STAIRS, color, "soapstone_brick_stairs");
            Block soapstoneBrickWall = requireEntry(ACBlocks.DYED_SOAPSTONE_BRICK_WALL, color, "soapstone_brick_wall");

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
