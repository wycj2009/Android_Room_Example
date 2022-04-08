package com.example.android_room_example

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class Product(
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        val name: String? = null,
        val quantity: Int = 0
)