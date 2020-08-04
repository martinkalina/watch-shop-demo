package cz.mkalina.watchshopdemo.persistence

import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
data class WatchEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,
        val title: String,
        val price: Int,
        val description: String,
        @Lob
        val fountain: ByteArray

) {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as WatchEntity

                if (id != other.id) return false

                return true
        }

        override fun hashCode(): Int {
                return 31
        }
}

interface WatchRepository : JpaRepository<WatchEntity, Long>