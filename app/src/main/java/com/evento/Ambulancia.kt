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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evento.ui.theme.*

class Ambulancia(num: String = ""){

    private val numero = num
    public val medicos = mutableListOf<Medico>()
    private var accidente: Accidente? = null

    @Composable
    public fun ShowAccident(): Int{
        val ancho = LocalConfiguration.current.screenWidthDp
        val participante = remember { mutableStateOf<Participante?>(accidente?.involucrados?.get(0)) }
        var op = remember { mutableStateOf(0)}

        if(participante.value != null){
            Column(modifier = Modifier
                .fillMaxSize()
                .background(Blue1_2)){
                LazyColumn {
                    item{
                        TopBar("Médico")
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
                op.value = -1
            }
        } else{
            participante.value!!.ConsultarDatosMedicos()
        }
        return op.value
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
        val cantidad = accidente?.involucrados?.size
        val saltos = accidente?.descripcion?.let { countSaltos(it) }
        val alto = LocalConfiguration.current.screenHeightDp
        val ancho = LocalConfiguration.current.screenWidthDp

        if (cantidad != null) {
            if (saltos != null) {
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
                                accidente?.ubicacion?.let { it1 -> Text(text = it1, fontSize = 30.sp, textAlign = TextAlign.Justify, color = Color.Black, modifier = Modifier
                                    .width((ancho - 60).dp)
                                    .offset(15.dp)) }
                                Spacer(modifier = Modifier.height(10.dp))
                                Box(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(2.dp)
                                    .background(Color.Black))
                                Spacer(modifier = Modifier.height(10.dp))
                                accidente?.descripcion?.let { it1 -> Text(text = it1, fontSize = 30.sp, textAlign = TextAlign.Justify, color = Color.Black, modifier = Modifier
                                    .width((ancho - 60).dp)
                                    .offset(15.dp)) }
                                Spacer(modifier = Modifier.height(10.dp))
                            }
                        }
                    }
                }
            }
        }
    }
    @Composable
    fun BoxParticipante(onclick: (Participante) -> Unit)
    {
        val ancho = LocalConfiguration.current.screenWidthDp
        val it = accidente?.involucrados?.iterator()
        if (it != null) {
            while (it.hasNext()){
                val it = it.next()
                Box(modifier = Modifier.height(120.dp)){
                    Column(){
                        Spacer(modifier = Modifier.height(10.dp))
                        it.ConsultarDatosGenerales()
                        Spacer(modifier = Modifier.height(10.dp))
                    }

                    Image(painter = painterResource(id = R.drawable.datos), contentDescription = null, modifier = Modifier
                        .size(100.dp, 100.dp)
                        .offset((ancho - 130).dp, 10.dp)
                        .clickable { onclick(it) }
                    )
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(Color.Black))
            }

        }

    }
    @Composable
    public fun GetMedicos(x: Int = 0,y: Int = 0,onClick: (Medico) -> Unit){
        val ancho = LocalConfiguration.current.screenWidthDp
        Spacer(modifier = Modifier.height(45.dp))
        for(medico in medicos){
            var count by rememberSaveable { mutableStateOf(0) }
            Box(modifier = Modifier.fillMaxWidth()){
                Text(text = medico.getCorreo(), fontSize = 20.sp, color = Color.Black, modifier = Modifier.offset((x+5).dp,0.dp))
                Image(painter = painterResource(id = R.drawable.del), contentDescription = null, modifier = Modifier
                    .size(30.dp, 30.dp)
                    .offset((ancho - x - 110).dp, 0.dp)
                    .clickable { count++;if (count > 1) onClick(medico) }
                )
            }
        }
    }
    public fun addMedico(medico: Medico = Medico("","")){
        if(!medico.getAsignado())
        {
            medico.setAsingFlag(true)
            medicos.add(medico)
        }
    }
    public fun removeMedico(medico: Medico = Medico("","")){
        if(medico.getAsignado())
        {
            medico.setAsingFlag(false)
            medicos.remove(medico)
        }
    }
    public fun getNum(): String
    { return numero }
    public fun asignAccidente(ac: Accidente){
        accidente = ac
    }
    public fun removeAccidente(){
        accidente = null
    }

    public fun getAccidente(): Accidente? {
        return accidente
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewUserProfiler() {
    val rol = rememberSaveable { mutableIntStateOf(2) }
    val op = rememberSaveable { mutableIntStateOf(0) }
    val view = remember { View(rol.value, op.value) }

    view.Pantalla()

}