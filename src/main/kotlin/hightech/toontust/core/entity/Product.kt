package hightech.toontust.core.entity

import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "products")
data class Product(
    @Id
    val id: String,
    @Column(name = "name")
    var name: String,
    @Column(name = "price")
    var price: Long,
    @Column(name = "quantity")
    var quantity: Int,
    @Column(name = "createdAt")
    var createdAt: Date,
    @Column(name = "updatedAt")
    var updatedAt: Date?
)
