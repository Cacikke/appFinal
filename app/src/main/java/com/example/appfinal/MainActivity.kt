package com.example.appfinal

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import com.example.appfinal.databinding.ActivityJugadores2Binding.inflate
import com.example.appfinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val jugar: TextView = binding.jugar
        val instrucciones: TextView = binding.instrucciones
        val extras: TextView = binding.extras
        val salir: TextView = binding.salir

        //Creamos el popup menú para elegir si queremos jugar con 2, 3 o 4 jugadores
        jugar.setOnClickListener {
            val menupopup= PopupMenu(this,jugar)

            menupopup.setOnMenuItemClickListener {
                item ->
                when (item.itemId) {
                    R.id.jug2 -> {
                        partida2()
                        true
                    }
                    R.id.jug3 -> {
                        partida3()
                        true
                    }
                    R.id.jug4 -> {
                        partida4()
                        true
                    }
                    else -> false
                }
            }
            menupopup.inflate(R.menu.popup)
            menupopup.show()

        }

        instrucciones.setOnClickListener {
            instrucciones()
        }

        extras.setOnClickListener {
            extras()
        }

        salir.setOnClickListener{
            salir()
        }

    }

    private fun partida2() {

        val intent = Intent(this,jugadores_2::class.java)
        startActivity(intent)
    }

    private fun partida3() {

        val intent = Intent(this,jugadores_3::class.java)
        startActivity(intent)
    }

    private fun partida4() {

        val intent = Intent(this,jugadores_4::class.java)
        startActivity(intent)
    }

    private fun instrucciones() {

        val intent = Intent(this,Instrucciones::class.java)
        startActivity(intent)
    }

    private fun extras() {

        val intent = Intent(this,Extras::class.java)
        startActivity(intent)
    }

    private fun salir() {
        finish()
    }

}