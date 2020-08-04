package cz.mkalina.watchshopdemo.rest

import cz.mkalina.watchshopdemo.model.Image
import cz.mkalina.watchshopdemo.model.Watch
import cz.mkalina.watchshopdemo.service.WatchService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*
import javax.xml.bind.annotation.XmlRootElement

@RestController
@RequestMapping("/watch")
class WatchController(
        val watchService: WatchService
) {

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: WatchCreateRequest) {

        val watch = try {
            val fountain = Image(Base64.getDecoder().decode(request.fountain))
            val price = Integer.parseInt(request.price)
            Watch(
                    title = request.title,
                    price = price,
                    description = request.description,
                    fountain = fountain
            )
        } catch (e: RuntimeException) {
            throw ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY)
        }

        watchService.create(watch)
    }

}

@XmlRootElement(name = "watch")
data class WatchCreateRequest(

        var title: String = "",
        var price: String = "",
        var description: String = "",
        var fountain: String = ""
)