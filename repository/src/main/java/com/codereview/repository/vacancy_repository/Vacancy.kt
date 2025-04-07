package com.codereview.repository.vacancy_repository

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
    val internship: Boolean
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

}