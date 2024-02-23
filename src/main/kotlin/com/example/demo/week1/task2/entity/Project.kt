package com.example.demo.week1.task2.entity

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
@Table(name = "projects")
data class Project(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "employee_project",
        joinColumns = [JoinColumn(name = "project_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "employee_id", referencedColumnName = "id")]
    )
    val employees: MutableSet<Employee> = mutableSetOf()
)