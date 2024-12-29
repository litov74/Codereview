package com.codereview.ui.theme

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codereview.R
import com.codereview.Vacancy

@Composable
fun VacancyList(vacancies: ArrayList<Vacancy>) {
    LazyColumn(
        Modifier.fillMaxSize().background(Whisper),
    ) {
        items(vacancies) {
            Vacancy(it)
        }
    }
}

@Composable
fun Vacancy(vacancy: Vacancy) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 10.dp, 20.dp, 5.dp)
            .clickable { Log.d("click", vacancy.vacancy) },
        shape = RoundedCornerShape(35.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White,),
        content = {
            Row(){
                Text(
                    vacancy.company, color = Color.DarkGray, fontSize = 17.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(25.dp, 20.dp, 20.dp, 5.dp))
            }
            Row(){
                Text(
                    vacancy.vacancy, color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(25.dp, 15.dp, 20.dp, 10.dp))
            }
            Row(){
                Column {
                    Card(modifier = Modifier.padding(25.dp, 10.dp, 5.dp, 0.dp),
                        shape = RoundedCornerShape(7.dp),
                        colors = CardDefaults.cardColors(containerColor = WhiteSmoke))
                    {
                        Row(modifier = Modifier.padding(7.dp)){
                            Image(
                                painter = painterResource(id = R.drawable.baseline_work_24),
                                contentDescription = "Work",
                            )
                            Text(vacancy.city, color = Color.DarkGray, fontSize = 15.sp, modifier = Modifier.padding(5.dp, 0.dp))
                        }
                    }
                }
                if (vacancy.graffic != "")
                {
                    Column {
                        Card(modifier = Modifier.padding(5.dp, 10.dp, 5.dp, 0.dp),
                            shape = RoundedCornerShape(7.dp),
                            colors = CardDefaults.cardColors(containerColor = WhiteSmoke))
                        {
                            Row(modifier = Modifier.padding(7.dp)){
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_location_on_24),
                                    contentDescription = "Location",
                                )
                                Text(vacancy.graffic, color = Color.DarkGray, fontSize = 15.sp, modifier = Modifier.padding(5.dp, 0.dp))
                            }
                        }
                    }
                }
                Column(modifier = Modifier.fillMaxWidth().padding(10.dp))
                {
                    Text(if(vacancy.salary == "") "з/п не указана" else vacancy.salary, color = Color.DarkGray, fontSize = 15.sp,
                        modifier = Modifier
                        .background(WhiteSmoke, RoundedCornerShape(7.dp))
                            .padding(7.dp))
                }
            }
            Row(modifier = Modifier.padding(25.dp, 15.dp, 10.dp, 15.dp)){
                Text("Опубликовано: " + vacancy.published, color = Color.Gray, fontSize = 17.sp)
            }
        }
    )
}

