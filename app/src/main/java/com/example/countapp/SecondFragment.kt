package com.example.countapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    val args: SecondFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(view) {
            findViewById<Button>(R.id.button_second).setOnClickListener {
                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            }

            //get the count argument, get the string and format it with the count
            val count = args.myArg
            val countText = getString(R.string.random_heading, count)
            findViewById<TextView>(R.id.textview_header).text = countText

            // create random number
            val random = java.util.Random()
            var randomNum = 0
            if (count > 0) {
                randomNum = random.nextInt(count + 1)
            }

            // get the id of the number
            findViewById<TextView>(R.id.textview_random).text = randomNum.toString()
        }


    }
}