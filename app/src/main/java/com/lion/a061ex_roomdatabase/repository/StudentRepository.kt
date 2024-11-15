package com.lion.a061ex_roomdatabase.repository

import android.content.Context
import com.lion.a061ex_roomdatabase.dao.StudentDatabase
import com.lion.a061ex_roomdatabase.util.StudentType
import com.lion.a061ex_roomdatabase.viewmodel.StudentViewModel
import com.lion.a061ex_roomdatabase.vo.StudentVO

class StudentRepository {

//    companion object{
//
//        // 학생 정보를 저장하는 메서드
//        fun insertStudentInfo(context: Context, studentViewModel: StudentViewModel){
//            // 데이터베이스 객체를 가져온다.
//            val studentDatabase = StudentDatabase.getInstance(context)
//            // ViewModel에 있는 데이터를 VO에 담아준다.
//            val studentType = studentViewModel.studentType.number
//            val studentName = studentViewModel.studentName
//            val studentAge = studentViewModel.studentAge
//
//            val studentVO = StudentVO(studentType, studentName, studentAge)
//
//            studentDatabase?.studentDAO()?.insertStudentData(studentVO)
//        }
//
//        // 학생 정보 전체를 가져오는 메서드
//        fun selectStudentInfoAll(context: Context) : MutableList<StudentViewModel>{
//            // 데이터 베이스 객체
//            val studentDatabase = StudentDatabase.getInstance(context)
//            // 학생 데이터 전체를 가져온다
//            val studentVoList = studentDatabase?.studentDAO()?.selectStudentDataAll()
//            // 학생 데이터를 담을 리스트
//            val studentViewModelList = mutableListOf<StudentViewModel>()
//            // 학생의 수 만큼 반복한다.
//            studentVoList?.forEach {
//                // 학생 데이터를 추출한다.
//                val studentType = when(it.studentType){
//                    StudentType.STUDENT_TYPE_BASEBALL.number -> StudentType.STUDENT_TYPE_BASEBALL
//                    StudentType.STUDENT_TYPE_BASKETBALL.number -> StudentType.STUDENT_TYPE_BASKETBALL
//                    else -> StudentType.STUDENT_TYPE_SOCCER
//                }
//                val studentName = it.studentName
//                val studentAge = it.studentAge
//                val studentIdx = it.studentIdx
//                // 객체에 담는다.
//                val studentViewModel = StudentViewModel(studentIdx, studentType, studentName, studentAge)
//                // 리스트에 담는다.
//                studentViewModelList.add(studentViewModel)
//            }
//            return studentViewModelList
//        }
//
//        fun selectStudentInfoByStudentIdx(context: Context, studentIdx:Int) : StudentViewModel{
//            val studentDatabase = StudentDatabase.getInstance(context)
//            // 학생 한명의 정보를 가져온다.
//            val studentVO = studentDatabase?.studentDAO()?.selectStudentDataOne(studentIdx)
//            // 학생 객체에 담는다
//            val studentType = when(studentVO?.studentType){
//                StudentType.STUDENT_TYPE_BASEBALL.number -> StudentType.STUDENT_TYPE_BASEBALL
//                StudentType.STUDENT_TYPE_BASKETBALL.number -> StudentType.STUDENT_TYPE_BASKETBALL
//                else -> StudentType.STUDENT_TYPE_SOCCER
//            }
//            val studentName = studentVO?.studentName
//            val studentAge = studentVO?.studentAge
//
//            val studentViewModel = StudentViewModel(studentIdx, studentType, studentName!!, studentAge!!)
//
//            return studentViewModel
//        }
//
//        // 학생 정보 삭제
//        fun deleteStudentInfoByStudentIdx(context: Context, studentIdx: Int){
//            val studentDatabase = StudentDatabase.getInstance(context)
//            // 삭제할 학생 번호를 담고 있을 객체를 생성한다.
//            val studentVO = StudentVO(studentIdx = studentIdx)
//            // 삭제한다
//            studentDatabase?.studentDAO()?.deleteStudentData(studentVO)
//        }
//
//        // 학생 정보를 수정하는 메서드
//        fun updateStudentInfo(context: Context, studentViewModel: StudentViewModel){
//            val studentDatabase = StudentDatabase.getInstance(context)
//            // VO에 객체에 담아준다
//            val studentType = studentViewModel.studentType.number
//            val studentName = studentViewModel.studentName
//            val studentAge = studentViewModel.studentAge
//            val studentVO = StudentVO(studentName, studentType, studentAge)
//            studentVO.studentIdx = studentViewModel.studentIdx
//            // 수정한다.
//            studentDatabase?.studentDAO()?.updateStudentData(studentVO)
//        }
//    }
}