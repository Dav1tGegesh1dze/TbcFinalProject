package com.example.middlecourseproject.presentation.cart.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.ItemCartBinding
import com.example.middlecourseproject.domain.cart.CartItem

import java.text.NumberFormat
import java.util.Locale

class CartAdapter(
    private val onIncreaseQuantity: (String) -> Unit,
    private val onDecreaseQuantity: (String) -> Unit,
    private val onRemoveItem: (String) -> Unit
) : ListAdapter<CartItem, CartAdapter.CartViewHolder>(CartDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = ItemCartBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CartViewHolder(
        private val binding: ItemCartBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CartItem) {
            binding.apply {
                tvItemName.text = item.name

                val formatter = NumberFormat.getCurrencyInstance(Locale.US)
                tvItemPrice.text = formatter.format(item.price)
                tvItemSubtotal.text = formatter.format(item.subtotal)

                tvQuantity.text = item.quantity.toString()

                Glide.with(itemView.context)
                    .load(item.image)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(ivItemImage)

                btnIncrease.setOnClickListener {
                    onIncreaseQuantity(item.dishId)
                }

                btnDecrease.setOnClickListener {
                    onDecreaseQuantity(item.dishId)
                }

                btnRemove.setOnClickListener {
                    onRemoveItem(item.dishId)
                }
            }
        }
    }

    class CartDiffCallback : DiffUtil.ItemCallback<CartItem>() {
        override fun areItemsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
            return oldItem.dishId == newItem.dishId
        }

        override fun areContentsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
            return oldItem == newItem
        }
    }
}