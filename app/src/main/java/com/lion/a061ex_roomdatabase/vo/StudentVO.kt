package com.lion.a061ex_roomdatabase.vo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("StudentTable")
data class StudentVO(
    val studentType:Int,
    val studentName:String,
    val studentAge:Int
){
    @PrimaryKey(autoGenerate = true) var studentIdx:Int = 0
}