package com.example.demo.week2.task2.mongo.repository

import com.example.demo.week2.task2.mongo.document.Product
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository : MongoRepository<Product, String> {
    fun findByCategoryAndPriceLessThan(category: String, price: Double): List<Product>
}