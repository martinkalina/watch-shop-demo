package cz.mkalina.watchshopdemo

import cz.mkalina.watchshopdemo.persistence.WatchRepository
import org.intellij.lang.annotations.Language
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
class WatchShopDemoApplicationTests {

	@Autowired lateinit var mockMvc: MockMvc

	@Autowired lateinit var watchRepository: WatchRepository

	@BeforeEach
	internal fun setUp() {
		watchRepository.deleteAll()
	}


	@Test
	fun test_create_json() {
		@Language("json")
		val payload = """
			{
			"title": "Prim",
			"price": "250000", 
			"description": "A watch with a water fountain picture",
			"fountain": "R0lGODlhAQABAIAAAAUEBAAAACwAAAAAAQABAAACAkQBADs="
			}
		""".trimIndent()

		mockMvc.perform(MockMvcRequestBuilders.post("/watch").contentType("application/json").content(payload))
				.andExpect(MockMvcResultMatchers.status().isCreated)

		val watches = watchRepository.findAll()
		assert(watches.size == 1)
		assert(watches[0].title == "Prim")
	}

	@Test
	fun test_create_xml() {
		@Language("xml")
		val payload = """<?xml version="1.0" encoding="UTF-8"?>
			<watch>
			    <description>A watch with a water fountain picture</description>
			    <fountain>R0lGODlhAQABAIAAAAUEBAAAACwAAAAAAQABAAACAkQBADs=</fountain>
			    <price>250000</price>
			    <title>Prim</title>
			</watch>
		""".trimIndent()

		mockMvc.perform(MockMvcRequestBuilders.post("/watch").contentType("application/xml").content(payload))
				.andExpect(MockMvcResultMatchers.status().isCreated)

		val watches = watchRepository.findAll()
		assert(watches.size == 1)
		assert(watches[0].title == "Prim")
	}
}
