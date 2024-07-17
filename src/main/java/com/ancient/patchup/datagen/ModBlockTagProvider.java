package com.ancient.patchup.datagen;

import com.ancient.patchup.block.*;
import com.ancient.patchup.block.another_furniture.*;
import com.ancient.patchup.block.heart_and_home.Shingles;
import com.ancient.patchup.block.heart_and_home.Terracotta_Bricks;
import com.ancient.patchup.block.heart_and_home.Tiles;
import com.starfish_studios.another_furniture.registry.AFBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        this.getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                /* Built */
                .add(Trims.MAROON_TERRACOTTA_TRIM, Trims.ROSE_TERRACOTTA_TRIM, Trims.CORAL_TERRACOTTA_TRIM,
                        Trims.GINGER_TERRACOTTA_TRIM, Trims.TAN_TERRACOTTA_TRIM, Trims.BEIGE_TERRACOTTA_TRIM,
                        Trims.AMBER_TERRACOTTA_TRIM, Trims.OLIVE_TERRACOTTA_TRIM, Trims.FOREST_TERRACOTTA_TRIM,
                        Trims.VERDANT_TERRACOTTA_TRIM, Trims.TEAL_TERRACOTTA_TRIM, Trims.MINT_TERRACOTTA_TRIM,
                        Trims.AQUA_TERRACOTTA_TRIM, Trims.SLATE_TERRACOTTA_TRIM, Trims.NAVY_TERRACOTTA_TRIM,
                        Trims.INDIGO_TERRACOTTA_TRIM, Shingles.MAROON_SHINGLES, Shingles.MAROON_SHINGLE_STAIRS, Shingles.MAROON_SHINGLE_SLAB, Shingles.ROSE_SHINGLES, Shingles.ROSE_SHINGLE_STAIRS, Shingles.ROSE_SHINGLE_SLAB,
                        Shingles.CORAL_SHINGLES, Shingles.CORAL_SHINGLE_STAIRS, Shingles.CORAL_SHINGLE_SLAB, Shingles.GINGER_SHINGLES, Shingles.GINGER_SHINGLE_STAIRS, Shingles.GINGER_SHINGLE_SLAB, Shingles.TAN_SHINGLES,
                        Shingles.TAN_SHINGLE_STAIRS, Shingles.TAN_SHINGLE_SLAB, Shingles.BEIGE_SHINGLES, Shingles.BEIGE_SHINGLE_STAIRS, Shingles.BEIGE_SHINGLE_SLAB, Shingles.AMBER_SHINGLES, Shingles.AMBER_SHINGLE_STAIRS,
                        Shingles.AMBER_SHINGLE_SLAB, Shingles.OLIVE_SHINGLES, Shingles.OLIVE_SHINGLE_STAIRS, Shingles.OLIVE_SHINGLE_SLAB, Shingles.FOREST_SHINGLES, Shingles.FOREST_SHINGLE_STAIRS, Shingles.FOREST_SHINGLE_SLAB,
                        Shingles.VERDANT_SHINGLES, Shingles.VERDANT_SHINGLE_STAIRS, Shingles.VERDANT_SHINGLE_SLAB, Shingles.TEAL_SHINGLES, Shingles.TEAL_SHINGLE_STAIRS, Shingles.TEAL_SHINGLE_SLAB, Shingles.MINT_SHINGLES,
                        Shingles.MINT_SHINGLE_STAIRS, Shingles.MINT_SHINGLE_SLAB, Shingles.AQUA_SHINGLES, Shingles.AQUA_SHINGLE_STAIRS, Shingles.AQUA_SHINGLE_SLAB, Shingles.SLATE_SHINGLES, Shingles.SLATE_SHINGLE_STAIRS,
                        Shingles.SLATE_SHINGLE_SLAB, Shingles.NAVY_SHINGLES, Shingles.NAVY_SHINGLE_STAIRS, Shingles.NAVY_SHINGLE_SLAB, Shingles.INDIGO_SHINGLES, Shingles.INDIGO_SHINGLE_STAIRS, Shingles.INDIGO_SHINGLE_SLAB,
                        Terracotta_Bricks.MAROON_TERRACOTTA_BRICKS,Terracotta_Bricks.MAROON_TERRACOTTA_BRICK_STAIRS,Terracotta_Bricks.MAROON_TERRACOTTA_BRICK_SLAB, Terracotta_Bricks.ROSE_TERRACOTTA_BRICKS,
                        Terracotta_Bricks.ROSE_TERRACOTTA_BRICK_STAIRS, Terracotta_Bricks.ROSE_TERRACOTTA_BRICK_SLAB, Terracotta_Bricks.CORAL_TERRACOTTA_BRICKS, Terracotta_Bricks.CORAL_TERRACOTTA_BRICK_STAIRS,
                        Terracotta_Bricks.CORAL_TERRACOTTA_BRICK_SLAB, Terracotta_Bricks.GINGER_TERRACOTTA_BRICKS, Terracotta_Bricks.GINGER_TERRACOTTA_BRICK_STAIRS, Terracotta_Bricks.GINGER_TERRACOTTA_BRICK_SLAB,
                        Terracotta_Bricks.TAN_TERRACOTTA_BRICKS, Terracotta_Bricks.TAN_TERRACOTTA_BRICK_STAIRS, Terracotta_Bricks.TAN_TERRACOTTA_BRICK_SLAB, Terracotta_Bricks.BEIGE_TERRACOTTA_BRICKS,
                        Terracotta_Bricks.BEIGE_TERRACOTTA_BRICK_STAIRS, Terracotta_Bricks.BEIGE_TERRACOTTA_BRICK_SLAB, Terracotta_Bricks.AMBER_TERRACOTTA_BRICKS, Terracotta_Bricks.AMBER_TERRACOTTA_BRICK_STAIRS,
                        Terracotta_Bricks.AMBER_TERRACOTTA_BRICK_SLAB, Terracotta_Bricks.OLIVE_TERRACOTTA_BRICKS, Terracotta_Bricks.OLIVE_TERRACOTTA_BRICK_STAIRS, Terracotta_Bricks.OLIVE_TERRACOTTA_BRICK_SLAB,
                        Terracotta_Bricks.FOREST_TERRACOTTA_BRICKS, Terracotta_Bricks.FOREST_TERRACOTTA_BRICK_STAIRS, Terracotta_Bricks.FOREST_TERRACOTTA_BRICK_SLAB, Terracotta_Bricks.VERDANT_TERRACOTTA_BRICKS,
                        Terracotta_Bricks.VERDANT_TERRACOTTA_BRICK_STAIRS, Terracotta_Bricks.VERDANT_TERRACOTTA_BRICK_SLAB, Terracotta_Bricks.TEAL_TERRACOTTA_BRICKS, Terracotta_Bricks.TEAL_TERRACOTTA_BRICK_STAIRS,
                        Terracotta_Bricks.TEAL_TERRACOTTA_BRICK_SLAB, Terracotta_Bricks.MINT_TERRACOTTA_BRICKS, Terracotta_Bricks.MINT_TERRACOTTA_BRICK_STAIRS, Terracotta_Bricks.MINT_TERRACOTTA_BRICK_SLAB,
                        Terracotta_Bricks.AQUA_TERRACOTTA_BRICKS, Terracotta_Bricks.AQUA_TERRACOTTA_BRICK_STAIRS, Terracotta_Bricks.AQUA_TERRACOTTA_BRICK_SLAB, Terracotta_Bricks.SLATE_TERRACOTTA_BRICKS,
                        Terracotta_Bricks.SLATE_TERRACOTTA_BRICK_STAIRS, Terracotta_Bricks.SLATE_TERRACOTTA_BRICK_SLAB, Terracotta_Bricks.NAVY_TERRACOTTA_BRICKS, Terracotta_Bricks.NAVY_TERRACOTTA_BRICK_STAIRS,
                        Terracotta_Bricks.NAVY_TERRACOTTA_BRICK_SLAB, Terracotta_Bricks.INDIGO_TERRACOTTA_BRICKS, Terracotta_Bricks.INDIGO_TERRACOTTA_BRICK_STAIRS, Terracotta_Bricks.INDIGO_TERRACOTTA_BRICK_SLAB,
                        Tiles.MAROON_TILES,Tiles.MAROON_TILE_SLAB,Tiles.ROSE_TILES,Tiles.ROSE_TILE_SLAB,Tiles.CORAL_TILES,Tiles.CORAL_TILE_SLAB,Tiles.GINGER_TILES,Tiles.GINGER_TILE_SLAB,Tiles.TAN_TILES,Tiles.TAN_TILE_SLAB,
                        Tiles.BEIGE_TILES,Tiles.BEIGE_TILE_SLAB,Tiles.AMBER_TILES,Tiles.AMBER_TILE_SLAB,Tiles.OLIVE_TILES,Tiles.OLIVE_TILE_SLAB,Tiles.FOREST_TILES,Tiles.FOREST_TILE_SLAB,Tiles.VERDANT_TILES,Tiles.VERDANT_TILE_SLAB,
                        Tiles.TEAL_TILES,Tiles.TEAL_TILE_SLAB,Tiles.MINT_TILES,Tiles.MINT_TILE_SLAB,Tiles.AQUA_TILES,Tiles.AQUA_TILE_SLAB,Tiles.SLATE_TILES,Tiles.SLATE_TILE_SLAB,Tiles.NAVY_TILES,Tiles.NAVY_TILE_SLAB,Tiles.INDIGO_TILES,
                        Tiles.INDIGO_TILE_SLAB);
                /* Another Furniture */
        this.getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(Stool.MAROON_STOOL.get(), Stool.ROSE_STOOL.get(), Stool.CORAL_STOOL.get(), Stool.GINGER_STOOL.get(), Stool.TAN_STOOL.get(), Stool.BEIGE_STOOL.get(), Stool.AMBER_STOOL.get(), Stool.OLIVE_STOOL.get(),
                     Stool.FOREST_STOOL.get(), Stool.VERDANT_STOOL.get(), Stool.TEAL_STOOL.get(), Stool.MINT_STOOL.get(), Stool.AQUA_STOOL.get(), Stool.SLATE_STOOL.get(), Stool.NAVY_STOOL.get(), Stool.INDIGO_STOOL.get(),
                     TallStool.MAROON_TALL_STOOL.get(), TallStool.ROSE_TALL_STOOL.get(), TallStool.CORAL_TALL_STOOL.get(), TallStool.GINGER_TALL_STOOL.get(), TallStool.TAN_TALL_STOOL.get(), TallStool.BEIGE_TALL_STOOL.get(),
                     TallStool.AMBER_TALL_STOOL.get(), TallStool.OLIVE_TALL_STOOL.get(), TallStool.FOREST_TALL_STOOL.get(), TallStool.VERDANT_TALL_STOOL.get(), TallStool.TEAL_TALL_STOOL.get(), TallStool.MINT_TALL_STOOL.get(),
                     TallStool.AQUA_TALL_STOOL.get(), TallStool.SLATE_TALL_STOOL.get(), TallStool.NAVY_TALL_STOOL.get(), TallStool.INDIGO_TALL_STOOL.get(),
                     Sofa.MAROON_SOFA.get(), Sofa.ROSE_SOFA.get(), Sofa.CORAL_SOFA.get(), Sofa.GINGER_SOFA.get(), Sofa.TAN_SOFA.get(), Sofa.BEIGE_SOFA.get(), Sofa.AMBER_SOFA.get(), Sofa.OLIVE_SOFA.get(),
                     Sofa.FOREST_SOFA.get(), Sofa.VERDANT_SOFA.get(), Sofa.TEAL_SOFA.get(), Sofa.MINT_SOFA.get(), Sofa.AQUA_SOFA.get(), Sofa.SLATE_SOFA.get(), Sofa.NAVY_SOFA.get(), Sofa.INDIGO_SOFA.get(),
                     Lamp.MAROON_LAMP.get(), Lamp.ROSE_LAMP.get(), Lamp.CORAL_LAMP.get(), Lamp.GINGER_LAMP.get(), Lamp.TAN_LAMP.get(), Lamp.BEIGE_LAMP.get(), Lamp.AMBER_LAMP.get(), Lamp.OLIVE_LAMP.get(),
                     Lamp.FOREST_LAMP.get(), Lamp.VERDANT_LAMP.get(), Lamp.TEAL_LAMP.get(), Lamp.MINT_LAMP.get(), Lamp.AQUA_LAMP.get(), Lamp.SLATE_LAMP.get(), Lamp.NAVY_LAMP.get(), Lamp.INDIGO_LAMP.get(),
                     Curtain.MAROON_CURTAIN.get(), Curtain.ROSE_CURTAIN.get(), Curtain.CORAL_CURTAIN.get(), Curtain.GINGER_CURTAIN.get(), Curtain.TAN_CURTAIN.get(), Curtain.BEIGE_CURTAIN.get(), Curtain.AMBER_CURTAIN.get(),
                     Curtain.OLIVE_CURTAIN.get(), Curtain.FOREST_CURTAIN.get(), Curtain.VERDANT_CURTAIN.get(), Curtain.TEAL_CURTAIN.get(), Curtain.MINT_CURTAIN.get(), Curtain.AQUA_CURTAIN.get(), Curtain.SLATE_CURTAIN.get(),
                     Curtain.NAVY_CURTAIN.get(), Curtain.INDIGO_CURTAIN.get());
                /* Stool */
        this.getOrCreateTagBuilder(AFBlockTags.STOOLS)
                .add(Stool.MAROON_STOOL.get())
                .add(Stool.ROSE_STOOL.get())
                .add(Stool.CORAL_STOOL.get())
                .add(Stool.GINGER_STOOL.get())
                .add(Stool.TAN_STOOL.get())
                .add(Stool.BEIGE_STOOL.get())
                .add(Stool.AMBER_STOOL.get())
                .add(Stool.OLIVE_STOOL.get())
                .add(Stool.FOREST_STOOL.get())
                .add(Stool.VERDANT_STOOL.get())
                .add(Stool.TEAL_STOOL.get())
                .add(Stool.MINT_STOOL.get())
                .add(Stool.AQUA_STOOL.get())
                .add(Stool.SLATE_STOOL.get())
                .add(Stool.NAVY_STOOL.get())
                .add(Stool.INDIGO_STOOL.get());

                /* Tall Stool */
        this.getOrCreateTagBuilder(AFBlockTags.TALL_STOOLS)
                .add(TallStool.MAROON_TALL_STOOL.get())
                .add(TallStool.ROSE_TALL_STOOL.get())
                .add(TallStool.CORAL_TALL_STOOL.get())
                .add(TallStool.GINGER_TALL_STOOL.get())
                .add(TallStool.TAN_TALL_STOOL.get())
                .add(TallStool.BEIGE_TALL_STOOL.get())
                .add(TallStool.AMBER_TALL_STOOL.get())
                .add(TallStool.OLIVE_TALL_STOOL.get())
                .add(TallStool.FOREST_TALL_STOOL.get())
                .add(TallStool.VERDANT_TALL_STOOL.get())
                .add(TallStool.TEAL_TALL_STOOL.get())
                .add(TallStool.MINT_TALL_STOOL.get())
                .add(TallStool.AQUA_TALL_STOOL.get())
                .add(TallStool.SLATE_TALL_STOOL.get())
                .add(TallStool.NAVY_TALL_STOOL.get())
                .add(TallStool.INDIGO_TALL_STOOL.get());

                /* Sofa */
        this.getOrCreateTagBuilder(AFBlockTags.SOFAS)
                .add(Sofa.MAROON_SOFA.get())
                .add(Sofa.ROSE_SOFA.get())
                .add(Sofa.CORAL_SOFA.get())
                .add(Sofa.GINGER_SOFA.get())
                .add(Sofa.TAN_SOFA.get())
                .add(Sofa.BEIGE_SOFA.get())
                .add(Sofa.AMBER_SOFA.get())
                .add(Sofa.OLIVE_SOFA.get())
                .add(Sofa.FOREST_SOFA.get())
                .add(Sofa.VERDANT_SOFA.get())
                .add(Sofa.TEAL_SOFA.get())
                .add(Sofa.MINT_SOFA.get())
                .add(Sofa.AQUA_SOFA.get())
                .add(Sofa.SLATE_SOFA.get())
                .add(Sofa.NAVY_SOFA.get())
                .add(Sofa.INDIGO_SOFA.get());

                /* Lamp */
        this.getOrCreateTagBuilder(AFBlockTags.LAMPS)
                .add(Lamp.MAROON_LAMP.get())
                .add(Lamp.ROSE_LAMP.get())
                .add(Lamp.CORAL_LAMP.get())
                .add(Lamp.GINGER_LAMP.get())
                .add(Lamp.TAN_LAMP.get())
                .add(Lamp.BEIGE_LAMP.get())
                .add(Lamp.AMBER_LAMP.get())
                .add(Lamp.OLIVE_LAMP.get())
                .add(Lamp.FOREST_LAMP.get())
                .add(Lamp.VERDANT_LAMP.get())
                .add(Lamp.TEAL_LAMP.get())
                .add(Lamp.MINT_LAMP.get())
                .add(Lamp.AQUA_LAMP.get())
                .add(Lamp.SLATE_LAMP.get())
                .add(Lamp.NAVY_LAMP.get())
                .add(Lamp.INDIGO_LAMP.get());

                /* Curtains */
        this.getOrCreateTagBuilder(AFBlockTags.CURTAINS)
                .add(Curtain.MAROON_CURTAIN.get())
                .add(Curtain.ROSE_CURTAIN.get())
                .add(Curtain.CORAL_CURTAIN.get())
                .add(Curtain.GINGER_CURTAIN.get())
                .add(Curtain.TAN_CURTAIN.get())
                .add(Curtain.BEIGE_CURTAIN.get())
                .add(Curtain.AMBER_CURTAIN.get())
                .add(Curtain.OLIVE_CURTAIN.get())
                .add(Curtain.FOREST_CURTAIN.get())
                .add(Curtain.VERDANT_CURTAIN.get())
                .add(Curtain.TEAL_CURTAIN.get())
                .add(Curtain.MINT_CURTAIN.get())
                .add(Curtain.AQUA_CURTAIN.get())
                .add(Curtain.SLATE_CURTAIN.get())
                .add(Curtain.NAVY_CURTAIN.get())
                .add(Curtain.INDIGO_CURTAIN.get());




    }
}