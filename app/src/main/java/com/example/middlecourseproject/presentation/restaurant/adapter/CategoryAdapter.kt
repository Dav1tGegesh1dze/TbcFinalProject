package com.example.middlecourseproject.presentation.restaurant.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.ItemCategoryBinding
import com.example.middlecourseproject.domain.restaurant.model.Category


class CategoryAdapter(
    private val onCategoryClicked: (String) -> Unit
) : ListAdapter<Category, CategoryAdapter.CategoryViewHolder>(CategoryDiffCallback()) {

    private var selectedCategoryId: String? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = getItem(position)
        holder.bind(category, category.id == selectedCategoryId)
    }

    fun setSelectedCategory(categoryId: String?) {
        val oldSelectedId = selectedCategoryId
        selectedCategoryId = categoryId

        if (oldSelectedId != null) {
            val oldIndex = currentList.indexOfFirst { it.id == oldSelectedId }
            if (oldIndex != -1) {
                notifyItemChanged(oldIndex)
            }
        }

        if (categoryId != null) {
            val newIndex = currentList.indexOfFirst { it.id == categoryId }
            if (newIndex != -1) {
                notifyItemChanged(newIndex)
            }
        }
    }

    inner class CategoryViewHolder(
        private val binding: ItemCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val category = getItem(position)
                    onCategoryClicked(category.id)
                }
            }
        }

        fun bind(category: Category, isSelected: Boolean) {
            binding.tvCategoryName.text = category.name

            category.imageUrl?.let { imageUrl ->
                Glide.with(binding.root.context)
                    .load(imageUrl)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(binding.ivCategoryImage)
            } ?: run {
                binding.ivCategoryImage.setImageDrawable(null)
            }

            // Change color later
            if (isSelected) {
                binding.root.setCardBackgroundColor(
                    ContextCompat.getColor(binding.root.context, R.color.white)
                )
                binding.tvCategoryName.setTextColor(
                    ContextCompat.getColor(binding.root.context, R.color.green_500)
                )
            } else {
                binding.root.setCardBackgroundColor(
                    ContextCompat.getColor(binding.root.context, R.color.white)
                )
                binding.tvCategoryName.setTextColor(
                    ContextCompat.getColor(binding.root.context, R.color.black)
                )
            }
        }
    }

    private class CategoryDiffCallback : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem == newItem
        }
    }
}