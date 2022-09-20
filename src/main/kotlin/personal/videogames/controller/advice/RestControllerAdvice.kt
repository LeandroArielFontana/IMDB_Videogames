package personal.videogames.controller.advice

import org.springframework.http.HttpStatus
import org.springframework.web.HttpMediaTypeNotSupportedException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MissingPathVariableException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.NoHandlerFoundException
import personal.videogames.dto.response.ErrorDetailResponseDTO
import personal.videogames.dto.response.ErrorResponseDTO
import personal.videogames.exception.ErrorType
import personal.videogames.utils.CompanionLogger
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class RestControllerAdvice {

    @ExceptionHandler(HttpMediaTypeNotSupportedException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleHttpMediaTypeNotSuportedException(ex: HttpMediaTypeNotSupportedException, request: HttpServletRequest) =
        MethodCreatedHandlerExceptionContext(
            ex = ex,
            request = request,
            responseError = ErrorType.RESPONSE_BAD_REQUEST
        ).toHttpResponse(ex.message.toString())
            .log { error("HttpMediaTypeNotSupportedException Captured") }

    @ExceptionHandler(NoHandlerFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNoHandlerFoundExceptionException(ex: NoHandlerFoundException, request: HttpServletRequest) =
        MethodCreatedHandlerExceptionContext(
            ex = ex,
            request = request,
            responseError = ErrorType.RESPONSE_NOT_FOUND
        ).toHttpResponse(ex.message.toString())
            .log { error("NoHandlerFoundExceptionException Captured") }

    @ExceptionHandler(MissingPathVariableException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleMissingPathVariableExceptionException(ex: MissingPathVariableException, request: HttpServletRequest) =
        MethodCreatedHandlerExceptionContext(
            ex = ex,
            request = request,
            responseError = ErrorType.RESPONSE_NOT_FOUND
        ).toHttpResponse(ex.message)
            .log { error("MissingPathVariableExceptionException Captured") }

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    fun handleHttpRequestMethodNotSupportedException(ex: HttpRequestMethodNotSupportedException, request: HttpServletRequest) =
        MethodCreatedHandlerExceptionContext(
            ex = ex,
            request = request,
            responseError = ErrorType.RESPONSE_METHOD_NOT_ALLOWED
        ).toHttpResponse(ex.message.toString())
            .log { error("Exception Captured") }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleUncaughtException(ex: Exception, request: HttpServletRequest) =
        MethodCreatedHandlerExceptionContext(
            ex = ex,
            request = request,
            responseError = ErrorType.RESPONSE_INTERNAL_SERVER_ERROR
        ).toHttpResponse(ex.message.toString())
            .log { error("Exception Captured") }

    private fun MethodCreatedHandlerExceptionContext.toHttpResponse(errorMessage: String) = ErrorResponseDTO(
        errors = mutableListOf(
            ErrorDetailResponseDTO(
                status = responseError.status,
                title = responseError.title,
                detail = errorMessage
            )
        )
    )

    data class MethodCreatedHandlerExceptionContext(
        val ex: Exception,
        val request: HttpServletRequest,
        val responseError: ErrorType
    )

    companion object : CompanionLogger()
}
