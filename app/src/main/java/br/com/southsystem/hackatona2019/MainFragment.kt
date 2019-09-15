package br.com.southsystem.hackatona2019

import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View


class MainFragment {

    fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedInstanceState: Bundle
    ): View {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }
}