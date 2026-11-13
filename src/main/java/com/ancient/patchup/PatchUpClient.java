package com.ancient.patchup;

import com.ancient.patchup.block.another_furniture.Curtain;
import com.ancient.patchup.block.another_furniture.Lamp;
import com.ancient.patchup.block.another_furniture.Sofa;
import com.ancient.patchup.block.arts_and_crafts.ArtsAndCraftsEntries;
import com.ancient.patchup.block.arts_and_crafts.PatchUpDecoratedPotItemRenderer;
import com.ninni.dye_depot.registry.DDDyes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import vectorwing.farmersdelight.common.registry.ModAtlases;

import java.util.function.Supplier;

public class PatchUpClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        if (Compats.ANOTHER_FURNITURE.isLoaded()) {
            for (Supplier<Block> sofa : Sofa.SOFAS.values()) {
                BlockRenderLayerMap.INSTANCE.putBlock(sofa.get(), RenderLayer.getCutout());
            }

            for (Supplier<Block> lamp : Lamp.LAMPS.values()) {
                BlockRenderLayerMap.INSTANCE.putBlock(lamp.get(), RenderLayer.getCutout());
            }
            for (Supplier<Block> connector : Lamp.LAMP_CONNECTORS.values()) {
                BlockRenderLayerMap.INSTANCE.putBlock(connector.get(), RenderLayer.getCutout());
            }

            for (Supplier<Block> curtain : Curtain.CURTAINS.values()) {
                BlockRenderLayerMap.INSTANCE.putBlock(curtain.get(), RenderLayer.getCutout());
            }
        }

        if (Compats.FARMERS_DELIGHT.isLoaded()) {
            for (DDDyes dye : DDDyes.values()) {
                DyeColor color = dye.get();
                ModAtlases.DYED_CANVAS_SIGN_MATERIALS.put(color,
                        new SpriteIdentifier(
                                TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                                Identifier.of("farmersdelight", "entity/signs/canvas_" + color.getName())));
                ModAtlases.DYED_HANGING_CANVAS_SIGN_MATERIALS.put(color,
                        new SpriteIdentifier(
                                TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                                Identifier.of("farmersdelight", "entity/signs/hanging/canvas_" + color.getName())));
            }
        }

        if (Compats.ARTS_AND_CRAFTS.isLoaded()) {
            PatchUpDecoratedPotItemRenderer potRenderer = new PatchUpDecoratedPotItemRenderer();
            for (ArtsAndCraftsEntries.Entry entry : ArtsAndCraftsEntries.ENTRIES) {
                BlockRenderLayerMap.INSTANCE.putBlock(entry.flowerPot(), RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(entry.chalkDust(), RenderLayer.getCutout());
                if (BuiltinItemRendererRegistry.INSTANCE.get(entry.decoratedPotItem()) == null) {
                    BuiltinItemRendererRegistry.INSTANCE.register(entry.decoratedPotItem(), potRenderer);
                }
            }
        }
    }
}
