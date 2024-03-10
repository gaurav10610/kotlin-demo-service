package com.example.demo.week2.task2.mongo.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.Date

@Document(collection = "orders")
data class Order(
    @Id val orderId: String?,
    val customerId: String,
    val orderDate: Date
)