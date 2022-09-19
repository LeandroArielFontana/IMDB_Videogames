package personal.videogames

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ImdbVideogamesApplication

fun main(args: Array<String>) {
    runApplication<ImdbVideogamesApplication>(*args)
}
