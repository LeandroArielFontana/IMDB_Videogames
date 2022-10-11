package personal.videogames

import personal.videogames.dto.response.ErrorDetailResponseDTO
import personal.videogames.dto.response.VideogameDTO
import personal.videogames.model.Videogame

fun <T> given(block: () -> T) = block()

fun <T> `when`(block: () -> T) = block()

fun <T> then(block: () -> T) = block()

fun getVideogameDTO() = VideogameDTO(
    id = 1,
    name = "Spider-Man",
    url = "https://www.imdb.com/title/tt5807780/?ref_=adv_li_tt",
    year = 2018,
    certificate = "T",
    rating = 9.2,
    votes = "20.759",
    plot = "When a new villain threatens New York City, Peter Parker and Spider-Man's worlds collide. To save the city and those he loves, he must rise up and be greater."
)

fun getVideogame() = Videogame(
    id = 1,
    name = "Spider-Man",
    url = "https://www.imdb.com/title/tt5807780/?ref_=adv_li_tt",
    year = 2018,
    certificate = "T",
    rating = 9.2,
    votes = "20.759",
    plot = "When a new villain threatens New York City, Peter Parker and Spider-Man's worlds collide. To save the city and those he loves, he must rise up and be greater."
)

fun getListOfVideogames() = mutableListOf(
    Videogame(
        id = 1,
        name = "Spider-Man",
        url = "https://www.imdb.com/title/tt5807780/?ref_=adv_li_tt",
        year = 2018,
        certificate = "T",
        rating = 9.2,
        votes = "20.759",
        plot = "When a new villain threatens New York City, Peter Parker and Spider-Man's worlds collide. To save the city and those he loves, he must rise up and be greater."
    ),
    Videogame(
        id = 2,
        name = "Undertale",
        url = "https://www.imdb.com/title/tt5807780/?ref_=adv_li_tt",
        year = 2008,
        certificate = "T",
        rating = 10.0,
        votes = "23.759",
        plot = "When a new villain threatens New York City, Peter Parker and Spider-Man's worlds collide. To save the city and those he loves, he must rise up and be greater."
    )
)

fun getIdOfVideogame() = 1

fun getNameOfVideogame() = "Spider-Man"

fun getURLOfVideogame() = "https://www.imdb.com/title/tt5807780/?ref_=adv_li_tt"

fun getYearOfVideogame() = 2018

fun getCertificateOfVideogame() = "T"

fun getVotesOfVideogame() = "20.759"

fun getPlotOfVideogame() = "When a new villain threatens New York City, Peter Parker and Spider-Man's worlds collide. To save the city and those he loves, he must rise up and be greater."

fun getRatingOfVideogame() = 9.2

fun getErrorDetailResponseDTO() = ErrorDetailResponseDTO(
    status = "404",
    title = "NOT FOUND",
    detail = "Not Found"
)
