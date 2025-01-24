package net.random.wildlife.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class BearCarpetBlock extends CarpetBlock {
    public BearCarpetBlock(Settings settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE = BearCarpetBlock.createCuboidShape(0.0,0.0,0.0,16.0,1.0,16.0);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}


