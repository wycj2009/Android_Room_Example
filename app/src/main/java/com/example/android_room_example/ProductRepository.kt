package com.example.android_room_example

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductRepository(application: Application) {

    private val dao = ProductDatabase.getInstance(application).productDao()

    val productList: LiveData<List<Product>> = dao.loadAll()

    fun insertProducts(vararg products: Product) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertAll(*products)
        }
    }

    fun deleteProductByName(name: String) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteByName(name)
        }
    }

}