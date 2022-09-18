package personal.videogames.controller

import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import personal.videogames.dto.VideogameDTO

@Validated
interface ApiController {

    fun getAllVideogames(): ResponseEntity<List<VideogameDTO>>

    fun getVideogameById(
        @PathVariable idVideogame: Int
    ): ResponseEntity<VideogameDTO>

    fun getVideogamesByCategory(@PathVariable videogameCategory: String): ResponseEntity<List<VideogameDTO>>

    fun getVideogamesByYear(@PathVariable videogameYear: Int): ResponseEntity<List<VideogameDTO>>

    fun getVideogameByName(@PathVariable videogameName: String): ResponseEntity<VideogameDTO>

    fun echo(): ResponseEntity<String>
}
