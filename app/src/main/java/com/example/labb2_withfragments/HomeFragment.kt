package com.example.labb2_withfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.labb2_withfragments.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding?=null
    private val binding get()=_binding!!




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding=FragmentHomeBinding.inflate(layoutInflater,container,false)
        val view = binding.root

        //ID
        val btn_naviAbout=binding.btnAboutUs
        val btn_naviQuiz=binding.btnQuiz
        val btn_naviNews=binding.btnNewsLetter


        //navigations

        btn_naviAbout.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_aboutFragment)
        }

        btn_naviQuiz.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_functionFragment)
        }

        btn_naviNews.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_newsFragment)
        }

        return view
    }

}