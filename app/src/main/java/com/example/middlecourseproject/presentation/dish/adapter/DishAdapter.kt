package com.example.middlecourseproject.presentation.dish.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.ItemDishBinding
import com.example.middlecourseproject.domain.restaurant.model.Dish
import com.example.middlecourseproject.presentation.ar.FoodArActivity
import java.text.NumberFormat
import java.util.Locale

class DishAdapter(
    private val onAddToCartClick: (Dish) -> Unit
) : ListAdapter<Dish, DishAdapter.DishViewHolder>(DishDiffCallback()) {

    private var restaurantCategoryId: String = ""
    private var restaurantName: String = ""

    fun setRestaurantInfo(categoryId: String, name: String) {
        this.restaurantCategoryId = categoryId
        this.restaurantName = name
        notifyDataSetChanged()
    }

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

                val ingredientsText = dish.ingredients.joinToString(", ")
                tvIngredients.text = ingredientsText

                val formatter = NumberFormat.getCurrencyInstance(Locale.US)
                tvDishPrice.text = formatter.format(dish.price)

                tvDeliveryTime.text = "${dish.deliveryTime} min"

                Glide.with(itemView.context)
                    .load(dish.image)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(ivDishImage)

                btnAddToCart.setOnClickListener {
                    onAddToCartClick(dish)
                }

                btnViewIn3d.setOnClickListener {
                    val intent = Intent(itemView.context, FoodArActivity::class.java).apply {
                        putExtra("DISH_ID", dish.id)
                        putExtra("DISH_NAME", dish.name)
                        putExtra("RESTAURANT_CATEGORY_ID", restaurantCategoryId)
                        putExtra("RESTAURANT_NAME", restaurantName)
                    }
                    itemView.context.startActivity(intent)
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