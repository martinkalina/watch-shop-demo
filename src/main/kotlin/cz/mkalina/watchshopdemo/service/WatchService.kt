package cz.mkalina.watchshopdemo.service

import cz.mkalina.watchshopdemo.model.Watch
import cz.mkalina.watchshopdemo.persistence.WatchEntity
import cz.mkalina.watchshopdemo.persistence.WatchRepository
import org.springframework.stereotype.Service

@Service
class WatchService(val watchRepository: WatchRepository) {

    fun create(watch: Watch) {
        watchRepository.save(watch.toEntity())
    }

}

private fun Watch.toEntity(): WatchEntity = WatchEntity(
        title = this.title,
        price = this.price,
        description = this.description,
        fountain = this.fountain.data
)



