package com.test.pos.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.test.pos.entity.Register

@Dao
interface RegisterDAO {
    @Query("SELECT * FROM tbl_register")
    fun getRegister(): List<Register>

    @Insert
    fun insertUser(vararg users: Register)

    @Query("DELETE FROM tbl_register")
    suspend fun deleteAll()
}