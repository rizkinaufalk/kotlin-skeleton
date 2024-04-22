package com.example.myproject.app.data.local.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myproject.app.data.local.entity.YourObject
import com.example.myproject.app.data.local.DBEntity

@Dao
interface IYourDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccount(accountObject: YourObject)
    @Query("SELECT accName FROM ${DBEntity.YOUR_DB} WHERE accNo = :accNo")
    suspend fun getAccName(accNo: String): String
    @Query("SELECT * FROM ${DBEntity.YOUR_DB} WHERE accNo = :accNo")
    suspend fun getAccountInfo(accNo: String): YourObject
    @Query("SELECT * FROM ${DBEntity.YOUR_DB}")
    suspend fun getAllAccount(): List<YourObject>
}