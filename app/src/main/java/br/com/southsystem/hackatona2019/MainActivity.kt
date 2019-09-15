package br.com.southsystem.hackatona2019

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Location
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.southsystem.hackatona2019.api.Data
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.Circle
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var lastLocation: Location
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private var areas: MutableMap<Circle, Data> = mutableMapOf()

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        val viewModel = ViewModelProviders.of(this).get(DadosViewModel::class.java)
        viewModel.dadosLiveData.observe(this, Observer {
            it?.let {
                for (dado in it) {
                    loadAreas(dado)
                }
            }
        })

        viewModel.getDados()
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

        mMap.setMinZoomPreference(12.5f)

        mMap.setOnCircleClickListener { circleTmp ->

            intent = Intent(this, DadosLocalidadeActivity::class.java).putExtra(
                "dados",
                areas.get(circleTmp)
            )
            startActivity(intent)
        }
    }

    private fun loadAreas(it: Data) {

        val cent = LatLng(it.latitude!!.toDouble(), it.longitude!!.toDouble())

        var circle: CircleOptions? = null
        if (it.status!!.situacao.equals("Verde")) {
            circle = CircleOptions()
                .center(cent)
                .radius(it.raio!!.toDouble())
                .strokeWidth(5f)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(70, 124, 252, 0))
                .clickable(true)
        } else if (it.status.situacao.equals("Amarelo")) {
            circle = CircleOptions()
                .center(cent)
                .radius(it.raio!!.toDouble())
                .strokeWidth(5f)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.argb(150, 255, 215, 0))
                .clickable(true)
        } else {
            circle = CircleOptions()
                .center(cent)
                .radius(it.raio!!.toDouble())
                .strokeWidth(5f)
                .strokeColor(Color.RED)
                .fillColor(Color.argb(70, 150, 70, 70))
                .clickable(true)
        }
        val circleObj = mMap.addCircle(circle!!)
        areas.put(circleObj, it!!)
    }

    fun nextActivity(view: View) {
        intent = Intent(this, DadosLocalidadeActivity::class.java)
        startActivity(intent)
    }

}


