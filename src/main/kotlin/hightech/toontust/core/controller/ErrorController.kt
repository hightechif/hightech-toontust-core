package hightech.toontust.core.controller

import hightech.toontust.core.dto.response.base.GeneralWrapper
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

}