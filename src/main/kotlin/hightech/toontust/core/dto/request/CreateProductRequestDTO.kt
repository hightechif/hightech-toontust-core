package hightech.toontust.core.dto.request

data class CreateProductRequestDTO(
    val id: String,
    val name: String,
    val price: Long,
    val quantity: Int
)
