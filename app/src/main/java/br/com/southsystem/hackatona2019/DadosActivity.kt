package br.com.southsystem.hackatona2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.southsystem.hackatona2019.api.Data
import br.com.southsystem.hackatona2019.api.Status
import kotlinx.android.synthetic.main.activity_dados.*

class DadosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dados)

        val bundle = this.intent.extras!!
        val dados = bundle.getSerializable("dados") as Status

        populacao_view.text=dados.populacao.toString()+" habitantes"
        cliente_contato_view.text=dados.geografia
    }
}
