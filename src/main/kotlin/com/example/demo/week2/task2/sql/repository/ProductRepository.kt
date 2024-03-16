package com.example.demo.week2.task2.sql.repository

import com.example.demo.week2.task2.sql.entity.Product
import com.example.demo.week2.task2.sql.projection.ProductSummary
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long> {
    @Query("SELECT p.productId as productId, p.name as name FROM Product p WHERE p.price < 50")
    fun findProductSummariesWithPriceLessThan50(): List<ProductSummary>
}