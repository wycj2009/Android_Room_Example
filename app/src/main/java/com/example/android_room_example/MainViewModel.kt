package com.example.android_room_example

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val productRepository: ProductRepository = ProductRepository(application)

    fun getProductList(): LiveData<List<Product>> = productRepository.productList

    fun insertProduct(product: Product) {
        productRepository.insertProducts(product)
    }

    fun deleteProductByName(name: String) {
        productRepository.deleteProductByName(name)
    }

}