package com.lion.a061ex_roomdatabase.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lion.a061ex_roomdatabase.vo.StudentVO

@Database(entities = [StudentVO::class], version = 1, exportSchema = true)
abstract class StudentDatabase : RoomDatabase() {
    // dao
    abstract fun studentDAO() : StudentDAO

    companion object{
        // 데이터 베이스 객체를 담을 변수
        var studentDatabase: StudentDatabase? = null
        @Synchronized
        fun getInstance(context: Context) : StudentDatabase?{
            // 만약 데이터베이스 객체가 null이라면 객체를 생성한다.
            synchronized(StudentDatabase::class){
                studentDatabase = Room.databaseBuilder(
                    context.applicationContext, StudentDatabase::class.java,
                    "Student.db"
                ).build()
            }
            return studentDatabase
        }

        // 데이터 베이스 객체가 소멸될 때 호출되는 메서드
        fun destroyInstance(){
            studentDatabase = null
        }
    }

}