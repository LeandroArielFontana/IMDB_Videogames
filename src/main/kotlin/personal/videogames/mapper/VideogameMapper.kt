package personal.videogames.mapper

import org.springframework.stereotype.Component
import personal.videogames.dto.response.VideogameDTO
import personal.videogames.model.Videogame

@Component
class VideogameMapper {

    fun videogameEntityToDto(videogame: Videogame): VideogameDTO = VideogameDTO(
        id = videogame.id,
        name = videogame.name,
        url = videogame.url,
        year = videogame.year,
        certificate = videogame.certificate,
        rating = videogame.rating,
        votes = videogame.votes,
        plot = videogame.plot
    )

    fun listOfVideogameEntityToDto(listOfVideogame: MutableList<Videogame>): MutableList<VideogameDTO> {
        val listOfVideogameDTO = mutableListOf<VideogameDTO>()
        for (videogame in listOfVideogame) listOfVideogameDTO.add(videogameEntityToDto(videogame = videogame))
        return listOfVideogameDTO
    }
}
