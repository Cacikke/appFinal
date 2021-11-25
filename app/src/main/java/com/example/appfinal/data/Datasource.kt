package com.example.appfinal.data

import com.example.appfinal.R
import com.example.appfinal.model.Preguntas

class Datasource {
    fun loadFrases(): List<Preguntas> {
        return listOf<Preguntas> (
            Preguntas(R.string.p1),
            Preguntas(R.string.si),
            Preguntas(R.string.p2),
            Preguntas(R.string.alguna),
            Preguntas(R.string.p3),
            Preguntas(R.string.si),
            Preguntas(R.string.p4),
            Preguntas(R.string.si),
            Preguntas(R.string.p5),
            Preguntas(R.string.no),
            Preguntas(R.string.p6),
            Preguntas(R.string.si),
            Preguntas(R.string.p7),
            Preguntas(R.string.si)
        )
    }

}