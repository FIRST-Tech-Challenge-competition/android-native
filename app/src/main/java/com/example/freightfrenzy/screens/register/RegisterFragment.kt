package com.example.freightfrenzy.screens.register

import android.app.Activity
import android.app.Application
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
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.freightfrenzy.R
import com.example.freightfrenzy.database.RegisteredTeamDatabaseDao
import com.example.freightfrenzy.database.RegisteredTeamsDatabase
import com.example.freightfrenzy.databinding.FragmentRegisterBinding
import com.example.freightfrenzy.screens.registered_teams.RegisteredTeamsViewModelFactory
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
        val binding: FragmentRegisterBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = RegisteredTeamsDatabase.getInstance(application).registeredTeamDatabaseDao
        val viewModelFactory = RegisterViewModelFactory(application = application, dataSource = dataSource)

        //Get the ViewModel for this fragment
        registerViewModel = ViewModelProvider(this, viewModelFactory).get(RegisterViewModel::class.java)
        imgView = binding.chooseImage

        //Implement mapView
        mapView = binding.mapView
        if(savedInstanceState != null) mapViewBundle = savedInstanceState.getBundle("MapViewBundleKey")
        mapView.onCreate(mapViewBundle)
        mapView.getMapAsync(this)

        //Set up add image
        binding.chooseImage.setOnClickListener { registerViewModel.uploadImage(imageUploaderLauncher) }
        binding.addImageText.setOnClickListener{ registerViewModel.uploadImage(imageUploaderLauncher) }

        binding.register.setOnClickListener{
            //TODO: Need to handle special inputs here, need to requires image, team name and id
            Log.i("Image URL", imageURL.toString())
            Log.i("latLong", latLong.toString())
            Log.i("Team Name: ", binding.teamName.text.toString())
            Log.i("Team ID: ", binding.teamID.text.toString())
            Log.i("Robot name: ", binding.robotName.text.toString())

            registerViewModel.addingTeam(imageURL, latLong[0], latLong[1], binding.teamName.text.toString(), binding.teamID.text.toString().toInt(), binding.robotName.text.toString())
            view!!.findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToTitleFragment())
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
        var defaultMarker = MarkerOptions().position(LatLng(0.0, 0.0)).title("Marker").draggable(true)
        map.addMarker(defaultMarker)

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
        if(perm_check()) return
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
        return ActivityCompat.checkSelfPermission(
            activity!!,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(
            activity!!,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        )!= PackageManager.PERMISSION_GRANTED
    }
}