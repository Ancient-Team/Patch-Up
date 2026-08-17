package com.ancient.patchup.block.another_furniture.custom;

import com.ancient.patchup.block.another_furniture.Lamp;
import com.ninni.dye_depot.registry.DDDyes;
import com.starfish_studios.another_furniture.block.properties.ModBlockStateProperties;
import com.starfish_studios.another_furniture.registry.AFItemTags;
import com.starfish_studios.another_furniture.util.block.ShapeUtil;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class LampBlock extends Block implements Waterloggable {
    protected static final int LEVEL_MIN = 1;
    protected static final int LEVEL_MAX = 3;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final BooleanProperty LIT = Properties.LIT;
    public static final BooleanProperty POWERED = Properties.POWERED;
    public static final DirectionProperty FACING = ModBlockStateProperties.FACING_EXCEPT_DOWN;
    public static final IntProperty LEVEL = ModBlockStateProperties.LEVEL_1_3;
    public static final BooleanProperty BASE = ModBlockStateProperties.BASE;

    protected static final VoxelShape AABB_UP = Block.createCuboidShape(3.0, 8.0, 3.0, 13.0, 16.0, 13.0);
    protected static final VoxelShape AABB_UP_NORMAL = VoxelShapes.union(AABB_UP, Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 8.0, 11.0));
    protected static final VoxelShape AABB_UP_TOP = VoxelShapes.union(AABB_UP, Block.createCuboidShape(7.0, 0.0, 7.0, 9.0, 8.0, 9.0));
    protected static final VoxelShape AABB_NORTH = VoxelShapes.union(
            Block.createCuboidShape(3.0, 8.0, 5.0, 13.0, 16.0, 15.0),
            Block.createCuboidShape(5.0, 0.0, 14.0, 11.0, 6.0, 16.0),
            Block.createCuboidShape(7.0, 2.0, 9.0, 9.0, 8.0, 11.0),
            Block.createCuboidShape(7.0, 2.0, 11.0, 9.0, 4.0, 14.0)
    );
    protected static final VoxelShape AABB_EAST = ShapeUtil.rotateShape(AABB_NORTH, Direction.EAST);
    protected static final VoxelShape AABB_SOUTH = ShapeUtil.rotateShape(AABB_NORTH, Direction.SOUTH);
    protected static final VoxelShape AABB_WEST = ShapeUtil.rotateShape(AABB_NORTH, Direction.WEST);

    private final DDDyes color;
    private final Supplier<Block> connectorSupplier;

    public LampBlock(DDDyes color, Supplier<Block> connectorSupplier, AbstractBlock.Settings properties) {
        super(properties);
        this.color = color;
        this.connectorSupplier = connectorSupplier;
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(FACING, Direction.UP)
                .with(LEVEL, 3)
                .with(LIT, true)
                .with(POWERED, false)
                .with(WATERLOGGED, false)
                .with(BASE, true));
    }

    public LampBlock(DDDyes color, AbstractBlock.Settings properties) {
        this(color, () -> Lamp.getLampConnectorByColor(color), properties);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH -> AABB_NORTH;
            case EAST -> AABB_EAST;
            case SOUTH -> AABB_SOUTH;
            case WEST -> AABB_WEST;
            default -> state.get(BASE) ? AABB_UP_NORMAL : AABB_UP_TOP;
        };
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext context) {
        boolean waterlogged = context.getWorld().getFluidState(context.getBlockPos()).getFluid() == Fluids.WATER;
        World level = context.getWorld();
        BlockPos pos = context.getBlockPos();
        Direction clickedFace = context.getSide();
        BlockState blockState = this.getDefaultState();
        if (level.isReceivingRedstonePower(pos)) {
            blockState = blockState.with(POWERED, true);
        }

        return clickedFace != Direction.DOWN ? blockState.with(FACING, clickedFace).with(WATERLOGGED, waterlogged) : null;
    }

    private boolean canConnect(BlockState state) {
        Block block = state.getBlock();
        if (block instanceof LampBlock lamp && lamp.getColor() == this.getColor() && state.contains(FACING) && state.get(FACING) == Direction.UP) {
            return true;
        }
        return block instanceof LampConnectorBlock connector && connector.getColor() == this.getColor();
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess level, BlockPos currentPos, BlockPos neighborPos) {
        if (!state.canPlaceAt(level, currentPos)) {
            return Blocks.AIR.getDefaultState();
        }

        if (state.get(WATERLOGGED)) {
            level.scheduleFluidTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(level));
        }

        if (state.get(FACING) == Direction.UP && (direction == Direction.UP || direction == Direction.DOWN)) {
            boolean aConnect = canConnect(level.getBlockState(currentPos.up()));
            boolean bConnect = canConnect(level.getBlockState(currentPos.down()));
            Block connector = this.connectorSupplier.get();
            boolean waterlogged = state.get(WATERLOGGED);

            if (aConnect && !bConnect) {
                return connector.getDefaultState().with(BASE, true).with(WATERLOGGED, waterlogged);
            } else if (!aConnect && bConnect) {
                return state.with(BASE, false);
            } else if (aConnect) {
                return connector.getDefaultState().with(BASE, false).with(WATERLOGGED, waterlogged);
            } else {
                return state.with(BASE, true);
            }
        }

        return state;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView level, BlockPos pos) {
        Direction direction = state.get(FACING);
        BlockPos facingPos = pos.offset(direction.getOpposite());
        BlockState facingState = level.getBlockState(facingPos);
        return direction == Direction.UP || facingState.isSideSolidFullSquare(level, facingPos, direction);
    }

    @Override
    public void neighborUpdate(BlockState state, World level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (!level.isClient) {
            BlockState below = level.getBlockState(pos.down());
            boolean belowPowered = (below.getBlock() instanceof LampConnectorBlock || below.getBlock() instanceof com.starfish_studios.another_furniture.block.LampConnectorBlock)
                    && below.contains(POWERED) && below.get(POWERED);
            boolean powered = level.isReceivingRedstonePower(pos) || belowPowered;

            if (powered != state.get(POWERED)) {
                if (state.get(LIT) != powered) {
                    state = state.with(LIT, powered);
                    level.playSound(null, pos, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }
                state = state.with(POWERED, powered);
            }

            level.setBlockState(pos, state, Block.NOTIFY_ALL);
        }
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getStackInHand(hand).isIn(AFItemTags.LAMPS) && state.get(FACING) == Direction.UP && hit.getSide() == Direction.UP) {
            return ItemActionResult.FAIL;
        } else {
            if (player.isInSneakingPose()) {
                int light = state.get(LEVEL);
                light = light >= LEVEL_MAX ? LEVEL_MIN : light + 1;
                state = state.with(LEVEL, light);
            } else {
                state = state.cycle(LIT);
            }

            level.setBlockState(pos, state, Block.NOTIFY_ALL);
            level.playSound(null, pos, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return ItemActionResult.success(level.isClient);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, LIT, POWERED, FACING, LEVEL, BASE);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    public DDDyes getColor() {
        return this.color;
    }

    public static Block getLampConnectorByColor(DDDyes color) {
        return Lamp.getLampConnectorByColor(color);
    }
}