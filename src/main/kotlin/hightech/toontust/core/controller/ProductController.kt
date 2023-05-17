package hightech.toontust.core.controller

import hightech.toontust.core.dto.request.CreateProductRequestDTO
import hightech.toontust.core.dto.response.ProductResponseDTO
import hightech.toontust.core.dto.response.base.GeneralWrapper
import hightech.toontust.core.service.IProductService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/api")
class ProductController(private val productService: IProductService) {

    @PostMapping(
        value = ["/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreateProductRequestDTO): GeneralWrapper<ProductResponseDTO> {
        val productResponse = productService.create(body)
        return GeneralWrapper(
            code = 200,
            status = "OK",
            data = productResponse,
            message = null
        )
    }

}