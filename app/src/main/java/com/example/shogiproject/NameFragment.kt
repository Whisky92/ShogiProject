package com.example.shogiproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.shogiproject.databinding.FragmentNameBinding


class NameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_name, container, false)
        val text = view.findViewById<EditText>(R.id.input_text) as EditText

        view.findViewById<Button>(R.id.submit_btn).setOnClickListener {
            lateinit var action: NavDirections
            if(text.text.toString() == "") {
                action = NameFragmentDirections.actionNameFragmentToRpsGameFragment()
            } else {
                action = NameFragmentDirections.actionNameFragmentToRpsGameFragment(text.text.toString())
            }
            Navigation.findNavController(view).navigate(action)
        }

        return view
    }

}