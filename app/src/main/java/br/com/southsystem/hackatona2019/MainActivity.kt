package br.com.southsystem.hackatona2019

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.southsystem.hackatona2019.api.Data


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(MapFragment(), false, "one")

        val viewModel = ViewModelProviders.of(this).get(DadosViewModel::class.java)
        viewModel.dadosLiveData.observe(this, Observer {
            it?.let { dados ->
            }
        })

        viewModel.getDados()

    }

    fun addFragment(fragment: Fragment, addToBackStack: Boolean, tag: String) {
        val manager = supportFragmentManager
        val ft = manager.beginTransaction()

        if (addToBackStack) {
            ft.addToBackStack(tag)
        }
        ft.replace(R.id.container_frame_back, fragment, tag)
        ft.commitAllowingStateLoss()
    }

    fun nextActivity(view: View) {
        val viewModel = ViewModelProviders.of(this).get(DadosViewModel::class.java)
        viewModel.dadosLiveData.observe(this, Observer {
            it?.let { dados ->
                intent = Intent(this, DadosLocalidadeActivity::class.java).putExtra("dados",it[1])
                startActivity(intent)
            }
        })

        viewModel.getDados()


    }

}
