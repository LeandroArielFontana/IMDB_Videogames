package personal.videogames.config

import com.fasterxml.jackson.databind.ObjectMapper
import io.swagger.v3.core.jackson.ModelResolver
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.responses.ApiResponse
import io.swagger.v3.oas.models.responses.ApiResponses
import io.swagger.v3.oas.models.tags.Tag
import org.springdoc.core.customizers.OpenApiCustomiser
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus

@Configuration
@OpenAPIDefinition
class OpenApiConfiguration(
    @Value("\${documentation.openapi.info.title}")
    private val infoTitle: String,
    @Value("\${documentation.openapi.info.description}")
    private val infoDescription: String,
    @Value("\${documentation.openapi.info.version}")
    private val infoVersion: String
) {
    @Bean
    fun openApiCustomizer() = OpenApiCustomiser {
        it.info = info()
        it.tags = tags()
    }

    private fun info() =
        Info()
            .title(infoTitle)
            .description(infoDescription)
            .version(infoVersion)

    private fun tags() =
        mutableListOf<Tag>(
            Tag().name("Get all videogames").description("Finds list of videogames in the DB")
        )

    @Bean
    fun modelResolver(objectMapper: ObjectMapper) = ModelResolver(objectMapper)

    private fun ApiResponses.addDefaultResponses(vararg httpStatus: HttpStatus) {
        httpStatus.forEach {
            this[it.asString()] = ApiResponse().description(it.reasonPhrase)
        }
    }

    private fun HttpStatus.asString() = value().toString()
}
