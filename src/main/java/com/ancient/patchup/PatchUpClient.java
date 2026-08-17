package com.ancient.patchup;

import com.ancient.patchup.block.another_furniture.Curtain;
import com.ancient.patchup.block.another_furniture.Lamp;
import com.ancient.patchup.block.another_furniture.Sofa;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

import java.util.function.Supplier;

public class PatchUpClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        if (Compats.ANOTHER_FURNITURE.isLoaded()) {
            /* Sofas */
            for (Supplier<Block> sofa : Sofa.SOFAS.values()) {
                BlockRenderLayerMap.INSTANCE.putBlock(sofa.get(), RenderLayer.getCutout());
            }

            /* Lamps & Lamp Connectors */
            for (Supplier<Block> lamp : Lamp.LAMPS.values()) {
                BlockRenderLayerMap.INSTANCE.putBlock(lamp.get(), RenderLayer.getCutout());
            }
            for (Supplier<Block> connector : Lamp.LAMP_CONNECTORS.values()) {
                BlockRenderLayerMap.INSTANCE.putBlock(connector.get(), RenderLayer.getCutout());
            }

            /* Curtains */
            for (Supplier<Block> curtain : Curtain.CURTAINS.values()) {
                BlockRenderLayerMap.INSTANCE.putBlock(curtain.get(), RenderLayer.getCutout());
            }
        }

        if (Compats.FARMERS_DELIGHT.isLoaded()) {
            for (com.ninni.dye_depot.registry.DDDyes dye : com.ninni.dye_depot.registry.DDDyes.values()) {
                net.minecraft.util.DyeColor color = dye.get();
                vectorwing.farmersdelight.common.registry.ModAtlases.DYED_CANVAS_SIGN_MATERIALS.put(color,
                        new net.minecraft.client.util.SpriteIdentifier(
                                net.minecraft.client.render.TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                                net.minecraft.util.Identifier.of("farmersdelight", "entity/signs/canvas_" + color.getName())));
                vectorwing.farmersdelight.common.registry.ModAtlases.DYED_HANGING_CANVAS_SIGN_MATERIALS.put(color,
                        new net.minecraft.client.util.SpriteIdentifier(
                                net.minecraft.client.render.TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                                net.minecraft.util.Identifier.of("farmersdelight", "entity/signs/hanging/canvas_" + color.getName())));
            }
        }
    }
}
