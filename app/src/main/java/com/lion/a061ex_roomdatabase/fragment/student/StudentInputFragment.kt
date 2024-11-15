package com.lion.a061ex_roomdatabase.fragment.student

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lion.a061ex_roomdatabase.vo.StudentVO
import com.lion.a061ex_roomdatabase.MainActivity
import com.lion.a061ex_roomdatabase.MainActivity.FragmentName
import com.lion.a061ex_roomdatabase.dao.StudentDatabase
import com.lion.a061ex_roomdatabase.databinding.FragmentStudentInputBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class StudentInputFragment : Fragment() {

    lateinit var fragmentStudentInputBinding: FragmentStudentInputBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentStudentInputBinding = FragmentStudentInputBinding.inflate(inflater)

        // 입력 완료 버튼
        settingButtonInputSubmit()
        // 입력 요소
        settingTextFieldInput()

        return fragmentStudentInputBinding.root
    }

    // 입력 완료 버튼
    private fun settingButtonInputSubmit(){
        fragmentStudentInputBinding.apply {
            buttonInputSubmit.setOnClickListener {
                inputDone()
            }
        }
    }

    // 입력 요소 셋팅
    private fun settingTextFieldInput(){
        fragmentStudentInputBinding.apply {
            // 마지막 입력 요소에서 Enter를 눌렀을 경우
            textFieldInputAge.editText?.setOnEditorActionListener { v, actionId, event ->
                inputDone()
                false
            }
        }
    }

    // 입력 완료 처리 메서드
    private fun inputDone(){
        fragmentStudentInputBinding.apply {
            // 입력한 데이터를 가져온다.
            val name = textFieldInputName.editText?.text.toString()
            val age = textFieldInputAge.editText?.text.toString().toInt()
            val type = textFieldInputAge.editText?.text.toString()
            // 객체에 담는다
            val studentVO = StudentVO(type.toInt(), name, age)
            // 데이터베이스에 저장한다.
            val a1 = activity as MainActivity
            val studentDataBase = StudentDatabase.getInstance(a1)
            CoroutineScope(Dispatchers.Main).launch {
                async(Dispatchers.IO){
                    studentDataBase?.studentDAO()?.insertStudentData(studentVO)
                }
                // 이전으로 돌아간다.
                a1.removeFragment(FragmentName.INPUT_FRAGMENT)
            }
        }
    }
}