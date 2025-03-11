package com.codereview.repository.vacancy_repository

import com.codereview.network.model.VacancyNet

fun VacancyNet.toVacancy(): Vacancy = Vacancy(
    id = id.toString(),
    active = active ?: false,
    companyName = companyName.orEmpty(),
    salary = salary.orEmpty(),
    speciality = speciality.orEmpty(),
    remote = remote ?: false,
    url = url.orEmpty(),
    description = description.orEmpty(),
    title = title.toString(),
    externalId = externalId ?: "",
    location = location.orEmpty(),
    internship = internship ?: false
)