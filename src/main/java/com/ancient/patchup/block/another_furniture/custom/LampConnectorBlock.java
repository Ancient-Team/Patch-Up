package com.ancient.patchup.block.another_furniture.custom;

import com.ancient.patchup.block.another_furniture.Lamp;
import com.ninni.dye_depot.registry.DDDyes;
import com.starfish_studios.another_furniture.block.properties.ModBlockStateProperties;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class LampConnectorBlock extends Block implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final BooleanProperty POWERED = Properties.POWERED;
    public static final BooleanProperty BASE = ModBlockStateProperties.BASE;

    protected static final VoxelShape AABB_NOT_BASE = Block.createCuboidShape(7.0, 0.0, 7.0, 9.0, 16.0, 9.0);
    protected static final VoxelShape AABB_BASE = VoxelShapes.union(
            Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 2.0, 11.0),
            Block.createCuboidShape(7.0, 2.0, 7.0, 9.0, 16.0, 9.0)
    );

    private final DDDyes color;
    private final Supplier<Block> lampSupplier;

    public LampConnectorBlock(DDDyes color, Supplier<Block> lampSupplier, AbstractBlock.Settings properties) {
        super(properties);
        this.color = color;
        this.lampSupplier = lampSupplier;
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(POWERED, false)
                .with(WATERLOGGED, false)
                .with(BASE, true));
    }

    public LampConnectorBlock(DDDyes color, AbstractBlock.Settings properties) {
        this(color, () -> Lamp.getLampByColor(color), properties);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return state.get(BASE) ? AABB_BASE : AABB_NOT_BASE;
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext context) {
        boolean waterlogged = context.getWorld().getFluidState(context.getBlockPos()).getFluid() == Fluids.WATER;
        World level = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState blockState = this.getDefaultState();
        if (level.isReceivingRedstonePower(pos)) {
            blockState = blockState.with(POWERED, true);
        }

        return blockState.with(WATERLOGGED, waterlogged);
    }

    private boolean canConnect(BlockState state) {
        Block block = state.getBlock();
        if (block instanceof LampBlock lamp && lamp.getColor() == this.getColor() && state.contains(LampBlock.FACING) && state.get(LampBlock.FACING) == Direction.UP) {
            return true;
        }
        return block instanceof LampConnectorBlock connector && connector.getColor() == this.getColor();
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            level.scheduleFluidTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(level));
        }

        if (direction == Direction.UP || direction == Direction.DOWN) {
            boolean aConnect = canConnect(level.getBlockState(currentPos.up()));
            boolean bConnect = canConnect(level.getBlockState(currentPos.down()));
            Block lamp = this.lampSupplier.get();
            boolean waterlogged = state.get(WATERLOGGED);

            if (aConnect && !bConnect) {
                return state.with(BASE, true);
            } else if (!aConnect && bConnect) {
                return lamp.getDefaultState().with(BASE, false).with(WATERLOGGED, waterlogged);
            } else if (aConnect) {
                return state.with(BASE, false);
            } else {
                return lamp.getDefaultState().with(BASE, true).with(WATERLOGGED, waterlogged);
            }
        }

        return state;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public void neighborUpdate(BlockState state, World level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (!level.isClient) {
            BlockState below = level.getBlockState(pos.down());
            boolean belowPowered = (below.getBlock() instanceof LampConnectorBlock || below.getBlock() instanceof com.starfish_studios.another_furniture.block.LampConnectorBlock)
                    && below.contains(POWERED) && below.get(POWERED);
            boolean powered = level.isReceivingRedstonePower(pos) || belowPowered;

            if (powered != state.get(POWERED)) {
                state = state.with(POWERED, powered);
            }

            level.setBlockState(pos, state, Block.NOTIFY_ALL);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, POWERED, BASE);
    }

    public DDDyes getColor() {
        return this.color;
    }

    public static Block getLampByColor(DDDyes color) {
        return Lamp.getLampByColor(color);
    }
}
