package com.example.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemRecyclerviewBinding


class MyAdapter(val mItems: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view : View, position : Int , aLike : Int)

    }
    interface ItemLongClicked{
        fun onItemLongClick(view: View,position: Int): Boolean
    }
    var itemClick : ItemClick? = null
    var itemLongClick : ItemLongClicked? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.Holder {
        val binding =
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position , mItems[position].aLike)
        }
        holder.itemView.setOnLongClickListener {
            itemLongClick?.onItemLongClick(it, position)
            true // 롱클릭 이벤트를 소비했음을 반환
        }
        holder.heart.setOnClickListener {
            val currentItem = mItems[position]
//            currentItem.heart = !currentItem.heart // Toggle the heart value
            if (!currentItem.heart) {
                holder.heart.setImageResource(R.drawable.fillheart)
                mItems[position].heart = true
                mItems[position].aLike += 1
            } else {
//                if (currentItem.heart == true)
                holder.heart.setImageResource(R.drawable.empty_heart)
                mItems[position].aLike -= 1
                mItems[position].heart = false
            }
            notifyItemChanged(position)
        }

        holder.iconImageView.setImageResource(mItems[position].aIcon)
        holder.iconImageView.clipToOutline = true
        holder.title.text = mItems[position].aTitle
        holder.adress.text = mItems[position].aAdress
        holder.price.text = mItems[position].aPrice
        holder.like.text = mItems[position].aLike.toString()
        holder.reply.text = mItems[position].aReply.toString()
        if (mItems[position].heart) {
            holder.heart.setImageResource(R.drawable.fillheart)
        }else {
            holder.heart.setImageResource(R.drawable.empty_heart)
        }


    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }
    fun setHeart(position: Int, heart: Boolean, aLike: Int) {
        mItems[position].heart = heart
        mItems[position].aLike = aLike
        notifyItemChanged(position)
    }


    inner class Holder(val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val iconImageView = binding.itemImage
        val title = binding.txtTitle
        val adress = binding.txtAdress
        val price = binding.prcie
        val like = binding.heartCount
        val reply = binding.replyCount
        val heart = binding.emptyHeart
    }

}