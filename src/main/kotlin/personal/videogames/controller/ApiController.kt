package personal.videogames.controller

import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import personal.videogames.dto.Videogame

@Validated
interface ApiController {

    fun getAllVideogames(): ResponseEntity<List<Videogame>>

    fun getVideogameById(): ResponseEntity<Videogame>

    fun getVideogamesByCategory(): ResponseEntity<List<Videogame>>

    fun getVideogamesByYear(): ResponseEntity<List<Videogame>>

    fun getVideogameByName(): ResponseEntity<Videogame>

    fun echo(): ResponseEntity<String>
}
