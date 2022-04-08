package com.example.android_room_example

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_room_example.databinding.ItemProductBinding

class ProductAdapter(private var items: List<Product>, private val clickCallback: (name: String?) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PersonViewHolder).bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(items: List<Product>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class PersonViewHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                clickCallback.invoke(items[adapterPosition].name)
            }
        }

        fun bind(item: Product) {
            binding.id.text = item.id.toString()
            binding.name.text = item.name
            binding.quantity.text = item.quantity.toString()
        }

    }

}