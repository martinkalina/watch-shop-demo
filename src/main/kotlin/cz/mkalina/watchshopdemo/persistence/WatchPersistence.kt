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
)

interface WatchRepository : JpaRepository<WatchEntity, Long>