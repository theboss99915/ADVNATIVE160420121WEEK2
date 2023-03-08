package com.anmp.adv160420121week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.random.Random


/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    var score = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textRandomNum1.text = (0..20).random().toString()
        textRandomNum2.text = (0..20).random().toString()
        btnSubmit.setOnClickListener(){
            var total = Integer.parseInt(textRandomNum1.text.toString()) + Integer.parseInt(textRandomNum2.text.toString())
            if(total.toString()==numberAnswer.text.toString())
            {
                score = score + 1
                textRandomNum1.text = (0..20).random().toString()
                textRandomNum2.text = (0..20).random().toString()
                numberAnswer.text.clear()

            }
            else{
                var action = MainFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

}