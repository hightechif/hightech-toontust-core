package hightech.toontust.core.dto.response.base

data class GeneralWrapper<T>(
    val code: Int,
    val status: String,
    val data: T,
    val message: String?
)
