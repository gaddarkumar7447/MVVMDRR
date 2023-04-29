package com.example.mvvmdrr.adpter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.mvvmdrr.databinding.ProductviewBinding
import com.example.mvvmdrr.model.ProductItem
import javax.inject.Inject

class ProductListAdapter @Inject constructor() : ListAdapter<ProductItem, ProductListAdapter.ProductViewHolder>(diffCallback) {
    var context : Context ?=null
    class ProductViewHolder(val productView : ProductviewBinding) : ViewHolder(productView.root)

    companion object{
        val diffCallback = object : DiffUtil.ItemCallback<ProductItem?>() {
            override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        context = parent.context
        return ProductViewHolder(ProductviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.productView.apply {
            productName.text = currentItem.title
            productPrize.text = "Rs. ${currentItem.price}"
            //productRate.text = "Rating. ${currentItem.rating.rate}"
            Glide.with(context!!).load(currentItem.image).into(imageProduct)
        }
    }

}