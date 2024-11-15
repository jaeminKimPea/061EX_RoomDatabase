package com.lion.a061ex_roomdatabase.fragment.student

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lion.a061ex_roomdatabase.vo.StudentVO
import com.lion.a061ex_roomdatabase.MainActivity
import com.lion.a061ex_roomdatabase.dao.StudentDatabase
import com.lion.a061ex_roomdatabase.util.ShowMenuItem
import com.lion.a061ex_roomdatabase.databinding.FragmentStudentShowBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class StudentShowFragment : Fragment() {

    lateinit var fragmentStudentShowBinding: FragmentStudentShowBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        fragmentStudentShowBinding = FragmentStudentShowBinding.inflate(inflater)

        // TextView 구성 메서드 호출
        settingTextView()

        settingfabMain()

        return fragmentStudentShowBinding.root
    }

    // TextView 구성
    private fun settingTextView(){
        fragmentStudentShowBinding.apply {
            // 학생 번호를 가져온다.
            val idx = arguments?.getInt("idx")!!
            // 데이터를 가져온다.
            val mainActivity = activity as MainActivity
            val studentDataBase = StudentDatabase.getInstance(mainActivity)
            CoroutineScope(Dispatchers.Main).launch {
                val work1 = async(Dispatchers.IO){
                    studentDataBase?.studentDAO()?.selectStudentDataOne(idx)
                }
                val studentVO = work1.await() as StudentVO
                // TextView에 값을 넣어준다.
                textViewShowName.text = studentVO.studentName
                textViewShowAge.text = studentVO.studentAge.toString()
                textViewShowType.text = studentVO.studentType.toString()
            }
        }
    }

    // FAB 구성

    private fun settingfabMain() {
        fragmentStudentShowBinding.apply {
            ShowRetouchToolbar.setOnMenuItemClickListener {
                val menuName = it.titleCondensed.toString()
                when( ShowMenuItem.valueOf(menuName)){
                    ShowMenuItem.SHOW_STUDENT_RETOUCH ->{
                        Log.d("st",ShowMenuItem.SHOW_STUDENT_RETOUCH.name)
                        true
                    }

                }
            }

        }
    }



}

