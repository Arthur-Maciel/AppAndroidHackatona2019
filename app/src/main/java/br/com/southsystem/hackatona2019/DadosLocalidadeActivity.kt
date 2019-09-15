package br.com.southsystem.hackatona2019

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.southsystem.hackatona2019.api.Data

class DadosLocalidadeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dados_localidade)

        setAdapter()
    }

    private fun setAdapter() {


        val recyclerView = findViewById<RecyclerView>(R.id.dadosLocalidade_recycler)
        val adapter = ExperienciaAdapter(this, { init ->

            val bundle = this.intent.extras!!
            val dados = bundle.getSerializable("dados") as Data

            if(init.equals("Dados")){
             val intent =  startActivity(Intent(this, DadosActivity::class.java).putExtra("dados",dados.status))
            }
            if(init.equals("Recursos")){
                val intent =  startActivity(Intent(this, RecursosActivity::class.java).putExtra("dados",dados.recursos))
            }
            if(init.equals("Histórico")){
                val intent = startActivity(Intent(this, HistoricoActivity::class.java).putExtra("dados",dados.historicos))
            }
            if(init.equals("Comentários")){
                val intent = startActivity(Intent(this, ComentarioActivity::class.java).putExtra("dados",dados.comentarios))
            }
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}
