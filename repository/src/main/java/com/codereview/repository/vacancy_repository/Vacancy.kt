package com.codereview.repository.vacancy_repository

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Vacancy(
    val id: String,
    val active: Boolean,
    val companyName: String,
    val salary: String,
    val speciality: String,
    val remote: Boolean,
    val url: String,
    val description: String,
    val title: String,
    val externalId: String,
    val location: String,
    val internship: Boolean,
    val datePublication: String,
) {

    fun getExtras(): Iterator<Pair<String, String>> {
        return listOf(
            Pair("З/п: ", salary.toSalary()),
            Pair("Удаленно: ", remote.humanize()),
            Pair("Адрес: ", location),
            Pair("Стажировка: ", internship.humanize()),
        ).iterator()
    }

    private fun Boolean.humanize(): String = if (this) "Да" else "Нет"

    private fun String?.toSalary(): String =
        if (this?.isBlank() == true) "з/п не указана"
        else "$this"

    fun formatSalary(salary: String?): String {
        return when {
            salary.isNullOrBlank() -> "з/п не указана"
            salary.equals("null", ignoreCase = true) -> "з/п не указана"
            else -> {
                val cleaned = salary
                    .removePrefix("$")
                    .replace("$", "")
                    .replace(",", "")
                    .replace(" ", "")
                    .replace("-", " - ")
                    .trim()

                when {
                    cleaned.isEmpty() -> "з/п не указана"
                    cleaned.contains("RUR", ignoreCase = true) -> cleaned
                        .replace("RUR", " RUR")
                        .trim()
                    else -> "$cleaned \$"
                }
            }
        }
    }

    fun formatDate(isoDate: String): String {
        val inputFormatter = DateTimeFormatter.ISO_DATE_TIME
        val outputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")

        return try {
            val dateTime = LocalDateTime.parse(isoDate, inputFormatter)
            dateTime.format(outputFormatter)
        } catch (e: Exception) {
            "Некорректная дата"
        }
    }
}