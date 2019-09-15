package br.com.southsystem.hackatona2019

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DadosLocalidadeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dados_localidade)

        setAdapter()
    }

    private fun setAdapter() {


        val recyclerView = findViewById<RecyclerView>(R.id.dadosLocalidade_recycler)
        val adapter = ExperienciaAdapter(this, { init ->
            if(init.equals("Dados")){
             val intent =  startActivity(Intent(this, DadosActivity::class.java))
            }
            if(init.equals("Recursos")){
                val intent =  startActivity(Intent(this, RecursosActivity::class.java))
            }
            if(init.equals("Histórico")){
                val intent = startActivity(Intent(this, HistoricoActivity::class.java))
            }
            if(init.equals("Comentários")){
                val intent = startActivity(Intent(this, ComentarioActivity::class.java))
            }
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}
