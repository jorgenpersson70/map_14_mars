package se.magictechnology.piaxmapposition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import se.magictechnology.piaxmapposition.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.mapView.getMapAsync(this)


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.markerButton.setOnClickListener {
            // 55.6112032506648, 12.994412054721224
            val minc = LatLng(55.6112032506648, 12.994412054721224)
            var themarker = MarkerOptions().position(minc).title("Minc")
            mMap.addMarker(themarker)

            var camMove = CameraUpdateFactory.newLatLngZoom(minc, 20.0F)

            mMap.moveCamera(camMove)
        }

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        var themarker = MarkerOptions().position(sydney).title("Marker in Sydney")
        mMap.addMarker(themarker)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}