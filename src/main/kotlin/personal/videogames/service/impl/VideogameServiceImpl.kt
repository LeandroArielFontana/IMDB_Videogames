package personal.videogames.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import personal.videogames.dto.response.VideogameDTO
import personal.videogames.mapper.VideogameMapper
import personal.videogames.repository.VideogameRepository
import personal.videogames.service.VideogameService

@Service
class VideogameServiceImpl(
    @Autowired
    val videogameRepository: VideogameRepository,
    @Autowired
    val videogameMapper: VideogameMapper
) : VideogameService {

    override fun getAllVideogames(): MutableList<VideogameDTO> =
        videogameMapper.listOfVideogameEntityToDto(videogameRepository.findAll())

    override fun getVideogameByName(name: String): MutableList<VideogameDTO> =
        videogameMapper.listOfVideogameEntityToDto(videogameRepository.getVideogameByName(name = name))

    override fun getVideogameById(id: Int): VideogameDTO =
        videogameMapper.videogameEntityToDto(videogameRepository.getVideogameById(id = id))

    override fun getVideogamesByYear(year: Int): MutableList<VideogameDTO> =
        videogameMapper.listOfVideogameEntityToDto(videogameRepository.getVideogameByYear(year = year))

    override fun getVideogamesByCertificate(certificate: String): MutableList<VideogameDTO> =
        videogameMapper.listOfVideogameEntityToDto(videogameRepository.getVideogameByCertificate(certificate = certificate))
}
