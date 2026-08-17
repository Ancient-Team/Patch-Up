package com.ancient.patchup.datagen;

import com.ancient.patchup.block.another_furniture.*;
import com.ancient.patchup.block.farmers_delight.CanvasSigns;
import com.starfish_studios.another_furniture.registry.AFItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public static final TagKey<Item> FD_CANVAS_SIGNS = TagKey.of(RegistryKeys.ITEM, Identifier.of("farmersdelight", "canvas_signs"));
    public static final TagKey<Item> FD_HANGING_CANVAS_SIGNS = TagKey.of(RegistryKeys.ITEM, Identifier.of("farmersdelight", "hanging_canvas_signs"));

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        /* Another Furniture */
        var stools = this.getOrCreateTagBuilder(AFItemTags.STOOLS);
        var tallStools = this.getOrCreateTagBuilder(AFItemTags.TALL_STOOLS);
        var sofas = this.getOrCreateTagBuilder(AFItemTags.SOFAS);
        var lamps = this.getOrCreateTagBuilder(AFItemTags.LAMPS);
        var curtains = this.getOrCreateTagBuilder(AFItemTags.CURTAINS);

        for (Supplier<Block> stool : Stool.STOOLS.values()) {
            stools.add(stool.get().asItem());
        }

        for (Supplier<Block> tallStool : TallStool.TALL_STOOLS.values()) {
            tallStools.add(tallStool.get().asItem());
        }

        for (Supplier<Block> sofa : Sofa.SOFAS.values()) {
            sofas.add(sofa.get().asItem());
        }

        for (Supplier<Block> lamp : Lamp.LAMPS.values()) {
            lamps.add(lamp.get().asItem());
        }

        for (Supplier<Block> curtain : Curtain.CURTAINS.values()) {
            curtains.add(curtain.get().asItem());
        }

        /* Farmer's Delight Canvas Signs */
        CanvasSigns.init();
        var signs = this.getOrCreateTagBuilder(ItemTags.SIGNS);
        var hangingSigns = this.getOrCreateTagBuilder(ItemTags.HANGING_SIGNS);
        var fdCanvasSigns = this.getOrCreateTagBuilder(FD_CANVAS_SIGNS);
        var fdHangingCanvasSigns = this.getOrCreateTagBuilder(FD_HANGING_CANVAS_SIGNS);

        for (CanvasSigns.CanvasSignEntry entry : CanvasSigns.ENTRIES) {
            signs.add(entry.signItem());
            hangingSigns.add(entry.hangingSignItem());
            fdCanvasSigns.add(entry.signItem());
            fdHangingCanvasSigns.add(entry.hangingSignItem());
        }

        /* Comforts */
        com.ancient.patchup.block.comforts.ComfortsItems.init();
        var hammocks = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("comforts", "hammocks")));
        var sleepingBags = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("comforts", "sleeping_bags")));

        for (com.ancient.patchup.block.comforts.ComfortsItems.ComfortsEntry entry : com.ancient.patchup.block.comforts.ComfortsItems.ENTRIES) {
            hammocks.add(entry.hammockItem().get());
            sleepingBags.add(entry.sleepingBagItem().get());
        }
    }
}
