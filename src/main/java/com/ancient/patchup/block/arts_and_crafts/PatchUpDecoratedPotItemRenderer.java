package com.ancient.patchup.block.arts_and_crafts;

import com.kekecreations.arts_and_crafts.common.block.DyedDecoratedPotBlock;
import com.kekecreations.arts_and_crafts.common.entity.DyedDecoratedPotBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

import java.util.HashMap;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class PatchUpDecoratedPotItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {

    private final Map<Block, DyedDecoratedPotBlockEntity> blockEntities = new HashMap<>();

    @Override
    public void render(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.getItem() instanceof BlockItem blockItem) {
            Block block = blockItem.getBlock();
            DyedDecoratedPotBlockEntity entity = blockEntities.computeIfAbsent(block, b -> {
                if (b instanceof DyedDecoratedPotBlock potBlock) {
                    return (DyedDecoratedPotBlockEntity) potBlock.createBlockEntity(BlockPos.ORIGIN, b.getDefaultState());
                }
                return new DyedDecoratedPotBlockEntity(BlockPos.ORIGIN, b.getDefaultState());
            });
            if (entity != null) {
                entity.setFromItem(stack);
                MinecraftClient.getInstance().getBlockEntityRenderDispatcher().renderEntity(entity, matrices, vertexConsumers, light, overlay);
            }
        }
    }
}
