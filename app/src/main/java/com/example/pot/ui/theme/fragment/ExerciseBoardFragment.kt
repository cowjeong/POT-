package com.example.pot.ui.theme.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pot.DatabaseHelper
import com.example.pot.R
import com.example.pot.DataAdapter
import androidx.recyclerview.widget.LinearLayoutManager

class ExerciseBoardFragment : Fragment() {

    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var adapter: DataAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_exercise_board, container, false)

        // 뒤로가기 버튼 클릭 이벤트 설정
        view.findViewById<ImageView>(R.id.imgBackIcon).setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }

        // Home 아이콘 클릭 이벤트
        view.findViewById<ImageView>(R.id.imgHomeIcon).setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }

        // Board 아이콘 클릭 이벤트
        view.findViewById<ImageView>(R.id.imgBoardIcon).setOnClickListener {
            findNavController().navigate(R.id.boardFragment)
        }

        // Chat 아이콘 클릭 이벤트
        view.findViewById<ImageView>(R.id.imgChatIcon).setOnClickListener {
            findNavController().navigate(R.id.chatFragment)
        }

        // 글작성 버튼 클릭 이벤트
        view.findViewById<ImageView>(R.id.writeButton).setOnClickListener {
            val bundle = Bundle().apply {
                putString("tableName", DatabaseHelper.TABLE_EXERCISE) // ExerciseNotes 테이블
                putInt("previousFragmentId", R.id.exerciseBoardFragment) // 현재(운동팟 게시판) Fragment ID 전달
            }
            findNavController().navigate(R.id.writeFragment, bundle)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databaseHelper = DatabaseHelper(requireContext()) // 데이터베이스 초기화
        adapter = DataAdapter() // 어댑터 초기화

        // RecyclerView 초기화
        val recyclerView = view.findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // 데이터 로드
        loadData()
    }

    private fun loadData() {
        val dataList = databaseHelper.getAllData(DatabaseHelper.TABLE_EXERCISE) // 테이블명 전달
        adapter.submitList(dataList) // 어댑터에 데이터 전달
    }
}
