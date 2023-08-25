package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemRecyclerviewBinding


class MyAdapter(val mItems: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.Holder {
        val binding =
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.iconImageView.setImageResource(mItems[position].aIcon)
        holder.iconImageView.clipToOutline = true
        holder.title.text = mItems[position].aTitle
        holder.adress.text = mItems[position].aAdress
        holder.price.text = mItems[position].aPrice

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }


    inner class Holder(val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val iconImageView = binding.itemImage
        val title = binding.txtTitle
        val adress = binding.txtAdress
        val price = binding.prcie
    }

}