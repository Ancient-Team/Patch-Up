package com.ancient.patchup.datagen;

import com.ancient.patchup.block.Trims;
import com.ancient.patchup.block.heart_and_home.*;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class ModModelProvider extends FabricModelProvider {


    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        /* Built */
        blockStateModelGenerator.registerSimpleCubeAll(Trims.MAROON_TERRACOTTA_TRIM);
        blockStateModelGenerator.registerSimpleCubeAll(Trims.ROSE_TERRACOTTA_TRIM);
        blockStateModelGenerator.registerSimpleCubeAll(Trims.CORAL_TERRACOTTA_TRIM);
        blockStateModelGenerator.registerSimpleCubeAll(Trims.GINGER_TERRACOTTA_TRIM);
        blockStateModelGenerator.registerSimpleCubeAll(Trims.TAN_TERRACOTTA_TRIM);
        blockStateModelGenerator.registerSimpleCubeAll(Trims.BEIGE_TERRACOTTA_TRIM);
        blockStateModelGenerator.registerSimpleCubeAll(Trims.AMBER_TERRACOTTA_TRIM);
        blockStateModelGenerator.registerSimpleCubeAll(Trims.OLIVE_TERRACOTTA_TRIM);
        blockStateModelGenerator.registerSimpleCubeAll(Trims.FOREST_TERRACOTTA_TRIM);
        blockStateModelGenerator.registerSimpleCubeAll(Trims.VERDANT_TERRACOTTA_TRIM);
        blockStateModelGenerator.registerSimpleCubeAll(Trims.TEAL_TERRACOTTA_TRIM);
        blockStateModelGenerator.registerSimpleCubeAll(Trims.MINT_TERRACOTTA_TRIM);
        blockStateModelGenerator.registerSimpleCubeAll(Trims.AQUA_TERRACOTTA_TRIM);
        blockStateModelGenerator.registerSimpleCubeAll(Trims.SLATE_TERRACOTTA_TRIM);
        blockStateModelGenerator.registerSimpleCubeAll(Trims.NAVY_TERRACOTTA_TRIM);
        blockStateModelGenerator.registerSimpleCubeAll(Trims.INDIGO_TERRACOTTA_TRIM);

        blockStateModelGenerator.registerSimpleCubeAll(PaperLantern.MAROON_PAPER_LANTERN);
        blockStateModelGenerator.registerSimpleCubeAll(PaperLantern.ROSE_PAPER_LANTERN);
        blockStateModelGenerator.registerSimpleCubeAll(PaperLantern.CORAL_PAPER_LANTERN);
        blockStateModelGenerator.registerSimpleCubeAll(PaperLantern.GINGER_PAPER_LANTERN);
        blockStateModelGenerator.registerSimpleCubeAll(PaperLantern.TAN_PAPER_LANTERN);
        blockStateModelGenerator.registerSimpleCubeAll(PaperLantern.BEIGE_PAPER_LANTERN);
        blockStateModelGenerator.registerSimpleCubeAll(PaperLantern.AMBER_PAPER_LANTERN);
        blockStateModelGenerator.registerSimpleCubeAll(PaperLantern.OLIVE_PAPER_LANTERN);
        blockStateModelGenerator.registerSimpleCubeAll(PaperLantern.FOREST_PAPER_LANTERN);
        blockStateModelGenerator.registerSimpleCubeAll(PaperLantern.VERDANT_PAPER_LANTERN);
        blockStateModelGenerator.registerSimpleCubeAll(PaperLantern.TEAL_PAPER_LANTERN);
        blockStateModelGenerator.registerSimpleCubeAll(PaperLantern.MINT_PAPER_LANTERN);
        blockStateModelGenerator.registerSimpleCubeAll(PaperLantern.AQUA_PAPER_LANTERN);
        blockStateModelGenerator.registerSimpleCubeAll(PaperLantern.SLATE_PAPER_LANTERN);
        blockStateModelGenerator.registerSimpleCubeAll(PaperLantern.NAVY_PAPER_LANTERN);
        blockStateModelGenerator.registerSimpleCubeAll(PaperLantern.INDIGO_PAPER_LANTERN);

        BlockStateModelGenerator.BlockTexturePool MaroonShinglesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Shingles.MAROON_SHINGLES);
        BlockStateModelGenerator.BlockTexturePool RoseShinglesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Shingles.ROSE_SHINGLES);
        BlockStateModelGenerator.BlockTexturePool CoralShinglesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Shingles.CORAL_SHINGLES);
        BlockStateModelGenerator.BlockTexturePool GingerShinglesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Shingles.GINGER_SHINGLES);
        BlockStateModelGenerator.BlockTexturePool TanShinglesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Shingles.TAN_SHINGLES);
        BlockStateModelGenerator.BlockTexturePool BeigeShinglesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Shingles.BEIGE_SHINGLES);
        BlockStateModelGenerator.BlockTexturePool AmberShinglesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Shingles.AMBER_SHINGLES);
        BlockStateModelGenerator.BlockTexturePool OliveShinglesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Shingles.OLIVE_SHINGLES);
        BlockStateModelGenerator.BlockTexturePool ForestShinglesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Shingles.FOREST_SHINGLES);
        BlockStateModelGenerator.BlockTexturePool VerdantShinglesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Shingles.VERDANT_SHINGLES);
        BlockStateModelGenerator.BlockTexturePool TealShinglesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Shingles.TEAL_SHINGLES);
        BlockStateModelGenerator.BlockTexturePool MintShinglesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Shingles.MINT_SHINGLES);
        BlockStateModelGenerator.BlockTexturePool AquaShinglesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Shingles.AQUA_SHINGLES);
        BlockStateModelGenerator.BlockTexturePool SlateShinglesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Shingles.SLATE_SHINGLES);
        BlockStateModelGenerator.BlockTexturePool NavyShinglesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Shingles.NAVY_SHINGLES);
        BlockStateModelGenerator.BlockTexturePool IndigoShinglesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Shingles.INDIGO_SHINGLES);

        blockStateModelGenerator.registerGlassPane(StainedBarredGlass.MAROON_STAINED_BARRED_GLASS, StainedBarredGlassPane.MAROON_STAINED_BARRED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(StainedBarredGlass.ROSE_STAINED_BARRED_GLASS, StainedBarredGlassPane.ROSE_STAINED_BARRED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(StainedBarredGlass.CORAL_STAINED_BARRED_GLASS, StainedBarredGlassPane.CORAL_STAINED_BARRED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(StainedBarredGlass.GINGER_STAINED_BARRED_GLASS, StainedBarredGlassPane.GINGER_STAINED_BARRED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(StainedBarredGlass.TAN_STAINED_BARRED_GLASS, StainedBarredGlassPane.TAN_STAINED_BARRED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(StainedBarredGlass.BEIGE_STAINED_BARRED_GLASS, StainedBarredGlassPane.BEIGE_STAINED_BARRED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(StainedBarredGlass.AMBER_STAINED_BARRED_GLASS, StainedBarredGlassPane.AMBER_STAINED_BARRED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(StainedBarredGlass.OLIVE_STAINED_BARRED_GLASS, StainedBarredGlassPane.OLIVE_STAINED_BARRED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(StainedBarredGlass.FOREST_STAINED_BARRED_GLASS, StainedBarredGlassPane.FOREST_STAINED_BARRED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(StainedBarredGlass.VERDANT_STAINED_BARRED_GLASS, StainedBarredGlassPane.VERDANT_STAINED_BARRED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(StainedBarredGlass.TEAL_STAINED_BARRED_GLASS, StainedBarredGlassPane.TEAL_STAINED_BARRED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(StainedBarredGlass.MINT_STAINED_BARRED_GLASS, StainedBarredGlassPane.MINT_STAINED_BARRED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(StainedBarredGlass.AQUA_STAINED_BARRED_GLASS, StainedBarredGlassPane.AQUA_STAINED_BARRED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(StainedBarredGlass.SLATE_STAINED_BARRED_GLASS, StainedBarredGlassPane.SLATE_STAINED_BARRED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(StainedBarredGlass.NAVY_STAINED_BARRED_GLASS, StainedBarredGlassPane.NAVY_STAINED_BARRED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(StainedBarredGlass.INDIGO_STAINED_BARRED_GLASS, StainedBarredGlassPane.INDIGO_STAINED_BARRED_GLASS_PANE);

        BlockStateModelGenerator.BlockTexturePool MaroonTerracottaBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(TerracottaBricks.MAROON_TERRACOTTA_BRICKS);
        BlockStateModelGenerator.BlockTexturePool RoseTerracottaBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(TerracottaBricks.ROSE_TERRACOTTA_BRICKS);
        BlockStateModelGenerator.BlockTexturePool CoralTerracottaBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(TerracottaBricks.CORAL_TERRACOTTA_BRICKS);
        BlockStateModelGenerator.BlockTexturePool GingerTerracottaBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(TerracottaBricks.GINGER_TERRACOTTA_BRICKS);
        BlockStateModelGenerator.BlockTexturePool TanTerracottaBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(TerracottaBricks.TAN_TERRACOTTA_BRICKS);
        BlockStateModelGenerator.BlockTexturePool BeigeTerracottaBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(TerracottaBricks.BEIGE_TERRACOTTA_BRICKS);
        BlockStateModelGenerator.BlockTexturePool AmberTerracottaBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(TerracottaBricks.AMBER_TERRACOTTA_BRICKS);
        BlockStateModelGenerator.BlockTexturePool OliveTerracottaBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(TerracottaBricks.OLIVE_TERRACOTTA_BRICKS);
        BlockStateModelGenerator.BlockTexturePool ForestTerracottaBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(TerracottaBricks.FOREST_TERRACOTTA_BRICKS);
        BlockStateModelGenerator.BlockTexturePool VerdantTerracottaBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(TerracottaBricks.VERDANT_TERRACOTTA_BRICKS);
        BlockStateModelGenerator.BlockTexturePool TealTerracottaBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(TerracottaBricks.TEAL_TERRACOTTA_BRICKS);
        BlockStateModelGenerator.BlockTexturePool MintTerracottaBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(TerracottaBricks.MINT_TERRACOTTA_BRICKS);
        BlockStateModelGenerator.BlockTexturePool AquaTerracottaBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(TerracottaBricks.AQUA_TERRACOTTA_BRICKS);
        BlockStateModelGenerator.BlockTexturePool SlateTerracottaBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(TerracottaBricks.SLATE_TERRACOTTA_BRICKS);
        BlockStateModelGenerator.BlockTexturePool NavyTerracottaBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(TerracottaBricks.NAVY_TERRACOTTA_BRICKS);
        BlockStateModelGenerator.BlockTexturePool IndigoTerracottaBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(TerracottaBricks.INDIGO_TERRACOTTA_BRICKS);

        BlockStateModelGenerator.BlockTexturePool MaroonTilesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Tiles.MAROON_TILES);
        BlockStateModelGenerator.BlockTexturePool RoseTilesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Tiles.ROSE_TILES);
        BlockStateModelGenerator.BlockTexturePool CoralTilesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Tiles.CORAL_TILES);
        BlockStateModelGenerator.BlockTexturePool GingerTilesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Tiles.GINGER_TILES);
        BlockStateModelGenerator.BlockTexturePool TanTilesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Tiles.TAN_TILES);
        BlockStateModelGenerator.BlockTexturePool BeigeTilesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Tiles.BEIGE_TILES);
        BlockStateModelGenerator.BlockTexturePool AmberTilesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Tiles.AMBER_TILES);
        BlockStateModelGenerator.BlockTexturePool OliveTilesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Tiles.OLIVE_TILES);
        BlockStateModelGenerator.BlockTexturePool ForestTilesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Tiles.FOREST_TILES);
        BlockStateModelGenerator.BlockTexturePool VerdantTilesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Tiles.VERDANT_TILES);
        BlockStateModelGenerator.BlockTexturePool TealTilesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Tiles.TEAL_TILES);
        BlockStateModelGenerator.BlockTexturePool MintTilesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Tiles.MINT_TILES);
        BlockStateModelGenerator.BlockTexturePool AquaTilesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Tiles.AQUA_TILES);
        BlockStateModelGenerator.BlockTexturePool SlateTilesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Tiles.SLATE_TILES);
        BlockStateModelGenerator.BlockTexturePool NavyTilesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Tiles.NAVY_TILES);
        BlockStateModelGenerator.BlockTexturePool IndigoTilesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Tiles.INDIGO_TILES);

        MaroonShinglesPool.stairs(Shingles.MAROON_SHINGLE_STAIRS);
        MaroonShinglesPool.slab(Shingles.MAROON_SHINGLE_SLAB);

        MaroonTerracottaBricksPool.stairs(TerracottaBricks.MAROON_TERRACOTTA_BRICK_STAIRS);
        MaroonTerracottaBricksPool.slab(TerracottaBricks.MAROON_TERRACOTTA_BRICK_SLAB);

        MaroonTilesPool.slab(Tiles.MAROON_TILE_SLAB);

        RoseShinglesPool.stairs(Shingles.ROSE_SHINGLE_STAIRS);
        RoseShinglesPool.slab(Shingles.ROSE_SHINGLE_SLAB);

        RoseTerracottaBricksPool.stairs(TerracottaBricks.ROSE_TERRACOTTA_BRICK_STAIRS);
        RoseTerracottaBricksPool.slab(TerracottaBricks.ROSE_TERRACOTTA_BRICK_SLAB);

        RoseTilesPool.slab(Tiles.ROSE_TILE_SLAB);

        CoralShinglesPool.stairs(Shingles.CORAL_SHINGLE_STAIRS);
        CoralShinglesPool.slab(Shingles.CORAL_SHINGLE_SLAB);

        CoralTerracottaBricksPool.stairs(TerracottaBricks.CORAL_TERRACOTTA_BRICK_STAIRS);
        CoralTerracottaBricksPool.slab(TerracottaBricks.CORAL_TERRACOTTA_BRICK_SLAB);

        CoralTilesPool.slab(Tiles.CORAL_TILE_SLAB);

        GingerShinglesPool.stairs(Shingles.GINGER_SHINGLE_STAIRS);
        GingerShinglesPool.slab(Shingles.GINGER_SHINGLE_SLAB);

        GingerTerracottaBricksPool.stairs(TerracottaBricks.GINGER_TERRACOTTA_BRICK_STAIRS);
        GingerTerracottaBricksPool.slab(TerracottaBricks.GINGER_TERRACOTTA_BRICK_SLAB);

        GingerTilesPool.slab(Tiles.GINGER_TILE_SLAB);

        TanShinglesPool.stairs(Shingles.TAN_SHINGLE_STAIRS);
        TanShinglesPool.slab(Shingles.TAN_SHINGLE_SLAB);

        TanTerracottaBricksPool.stairs(TerracottaBricks.TAN_TERRACOTTA_BRICK_STAIRS);
        TanTerracottaBricksPool.slab(TerracottaBricks.TAN_TERRACOTTA_BRICK_SLAB);

        TanTilesPool.slab(Tiles.TAN_TILE_SLAB);

        BeigeShinglesPool.stairs(Shingles.BEIGE_SHINGLE_STAIRS);
        BeigeShinglesPool.slab(Shingles.BEIGE_SHINGLE_SLAB);

        BeigeTerracottaBricksPool.stairs(TerracottaBricks.BEIGE_TERRACOTTA_BRICK_STAIRS);
        BeigeTerracottaBricksPool.slab(TerracottaBricks.BEIGE_TERRACOTTA_BRICK_SLAB);

        BeigeTilesPool.slab(Tiles.BEIGE_TILE_SLAB);

        AmberShinglesPool.stairs(Shingles.AMBER_SHINGLE_STAIRS);
        AmberShinglesPool.slab(Shingles.AMBER_SHINGLE_SLAB);

        AmberTerracottaBricksPool.stairs(TerracottaBricks.AMBER_TERRACOTTA_BRICK_STAIRS);
        AmberTerracottaBricksPool.slab(TerracottaBricks.AMBER_TERRACOTTA_BRICK_SLAB);

        AmberTilesPool.slab(Tiles.AMBER_TILE_SLAB);

        OliveShinglesPool.stairs(Shingles.OLIVE_SHINGLE_STAIRS);
        OliveShinglesPool.slab(Shingles.OLIVE_SHINGLE_SLAB);

        OliveTerracottaBricksPool.stairs(TerracottaBricks.OLIVE_TERRACOTTA_BRICK_STAIRS);
        OliveTerracottaBricksPool.slab(TerracottaBricks.OLIVE_TERRACOTTA_BRICK_SLAB);

        OliveTilesPool.slab(Tiles.OLIVE_TILE_SLAB);

        ForestShinglesPool.stairs(Shingles.FOREST_SHINGLE_STAIRS);
        ForestShinglesPool.slab(Shingles.FOREST_SHINGLE_SLAB);

        ForestTerracottaBricksPool.stairs(TerracottaBricks.FOREST_TERRACOTTA_BRICK_STAIRS);
        ForestTerracottaBricksPool.slab(TerracottaBricks.FOREST_TERRACOTTA_BRICK_SLAB);

        ForestTilesPool.slab(Tiles.FOREST_TILE_SLAB);

        VerdantShinglesPool.stairs(Shingles.VERDANT_SHINGLE_STAIRS);
        VerdantShinglesPool.slab(Shingles.VERDANT_SHINGLE_SLAB);

        VerdantTerracottaBricksPool.stairs(TerracottaBricks.VERDANT_TERRACOTTA_BRICK_STAIRS);
        VerdantTerracottaBricksPool.slab(TerracottaBricks.VERDANT_TERRACOTTA_BRICK_SLAB);

        VerdantTilesPool.slab(Tiles.VERDANT_TILE_SLAB);

        TealShinglesPool.stairs(Shingles.TEAL_SHINGLE_STAIRS);
        TealShinglesPool.slab(Shingles.TEAL_SHINGLE_SLAB);

        TealTerracottaBricksPool.stairs(TerracottaBricks.TEAL_TERRACOTTA_BRICK_STAIRS);
        TealTerracottaBricksPool.slab(TerracottaBricks.TEAL_TERRACOTTA_BRICK_SLAB);

        TealTilesPool.slab(Tiles.TEAL_TILE_SLAB);

        MintShinglesPool.stairs(Shingles.MINT_SHINGLE_STAIRS);
        MintShinglesPool.slab(Shingles.MINT_SHINGLE_SLAB);

        MintTerracottaBricksPool.stairs(TerracottaBricks.MINT_TERRACOTTA_BRICK_STAIRS);
        MintTerracottaBricksPool.slab(TerracottaBricks.MINT_TERRACOTTA_BRICK_SLAB);

        MintTilesPool.slab(Tiles.MINT_TILE_SLAB);

        AquaShinglesPool.stairs(Shingles.AQUA_SHINGLE_STAIRS);
        AquaShinglesPool.slab(Shingles.AQUA_SHINGLE_SLAB);

        AquaTerracottaBricksPool.stairs(TerracottaBricks.AQUA_TERRACOTTA_BRICK_STAIRS);
        AquaTerracottaBricksPool.slab(TerracottaBricks.AQUA_TERRACOTTA_BRICK_SLAB);

        AquaTilesPool.slab(Tiles.AQUA_TILE_SLAB);

        SlateShinglesPool.stairs(Shingles.SLATE_SHINGLE_STAIRS);
        SlateShinglesPool.slab(Shingles.SLATE_SHINGLE_SLAB);

        SlateTerracottaBricksPool.stairs(TerracottaBricks.SLATE_TERRACOTTA_BRICK_STAIRS);
        SlateTerracottaBricksPool.slab(TerracottaBricks.SLATE_TERRACOTTA_BRICK_SLAB);

        SlateTilesPool.slab(Tiles.SLATE_TILE_SLAB);

        NavyShinglesPool.stairs(Shingles.NAVY_SHINGLE_STAIRS);
        NavyShinglesPool.slab(Shingles.NAVY_SHINGLE_SLAB);

        NavyTerracottaBricksPool.stairs(TerracottaBricks.NAVY_TERRACOTTA_BRICK_STAIRS);
        NavyTerracottaBricksPool.slab(TerracottaBricks.NAVY_TERRACOTTA_BRICK_SLAB);

        NavyTilesPool.slab(Tiles.NAVY_TILE_SLAB);

        IndigoShinglesPool.stairs(Shingles.INDIGO_SHINGLE_STAIRS);
        IndigoShinglesPool.slab(Shingles.INDIGO_SHINGLE_SLAB);

        IndigoTerracottaBricksPool.stairs(TerracottaBricks.INDIGO_TERRACOTTA_BRICK_STAIRS);
        IndigoTerracottaBricksPool.slab(TerracottaBricks.INDIGO_TERRACOTTA_BRICK_SLAB);

        IndigoTilesPool.slab(Tiles.INDIGO_TILE_SLAB);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
}
