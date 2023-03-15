package com.example.labb2_withfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.labb2_withfragments.databinding.FragmentAboutBinding
import com.example.labb2_withfragments.databinding.FragmentHomeBinding

class AboutFragment : Fragment() {
    private var _binding: FragmentAboutBinding?=null
    private val binding get()=_binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding=FragmentAboutBinding.inflate(layoutInflater,container,false)
        val view = binding.root

        //ID
        val btn_home = binding.btnAboutReturnHome


        //global navigation
        btn_home.setOnClickListener {   view->view.findNavController().navigate(R.id.action_global_homeFragment) }


        return view


    }


}