package com.example.demo.task2.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "orders")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    val orderId: Long = 0,

    @Column(name = "customer_id")
    val customerId: Long,

    @Column(name = "order_date")
    val orderDate: LocalDate
)