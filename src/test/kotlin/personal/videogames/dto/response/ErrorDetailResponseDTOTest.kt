package personal.videogames.dto.response

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import personal.videogames.getErrorDetailResponseDTO

class ErrorDetailResponseDTOTest : StringSpec({
    "ErrorDetailResponseDTO should return..." {
        val errorDetail = getErrorDetailResponseDTO()
        errorDetail.detail shouldBe "Not Found"
        errorDetail.status shouldBe "404"
        errorDetail.title shouldBe "NOT FOUND"
    }
})
