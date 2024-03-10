package com.example.demo.week2.task2.sql.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.NamedQuery

@Entity
@NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = ?1")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long? = null,
    val username: String,
    val email: String
)