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
        ambulancias[3].addMedico(medicos[7])
        ambulancias[3].addMedico(medicos[8])
        ambulancias[3].addMedico(medicos[9])

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
                "B-",  // Listas con algunos datos
                mutableListOf<String>("Aspirina", "Ibuprofeno"),
                mutableListOf<String>("Polen", "Ácaros"),
                mutableListOf<String>("Hipertensión", "Diabetes"),
                mutableListOf<String>("Fractura de pierna", "Esguince de tobillo"),
                mutableListOf<String>("Influenza", "Hepatitis B")
            )
        )
        participantes.add(
            Participante(
                "Juan",
                "1990-01-01",
                "Masculino",
                "12345",
                "juan@example.com",
                "1234567890",
                "María",
                123456789,
                70.5f,
                170f,
                "A+",
                mutableListOf<String>("Paracetamol", "Amoxicilina"),
                mutableListOf<String>("Nueces", "Mariscos"),
                mutableListOf<String>("Asma", "Hipotiroidismo"),
                mutableListOf<String>("Fractura de brazo", "Contusión en la cabeza"),
                mutableListOf<String>("Tétanos", "Varicela")
            )
        )
        participantes.add(
            Participante(
                "Ana",
                "1988-07-10",
                "Femenino",
                "54321",
                "ana@example.com",
                "0987654321",
                "Pedro",
                987654321,
                55.2f,
                165f,
                "AB-",
                mutableListOf<String>("Ibuprofeno", "Omeprazol"),
                mutableListOf<String>("Polen", "Leche"),
                mutableListOf<String>("Diabetes", "Artritis"),
                mutableListOf<String>("Esguince de tobillo", "Lumbalgia"),
                mutableListOf<String>("Sarampión", "Gripe")
            )
        )
        participantes.add(
            Participante(
                "Carlos",
                "1983-12-25",
                "Masculino",
                "67890",
                "carlos@example.com",
                "9876543210",
                "Luisa",
                123456789,
                80.2f,
                175f,
                "O+",
                mutableListOf<String>("Loratadina", "Metformina"),
                mutableListOf<String>("Polen", "Frutas cítricas"),
                mutableListOf<String>("Hipertensión", "Gastritis"),
                mutableListOf<String>("Fractura de pierna", "Luxación de hombro"),
                mutableListOf<String>("Hepatitis A", "Influenza")
            )
        )
        participantes.add(
            Participante(
                "Elena",
                "1975-03-18",
                "Femenino",
                "13579",
                "elena@example.com",
                "0123456789",
                "Pedro",
                987654321,
                70.0f,
                160f,
                "A-",
                mutableListOf<String>("Aspirina", "Ciprofloxacino"),
                mutableListOf<String>("Polvo", "Chocolate"),
                mutableListOf<String>("Hipertensión", "Osteoporosis"),
                mutableListOf<String>("Esguince de rodilla", "Fractura de muñeca"),
                mutableListOf<String>("Tétanos", "Hepatitis B")
            )
        )
        participantes.add(
            Participante(
                "Javier",
                "1980-09-03",
                "Masculino",
                "24680",
                "javier@example.com",
                "1357924680",
                "Sandra",
                987654321,
                90.5f,
                180f,
                "AB+",
                mutableListOf<String>("Diclofenaco", "Insulina"),
                mutableListOf<String>("Polvo", "Mariscos"),
                mutableListOf<String>("Asma", "Hipotiroidismo"),
                mutableListOf<String>("Fractura de pierna", "Luxación de hombro"),
                mutableListOf<String>("Hepatitis A", "Varicela")
            )
        )
        participantes.add(
            Participante(
                "Lucia",
                "1992-11-30",
                "Femenino",
                "97531",
                "lucia@example.com",
                "9876543210",
                "Diego",
                123456789,
                60.8f,
                165f,
                "O-",
                mutableListOf<String>("Paracetamol", "Omeprazol"),
                mutableListOf<String>("Polen", "Frutas secas"),
                mutableListOf<String>("Diabetes", "Artritis"),
                mutableListOf<String>("Esguince de tobillo", "Lumbalgia"),
                mutableListOf<String>("Gripe", "Resfriado")
            )
        )
    }
    @Composable
    fun Pantalla() {
        if(count == 0){
            inicializarDatos()
        }
        count++

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
                    MainMenu()
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Blue1)
        ) {}
        val opciones = mutableListOf<String>()
        val imagenes = mutableListOf<Int>()
        var puesto = ""
        when (rol) {
            0 -> {
                puesto = "Encargado"
                opciones.add("Registrar\nEvento")
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
                opciones.add("Accidente")
                opciones.add("Disponible")
                imagenes.add(R.drawable.podio)
                imagenes.add(R.drawable.ambulancia)
            }
        }

        TopBar(puesto)
        var actual = 60
        for (i in opciones.indices) {
            Option(opciones[i], actual + 30, imagenes[i]){
                op = i
            }
            val saltos = countSaltos(opciones[i])
            actual += 140 + (saltos * 30 + saltos * 12)
        }
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
        BotBar()
    }

    @Composable
    fun EncargadoMedicos() {
        var nuevo by rememberSaveable { mutableStateOf(true) }
        var abierto by rememberSaveable { mutableStateOf(false) }
        var i = 0



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
                    registrarAmulancia(){
                        nuevo = false
                    }
                    Spacer(modifier = Modifier.padding(200.dp))
                    BotBar()
                }
                else
                {
                    abierto = false
                    for(i in 1..ambulancias.size){
                        abierto = VentantaAmbulancia(ambulancias[i-1])
                        Spacer(modifier = Modifier.padding(1.dp))
                        if(abierto){
                            TabAmbulancia(ambulancias[i-1])
                            break
                        }
                    }
                    Spacer(modifier = Modifier.padding(39.dp))
                    BotBar()
                }
            }
        }



    }

    @Composable
    fun VentantaAmbulancia(ambulanciai: Ambulancia): Boolean{
        val ambulancia = ambulanciai
        val ancho = LocalConfiguration.current.screenWidthDp
        var open by rememberSaveable { mutableStateOf(true) }
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
    @Composable fun TabAmbulancia(ambulanciai: Ambulancia){
        val ambulancia = ambulanciai
        val ancho = LocalConfiguration.current.screenWidthDp
        val alto = LocalConfiguration.current.screenHeightDp
        Box(modifier = Modifier
            .size((ancho - 15 * 2).dp, (alto - 420).dp)
            .offset(15.dp, 0.dp)
            .fillMaxSize()
            .background(Color.Black)
        ){
            Box(modifier = Modifier
                .size((ancho - 30 - 6).dp, (alto - 423).dp)
                .offset((3).dp, 0.dp)
                .background(Color.White)
            ){
                VenanasInternas(ambulancia)
            }
        }
    }

    @Composable
    fun VenanasInternas(ambulanciai: Ambulancia){
        var ambulancia = ambulanciai
        val alto = LocalConfiguration.current.screenHeightDp
        val ancho = LocalConfiguration.current.screenWidthDp
        var medico_open by rememberSaveable { mutableStateOf(false) }
        var equipo_open by rememberSaveable { mutableStateOf(true) }
        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier
                .size((ancho - 65).dp, 60.dp)
                .offset(15.dp, 5.dp)
                .background(Ventanta)
            ){
                Text(text = "Medicos", color = Color.White, fontSize = 30.sp, textAlign = TextAlign.Left,modifier = Modifier
                    .offset(15.dp,6.dp)
                )
                Image(painter = painterResource(id = R.drawable.expand), contentDescription = null, modifier = Modifier
                    .size(50.dp, 50.dp)
                    .offset((ancho - 110).dp, 5.dp)
                    .clickable { medico_open = !medico_open }
                )
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

                }
                else
                {
                    Box(modifier = Modifier
                        .size((ancho - 65).dp, (alto - 559).dp)
                        .offset(15.dp, 0.dp)
                        .background(Color.Black)
                    ){
                        Box(modifier = Modifier
                            .size((ancho - 72).dp, (alto - 562).dp)
                            .offset((3).dp, 0.dp)
                            .background(Color.White)
                        )
                    }
                    //ambulancia.getEquipo
                }
            }
            else
            {
                Box(modifier = Modifier
                    .size((ancho - 65).dp, (alto - 559).dp)
                    .offset(15.dp, 0.dp)
                    .background(Color.Black)
                ){
                    Box(modifier = Modifier
                        .size((ancho - 72).dp, (alto - 562).dp)
                        .offset((3).dp, 0.dp)
                        .background(Color.White)
                    )
                }

                //ambulancia.getMedicos {
                    //ambulancia.removeMedico(it)
                //}
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
    fun WindowAmbulancia(){

    }
    @Composable
    fun registrarAmulancia( onSave: () -> Unit){
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

    @Composable
    fun EncargadoEvento(){
        //falta implementar
    }

    @Composable
    fun StaffAccidente(){
        var involucrados by rememberSaveable { mutableStateOf(0) }
        LazyColumn(

            modifier = Modifier
                .fillMaxSize()
                .background(Fondo)

        ) {
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
                involucrados = Contador {}
                for (i in 1..involucrados ){
                    CampoTxt("Nombre o numero de participante"){

                    }
                }
                if(involucrados > 0)
                {
                    CampoTxt("Descripción", 12){

                    }
                }
                SendButton(20){

                }
            }
        }
        BotBar()
    }

    @Composable
    fun Contador(onClick: () -> Unit): Int{
        var count by rememberSaveable { mutableStateOf(1) }
        var ancho = LocalConfiguration.current.screenWidthDp
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
    @Composable
    fun MedicoAccidente(){
        //falta implementar
    }

    @Composable
    fun MedicoDisponibilidad(){
        //falta implementar
    }

    @Composable
    fun BotBar() {
        val ancho = LocalConfiguration.current.screenWidthDp
        Box(
            modifier = Modifier
                .size(ancho.dp, 61.dp)
                .offset(0.dp, 0.dp)
                .background(Blue5)
                .fillMaxWidth()
        ){
            Image(
                painter = painterResource(id = R.drawable.options),
                contentDescription = null,
                modifier = Modifier
                    .size(55.dp, 55.dp)
                    .offset(44.dp, 0.dp)
                    .clickable { /* acción */ }
            )

            Image(
                painter = painterResource(id = R.drawable.home),
                contentDescription = null,
                modifier = Modifier
                    .size(47.dp, 47.dp)
                    .offset((ancho / 2 - 22).dp, 0.dp)
                    .clickable { op = -1 }
            )

            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = null,
                modifier = Modifier
                    .size(55.dp, 55.dp)
                    .offset((ancho - 97).dp, 0.dp)
                    .clickable { op = -1 }
            )
        }


    }
}



class Compose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val rol = rememberSaveable { mutableIntStateOf(0) }
            val op = rememberSaveable { mutableIntStateOf(1) }
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
    val op = rememberSaveable { mutableIntStateOf(1) }
    val view = remember { View(rol.value, op.value) }

    view.Pantalla()

}