package personal.videogames.dto.response

data class VideogameDTO(
    var id: Int = 0,
    var name: String = "",
    var url: String = "",
    var year: Int = 0,
    var rating: Double = 0.0,
    var votes: String = "",
    var certificate: String = "",
    var plot: String = ""
)
