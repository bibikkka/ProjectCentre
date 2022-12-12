package com.example.projectcentre.presentation.mainPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectcentre.R
import com.example.projectcentre.adapter.ExampleAdapter
import com.example.projectcentre.adapter.MainPageRecycler
import com.example.projectcentre.databinding.FragmentMainPageBinding
import com.example.projectcentre.domain.model.mainPage.MainPageModel
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainPage : Fragment() {
    private var _binding: FragmentMainPageBinding? = null
    private val binding get() = _binding!!

    private val groupAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity).supportActionBar?.title = "Главная страница"
        _binding = FragmentMainPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()
        observeOnState()
    }

    private fun observeOnState() {
        val list: List<Group> = mutableListOf<Group>().apply {
            this += MainPageRecycler(
                images = listOf(
                    MainPageModel(R.drawable.firstmain),
                    MainPageModel(R.drawable.secondmain),
                    MainPageModel(R.drawable.thirdmain),
                    MainPageModel(R.drawable.fourthmain),
                )
            )
        }

        groupAdapter.replaceAll (list)
    }

    private fun initRecycler(){
        binding.rvAutoScrollContent.adapter = groupAdapter
        binding.rvAutoScrollContent.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}