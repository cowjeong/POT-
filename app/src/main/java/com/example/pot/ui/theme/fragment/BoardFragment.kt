package com.example.pot.ui.theme.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pot.R

class BoardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_board, container, false)

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
            // 현재 BoardFragment이므로 이동 없음
        }

        // Chat 아이콘 클릭 이벤트
        view.findViewById<ImageView>(R.id.imgChatIcon).setOnClickListener {
            findNavController().navigate(R.id.chatFragment)
        }

        return view
    }
}
