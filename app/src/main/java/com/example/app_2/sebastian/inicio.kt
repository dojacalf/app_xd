// inicio.kt
package com.example.app_2.Provarjetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
// Asegúrate de tener solo una importación para Text de Material 3
import androidx.compose.material3.Text // Correcto si usas Material 3
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_2.R
import com.example.app_2.ui.theme.fredoka // Asegúrate que este import sea correcto o define fredoka aquí
import androidx.navigation.NavController // Importa NavController
// import androidx.navigation.compose.rememberNavController // Ya no es necesario aquí



val Fredoka = FontFamily(Font(R.font.fredoka_semibold)) //

// @Preview // El Preview no podrá pasar un NavController real, puedes comentarlo o usar un NavController de prueba
@Composable
fun InicioScreen(navController: NavController) { // Acepta NavController como parámetro

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LogoSection(
            modifier = Modifier.weight(6f)
        )

        WelcomeSection(
            modifier = Modifier.weight(4f),
            navController = navController // Pasa el navController a WelcomeSection
        )

        LoginSection( // Pasa navController si necesitas navegar desde LoginSection también
            modifier = Modifier.weight(3f),
            navController = navController
        )
    }
}

@Composable
private fun LogoSection(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.perro2), //
            contentDescription = "Logo de la aplicación",
            modifier = Modifier.fillMaxWidth(0.5f), //
            contentScale = ContentScale.Crop //
        )
    }
}

@Composable
private fun WelcomeSection(
    modifier: Modifier = Modifier,
    navController: NavController // Acepta NavController
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hey! ¡Bienvenido! \uD83D\uDE0A", //
            style = TextStyle(
                fontSize = 30.sp, //
                fontFamily = Fredoka //
            ),
            modifier = Modifier.padding(vertical = 15.dp) //
        )

        Text(
            text = buildAnnotatedString { //
                append("Aquí Cada Huellita Cuenta y\n") //
                append("Cada Historia Merece Un Final\n") //
                append("Feliz 💗") //
            },
            style = TextStyle(
                fontSize = 20.sp, //
                fontFamily = fredoka, // Asumo que 'fredoka' es similar a 'Fredoka' o está definido correctamente
                lineHeight = 23.sp //
            ),
            textAlign = TextAlign.Center, //
            modifier = Modifier.padding(horizontal = 30.dp) //
        )
        Spacer(modifier = Modifier.height(40.dp)) //
        StartButton(
            onClick = {
                // Navega a LoginScreen usando la ruta definida
                navController.navigate("encuentra1")
            }
        )
    }
}

@Composable
fun StartButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick, // Aquí se llama a la lambda que ahora contiene la navegación
        modifier = modifier.height(50.dp), //
        colors = ButtonDefaults.buttonColors( //
            containerColor = amarillo //
        ),
        shape = RoundedCornerShape(25.dp) //
    ) {
        Text(
            text = "EMPEZAR", //
            style = TextStyle(
                color = Color.White, //
                fontSize = 25.sp, //
                fontFamily = Fredoka //
            )
        )
    }
}

@Composable
private fun LoginSection(
    modifier: Modifier = Modifier,
    navController: NavController // Acepta NavController para la navegación de "Iniciar Sesión"
) {
    Column(
        modifier = modifier.fillMaxWidth(), //
        horizontalAlignment = Alignment.CenterHorizontally, //
        verticalArrangement = Arrangement.Center //
    ) {
        Text(
            text = "Crea Una cuenta", //
            style = TextStyle(
                fontSize = 30.sp, //
                fontFamily = Fredoka //
            ),
            modifier = Modifier.padding(bottom = 20.dp).clickable { //
                navController.navigate("registro")
            } //

        )

        Text(
            text = "Iniciar Sesión", //
            style = TextStyle(
                fontSize = 30.sp, //
                fontWeight = FontWeight.W700, //
                fontFamily = Fredoka, //
                color = amarillo //
            ),
            modifier = Modifier.clickable { //
                navController.navigate("login_screen")
            }
        )
    }
}

// Para el Preview de InicioScreen, si quieres que funcione sin errores de NavController:
@Preview(showBackground = true)
@Composable
fun InicioScreenPreview() {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LogoSection(modifier = Modifier.weight(6f))
        WelcomeSectionPreviewHelper(modifier = Modifier.weight(4f))
        LoginSectionPreviewHelper(modifier = Modifier.weight(3f))
    }
}

@Composable
private fun WelcomeSectionPreviewHelper(modifier: Modifier = Modifier) {
    // Esta es una versión simplificada de WelcomeSection para el Preview
    // sin la lógica de navegación real.
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hey! ¡Bienvenido! \uD83D\uDE0A",
            style = TextStyle(fontSize = 30.sp, fontFamily = Fredoka),
            modifier = Modifier.padding(vertical = 15.dp)
        )
        Text(
            text = buildAnnotatedString {
                append("Aquí Cada Huellita Cuenta y\n")
                append("Cada Historia Merece Un Final\n")
                append("Feliz 💗")
            },
            style = TextStyle(fontSize = 20.sp, fontFamily = fredoka, lineHeight = 23.sp),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 30.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        StartButton(onClick = { /* En Preview, no hace nada */ })
    }
}

@Composable
private fun LoginSectionPreviewHelper(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Crea Una cuenta",
            style = TextStyle(fontSize = 30.sp, fontFamily = Fredoka),
            modifier = Modifier.padding(bottom = 20.dp)
        )
        Text(
            text = "Iniciar Sesión",
            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.W700, fontFamily = Fredoka, color = amarillo),
            modifier = Modifier.clickable { /* En Preview, no hace nada */ }
        )
    }
}