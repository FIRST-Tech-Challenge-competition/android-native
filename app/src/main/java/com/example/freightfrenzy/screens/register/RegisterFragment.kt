package com.example.freightfrenzy.screens.register

import android.app.Activity
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentRegisterBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


class RegisterFragment: Fragment(), OnMapReadyCallback {
    private lateinit var registerViewModel: RegisterViewModel
    private var imageURL: Uri? = null
    private lateinit var imgView: ImageView
    private lateinit var mapView: MapView
    private var mapViewBundle: Bundle? = null
    private var latLong: Array<Double> = arrayOf(0.0, 0.0)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity?.setTitle("Team registration")
        val binding: FragmentRegisterBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        //Get the ViewModel for this fragment
        registerViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        imgView = binding.chooseImage

        //Implement mapView
        mapView = binding.mapView
        if(savedInstanceState != null) mapViewBundle = savedInstanceState.getBundle("MapViewBundleKey")
        mapView.onCreate(mapViewBundle)
        mapView.getMapAsync(this)

        //Set up add image
        binding.chooseImage.setOnClickListener { registerViewModel.uploadImage(imageUploaderLauncher) }
        binding.addImageText.setOnClickListener{ registerViewModel.uploadImage(imageUploaderLauncher) }

        //TODO: Navigation back to main screen, add these info to database (name, id, location, robot's name, Image URI, allow_score_sharing)
        binding.register.setOnClickListener{
            Log.i("URI is", imageURL.toString())
            Log.i("Lattitude is", latLong[0].toString())
            Log.i("Longtitude is", latLong[1].toString())
        }
        return binding.root
    }

    //The receiver for the activity result
    val imageUploaderLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == Activity.RESULT_OK){
            imageURL = result.data!!.data
            imgView.setImageURI(imageURL)
        }
    }

    //The callback(s) for Google Map above
    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onMapReady(map: GoogleMap) {
        if(perm_check()) return
        //Set up marker drag event
        map.setOnMarkerDragListener(object : GoogleMap.OnMarkerDragListener{
            override fun onMarkerDrag(p0: Marker) {}

            override fun onMarkerDragEnd(new_marker: Marker) {
                latLong[0] = new_marker.position.latitude
                latLong[1] = new_marker.position.longitude
                map.animateCamera(CameraUpdateFactory.newLatLng(new_marker.position))
            }

            override fun onMarkerDragStart(p0: Marker){}
        })

        var defaultMarker = MarkerOptions().position(LatLng(0.0, 0.0)).title("Marker").draggable(true)
        map.addMarker(defaultMarker)
    }

    override fun onPause() {
        mapView.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        mapView.onDestroy()
        super.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    //Check ACCESS_FINE_LOCATION and ACCESS_COARSE_LOCATION permissions, this is set in AndroidManifest
    fun perm_check(): Boolean{
        return ActivityCompat.checkSelfPermission(activity!!, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(activity!!, android.Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED
    }
}