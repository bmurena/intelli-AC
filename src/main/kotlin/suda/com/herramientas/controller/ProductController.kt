package suda.com.herramientas.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import suda.com.herramientas.model.Product
import suda.com.herramientas.service.ProductService

@RestController
open class ProductController {

    @Autowired
    open lateinit var ProductService: ProductService

    @GetMapping("/listar")
    open fun listar(): List<Product> {
        return ProductService.listar()
    }

    @PostMapping("/crear")
    open fun crear(@RequestBody product: Product): Product {
        return ProductService.crear(product)
    }

    @PutMapping("/actualizar/{id}")
    open fun actualizar(@PathVariable id: Int, @RequestBody product: Product): Product? {
        return ProductService.actualizar(id, product)
    }

    @DeleteMapping("/eliminar/{id}")
    open fun eliminar(@PathVariable id: Int): String {
        return if (ProductService.eliminar(id)) "Producto eliminado" else "Producto no encontrado"
    }
}