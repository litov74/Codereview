package com.codereview

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomePage(
    jobsList: List<JobSpec> = JobsList.list,
    onNavigateToVacancies: (String) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val gridCellsNumber = getGridCellsNumber()

        Column {
            ShowTitle()
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                ShowGrid(
                    columnsNumber = gridCellsNumber,
                    jobsList = jobsList,
                    onClicked = onNavigateToVacancies
                )
            }
        }
    }
}

@Composable
fun ShowTitle() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            stringResource(R.string.title_one),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            stringResource(R.string.title_two),
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ShowGrid(
    columnsNumber: Int,
    jobsList: List<JobSpec>,
    onClicked: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(columnsNumber),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(items = jobsList) { job ->
            JobCard(
                jobTitle = job.jobTitle,
                logoId = job.logoId,
                onSelected = onClicked
            )
        }
    }
}

@Composable
fun JobCard(
    jobTitle: String,
    logoId: Int,
    onSelected: (String) -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.onPrimary,
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 8.dp,
        tonalElevation = 8.dp,
        modifier = Modifier.wrapContentWidth(),
        onClick = { onSelected("/$jobTitle") }
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Column(modifier = Modifier.width(130.dp)) {
                Surface(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(5.dp),
                ) {
                    Text(
                        stringResource(R.string.remote_work),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(5.dp)
                    )
                }
                Spacer(modifier = Modifier.height(3.dp))
                Surface(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(5.dp),
                ) {
                    Text(
                        stringResource(R.string.junior_jobs),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(5.dp)
                    )
                }
                Spacer(modifier = Modifier.height(3.dp))
                Surface(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(5.dp),
                ) {
                    Text(
                        stringResource(R.string.internship),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(5.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    jobTitle,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Image(
                painter = painterResource(id = logoId),
                contentDescription = jobTitle
            )
        }
    }
}

@Composable
fun getGridCellsNumber(): Int {
    val configuration = LocalConfiguration.current
    return when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> 3
        Configuration.ORIENTATION_PORTRAIT -> 1
        else -> 1
    }
}

