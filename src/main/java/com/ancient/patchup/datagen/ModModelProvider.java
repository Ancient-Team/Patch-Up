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
