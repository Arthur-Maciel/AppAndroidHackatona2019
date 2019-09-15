package br.com.southsystem.hackatona2019

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Location
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng


class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var lastLocation: Location
    private lateinit var fusedLocationClient: FusedLocationProviderClient


    private val areas: ArrayList<Area> = arrayListOf()

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
            return
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.uiSettings.isZoomControlsEnabled = true

        setUpMap()

        mMap.isMyLocationEnabled = true
        fusedLocationClient.lastLocation.addOnSuccessListener(this) { location ->
            if (location != null) {
                lastLocation = location
                val currentLatLng = LatLng(location.latitude, location.longitude)
                println(location.latitude)
                println(location.longitude)
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 12f))
            }
        }

        mMap.setMinZoomPreference(15f)

        val area1 = Area("area 1", -30.0699753, -51.1757777, 500, Status("mato", "em alerta", 900))
        val area2 = Area("area 2", -30.0562199, -51.1800445, 300, Status("riacho", "sereno", 870))
        val area3 = Area("area 3", -30.0605308, -51.166284, 150, Status("arvores", "perigo", 1403))

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
        intent = Intent(this, DadosLocalidadeActivity::class.java)
        startActivity(intent)
    }

}
