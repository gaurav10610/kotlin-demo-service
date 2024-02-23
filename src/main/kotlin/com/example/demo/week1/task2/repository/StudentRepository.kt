package com.example.demo.week1.task2.repository

import com.example.demo.week1.task2.entity.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<Student, Long>