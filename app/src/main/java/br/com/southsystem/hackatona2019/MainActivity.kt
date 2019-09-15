package br.com.southsystem.hackatona2019

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

//        addFragment(MapFragment(), false, "one")

    }

    override fun onMapReady(p0: GoogleMap) {
        mMap = p0

        val puc = LatLng(-30.0592363, -51.1751851)
        mMap.addMarker(MarkerOptions().position(puc).title("Marker in PUCRS"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(puc))
        mMap.setMinZoomPreference(15f)
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
