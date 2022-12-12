package com.example.projectcentre.adapter

import com.example.projectcentre.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_list_child.view.*

open class ChildItem(val title : String, private val description: String) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.root.child_textTitle.text = title
        viewHolder.root.child_textDescription.text = description
    }
    override fun getLayout(): Int {
        return R.layout.item_list_child
    }

}
