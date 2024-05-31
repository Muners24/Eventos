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
import com.evento.ui.theme.*
import java.util.Random


class View(roli: Int, opi: Int) {
    var rol by mutableIntStateOf(roli)
    var op by mutableIntStateOf(opi)
    private val participantes = mutableListOf<Participante>()
    private val staffs = mutableListOf<Staff>()
    private var ambulancias = mutableListOf<Ambulancia>()
    private val medicos = mutableListOf<Medico>()
    private var count by mutableIntStateOf(0)
    private var accidentes = mutableListOf<Accidente>()
    private var evento = mutableStateOf<Evento?>(null)
    private var ubicaciones = mutableListOf<Ubicacion>()
    private fun inicializarDatos(){
        evento.value = Evento(
            "Gran Carrera Ciclista",
            "200",
            "30 USD",
            "2024-07-20",
            "Valle de Guadalupe",
            "Uso obligatorio de casco y protección\nNo se permite dejar basura en el recorrido",
            "Una emocionante carrera ciclista a través del Parque Central, abierta para todos los niveles."
        )

        ubicaciones.clear()
        ubicaciones.add(Ubicacion("Punto de control 1", 40.7306f, -73.9352f))
        ubicaciones.add(Ubicacion("Punto de control 2", 40.7550f, -73.9857f))
        ubicaciones.add(Ubicacion("Punto de control 3", 40.7128f, -74.0060f))
        ubicaciones.add(Ubicacion("Punto de control 4", 40.7589f, -73.9851f))
        ubicaciones.add(Ubicacion("Punto de control 5", 40.7069f, -74.0113f))
        ubicaciones.add(Ubicacion("Punto de control 6", 40.7222f, -73.9884f))
        ubicaciones.add(Ubicacion("Punto de control 7", 40.7580f, -73.9855f))
        ubicaciones.add(Ubicacion("Punto de control 8", 40.7120f, -74.0009f))
        ubicaciones.add(Ubicacion("Punto de control 9", 40.7362f, -73.9924f))
        ubicaciones.add(Ubicacion("Punto de control 10", 40.7380f, -73.9819f))

        medicos.clear()
        medicos.add(Medico("patricia.martinez@gmail.com", "contraseña1",ambulancias))
        medicos.add(Medico("laura.garcia@gmail.com", "contraseña2",ambulancias))
        medicos.add(Medico("luis.mendoza@gmail.com", "contraseña3",ambulancias))
        medicos.add(Medico("josemartinez@gmail.com", "contraseña4",ambulancias))
        medicos.add(Medico("maria.rodriguez@gmail.com", "contraseña5",ambulancias))
        medicos.add(Medico("carlos.perez@gmail.com", "contraseña6",ambulancias))
        medicos.add(Medico("luisa.lopez@gmail.com", "contraseña7",ambulancias))
        medicos.add(Medico("carlos.mendoza@gmail.com", "contraseña8",ambulancias))
        medicos.add(Medico("ana.gomez@gmail.com", "contraseña9",ambulancias))
        medicos.add(Medico("juan.lopez@gmail.com", "contraseña10",ambulancias))
        medicos.add(Medico("lopez@gmail.com", "contraseña10",ambulancias))
        medicos.add(Medico("llpez@gmail.com", "contraseña10",ambulancias))
        medicos.add(Medico("juan.martinez@gmail.com", "contraseña11",ambulancias))
        medicos.add(Medico("andrea.lopez@gmail.com", "contraseña12",ambulancias))
        medicos.add(Medico("daniel.garcia@gmail.com", "contraseña13",ambulancias))
        medicos.add(Medico("ana.rodriguez@gmail.com", "contraseña14",ambulancias))
        medicos.add(Medico("jose.gomez@gmail.com", "contraseña15",ambulancias))
        medicos.add(Medico("maria.perez@gmail.com", "contraseña16",ambulancias))
        medicos.add(Medico("lucia.martin@gmail.com", "contraseña17",ambulancias))
        medicos.add(Medico("miguel.fernandez@gmail.com", "contraseña18",ambulancias))
        medicos.add(Medico("carolina.sanchez@gmail.com", "contraseña19",ambulancias))
        medicos.add(Medico("pedro.gonzalez@gmail.com", "contraseña20",ambulancias))
        staffs.clear()
        staffs.add(Staff("lucas@gmail.com", "contraseña1",participantes,accidentes,ubicaciones))
        staffs.add(Staff("mariana@gmail.com", "contraseña2",participantes,accidentes,ubicaciones))
        staffs.add(Staff("carolina@gmail.com", "contraseña3",participantes,accidentes,ubicaciones))
        staffs.add(Staff("pablo@gmail.com", "contraseña4",participantes,accidentes,ubicaciones))
        staffs.add(Staff("juan@gmail.com", "contraseña5",participantes,accidentes,ubicaciones))
        staffs.add(Staff("ana@gmail.com", "contraseña6",participantes,accidentes,ubicaciones))
        staffs.add(Staff("luis@gmail.com", "contraseña7",participantes,accidentes,ubicaciones))
        staffs.add(Staff("marco@gmail.com", "contraseña8",participantes,accidentes,ubicaciones))
        staffs.add(Staff("sofia@gmail.com", "contraseña9",participantes,accidentes,ubicaciones))
        staffs.add(Staff("diana@gmail.com", "contraseña10",participantes,accidentes,ubicaciones))

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
                "Maria Lopez",
                "98765",
                "1985-05-15",
                "Femenino",
                "maria@gmail.com",
                "0987654321",
                "646 189 38 93",
                "987654321",
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
                "Juan Perez",
                "12345",
                "1990-01-01",
                "Masculino",
                "juan@gmail.com",
                "1234567890",
                "María",
                "123456789",
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
                "Ana Gomez",
                "54321",
                "1988-07-10",
                "Femenino",
                "ana@gmail.com",
                "0987654321",
                "Pedro",
                "987654321",
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
                "Carlos Ruiz",
                "67890",
                "1983-12-25",
                "Masculino",
                "carlos@gmail.com",
                "9876543210",
                "Luisa",
                "123456789",
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
                "Elena Martinez",
                "13579",
                "1975-03-18",
                "Femenino",
                "elena@gmail.com",
                "0123456789",
                "Pedro",
                "987654321",
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
                "Javier Fernandez",
                "24680",
                "1980-09-03",
                "Masculino",
                "javier@gmail.com",
                "1357924680",
                "Sandra",
                "987654321",
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
                "Lucia Diaz",
                "97531",
                "1992-11-30",
                "Femenino",
                "lucia@gmail.com",
                "9876543210",
                "Diego",
                "123456789",
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
        val random = Random()
        val indice = random.nextInt(ubicaciones.size-1)
        accidentes.add(Accidente(involucrados,"Los participantes tienen lesiones que van desde cortes menores hasta posibles fracturas",ubicaciones[indice]))
        //ambulancias[0].asignAccidente()
    }
    @Composable
    fun Pantalla() {

        if(count == 0){
            inicializarDatos()
        }
        count++
        if(evento.value != null){
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
                0 -> {
                    when(rol){
                        0 -> VerEvento()
                        1 -> op = staffs[0].registrarAccidente()
                        2 -> op = medicos[0].verAccidente()
                    }
                }
                1 -> {
                    when(rol){
                        0 -> EncargadoMedicos()
                        //registrar datos medicos no se implementara
                        1 -> MainMenu()
                        //Disponibilidad ambulancia no se implementara
                        2 -> MainMenu()
                    }
                }
                else -> {MainMenu()}
            }
        }
        else
        {
            NoEvento()
        }

    }

    @Composable
    fun NoEvento(){
        Column(
            Modifier
                .fillMaxSize()
                .background(Fondo)) {
                Box{
                    if(op == -1){
                        when(rol){
                            0 -> TopBar("Encargado")
                            1 -> TopBar("Staff")
                            2 -> TopBar("Médico")
                        }
                        TopButtonRight{
                            if (rol != 2){
                                rol++
                            } else{
                                rol = 0
                            }
                        }
                        TopButtonLeft{
                            if (rol != 0){
                                rol--
                            } else{
                                rol = 2
                            }
                        }
                    }
                }
                if(rol > 0){
                    MsgNoEvento()
                }
                else
                {
                    RegistroEvento()
                }

        }
        BotBar {
            op = -1
        }
    }


    @Composable
    fun RegistroEvento(){
        val opciones = remember { mutableListOf<String>() }
        val imagenes = remember { mutableListOf<Int>() }

        val count = remember { mutableIntStateOf(0)}
        if( count.intValue == 0){
            opciones.clear()
            imagenes.clear()
            opciones.add("Registrar\nEvento")
            imagenes.add(R.drawable.podio)
            opciones.add("Médicos")
            imagenes.add(R.drawable.ambulancia)
            opciones.add("Datos\nMedicos")
            imagenes.add(R.drawable.podio)
            count.intValue++
        }
        when (op) {
            -1 -> {

                for (i in opciones.indices) {
                    Spacer(modifier = Modifier.height(30.dp))
                    Option(opciones[i], imagenes[i]){
                        op = i
                    }
                }
            }
            0 -> EncargadoRegistrarEvento()
            1 -> EncargadoMedicos()
        }
    }
    @Composable
    fun MsgNoEvento(){
        Column(){
            Spacer(modifier = Modifier.height(150.dp))
            Text(text = "No hay un", fontSize = 60.sp, color = Color.Black, textAlign = TextAlign.Center,modifier = Modifier
                .fillMaxWidth())
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "evento", fontSize = 60.sp, color = Color.Black, textAlign = TextAlign.Center,modifier = Modifier
                .fillMaxWidth())
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "asignado...", fontSize = 60.sp, color = Color.Black, textAlign = TextAlign.Center,modifier = Modifier
                .fillMaxWidth())
        }
    }

    @Composable
    fun MainMenu(){
        val opciones = remember { mutableListOf<String>() }
        val imagenes = remember { mutableListOf<Int>() }
        var puesto by rememberSaveable { mutableStateOf("") }

        opciones.clear()
        imagenes.clear()
        when (rol) {
            0 -> {
                puesto = "Encargado"
                opciones.add("Consultar\nEvento")
                opciones.add("Médicos")
                opciones.add("Datos\nMédicos")
                opciones.add("Accidentes")
                imagenes.add(R.drawable.podio)
                imagenes.add(R.drawable.ambulancia)
                imagenes.add(R.drawable.part)
                imagenes.add(R.drawable.ambulancia)
            }
            1 -> {
                puesto = "Staff"
                opciones.add("Registrar\nAccidente")
                opciones.add("Registrar\nCorredor")
                imagenes.add(R.drawable.podio)
                imagenes.add(R.drawable.part)
            }
            2 -> {
                puesto = "Médico"
                opciones.add("Consultar\nAccidente")
                opciones.add("Actualizar\nEstado del\nAccidente")
                imagenes.add(R.drawable.podio)
                imagenes.add(R.drawable.ambulancia)
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
                for (i in opciones.indices) {
                    Spacer(modifier = Modifier.height(30.dp))
                    Option(opciones[i], imagenes[i]){
                        op = i
                    }
                }
            }
        }
        BotBar(){op = -1}
    }

    @Composable
    fun VerEvento(){
        var count = remember { mutableIntStateOf(0) }
        val ancho = LocalConfiguration.current.screenWidthDp
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(Fondo)) {
            item{
                TopBar("Encargado")
                Spacer(Modifier.height(20.dp))
                evento.value?.let { Text(text = it.nombre, textAlign = TextAlign.Center, fontSize = 35.sp, modifier = Modifier
                    .fillParentMaxWidth()) }
                evento.value?.ConsultarEvento()
                Box(modifier = Modifier.fillParentMaxWidth().height(3.dp).background(Color.Black))
                Box(modifier = Modifier.height(300.dp)){
                    Image(painter = painterResource(id = R.drawable.del),contentDescription = null, modifier = Modifier
                        .size(100.dp,100.dp)
                        .fillParentMaxWidth()
                        .offset((ancho/2-50).dp,50.dp)
                        .clickable { count.intValue++;
                            if(count.intValue > 1){
                                op = -1; evento.value = null
                                accidentes.clear()
                                for(ambulancia in ambulancias){
                                    ambulancia.removeAccidente()
                                }
                            }
                        }
                    )
                }
            }
        }
        BotBar {
            op = -1
        }
    }

    @Composable
    fun EncargadoRegistrarEvento(){
        val ancho = LocalConfiguration.current.screenWidthDp
        val nombre = remember { mutableStateOf("" )}
        val cupo = remember { mutableStateOf("" )}
        val cuota = remember { mutableStateOf("" )}
        val dia_evento = remember { mutableStateOf("" )}
        val ubicacion = remember { mutableStateOf("" )}
        val descripcion = remember { mutableStateOf("" )}
        val reglas = remember { mutableStateOf("" )}

        LazyColumn(
            Modifier
                .fillMaxSize()
                .background(Fondo)) {
            item{
                TopBar("Encargado")
                Text(
                    text = "Registro de Evento",
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp)
                )
                nombre.value = campoEvento("Nombre del evento")
                cupo.value = campoEvento("Límite de participantes", true,keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
                cuota.value = campoEvento("Cuota de inscripcion", true,keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
                dia_evento.value = campoFechaEvento("Día del evento")
                ubicacion.value = campoEvento("Ubicación")
                reglas.value = campoEvento("Reglas")
                descripcion.value = campoEvento("Descripción")

                Box(modifier = Modifier
                    .fillParentMaxWidth()
                    .height(500.dp)){
                    if (nombre.value != "" && cupo.value != "" && cuota.value != "" && dia_evento.value != "" && ubicacion.value != "" && descripcion.value != "" && reglas.value != ""){
                        Image(painter = painterResource(id = R.drawable.save), contentDescription = null, modifier = Modifier
                            .size(80.dp, 80.dp)
                            .offset((ancho / 2 - 40).dp, 30.dp)
                            .clickable {
                                evento.value = Evento(
                                    nombre.value,
                                    cupo.value,
                                    cuota.value,
                                    dia_evento.value,
                                    ubicacion.value,
                                    reglas.value,
                                    descripcion.value
                                )
                                op = -1
                            }
                        )
                    }
                }
            }
        }
        BotBar {
            op = -1
        }
    }

    @Composable
    fun campoEvento(text: String,singleLine: Boolean = false,keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)): String{
        var texto_campo = rememberSaveable { mutableStateOf("" )}
        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = texto_campo.value, onValueChange = { newValue -> texto_campo.value = newValue},
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 1.dp),
            label = { Text(text, textAlign = TextAlign.Center, modifier = Modifier) },
            singleLine = singleLine,
            keyboardOptions = keyboardOptions
        )
        return texto_campo.value
    }
    @Composable
    fun campoFechaEvento(text: String): String {
        var textoCampo by rememberSaveable { mutableStateOf("") }
        var fecha by rememberSaveable { mutableStateOf("") }


        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = fecha,
            onValueChange = { newValue ->
                fecha = newValue
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 1.dp),
            label = { Text(text, textAlign = TextAlign.Center, modifier = Modifier) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )

        return fecha
    }



    @Composable
    fun EncargadoMedicos() {
        var nuevo by rememberSaveable { mutableStateOf(false) }
        var abierto by rememberSaveable { mutableStateOf(false) }
        var recomposicion by rememberSaveable { mutableStateOf(false) }

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
                else{
                    if(recomposicion) {
                        var actual = remember {
                            mutableIntStateOf(ambulancias.size)
                        }
                        abierto = false
                        for(i in 1..ambulancias.size){
                            abierto = ventantaAmbulancia(ambulancias[i-1])
                            Spacer(modifier = Modifier.padding(1.dp))
                            if(abierto){
                                TabAmbulancia(ambulancias[i-1])
                                break
                            }
                            if(actual.value != ambulancias.size){
                                recomposicion = !recomposicion
                            }
                        }
                        Spacer(modifier = Modifier.padding(39.dp))
                    }
                    else{
                        var actual = remember {
                            mutableIntStateOf(ambulancias.size)
                        }
                        abierto = false
                        for(i in 1..ambulancias.size){
                            abierto = ventantaAmbulancia(ambulancias[i-1])
                            Spacer(modifier = Modifier.padding(1.dp))
                            if(abierto){
                                TabAmbulancia(ambulancias[i-1])
                                break
                            }
                        }
                        if(actual.value != ambulancias.size){
                            recomposicion = !recomposicion
                        }
                        Spacer(modifier = Modifier.padding(39.dp))
                    }
                }
            }
        }
        BotBar(){
            when(it){
                1 -> op = -1
                2 -> if(nuevo) { nuevo = false} else { op = -1 }
            }
        }
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
                    EliminarAmbulancia(ambulancia){
                        op = 1
                    }
                }
                else
                {
                    Column{
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
                                        //falta implementar
                                        TabEquipo()
                                    }
                                }
                            }
                        }
                    }

                }
            }
            else
            {
                Column{
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
                                    TabMedicos(ambulancia = ambulancia) {
                                        onClick(it)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    @Composable
    fun TabEquipo(){

    }

    @Composable
    fun EliminarAmbulancia(ambulancia: Ambulancia,onClick: () -> Unit){
        var count by rememberSaveable { mutableStateOf(0) }
        val alto = LocalConfiguration.current.screenHeightDp
        Image(painter = painterResource(id = R.drawable.del),contentDescription = null,modifier = Modifier
            .size(100.dp, 100.dp)
            .offset(0.dp, (alto - 615).dp)
            .clickable {
                count++;if (count > 1) {
                op = 1; ambulancias.remove(ambulancia)
            }
            }
        )
    }

    @Composable
    fun TabMedicos(ambulancia: Ambulancia, onClick: (String) -> Unit ){
        var text by rememberSaveable { mutableStateOf("") }
        var coincidencia by rememberSaveable { mutableStateOf(false) }
        var activo by rememberSaveable { mutableStateOf(true) }
        val ancho = LocalConfiguration.current.screenWidthDp
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
        ambulancia.GetMedicos {
            ambulancia.removeMedico(it)
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
    val rol = rememberSaveable { mutableIntStateOf(0) }
    val op = rememberSaveable { mutableIntStateOf(-1) }
    val view = remember { View(rol.value, op.value) }
    view.Pantalla()

}