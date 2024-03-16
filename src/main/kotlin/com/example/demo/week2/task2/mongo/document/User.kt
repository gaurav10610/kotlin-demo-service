package com.example.demo.week2.task2.mongo.document

import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Benefits of compound index -
 *
 * Improved Query Performance: Compound indexing can significantly improve query performance, especially when queries involve multiple fields included in the compound index. MongoDB can use the compound index to efficiently locate documents based on the indexed fields, resulting in faster query execution.
 *
 * Covered Queries: If a compound index includes all the fields required by a query, MongoDB can fulfill the query's requirements by scanning only the index without needing to access the actual documents. This is known as a covered query and can lead to faster query execution since it reduces disk I/O operations.
 *
 * Query Optimization: Compound indexing allows for optimization of queries involving multiple fields. By carefully selecting the order of fields in the compound index based on query patterns, you can optimize query performance for common use cases in your application.
 *
 * Index Intersection: MongoDB can utilize index intersection when executing queries to combine multiple single-field indexes into an effective compound index. This allows MongoDB to efficiently use existing single-field indexes to satisfy query conditions, even if there is no explicit compound index defined for those fields.
 *
 * Reduced Index Size: In some cases, a compound index may have a smaller size compared to maintaining multiple separate single-field indexes. This can lead to reduced memory usage and storage requirements for maintaining indexes, especially in scenarios with limited resources or large datasets.
 */
@Document(collection = "users")
@CompoundIndex(def = "{'username': 1, 'email': 1}", name = "compound_index")
data class User(
    @Indexed(unique = true)
    val username: String,
    @Indexed(unique = true)
    val email: String
)