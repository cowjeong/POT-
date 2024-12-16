package com.example.pot.ui.theme.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.pot.DatabaseHelper
import com.example.pot.R

class WriteFragment : Fragment() {
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var editText: EditText
    private lateinit var saveButton: ImageView
    private lateinit var backIcon: ImageView
    private var tableName: String = DatabaseHelper.TABLE_EXERCISE // 기본값
    private var previousFragmentId: Int = R.id.exerciseBoardFragment // 기본값

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            tableName = it.getString("tableName", DatabaseHelper.TABLE_EXERCISE)
            previousFragmentId = it.getInt("previousFragmentId", R.id.exerciseBoardFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_write, container, false)

        databaseHelper = DatabaseHelper(requireContext())
        editText = view.findViewById(R.id.editText)
        saveButton = view.findViewById(R.id.saveButton)
        backIcon = view.findViewById(R.id.backIcon)

        saveButton.setOnClickListener {
            val inputText = editText.text.toString().trim()
            if (inputText.isNotEmpty()) {
                val isSaved = databaseHelper.insertData(inputText, tableName)
                if (isSaved) {
                    Toast.makeText(requireContext(), "저장 완료!", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(previousFragmentId) // 이전 화면으로 이동
                } else {
                    Toast.makeText(requireContext(), "저장 실패!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "내용을 입력하세요!", Toast.LENGTH_SHORT).show()
            }
        }

        backIcon.setOnClickListener {
            findNavController().navigate(previousFragmentId) // 이전 화면으로 이동
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        databaseHelper.close()
    }
}
