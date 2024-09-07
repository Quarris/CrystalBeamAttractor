package dev.quarris.cba

import dev.quarris.cba.content.ModContent
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.FORGE_BUS
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(ModRef.ID)
object CrystalBeamAttractor {

    init {
        ModContent.ITEMS.register(MOD_BUS)
        ModContent.CREATIVE_TABS.register(MOD_BUS)

        FORGE_BUS.register(Events)
    }
}