package com.example.android_room_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.android_room_example.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.productList.adapter = ProductAdapter(emptyList(), {})

        viewModel.getProductList().observe(this) {
            (binding.productList.adapter as ProductAdapter).setItems(it)
        }

        binding.insertButton.setOnClickListener {
            val name = binding.productName.text.toString()
            val quantity = binding.productQuantity.text.toString()

            if (name.isNullOrEmpty() || quantity.isNullOrEmpty()) {
                Snackbar.make(binding.root, "Error", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewModel.insertProduct(
                    Product(
                            name = name,
                            quantity = quantity.toInt()
                    )
            )
            clearFields()
        }

        binding.deleteButton.setOnClickListener {
            val name = binding.productName.text.toString()

            if (name.isNullOrEmpty()) {
                Snackbar.make(binding.root, "Error", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewModel.deleteProductByName(name)
            clearFields()
        }
    }

    private fun clearFields() {
        binding.productName.setText("")
        binding.productQuantity.setText("")
    }

}