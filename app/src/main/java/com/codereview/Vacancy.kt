package com.codereview

data class Vacancy(
    val id: String,
    val company: String,
    val vacancy: String,
    val published: String,
    val extras: List<Pair<String?, String?>>
)
