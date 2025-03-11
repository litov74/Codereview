package com.codereview.feature_vacansies

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import com.codereview.core.theme.toSalary
import com.codereview.core.theme.toShiftType
import com.codereview.repository.vacancy_repository.Vacancy
import com.codereview.core.R as coreR

@Composable
fun VacancyList(
    vacanciesArg: String?,
    viewModel: VacanciesViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = viewModel) {
        viewModel.getVacancies(vacanciesArg ?: "")
    }

    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(color = PurpleGrey80),
    ) {
        items(uiState.vacancies) { vacancy ->
            VacancyItem(
                vacancy = vacancy,
                onItemClick = viewModel::onVacancyClick
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
            modifier = Modifier.padding(16.dp) //только для общего паддинга, т.к. мы не используем scaffold
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
            /*LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 150.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height((32 * vacancy.extras.size).dp),
                userScrollEnabled = false,
            ) {
                items(vacancy.extras) { item ->
                    VacancyExtrasItem(
                        name = item.first,
                        description = item.second
                    )
                }
            }*/
            Text(
                text = "Опубликовано: ${vacancy.companyName}",
                color = Color.Gray,
                fontSize = 17.sp
            )
        }
    }
}

@Composable
private fun VacancyExtrasItem(
    name: String?,
    description: String?
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(color = Whisper)
            .height(32.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        name?.let { _name ->
            if (_name.contains("city")) {
                Image(
                    painter = painterResource(coreR.drawable.baseline_work_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(start = 4.dp)
                )
            } else if (_name.contains("shift")) {
                Image(
                    painter = painterResource(coreR.drawable.baseline_location_on_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(start = 4.dp)
                )
            }
            description?.let { _description ->
                Text(
                    text = if (_name == "city") _description
                    else if (_name == "shift") _description.toShiftType()
                    else if (_name == "salary") _description.toSalary()
                    else "",
                    color = Color.DarkGray,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
    }
}
