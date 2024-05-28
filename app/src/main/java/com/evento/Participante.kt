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
    private var num_seguro: Int,
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
    fun ConsultarDatosGenerales(x: Int = 0,y: Int = 0) {
        var string = ""
        string += this.nombre + "\n" + this.numeroParticipante
        Text(text = string,fontSize = 23.sp, color = Color.Black)

        //println("Fecha de nacimiento: $fecha_nacimiento")
        //println("Sexo: $sexo")
        //println("Correo: $correo")
        //println("Telefono: $telefono")
    }

    fun consultarDatosMedicos() {
        println("Nombre: $nombre")
        println("Número de corredor: $numeroParticipante")
        println("Contacto de emergencia: $contacto_emergencia")
        println("Numero de seguro: $num_seguro")
        println("Peso: $peso")
        println("Altura: $altura")
        println("Tipo de sangre: $tipo_sangre\n")
        printLista(medicamento_actual, "Medicamentos")
        printLista(alergias, "Alergias")
        printLista(enfermedades, "Enfermedades")
        printLista(lesiones, "Lesiones")
        printLista(vacunas, "Vacunas")
    }

    private fun printLista(lista: List<String>, titulo: String) {
        var i = 1
        println("\t$titulo")
        lista.forEach { elemento ->
            println("\t$i. $elemento")
            i++
        }
        println()
    }
}
