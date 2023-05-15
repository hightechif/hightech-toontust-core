package hightech.toontust.core.repository

import hightech.toontust.core.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, String> {

}