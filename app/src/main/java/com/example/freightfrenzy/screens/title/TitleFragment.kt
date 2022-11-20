package com.example.freightfrenzy.screens.title

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.*
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.freightfrenzy.R
import com.example.freightfrenzy.databinding.FragmentTitleBinding

class TitleFragment: Fragment() {
    private lateinit var titleViewModel: TitleViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
        //Get the ViewModel for this fragment
        titleViewModel = ViewModelProvider(this).get(TitleViewModel::class.java)

        //overflow menu w/o using fragment menu API, which was deprecated already
        requireActivity().addMenuProvider(object: MenuProvider {
            //Inflate the overflow menu resource when create this menu
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.overflow_menu, menu)
            }

            //Return true whether the menu item is handled or not
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return NavigationUI.onNavDestinationSelected(menuItem!!, view!!.findNavController())
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        //TODO: Need to disable going back to sub-pages when going to this title screen.

        //Set up navigation for all buttons in the title screen
        binding.gameButton.setOnClickListener{ view!!.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment()) }
        binding.registerButton.setOnClickListener{ view!!.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToRegisterFragment()) }
        return binding.root
    }
}