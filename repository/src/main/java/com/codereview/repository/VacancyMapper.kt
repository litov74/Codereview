package com.codereview.repository

import com.codereview.network.VacancyNet

fun VacancyNet.toVacancy(): Vacancy = Vacancy(
    id = id ?: 0,
    active = active ?: false,
    companyName = companyName.orEmpty(),
    salary = salary.orEmpty(),
    speciality = speciality.orEmpty(),
    remote = remote ?: false,
    url = url.orEmpty(),
    description = description.orEmpty(),
    title = title.toString(),
    externalId = externalId ?: 0,
    location = location.orEmpty(),
    internship = internship ?: false
)