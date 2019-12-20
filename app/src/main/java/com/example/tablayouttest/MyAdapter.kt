package com.example.tablayouttest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contact_cell.view.*

class MyAdapter:ListAdapter<Person, MyViewHolder>(DIFFCALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val holder = MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.contact_cell, parent, false))
        return holder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val person = getItem(position)
        holder.itemView.textViewName.text = person.name
        holder.itemView.textViewNumber.text = person.number
    }

    object DIFFCALLBACK:DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.number == newItem.number
        }

    }


}

class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)