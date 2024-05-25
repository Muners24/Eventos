package com.evento


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evento.ui.theme.Blue1
import com.evento.ui.theme.Blue3
import com.evento.ui.theme.Blue4
import com.evento.ui.theme.Blue5
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalConfiguration
import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick
import androidx.constraintlayout.widget.ConstraintLayout


class View(roli: Int, opi: Int) {
    var rol by mutableIntStateOf(roli)
    var op by mutableIntStateOf(opi)

    @Composable
    fun Pantalla() {

        if(op != -34){
            MainMenu()
        }

        Text(
            text = op.toString(),
            fontSize = 40.sp,
            color = Color.Black,
            modifier = Modifier
                .size(50.dp,50.dp)
                .offset(50.dp,50.dp)
        )

    }

    @Composable
    fun MainMenu(){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Blue1)
        ) {}
        val opciones = mutableListOf<String>()
        val imagenes = mutableListOf<Int>()
        var puesto = ""
        when (rol) {
            0 -> {
                puesto = "Encargado"
                opciones.add("Registrar\nEvento")
                opciones.add("Médicos")
                opciones.add("Datos\nMédicos")
                opciones.add("Accidentes")
                imagenes.add(R.drawable.podio)
                imagenes.add(R.drawable.ambulancia)
                imagenes.add(R.drawable.part)
                imagenes.add(R.drawable.ambulancia)
            }
            1 -> {
                puesto = "Staff"
                opciones.add("Registrar\nAccidente")
                opciones.add("Registrar\nCorredor")
                imagenes.add(R.drawable.podio)
                imagenes.add(R.drawable.part)
            }
            2 -> {
                puesto = "Médico"
                opciones.add("Accidente")
                opciones.add("Disponible")
                imagenes.add(R.drawable.podio)
                imagenes.add(R.drawable.ambulancia)
            }
        }


        TopBar(puesto)
        var actual = 60
        for (i in opciones.indices) {
            Option(opciones[i], actual + 30, imagenes[i]){
                op = i
            }
            val saltos = countSaltos(opciones[i])
            actual += 140 + (saltos * 30 + saltos * 12)
        }
        TopButtonRight{
            if (rol != 2)
                rol++
            op=-1
        }
        TopButtonLeft{
            if (rol != 0)
                rol--
            op=-1
        }

        BotBar()
    }

    @Composable
    fun EncargadoMedicos(){
        //falta implementar
    }

    @Composable
    fun EncargadoEvento(){
        //falta implementar
    }

    @Composable
    fun StaffAccidente(){
        //falta implementar
    }

    @Composable
    fun MedicoAccidente(){
        //falta implementar
    }

    @Composable
    fun MedicoDisponibilidad(){
        //falta implementar
    }

    @Composable
    fun TopButtonLeft(onClick: () -> Unit) {
        Canvas(
            modifier = Modifier
                .size(40.dp)
                .offset(10.dp, 10.dp)
                .clickable {onClick()}
        ) {
            drawCircle(
                color = Blue4,
                radius = size.minDimension / 2
            )
        }
        Image(
            painter = painterResource(id = R.drawable.arrow_back2),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .offset(10.dp, 10.dp)
        )
    }

    @Composable
    fun TopButtonRight(onClick: () -> Unit) {

        val ancho = LocalConfiguration.current.screenWidthDp
        Canvas(
            modifier = Modifier
                .size(40.dp)
                .offset((ancho - 50).dp, 10.dp)
                .clickable {onClick()}
        ) {
            drawCircle(
                color = Blue4,
                radius = size.minDimension / 2
            )
        }

        Image(
            painter = painterResource(id = R.drawable.arrow_forward),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .offset((ancho - 50).dp, 10.dp)
        )


    }

    @Composable
    fun TopBar(puesto: String = "") {
        val ancho = LocalConfiguration.current.screenWidthDp

        Box(
            modifier = Modifier
                .size(ancho.dp, 60.dp)
                .background(Blue3)
        )
        Text(
            text = puesto,
            fontSize = 43.sp,
            color = Blue1,
            modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp, -2.dp),
            textAlign = TextAlign.Center
        )
    }

    @Composable
    fun Option(optxt: String = "", y: Int = 0, img: Int = 0,onClick: () -> Unit) {
        val saltos = countSaltos(optxt)
        val ajustebox = (saltos * 30 + saltos * 12)
        val ancho = LocalConfiguration.current.screenWidthDp

        Box(
            modifier = Modifier
                .size((ancho - 30).dp, 110.dp + ajustebox.dp)
                .offset(15.dp, y.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Blue3)
                .clickable {onClick()}
        )

        Text(
            text = optxt,
            fontSize = 42.sp,
            color = Blue1,
            modifier = Modifier
                .size(363.dp, 160.dp)
                .offset((ancho / 11).dp, y.dp + 22.dp),
            textAlign = TextAlign.Left
        )

        val ajusteimgy = when (optxt) {
            "Registrar\nEvento", "Registrar\nAccidente" -> y + 56
            "Médicos" -> y + 145
            "Datos\nMédicos" -> y + 208
            "Registrar\nCorredor" -> y + 135
            "Accidente" -> y + 23
            "Disponible" -> y + 120
            "Accidentes" -> y + 315
            else -> y
        }

        Image(
            painter = painterResource(id = img),
            contentDescription = null,
            modifier = Modifier
                .scale(scaleX = 0.65f, scaleY = 0.65f)
                .offset((ancho - 80).dp, ajusteimgy.dp)
        )
    }

    @Composable
    fun BotBar() {
        val alto = LocalConfiguration.current.screenHeightDp
        val ancho = LocalConfiguration.current.screenWidthDp
        Box(
            modifier = Modifier
                .size(ancho.dp, 61.dp)
                .offset(0.dp, (alto - 60).dp)
                .background(Blue5)
                .fillMaxWidth()
        )

        Image(
            painter = painterResource(id = R.drawable.options),
            contentDescription = null,
            modifier = Modifier
                .size(55.dp, 55.dp)
                .offset(44.dp, (alto - 52).dp)
                .clickable { /* acción */ }
        )

        Image(
            painter = painterResource(id = R.drawable.home),
            contentDescription = null,
            modifier = Modifier
                .size(47.dp, 47.dp)
                .offset((ancho / 2 - 22).dp, (alto - 51).dp)
                .clickable { /* acción */ }
        )

        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = null,
            modifier = Modifier
                .size(55.dp, 55.dp)
                .offset((ancho - 97).dp, (alto - 54).dp)
                .clickable { /* acción */ }
        )
    }

    fun countSaltos(text: String): Int {
        return text.count { it == '\n' }
    }
}

class Compose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val rol = rememberSaveable { mutableStateOf(0) }
            val op = rememberSaveable { mutableStateOf(-1) }
            val view = remember { View(roli = rol.value, op.value) }

            view.Pantalla()

            LaunchedEffect(view.rol, view.op) {
                rol.value = view.rol
                op.value = view.op
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserProfile() {
    val rol = rememberSaveable { mutableStateOf(0) }
    val op = rememberSaveable { mutableStateOf(-1) }
    val view = remember { View(rol.value, op.value) }

    view.Pantalla()

}




