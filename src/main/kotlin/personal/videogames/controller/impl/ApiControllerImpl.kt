package personal.videogames.controller.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import personal.videogames.constant.ApiConstant
import personal.videogames.controller.ApiController
import personal.videogames.model.Videogames
import personal.videogames.service.impl.VideogameServiceImpl

@RestController
@RequestMapping("/v1/core/api-videogame")
class ApiControllerImpl(

    @Autowired
    val videogameServiceImpl: VideogameServiceImpl

) : ApiController {

    @GetMapping("/videogames")
    override fun getAllVideogames(): ResponseEntity<MutableList<Videogames>> =
        ResponseEntity.ok(videogameServiceImpl.getAllVideogames())

    @GetMapping("/id/{idVideogame}")
    override fun getVideogameById(idVideogame: Int): ResponseEntity<Videogames> =
        ResponseEntity.ok(videogameServiceImpl.getVideogameById(id = idVideogame))

    @GetMapping("/category/{category}")
    override fun getVideogamesByCategory(videogameCategory: String): ResponseEntity<List<Videogames>> =
        ResponseEntity.ok(videogameServiceImpl.getVideogamesByCategory(category = videogameCategory))

    @GetMapping("/year/{year}")
    override fun getVideogamesByYear(videogameYear: Int): ResponseEntity<List<Videogames>> =
        ResponseEntity.ok(videogameServiceImpl.getVideogamesByYear(year = videogameYear))

    @GetMapping("/name/{name}")
    override fun getVideogameByName(videogameName: String): ResponseEntity<Videogames> =
        ResponseEntity.ok(videogameServiceImpl.getVideogameByName(videogameName))

    @GetMapping("/echo")
    override fun echo(): ResponseEntity<String> = ResponseEntity.ok(ApiConstant.ECHO)
}
