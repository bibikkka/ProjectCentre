package com.example.projectcentre.adapter

import android.view.View
import com.example.projectcentre.R
import com.example.projectcentre.databinding.AutoscrollContentBinding
import com.example.projectcentre.domain.model.mainPage.MainPageModel
import com.xwray.groupie.viewbinding.BindableItem

class MainPageHorizontalRecycler(private var image: MainPageModel): BindableItem<AutoscrollContentBinding>() {
    override fun bind(binding: AutoscrollContentBinding, position: Int) {
        binding.ivMage.setImageResource(image.image)
    }

    override fun getLayout(): Int {
        return R.layout.autoscroll_content
    }

    override fun initializeViewBinding(view: View): AutoscrollContentBinding {
        return AutoscrollContentBinding.bind(view)
    }
}