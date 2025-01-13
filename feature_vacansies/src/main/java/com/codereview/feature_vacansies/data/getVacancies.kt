package com.codereview.feature_vacansies.data

fun getVacancies(): List<Vacancy> =
    listOf(
        Vacancy(
            id = "1",
            company = "Naumen",
            vacancy = "Junior Frontend Developer",
            published = "29.12.2024",
            extras = listOf(
                Pair("city", "Екатеринбург"),
                Pair("shift", ""),
                Pair("salary", ""),
                Pair("test", "test_item")
            )
        ),
        Vacancy(
            id = "2",
            company = "Зазекс",
            vacancy = "Начинающий фронтенд разработчик",
            published = "28.12.2024",
            extras = listOf(
                Pair("city", "Ростов-на-Дону"),
                Pair("shift", ""),
                Pair("salary", "40000")
            )
        ),
        Vacancy(
            id = "3",
            company = "AliExpress2",
            vacancy = "Junior C# Developer",
            published = "28.12.2024",
            extras = listOf(
                Pair("city", "Москва"),
                Pair("shift", "remote"),
                Pair("salary", "200000")
            )
        ),
        Vacancy(
            id = "4",
            company = "Майнитек",
            vacancy = "Junior QA инженер",
            published = "27.12.2024",
            extras = listOf(
                Pair("city", "Екатеринбург"),
                Pair("shift", ""),
                Pair("salary", "")
            )
        ),
        Vacancy(
            id = "5",
            company = "СБЕР",
            vacancy = "Junior Dara Engineer",
            published = "28.12.2024",
            extras = listOf(
                Pair("city", "Москва"),
                Pair("shift", ""),
                Pair("salary", "200000")
            )
        )
    )