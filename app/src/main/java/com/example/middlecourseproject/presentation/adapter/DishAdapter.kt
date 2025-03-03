package com.example.middlecourseproject.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.transition.Transition.ViewAdapter
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.FoodRecyclerItemBinding
import com.example.middlecourseproject.databinding.IngredientRecyclerItemBinding
import com.example.middlecourseproject.domain.models.Recipe

class DishAdapter(private val items: List<String>) :
    RecyclerView.Adapter<DishAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = IngredientRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    inner class ItemViewHolder( private val binding: IngredientRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: String) {
            binding.ingredientName.text = item
        }
    }
}
