package personal.videogames.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import personal.videogames.model.Videogames
import personal.videogames.repository.VideogameRepository
import personal.videogames.service.VideogameService

@Service
class VideogameServiceImpl(
    @Autowired
    val videogameRepository: VideogameRepository
) : VideogameService {

    override fun getAllVideogames(): MutableList<Videogames> = videogameRepository.findAll()

    override fun getVideogameByName(name: String): MutableList<Videogames> = videogameRepository.getVideogameByName(name = name)

    override fun getVideogameById(id: Int): Videogames = videogameRepository.getVideogameById(id = id)

    override fun getVideogamesByCategory(category: String): MutableList<Videogames> = TODO("Not yet implemented")

    override fun getVideogamesByYear(year: Int): List<Videogames> = TODO("Not yet implemented")
}
