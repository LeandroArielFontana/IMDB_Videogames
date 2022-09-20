package personal.videogames.service

import org.springframework.stereotype.Service
import personal.videogames.dto.response.VideogameDTO

@Service
interface VideogameService {
    fun getVideogameById(id: Int): VideogameDTO

    fun getVideogameByName(name: String): MutableList<VideogameDTO>

    fun getAllVideogames(): MutableList<VideogameDTO>

    fun getVideogamesByCertificate(certificate: String): MutableList<VideogameDTO>

    fun getVideogamesByYear(year: Int): MutableList<VideogameDTO>
}
