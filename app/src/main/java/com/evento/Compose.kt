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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.evento.ui.theme.*

class View(roli: Int, opi: Int) {
    var rol by mutableIntStateOf(roli)
    var op by mutableIntStateOf(opi)
    private val participantes = mutableListOf<Participante>()
    private val staffs = mutableListOf<Staff>()
    private var ambulancias = mutableListOf<Ambulancia>()
    private val medicos = mutableListOf<Medico>()
    private var count by mutableIntStateOf(0)
    private var accidentes = mutableListOf<Accidente>()

    private fun inicializarDatos(){
        medicos.clear()
        medicos.add(Medico("patricia.martinez@gmail.com", "contraseña1"))
        medicos.add(Medico("laura.garcia@gmail.com", "contraseña2"))
        medicos.add(Medico("luis.mendoza@gmail.com", "contraseña3"))
        medicos.add(Medico("josemartinez@gmail.com", "contraseña4"))
        medicos.add(Medico("maria.rodriguez@gmail.com", "contraseña5"))
        medicos.add(Medico("carlos.perez@gmail.com", "contraseña6"))
        medicos.add(Medico("luisa.lopez@gmail.com", "contraseña7"))
        medicos.add(Medico("carlos.mendoza@gmail.com", "contraseña8"))
        medicos.add(Medico("ana.gomez@gmail.com", "contraseña9"))
        medicos.add(Medico("juan.lopez@gmail.com", "contraseña10"))
        medicos.add(Medico("lopez@gmail.com", "contraseña10"))
        medicos.add(Medico("llpez@gmail.com", "contraseña10"))
        medicos.add(Medico("juan.martinez@gmail.com", "contraseña11"))
        medicos.add(Medico("andrea.lopez@gmail.com", "contraseña12"))
        medicos.add(Medico("daniel.garcia@gmail.com", "contraseña13"))
        medicos.add(Medico("ana.rodriguez@gmail.com", "contraseña14"))
        medicos.add(Medico("jose.gomez@gmail.com", "contraseña15"))
        medicos.add(Medico("maria.perez@gmail.com", "contraseña16"))
        medicos.add(Medico("lucia.martin@gmail.com", "contraseña17"))
        medicos.add(Medico("miguel.fernandez@gmail.com", "contraseña18"))
        medicos.add(Medico("carolina.sanchez@gmail.com", "contraseña19"))
        medicos.add(Medico("pedro.gonzalez@gmail.com", "contraseña20"))
        staffs.clear()
        staffs.add(Staff("lucas@gmail.com", "contraseña1"))
        staffs.add(Staff("mariana@gmail.com", "contraseña2"))
        staffs.add(Staff("carolina@gmail.com", "contraseña3"))
        staffs.add(Staff("pablo@gmail.com", "contraseña4"))
        staffs.add(Staff("juan@gmail.com", "contraseña5"))
        staffs.add(Staff("ana@gmail.com", "contraseña6"))
        staffs.add(Staff("luis@gmail.com", "contraseña7"))
        staffs.add(Staff("marco@gmail.com", "contraseña8"))
        staffs.add(Staff("sofia@gmail.com", "contraseña9"))
        staffs.add(Staff("diana@gmail.com", "contraseña10"))

        ambulancias.clear()
        ambulancias.add(Ambulancia("12345"))
        ambulancias[0].addMedico(medicos[0])
        ambulancias[0].addMedico(medicos[1])
        ambulancias[0].addMedico(medicos[2])
        ambulancias.add(Ambulancia("53215"))
        ambulancias[1].addMedico(medicos[3])
        ambulancias[1].addMedico(medicos[4])
        ambulancias[1].addMedico(medicos[5])
        ambulancias.add(Ambulancia("11112"))
        ambulancias[2].addMedico(medicos[6])
        ambulancias[2].addMedico(medicos[7])
        ambulancias[2].addMedico(medicos[8])
        ambulancias.add(Ambulancia("65785"))
        ambulancias[3].addMedico(medicos[9])
        ambulancias[3].addMedico(medicos[10])
        ambulancias[3].addMedico(medicos[11])

        participantes.clear()
        participantes.add(
            Participante(
                "Maria",
                "98765",
                "1985-05-15",
                "Femenino",
                "maria@example.com",
                "0987654321",
                "Juan",
                987654321,
                65.2f,
                160f,
                "B-",
                mutableListOf("Aspirina", "Ibuprofeno"),
                mutableListOf("Polen", "Ácaros"),
                mutableListOf("Hipertensión", "Diabetes"),
                mutableListOf("Fractura de pierna", "Esguince de tobillo"),
                mutableListOf("Influenza", "Hepatitis B")
            )
        )

        participantes.add(
            Participante(
                "Juan",
                "12345",
                "1990-01-01",
                "Masculino",
                "juan@example.com",
                "1234567890",
                "María",
                123456789,
                70.5f,
                170f,
                "A+",
                mutableListOf("Paracetamol", "Amoxicilina"),
                mutableListOf("Nueces", "Mariscos"),
                mutableListOf("Asma", "Hipotiroidismo"),
                mutableListOf("Fractura de brazo", "Contusión en la cabeza"),
                mutableListOf("Tétanos", "Varicela")
            )
        )

        participantes.add(
            Participante(
                "Ana",
                "54321",
                "1988-07-10",
                "Femenino",
                "ana@example.com",
                "0987654321",
                "Pedro",
                987654321,
                55.2f,
                165f,
                "AB-",
                mutableListOf("Ibuprofeno", "Omeprazol"),
                mutableListOf("Polen", "Leche"),
                mutableListOf("Diabetes", "Artritis"),
                mutableListOf("Esguince de tobillo", "Lumbalgia"),
                mutableListOf("Sarampión", "Gripe")
            )
        )

        participantes.add(
            Participante(
                "Carlos",
                "67890",
                "1983-12-25",
                "Masculino",
                "carlos@example.com",
                "9876543210",
                "Luisa",
                123456789,
                80.2f,
                175f,
                "O+",
                mutableListOf("Loratadina", "Metformina"),
                mutableListOf("Polen", "Frutas cítricas"),
                mutableListOf("Hipertensión", "Gastritis"),
                mutableListOf("Fractura de pierna", "Luxación de hombro"),
                mutableListOf("Hepatitis A", "Influenza")
            )
        )

        participantes.add(
            Participante(
                "Elena",
                "13579",
                "1975-03-18",
                "Femenino",
                "elena@example.com",
                "0123456789",
                "Pedro",
                987654321,
                70.0f,
                160f,
                "A-",
                mutableListOf("Aspirina", "Ciprofloxacino"),
                mutableListOf("Polvo", "Chocolate"),
                mutableListOf("Hipertensión", "Osteoporosis"),
                mutableListOf("Esguince de rodilla", "Fractura de muñeca"),
                mutableListOf("Tétanos", "Hepatitis B")
            )
        )

        participantes.add(
            Participante(
                "Javier",
                "24680",
                "1980-09-03",
                "Masculino",
                "javier@example.com",
                "1357924680",
                "Sandra",
                987654321,
                90.5f,
                180f,
                "AB+",
                mutableListOf("Diclofenaco", "Insulina"),
                mutableListOf("Polvo", "Mariscos"),
                mutableListOf("Asma", "Hipotiroidismo"),
                mutableListOf("Fractura de pierna", "Luxación de hombro"),
                mutableListOf("Hepatitis A", "Varicela")
            )
        )

        participantes.add(
            Participante(
                "Lucia",
                "97531",
                "1992-11-30",
                "Femenino",
                "lucia@example.com",
                "9876543210",
                "Diego",
                123456789,
                60.8f,
                165f,
                "O-",
                mutableListOf("Paracetamol", "Omeprazol"),
                mutableListOf("Polen", "Frutas secas"),
                mutableListOf("Diabetes", "Artritis"),
                mutableListOf("Esguince de tobillo", "Lumbalgia"),
                mutableListOf("Gripe", "Resfriado")
            )
        )

        val involucrados = mutableListOf<Participante>()
        involucrados.add(participantes[0])
        involucrados.add(participantes[1])
        involucrados.add(participantes[2])
        accidentes.add(Accidente(involucrados,"Los participantes tienen lesiones que van desde cortes menores hasta posibles fracturas"))
        //ambulancias[0].asignAccidente()
    }
    @Composable
    fun Pantalla() {
        if(count == 0){
            inicializarDatos()
        }
        count++

        val it = accidentes.iterator()
        while (it.hasNext()) {
            val accidente = it.next()
            for (ambulancia in ambulancias) {
                if (ambulancia.getAccidente() == null) {
                    ambulancia.asignAccidente(accidente)
                    it.remove()
                    break
                }
            }
        }

        when(op){
            -1 -> {MainMenu()}
            0 -> {
                if(rol == 0){
                    //registrarEvento
                    MainMenu()
                } else if (rol == 1){
                    //registrarAccidente
                    StaffAccidente()
                } else if (rol == 2){
                    //Veraccidente
                    MedicoAccidente()
                }
            }
            1 -> {
                if(rol == 0){
                    //encargadoMedicos
                    EncargadoMedicos()
                } else if (rol == 1){
                    //no se implementara
                    MainMenu()
                } else if (rol == 2){
                    //Disponibilidad
                    MainMenu()
                }else{
                    MainMenu()
                }
            }
            else -> {MainMenu()}
        }
        if (op == -1){
            MainMenu()
        }else if (op == 1){
            if(rol == 0){
                EncargadoMedicos()
            }
        }
    }
    @Composable
    fun MainMenu(){
        val opciones = remember { mutableStateOf(mutableListOf<String>()) }
        val imagenes = remember { mutableStateOf(mutableListOf<Int>()) }
        var puesto by rememberSaveable { mutableStateOf("") }

        opciones.value.clear()
        imagenes.value.clear()
        when (rol) {
            0 -> {
                puesto = "Encargado"
                opciones.value.add("Registrar\nEvento")
                opciones.value.add("Médicos")
                opciones.value.add("Datos\nMédicos")
                opciones.value.add("Accidentes")
                imagenes.value.add(R.drawable.podio)
                imagenes.value.add(R.drawable.ambulancia)
                imagenes.value.add(R.drawable.part)
                imagenes.value.add(R.drawable.ambulancia)
            }
            1 -> {
                puesto = "Staff"
                opciones.value.add("Registrar\nAccidente")
                opciones.value.add("Registrar\nCorredor")
                imagenes.value.add(R.drawable.podio)
                imagenes.value.add(R.drawable.part)
            }
            2 -> {
                puesto = "Médico"
                opciones.value.add("Accidente")
                opciones.value.add("Disponible")
                imagenes.value.add(R.drawable.podio)
                imagenes.value.add(R.drawable.ambulancia)
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Blue1)
        ) {
            item{
                Box(){
                    TopBar(puesto)
                    TopButtonRight{
                        if (rol != 2){
                            rol++
                        } else{
                            rol = 0
                        }
                        op=-1
                    }
                    TopButtonLeft{
                        if (rol != 0){
                            rol--
                        } else{
                            rol = 2
                        }
                        op=-1
                    }
                }
                for (i in opciones.value.indices) {
                    Spacer(modifier = Modifier.height(30.dp))
                    Option(opciones.value[i], imagenes.value[i]){
                        op = i
                    }
                }
            }
        }
        BotBar(){op = -1}
    }
    @Composable
    fun EncargadoEvento(){
        //falta implementar
    }
    @Composable
    fun MedicoAccidente(){
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(Blue1))
        {
            item{
                TopBar("Medico")
                if(ambulancias[0].getAccidente() != null){
                    ambulancias[0].ShowAccident()
                }else{
                    NoAccidenteMensaje()
                }
            }
        }
        BotBar { op = -1 }
    }
    @Composable fun NoAccidenteMensaje(){
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
    @Composable
    fun MedicoDisponibilidad(){
        //falta implementar
    }

    //encargadoMedicos..... medicos listo..... equipo ?  ... listo 75%
    @Composable
    fun EncargadoMedicos() {
        var nuevo by rememberSaveable { mutableStateOf(false) }
        var abierto by rememberSaveable { mutableStateOf(false) }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Blue1)
        ) {
            item{

                TopBar("Encargado")
                AmbulanciaButton(){
                    nuevo = true
                }
                nuevo = true
                if(nuevo)
                {
                    RegistrarAmulancia(){
                        nuevo = false
                    }
                    Spacer(modifier = Modifier.height(60.dp))
                    for(i in 1..ambulancias.size){
                        abierto = ventantaAmbulancia(ambulancias[i-1])
                        Spacer(modifier = Modifier.padding(1.dp))
                        if(abierto){
                            TabAmbulancia(ambulancias[i-1])
                            break
                        }
                    }
                }
                else
                {
                    abierto = false
                    for(i in 1..ambulancias.size){
                        abierto = ventantaAmbulancia(ambulancias[i-1])
                        Spacer(modifier = Modifier.padding(1.dp))
                        if(abierto){
                            TabAmbulancia(ambulancias[i-1])
                            break
                        }
                    }
                    Spacer(modifier = Modifier.padding(39.dp))
                }
            }
        }
        BotBar(){ op = -1 }
    }
    @Composable
    fun ventantaAmbulancia(ambulanciai: Ambulancia): Boolean{
        val ambulancia = ambulanciai
        val ancho = LocalConfiguration.current.screenWidthDp
        var open by rememberSaveable { mutableStateOf(false) }
        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier
                .size((ancho - 30).dp, 60.dp)
                .offset(15.dp, 0.dp)
                .background(Ventanta)
            ){
                Text(text = "Ambulancia: "+ambulancia.getNum(), color = Color.White, fontSize = 30.sp, textAlign = TextAlign.Left,modifier = Modifier
                    .offset(15.dp,6.dp)
                )
                Image(painter = painterResource(id = R.drawable.expand), contentDescription = null, modifier = Modifier
                    .size(50.dp, 50.dp)
                    .offset((ancho - 80).dp, 5.dp)
                    .clickable { open = !open }
                )
            }
        }
        return open
    }
    @Composable
    fun TabAmbulancia(ambulanciai: Ambulancia){
        val ambulancia = ambulanciai
        val ancho = LocalConfiguration.current.screenWidthDp
        val alto = LocalConfiguration.current.screenHeightDp
        Box(modifier = Modifier
            .size((ancho - 15 * 2).dp, (alto - 380).dp)
            .offset(15.dp, 0.dp)
            .fillMaxSize()
            .background(Color.Black)
        ){
            Box(modifier = Modifier
                .size((ancho - 30 - 6).dp, (alto - 383).dp)
                .offset((3).dp, 0.dp)
                .background(Color.White)
            ){
                VenanasInternas(ambulancia){
                    for(medico in medicos){
                        if(medico.getCorreo().lowercase() == it.lowercase()){
                            if(ambulancia.medicos.find { medico.getCorreo().lowercase() == it.getCorreo().lowercase()} == null){
                                ambulancia.addMedico(medico)
                                break
                            }
                        }
                    }
                }
            }
        }
    }
    @Composable
    fun VenanasInternas(ambulanciai: Ambulancia, onClick: (medico: String) -> Unit){
        var ambulancia = ambulanciai
        val alto = LocalConfiguration.current.screenHeightDp
        val ancho = LocalConfiguration.current.screenWidthDp
        var medico_open by rememberSaveable { mutableStateOf(false) }
        var equipo_open by rememberSaveable { mutableStateOf(false) }
        val lazyListState = rememberLazyListState()
        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier
                .size((ancho - 65).dp, 60.dp)
                .offset(15.dp, 5.dp)
                .background(Ventanta)
            ){
                Text(text = "Medicos", color = Color.White, fontSize = 30.sp, textAlign = TextAlign.Left,modifier = Modifier.offset(15.dp,6.dp))
                Image(painter = painterResource(id = R.drawable.expand), contentDescription = null, modifier = Modifier
                    .size(50.dp, 50.dp)
                    .offset((ancho - 110).dp, 5.dp)
                    .clickable { medico_open = !medico_open })
            }

            if(!medico_open){
                Spacer(modifier = Modifier.padding(1.dp))
                Box(modifier = Modifier
                    .size((ancho - 65).dp, 60.dp)
                    .offset(15.dp, 5.dp)
                    .background(Ventanta)
                ){
                    Text(text = "Equipo", color = Color.White, fontSize = 30.sp, textAlign = TextAlign.Left,modifier = Modifier
                        .offset(15.dp,6.dp)
                    )
                    Image(painter = painterResource(id = R.drawable.expand), contentDescription = null, modifier = Modifier
                        .size(50.dp, 50.dp)
                        .offset((ancho - 110).dp, 5.dp)
                        .clickable { equipo_open = !equipo_open }
                    )
                }
                if(!equipo_open){
                    var x = 0
                }
                else
                {
                    Box(modifier = Modifier
                        .size((ancho - 65).dp, (alto - 509).dp)
                        .offset(15.dp, 0.dp)
                        .background(Color.Black)
                    ){
                        Box(modifier = Modifier
                            .size((ancho - 72).dp, (alto - 512).dp)
                            .offset((3).dp, 0.dp)
                            .background(Color.White)
                        )
                    }
                    //ambulancia.getEquipo
                }
            }
            else
            {
                Column{
                    var text by rememberSaveable { mutableStateOf("") }
                    Box(modifier = Modifier
                        .size((ancho - 65).dp, (alto - 509).dp)
                        .offset(15.dp, 0.dp)
                        .background(Color.Black)
                    ){
                        Box(modifier = Modifier
                            .size((ancho - 72).dp, (alto - 512).dp)
                            .offset((3).dp, 0.dp)
                            .background(Color.White)
                        ){
                            LazyColumn(state = lazyListState,) {
                                item{
                                    var coincidencia by rememberSaveable { mutableStateOf(false) }
                                    var activo by rememberSaveable { mutableStateOf(true) }
                                    Text("Correos", fontSize = 35.sp, color = Color.Black, modifier = Modifier.offset(7.dp))
                                    text = SingleCampoTxt("Correo",0,0,
                                        Modifier
                                            .size((ancho - 87).dp, 50.dp)
                                            .offset(7.dp, 20.dp),activo) {
                                        activo = false
                                        onClick(it)
                                    }
                                    if(text != ""){
                                        activo = true
                                        for (medico in medicos){
                                            coincidencia = true
                                            if(!medico.getAsignado()){
                                                for (i in text.indices){
                                                    if(text[i].lowercase() != medico.getCorreo()[i].lowercase()){
                                                        coincidencia = false
                                                    }
                                                }
                                                if(coincidencia){
                                                    if(ambulancia.medicos.find { medico.getCorreo().lowercase() == it.getCorreo().lowercase()} == null){
                                                        Text(text = medico.getCorreo().lowercase(), fontSize = 23.sp, textAlign = TextAlign.Center, color = Color.Black, modifier = Modifier
                                                            .offset(5.dp, 32.dp)
                                                            .clickable {
                                                                activo =
                                                                    false; onClick(medico.getCorreo())
                                                            })
                                                        Box(modifier = Modifier
                                                            .fillMaxWidth()
                                                            .height(2.dp)
                                                            .background(Color.Black))
                                                    }
                                                }
                                            }
                                        }
                                    }else{activo = true}
                                    ambulancia.GetMedicos { ambulancia.removeMedico(it)}
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    @Composable
    fun AmbulanciaButton(onClick: () -> Unit){
        Row {
            Image(painter = painterResource(id = R.drawable.ambulancia),contentDescription = null, modifier = Modifier
                .size(200.dp, 160.dp)
                .offset(30.dp, 0.dp)
            )
            Box(modifier = Modifier
                .size(94.dp, 94.dp)
                .offset(60.dp, 25.dp)
                .background(Color.Transparent)
                .clickable { onClick() }
            ){
                Image(painter = painterResource(id = R.drawable.add),contentDescription = null, modifier = Modifier
                    .size(120.dp, 120.dp)
                    .offset(0.dp, 0.dp)
                    .clickable { onClick() }
                )
            }
        }
    }
    @Composable
    fun RegistrarAmulancia( onSave: () -> Unit){
        val ancho = LocalConfiguration.current.screenWidthDp
        Box(modifier = Modifier
            .size((ancho - 10).dp, 170.dp)
            .offset(5.dp, 40.dp)
            .background(Ventanta)
        ){
            Text(text = "Nueva Ambulancia", fontSize = 40.sp, textAlign = TextAlign.Center, color = Color.White, modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp, 0.dp))
            SingleNumCampoTxt("Numero de ambulancia",x = 15,modifier = Modifier.offset(0.dp,60.dp)){
                onSave();ambulancias.add(Ambulancia(it))
            }
        }
    }
    //staff... 100% listo ...
    @Composable
    fun StaffAccidente(){
        val participantesInvol = remember { mutableStateOf(mutableListOf<Participante>()) }
        val participantesAccidente = remember { mutableStateOf(mutableListOf<String>()) }
        var involucradosCount by rememberSaveable { mutableIntStateOf(0) }
        var listo by rememberSaveable { mutableStateOf(true) }
        var reset by rememberSaveable { mutableStateOf(false) }
        val ancho = LocalConfiguration.current.screenWidthDp
        var descripcion by rememberSaveable { mutableStateOf("") }

        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(Fondo)) {
            item{
                TopBar("Staff")
                Text(text = "Registro de Accidente", fontSize = 30.sp, textAlign = TextAlign.Center, color = Color.Black,  modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp)
                )
                Text(text = "Involucrados", fontSize = 25.sp, textAlign = TextAlign.Center, color = Color.Black,  modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                )
                involucradosCount = contador(reset)
                listo = true
                reset = false
                while(participantesAccidente.value.size<involucradosCount){
                    participantesAccidente.value.add("")
                }

                for (i in 1..involucradosCount ){
                    Box{
                        participantesAccidente.value[i-1] = (CampoTxt("Nombre o numero de participante"))
                        if(participantes.find { participantesAccidente.value[i-1].lowercase() == it.nombre.lowercase() || participantesAccidente.value[i-1] == it.numeroParticipante} != null){
                            Image(painter = painterResource(id = R.drawable.check),contentDescription = null, modifier = Modifier
                                .size(40.dp, 40.dp)
                                .offset((ancho - 65).dp, 5.dp)
                            )
                        } else{ listo = false }
                    }
                }
                if(involucradosCount > 0)
                {
                    descripcion = CampoTxt("Descripción", 12)
                    if(listo){
                        if(descripcion != ""){
                            SendButton(20){
                                involucradosCount = 0
                                listo = true
                                reset = true
                                for(participante in participantes){
                                    if(participantesAccidente.value.find {participante.nombre.lowercase() == it || participante.numeroParticipante == it} != null){
                                        participantesInvol.value.add(participante)
                                    }
                                }
                                accidentes.add(Accidente(participantesInvol.value.toMutableList(),descripcion))
                                participantesInvol.value.clear()
                                participantesAccidente.value.clear()
                                descripcion = ""
                            }
                        }
                    }
                }
            }
        }
        BotBar(){ op = -1 }
    }
    @Composable
    fun contador(reset: Boolean): Int{
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
    fun SendButton(padding: Int = 0,onClick: () -> Unit){
        var ancho = LocalConfiguration.current.screenWidthDp
        Image(painter = painterResource(id = R.drawable.send), contentDescription = null, modifier = Modifier
            .size(80.dp, 80.dp)
            .offset((ancho / 2 - 42).dp, padding.dp)
            .clickable { onClick() }
        )
    }
}

class Compose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val rol = rememberSaveable { mutableIntStateOf(0) }
            val op = rememberSaveable { mutableIntStateOf(0) }
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
    val rol = rememberSaveable { mutableIntStateOf(2) }
    val op = rememberSaveable { mutableIntStateOf(0) }
    val view = remember { View(rol.value, op.value) }
    view.Pantalla()

}