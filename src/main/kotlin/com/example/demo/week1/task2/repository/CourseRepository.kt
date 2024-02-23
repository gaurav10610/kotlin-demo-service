package com.example.demo.week1.task2.repository

import com.example.demo.week1.task2.entity.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository : JpaRepository<Course, Long> {
    fun findByName(name: String): Course?
}