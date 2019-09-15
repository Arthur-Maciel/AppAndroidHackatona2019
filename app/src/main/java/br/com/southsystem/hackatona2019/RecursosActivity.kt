package br.com.southsystem.hackatona2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.southsystem.hackatona2019.api.Data
import br.com.southsystem.hackatona2019.api.Recursos
import kotlinx.android.synthetic.main.activity_recursos.*

class RecursosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recursos)

        val bundle = this.intent.extras!!
        val dados = bundle.getSerializable("dados") as Recursos

        saude_view.text=dados.servicos_saude
        apoio_view.text=dados.servicos_apoio
        bombeiros_view.text=dados.posto_bomb
        agua_view.text=dados.forn_agua
        telefonia_view.text=dados.telefonia
        internet_view.text=dados.internet
        saneamento_view.text=dados.saneamento
        acessibilidade_view.text=dados.acessibilidade

    }
}
