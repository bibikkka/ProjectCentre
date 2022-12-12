package com.example.projectcentre.adapter

import android.view.View
import androidx.annotation.StringRes
import com.example.projectcentre.R
import com.example.projectcentre.databinding.ItemHeaderBinding
import com.xwray.groupie.viewbinding.BindableItem

open class HeaderItem(
    @StringRes private val titleStringResId: Int
) : BindableItem<ItemHeaderBinding>() {
    override fun bind(viewBinding: ItemHeaderBinding, position: Int) {
        viewBinding.title.setText(titleStringResId)
    }

    override fun getLayout(): Int {
        return R.layout.item_header
    }

    override fun initializeViewBinding(view: View): ItemHeaderBinding {
        return ItemHeaderBinding.bind(view)
    }
}