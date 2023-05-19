package hightech.toontust.core.controller

import hightech.toontust.core.dto.response.base.GeneralWrapper
import hightech.toontust.core.error.NotFoundException
import hightech.toontust.core.error.UnauthorizedException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): ResponseEntity<GeneralWrapper<Nothing?>> {
        return ResponseEntity(GeneralWrapper(
            code = 400,
            status = "BAD REQUEST",
            data = null,
            message = constraintViolationException.message
        ), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFound(notFoundException: NotFoundException): ResponseEntity<GeneralWrapper<Nothing?>> {
        return ResponseEntity(
            GeneralWrapper(
            code = 404,
            status = "NOT FOUND",
            data = null,
            message = "Not Found"
        ), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(value = [UnauthorizedException::class])
    fun unauthorized(unauthorizedException: UnauthorizedException): ResponseEntity<GeneralWrapper<Nothing?>> {
        return ResponseEntity(
            GeneralWrapper(
                code = 401,
                status = "UNAUTHORIZED",
                data = null,
                message = "Please put your X-Api-Key"
            ), HttpStatus.UNAUTHORIZED)
    }

}