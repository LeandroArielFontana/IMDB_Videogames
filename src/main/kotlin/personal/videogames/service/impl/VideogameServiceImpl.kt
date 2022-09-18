package personal.videogames.service.impl

import org.springframework.stereotype.Service
import personal.videogames.dto.VideogameDTO
import personal.videogames.service.VideogameService

@Service
class VideogameServiceImpl : VideogameService {
    override fun getVideogameById(id: Int): VideogameDTO {
        TODO("Not yet implemented")
    }

    override fun getVideogameByName(name: String): VideogameDTO {
        TODO("Not yet implemented")
    }

    override fun getAllVideogames(): List<VideogameDTO> {
        TODO("Not yet implemented")
    }

    override fun getVideogamesByCategory(category: String): List<VideogameDTO> {
        TODO("Not yet implemented")
    }

    override fun getVideogamesByYear(year: Int): List<VideogameDTO> {
        TODO("Not yet implemented")
    }
}
