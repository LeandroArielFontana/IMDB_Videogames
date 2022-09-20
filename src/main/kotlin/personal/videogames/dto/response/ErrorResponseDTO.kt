package personal.videogames.dto.response

import io.swagger.v3.oas.annotations.media.Schema

@Schema(name = "ErrorResponseDTO", description = "Error response when an error has ocurred")
data class ErrorResponseDTO(
    @field:Schema(
        description = "List of errors",
        type = "array"
    )
    val errors: MutableList<ErrorDetailResponseDTO>
)
