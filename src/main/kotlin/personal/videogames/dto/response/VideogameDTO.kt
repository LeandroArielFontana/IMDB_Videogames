package personal.videogames.dto.response

data class VideogameDTO(
    val id: Int,
    val name: String,
    val url: String,
    val year: Int,
    val certificate: String,
    val rating: Double,
    val votes: String,
    val plot: String
)
