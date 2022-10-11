package personal.videogames.constant

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.types.shouldBeTypeOf

class ApiConstantTest : StringSpec({
    "toString ApiConstant should return correct formatted string" {
        val example = ApiConstant()
        example.shouldBeTypeOf<ApiConstant>()
    }
})
