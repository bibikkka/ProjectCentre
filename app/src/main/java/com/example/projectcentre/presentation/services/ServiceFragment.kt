package com.example.projectcentre.presentation.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectcentre.R
import com.example.projectcentre.adapter.ChildItem
import com.example.projectcentre.adapter.ExpandableHeaderItem
import com.example.projectcentre.adapter.MainPageRecycler
import com.example.projectcentre.databinding.FragmentServiceBinding
import com.example.projectcentre.domain.model.mainPage.MainPageModel
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.groupiex.plusAssign
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ServiceFragment : Fragment() {
    private var _binding: FragmentServiceBinding? = null
    private val binding get() = _binding!!

    private val groupAdapter = GroupAdapter<GroupieViewHolder>()
    private lateinit var groupLayoutManager: LinearLayoutManager

    private val childList = listOf(
        ChildItem(title = "Долговременная укладка +\nокрашивание", description = "от 1500 Р, 1 час."),
        ChildItem(title = "Долговременная укладка ( без\nокрашивания)", description = "от 1200 Р, 1 час."),
        ChildItem(title = "Архитектура бровей и окрашивание\nкраской/хной", description = "от 1000 Р, 1 час."),
    )

    private val parentList = listOf(
        ExpandableHeaderItem("Дизайн бровей"),
        ExpandableHeaderItem("Дизайн бровей"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity).supportActionBar?.title = "Услуги"
        _binding = FragmentServiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeOnState()
    }

    private fun observeOnState() {
        groupLayoutManager = LinearLayoutManager(requireContext())

        binding.recycler.apply {
            layoutManager = groupLayoutManager
            adapter = groupAdapter
        }

        groupAdapter.apply {
            for (i in parentList){
                this += ExpandableGroup(i).apply {
                    for (j  in childList) {
                        add(j)
                    }
                }

            }
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}