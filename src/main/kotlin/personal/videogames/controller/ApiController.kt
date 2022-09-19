package personal.videogames.controller

import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import personal.videogames.model.Videogames

@Validated
interface ApiController {

    fun getAllVideogames(): ResponseEntity<MutableList<Videogames>>

    fun getVideogameById(
        @PathVariable idVideogame: Int
    ): ResponseEntity<Videogames>

    fun getVideogamesByCategory(
        @PathVariable videogameCategory: String
    ): ResponseEntity<List<Videogames>>

    fun getVideogamesByYear(
        @PathVariable videogameYear: Int
    ): ResponseEntity<List<Videogames>>

    fun getVideogameByName(
        @RequestParam videogameName: String
    ): ResponseEntity<Videogames>

    fun echo(): ResponseEntity<String>
}
