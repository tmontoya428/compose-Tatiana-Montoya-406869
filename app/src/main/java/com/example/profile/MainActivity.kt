package com.example.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.darkColorScheme

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF1E88E5),
    secondary = Color(0xFF1565C0),
    tertiary = Color(0xFF81D4FA)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF2196F3),
    secondary = Color(0xFF64B5F6),
    tertiary = Color(0xFF03A9F4),
    background = Color(0xFFF2F2F2),
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

@Composable
fun ProfileTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colors,
        typography = Typography(),
        content = content
    )
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFF2F2F2))
                ) { innerPadding ->
                    Profile(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Profile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 8.dp,
        color = Color.White
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            // Imagen de perfil
            Box(modifier = Modifier.size(116.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.cat),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(50.dp))
                )

                Card(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .clickable { /* TODO: acción editar */ },
                    border = BorderStroke(1.dp, SolidColor(Color.Blue)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Edit",
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                        fontSize = 12.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre
            Text(
                text = "Miss Montoya",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 16.dp)
            )

            // Descripción
            Text(
                text = "Mi gatica",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            // Botones
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = { /* TODO */ }) { Text("Follow") }
                Button(onClick = { /* TODO */ }) { Text("Message") }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    ProfileTheme {
        Profile(modifier = Modifier.padding(20.dp))
    }
}