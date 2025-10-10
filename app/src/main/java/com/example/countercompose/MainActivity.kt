package com.example.countercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Scaffold

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Scaffold(
                modifier = Modifier.fillMaxSize()
            ) { innerPadding ->
                // ✅ Se pasa el padding interno correctamente
                MainScreen(Modifier.padding(innerPadding))
            }
        }
    }
}


@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    // ✅ Variable de estado del contador
    var counter by remember { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxHeight()
    ) {
        // ✅ Título del contador
        Text(
            text = stringResource(id = R.string.counter_text),
            fontSize = 44.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        // ✅ Valor actual del contador
        Text(
            text = counter.toString(),
            fontSize = 54.sp,
            fontWeight = FontWeight.Bold
        )

        // ✅ Fila con los botones + y -
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Botón para aumentar el contador
            Button(onClick = { counter++ }) {
                Text(
                    text = stringResource(id = R.string.plus),
                    fontSize = 44.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }

            // Botón para disminuir el contador (sin bajar de 0)
            Button(onClick = {
                if (counter > 0) {
                    counter--
                }
            }) {
                Text(
                    text = stringResource(id = R.string.minus),
                    fontSize = 44.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}

// ✅ Vista previa en el editor (sin necesidad de ejecutar la app)
@Preview
@Composable
fun MainScreenPreview() { @androidx.compose.runtime.Composable {
    MainScreen(Modifier.padding(20.dp))
}
}

