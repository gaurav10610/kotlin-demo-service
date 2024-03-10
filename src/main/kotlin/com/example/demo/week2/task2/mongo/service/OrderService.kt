package com.example.demo.week2.task2.mongo.service

import com.example.demo.week2.task2.mongo.projection.CustomerOrderCount
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.stereotype.Service

@Service
class OrderService(@Autowired private val mongoTemplate: MongoTemplate) {

    fun countOrdersPerCustomer(): List<CustomerOrderCount> {
        val aggregation = Aggregation.newAggregation(
            Aggregation.group("customerId").count().`as`("orderCount"),
            Aggregation.project("orderCount").and("_id").`as`("customerId"),
            Aggregation.sort(Sort.Direction.DESC, "orderCount")
        )

        val results = mongoTemplate.aggregate(aggregation, "orders", CustomerOrderCount::class.java)
        return results.mappedResults
    }
}