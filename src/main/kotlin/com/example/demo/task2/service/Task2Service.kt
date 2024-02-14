package com.example.demo.task2.service

import com.example.demo.task2.entity.Product

interface Task2Service {
    fun getProductsGreaterThan50(): List<Product>
}