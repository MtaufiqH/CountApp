package com.example.countapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(view){
            findViewById<Button>(R.id.random_button).setOnClickListener {
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }

            findViewById<Button>(R.id.toast_button).setOnClickListener {
                Toast.makeText(context, getString(R.string.toast_text), Toast.LENGTH_SHORT).show()
            }

            findViewById<Button>(R.id.random_button).setOnClickListener {
//                countMe(view)
                // get the id
                val showCountTextView = view.findViewById<TextView>(R.id.textview_first)

                // get the current text on the textView and convert to int
                val currentCount = showCountTextView.text.toString().toInt()

                //create an action
                val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)

                // navigate
                findNavController().navigate(action)


            }
        }

    }

    private fun countMe(view: View) {
        // get the textView
        val showCountText = view.findViewById<TextView>(R.id.textview_first)

        // get the text on the Text View
        val countString = showCountText.text.toString()

        // convert to int and then increment it
        var count = countString.toInt()
        count++

        // display new value to the text view
        showCountText.text = count.toString()

    }
}