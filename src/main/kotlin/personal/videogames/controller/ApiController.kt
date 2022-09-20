package personal.videogames.controller

import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import personal.videogames.dto.response.VideogameDTO

@Validated
interface ApiController {

    @Operation(
        summary = "Finds all video games",
        description = "returns a list of all video games in DB",
        tags = ["Get all videogames"]
    )
    fun getAllVideogames(): ResponseEntity<MutableList<VideogameDTO>>

    @Operation(
        summary = "Find a video games by ID",
        description = "returns a video games in DB by ID",
        tags = ["Get video game by ID"]
    )
    fun getVideogameById(
        @PathVariable idVideogame: Int
    ): ResponseEntity<VideogameDTO>

    @Operation(
        summary = "Find a video game by certificate",
        description = "returns a video games in DB by certificate",
        tags = ["Get video games by certificate"]
    )
    fun getVideogamesByCertificate(
        @RequestParam certificate: String
    ): ResponseEntity<List<VideogameDTO>>

    @Operation(
        summary = "Find video games by year",
        description = "returns video games in DB by year",
        tags = ["Get video games by year"]
    )
    fun getVideogamesByYear(
        @PathVariable videogameYear: Int
    ): ResponseEntity<List<VideogameDTO>>

    @Operation(
        summary = "Finds video games by name",
        description = "returns video games in DB by name",
        tags = ["Get video games by name"]
    )
    fun getVideogameByName(
        @RequestParam videogameName: String
    ): ResponseEntity<MutableList<VideogameDTO>>

    @Operation(
        summary = "echo endpoint",
        description = "returns echo",
        tags = ["Echo"]
    )
    fun echo(): ResponseEntity<String>
}
