package dev.quarris.cba

import dev.quarris.cba.content.BeamLinkTool
import net.minecraft.nbt.NbtUtils
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.boss.enderdragon.EndCrystal
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract
import net.minecraftforge.eventbus.api.SubscribeEvent

object Events {

    @SubscribeEvent
    fun interact(event: EntityInteract) {
        val crystal = event.target
        val stack = event.itemStack
        if (crystal !is EndCrystal) return
        if (stack.item !is BeamLinkTool) return

        if (event.entity.isShiftKeyDown) {
            crystal.beamTarget = null
            event.entity.displayClientMessage(Component.translatable("item.cba.beam_link_tool.cleared"), true)
            return
        }

        val tag = stack.getTagElement("BeamTarget")?:return
        val pos = NbtUtils.readBlockPos(tag)
        crystal.beamTarget = pos
        event.entity.displayClientMessage(Component.translatable("item.cba.beam_link_tool.on_entity_use"), true)
    }

}