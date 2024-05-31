package com.evento

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.util.copy
import com.evento.ui.theme.*

class Evento(
    nombrei: String,
    cupoi: String,
    cuotai: String,
    fechai: String,
    ubicacioni: String,
    reglasi: String,
    desci: String
) {
    val nombre: String = nombrei
    val cupo: String = cupoi
    val cuota: String = cuotai
    val fecha: String = fechai
    val ubicacion: String = ubicacioni
    val reglas: String = reglasi
    val descripcion: String = desci
    @Composable
    public fun ConsultarEvento(){
        Spacer(modifier = Modifier.height(30.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(Color.Black))
        CampoEvento("Descripcion", descripcion)
        CampoEvento("Fecha", fecha)
        CampoEvento("Ubicacion", ubicacion)
        CampoEvento("Límite de participantes", cupo)
        CampoEvento("Cuota", cuota)
        CampoEvento("Reglas", reglas)
    }

    @Composable
    private fun CampoEvento(what: String,text:String){
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(Color.Black))
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = what, fontSize = 30.sp, textAlign = TextAlign.Center,modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = text, fontSize = 30.sp, textAlign = TextAlign.Center,modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserProfilesder() {
    val rol = rememberSaveable { mutableIntStateOf(0) }
    val op = rememberSaveable { mutableIntStateOf(1) }
    val view = remember { View(rol.value, op.value) }
    view.Pantalla()

}