package hightech.toontust.core.dto.response

import java.util.*

data class ProductResponseDTO(
    val id: String,
    val name: String,
    val price: Long,
    val quantity: Int,
    val createdAt: Date,
    val updatedAt: Date?
)
