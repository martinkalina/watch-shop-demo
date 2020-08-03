package cz.mkalina.watchshopdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
@EnableWebMvc
class WatchShopDemoApplication

fun main(args: Array<String>) {
	runApplication<WatchShopDemoApplication>(*args)
}
