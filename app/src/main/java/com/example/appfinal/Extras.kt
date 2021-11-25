package com.example.appfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.appfinal.adapter.ItemAdapter
import com.example.appfinal.data.Datasource
import com.example.appfinal.databinding.ActivityExtrasBinding
import com.example.appfinal.databinding.ActivityInstruccionesBinding
import com.example.appfinal.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Extras : AppCompatActivity() {

    private lateinit var binding: ActivityExtrasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityExtrasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myDataset= Datasource().loadFrases()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)
        recyclerView.setHasFixedSize(true)

        val volver : FloatingActionButton =binding.floatingActionButton
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