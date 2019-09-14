package br.com.southsystem.hackatona2019

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlin.collections.ArrayList

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    val areas: ArrayList<Any>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        popula()

    }

    fun popula() {
//        for (i in list) {
//            if (i.selecionada!!) {
//                dados!!.add(i.name)
//            }
//        }


        val Area1 = object {
            val latitude = "-30.0699753"
            val longitude = "-51.1757777"
            val raio = "500"
            val status = object {
                val situacao = "em alerta"
            }
        }
        val Area2 = object {
            val latitude = "-30.0562199"
            val longitude = "-51.1800445"
            val raio = "300"
            val status = object {
                val situacao = "sereno"
            }
        }
        val Area3 = object {
            val latitude = "-51.1800445"
            val longitude = "-51.166284"
            val raio = "150"
            val status = object {
                val situacao = "perigo"
            }
        }

        areas?.add(Area1)
        areas?.add(Area2)
        areas?.add(Area3)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in PUCRS and move the camera
        val puc = LatLng(-30.0592363, -51.1751851)
        mMap.addMarker(MarkerOptions().position(puc).title("Marker in PUCRS"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(puc))
        mMap.setMinZoomPreference(15f)

        loadAreas()

        mMap.setOnCircleClickListener {
            println(it.isVisible)
        }
    }


    private fun loadAreas() {

        if (areas != null) {
            for (i in areas) {
                
            }
        }



        val redArea2 = LatLng(-30.0699753, -51.1757777)

       mMap.addCircle(
            CircleOptions()
                .center(redArea2)
                .radius(500.0)
                .strokeWidth(5f)
                .strokeColor(Color.RED)
                .fillColor(Color.argb(70,150,70,70))
                .clickable(true)
        )
    }

}
