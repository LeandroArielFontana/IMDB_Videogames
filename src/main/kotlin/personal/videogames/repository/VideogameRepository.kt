package personal.videogames.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import personal.videogames.model.Videogames

@Repository
interface VideogameRepository : JpaRepository<Videogames, Int> {
    // @Query(QueryConstant.FIND_BY_NAME)
    // fun getVideogameByName(@Param("name") name: String): Videogame
}
