package com.codereview

fun GetVacancies(): ArrayList<Vacancy> {
    val vac1 = Vacancy("Naumen", "Junior Frontend Developer",
        "Екатеринбург", "", "", "29.12.2024")
    val vac2 = Vacancy("Зазекс", "Начинающий фронтенд разработчик",
        "Ростов-на-Дону", "", "40000 RUR", "28.12.2024")
    val vac3 = Vacancy("AliExpress2", "Junior C# Developer",
        "Москва", "Удаленно", "200000 RUR", "28.12.2024")
    val vac4 = Vacancy("Майнитек", "Junior QA инженер",
        "Екатеринбург", "", "", "27.12.2024")
    val vac5 = Vacancy("СБЕР", "Junior Dara Engineer",
        "Москва", "", "200000 RUR", "28.12.2024")
    return arrayListOf(vac1, vac2, vac3, vac4, vac5)
}