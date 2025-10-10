package com.example.settings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SettingsContainer(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

@Composable
fun SettingsContainer(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp)
    ) {
        SettingsHeader()
        SettingsImage()
        SettingsCheckbox()
        SettingsSwitch()
        SettingsSlider()
        SettingsRadioButtons()
        SettingsAlertDialog()
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsContainerPreview() {
        SettingsContainer()
    }


@Composable
fun SettingsHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Settings",
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(end = 10.dp)
        )
        Icon(
            imageVector = Icons.Default.Settings,
            contentDescription = "Settings Icon"
        )
    }
}

@Composable
fun SettingsImage() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8. dp)
            .padding( start = 16 . dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Profile Image", fontSize = 18.sp)
        Image(
            painter = painterResource(id = R.drawable.sunflower),
            contentDescription = "Profile Image",
            modifier = Modifier
                .height(34.dp)
                .padding(end = 10.dp)
                .clickable { /* Cambiar imagen */ }
        )
    }
}

@Composable
fun SettingsCheckbox() {
    var isChecked by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8. dp)
            .padding( start = 16 . dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Accept non-essential cookies?", fontSize = 18.sp)
        Checkbox(checked = isChecked, onCheckedChange = { isChecked = it })
    }
}

@Composable
fun SettingsSwitch() {
    var isChecked by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8. dp)
            .padding( start = 16 . dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Download using mobile data?", fontSize = 18.sp)
        Switch(checked = isChecked, onCheckedChange = { isChecked = it })
    }
}

@Composable
fun SettingsSlider() {
    var sliderValue by remember { mutableStateOf(0f) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8. dp)
            .padding( start = 16 . dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Text size:", fontSize = 18.sp)
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            steps = 2,
            modifier = Modifier.width(200.dp)
        )
    }
}

@Composable
fun SettingsRadioButtons() {
    var selectedPaymentMethod by remember { mutableStateOf("PayPal") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Preferred payment method", modifier = Modifier.padding(bottom = 8.dp))
        listOf("PayPal", "Credit Card", "Bank Transfer").forEach { method ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                RadioButton(
                    selected = (selectedPaymentMethod == method),
                    onClick = { selectedPaymentMethod = method }
                )
                Text(text = method, modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}

@Composable
fun SettingsAlertDialog() {
    var showDialog by remember { mutableStateOf(false) }

    Button(onClick = { showDialog = true }) {
        Text("Sign out")
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Sign out") },
            text = { Text("Are you sure?") },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("OK")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}
