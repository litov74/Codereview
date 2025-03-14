package com.codereview.feature_vacansies

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.codereview.core.theme.PurpleGrey80
import com.codereview.core.theme.Whisper
import com.codereview.feature_vacansies.state.VacanciesState
import com.codereview.repository.vacancy_repository.Vacancy
import com.codereview.core.R as coreR

@Composable
fun VacanciesScreen(
    modifier: Modifier = Modifier,
    vacanciesArg: String?,
    viewModel: VacanciesViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = viewModel) {
        viewModel.getVacancies(vacanciesArg ?: "")
    }

    when (state) {
        VacanciesState.Loading -> VacanciesLoading()

        is VacanciesState.Error -> {
            val message = (state as VacanciesState.Error).message
            VacanciesError(
                errorMessage = message,
                onRefreshVacancies = { viewModel.getVacancies(vacanciesArg ?: "") }
            )
        }

        is VacanciesState.Ready -> {
            val vacancies = (state as VacanciesState.Ready).data
            VacancyList(
                vacancies = vacancies,
                onVacancyClick = viewModel::onVacancyClick
            )
        }
    }
}

@Composable
fun VacancyList(
    vacancies: List<Vacancy>,
    onVacancyClick: (String) -> Unit,
) {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(color = PurpleGrey80),
    ) {
        items(vacancies) { vacancy ->
            VacancyItem(
                vacancy = vacancy,
                onItemClick = onVacancyClick
            )
        }
    }
}

@Composable
fun VacancyItem(
    vacancy: Vacancy,
    onItemClick: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(color = Color.White)
            .clickable { onItemClick(vacancy.url) },
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = vacancy.companyName,
                color = Color.DarkGray,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                vacancy.title,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(8.dp))
            vacancy.getExtras().forEach { component ->
                if (component.first.isNotEmpty() && component.second.isNotEmpty()) {
                    run {
                        VacancyExtrasItem(
                            name = component.first,
                            description = component.second
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
            Text(
                text = "Опубликовано: ${vacancy.companyName}",
                color = Color.Gray,
                fontSize = 17.sp
            )
        }
    }
}

@Composable
fun VacanciesLoading(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = PurpleGrey80)
    ) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun VacanciesError(
    modifier: Modifier = Modifier,
    errorMessage: String?,
    onRefreshVacancies: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier
                .padding(16.dp),
            text = errorMessage ?: "Unknown error",
            color = Color.Red,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(32.dp))
                .clickable(onClick = onRefreshVacancies),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "Обновить"
            )
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = null
            )
        }
    }
}

@Composable
private fun VacancyExtrasItem(
    name: String?,
    description: String?
) {
    name?.let { _name ->
        description?.let { _description ->
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(color = Whisper)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (_name.contains("Удаленно")) {
                    Image(
                        painter = painterResource(coreR.drawable.baseline_work_24),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .padding(start = 4.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = _name
                    )
                } else if (_name.contains("Адрес") && !description.isNullOrEmpty()) {
                    Image(
                        painter = painterResource(coreR.drawable.baseline_location_on_24),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .padding(start = 4.dp)
                    )
                } else if (!_name.contains("З/п") && !_name.contains("Адрес") && _name.isNotBlank()) {
                    Text(
                        text = _name
                    )
                }
                Text(
                    text = _description,
                    color = Color.DarkGray,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
    }
}
