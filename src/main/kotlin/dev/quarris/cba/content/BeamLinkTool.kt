package dev.quarris.cba.content

import net.minecraft.ChatFormatting
import net.minecraft.nbt.NbtUtils
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.Style
import net.minecraft.world.InteractionResult
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.world.level.Level

class BeamLinkTool(pProperties: Properties) : Item(pProperties) {

    override fun useOn(pContext: UseOnContext): InteractionResult {
        val pos = pContext.clickedPos
        pContext.itemInHand.addTagElement("BeamTarget", NbtUtils.writeBlockPos(pos))
        pContext.player?.displayClientMessage(Component.translatable("item.cba.beam_link_tool.on_use"), true)
        return super.useOn(pContext)
    }

    override fun appendHoverText(
        pStack: ItemStack,
        pLevel: Level?,
        pTooltipComponents: MutableList<Component>,
        pIsAdvanced: TooltipFlag
    ) {
        pTooltipComponents.add(Component.translatable("item.cba.beam_link_tool.description").withStyle(ChatFormatting.LIGHT_PURPLE))
        val tag = pStack.getTagElement("BeamTarget") ?: return

        val pos = NbtUtils.readBlockPos(tag)
        pTooltipComponents.add(Component.translatable("item.cba.beam_link_tool.beam_target", "${pos.x}, ${pos.y}, ${pos.z}").withStyle(ChatFormatting.GOLD))

    }

}