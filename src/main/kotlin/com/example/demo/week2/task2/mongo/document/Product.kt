package com.example.demo.week2.task2.mongo.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "products")
data class Product(
    @Id val productId: String?,
    val name: String,
    val price: Double,
    val category: String
)