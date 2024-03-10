package com.example.demo.week2.task2.mongo.projection

data class CustomerOrderCount(
    val customerId: String,
    val orderCount: Long
)