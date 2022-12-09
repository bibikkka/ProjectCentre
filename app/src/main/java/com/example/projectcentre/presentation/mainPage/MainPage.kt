package com.example.projectcentre.presentation.mainPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectcentre.R
import com.example.projectcentre.adapter.ExampleAdapter
import com.example.projectcentre.databinding.FragmentMainPageBinding
import com.example.projectcentre.domain.model.mainPage.MainPageModel

class MainPage : Fragment() {
    private var _binding: FragmentMainPageBinding? = null
    private val binding get() = _binding!!
    private var reverse = false
    private var loop = false
    private var canTouch = false
    private var orientationLm = LinearLayoutManager.HORIZONTAL
    private var currentSpeed = 40

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        val lm = LinearLayoutManager(requireContext())
        lm.orientation = LinearLayoutManager.HORIZONTAL

        binding.rvAutoScrollContent.layoutManager = lm

        setUpAutoScrollContent(
            listOf(
                MainPageModel(R.drawable.firstmain),
                MainPageModel(R.drawable.secondmain),
                MainPageModel(R.drawable.thirdmain),
                MainPageModel(R.drawable.fourthmain),
            )
        )
    }
    private fun setUpAutoScrollContent(messagesList: List<MainPageModel>) {

        val adapter = ExampleAdapter().apply {
            submitList(messagesList)
        }

        binding.rvAutoScrollContent.adapter = adapter
//
//        binding.rvAutoScrollContent.setItemClickListener { viewHolder, position ->
//            viewHolder?.let {
//                adapter.onLinkItem(viewHolder, position, onItemClicked)
//            }
//        }
    }

//    private fun setUpSwReverseChecked() {
//        binding.swReverseContent.setOnCheckedChangeListener { _, isChecked ->
//            reverse = isChecked
//            setUpLoop()
//            setUpSpeed()
//            setUpReverse()
//            setUpCanTouch()
//            setUpOrientationLm()
//        }
//    }

//    private fun setUpSwCanTouchChecked() {
//        binding.swCanTouchContent.setOnCheckedChangeListener { _, isChecked ->
//            canTouch = isChecked
//            setUpLoop()
//            setUpSpeed()
//            setUpReverse()
//            setUpCanTouch()
//            setUpOrientationLm()
//        }
//    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}