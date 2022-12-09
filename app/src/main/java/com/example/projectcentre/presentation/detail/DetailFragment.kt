package com.example.projectcentre.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectcentre.R
import com.example.projectcentre.databinding.FragmentDetailBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private val args: DetailFragmentArgs by navArgs()

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DetailViewModel by viewModels()
    private val groupAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getTasks(args.projectID)

        observeOnState()
        initListeners()
        initRecycler()
    }

    private fun initRecycler() {
        binding.recycler.adapter = groupAdapter
        binding.recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun initListeners() {
        binding.zakazchikTru.text = args.projectZakazchik
        binding.materialTextView2.text = args.projectDateStart
        binding.dateEndTruStory.text = args.projectDateEnd
        binding.materialTextView.text = args.projectName

        binding.create.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("id", args.projectID)
            findNavController().navigate(R.id.addTask, bundle)
        }
    }

    private fun observeOnState() {

//        viewModel.state.onEach { state ->
//            val list: List<Group> = mutableListOf<Group>().apply {
//
//                if (state.detailsTasksState.data?.isNotEmpty() == true) {
//                    for(i in 0 until state.detailsTasksState.data.size) {
//                        this += VerticalTasksItem(
//                            task = Tasks(
//                                id = state.detailsTasksState.data[i].id,
//                                projectID = state.detailsTasksState.data[i].projectID,
//                                status = state.detailsTasksState.data[i].status,
//                                title = state.detailsTasksState.data[i].title,
//                                executorName = state.detailsTasksState.data[i].executorName,
//                                dateStart = state.detailsTasksState.data[i].dateStart,
//                                dateEnd = state.detailsTasksState.data[i].dateEnd,
//                                description = state.detailsTasksState.data[i].description,
//                            ),
//                            fragment = this@DetailFragment
//                        )
//                    }
//                }
//            }
//
//            groupAdapter.replaceAll(list)
//        }.launchWhenStarted()

    }

    private fun <T> Flow<T>.launchWhenStarted() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted { collect () }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}