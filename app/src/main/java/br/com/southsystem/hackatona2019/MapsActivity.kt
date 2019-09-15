package br.com.southsystem.hackatona2019

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.Circle
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlin.collections.ArrayList

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    private val areas: ArrayList<Area> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in PUCRS and move the camera
        val puc = LatLng(-30.0592363, -51.1751851)
        mMap.addMarker(MarkerOptions().position(puc).title("Marker in PUCRS"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(puc))
        mMap.setMinZoomPreference(15f)

        val area1 = Area("area 1",-30.0699753, -51.1757777,500, Status("mato","em alerta", 900))
        val area2 = Area("area 2",-30.0562199, -51.1800445, 300, Status("riacho","sereno", 870))
        val area3 = Area("area 3",-30.0605308, -51.166284, 150, Status("arvores","perigo", 1403))

        areas.add(area1)
        areas.add(area2)
        areas.add(area3)

        val circles: List<CircleOptions>? = loadAreas()

        circles?.forEach { mMap.addCircle(it) }

        mMap.setOnCircleClickListener {
            println(it.toString())
        }
    }


    private fun loadAreas() = areas.map {

            val cent = LatLng(it.latitude.toDouble(), it.longitude.toDouble())

            when {
                it.Status.situacao.equals("sereno") ->
                    CircleOptions()
                        .center(cent)
                        .radius(it.raio.toDouble())
                        .strokeWidth(5f)
                        .strokeColor(Color.GREEN)
                        .fillColor(Color.argb(70, 124, 252, 0))
                        .clickable(true)
                it.Status.situacao.equals("em alerta") ->
                    CircleOptions()
                        .center(cent)
                        .radius(it.raio.toDouble())
                        .strokeWidth(5f)
                        .strokeColor(Color.YELLOW)
                        .fillColor(Color.argb(70, 255, 255, 0))
                        .clickable(true)

                else ->
                    CircleOptions()
                        .center(cent)
                        .radius(it.raio.toDouble())
                        .strokeWidth(5f)
                        .strokeColor(Color.RED)
                        .fillColor(Color.argb(70,150, 70, 70))
                        .clickable(true)

            }
        }

}
