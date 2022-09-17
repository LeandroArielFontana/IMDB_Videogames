package personal.videogames.dto

data class Videogame(
    val id: Int,
    val name: String,
    val url: String,
    val year: Int,
    val certificate: Char,
    val rating: Double,
    val votes: Int,
    val plot: String,
)
