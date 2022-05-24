package com.example.loginapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController

import com.example.loginapp.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.btn.setOnClickListener {

            if (binding.edit1.text.toString() == "Rakesh singh") {
                if (binding.edit2.text.toString().toInt() == 1234) {
                    findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToNextFragment())
                } else {
                    Toast.makeText(requireContext(), "incorrect password", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(context, "incorrect name", Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }


}