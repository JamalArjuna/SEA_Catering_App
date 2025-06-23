package com.example.seacatering.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.seacatering.R
import com.google.android.material.bottomsheet.BottomSheetDialog

class MenuFragment : Fragment() {

    lateinit var buttonSeeMore1: Button
    lateinit var buttonSeeMore2: Button
    lateinit var buttonSeeMore3: Button

    fun initComponents(view: View) {
        buttonSeeMore1 = view.findViewById(R.id.button_detail1)
        buttonSeeMore2 = view.findViewById(R.id.button_detail2)
        buttonSeeMore3 = view.findViewById(R.id.button_detail3)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initComponents(view)

        buttonSeeMore1.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.meal_plan_detail1_bottomsheet, null)
            val dialog = BottomSheetDialog(requireContext())
            dialog.setContentView(dialogView)
            dialog.show()
        }
        buttonSeeMore2.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.meal_plan_detail2_bottomsheet, null)
            val dialog = BottomSheetDialog(requireContext())
            dialog.setContentView(dialogView)
            dialog.show()
        }
        buttonSeeMore3.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.meal_plan_detail3_bottomsheet, null)
            val dialog = BottomSheetDialog(requireContext())
            dialog.setContentView(dialogView)
            dialog.show()
        }
    }
}


