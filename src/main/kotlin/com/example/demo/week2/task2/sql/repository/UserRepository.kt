package com.example.demo.week2.task2.sql.repository

import com.example.demo.week2.task2.sql.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): List<User>
}