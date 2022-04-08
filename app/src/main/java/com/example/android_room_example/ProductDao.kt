package com.example.android_room_example

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    @Query("SELECT * FROM product")
    fun loadAll(): LiveData<List<Product>>

    @Insert
    fun insertAll(vararg products: Product)

    @Query("DELETE FROM product WHERE name = :name")
    fun deleteByName(name: String)

}