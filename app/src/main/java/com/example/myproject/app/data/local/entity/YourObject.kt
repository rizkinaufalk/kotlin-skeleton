package com.example.myproject.app.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.myproject.app.data.local.DBEntity
import com.example.myproject.ext.converter.Converters

@Entity(tableName = DBEntity.YOUR_DB)
@TypeConverters(Converters::class)
data class YourObject (
    @PrimaryKey
    @ColumnInfo
    val accNo: String,

    @ColumnInfo
    val accName: String,

    @ColumnInfo
    val productType: String,

    @ColumnInfo
    val cifCode: String,

    @ColumnInfo
    val userId: String,

    @ColumnInfo
    val clientName: String)
