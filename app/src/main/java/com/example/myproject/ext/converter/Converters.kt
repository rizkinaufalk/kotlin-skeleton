package com.example.myproject.ext.converter

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.math.BigDecimal
import java.util.*

class Converters {private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun stringToIntList(data: String?): List<Int> {
        if (data.isNullOrEmpty()) {
            return emptyList()
        }

        val listType = Types.newParameterizedType(List::class.java, Int::class.javaObjectType)
        val adapter: JsonAdapter<List<Int>> = moshi.adapter(listType)
        return adapter.fromJson(data) ?: emptyList()
    }

    @TypeConverter
    fun intListToString(ints: List<Int>?): String? {
        if (ints.isNullOrEmpty()) {
            return null
        }

        val listType = Types.newParameterizedType(List::class.java, Int::class.javaObjectType)
        val adapter: JsonAdapter<List<Int>> = moshi.adapter(listType)
        return adapter.toJson(ints)
    }

    @TypeConverter
    fun stringToStringList(data: String?): List<String> {
        if (data.isNullOrEmpty()) {
            return emptyList()
        }

        val listType = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter: JsonAdapter<List<String>> = moshi.adapter(listType)
        return adapter.fromJson(data) ?: emptyList()
    }

    @TypeConverter
    fun stringListToString(string: List<String>?): String? {
        if (string.isNullOrEmpty()) {
            return null
        }

        val listType = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter: JsonAdapter<List<String>> = moshi.adapter(listType)
        return adapter.toJson(string)
    }

    @TypeConverter
    fun toDate(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun fromDate(value: Date?): Long? {
        return value?.time
    }

    @TypeConverter
    fun toBigDecimal(value: String?): BigDecimal? {
        return value?.let { BigDecimal(it) }
    }

    @TypeConverter
    fun fromBigDecimal(value: BigDecimal?): String? {
        return value?.toString()
    }
}

