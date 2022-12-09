package com.example.projectcentre.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding
import com.example.projectcentre.databinding.AutoscrollContentBinding
import com.example.projectcentre.domain.model.mainPage.MainPageModel

class ExampleAdapter : ListAdapter<MainPageModel, ViewHolder>(ExampleDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AutoscrollContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ExampleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemViewHolder = holder as ExampleViewHolder
        itemViewHolder.bind(getItem(position))
    }

//    fun onLinkItem(holder: ViewHolder, position: Int, onLinkItem: (String) -> Unit) {
//        val itemViewHolder = holder as ExampleViewHolder
//        itemViewHolder.onLinkItem(getItem(position), onLinkItem)
//    }
}

class ExampleDiffCallback : DiffUtil.ItemCallback<MainPageModel>() {

    override fun areItemsTheSame(oldItem: MainPageModel, newItem: MainPageModel): Boolean =
        oldItem.image == newItem.image

    override fun areContentsTheSame(oldItem: MainPageModel, newItem: MainPageModel): Boolean =
        oldItem == newItem
}

class ExampleViewHolder(
    private val binding: ViewBinding
) : ViewHolder(binding.root) {

    fun bind(item: MainPageModel) {
        val binding = (binding as AutoscrollContentBinding)

        binding.ivMage.setBackgroundResource(item.image)
    }
}