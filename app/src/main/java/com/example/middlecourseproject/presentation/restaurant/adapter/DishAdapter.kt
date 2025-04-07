package com.example.middlecourseproject.presentation.restaurant.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.ItemDishBinding
import com.example.middlecourseproject.domain.restaurant.model.Dish


class DishAdapter(
    private val onAddClicked: (String) -> Unit
) : ListAdapter<Dish, DishAdapter.DishViewHolder>(DishDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val binding = ItemDishBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DishViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        val dish = getItem(position)
        holder.bind(dish)
    }

    inner class DishViewHolder(
        private val binding: ItemDishBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.btnAddToCart.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val dish = getItem(position)
                    onAddClicked(dish.id)
                }
            }
        }

        fun bind(dish: Dish) {
            binding.apply {
                tvDishName.text = dish.name
                tvDishPrice.text = "$${dish.price}"
                tvDeliveryTime.text = "${dish.deliveryTime} min"

                val ingredientsText = dish.ingredients.joinToString(", ")
                tvIngredients.text = ingredientsText

                // Later
                Glide.with(root.context)
                    .load(dish.image)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_background)
                    .into(ivDishImage)
            }
        }
    }

    private class DishDiffCallback : DiffUtil.ItemCallback<Dish>() {
        override fun areItemsTheSame(oldItem: Dish, newItem: Dish): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Dish, newItem: Dish): Boolean {
            return oldItem == newItem
        }
    }
}