package com.lion.a061ex_roomdatabase.fragment.student

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.lion.a061ex_roomdatabase.vo.StudentVO
import com.lion.a061ex_roomdatabase.MainActivity
import com.lion.a061ex_roomdatabase.dao.StudentDatabase
import com.lion.a061ex_roomdatabase.databinding.FragmentStudentInfoBinding
import com.lion.a061ex_roomdatabase.databinding.ItemStudentInfoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class StudentInfoFragment : Fragment() {

    lateinit var fragmentStudentInfoBinding: FragmentStudentInfoBinding
    // RecyclerView 구성을 위한 임시 데이터
//    val dataList = Array(50){
//        "항목 $it"
//    }

    // 데이터를 담을 리스트
    var dataList = mutableListOf<StudentVO>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        fragmentStudentInfoBinding = FragmentStudentInfoBinding.inflate(inflater)

        // RecyclerView 구성
        settingRecyclerViewMain()
        // FAB 구성
        settingfabMain()
        // 데이터를 읽어와 RecyclerView를 갱신한다
        refreshRecyclerView()

        return fragmentStudentInfoBinding.root
    }

    // RecyclerView  구성
    private fun settingRecyclerViewMain(){
        fragmentStudentInfoBinding.apply {
            // 어뎁터 셋팅
            recyclerViewMain.adapter = RecyclerViewMainAdapter()
            // 보여주는 형식
            recyclerViewMain.layoutManager = LinearLayoutManager(activity)
            // 구분선
            val deco = MaterialDividerItemDecoration(requireActivity(), MaterialDividerItemDecoration.VERTICAL)
            recyclerViewMain.addItemDecoration(deco)
        }
    }

    // FAB 구성
    private fun settingfabMain(){
        fragmentStudentInfoBinding.apply {
            fabMain.setOnClickListener {
                // InputFragment로 변경한다.
                val a1 = activity as MainActivity
                a1.replaceFragment(MainActivity.FragmentName.INPUT_FRAGMENT, true, null)
            }
        }
    }

    // 데이터베이스에서 데이터를 가져와 리스트 뷰를 구성하는 메서드
    fun refreshRecyclerView(){
        val mainActivity = activity as MainActivity
        val studentDataBase = StudentDatabase.getInstance(mainActivity)
        CoroutineScope(Dispatchers.Main).launch {
            val work1 = async(Dispatchers.IO){
                studentDataBase?.studentDAO()?.selectStudentDataAll()
            }
            dataList = work1.await() as MutableList<StudentVO>

            // recyclerView 갱신
            fragmentStudentInfoBinding.recyclerViewMain.adapter?.notifyDataSetChanged()
        }
    }

    // RecyclerView의 어뎁터 클래스
    inner class RecyclerViewMainAdapter : RecyclerView.Adapter<RecyclerViewMainAdapter.MainViewHolder>(){
        // ViewHolder
        inner class MainViewHolder(var itemStudentInfoBinding: ItemStudentInfoBinding) : RecyclerView.ViewHolder(itemStudentInfoBinding.root),
            OnClickListener {
            override fun onClick(v: View?) {
                // ShowFragment가 보이도록 한다.
                val a1 = activity as MainActivity
                // Fragment에게 전달할 데이터를 담을 Bundle 객체를 생성한다.
                val dataBundle = Bundle()
                // 데이터를 담는다
                // 사용자가 누른 학생의 idx 값
                dataBundle.putInt("idx", dataList[adapterPosition].studentIdx)
                a1.replaceFragment(MainActivity.FragmentName.SHOW_FRAGMENT, true, dataBundle)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val itemStudentInfoViewHolder = ItemStudentInfoBinding.inflate(layoutInflater)
            val mainViewHolder = MainViewHolder(itemStudentInfoViewHolder)

            itemStudentInfoViewHolder.root.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            itemStudentInfoViewHolder.root.setOnClickListener(mainViewHolder)

            return mainViewHolder
        }

        override fun getItemCount(): Int {
            return dataList.size
        }

        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            holder.itemStudentInfoBinding.textViewMainRow.text = dataList[position].studentName
        }
    }

}