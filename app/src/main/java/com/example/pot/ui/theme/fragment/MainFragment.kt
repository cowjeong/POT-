package com.example.pot.ui.theme.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pot.R

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        // User 아이콘 클릭 이벤트
        val userIcon = view.findViewById<ImageView>(R.id.imgUserIcon)
        userIcon.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_myPageFragment)
        }

        // 나머지 아이콘 클릭 이벤트는 변경 없음
        val exercisePot = view.findViewById<ImageView>(R.id.imgExercisePot)
        exercisePot.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_exerciseBoardFragment)
        }

        val taxiPot = view.findViewById<ImageView>(R.id.imgTaxiPot)
        taxiPot.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_taxiBoardFragment)
        }

        val studyPot = view.findViewById<ImageView>(R.id.imgStudyPot)
        studyPot.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_studyBoardFragment)
        }

        val mealPot = view.findViewById<ImageView>(R.id.imgMealPot)
        mealPot.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_mealBoardFragment)
        }

        val homeIcon = view.findViewById<ImageView>(R.id.imgHomeIcon)
        homeIcon.setOnClickListener {
            // 현재 MainFragment이므로 이동 없음
        }

        val boardIcon = view.findViewById<ImageView>(R.id.imgBoardIcon)
        boardIcon.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_boardFragment)
        }

        val chatIcon = view.findViewById<ImageView>(R.id.imgChatIcon)
        chatIcon.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_chatFragment)
        }

        return view
    }
}
