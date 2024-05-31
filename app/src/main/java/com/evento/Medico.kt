package com.evento

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evento.ui.theme.Blue1_2

class Medico(correoi: String, contrasenai: String,ambulanciasi: MutableList<Ambulancia>) : Usuario(correoi, contrasenai) {
    private val ambulancias = ambulanciasi
    @Composable
    fun verAccidente(): Int{
        var indice = remember { mutableIntStateOf(0) }
        var op = remember { mutableIntStateOf(0) }
        var consultando = remember { mutableStateOf(false) }

        if(ambulancias[indice.intValue].getAccidente() != null){
            consultando.value = ambulancias[indice.intValue].getAccidente()?.ShowAccident(ambulancias[indice.intValue].getNum()){
                op.intValue = -1
            } == true
        }else{
            op.intValue = noAccidenteMensaje(ambulancias[indice.intValue].getNum())
        }
        if(!consultando.value)
        {
            TopButtonLeft {
                indice.intValue--
                if(indice.intValue < 0){
                    indice.intValue = ambulancias.size-1
                }
            }
            TopButtonRight {
                indice.intValue++
                if(indice.intValue >= ambulancias.size){
                    indice.intValue = 0
                }
            }
        }
        return op.intValue
    }
    @Composable
    private fun noAccidenteMensaje(num_amb: String): Int{
        var op = remember { mutableIntStateOf(0) }
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(Blue1_2))
        {
            item{
                Box(){
                    TopBar(num_amb)
                }
                Spacer(modifier = Modifier.height(150.dp))
                Text(text = "No hay un", fontSize = 60.sp, color = Color.Black, textAlign = TextAlign.Center,modifier = Modifier
                    .fillMaxWidth())
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "accidente", fontSize = 60.sp, color = Color.Black, textAlign = TextAlign.Center,modifier = Modifier
                    .fillMaxWidth())
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "asignado...", fontSize = 60.sp, color = Color.Black, textAlign = TextAlign.Center,modifier = Modifier
                    .fillMaxWidth())
            }
        }
        BotBar() {
            op.intValue = -1
        }
        return op.intValue
    }
}