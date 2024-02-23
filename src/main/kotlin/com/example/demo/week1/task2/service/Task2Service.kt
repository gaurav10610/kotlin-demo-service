package com.example.demo.week1.task2.service

import com.example.demo.week1.task2.entity.Product

interface Task2Service {
    fun getProductsGreaterThan50(): List<Product>
}