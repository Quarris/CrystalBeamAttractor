package dev.quarris.cba.content

import dev.quarris.cba.ModRef
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object ModContent {
    val ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModRef.ID)
    val CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModRef.ID)

    val BEAM_LINK_TOOL by ITEMS.registerObject("beam_link_tool") {
        BeamLinkTool(Item.Properties().stacksTo(1))
    }

    val MAIN_TAB by CREATIVE_TABS.registerObject("main") {
        CreativeModeTab.builder()
            .displayItems { pParameters, pOutput ->
                ITEMS.entries.forEach {
                    pOutput.accept(it.get())
                }
            }
            .icon { ItemStack(BEAM_LINK_TOOL) }
            .title(Component.translatable("tab.cba.title"))
            .build()
    }


}