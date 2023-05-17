package hightech.toontust.core.service

import hightech.toontust.core.dto.request.CreateProductRequestDTO
import hightech.toontust.core.dto.response.ProductResponseDTO
import hightech.toontust.core.entity.Product
import hightech.toontust.core.repository.ProductRepository
import hightech.toontust.core.validation.ValidationUtil
import org.springframework.stereotype.Service
import java.util.Date

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val validationUtil: ValidationUtil
) : IProductService {

    override fun create(createProductRequest: CreateProductRequestDTO): ProductResponseDTO {
        validationUtil.validate(createProductRequest)
        val product = Product(
            id = createProductRequest.id!!,
            name = createProductRequest.name!!,
            price = createProductRequest.price!!,
            quantity = createProductRequest.quantity!!,
            createdAt = Date(),
            updatedAt = null
        )
        productRepository.save(product)
        return ProductResponseDTO(
            id = product.id,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            createdAt = product.createdAt,
            updatedAt = product.updatedAt
        )
    }
}