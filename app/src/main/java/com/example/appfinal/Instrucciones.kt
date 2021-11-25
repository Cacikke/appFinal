package com.example.appfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.appfinal.databinding.ActivityInstruccionesBinding
import com.example.appfinal.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Instrucciones : AppCompatActivity() {

    private lateinit var binding: ActivityInstruccionesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityInstruccionesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val volver : FloatingActionButton=binding.floatingActionButton
        volver.setOnClickListener {
            menuppal()
        }

    }

    //Botón para volver al menú principal
    private fun menuppal() {

        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}