package com.example.labb2_withfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.labb2_withfragments.databinding.FragmentFunctionBinding
import com.example.labb2_withfragments.databinding.FragmentHomeBinding
import com.example.labb2_withfragments.databinding.FragmentNewsBinding
import com.google.android.material.snackbar.Snackbar


class NewsFragment : Fragment() {
    private var _binding: FragmentNewsBinding?=null
    private val binding get()=_binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentNewsBinding.inflate(layoutInflater,container,false)
        val view = binding.root

        //ID

        val btn_home = binding.btnNewsReturnHome

        val btn_subscribe = binding.btnSubscribe

        val inputEmail = binding.etEnterEmail

        // create object list
        val userEmailList=ArrayList<User>()


       //onClick save email, add it in the list ,snackbar the action and undo the action

        btn_subscribe.setOnClickListener {

            val email=inputEmail.text.toString()

          if (email.isEmpty()){

              val snacks = Snackbar.make(inputEmail,"You need to fill in the form",Snackbar.LENGTH_SHORT).show()

          } else{

              userEmailList.add(User(email))

              val snackBar = Snackbar.make(inputEmail,"your email is saved",Snackbar.LENGTH_SHORT).setAction("UNDO"){
                  userEmailList.remove(User(email))
              }.show()
          }


        }

        //global navigation
        btn_home.setOnClickListener {   view->view.findNavController().navigate(R.id.action_global_homeFragment) }



        return view

    }


}