package com.example.lab_7

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.nio.file.WatchEvent

@Composable
fun DriversScreen(navController: NavController) {
    var driver by remember { mutableStateOf("") }
    var driverlist = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.testTag("backButton") // for testing
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Drivers",
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                value = driver,
                onValueChange = {
                    driver= it
                },
                label = {
                    Text("Add Driver")
                },
                modifier = Modifier.testTag("driverInput")
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (driver.isNotBlank()) {
                        driverlist.add(driver)
                        driver = ""
                    }
                },
                modifier = Modifier.testTag("addDriverButton")
            ) {
                Text("Add")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    driverlist.clear()
                },
                modifier = Modifier.testTag("clearDriversButton")
            ) {
                Text("Clear")
            }
        }

        LazyColumn() {
            items(driverlist) { driver ->
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = driver,
                    fontSize = 24.sp
                )
            }
        }
    }
}