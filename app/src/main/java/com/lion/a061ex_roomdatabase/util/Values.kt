package com.lion.a061ex_roomdatabase.util

import com.lion.a061ex_roomdatabase.R


enum class ShowMenuItem(val id: Int){
    SHOW_STUDENT_RETOUCH(R.id.inputStudentAdd)
}



// 프래그먼트를 나타내는 값
enum class FragmentName(var number:Int, var str:String){
    // 첫 화면
    MAIN_FRAGMENT(1, "MainFragment"),
    // 입력 화면
    INPUT_FRAGMENT(2, "InputFragment"),
    // 출력 화면
    SHOW_FRAGMENT(3, "ShowFragment"),
    // 수정 화면
    MODIFY_FRAGMENT(4, "ModifyFragment"),
}

// 운동부 타입을 나타내는 값
enum class StudentType(var number:Int, var str:String){
    // 야구부
    STUDENT_TYPE_BASEBALL(1, "야구부"),
    // 농구부
    STUDENT_TYPE_BASKETBALL(2, "농구부"),
    // 축구부
    STUDENT_TYPE_SOCCER(3, "축구부")
}
