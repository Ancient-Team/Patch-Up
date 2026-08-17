package com.ancient.patchup.datagen;

import com.ancient.patchup.block.another_furniture.*;
import com.ancient.patchup.block.farmers_delight.CanvasSigns;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDDyes;
import com.ninni.dye_depot.registry.DDItems;
import com.starfish_studios.another_furniture.registry.AFItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        /* Another Furniture Recipes */
        for (DDDyes dye : DDDyes.values()) {
            Item dyeItem = DDItems.DYES.getOrThrow(dye.get());
            Block woolBlock = DDBlocks.WOOL.getOrThrow(dye.get());
            Block stool = Stool.STOOLS.get(dye).get();
            Block tallStool = TallStool.TALL_STOOLS.get(dye).get();
            Block sofa = Sofa.SOFAS.get(dye).get();
            Block lamp = Lamp.LAMPS.get(dye).get();
            Block curtain = Curtain.CURTAINS.get(dye).get();

            /* Stool */
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, stool, 3)
                    .pattern("#W#")
                    .pattern("/ /")
                    .input('W', woolBlock)
                    .input('#', ItemTags.PLANKS)
                    .input('/', Items.STICK)
                    .group("stools")
                    .criterion(RecipeProvider.hasItem(woolBlock), RecipeProvider.conditionsFromItem(woolBlock))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(stool)));

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, stool, 1)
                    .input(dyeItem)
                    .input(AFItemTags.STOOLS)
                    .group("stools")
                    .criterion(RecipeProvider.hasItem(dyeItem), RecipeProvider.conditionsFromItem(dyeItem))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(stool) + "dye"));

            /* Tall Stool */
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, tallStool, 3)
                    .pattern("#W#")
                    .pattern("///")
                    .pattern("/ /")
                    .input('W', woolBlock)
                    .input('#', ItemTags.PLANKS)
                    .input('/', Items.STICK)
                    .group("tall_stools")
                    .criterion(RecipeProvider.hasItem(woolBlock), RecipeProvider.conditionsFromItem(woolBlock))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(tallStool)));

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, tallStool, 1)
                    .input(dyeItem)
                    .input(AFItemTags.TALL_STOOLS)
                    .group("tall_stools")
                    .criterion(RecipeProvider.hasItem(dyeItem), RecipeProvider.conditionsFromItem(dyeItem))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(tallStool) + "dye"));

            /* Sofa */
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, sofa, 3)
                    .pattern("#W ")
                    .pattern("#WW")
                    .pattern("/ /")
                    .input('W', woolBlock)
                    .input('#', ItemTags.PLANKS)
                    .input('/', Items.STICK)
                    .group("sofas")
                    .criterion(RecipeProvider.hasItem(woolBlock), RecipeProvider.conditionsFromItem(woolBlock))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(sofa)));

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, sofa, 1)
                    .input(dyeItem)
                    .input(AFItemTags.SOFAS)
                    .group("sofas")
                    .criterion(RecipeProvider.hasItem(dyeItem), RecipeProvider.conditionsFromItem(dyeItem))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(sofa) + "dye"));

            /* Lamp */
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, lamp, 3)
                    .pattern(" W ")
                    .pattern("WTW")
                    .pattern(" / ")
                    .input('W', woolBlock)
                    .input('T', Items.TORCH)
                    .input('/', Items.STICK)
                    .group("lamps")
                    .criterion(RecipeProvider.hasItem(woolBlock), RecipeProvider.conditionsFromItem(woolBlock))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(lamp)));

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, lamp, 1)
                    .input(dyeItem)
                    .input(AFItemTags.LAMPS)
                    .group("lamps")
                    .criterion(RecipeProvider.hasItem(dyeItem), RecipeProvider.conditionsFromItem(dyeItem))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(lamp) + "dye"));

            /* Curtain */
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, curtain, 3)
                    .pattern("//")
                    .pattern("WW")
                    .pattern("WW")
                    .input('W', woolBlock)
                    .input('/', Items.STICK)
                    .group("curtains")
                    .criterion(RecipeProvider.hasItem(woolBlock), RecipeProvider.conditionsFromItem(woolBlock))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(curtain)));

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, curtain, 1)
                    .input(dyeItem)
                    .input(AFItemTags.CURTAINS)
                    .group("curtains")
                    .criterion(RecipeProvider.hasItem(dyeItem), RecipeProvider.conditionsFromItem(dyeItem))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(curtain) + "dye"));
        }

        /* Farmer's Delight Canvas Signs Recipes */
        CanvasSigns.init();
        for (CanvasSigns.CanvasSignEntry entry : CanvasSigns.ENTRIES) {
            Item dyeItem = DDItems.DYES.getOrThrow(entry.dye().get());

            /* Dyeing Canvas Sign */
            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, entry.signItem(), 1)
                    .input(dyeItem)
                    .input(ModItemTagProvider.FD_CANVAS_SIGNS)
                    .group("canvas_signs")
                    .criterion(RecipeProvider.hasItem(dyeItem), RecipeProvider.conditionsFromItem(dyeItem))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(entry.signItem()) + "_from_dyeing"));

            /* Dyeing Hanging Canvas Sign */
            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, entry.hangingSignItem(), 1)
                    .input(dyeItem)
                    .input(ModItemTagProvider.FD_HANGING_CANVAS_SIGNS)
                    .group("hanging_canvas_signs")
                    .criterion(RecipeProvider.hasItem(dyeItem), RecipeProvider.conditionsFromItem(dyeItem))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(entry.hangingSignItem()) + "_from_dyeing"));
        }

        /* Arts & Crafts Recipes */
        com.ancient.patchup.block.arts_and_crafts.ArtsAndCraftsEntries.init();
        for (com.ancient.patchup.block.arts_and_crafts.ArtsAndCraftsEntries.Entry entry : com.ancient.patchup.block.arts_and_crafts.ArtsAndCraftsEntries.ENTRIES) {
            Item dyeItem = DDItems.DYES.getOrThrow(entry.dye().get());

            // 1. Chalk Block <-> Chalk Stick
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, entry.chalk(), 1)
                    .pattern("##")
                    .pattern("##")
                    .input('#', entry.chalkStick())
                    .criterion(RecipeProvider.hasItem(entry.chalkStick()), RecipeProvider.conditionsFromItem(entry.chalkStick()))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(entry.chalk())));

            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, entry.chalkStick(), 4)
                    .input(entry.chalk())
                    .criterion(RecipeProvider.hasItem(entry.chalk()), RecipeProvider.conditionsFromItem(entry.chalk()))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(entry.chalkStick()) + "_from_chalk_block"));

            offerStonecuttingRecipe(exporter, RecipeCategory.MISC, entry.chalkStick(), entry.chalk(), 4);

            // 2. Paintbrush
            ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, entry.paintbrush(), 1)
                    .input(dyeItem)
                    .input(com.kekecreations.arts_and_crafts.core.init.ACTags.ItemTags.PAINTBRUSHES)
                    .group("paintbrushes")
                    .criterion(RecipeProvider.hasItem(dyeItem), RecipeProvider.conditionsFromItem(dyeItem))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(entry.paintbrush()) + "_from_dyeing"));

            // 3. Plaster
            ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, entry.plaster(), 8)
                    .input(dyeItem)
                    .input(com.kekecreations.arts_and_crafts.core.registry.ACBlocks.PLASTER.get(), 8)
                    .group("plaster")
                    .criterion(RecipeProvider.hasItem(dyeItem), RecipeProvider.conditionsFromItem(dyeItem))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(entry.plaster()) + "_from_dyeing"));

            // 4. Pots
            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, entry.flowerPotItem(), 1)
                    .input(dyeItem)
                    .input(Items.FLOWER_POT)
                    .group("flower_pots")
                    .criterion(RecipeProvider.hasItem(dyeItem), RecipeProvider.conditionsFromItem(dyeItem))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(entry.flowerPotItem()) + "_from_dyeing"));

            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, entry.decoratedPotItem(), 1)
                    .input(dyeItem)
                    .input(Items.DECORATED_POT)
                    .group("decorated_pots")
                    .criterion(RecipeProvider.hasItem(dyeItem), RecipeProvider.conditionsFromItem(dyeItem))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(entry.decoratedPotItem()) + "_from_dyeing"));

            // 5. Mud Bricks Family
            ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, entry.mudBricks(), 8)
                    .input(dyeItem)
                    .input(Blocks.MUD_BRICKS, 8)
                    .group("mud_bricks")
                    .criterion(RecipeProvider.hasItem(dyeItem), RecipeProvider.conditionsFromItem(dyeItem))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(entry.mudBricks()) + "_from_dyeing"));

            createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, entry.mudBrickSlab(), net.minecraft.recipe.Ingredient.ofItems(entry.mudBricks()))
                    .criterion(RecipeProvider.hasItem(entry.mudBricks()), RecipeProvider.conditionsFromItem(entry.mudBricks()))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(entry.mudBrickSlab())));
            createStairsRecipe(entry.mudBrickStairs(), net.minecraft.recipe.Ingredient.ofItems(entry.mudBricks()))
                    .criterion(RecipeProvider.hasItem(entry.mudBricks()), RecipeProvider.conditionsFromItem(entry.mudBricks()))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(entry.mudBrickStairs())));
            offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.mudBrickWall(), entry.mudBricks());

            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.mudBrickSlab(), entry.mudBricks(), 2);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.mudBrickStairs(), entry.mudBricks(), 1);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.mudBrickWall(), entry.mudBricks(), 1);

            // 6. Terracotta Shingles Family
            createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, entry.terracottaShingleSlab(), net.minecraft.recipe.Ingredient.ofItems(entry.terracottaShingles()))
                    .criterion(RecipeProvider.hasItem(entry.terracottaShingles()), RecipeProvider.conditionsFromItem(entry.terracottaShingles()))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(entry.terracottaShingleSlab())));
            createStairsRecipe(entry.terracottaShingleStairs(), net.minecraft.recipe.Ingredient.ofItems(entry.terracottaShingles()))
                    .criterion(RecipeProvider.hasItem(entry.terracottaShingles()), RecipeProvider.conditionsFromItem(entry.terracottaShingles()))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(entry.terracottaShingleStairs())));
            offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.terracottaShingleWall(), entry.terracottaShingles());

            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.terracottaShingleSlab(), entry.terracottaShingles(), 2);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.terracottaShingleStairs(), entry.terracottaShingles(), 1);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.terracottaShingleWall(), entry.terracottaShingles(), 1);

            // 7. Soapstone Family
            createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, entry.soapstoneSlab(), net.minecraft.recipe.Ingredient.ofItems(entry.soapstone()))
                    .criterion(RecipeProvider.hasItem(entry.soapstone()), RecipeProvider.conditionsFromItem(entry.soapstone()))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(entry.soapstoneSlab())));
            createStairsRecipe(entry.soapstoneStairs(), net.minecraft.recipe.Ingredient.ofItems(entry.soapstone()))
                    .criterion(RecipeProvider.hasItem(entry.soapstone()), RecipeProvider.conditionsFromItem(entry.soapstone()))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(entry.soapstoneStairs())));
            offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.soapstoneWall(), entry.soapstone());

            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.soapstoneSlab(), entry.soapstone(), 2);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.soapstoneStairs(), entry.soapstone(), 1);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.soapstoneWall(), entry.soapstone(), 1);

            // Polished Soapstone
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, entry.polishedSoapstone(), 4)
                    .pattern("##")
                    .pattern("##")
                    .input('#', entry.soapstone())
                    .criterion(RecipeProvider.hasItem(entry.soapstone()), RecipeProvider.conditionsFromItem(entry.soapstone()))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(entry.polishedSoapstone())));
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.polishedSoapstone(), entry.soapstone(), 1);

            createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, entry.polishedSoapstoneSlab(), net.minecraft.recipe.Ingredient.ofItems(entry.polishedSoapstone()))
                    .criterion(RecipeProvider.hasItem(entry.polishedSoapstone()), RecipeProvider.conditionsFromItem(entry.polishedSoapstone()))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(entry.polishedSoapstoneSlab())));
            createStairsRecipe(entry.polishedSoapstoneStairs(), net.minecraft.recipe.Ingredient.ofItems(entry.polishedSoapstone()))
                    .criterion(RecipeProvider.hasItem(entry.polishedSoapstone()), RecipeProvider.conditionsFromItem(entry.polishedSoapstone()))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(entry.polishedSoapstoneStairs())));
            offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.polishedSoapstoneWall(), entry.polishedSoapstone());

            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.polishedSoapstoneSlab(), entry.polishedSoapstone(), 2);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.polishedSoapstoneStairs(), entry.polishedSoapstone(), 1);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.polishedSoapstoneWall(), entry.polishedSoapstone(), 1);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.polishedSoapstoneSlab(), entry.soapstone(), 2);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.polishedSoapstoneStairs(), entry.soapstone(), 1);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.polishedSoapstoneWall(), entry.soapstone(), 1);

            // Soapstone Bricks
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, entry.soapstoneBricks(), 4)
                    .pattern("##")
                    .pattern("##")
                    .input('#', entry.polishedSoapstone())
                    .criterion(RecipeProvider.hasItem(entry.polishedSoapstone()), RecipeProvider.conditionsFromItem(entry.polishedSoapstone()))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(entry.soapstoneBricks())));
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.soapstoneBricks(), entry.polishedSoapstone(), 1);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.soapstoneBricks(), entry.soapstone(), 1);

            createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, entry.soapstoneBrickSlab(), net.minecraft.recipe.Ingredient.ofItems(entry.soapstoneBricks()))
                    .criterion(RecipeProvider.hasItem(entry.soapstoneBricks()), RecipeProvider.conditionsFromItem(entry.soapstoneBricks()))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(entry.soapstoneBrickSlab())));
            createStairsRecipe(entry.soapstoneBrickStairs(), net.minecraft.recipe.Ingredient.ofItems(entry.soapstoneBricks()))
                    .criterion(RecipeProvider.hasItem(entry.soapstoneBricks()), RecipeProvider.conditionsFromItem(entry.soapstoneBricks()))
                    .offerTo(exporter, Identifier.of(RecipeProvider.getRecipeName(entry.soapstoneBrickStairs())));
            offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.soapstoneBrickWall(), entry.soapstoneBricks());

            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.soapstoneBrickSlab(), entry.soapstoneBricks(), 2);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.soapstoneBrickStairs(), entry.soapstoneBricks(), 1);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.soapstoneBrickWall(), entry.soapstoneBricks(), 1);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.soapstoneBrickSlab(), entry.soapstone(), 2);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.soapstoneBrickStairs(), entry.soapstone(), 1);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.soapstoneBrickWall(), entry.soapstone(), 1);
        }
    }
}
