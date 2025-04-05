package com.example.middlecourseproject.presentation.restaurant.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.ItemRestaurantBinding
import com.example.middlecourseproject.domain.restaurant.model.Restaurant

class RestaurantAdapter(
    private val onRestaurantClicked: (String) -> Unit
) : ListAdapter<Restaurant, RestaurantAdapter.RestaurantViewHolder>(RestaurantDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding = ItemRestaurantBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = getItem(position)
        holder.bind(restaurant)
    }

    inner class RestaurantViewHolder(
        private val binding: ItemRestaurantBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val restaurant = getItem(position)
                    onRestaurantClicked(restaurant.id)
                }
            }
        }

        fun bind(restaurant: Restaurant) {
            binding.apply {
                tvRestaurantName.text = restaurant.name
                ratingBar.rating = restaurant.rating.toFloat()
                tvRating.text = restaurant.rating.toString()

                val avgPrice = restaurant.menu.flatMap { it.dishes }
                    .takeIf { it.isNotEmpty() }
                    ?.let { dishes ->
                        val min = dishes.minOfOrNull { it.price } ?: 0.0
                        val max = dishes.maxOfOrNull { it.price } ?: 0.0
                        "$${min.toInt()} - $${max.toInt()}"
                    } ?: "Price N/A"

                tvPrice.text = avgPrice

                val avgDeliveryTime = restaurant.menu.flatMap { it.dishes }
                    .takeIf { it.isNotEmpty() }
                    ?.let { dishes ->
                        val avgTime = dishes.map { it.deliveryTime }.average().toInt()
                        "$avgTime min"
                    } ?: "Time N/A"

                tvDeliveryTime.text = avgDeliveryTime

                Glide.with(root.context)
                    .load(restaurant.mainImage)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_foreground) //CHANGE
                    .error(R.drawable.ic_launcher_foreground) // CHANGE
                    .into(ivRestaurantImage)
            }
        }
    }

    private class RestaurantDiffCallback : DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }
    }
}