package com.example.pot.ui.theme.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pot.R

class MyPageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_page, container, false)

        // 뒤로가기 버튼 클릭 이벤트
        val backIcon = view.findViewById<ImageView>(R.id.imgBackIcon)
        backIcon.setOnClickListener {
            findNavController().navigateUp() // 이전 Fragment(MainFragment)로 이동
        }

        // Home 아이콘 클릭 이벤트
        val homeIcon = view.findViewById<ImageView>(R.id.imgHomeIcon)
        homeIcon.setOnClickListener {
            findNavController().navigate(R.id.mainFragment) // MainFragment로 이동
        }

        // Board 아이콘 클릭 이벤트
        val boardIcon = view.findViewById<ImageView>(R.id.imgBoardIcon)
        boardIcon.setOnClickListener {
            findNavController().navigate(R.id.boardFragment) // BoardFragment로 이동
        }

        // Chat 아이콘 클릭 이벤트
        val chatIcon = view.findViewById<ImageView>(R.id.imgChatIcon)
        chatIcon.setOnClickListener {
            findNavController().navigate(R.id.chatFragment) // ChatFragment로 이동
        }

        return view
    }
}
