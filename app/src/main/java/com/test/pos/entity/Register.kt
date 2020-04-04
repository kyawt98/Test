package com.test.pos.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_register")
data class Register(
 @PrimaryKey val register_id:String,

 @ColumnInfo (name = "firstname") val firstname:String,
 @ColumnInfo(name = "lastname") val lastname:String,
 @ColumnInfo(name = "username") val username:String,
 @ColumnInfo(name = "password") val password:String
)