package com.lion.a061ex_roomdatabase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lion.a061ex_roomdatabase.vo.StudentVO

@Dao
interface StudentDAO {
    // 학생 정보 저장
    @Insert
    fun insertStudentData(studentEntity: StudentVO)

    // 학생의 모든 정보를 가져온다.
    @Query("select * from StudentTable")
    fun selectStudentDataAll() : List<StudentVO>

    // 특정 학생의 정보를 가져온다.
    @Query("select * from StudentTable where studentIdx = :studentIdx")
    fun selectStudentDataOne(studentIdx:Int) : StudentVO
}