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

class MealBoardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_meal_board, container, false)

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
                putString("tableName", DatabaseHelper.TABLE_MEAL) // StudyNotes 테이블
                putInt("previousFragmentId", R.id.mealBoardFragment) // 현재(밥팟 게시판) Fragment ID 전달
            }
            findNavController().navigate(R.id.writeFragment, bundle)
        }

        return view
    }
}
