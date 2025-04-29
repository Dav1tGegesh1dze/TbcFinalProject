package com.example.middlecourseproject.presentation.cart.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
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
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    override fun onViewRecycled(holder: CartViewHolder) {
        super.onViewRecycled(holder)
        holder.unbind()
    }

    inner class CartViewHolder(
        private val binding: ItemCartBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CartItem) {
            try {
                binding.apply {
                    tvItemName.text = item.name

                    val formatter = NumberFormat.getCurrencyInstance(Locale.US)
                    tvItemPrice.text = formatter.format(item.price)
                    tvItemSubtotal.text = formatter.format(item.subtotal)

                    tvQuantity.text = item.quantity.toString()

                    Glide.with(itemView.context.applicationContext)
                        .load(item.image)
                        .apply(RequestOptions()
                            .centerCrop()
                            .placeholder(R.drawable.ic_launcher_foreground)
                            .error(R.drawable.ic_launcher_foreground)
                            .dontAnimate()
                        )
                        .into(ivItemImage)

                    btnIncrease.setOnClickListener {
                        val position = bindingAdapterPosition
                        if (position != RecyclerView.NO_POSITION) {
                            onIncreaseQuantity(item.dishId)
                        }
                    }

                    btnDecrease.setOnClickListener {
                        val position = bindingAdapterPosition
                        if (position != RecyclerView.NO_POSITION) {
                            onDecreaseQuantity(item.dishId)
                        }
                    }

                    btnRemove.setOnClickListener {
                        val position = bindingAdapterPosition
                        if (position != RecyclerView.NO_POSITION) {
                            onRemoveItem(item.dishId)
                        }
                    }
                }
            } catch (e: Exception) {
                android.util.Log.e("CartAdapter", "Error binding item: ${e.message}", e)
            }
        }

        fun unbind() {
            try {
                Glide.with(itemView.context.applicationContext).clear(binding.ivItemImage)

                binding.btnIncrease.setOnClickListener(null)
                binding.btnDecrease.setOnClickListener(null)
                binding.btnRemove.setOnClickListener(null)
            } catch (e: Exception) {
                android.util.Log.e("CartAdapter", "Error unbinding item: ${e.message}", e)
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