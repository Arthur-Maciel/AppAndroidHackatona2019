package br.com.southsystem.hackatona2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ComentarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comentario)

        val bundle = this.intent.extras!!
        val dados = bundle.getStringArrayList("dados")
    }
}
