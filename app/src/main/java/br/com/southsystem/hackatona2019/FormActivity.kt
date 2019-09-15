package br.com.southsystem.hackatona2019

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        setAdapter()
    }

    private fun setAdapter() {
        val recyclerView = findViewById<RecyclerView>(R.id.dadosLocalidade_recycler)
        val adapter = FormAdapter(this, { init -> })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}
