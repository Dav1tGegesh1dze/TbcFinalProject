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
import java.text.NumberFormat
import java.util.Locale

class DishAdapter(
    private val onAddToCartClick: (Dish) -> Unit
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
        holder.bind(getItem(position))
    }

    inner class DishViewHolder(
        private val binding: ItemDishBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(dish: Dish) {
            binding.apply {
                tvDishName.text = dish.name

                // Join ingredients with commas
                val ingredientsText = dish.ingredients.joinToString(", ")
                tvIngredients.text = ingredientsText

                // Format price with currency
                val formatter = NumberFormat.getCurrencyInstance(Locale.US)
                tvDishPrice.text = formatter.format(dish.price)

                // Set delivery time
                tvDeliveryTime.text = "${dish.deliveryTime} min"

                // Load image
                Glide.with(itemView.context)
                    .load(dish.image)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(ivDishImage)

                // Set Add to cart button click listener
                btnAddToCart.setOnClickListener {
                    onAddToCartClick(dish)
                }
            }
        }
    }

    class DishDiffCallback : DiffUtil.ItemCallback<Dish>() {
        override fun areItemsTheSame(oldItem: Dish, newItem: Dish): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Dish, newItem: Dish): Boolean {
            return oldItem == newItem
        }
    }
}