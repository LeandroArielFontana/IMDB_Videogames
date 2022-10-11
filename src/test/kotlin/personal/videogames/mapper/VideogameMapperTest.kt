package personal.videogames.mapper

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import personal.videogames.dto.response.VideogameDTO
import personal.videogames.getListOfVideogames
import personal.videogames.getVideogame

class VideogameMapperTest : BehaviorSpec({
    val mapper = VideogameMapper()
    Given("A VideogameDTO is initialized") {
        val response = getVideogame()
        When("mapping it to DTO") {
            val responseDTO = mapper.videogameEntityToDto(response)
            Then("mapping is correct") {
                responseDTO.id shouldBe 1
                responseDTO.name shouldBe "Spider-Man"
                responseDTO.certificate shouldBe "T"
                responseDTO.url shouldBe "https://www.imdb.com/title/tt5807780/?ref_=adv_li_tt"
                responseDTO.votes shouldBe "20.759"
                responseDTO.year shouldBe 2018
                responseDTO.plot.shouldBeTypeOf<String>()
                responseDTO.rating shouldBe 9.2
            }
        }
    }
    Given("A listOfVideogameEntityToDto is initialized") {
        val response = getListOfVideogames()
        When("mapping it to list of DTO") {
            val responseListOfDTO = mapper.listOfVideogameEntityToDto(response)
            Then("mapping is correct") {
                responseListOfDTO[0].id shouldBe 1
                responseListOfDTO[1].id shouldBe 2
            }
        }
    }
})
