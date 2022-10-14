package com.example.day4_compose_caculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.day4_compose_caculator.ui.theme.Day4_Compose_CaculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {

    var num1 by remember {
        mutableStateOf("")
    }
    var num2 by remember {
        mutableStateOf("")
    }
    var result by remember {
        mutableStateOf("")
    }

    val appBarColor = Color(0xff6200EE)

    Day4_Compose_CaculatorTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Scaffold(
                topBar = { TopAppBar(title = {Text("Compose Calculator")},backgroundColor = appBarColor) },
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = num1,
                        label = { Text(text = "Number 1") },
                        onValueChange = {
                            num1 = it
                        }
                    )
                    OutlinedTextField(
                        value = num2,
                        label = { Text(text = "Number 2") },
                        onValueChange = {
                            num2 = it
                        }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = {
                                if(checkIntegers(num1, num2)) {
                                    val addResult: Int = num1.toString().toInt() + num2.toString().toInt()
                                    result = addResult.toString()
                                } else {
                                    result = "Please give valid numbers Bruh!"
                                }
                            },
                            modifier = Modifier
                                .width(130.dp)
                                .height(40.dp)
                        ) {
                            Text(text = "+")
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Button(
                            onClick = {
                                if(checkIntegers(num1, num2)) {
                                    val addResult: Int = num1.toString().toInt() - num2.toString().toInt()
                                    result = addResult.toString()
                                } else {
                                    result = "Please give valid numbers Bruh!"
                                }
                            },
                            modifier = Modifier
                                .width(130.dp)
                                .height(40.dp)
                        ) {
                            Text(text = "-")
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = {
                                if(checkIntegers(num1, num2)) {
                                    val addResult: Int = num1.toString().toInt() * num2.toString().toInt()
                                    result = addResult.toString()
                                } else {
                                    result = "Please give valid numbers Bruh!"
                                }
                            },
                            modifier = Modifier
                                .width(130.dp)
                                .height(40.dp)
                        ) {
                            Text(text = "*")
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Button(
                            onClick = {
                                if(checkIntegers(num1, num2)) {
                                    val addResult: Int = num1.toString().toInt() / num2.toString().toInt()
                                    result = addResult.toString()
                                } else {
                                    result = "Please give valid numbers Bruh!"
                                }
                            },
                            modifier = Modifier
                                .width(130.dp)
                                .height(40.dp)
                        ) {
                            Text(text = "/")
                        }
                    }

                    OutlinedTextField(
                        value = result,
                        label = { Text(text = "Result") },
                        onValueChange = {
                            result = it
                        },
//                    enabled = false
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = {
                            num1 = ""
                            num2 = ""
                            result = ""
                        },
                        modifier = Modifier
                            .width(280.dp)
                            .height(50.dp)
                    ) {
                        Text(text = "Clear")
                    }
                }
            }
        }
    }
}

fun checkIntegers(num1: String, num2: String): Boolean {
    var flag: Boolean = true
    if(num1.toString() == "" || num2.toString() == "") {
        flag = false
    }
    return flag
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    App()
}