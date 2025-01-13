package com.codereview.core.theme

fun String?.toShiftType(): String =
    if (this?.contains("remote") == true) "Удаленно"
    else if (this?.isBlank() == true) "Не указано"
    else this ?: ""

fun String?.toSalary(): String =
    if (this?.isBlank() == true) "з/п не указана"
    else "$this RUR"