package com.example.demo.task2.service.impl

import com.example.demo.task2.entity.Product
import com.example.demo.task2.repository.ProductRepository
import com.example.demo.task2.service.Task2Service
import org.springframework.beans.factory.annotation.Autowired

class Task2ServiceImpl(@Autowired val productRepository: ProductRepository): Task2Service {
    override fun getProductsGreaterThan50(): List<Product> {
        val products = productRepository.findByPriceGreaterThan(50.00)
        println("products: $products")
        return  products
    }
}