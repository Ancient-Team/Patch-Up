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
    }
}
