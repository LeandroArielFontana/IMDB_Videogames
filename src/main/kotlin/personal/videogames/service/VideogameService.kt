package personal.videogames.service

import org.springframework.stereotype.Service
import personal.videogames.model.Videogames

@Service
interface VideogameService {
    fun getVideogameById(id: Int): Videogames

    fun getVideogameByName(name: String): MutableList<Videogames>

    fun getAllVideogames(): MutableList<Videogames>

    fun getVideogamesByCategory(category: String): MutableList<Videogames>

    fun getVideogamesByYear(year: Int): MutableList<Videogames>
}
