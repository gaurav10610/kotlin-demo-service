package com.example.demo.task2.repository

import com.example.demo.task2.entity.Employee
import com.example.demo.task2.entity.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ProjectRepository : JpaRepository<Project, Long> {

    @Query("SELECT p.employees FROM Project p WHERE p.name = :projectName")
    fun findEmployeesByProjectName(projectName: String): Set<Employee>
}