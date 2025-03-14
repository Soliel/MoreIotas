package ram.talia.moreiotas.api.mod

import at.petrak.hexcasting.api.HexAPI
import net.minecraft.resources.ResourceLocation

object MoreIotasConfig {
    interface CommonConfigAccess { }

    interface ClientConfigAccess { }

    interface ServerConfigAccess {
        val MAX_MATRIX_SIZE: Int
        val MAX_STRING_LENGTH: Int

        companion object {
            const val DEFAULT_MAX_MATRIX_SIZE: Int = 144
            const val MAX_MAX_MATRIX_SIZE: Int = 512
            const val DEFAULT_MAX_STRING_LENGTH: Int = 1728
            const val MAX_MAX_STRING_LENGTH: Int = 32768
        }
    }

    // Simple extensions for resource location configs
    fun anyMatch(keys: List<String>, key: ResourceLocation): Boolean {
        return keys.stream().map { s: String -> ResourceLocation(s) }.anyMatch { r: ResourceLocation? -> key == r }
    }

    fun noneMatch(keys: List<String>, key: ResourceLocation): Boolean {
        return keys.stream().map { s: String -> ResourceLocation(s) }.noneMatch { r: ResourceLocation? -> key == r }
    }

    @JvmStatic
    var common: CommonConfigAccess? = null
        set(access) {
            if (access == null)
                throw Exception("Attempted to set MoreIotasConfig.common to null.")
            if (field != null) {
                HexAPI.LOGGER.warn("CommonConfigAccess was replaced! Old {} New {}",
                        field!!.javaClass.name, access.javaClass.name)
            }
            field = access
        }

    @JvmStatic
    var client: ClientConfigAccess? = null
        set(access) {
            if (access == null)
                throw Exception("Attempted to set MoreIotasConfig.client to null.")
            if (field != null) {
                HexAPI.LOGGER.warn("ClientConfigAccess was replaced! Old {} New {}",
                        field!!.javaClass.name, access.javaClass.name)
            }
            field = access
        }

    @JvmStatic
    var server: ServerConfigAccess? = null
        set(access) {
            if (access == null)
                throw Exception("Attempted to set MoreIotasConfig.client to null.")
            if (field != null) {
                HexAPI.LOGGER.warn("ServerConfigAccess was replaced! Old {} New {}",
                        field!!.javaClass.name, access.javaClass.name)
            }
            field = access
        }
}