package hightech.toontust.core.controller

import hightech.toontust.core.dto.request.CreateProductRequestDTO
import hightech.toontust.core.dto.response.ProductResponseDTO
import hightech.toontust.core.dto.response.base.GeneralWrapper
import hightech.toontust.core.service.IProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/v1"])
class ProductController(private val productService: IProductService) {

    @PostMapping(
        value = ["/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreateProductRequestDTO): ResponseEntity<GeneralWrapper<ProductResponseDTO>> {
        val productResponse = productService.create(body)
        return ResponseEntity(GeneralWrapper(
            code = 200,
            status = "OK",
            data = productResponse,
            message = null
        ), HttpStatus.CREATED)
    }

}