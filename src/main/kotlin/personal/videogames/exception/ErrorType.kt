package personal.videogames.exception

import org.springframework.http.HttpStatus

enum class ErrorType(
    val status: String,
    val title: String
) {
    RESPONSE_METHOD_NOT_ALLOWED(
        status = HttpStatus.METHOD_NOT_ALLOWED.value().toString(),
        title = "METHOD NOT ALLOWED"
    ),
    RESPONSE_BAD_REQUEST(
        status = HttpStatus.BAD_REQUEST.value().toString(),
        title = "BAD REQUEST"
    ),
    RESPONSE_NOT_FOUND(
        status = HttpStatus.NOT_FOUND.value().toString(),
        title = "NOT FOUND"
    ),
    RESPONSE_INTERNAL_SERVER_ERROR(
        status = HttpStatus.INTERNAL_SERVER_ERROR.value().toString(),
        title = "INTERNAL SERVER ERROR"
    )
}
