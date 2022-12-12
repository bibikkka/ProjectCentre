package com.example.projectcentre.adapter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectcentre.R
import com.example.projectcentre.databinding.MainpageRecBinding
import com.example.projectcentre.domain.model.mainPage.MainPageModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.viewbinding.BindableItem

class MainPageRecycler(private val images: List<MainPageModel>): BindableItem<MainpageRecBinding>() {
    private val horizontalAdapter by lazy { GroupAdapter <GroupieViewHolder>() }
    override fun getLayout(): Int {
        return R.layout.mainpage_rec
    }

    override fun bind(binding: MainpageRecBinding, position: Int) {
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = horizontalAdapter
        }

        horizontalAdapter.replaceAll(images.map { MainPageHorizontalRecycler(it) })
    }

    override fun initializeViewBinding(view: View): MainpageRecBinding {
        return MainpageRecBinding.bind(view)
    }
}
