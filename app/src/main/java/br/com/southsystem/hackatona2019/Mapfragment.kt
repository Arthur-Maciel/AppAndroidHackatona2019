package br.com.southsystem.hackatona2019

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onMapReady(p0: GoogleMap?) {

        val puc = LatLng(-30.0592363, -51.1751851)
        mMap.addMarker(MarkerOptions().position(puc).title("Marker in PUCRS"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(puc))
        mMap.setMinZoomPreference(15f)
    }

    fun newInstance(): MapFragment {
        return MapFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

}