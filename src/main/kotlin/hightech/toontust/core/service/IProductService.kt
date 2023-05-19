package hightech.toontust.core.service

import hightech.toontust.core.dto.request.CreateProductRequestDTO
import hightech.toontust.core.dto.request.ListProductRequestDTO
import hightech.toontust.core.dto.request.UpdateProductRequestDTO
import hightech.toontust.core.dto.response.ProductResponseDTO

interface IProductService {

    fun create(createProductRequest: CreateProductRequestDTO): ProductResponseDTO

    fun get(id: String): ProductResponseDTO

    fun update(id: String, updateProductRequest: UpdateProductRequestDTO): ProductResponseDTO

    fun delete(id: String)

    fun list(listProductRequest: ListProductRequestDTO): List<ProductResponseDTO>

}