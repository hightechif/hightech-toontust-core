package hightech.toontust.core.controller

import hightech.toontust.core.dto.response.base.GeneralWrapper
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): GeneralWrapper<Nothing?> {
        return GeneralWrapper(
            code = 400,
            status = "BAD REQUEST",
            data = null,
            message = constraintViolationException.message
        )
    }

}