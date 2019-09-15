package br.com.southsystem.hackatona2019

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


typealias ExperienciaClicada = (string:String) -> Unit

class ExperienciaAdapter(
    val context: Context,
    private val onclick: ExperienciaClicada,
    val vagas: Array<String> = arrayOf(
        "Dados",
        "Recursos",
        "Histórico",
        "Comentários"
    )
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false)
        return VagasViewHolder(view)
    }

    override fun getItemCount(): Int {
        return vagas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as VagasViewHolder
        holder.run {
            val vaga = vagas[position]

            tituloVaga.text = vaga

            if (position == 0) {
                upperLine.visibility = View.GONE
            } else {
                upperLine.visibility = View.VISIBLE
            }

            if (position == itemCount - 1) {
                bottomLine.visibility = View.GONE
            } else {
                bottomLine.visibility = View.VISIBLE
            }

            if (itemCount == 1) {
                bottomLine.visibility = View.GONE
                upperLine.visibility = View.GONE
            }
        }


    }

    inner class VagasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tituloVaga: TextView = itemView.findViewById(R.id.titulo_vaga)
        val upperLine: View = itemView.findViewById(R.id.period_value_upper_line_view)
        val bottomLine: View = itemView.findViewById(R.id.period_value_bottom_line_view)

        init {
            itemView.setOnClickListener {
                onclick.invoke(vagas[adapterPosition].toString())
            }
        }
    }
}

