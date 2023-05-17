package hightech.toontust.core.service

import hightech.toontust.core.dto.request.CreateProductRequestDTO
import hightech.toontust.core.dto.request.UpdateProductRequestDTO
import hightech.toontust.core.dto.response.ProductResponseDTO
import hightech.toontust.core.entity.Product
import hightech.toontust.core.error.NotFoundException
import hightech.toontust.core.repository.ProductRepository
import hightech.toontust.core.validation.ValidationUtil
import org.springframework.data.repository.findByIdOrNull
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
        return convertProductEntityToResponseDTO(product)
    }

    override fun get(id: String): ProductResponseDTO {
        val product = productRepository.findByIdOrNull(id) ?: throw NotFoundException()
        return convertProductEntityToResponseDTO(product)
    }

    override fun update(id: String, updateProductRequest: UpdateProductRequestDTO): ProductResponseDTO {
        validationUtil.validate(updateProductRequest)
        val product = productRepository.findByIdOrNull(id) ?: throw NotFoundException()
        product.apply {
            name = updateProductRequest.name!!
            price = updateProductRequest.price!!
            quantity = updateProductRequest.quantity!!
            updatedAt = Date()
        }
        productRepository.save(product)
        return convertProductEntityToResponseDTO(product)
    }

    private fun convertProductEntityToResponseDTO(product: Product): ProductResponseDTO {
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