package com.example.projectcentre.presentation.services

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.projectcentre.R
import com.example.projectcentre.databinding.FragmentServiceBinding
import com.example.projectcentre.databinding.FragmentServiceChoiceBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ServiceChoice : Fragment() {
    private var _binding: FragmentServiceChoiceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity).supportActionBar?.title = "Выбор услуг"
        _binding = FragmentServiceChoiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView(){
        binding.cvService.setOnClickListener {
            findNavController().navigate(R.id.action_serviceChoice_to_serviceFragment)
        }
        binding.cvMaster.setOnClickListener {
            findNavController().navigate(R.id.action_serviceChoice_to_masterFragment)
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}