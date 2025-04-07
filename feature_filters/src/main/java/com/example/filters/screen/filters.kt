package com.example.filters.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.RadioButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.filters.FiltersViewModel
import java.util.logging.Filter

object FilterState{
    var specState =  mutableStateOf("")
    var cityState =  mutableStateOf("")
    var sourceState =  mutableStateOf(listOf(""))
    var additionalyState =  mutableStateOf(listOf(""))
}
enum class FilterMap(val title: String, val stateValue: MutableState<String>)
{
    SPEC("Специализация", FilterState.specState),
    CITY("Город", FilterState.cityState)
}
enum class FilterMapList(val title: String, val stateValue: MutableState<List<String>>)
{
    SOURCE("Источник", FilterState.sourceState),
    ADDITIONAL("Дополнительно", FilterState.additionalyState)
}

@Composable
fun Filters(viewModel: FiltersViewModel = hiltViewModel()){
    val cityState by viewModel.cityState.collectAsStateWithLifecycle()
    val specState by viewModel.specState.collectAsStateWithLifecycle()

    Column()
    {
        FilterRadioButton(FilterMap.SPEC, specState, 450.dp)
        FilterRadioButton(FilterMap.CITY, cityState, 700.dp)
        FilterCheckBox(FilterMapList.SOURCE,  arrayListOf("hh", "YourCodeReview"), 250.dp)
        FilterCheckBox(FilterMapList.ADDITIONAL, arrayListOf("Удаленно", "Стажировка"), 250.dp)
        Log.d("tempLog", decodeMorse(".... . -.--   .--- ..- -.. ."))
    }
}

@Composable
private fun FilterRadioButton(state: FilterMap, values: ArrayList<String?>, height: Dp)
{
    var checked = rememberSaveable  { mutableStateOf(false) }
    val (selectedOption, onOptionSelected) = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(if (checked.value) height else 70.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(color = Color.White),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = state.title,
                color = Color.DarkGray,
                fontSize = 17.sp
            )

            IconButton(onClick = {checked.value = !checked.value}) {
                Icon(
                    if (checked.value == true) Icons.Filled.KeyboardArrowUp
                    else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Скрыть\\Показать"
                )
            }
        }

        LazyColumn( Modifier
            .alpha(if (checked.value) 1f else 0f)) {
            items(values)
            { it ->
                if (it != null) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.selectable(
                            selected = (it == selectedOption),
                            onClick = { onOptionSelected(it!!)
                                state.stateValue.value = it},
                            role = Role.RadioButton
                        )
                    )
                    {
                        RadioButton(
                            selected = (it == selectedOption),
                            onClick = {
                                onOptionSelected(it!!)
                                state.stateValue.value = it
                            }
                        )
                        Text(text = it.toString(), modifier = Modifier.padding(start = 5.dp))
                    }
                }
            }
        }
    }
}

@Composable
private fun FilterCheckBox(state: FilterMapList, values: ArrayList<String?>, height: Dp)
{
    var checked = rememberSaveable  { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(if (checked.value) height else 70.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(color = Color.White),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = state.title,
                color = Color.DarkGray,
                fontSize = 17.sp
            )

            IconButton(onClick = {checked.value = !checked.value}) {
                Icon(
                    if (checked.value == true) Icons.Filled.KeyboardArrowUp
                    else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Скрыть\\Показать"
                )
            }
        }

        LazyColumn( Modifier
            .alpha(if (checked.value) 1f else 0f)) {
            items(values)
            { it ->
                val checkedState = remember { mutableStateOf(true) }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Checkbox(
                        checked = checkedState.value,
                        onCheckedChange = { checkedState.value = it }
                    )
                    Text(it.toString(), modifier = Modifier.padding(start = 5.dp))
                }
            }
        }
    }
}

fun maxMultiple(d: Int, b: Int): Int {
    if (b%d == 0) return b
    var bb = b
    while (bb%d != 0)
        bb -= 1
    return bb
}

fun decodeMorse(code: String): String{
    val morseMap = mapOf(
        ".-" to "a",
        "-..." to "b",
        "-.-." to "c",
        "-.." to "d",
        "." to "e",
        "..-." to "f",
        "--." to "g",
        "...." to "h",
        ".." to "i",
        ".---" to "j",
        "-.-" to "k",
        ".-.." to "l",
        "--" to "m",
        "-." to "n",
        "---" to "o",
        ".--." to "p",
        "--.-" to "q",
        ".-." to "r",
        "..." to "s",
        "-" to "t",
        "..-" to "u",
        "...-" to "v",
        ".--" to "w",
        "-..-" to "x",
        "-.--" to "y",
        "--.." to "z"
    )
    var res: String = ""
    val arr = code.trim().replace("   ", " / ").split(" ")
    arr.forEach {
        if (it == "/")
            res = res + " "
        else
        for (word in morseMap)
            if (it == word.key) {
                res = res + word.value
                break
            }
    }
    return res
}

