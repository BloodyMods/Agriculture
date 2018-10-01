package atm.bloodworkxgaming.agriculture.blocks.machines

import atm.bloodworkxgaming.agriculture.extensions.registerMe
import atm.bloodworkxgaming.bloodyLib.registry.IHasModel
import net.minecraft.block.Block
import net.minecraft.block.ITileEntityProvider
import net.minecraft.block.material.Material
import net.minecraft.block.properties.PropertyDirection
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraft.world.World
import net.minecraftforge.common.property.ExtendedBlockState
import net.minecraftforge.common.property.Properties


open class BlockBaseMachine(name: String) : Block(Material.ROCK), IHasModel {
    init {
        registerMe(name)
    }
}

class BlockCounter : BlockBaseMachine("counter"), ITileEntityProvider {
    companion object {
        val FACING: PropertyDirection = PropertyDirection.create("facing")
    }

    override fun createNewTileEntity(worldIn: World, meta: Int): TileEntity? = TileCounter()

    public override fun createBlockState(): ExtendedBlockState {
        return ExtendedBlockState(this, arrayOf(FACING, Properties.StaticProperty), arrayOf(Properties.AnimationProperty))
    }

    override fun isOpaqueCube(state: IBlockState?) = false
    override fun isFullCube(state: IBlockState?) = false

    override fun getStateForPlacement(world: World, pos: BlockPos, facing: EnumFacing, hitX: Float, hitY: Float, hitZ: Float, meta: Int, placer: EntityLivingBase, hand: EnumHand): IBlockState {
        return this.defaultState.withProperty(FACING, placer.horizontalFacing.opposite)
    }

    override fun getStateFromMeta(meta: Int): IBlockState {
        return defaultState.withProperty(FACING, EnumFacing.getFront(meta))
    }

    override fun getMetaFromState(state: IBlockState): Int {
        return state.getValue(FACING).index
    }

    override fun getActualState(state: IBlockState, world: IBlockAccess?, pos: BlockPos?): IBlockState {
        return state.withProperty(Properties.StaticProperty, true)
    }

    override fun hasTileEntity(state: IBlockState) = true

    override fun onBlockActivated(worldIn: World, pos: BlockPos, state: IBlockState, playerIn: EntityPlayer, hand: EnumHand, facing: EnumFacing, hitX: Float, hitY: Float, hitZ: Float): Boolean {
        if (worldIn.isRemote) {
            val te = worldIn.getTileEntity(pos) as? TileCounter ?: return true

            te.click(playerIn.isSneaking)
        }

        return true
    }
}