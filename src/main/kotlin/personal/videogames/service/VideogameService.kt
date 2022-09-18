package personal.videogames.service

import personal.videogames.dto.VideogameDTO

interface VideogameService {
    fun getVideogameById(id: Int): VideogameDTO

    fun getVideogameByName(name: String): VideogameDTO

    fun getAllVideogames(): List<VideogameDTO>

    fun getVideogamesByCategory(category: String): List<VideogameDTO>

    fun getVideogamesByYear(year: Int): List<VideogameDTO>
}
