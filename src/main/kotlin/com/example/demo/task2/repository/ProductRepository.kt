package com.example.demo.task2.repository

import com.example.demo.task2.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long> {
    fun findByPriceGreaterThan(price: Double): List<Product>
}