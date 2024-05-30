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

class Participante(
    var nombre: String,
    var numeroParticipante: String,
    private var fecha_nacimiento: String,
    private var sexo: String,
    private var correo: String,
    private var telefono: String,
    private var contacto_emergencia: String,
    private var num_seguro: String,
    private var peso: Float,
    private var altura: Float,
    private var tipo_sangre: String,
    // listas
    private var medicamento_actual: List<String>,
    private var alergias: List<String>,
    private var enfermedades: List<String>,
    private var lesiones: List<String>,
    private var vacunas: List<String>
) {

    @Composable
    fun ConsultarDatosGenerales(x: Int = 0,y: Int = 0,textAlign: TextAlign = TextAlign.Left,modifier: Modifier = Modifier) {
        var string = ""
        string += this.nombre + "\n" + this.numeroParticipante
        Text(text = string,fontSize = 33.sp, color = Color.Black, textAlign = textAlign, modifier = modifier
            .fillMaxWidth()
            .offset(15.dp, 0.dp))

        //println("Fecha de nacimiento: $fecha_nacimiento")
        //println("Sexo: $sexo")
        //println("Correo: $correo")
        //println("Telefono: $telefono")
    }

    @Composable
    fun ConsultarDatosMedicos() {
        val ancho = LocalConfiguration.current.screenWidthDp
        val alto = LocalConfiguration.current.screenHeightDp
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)){
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(4.dp, 1.dp)
                .background(FondoConsutla)){
                Column {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp)
                        .background(cian)){
                        Text(text = "Datos Medicos",color = Color.Black, fontSize = 40.sp,textAlign = TextAlign.Center, modifier = Modifier
                            .fillMaxWidth()
                            .offset(0.dp, 10.dp)
                        )
                        SeparacionCampos()
                    }
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(3.dp)
                        .background(Color.Black))
                    ConsultarDatosGenerales()
                    SeparacionCampos()
                    CamposMedicos("Altura: " + altura.toString() +" m")
                    CamposMedicos("Peso: " + peso.toString() + " Kg")
                    CamposMedicos("Sangre: " + tipo_sangre)
                    CamposMedicos("Seguro: " + num_seguro)
                    CamposMedicos("Contacto de emergencia\n» " + contacto_emergencia)
                    val text = remember { mutableStateOf("")}

                    if(alergias.size != 0){
                        text.value = "Alergias\n"
                        text.value += listaToString(alergias)
                        CamposMedicos(text.value)
                    }

                    if(enfermedades.size != 0){
                        text.value = "Enfermedades\n"
                        text.value += listaToString(enfermedades)
                        CamposMedicos(text.value)
                    }


                    if(medicamento_actual.size != 0){
                        text.value = "Medicamento\n"
                        text.value += listaToString(medicamento_actual)
                        CamposMedicos(text.value)
                    }

                    if(lesiones.size != 0){
                        text.value = "Lesiones\n"
                        text.value += listaToString(lesiones)
                        CamposMedicos(text.value)
                    }

                    if(vacunas.size != 0){
                        text.value = "Vacunas\n"
                        text.value += listaToString(vacunas)
                        CamposMedicos(text.value)
                    }
                    Spacer(modifier = Modifier.height(39.dp))
                }
            }
        }
    }

    @Composable
    fun CamposMedicos(text: String){
        Text(text = text,color = Color.Black, fontSize = 32.sp, modifier = Modifier
            .offset(15.dp,0.dp)
        )
        SeparacionCampos()
    }
    @Composable
    fun SeparacionCampos()
    {
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(3.dp)
            .background(Color.Black))
        Spacer(modifier = Modifier.height(10.dp))
    }

    private fun listaToString(lista: List<String>): String {
        var text = ""
        for (i in lista.indices){
            if(i < lista.size-1){
                text += "» " + lista[i] + "\n"
            }
            else{
                text += "» " + lista[i]
            }

        }
        return  text
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewUserProfilert() {
    val rol = rememberSaveable { mutableIntStateOf(2) }
    val op = rememberSaveable { mutableIntStateOf(0) }
    val view = remember { View(rol.value, op.value) }

    view.Pantalla()

}