package com.example.appfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.appfinal.databinding.ActivityJugadores2Binding
import com.example.appfinal.databinding.ActivityJugadores3Binding
import com.example.appfinal.databinding.ActivityJugadores4Binding
import com.example.appfinal.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class jugadores_4 : AppCompatActivity(), OnFragmentActionsListener {
    private lateinit var binding: ActivityJugadores4Binding
    var intentos=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityJugadores4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val pasar: TextView = binding.txtpasar

        // Limitamos el número de veces que puedes cambiar la carta.
        pasar.setOnClickListener {
            intentos+=1
            roll()
            if (intentos==2){
                val deshabilitarpasar: TextView=binding.txtpasar
                deshabilitarpasar.setEnabled(false)
                Toast.makeText(this, "Has realizado tu último cambio :)", Toast.LENGTH_LONG).show()
            }
        }
        val volver : FloatingActionButton =binding.floatingActionButton
        volver.setOnClickListener {
            onClickBtnMenuppal()
        }
    }

    //Sobreescribimos los metodos de OnFragmentActionsListener para hacer intents de los dos botones que tenemos en el fragment
    override fun onClickBtnRejugar() {
        val intent = Intent(this,jugadores_4::class.java)
        startActivity(intent)
    }

    override fun onClickBtnMenuppal() {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    //Hacemos un roll de los valores de las cartas y las asignamos a los jugadores cuando pulsemos el boton de plantarse
    private fun roll() {
        val plantarse: TextView= binding.txtplantarse

        //Creamos la variable de letras aleatorias c, d, p y t para asignar las imágenes de las cartas (Corazones,Diamantes,Picas y Treboles)
        val letra= mutableListOf('c','d','p','t')
        val letra_random1= letra.random()

        //Creamos números aleatorios del 1 al 12 para asignar las imágenes de las cartas
        val num_jugador_1=(1..12).random()
        val num_jugador_2=(1..12).random()
        val num_jugador_3=(1..12).random()
        val num_jugador_4=(1..12).random()

        val img_carta1:ImageView=binding.jugador1
        val num_carta1=letra_random1.toString()+num_jugador_1.toString()

        plantarse.setOnClickListener {
            comprobarvalores1(num_jugador_1,num_jugador_2,num_jugador_3,num_jugador_4,num_carta1)
        }



        //Asignamos la carta de jugador1, osea, tú
        asignarCarta(img_carta1,num_carta1)

    }

    //Creamos la función para asignar las imágenes de las cartas a los jugadores
    private fun asignarCarta(img_carta:ImageView,valor_carta: String) {
        val asignarCarta= when(valor_carta){
            "c1"-> R.drawable.c1
            "c2"-> R.drawable.c2
            "c3"-> R.drawable.c3
            "c4"-> R.drawable.c4
            "c5"-> R.drawable.c5
            "c6"-> R.drawable.c6
            "c7"-> R.drawable.c7
            "c8"-> R.drawable.c8
            "c9"-> R.drawable.c9
            "c10"-> R.drawable.c10
            "c11"-> R.drawable.c11
            "c12"-> R.drawable.c12

            "d1"-> R.drawable.d1
            "d2"-> R.drawable.d2
            "d3"-> R.drawable.d3
            "d4"-> R.drawable.d4
            "d5"-> R.drawable.d5
            "d6"-> R.drawable.d6
            "d7"-> R.drawable.d7
            "d8"-> R.drawable.d8
            "d9"-> R.drawable.d9
            "d10"-> R.drawable.d10
            "d11"-> R.drawable.d11
            "d12"-> R.drawable.d12

            "p1"-> R.drawable.p1
            "p2"-> R.drawable.p2
            "p3"-> R.drawable.p3
            "p4"-> R.drawable.p4
            "p5"-> R.drawable.p5
            "p6"-> R.drawable.p6
            "p7"-> R.drawable.p7
            "p8"-> R.drawable.p8
            "p9"-> R.drawable.p9
            "p10"-> R.drawable.p10
            "p11"-> R.drawable.p11
            "p12"-> R.drawable.p12

            "t1"-> R.drawable.t1
            "t2"-> R.drawable.t2
            "t3"-> R.drawable.t3
            "t4"-> R.drawable.t4
            "t5"-> R.drawable.t5
            "t6"-> R.drawable.t6
            "t7"-> R.drawable.t7
            "t8"-> R.drawable.t8
            "t9"-> R.drawable.t9
            "t10"-> R.drawable.t10
            "t11"-> R.drawable.t11
            "t12"-> R.drawable.t12

            else -> R.drawable.back
        }
        img_carta.setImageResource(asignarCarta)

    }

    //Creamos la función para llamar a los fragments que dan el resultado de la partida
    fun cargarFragment(fragment: Fragment) {
        val fragmentIntercambio = supportFragmentManager.beginTransaction()
        fragmentIntercambio.replace(R.id.fragmentContainer,fragment)
        fragmentIntercambio.commit()
    }

    //Creamos la función para comprobar los valores de las cartas de los jugadores
    private fun comprobarvalores1(valor1:Int, valor2:Int, valor3:Int, valor4:Int, cartajug1:String){
        var value2=valor2
        var value3=valor3
        var value4=valor4

        val img_carta2:ImageView=binding.jugador2
        val img_carta3:ImageView=binding.jugador3
        val img_carta4:ImageView=binding.jugador4

        val letra= mutableListOf('c','d','p','t')
        var letra_random2= letra.random()
        var letra_random3= letra.random()
        var letra_random4= letra.random()

        /*Juntamos el valor de la letra random con el número random que le pasamos a la función "comprobarvalores1" y lo pasamos
        a String para pasarle el valor a la función "asignarCarta" */
        var num_carta2=letra_random2.toString()+value2.toString()
        var num_carta3=letra_random3.toString()+value3.toString()
        var num_carta4=letra_random4.toString()+value4.toString()

        // Comparamos los strings de las cartas para que no puedan coincidir cartas iguales.
        //Lo resolveré con el método Elías la siguiente vez :)
        while (num_carta2==cartajug1 || num_carta3==cartajug1 || num_carta4==cartajug1 || num_carta2==num_carta3
            || num_carta2==num_carta4 || num_carta3==num_carta4){

            if (num_carta2==cartajug1){
                letra_random2=letra.random()
                value2=(1..12).random()
                num_carta2=letra_random2.toString()+value2.toString()
            }
            if (num_carta3==cartajug1){
                letra_random3=letra.random()
                value3=(1..12).random()
                num_carta3=letra_random3.toString()+value3.toString()
            }
            if (num_carta4==cartajug1){
                letra_random4=letra.random()
                value4=(1..12).random()
                num_carta4=letra_random4.toString()+value4.toString()
            }
            if (num_carta2==num_carta3){
                letra_random2=letra.random()
                value2=(1..12).random()
                num_carta2=letra_random2.toString()+value2.toString()
            }
            if (num_carta2==num_carta4){
                letra_random4=letra.random()
                value4=(1..12).random()
                num_carta4=letra_random4.toString()+value4.toString()
            }
            if (num_carta3==num_carta4){
                letra_random4=letra.random()
                value4=(1..12).random()
                num_carta4=letra_random4.toString()+value4.toString()
            }
        }


        //Llamamos a la función para asignar las cartas de los otros jugadores
        asignarCarta(img_carta2,num_carta2)
        asignarCarta(img_carta3,num_carta3)
        asignarCarta(img_carta4,num_carta4)

        //Comprobamos los valores de las cartas y llamamos al fragment correspondiente
        if (valor1>valor2 && valor1>valor3 && valor1>valor4){
            cargarFragment(ResultadoFragment())
        }
        else if (valor1<valor2 || valor1<valor3 || valor1<valor4){
            cargarFragment(ResultadoFragment2())
        }
        else{
            cargarFragment(ResultadoFragment3())
        }

        //Deshabilitamos los botones de pasar y plantarse para que cuando salga el fragment del resultado no podamos darles.
        val deshabilitarplantarse: TextView=binding.txtplantarse
        val deshabilitarpasar: TextView=binding.txtpasar
        deshabilitarplantarse.setEnabled(false)
        deshabilitarpasar.setEnabled(false)
    }
}
