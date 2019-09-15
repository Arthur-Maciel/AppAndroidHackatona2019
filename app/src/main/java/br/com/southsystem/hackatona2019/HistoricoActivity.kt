package br.com.southsystem.hackatona2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.southsystem.hackatona2019.api.Recursos
import kotlinx.android.synthetic.main.activity_historico.*

class HistoricoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico)

        val bundle = this.intent.extras!!
        val dados = bundle.getStringArrayList("dados")

        acontecimento_view.text= dados!![0]
        cliente_contato_view.text= dados!![1]

    }
}
