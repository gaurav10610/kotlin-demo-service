package com.example.demo.week1.task2.repository

import com.example.demo.week1.task2.entity.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface EnrollmentRepository : JpaRepository<Student, Long> {

    @Query("""
        SELECT s.name, c.name FROM Student s
        LEFT JOIN s.courses c
    """)
    fun findStudentsAndCourses(): List<Array<Any>>
}