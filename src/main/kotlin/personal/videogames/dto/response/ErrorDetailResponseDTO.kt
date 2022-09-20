package personal.videogames.dto.response

import io.swagger.v3.oas.annotations.media.Schema

@Schema(name = "ErrorDetailResponseDTO")
class ErrorDetailResponseDTO(
    val status: String,
    val title: String,
    val detail: String
)
