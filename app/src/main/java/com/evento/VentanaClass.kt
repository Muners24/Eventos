package com.evento

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evento.Ambulancia
import com.evento.ui.theme.VentanaBody
import com.evento.ui.theme.Ventanta


class VentanaClass(xi: Int, yi: Int, tituloi: String, ambulanciai: Ambulancia, ambulanciasi: MutableList<Ambulancia>,medicosi: MutableList<Medico>) {

    private val ambulancia = ambulanciai
    private val ambulancias = ambulanciasi
    private val medicos = medicosi
    private var x by mutableIntStateOf(xi)
    private var y by mutableIntStateOf(yi)
    private var titulo by mutableStateOf(tituloi)
    var abierto by mutableStateOf(true)
    var bloqueado by mutableStateOf(false)
    var del by mutableStateOf(false)

    @Composable
    public fun TopWindow(onClick: () -> Unit){
        val ancho = LocalConfiguration.current.screenWidthDp
        Box(modifier = Modifier
            .size((ancho - x * 2).dp, 50.dp)
            .offset(x.dp, y.dp)
            .background(Ventanta)
        )
        Box(modifier = Modifier
            .size(29.dp, 25.dp)
            .offset((ancho - x - 45).dp, (y + 13).dp)
            .background(Color.Transparent)
            .clickable {
                if (!bloqueado) {
                    onClick()
                }
            }
        )
        Text(text = titulo,
            fontSize = 30.sp,
            color = VentanaBody,
            modifier = Modifier
                .offset((ancho/8).dp,(y+4).dp)
        )

        Image(painter = painterResource(id = R.drawable.expand),contentDescription = null, modifier = Modifier
            .size(70.dp, 70.dp)
            .offset((ancho - x - 65).dp, (y - 10).dp)
        )
        if(abierto){
            TabWindow(x,y+50){}
        }
    }

    @Composable
    public fun TabWindow(xt: Int = 15, yt: Int = 312,onClick: () -> Unit){
        val ancho = LocalConfiguration.current.screenWidthDp
        Box(modifier = Modifier
            .size((ancho - xt * 2).dp, 300.dp)
            .offset(xt.dp, yt.dp)
            .background(Color.Black)
        )
        Box(modifier = Modifier
            .size((ancho - xt * 2 - 4).dp, (300 - 2).dp)
            .offset((xt + 2).dp, yt.dp)
            .background(Color.White)
        )

        if(x == 15){
            var ventanasInternas = remember { mutableStateListOf<VentanaClass>() }
            ventanasInternas.add(VentanaClass(xi = x+15,yi = y + 60, tituloi = "Medicos ", ambulancia,ambulancias,medicos))
            ventanasInternas.add(VentanaClass(xi = x+15,yi = y + 115, tituloi = "Equipo ", ambulancia,ambulancias, medicos))

            ventanasInternas[1].TopWindow {
                ventanasInternas[1].abierto=!ventanasInternas[1].abierto
                ventanasInternas[0].abierto = false
            }
            ventanasInternas[0].TopWindow {
                ventanasInternas[0].abierto=!ventanasInternas[0].abierto
                ventanasInternas[1].abierto = false
                ventanasInternas[1].bloqueado = ventanasInternas[0].abierto
            }
            if(ventanasInternas[1].abierto){
            }
            if(ventanasInternas[0].abierto){
                ambulancia.getMedicos(xt+20, yt+60){
                    ambulancia.removeMedico(it)
                }
                /*
                SingleCampoTxt("Correo",x= (xt*3), y = (yt+120+ambulancia.medicos.size*45),Modifier
                   .size((ancho-xt*4-17).dp,60.dp)
                   .offset((xt+23).dp,(yt+120+ambulancia.medicos.size*45).dp)
                ) {
                    ambulancia.addMedico(medicos[0])
                    for(medico in medicos){
                        //if(it == medico.getCorreo()){

                        //}
                    }
                }*/
            }
            if(!ventanasInternas[0].abierto && !ventanasInternas[1].abierto){
                var count by rememberSaveable { mutableStateOf(0) }
                Image(painter = painterResource(id = R.drawable.del), contentDescription = null , modifier = Modifier
                    .size(110.dp, 110.dp)
                    .fillMaxWidth()
                    .offset((10).dp, (y + 240).dp)
                    .clickable {
                        onClick();count++;if (count > 1) {
                        ambulancias.remove(ambulancia); del = true
                    }
                    }
                )
            }
        }
    }

    public fun reajustar(yr: Int){
        y = yr
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewUserProfiles() {
    val rol = rememberSaveable { mutableIntStateOf(0) }
    val op = rememberSaveable { mutableIntStateOf(1) }
    val view = remember { View(rol.value, op.value) }

    view.Pantalla()

}

