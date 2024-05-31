package com.evento

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evento.ui.theme.Blue1_2
import com.evento.ui.theme.cian

class Accidente(involi: MutableList<Participante>,desc: String,ubicacioni: Ubicacion){
    val involucrados = involi
    var descripcion = desc
    var ubicacion = ubicacioni
    var estado = "En camino"
    @Composable
    public fun ShowAccident(num_amb: String,onclick: () -> Unit): Boolean{
        val ancho = LocalConfiguration.current.screenWidthDp
        val participante = remember { mutableStateOf<Participante?>(null) }
        var consultando = remember { mutableStateOf(false)}

        if(participante.value == null){
            consultando.value = false
            Column(modifier = Modifier
                .fillMaxSize()
                .background(Blue1_2)){
                LazyColumn {
                    item{
                        TopBar(num_amb)
                        Spacer(modifier = Modifier.height(15.dp))
                        EncabezadoAccidente(modifier = Modifier
                            .size((ancho - 20).dp, 80.dp)
                            .offset(10.dp, 0.dp)
                            .background(Color.Black))
                        CuerpoAccidente(){
                            participante.value = it
                        }
                    }
                }
            }
            BotBar {
                onclick()
            }
        } else{
            consultando.value = true
            LazyColumn {
                item{
                    TopBar(num_amb)
                    participante.value!!.ConsultarDatosMedicos()
                }
            }
            BotBar {
                if(it == 2){
                    participante.value = null
                }
                else{
                    onclick()
                }
            }
        }
        return consultando.value
    }
    @Composable
    fun EncabezadoAccidente(modifier: Modifier){
        val ancho = LocalConfiguration.current.screenWidthDp
        Box(modifier = modifier){
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(3.dp)
                .background(cian)){
                Text(text = "Accidente", textAlign = TextAlign.Center, fontSize = 45.sp,modifier = Modifier
                    .fillMaxWidth()
                    .offset(0.dp, 5.dp))

            }
        }
    }
    @Composable
    fun CuerpoAccidente(onclick: (Participante) -> Unit){
        val alto = LocalConfiguration.current.screenHeightDp
        val ancho = LocalConfiguration.current.screenWidthDp
        Box(modifier = Modifier
            .size((ancho - 20).dp, (alto - 220).dp)
            .offset(10.dp, 0.dp)
            .background(Color.Black)){
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(3.dp)
                .background(Color.White)){
                LazyColumn(){
                    item{
                        BoxParticipante(){
                            onclick(it)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "Estado: " +estado, fontSize = 30.sp, textAlign = TextAlign.Justify, color = Color.Black, modifier = Modifier
                            .width((ancho - 60).dp)
                            .offset(15.dp))
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp)
                            .background(Color.Black))
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = ubicacion.getUbicacion(), fontSize = 30.sp, textAlign = TextAlign.Justify, color = Color.Black, modifier = Modifier
                            .width((ancho - 60).dp)
                            .offset(15.dp))
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp)
                            .background(Color.Black))
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = descripcion, fontSize = 30.sp, textAlign = TextAlign.Justify, color = Color.Black, modifier = Modifier
                            .width((ancho - 60).dp)
                            .offset(15.dp))
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    }

    @Composable
    fun BoxParticipante(onclick: (Participante) -> Unit) {
        val ancho = LocalConfiguration.current.screenWidthDp
        for (participante in involucrados){
            Box(modifier = Modifier.height(120.dp)){
                Column(){
                    Spacer(modifier = Modifier.height(10.dp))
                    participante.ConsultarDatosGenerales()
                    Spacer(modifier = Modifier.height(10.dp))
                }

                Image(painter = painterResource(id = R.drawable.datos), contentDescription = null, modifier = Modifier
                    .size(100.dp, 100.dp)
                    .offset((ancho - 130).dp, 10.dp)
                    .clickable { onclick(participante) }
                )
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Color.Black))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserProfilef() {
    val rol = rememberSaveable { mutableIntStateOf(2) }
    val op = rememberSaveable { mutableIntStateOf(0) }
    val view = remember { View(rol.value, op.value) }
    view.Pantalla()

}