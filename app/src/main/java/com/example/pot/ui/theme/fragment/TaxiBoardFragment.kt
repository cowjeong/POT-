package com.example.pot.ui.theme.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pot.DatabaseHelper
import com.example.pot.DataAdapter
import com.example.pot.R

class TaxiBoardFragment : Fragment() {

    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var adapter: DataAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_taxi_board, container, false)

        databaseHelper = DatabaseHelper(requireContext()) // DatabaseHelper 초기화
        adapter = DataAdapter() // RecyclerView 어댑터 초기화

        // RecyclerView 초기화
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

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
                putString("tableName", DatabaseHelper.TABLE_TAXI) // TaxiNotes 테이블 전달
                putInt("previousFragmentId", R.id.taxiBoardFragment) // 현재(택시팟 게시판) Fragment ID 전달
            }
            findNavController().navigate(R.id.writeFragment, bundle)
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        loadData() // 화면에 다시 나타날 때 데이터 갱신
    }

    private fun loadData() {
        val dataList = databaseHelper.getAllData(DatabaseHelper.TABLE_TAXI)
        adapter.submitList(dataList)
    }
}
