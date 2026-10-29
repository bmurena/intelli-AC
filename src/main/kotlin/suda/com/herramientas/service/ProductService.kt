package suda.com.herramientas.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import suda.com.herramientas.model.Product
import suda.com.herramientas.repository.ProductRepository

@Service
open class ProductService {

    @Autowired
    open lateinit var ProductRepository: ProductRepository

    open fun listar(): List<Product> {
        return ProductRepository.findAll()
    }

    open fun crear(product: Product): Product {
        product.id = null
        return ProductRepository.save(product)
    }

    open fun actualizar(id: Int, datos: Product): Product? {
        val existente = ProductRepository.findById(id).orElse(null) ?: return null
        existente.description = datos.description
        existente.price = datos.price
        existente.stock = datos.stock
        return ProductRepository.save(existente)
    }

    open fun eliminar(id: Int): Boolean {
        if (!ProductRepository.existsById(id)) return false
        ProductRepository.deleteById(id)
        return true
    }
}