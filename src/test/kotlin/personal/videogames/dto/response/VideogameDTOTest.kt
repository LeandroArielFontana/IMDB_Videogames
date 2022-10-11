package personal.videogames.dto.response

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import personal.videogames.* // ktlint-disable no-wildcard-imports

class VideogameDTOTest : StringSpec({
    "VideogameDTO should return..." {
        val videogame = getVideogameDTO()
        videogame.id shouldBe 1
        videogame.name shouldBe "Spider-Man"
        videogame.certificate shouldBe "T"
        videogame.url shouldBe "https://www.imdb.com/title/tt5807780/?ref_=adv_li_tt"
        videogame.votes shouldBe "20.759"
        videogame.year shouldBe 2018
        videogame.plot.shouldBeTypeOf<String>()
        videogame.rating shouldBe 9.2
    }
    "VideogameDTO should return..." {
        var videogame = VideogameDTO()
        videogame.year = getYearOfVideogame()
        videogame.plot = getPlotOfVideogame()
        videogame.url = getURLOfVideogame()
        videogame.votes = getVotesOfVideogame()
        videogame.certificate = getCertificateOfVideogame()
        videogame.rating = getRatingOfVideogame()
        videogame.id = getIdOfVideogame()
        videogame.name = getNameOfVideogame()
    }
})
