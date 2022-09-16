package personal.videogames.controller.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import personal.videogames.constant.ApiConstant
import personal.videogames.controller.ApiController
import personal.videogames.dto.Videogame
import personal.videogames.service.VideogameService

@RestController
@RequestMapping("/v1/core/api-videogame")
class ApiControllerImpl(

    @Autowired
    val videogameService: VideogameService

) : ApiController {

    @GetMapping("/videogames")
    override fun getAllVideogames(): ResponseEntity<List<Videogame>> {
        TODO("Not yet implemented")
    }

    @GetMapping("/id/{idVideogame}")
    override fun getVideogameById(): ResponseEntity<Videogame> {
        TODO("Not yet implemented")
    }

    @GetMapping("/category/{category}")
    override fun getVideogamesByCategory(): ResponseEntity<List<Videogame>> {
        TODO("Not yet implemented")
    }

    @GetMapping("/year/{year}")
    override fun getVideogamesByYear(): ResponseEntity<List<Videogame>> {
        TODO("Not yet implemented")
    }

    @GetMapping("/name/{name}")
    override fun getVideogameByName(): ResponseEntity<Videogame> {
        TODO("Not yet implemented")
    }

    @GetMapping("/echo")
    override fun echo(): ResponseEntity<String> = ResponseEntity.ok(ApiConstant.ECHO)
}
