package com.evento

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evento.ui.theme.Blue1
import com.evento.ui.theme.Fondo
import kotlin.random.Random

class Staff(correoi: String, contrasenai: String, participantesi: MutableList<Participante>, accidentesi: MutableList<Accidente>,ubicacioni: MutableList<Ubicacion>) : Usuario(correoi, contrasenai) {

    private val participantes = participantesi
    private val accidentes = accidentesi
    private val ubicaciones = ubicacioni
    @Composable
    fun registrarAccidente(): Int {
        val participantesInvol = remember { mutableStateOf(mutableListOf<Participante>()) }
        val participantesAccidente = remember { mutableStateOf(mutableListOf<String>()) }
        var involucradosCount by rememberSaveable { mutableIntStateOf(0) }
        var op by remember { mutableIntStateOf(0) }
        var listo by rememberSaveable { mutableStateOf(true) }
        var reset by rememberSaveable { mutableStateOf(false) }
        val ancho = LocalConfiguration.current.screenWidthDp
        var descripcion by rememberSaveable { mutableStateOf("") }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Fondo)
        ) {
            item {
                TopBar("Staff")
                Text(
                    text = "Registro de Accidente",
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp)
                )
                Text(
                    text = "Involucrados",
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                involucradosCount = contador(reset)
                listo = true
                reset = false

                while (participantesAccidente.value.size < involucradosCount) {
                    participantesAccidente.value.add("")
                }

                if (involucradosCount > 0) {
                    for (i in 0 until involucradosCount) {
                        Box {
                            participantesAccidente.value[i] = CampoTxt("Nombre o numero de participante")
                            if (participantes.find {
                                    participantesAccidente.value[i].lowercase() == it.nombre.lowercase() || participantesAccidente.value[i] == it.numeroParticipante
                                } != null) {
                                Image(
                                    painter = painterResource(id = R.drawable.check),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(40.dp, 40.dp)
                                        .offset((ancho - 65).dp, 5.dp)
                                )
                            } else {
                                listo = false
                            }
                        }
                    }

                    descripcion = CampoTxt("Descripción", 12)
                    if (listo && descripcion.isNotEmpty()) {
                        SendButton(20) {
                            involucradosCount = 0
                            listo = true
                            reset = true
                            participantesInvol.value.addAll(participantes.filter {
                                participantesAccidente.value.any { acc ->
                                    acc.lowercase() == it.nombre.lowercase() || acc == it.numeroParticipante
                                }
                            })
                            val indice = Random.nextInt(ubicaciones.size-1)
                            accidentes.add(Accidente(participantesInvol.value.toMutableList(), descripcion,ubicaciones[indice]))
                            participantesInvol.value.clear()
                            participantesAccidente.value.clear()
                            descripcion = ""
                        }
                    }
                }
            }
        }
        BotBar { op = -1 }
        return op
    }

    @Composable
    private fun contador(reset: Boolean): Int{
        var count by rememberSaveable { mutableStateOf(1) }
        var ancho = LocalConfiguration.current.screenWidthDp
        if(reset){
            count = 0
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding((ancho / 4).dp, 10.dp)) {
            Box(
                modifier = Modifier
                    .size(50.dp, 50.dp)
                    .offset(0.dp, 5.dp)
                    .clip(RoundedCornerShape(8.dp))  // Aplica esquinas redondeadas
                    .background(Blue1)
                    .clickable { count = if (count > 0) count - 1 else 0 },
                contentAlignment = Alignment.Center
            ) {
                Image(painter = painterResource(id = R.drawable.decrementar),contentDescription = null, modifier = Modifier.size(50.dp,50.dp))
            }
            Box(
                modifier = Modifier
                    .size(60.dp, 60.dp)
                    .offset(15.dp)
                    .clip(RoundedCornerShape(8.dp))// Aplica esquinas redondeadas
                    .background(Blue1)
                    .clickable { count++ },
                contentAlignment = Alignment.Center
            ) {
                Text(text = count.toString(), fontSize = 40.sp)
            }
            Box(
                modifier = Modifier
                    .size(50.dp, 50.dp)
                    .offset(30.dp, 5.dp)
                    .clip(RoundedCornerShape(8.dp))  // Aplica esquinas redondeadas
                    .background(Blue1)
                    .clickable { count++ },
                contentAlignment = Alignment.Center
            ) {
                Image(painter = painterResource(id = R.drawable.add_counter),contentDescription = null, modifier = Modifier.size(50.dp,50.dp))
            }
        }
        return count
    }
    @Composable
    private fun SendButton(padding: Int = 0,onClick: () -> Unit){
        var ancho = LocalConfiguration.current.screenWidthDp
        Image(painter = painterResource(id = R.drawable.send), contentDescription = null, modifier = Modifier
            .size(80.dp, 80.dp)
            .offset((ancho / 2 - 42).dp, padding.dp)
            .clickable { onClick() }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserProfilesd() {
    val rol = rememberSaveable { mutableIntStateOf(1) }
    val op = rememberSaveable { mutableIntStateOf(0) }
    val view = remember { View(rol.value, op.value) }
    view.Pantalla()

}