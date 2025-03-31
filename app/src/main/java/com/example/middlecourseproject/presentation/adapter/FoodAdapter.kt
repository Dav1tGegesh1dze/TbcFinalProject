package com.example.middlecourseproject.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.middlecourseproject.databinding.FoodRecyclerItemBinding
import com.example.middlecourseproject.presentation.imageLoading.ImageLoader
import com.example.middlecourseproject.domain.models.Recipe

class FoodAdapter (
    private val imageLoader: ImageLoader,
    private val onCardClick : (String) -> Unit
) : PagingDataAdapter<Recipe, FoodAdapter.ItemViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = FoodRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.onBind(item)
        }
    }

    inner class ItemViewHolder(private val binding: FoodRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Recipe) {
            imageLoader.loadImage(binding.foodImage, item.imageUrl)

            binding.foodTitle.text = item.title
            binding.publisher.text = "By ${item.publisher}"
            binding.root.setOnClickListener{
                onCardClick(item.recipeId)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Recipe>() {
            override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
                return oldItem.recipeId == newItem.recipeId
            }

            override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
                return oldItem == newItem
            }
        }
    }
}
