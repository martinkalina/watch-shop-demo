package cz.mkalina.watchshopdemo.model

/**
 * Simple wrapper over binary image representation, handling equality for its content.
 */
data class Image(
        val data : ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Image

        if (!data.contentEquals(other.data)) return false

        return true
    }

    override fun hashCode(): Int {
        return data.contentHashCode()
    }
}