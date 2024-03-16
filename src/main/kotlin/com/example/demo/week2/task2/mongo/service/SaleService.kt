package com.example.demo.week2.task2.mongo.service

import com.example.demo.week2.task2.mongo.projection.ProductQuantitySold
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.aggregation.Aggregation.*
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class SaleService(@Autowired private val mongoOperations: MongoOperations) {

    fun totalQuantitySoldPerProductInOctober(): List<ProductQuantitySold> {
        val aggregation = newAggregation(
            match(
                Criteria.where("date").gte(LocalDate.ofYearDay(LocalDate.now().year, 1))
                    .and("date").lt(LocalDate.ofYearDay(LocalDate.now().year, 1).plusMonths(1)).and("date")
                    .lt(LocalDate.now())
            ),
            group("productId").sum("quantitySold").`as`("totalQuantitySold"),
            project("totalQuantitySold").and("_id").`as`("productId")
        )

        val results = mongoOperations.aggregate(aggregation, "sales", ProductQuantitySold::class.java)
        return results.mappedResults
    }
}