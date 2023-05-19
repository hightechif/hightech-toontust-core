package hightech.toontust.core.controller

import hightech.toontust.core.dto.request.CreateProductRequestDTO
import hightech.toontust.core.dto.request.ListProductRequestDTO
import hightech.toontust.core.dto.request.UpdateProductRequestDTO
import hightech.toontust.core.dto.response.ProductResponseDTO
import hightech.toontust.core.dto.response.base.GeneralWrapper
import hightech.toontust.core.service.IProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
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
        return ResponseEntity(
            GeneralWrapper(
                code = 201,
                status = "CREATED",
                data = productResponse,
                message = null
            ), HttpStatus.CREATED
        )
    }

    @GetMapping(
        value = ["/products/{idProduct}"],
        produces = ["application/json"],
    )
    fun getProduct(@PathVariable("idProduct") id: String): ResponseEntity<GeneralWrapper<ProductResponseDTO>> {
        val productResponse = productService.get(id)
        return ResponseEntity(
            GeneralWrapper(
                code = 200,
                status = "OK",
                data = productResponse,
                message = null
            ), HttpStatus.OK
        )
    }

    @PutMapping(
        value = ["/products/{idProduct}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateProduct(
        @PathVariable("idProduct") id: String,
        @RequestBody updateProductRequest: UpdateProductRequestDTO
    ): ResponseEntity<GeneralWrapper<ProductResponseDTO>> {
        val productResponse = productService.update(id, updateProductRequest)
        return ResponseEntity(
            GeneralWrapper(
                code = 200,
                status = "OK",
                data = productResponse,
                message = null
            ), HttpStatus.OK
        )
    }

    @DeleteMapping(
        value = ["/products/{idProduct}"],
        produces = ["application/json"]
    )
    fun deleteProduct(@PathVariable("idProduct") id: String): ResponseEntity<GeneralWrapper<Nothing?>> {
        productService.delete(id)
        return ResponseEntity(
            GeneralWrapper(
                code = 200,
                status = "OK",
                data = null,
                message = "Product with id=$id is deleted."
            ), HttpStatus.OK
        )
    }

    @GetMapping(
        value = ["/products"],
        produces = ["application/json"]
    )
    fun listProduct(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "10") size: Int
    ): ResponseEntity<GeneralWrapper<List<ProductResponseDTO>>> {
        val request = ListProductRequestDTO(page, size)
        val response = productService.list(request)
        return ResponseEntity(
            GeneralWrapper(
                code = 200,
                status = "OK",
                data = response,
                message = null
            ),
            HttpStatus.OK
        )
    }

}