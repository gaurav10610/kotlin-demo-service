package com.example.demo.week2.task2.mongo.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.Date

@Document(collection = "sales")
data class Sale(
    @Id val id: String? = null,
    val date: Date,
    val productId: String,
    val quantitySold: Int
)