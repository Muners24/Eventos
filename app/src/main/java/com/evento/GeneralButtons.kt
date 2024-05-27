package com.evento

import android.util.Log
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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evento.ui.theme.*

@Composable
fun SingleCampoTxt(what: String = "",x: Int = 0,y: Int = 0, modifier: Modifier = Modifier, onClick: (String) -> Unit){
    var text by rememberSaveable { mutableStateOf("") }
    var ancho = LocalConfiguration.current.screenWidthDp
    TextField(value = text, onValueChange = { newValue -> text = newValue}, modifier = modifier
        .fillMaxWidth(),
        label = { Text(what, textAlign = TextAlign.Center, modifier = Modifier) },
        singleLine = true
    )
    if(text != ""){
        Image(painter = painterResource(id = R.drawable.save), contentDescription = null, modifier = Modifier
            .size(40.dp, 40.dp)
            .offset((ancho - x*2.2).dp, (y+5).dp)
            .clickable { onClick(text) }
        )
    }
}

@Composable
fun SingleNumCampoTxt(what: String = "",x: Int = 0,y: Int = 0, modifier: Modifier = Modifier, onClick: (String) -> Unit){
    var text by rememberSaveable { mutableStateOf("as") }
    var ancho = LocalConfiguration.current.screenWidthDp
    TextField(value = text, onValueChange = { newValue -> text = newValue}, modifier = modifier
        .fillMaxWidth()
        .padding(15.dp, 1.dp),
        label = { Text(what, textAlign = TextAlign.Center, modifier = Modifier) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true
    )
    if(text != ""){
        Image(painter = painterResource(id = R.drawable.save), contentDescription = null, modifier = Modifier
            .size(40.dp, 40.dp)
            .offset((ancho - x*4.5).dp, 67.dp)
            .clickable { onClick(text) }
        )
    }
}

@Composable
fun CampoTxt(what: String = "",padding: Int = 0, modifier: Modifier = Modifier, onClick: (String) -> Unit){
    var text by rememberSaveable { mutableStateOf("") }
    var ancho = LocalConfiguration.current.screenWidthDp
    TextField(value = text, onValueChange = { newValue -> text = newValue}, modifier = modifier
        .fillMaxWidth()
        .padding(15.dp, (padding + 1).dp),
        label = { Text(what, textAlign = TextAlign.Center, modifier = Modifier) }
    )
}

@Composable
fun TopButtonLeft(onClick: () -> Unit) {
    Canvas(
        modifier = Modifier
            .size(40.dp)
            .offset(10.dp, 10.dp)
            .clickable { onClick() }
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
            .clickable { onClick() }
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
    ){
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
            .clickable { onClick() }
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

public fun countSaltos(text: String): Int {
    return text.count { it == '\n' }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserProfilesss() {
    val rol = rememberSaveable { mutableIntStateOf(0) }
    val op = rememberSaveable { mutableIntStateOf(1) }
    val view = remember { View(rol.value, op.value) }

    view.Pantalla()

}

