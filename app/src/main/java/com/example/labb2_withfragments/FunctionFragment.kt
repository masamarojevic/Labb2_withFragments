package com.example.labb2_withfragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import com.example.labb2_withfragments.Counter.CounterViewModel
import com.example.labb2_withfragments.databinding.FragmentFunctionBinding
import kotlinx.coroutines.launch


class FunctionFragment : Fragment() {
    private var _binding: FragmentFunctionBinding?=null
    private val binding get()=_binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding=FragmentFunctionBinding.inflate(layoutInflater,container,false)
        val view = binding.root

        //viewModel
        val counterViewModel: CounterViewModel by viewModels()


        //first answer group
        val answer1One: RadioButton = binding.rBtn1Of1
        val answer1Two: RadioButton = binding.rBtn2Of1
        val answer1Three: RadioButton = binding.rBtn3Of1

        val correctAnswer1 = answer1One

       //second answer group
        val answer2One: RadioButton = binding.rBtn1Of2
        val answer2Two: RadioButton = binding.rBtn2Of2
        val answer2Three: RadioButton = binding.rBtn3Of2

        val correctAnswer2 = answer2Two

       //third answer group
        val answer3One: RadioButton = binding.rBtn1Of3
        val answer3Two: RadioButton = binding.rBtn2Of3
        val answer3Three: RadioButton = binding.rBtn3Of3

        val correctAnswer3=answer3Two


        val pointsValue: TextView =binding.tvTotalPoints

        val buttonSubmit: Button =binding.btnSubmitAnswers

        val btn_home=binding.btnFunctionReturnHome

        val correctAnswers = arrayOf(correctAnswer1,correctAnswer2,correctAnswer3)

        val allAnswers = arrayOf(answer1One,answer1Two, answer1Three,answer2One,answer2Two,answer3Three,answer3One,answer3Two,answer3Three)


        //async lifecycle function for state
        lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED){

                //we collect data fron counterviewmodel
                counterViewModel.uiState.collect {

                    //update UI elements
                    pointsValue.text = counterViewModel.uiState.value.counterPoints.toString()

                }
            }
        }

        //number of possible clicks
        var numOfClickChoice = 0

        buttonSubmit.setOnClickListener {

                for (correct in correctAnswers) {
                    if (correct.isChecked) {
                        counterViewModel.add()

                    }
                }

               for(all in allAnswers){
                   if(all.isChecked){
                       numOfClickChoice++
                   }
                   if(numOfClickChoice == 3){
                       buttonSubmit.isEnabled = false
                   }
               }

        }

        //global navigation
        btn_home.setOnClickListener {
                view->view.findNavController().navigate(R.id.action_global_homeFragment)
        }


        return view

    }


}