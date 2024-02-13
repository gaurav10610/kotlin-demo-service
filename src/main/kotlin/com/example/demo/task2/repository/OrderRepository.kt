package com.example.demo.task2.repository

import com.example.demo.task2.entity.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, Long> {
    @Query("SELECT o.customerId, COUNT(o) AS orderCount FROM Order o GROUP BY o.customerId ORDER BY orderCount DESC")
    fun findOrderCountByCustomer(): List<Any>
}