package personal.videogames.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import personal.videogames.constant.QueryConstant
import personal.videogames.model.Videogame

@Repository
interface VideogameRepository : JpaRepository<Videogame, Int> {
    @Query(QueryConstant.FIND_BY_NAME, nativeQuery = true)
    fun getVideogameByName(@Param("name") name: String): MutableList<Videogame>

    @Query(QueryConstant.FIND_BY_ID, nativeQuery = true)
    fun getVideogameById(@Param("id") id: Int): Videogame

    @Query(QueryConstant.FIND_BY_YEAR, nativeQuery = true)
    fun getVideogameByYear(@Param("year") year: Int): MutableList<Videogame>

    @Query(QueryConstant.FIND_BY_CERTIFICATE, nativeQuery = true)
    fun getVideogameByCertificate(@Param("certificate") certificate: String): MutableList<Videogame>
}
