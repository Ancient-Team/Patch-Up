package com.ancient.patchup.datagen;

import com.ancient.patchup.block.farmers_delight.CanvasSigns;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        CanvasSigns.init();
        Identifier canvasSignModelId = Identifier.of("farmersdelight", "block/canvas_sign");

        for (CanvasSigns.CanvasSignEntry entry : CanvasSigns.ENTRIES) {
            blockStateModelGenerator.blockStateCollector.accept(
                    BlockStateModelGenerator.createSingletonBlockState(entry.standingSign(), canvasSignModelId));
            blockStateModelGenerator.blockStateCollector.accept(
                    BlockStateModelGenerator.createSingletonBlockState(entry.wallSign(), canvasSignModelId));
            blockStateModelGenerator.blockStateCollector.accept(
                    BlockStateModelGenerator.createSingletonBlockState(entry.ceilingHangingSign(), canvasSignModelId));
            blockStateModelGenerator.blockStateCollector.accept(
                    BlockStateModelGenerator.createSingletonBlockState(entry.wallHangingSign(), canvasSignModelId));
        }

        /* Arts & Crafts */
        com.ancient.patchup.block.arts_and_crafts.ArtsAndCraftsEntries.init();
        for (com.ancient.patchup.block.arts_and_crafts.ArtsAndCraftsEntries.Entry entry : com.ancient.patchup.block.arts_and_crafts.ArtsAndCraftsEntries.ENTRIES) {
            blockStateModelGenerator.registerSimpleCubeAll(entry.chalk());

            var mudBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(entry.mudBricks());
            mudBricksPool.slab(entry.mudBrickSlab());
            mudBricksPool.stairs(entry.mudBrickStairs());
            mudBricksPool.wall(entry.mudBrickWall());

            var terracottaShinglesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(entry.terracottaShingles());
            terracottaShinglesPool.slab(entry.terracottaShingleSlab());
            terracottaShinglesPool.stairs(entry.terracottaShingleStairs());
            terracottaShinglesPool.wall(entry.terracottaShingleWall());

            var soapstonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(entry.soapstone());
            soapstonePool.slab(entry.soapstoneSlab());
            soapstonePool.stairs(entry.soapstoneStairs());
            soapstonePool.wall(entry.soapstoneWall());

            var polishedSoapstonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(entry.polishedSoapstone());
            polishedSoapstonePool.slab(entry.polishedSoapstoneSlab());
            polishedSoapstonePool.stairs(entry.polishedSoapstoneStairs());
            polishedSoapstonePool.wall(entry.polishedSoapstoneWall());

            var soapstoneBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(entry.soapstoneBricks());
            soapstoneBricksPool.slab(entry.soapstoneBrickSlab());
            soapstoneBricksPool.stairs(entry.soapstoneBrickStairs());
            soapstoneBricksPool.wall(entry.soapstoneBrickWall());
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        CanvasSigns.init();
        for (CanvasSigns.CanvasSignEntry entry : CanvasSigns.ENTRIES) {
            itemModelGenerator.register(entry.signItem(), Models.GENERATED);
            itemModelGenerator.register(entry.hangingSignItem(), Models.GENERATED);
        }
    }
}
