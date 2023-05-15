package hightech.toontust.core.service

import hightech.toontust.core.dto.request.CreateProductRequestDTO
import hightech.toontust.core.dto.response.ProductResponseDTO

interface IProductService {

    fun create(createProductRequest: CreateProductRequestDTO): ProductResponseDTO

}