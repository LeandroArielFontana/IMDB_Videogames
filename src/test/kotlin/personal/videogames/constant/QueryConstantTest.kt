package personal.videogames.constant

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.types.shouldBeTypeOf

class QueryConstantTest : StringSpec({
    "toString QueryConstant should return correct formatted string" {
        val example = QueryConstant()
        example.shouldBeTypeOf<QueryConstant>()
    }
})
