package com.lavita.menofeme.view.ui.questionarios

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.lavita.menofeme.R
import com.lavita.menofeme.view.ui.home.HomeFragment
import java.text.SimpleDateFormat
import java.util.*

class MauqFragment : Fragment() {
    private lateinit var pegarView: View
    private val db = FirebaseFirestore.getInstance()
    private lateinit var btnAnalise: androidx.appcompat.widget.AppCompatButton
    private lateinit var rdgQ2Q1: RadioGroup
    private lateinit var rdgQ2Q2: RadioGroup
    private lateinit var rdgQ2Q3: RadioGroup
    private lateinit var rdgQ2Q4: RadioGroup
    private lateinit var rdgQ2Q5: RadioGroup
    private lateinit var rdgQ2Q6: RadioGroup
    private lateinit var rdgQ2Q7: RadioGroup
    private lateinit var rdgQ2Q8: RadioGroup
    private lateinit var rdgQ2Q9: RadioGroup
    private lateinit var rdgQ2Q10: RadioGroup
    private lateinit var rdgQ2Q11: RadioGroup
    private lateinit var rdgQ2Q12: RadioGroup
    private lateinit var rdgQ2Q13: RadioGroup
    private lateinit var rdgQ2Q14: RadioGroup
    private lateinit var rdgQ2Q15: RadioGroup
    private lateinit var rdgQ2Q16: RadioGroup
    private lateinit var rdgQ2Q17: RadioGroup
    private lateinit var rdgQ2Q18: RadioGroup
    private lateinit var Q2Q1opt1: RadioButton
    private lateinit var Q2Q1opt2: RadioButton
    private lateinit var Q2Q1opt3: RadioButton
    private lateinit var Q2Q1opt4: RadioButton
    private lateinit var Q2Q1opt5: RadioButton
    private lateinit var Q2Q1opt6: RadioButton
    private lateinit var Q2Q1opt7: RadioButton
    private lateinit var Q2Q2opt1: RadioButton
    private lateinit var Q2Q2opt2: RadioButton
    private lateinit var Q2Q2opt3: RadioButton
    private lateinit var Q2Q2opt4: RadioButton
    private lateinit var Q2Q2opt5: RadioButton
    private lateinit var Q2Q2opt6: RadioButton
    private lateinit var Q2Q2opt7: RadioButton
    private lateinit var Q2Q3opt1: RadioButton
    private lateinit var Q2Q3opt2: RadioButton
    private lateinit var Q2Q3opt3: RadioButton
    private lateinit var Q2Q3opt4: RadioButton
    private lateinit var Q2Q3opt5: RadioButton
    private lateinit var Q2Q3opt6: RadioButton
    private lateinit var Q2Q3opt7: RadioButton
    private lateinit var Q2Q4opt1: RadioButton
    private lateinit var Q2Q4opt2: RadioButton
    private lateinit var Q2Q4opt3: RadioButton
    private lateinit var Q2Q4opt4: RadioButton
    private lateinit var Q2Q4opt5: RadioButton
    private lateinit var Q2Q4opt6: RadioButton
    private lateinit var Q2Q4opt7: RadioButton
    private lateinit var Q2Q5opt1: RadioButton
    private lateinit var Q2Q5opt2: RadioButton
    private lateinit var Q2Q5opt3: RadioButton
    private lateinit var Q2Q5opt4: RadioButton
    private lateinit var Q2Q5opt5: RadioButton
    private lateinit var Q2Q5opt6: RadioButton
    private lateinit var Q2Q5opt7: RadioButton
    private lateinit var Q2Q6opt1: RadioButton
    private lateinit var Q2Q6opt2: RadioButton
    private lateinit var Q2Q6opt3: RadioButton
    private lateinit var Q2Q6opt4: RadioButton
    private lateinit var Q2Q6opt5: RadioButton
    private lateinit var Q2Q6opt6: RadioButton
    private lateinit var Q2Q6opt7: RadioButton
    private lateinit var Q2Q7opt1: RadioButton
    private lateinit var Q2Q7opt2: RadioButton
    private lateinit var Q2Q7opt3: RadioButton
    private lateinit var Q2Q7opt4: RadioButton
    private lateinit var Q2Q7opt5: RadioButton
    private lateinit var Q2Q7opt6: RadioButton
    private lateinit var Q2Q7opt7: RadioButton
    private lateinit var Q2Q8opt1: RadioButton
    private lateinit var Q2Q8opt2: RadioButton
    private lateinit var Q2Q8opt3: RadioButton
    private lateinit var Q2Q8opt4: RadioButton
    private lateinit var Q2Q8opt5: RadioButton
    private lateinit var Q2Q8opt6: RadioButton
    private lateinit var Q2Q8opt7: RadioButton
    private lateinit var Q2Q9opt1: RadioButton
    private lateinit var Q2Q9opt2: RadioButton
    private lateinit var Q2Q9opt3: RadioButton
    private lateinit var Q2Q9opt4: RadioButton
    private lateinit var Q2Q9opt5: RadioButton
    private lateinit var Q2Q9opt6: RadioButton
    private lateinit var Q2Q9opt7: RadioButton
    private lateinit var Q2Q10opt1: RadioButton
    private lateinit var Q2Q10opt2: RadioButton
    private lateinit var Q2Q10opt3: RadioButton
    private lateinit var Q2Q10opt4: RadioButton
    private lateinit var Q2Q10opt5: RadioButton
    private lateinit var Q2Q10opt6: RadioButton
    private lateinit var Q2Q10opt7: RadioButton
    private lateinit var Q2Q11opt1: RadioButton
    private lateinit var Q2Q11opt2: RadioButton
    private lateinit var Q2Q11opt3: RadioButton
    private lateinit var Q2Q11opt4: RadioButton
    private lateinit var Q2Q11opt5: RadioButton
    private lateinit var Q2Q11opt6: RadioButton
    private lateinit var Q2Q11opt7: RadioButton
    private lateinit var Q2Q12opt1: RadioButton
    private lateinit var Q2Q12opt2: RadioButton
    private lateinit var Q2Q12opt3: RadioButton
    private lateinit var Q2Q12opt4: RadioButton
    private lateinit var Q2Q12opt5: RadioButton
    private lateinit var Q2Q12opt6: RadioButton
    private lateinit var Q2Q12opt7: RadioButton
    private lateinit var Q2Q13opt1: RadioButton
    private lateinit var Q2Q13opt2: RadioButton
    private lateinit var Q2Q13opt3: RadioButton
    private lateinit var Q2Q13opt4: RadioButton
    private lateinit var Q2Q13opt5: RadioButton
    private lateinit var Q2Q13opt6: RadioButton
    private lateinit var Q2Q13opt7: RadioButton
    private lateinit var Q2Q14opt1: RadioButton
    private lateinit var Q2Q14opt2: RadioButton
    private lateinit var Q2Q14opt3: RadioButton
    private lateinit var Q2Q14opt4: RadioButton
    private lateinit var Q2Q14opt5: RadioButton
    private lateinit var Q2Q14opt6: RadioButton
    private lateinit var Q2Q14opt7: RadioButton
    private lateinit var Q2Q15opt1: RadioButton
    private lateinit var Q2Q15opt2: RadioButton
    private lateinit var Q2Q15opt3: RadioButton
    private lateinit var Q2Q15opt4: RadioButton
    private lateinit var Q2Q15opt5: RadioButton
    private lateinit var Q2Q15opt6: RadioButton
    private lateinit var Q2Q15opt7: RadioButton
    private lateinit var Q2Q16opt1: RadioButton
    private lateinit var Q2Q16opt2: RadioButton
    private lateinit var Q2Q16opt3: RadioButton
    private lateinit var Q2Q16opt4: RadioButton
    private lateinit var Q2Q16opt5: RadioButton
    private lateinit var Q2Q16opt6: RadioButton
    private lateinit var Q2Q16opt7: RadioButton
    private lateinit var Q2Q17opt1: RadioButton
    private lateinit var Q2Q17opt2: RadioButton
    private lateinit var Q2Q17opt3: RadioButton
    private lateinit var Q2Q17opt4: RadioButton
    private lateinit var Q2Q17opt5: RadioButton
    private lateinit var Q2Q17opt6: RadioButton
    private lateinit var Q2Q17opt7: RadioButton
    private lateinit var Q2Q18opt1: RadioButton
    private lateinit var Q2Q18opt2: RadioButton
    private lateinit var Q2Q18opt3: RadioButton
    private lateinit var Q2Q18opt4: RadioButton
    private lateinit var Q2Q18opt5: RadioButton
    private lateinit var Q2Q18opt6: RadioButton
    private lateinit var Q2Q18opt7: RadioButton
    private lateinit var homeFragment: HomeFragment

    private var RespQ2Q1: Int = 9
    private var RespQ2Q2: Int = 9
    private var RespQ2Q3: Int = 9
    private var RespQ2Q4: Int = 9
    private var RespQ2Q5: Int = 9
    private var RespQ2Q6: Int = 9
    private var RespQ2Q7: Int = 9
    private var RespQ2Q8: Int = 9
    private var RespQ2Q9: Int = 9
    private var RespQ2Q10: Int = 9
    private var RespQ2Q11: Int = 9
    private var RespQ2Q12: Int = 9
    private var RespQ2Q13: Int = 9
    private var RespQ2Q14: Int = 9
    private var RespQ2Q15: Int = 9
    private var RespQ2Q16: Int = 9
    private var RespQ2Q17: Int = 9
    private var RespQ2Q18: Int = 9
    private var valorQ2Q1: Int = 9
    private var valorQ2Q2: Int = 9
    private var valorQ2Q3: Int = 9
    private var valorQ2Q4: Int = 9
    private var valorQ2Q5: Int = 9
    private var valorQ2Q6: Int = 9
    private var valorQ2Q7: Int = 9
    private var valorQ2Q8: Int = 9
    private var valorQ2Q9: Int = 9
    private var valorQ2Q10: Int = 9
    private var valorQ2Q11: Int = 9
    private var valorQ2Q12: Int = 9
    private var valorQ2Q13: Int = 9
    private var valorQ2Q14: Int = 9
    private var valorQ2Q15: Int = 9
    private var valorQ2Q16: Int = 9
    private var valorQ2Q17: Int = 9
    private var valorQ2Q18: Int = 9


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        pegarView = inflater.inflate(R.layout.fragment_mauq, container, false)
        btnAnalise = pegarView.findViewById(R.id.btnAnaliseMauQ)
        rdgQ2Q1 = pegarView.findViewById(R.id.rdgQ2Q1)
        rdgQ2Q2 = pegarView.findViewById(R.id.rdgQ2Q2)
        rdgQ2Q3 = pegarView.findViewById(R.id.rdgQ2Q3)
        rdgQ2Q4 = pegarView.findViewById(R.id.rdgQ2Q4)
        rdgQ2Q5 = pegarView.findViewById(R.id.rdgQ2Q5)
        rdgQ2Q6 = pegarView.findViewById(R.id.rdgQ2Q6)
        rdgQ2Q7 = pegarView.findViewById(R.id.rdgQ2Q7)
        rdgQ2Q8 = pegarView.findViewById(R.id.rdgQ2Q8)
        rdgQ2Q9 = pegarView.findViewById(R.id.rdgQ2Q9)
        rdgQ2Q10 = pegarView.findViewById(R.id.rdgQ2Q10)
        rdgQ2Q11 = pegarView.findViewById(R.id.rdgQ2Q11)
        rdgQ2Q12 = pegarView.findViewById(R.id.rdgQ2Q12)
        rdgQ2Q13 = pegarView.findViewById(R.id.rdgQ2Q13)
        rdgQ2Q14 = pegarView.findViewById(R.id.rdgQ2Q14)
        rdgQ2Q15 = pegarView.findViewById(R.id.rdgQ2Q15)
        rdgQ2Q16 = pegarView.findViewById(R.id.rdgQ2Q16)
        rdgQ2Q17 = pegarView.findViewById(R.id.rdgQ2Q17)
        rdgQ2Q18 = pegarView.findViewById(R.id.rdgQ2Q18)
        Q2Q1opt1 = pegarView.findViewById(R.id.Q2Q1opt1)
        Q2Q1opt2 = pegarView.findViewById(R.id.Q2Q1opt2)
        Q2Q1opt3 = pegarView.findViewById(R.id.Q2Q1opt3)
        Q2Q1opt4 = pegarView.findViewById(R.id.Q2Q1opt4)
        Q2Q1opt5 = pegarView.findViewById(R.id.Q2Q1opt5)
        Q2Q1opt6 = pegarView.findViewById(R.id.Q2Q1opt6)
        Q2Q1opt7 = pegarView.findViewById(R.id.Q2Q1opt7)
        Q2Q2opt1 = pegarView.findViewById(R.id.Q2Q2opt1)
        Q2Q2opt2 = pegarView.findViewById(R.id.Q2Q2opt2)
        Q2Q2opt3 = pegarView.findViewById(R.id.Q2Q2opt3)
        Q2Q2opt4 = pegarView.findViewById(R.id.Q2Q2opt4)
        Q2Q2opt5 = pegarView.findViewById(R.id.Q2Q2opt5)
        Q2Q2opt6 = pegarView.findViewById(R.id.Q2Q2opt6)
        Q2Q2opt7 = pegarView.findViewById(R.id.Q2Q2opt7)
        Q2Q3opt1 = pegarView.findViewById(R.id.Q2Q3opt1)
        Q2Q3opt2 = pegarView.findViewById(R.id.Q2Q3opt2)
        Q2Q3opt3 = pegarView.findViewById(R.id.Q2Q3opt3)
        Q2Q3opt4 = pegarView.findViewById(R.id.Q2Q3opt4)
        Q2Q3opt5 = pegarView.findViewById(R.id.Q2Q3opt5)
        Q2Q3opt6 = pegarView.findViewById(R.id.Q2Q3opt6)
        Q2Q3opt7 = pegarView.findViewById(R.id.Q2Q3opt7)
        Q2Q4opt1 = pegarView.findViewById(R.id.Q2Q4opt1)
        Q2Q4opt2 = pegarView.findViewById(R.id.Q2Q4opt2)
        Q2Q4opt3 = pegarView.findViewById(R.id.Q2Q4opt3)
        Q2Q4opt4 = pegarView.findViewById(R.id.Q2Q4opt4)
        Q2Q4opt5 = pegarView.findViewById(R.id.Q2Q4opt5)
        Q2Q4opt6 = pegarView.findViewById(R.id.Q2Q4opt6)
        Q2Q4opt7 = pegarView.findViewById(R.id.Q2Q4opt7)
        Q2Q5opt1 = pegarView.findViewById(R.id.Q2Q5opt1)
        Q2Q5opt2 = pegarView.findViewById(R.id.Q2Q5opt2)
        Q2Q5opt3 = pegarView.findViewById(R.id.Q2Q5opt3)
        Q2Q5opt4 = pegarView.findViewById(R.id.Q2Q5opt4)
        Q2Q5opt5 = pegarView.findViewById(R.id.Q2Q5opt5)
        Q2Q5opt6 = pegarView.findViewById(R.id.Q2Q5opt6)
        Q2Q5opt7 = pegarView.findViewById(R.id.Q2Q5opt7)
        Q2Q6opt1 = pegarView.findViewById(R.id.Q2Q6opt1)
        Q2Q6opt2 = pegarView.findViewById(R.id.Q2Q6opt2)
        Q2Q6opt3 = pegarView.findViewById(R.id.Q2Q6opt3)
        Q2Q6opt4 = pegarView.findViewById(R.id.Q2Q6opt4)
        Q2Q6opt5 = pegarView.findViewById(R.id.Q2Q6opt5)
        Q2Q6opt6 = pegarView.findViewById(R.id.Q2Q6opt6)
        Q2Q6opt7 = pegarView.findViewById(R.id.Q2Q6opt7)
        Q2Q7opt1 = pegarView.findViewById(R.id.Q2Q7opt1)
        Q2Q7opt2 = pegarView.findViewById(R.id.Q2Q7opt2)
        Q2Q7opt3 = pegarView.findViewById(R.id.Q2Q7opt3)
        Q2Q7opt4 = pegarView.findViewById(R.id.Q2Q7opt4)
        Q2Q7opt5 = pegarView.findViewById(R.id.Q2Q7opt5)
        Q2Q7opt6 = pegarView.findViewById(R.id.Q2Q7opt6)
        Q2Q7opt7 = pegarView.findViewById(R.id.Q2Q7opt7)
        Q2Q8opt1 = pegarView.findViewById(R.id.Q2Q8opt1)
        Q2Q8opt2 = pegarView.findViewById(R.id.Q2Q8opt2)
        Q2Q8opt3 = pegarView.findViewById(R.id.Q2Q8opt3)
        Q2Q8opt4 = pegarView.findViewById(R.id.Q2Q8opt4)
        Q2Q8opt5 = pegarView.findViewById(R.id.Q2Q8opt5)
        Q2Q8opt6 = pegarView.findViewById(R.id.Q2Q8opt6)
        Q2Q8opt7 = pegarView.findViewById(R.id.Q2Q8opt7)
        Q2Q9opt1 = pegarView.findViewById(R.id.Q2Q9opt1)
        Q2Q9opt2 = pegarView.findViewById(R.id.Q2Q9opt2)
        Q2Q9opt3 = pegarView.findViewById(R.id.Q2Q9opt3)
        Q2Q9opt4 = pegarView.findViewById(R.id.Q2Q9opt4)
        Q2Q9opt5 = pegarView.findViewById(R.id.Q2Q9opt5)
        Q2Q9opt6 = pegarView.findViewById(R.id.Q2Q9opt6)
        Q2Q9opt7 = pegarView.findViewById(R.id.Q2Q9opt7)
        Q2Q10opt1 = pegarView.findViewById(R.id.Q2Q10opt1)
        Q2Q10opt2 = pegarView.findViewById(R.id.Q2Q10opt2)
        Q2Q10opt3 = pegarView.findViewById(R.id.Q2Q10opt3)
        Q2Q10opt4 = pegarView.findViewById(R.id.Q2Q10opt4)
        Q2Q10opt5 = pegarView.findViewById(R.id.Q2Q10opt5)
        Q2Q10opt6 = pegarView.findViewById(R.id.Q2Q10opt6)
        Q2Q10opt7 = pegarView.findViewById(R.id.Q2Q10opt7)
        Q2Q11opt1 = pegarView.findViewById(R.id.Q2Q11opt1)
        Q2Q11opt2 = pegarView.findViewById(R.id.Q2Q11opt2)
        Q2Q11opt3 = pegarView.findViewById(R.id.Q2Q11opt3)
        Q2Q11opt4 = pegarView.findViewById(R.id.Q2Q11opt4)
        Q2Q11opt5 = pegarView.findViewById(R.id.Q2Q11opt5)
        Q2Q11opt6 = pegarView.findViewById(R.id.Q2Q11opt6)
        Q2Q11opt7 = pegarView.findViewById(R.id.Q2Q11opt7)
        Q2Q12opt1 = pegarView.findViewById(R.id.Q2Q12opt1)
        Q2Q12opt2 = pegarView.findViewById(R.id.Q2Q12opt2)
        Q2Q12opt3 = pegarView.findViewById(R.id.Q2Q12opt3)
        Q2Q12opt4 = pegarView.findViewById(R.id.Q2Q12opt4)
        Q2Q12opt5 = pegarView.findViewById(R.id.Q2Q12opt5)
        Q2Q12opt6 = pegarView.findViewById(R.id.Q2Q12opt6)
        Q2Q12opt7 = pegarView.findViewById(R.id.Q2Q12opt7)
        Q2Q13opt1 = pegarView.findViewById(R.id.Q2Q13opt1)
        Q2Q13opt2 = pegarView.findViewById(R.id.Q2Q13opt2)
        Q2Q13opt3 = pegarView.findViewById(R.id.Q2Q13opt3)
        Q2Q13opt4 = pegarView.findViewById(R.id.Q2Q13opt4)
        Q2Q13opt5 = pegarView.findViewById(R.id.Q2Q13opt5)
        Q2Q13opt6 = pegarView.findViewById(R.id.Q2Q13opt6)
        Q2Q13opt7 = pegarView.findViewById(R.id.Q2Q13opt7)
        Q2Q14opt1 = pegarView.findViewById(R.id.Q2Q14opt1)
        Q2Q14opt2 = pegarView.findViewById(R.id.Q2Q14opt2)
        Q2Q14opt3 = pegarView.findViewById(R.id.Q2Q14opt3)
        Q2Q14opt4 = pegarView.findViewById(R.id.Q2Q14opt4)
        Q2Q14opt5 = pegarView.findViewById(R.id.Q2Q14opt5)
        Q2Q14opt6 = pegarView.findViewById(R.id.Q2Q14opt6)
        Q2Q14opt7 = pegarView.findViewById(R.id.Q2Q14opt7)
        Q2Q15opt1 = pegarView.findViewById(R.id.Q2Q15opt1)
        Q2Q15opt2 = pegarView.findViewById(R.id.Q2Q15opt2)
        Q2Q15opt3 = pegarView.findViewById(R.id.Q2Q15opt3)
        Q2Q15opt4 = pegarView.findViewById(R.id.Q2Q15opt4)
        Q2Q15opt5 = pegarView.findViewById(R.id.Q2Q15opt5)
        Q2Q15opt6 = pegarView.findViewById(R.id.Q2Q15opt6)
        Q2Q15opt7 = pegarView.findViewById(R.id.Q2Q15opt7)
        Q2Q16opt1 = pegarView.findViewById(R.id.Q2Q16opt1)
        Q2Q16opt2 = pegarView.findViewById(R.id.Q2Q16opt2)
        Q2Q16opt3 = pegarView.findViewById(R.id.Q2Q16opt3)
        Q2Q16opt4 = pegarView.findViewById(R.id.Q2Q16opt4)
        Q2Q16opt5 = pegarView.findViewById(R.id.Q2Q16opt5)
        Q2Q16opt6 = pegarView.findViewById(R.id.Q2Q16opt6)
        Q2Q16opt7 = pegarView.findViewById(R.id.Q2Q16opt7)
        Q2Q17opt1 = pegarView.findViewById(R.id.Q2Q17opt1)
        Q2Q17opt2 = pegarView.findViewById(R.id.Q2Q17opt2)
        Q2Q17opt3 = pegarView.findViewById(R.id.Q2Q17opt3)
        Q2Q17opt4 = pegarView.findViewById(R.id.Q2Q17opt4)
        Q2Q17opt5 = pegarView.findViewById(R.id.Q2Q17opt5)
        Q2Q17opt6 = pegarView.findViewById(R.id.Q2Q17opt6)
        Q2Q17opt7 = pegarView.findViewById(R.id.Q2Q17opt7)
        Q2Q18opt1 = pegarView.findViewById(R.id.Q2Q18opt1)
        Q2Q18opt2 = pegarView.findViewById(R.id.Q2Q18opt2)
        Q2Q18opt3 = pegarView.findViewById(R.id.Q2Q18opt3)
        Q2Q18opt4 = pegarView.findViewById(R.id.Q2Q18opt4)
        Q2Q18opt5 = pegarView.findViewById(R.id.Q2Q18opt5)
        Q2Q18opt6 = pegarView.findViewById(R.id.Q2Q18opt6)
        Q2Q18opt7 = pegarView.findViewById(R.id.Q2Q18opt7)
        homeFragment = HomeFragment()

        setCheckedrdgQ2Q1()
        setCheckedrdgQ2Q2()
        setCheckedrdgQ2Q3()
        setCheckedrdgQ2Q4()
        setCheckedrdgQ2Q5()
        setCheckedrdgQ2Q6()
        setCheckedrdgQ2Q7()
        setCheckedrdgQ2Q8()
        setCheckedrdgQ2Q9()
        setCheckedrdgQ2Q10()
        setCheckedrdgQ2Q11()
        setCheckedrdgQ2Q12()
        setCheckedrdgQ2Q13()
        setCheckedrdgQ2Q14()
        setCheckedrdgQ2Q15()
        setCheckedrdgQ2Q16()
        setCheckedrdgQ2Q17()
        setCheckedrdgQ2Q18()

        btnAnalise.setOnClickListener {
            if (RespQ2Q1 == 9) {
                Toast.makeText(requireContext(), getString(R.string.txtQ1), Toast.LENGTH_SHORT)
                    .show()
            } else {
                valorQ2Q1 = RespQ2Q1
                if (RespQ2Q2 == 9) {
                    Toast.makeText(requireContext(), getString(R.string.txtQ2), Toast.LENGTH_SHORT)
                        .show()
                } else {
                    valorQ2Q2 = RespQ2Q2
                    if (RespQ2Q3 == 9) {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.txtQ3),
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        valorQ2Q3 = RespQ2Q3
                        if (RespQ2Q4 == 9) {
                            Toast.makeText(
                                requireContext(),
                                getString(R.string.txtQ4),
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            valorQ2Q4 = RespQ2Q4
                            if (RespQ2Q5 == 9) {
                                Toast.makeText(
                                    requireContext(),
                                    getString(R.string.txtQ5),
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                valorQ2Q5 = RespQ2Q5
                                if (RespQ2Q6 == 9) {
                                    Toast.makeText(
                                        requireContext(),
                                        getString(R.string.txtQ6),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    valorQ2Q6 = RespQ2Q6
                                    if (RespQ2Q7 == 9) {
                                        Toast.makeText(
                                            requireContext(),
                                            getString(R.string.txtQ7),
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    } else {
                                        valorQ2Q7 = RespQ2Q7
                                        if (RespQ2Q8 == 9) {
                                            Toast.makeText(
                                                requireContext(),
                                                getString(R.string.txtQ8),
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        } else {
                                            valorQ2Q8 = RespQ2Q8
                                            if (RespQ2Q9 == 9) {
                                                Toast.makeText(
                                                    requireContext(),
                                                    getString(R.string.txtQ9),
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            } else {
                                                valorQ2Q9 = RespQ2Q9
                                                if(RespQ2Q10 == 9){
                                                    Toast.makeText(requireContext(), getString(R.string.txtQ11), Toast.LENGTH_SHORT).show()
                                                }else {
                                                    valorQ2Q10 = RespQ2Q10
                                                    if (RespQ2Q11 == 9) {
                                                        Toast.makeText(
                                                            requireContext(),
                                                            getString(R.string.txtQ11),
                                                            Toast.LENGTH_SHORT
                                                        ).show()
                                                    }else {
                                                        valorQ2Q11 = RespQ2Q11
                                                        if (RespQ2Q12 == 9) {
                                                            Toast.makeText(
                                                                requireContext(),
                                                                getString(R.string.txtQ12),
                                                                Toast.LENGTH_SHORT
                                                            ).show()
                                                        } else {
                                                            valorQ2Q12 = RespQ2Q12
                                                            if (RespQ2Q13 == 9) {
                                                                Toast.makeText(
                                                                    requireContext(),
                                                                    getString(R.string.txtQ13),
                                                                    Toast.LENGTH_SHORT
                                                                ).show()
                                                            } else {
                                                                valorQ2Q13 = RespQ2Q13
                                                                if (RespQ2Q14 == 9) {
                                                                    Toast.makeText(
                                                                        requireContext(),
                                                                        getString(R.string.txtQ14),
                                                                        Toast.LENGTH_SHORT
                                                                    ).show()
                                                                } else {
                                                                    valorQ2Q14 = RespQ2Q14
                                                                    if (RespQ2Q15 == 9) {
                                                                        Toast.makeText(
                                                                            requireContext(),
                                                                            getString(R.string.txtQ15),
                                                                            Toast.LENGTH_SHORT
                                                                        ).show()
                                                                    } else {
                                                                        valorQ2Q15 = RespQ2Q15
                                                                        if (RespQ2Q16 == 9) {
                                                                            Toast.makeText(
                                                                                requireContext(),
                                                                                getString(R.string.txtQ16),
                                                                                Toast.LENGTH_SHORT
                                                                            ).show()
                                                                        } else {
                                                                            valorQ2Q16 = RespQ2Q16
                                                                            if (RespQ2Q17 == 9) {
                                                                                Toast.makeText(
                                                                                    requireContext(),
                                                                                    getString(R.string.txtQ17),
                                                                                    Toast.LENGTH_SHORT
                                                                                ).show()
                                                                            } else {
                                                                                valorQ2Q17 =
                                                                                    RespQ2Q17
                                                                                if (RespQ2Q18 == 9) {
                                                                                    Toast.makeText(
                                                                                        requireContext(),
                                                                                        getString(R.string.txtQ18),
                                                                                        Toast.LENGTH_SHORT
                                                                                    ).show()
                                                                                } else {
                                                                                    valorQ2Q18 =
                                                                                        RespQ2Q18
                                                                                    AlertDialog.Builder(requireContext())
                                                                                        .setTitle(R.string.menu_app)
                                                                                        .setMessage(R.string.txtFinal2)
                                                                                        .setPositiveButton(R.string.btnOk) { _, _ ->
                                                                                            //Criando um coleção
                                                                                            val user =
                                                                                                Firebase.auth.currentUser
                                                                                            user?.let {
                                                                                                val email =
                                                                                                    it.email
                                                                                                db.collection(
                                                                                                    "User"
                                                                                                )
                                                                                                    .document(
                                                                                                        email.toString()
                                                                                                    )
                                                                                                    .addSnapshotListener { documento, _ ->
                                                                                                        if (documento != null) {
                                                                                                            val nome =
                                                                                                                documento.getString(
                                                                                                                    "Nome"
                                                                                                                )
                                                                                                            val emailMauq =
                                                                                                                documento.getString(
                                                                                                                    "Email"
                                                                                                                )
                                                                                                            val txtData =
                                                                                                                SimpleDateFormat(
                                                                                                                    "dd/MM/yyyy",
                                                                                                                    Locale.getDefault()
                                                                                                                ).format(
                                                                                                                    System.currentTimeMillis()
                                                                                                                )
                                                                                                            val txtHora =
                                                                                                                SimpleDateFormat(
                                                                                                                    "HH:mm",
                                                                                                                    Locale.getDefault()
                                                                                                                ).format(
                                                                                                                    System.currentTimeMillis()
                                                                                                                )
                                                                                                            val idMauq =
                                                                                                                db.collection(
                                                                                                                    "Mauq"
                                                                                                                )
                                                                                                                    .document().id

                                                                                                            val mauqMap =
                                                                                                                hashMapOf(
                                                                                                                    "idMauq" to idMauq,
                                                                                                                    "Nome" to nome.toString(),
                                                                                                                    "Email" to emailMauq.toString(),
                                                                                                                    "Data" to txtData.toString(),
                                                                                                                    "Hora" to txtHora.toString(),
                                                                                                                    "Questao_01" to valorQ2Q1.toString(),
                                                                                                                    "Questao_02" to valorQ2Q2.toString(),
                                                                                                                    "Questao_03" to valorQ2Q3.toString(),
                                                                                                                    "Questao_04" to valorQ2Q4.toString(),
                                                                                                                    "Questao_05" to valorQ2Q5.toString(),
                                                                                                                    "Questao_06" to valorQ2Q6.toString(),
                                                                                                                    "Questao_07" to valorQ2Q7.toString(),
                                                                                                                    "Questao_08" to valorQ2Q8.toString(),
                                                                                                                    "Questao_09" to valorQ2Q9.toString(),
                                                                                                                    "Questao_10" to valorQ2Q10.toString(),
                                                                                                                    "Questao_11" to valorQ2Q11.toString(),
                                                                                                                    "Questao_12" to valorQ2Q12.toString(),
                                                                                                                    "Questao_13" to valorQ2Q13.toString(),
                                                                                                                    "Questao_14" to valorQ2Q14.toString(),
                                                                                                                    "Questao_15" to valorQ2Q15.toString(),
                                                                                                                    "Questao_16" to valorQ2Q16.toString(),
                                                                                                                    "Questao_17" to valorQ2Q17.toString(),
                                                                                                                    "Questao_18" to valorQ2Q18.toString()
                                                                                                                )
                                                                                                            db.collection(
                                                                                                                "Mauq"
                                                                                                            )
                                                                                                                .document(
                                                                                                                    idMauq
                                                                                                                )
                                                                                                                .set(
                                                                                                                    mauqMap
                                                                                                                )
                                                                                                                .addOnCompleteListener {}
                                                                                                                .addOnFailureListener {}

                                                                                                        }
                                                                                                    }
                                                                                            }
                                                                                        }
                                                                                        .setIcon(R.drawable.ic_menstruacao)
                                                                                        .show()
                                                                                        setFragment(homeFragment)
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return pegarView
    }
    private fun setCheckedrdgQ2Q1() {
        rdgQ2Q1.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q2Q1opt1 == checkedId) {
                RespQ2Q1 = 1
            } else if (R.id.Q2Q1opt2 == checkedId) {
                RespQ2Q1 = 2
            } else if (R.id.Q2Q1opt3 == checkedId) {
                RespQ2Q1 = 3
            } else if (R.id.Q2Q1opt4 == checkedId) {
                RespQ2Q1 = 4
            } else if (R.id.Q2Q1opt5 == checkedId) {
                RespQ2Q1 = 5
            } else if (R.id.Q2Q1opt6 == checkedId) {
                RespQ2Q1 = 6
            } else if (R.id.Q2Q1opt7 == checkedId) {
                RespQ2Q1 = 7
            }
        }
    }
    private fun setCheckedrdgQ2Q2() {
        rdgQ2Q2.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q2Q1opt2 == checkedId) {
                RespQ2Q2 = 1
            } else if (R.id.Q2Q2opt2 == checkedId) {
                RespQ2Q2 = 2
            } else if (R.id.Q2Q2opt3 == checkedId) {
                RespQ2Q2 = 3
            } else if (R.id.Q2Q2opt4 == checkedId) {
                RespQ2Q2 = 4
            } else if (R.id.Q2Q2opt5 == checkedId) {
                RespQ2Q2 = 5
            } else if (R.id.Q2Q2opt6 == checkedId) {
                RespQ2Q2 = 6
            } else if (R.id.Q2Q2opt7 == checkedId) {
                RespQ2Q2 = 7
            }
        }
    }
    private fun setCheckedrdgQ2Q3() {
        rdgQ2Q3.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q2Q3opt1 == checkedId) {
                RespQ2Q3 = 1
            } else if (R.id.Q2Q3opt2 == checkedId) {
                RespQ2Q3 = 2
            } else if (R.id.Q2Q3opt3 == checkedId) {
                RespQ2Q3 = 3
            } else if (R.id.Q2Q3opt4 == checkedId) {
                RespQ2Q3 = 4
            } else if (R.id.Q2Q3opt5 == checkedId) {
                RespQ2Q3 = 5
            } else if (R.id.Q2Q3opt6 == checkedId) {
                RespQ2Q3 = 6
            } else if (R.id.Q2Q3opt7 == checkedId) {
                RespQ2Q3 = 7
            }
        }
    }
    private fun setCheckedrdgQ2Q4() {
        rdgQ2Q4.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q2Q4opt1 == checkedId) {
                RespQ2Q4 = 1
            } else if (R.id.Q2Q4opt2 == checkedId) {
                RespQ2Q4 = 2
            } else if (R.id.Q2Q4opt3 == checkedId) {
                RespQ2Q4 = 3
            } else if (R.id.Q2Q4opt4 == checkedId) {
                RespQ2Q4 = 4
            } else if (R.id.Q2Q4opt5 == checkedId) {
                RespQ2Q4 = 5
            } else if (R.id.Q2Q4opt6 == checkedId) {
                RespQ2Q4 = 6
            } else if (R.id.Q2Q4opt7 == checkedId) {
                RespQ2Q4 = 7
            }
        }
    }
    private fun setCheckedrdgQ2Q5() {
        rdgQ2Q5.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q2Q5opt1 == checkedId) {
                RespQ2Q5 = 1
            } else if (R.id.Q2Q5opt2 == checkedId) {
                RespQ2Q5 = 2
            } else if (R.id.Q2Q5opt3 == checkedId) {
                RespQ2Q5 = 3
            } else if (R.id.Q2Q5opt4 == checkedId) {
                RespQ2Q5 = 4
            } else if (R.id.Q2Q5opt5 == checkedId) {
                RespQ2Q5 = 5
            } else if (R.id.Q2Q5opt6 == checkedId) {
                RespQ2Q5 = 6
            } else if (R.id.Q2Q5opt7 == checkedId) {
                RespQ2Q5 = 7
            }
        }
    }
    private fun setCheckedrdgQ2Q6() {
        rdgQ2Q6.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q2Q6opt1 == checkedId) {
                RespQ2Q6 = 1
            } else if (R.id.Q2Q6opt2 == checkedId) {
                RespQ2Q6 = 2
            } else if (R.id.Q2Q6opt3 == checkedId) {
                RespQ2Q6 = 3
            } else if (R.id.Q2Q6opt4 == checkedId) {
                RespQ2Q6 = 4
            } else if (R.id.Q2Q6opt5 == checkedId) {
                RespQ2Q6 = 5
            } else if (R.id.Q2Q6opt6 == checkedId) {
                RespQ2Q6 = 6
            } else if (R.id.Q2Q6opt7 == checkedId) {
                RespQ2Q6 = 7
            }
        }
    }
    private fun setCheckedrdgQ2Q7() {
        rdgQ2Q7.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q2Q7opt1 == checkedId) {
                RespQ2Q7 = 1
            } else if (R.id.Q2Q7opt2 == checkedId) {
                RespQ2Q7 = 2
            } else if (R.id.Q2Q7opt3 == checkedId) {
                RespQ2Q7 = 3
            } else if (R.id.Q2Q7opt4 == checkedId) {
                RespQ2Q7 = 4
            } else if (R.id.Q2Q7opt5 == checkedId) {
                RespQ2Q7 = 5
            } else if (R.id.Q2Q7opt6 == checkedId) {
                RespQ2Q7 = 6
            } else if (R.id.Q2Q7opt7 == checkedId) {
                RespQ2Q7 = 7
            }
        }
    }
    private fun setCheckedrdgQ2Q8() {
        rdgQ2Q8.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q2Q8opt1 == checkedId) {
                RespQ2Q8 = 1
            } else if (R.id.Q2Q8opt2 == checkedId) {
                RespQ2Q8 = 2
            } else if (R.id.Q2Q8opt3 == checkedId) {
                RespQ2Q8 = 3
            } else if (R.id.Q2Q8opt4 == checkedId) {
                RespQ2Q8 = 4
            } else if (R.id.Q2Q8opt5 == checkedId) {
                RespQ2Q8 = 5
            } else if (R.id.Q2Q8opt6 == checkedId) {
                RespQ2Q8 = 6
            } else if (R.id.Q2Q8opt7 == checkedId) {
                RespQ2Q8 = 7
            }
        }
    }
    private fun setCheckedrdgQ2Q9() {
        rdgQ2Q9.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q2Q9opt1 == checkedId) {
                RespQ2Q9 = 1
            } else if (R.id.Q2Q9opt2 == checkedId) {
                RespQ2Q9 = 2
            } else if (R.id.Q2Q9opt3 == checkedId) {
                RespQ2Q9 = 3
            } else if (R.id.Q2Q9opt4 == checkedId) {
                RespQ2Q9 = 4
            } else if (R.id.Q2Q9opt5 == checkedId) {
                RespQ2Q9 = 5
            } else if (R.id.Q2Q9opt6 == checkedId) {
                RespQ2Q9 = 6
            } else if (R.id.Q2Q9opt7 == checkedId) {
                RespQ2Q9 = 7
            }
        }
    }
    private fun setCheckedrdgQ2Q10() {
        rdgQ2Q10.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q2Q10opt1 == checkedId) {
                RespQ2Q10 = 1
            } else if (R.id.Q2Q10opt2 == checkedId) {
                RespQ2Q10 = 2
            } else if (R.id.Q2Q10opt3 == checkedId) {
                RespQ2Q10 = 3
            } else if (R.id.Q2Q10opt4 == checkedId) {
                RespQ2Q10 = 4
            } else if (R.id.Q2Q10opt5 == checkedId) {
                RespQ2Q10 = 5
            } else if (R.id.Q2Q10opt6 == checkedId) {
                RespQ2Q10 = 6
            } else if (R.id.Q2Q10opt7 == checkedId) {
                RespQ2Q10 = 7
            }
        }
    }
    private fun setCheckedrdgQ2Q11() {
        rdgQ2Q11.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q2Q11opt1 == checkedId) {
                RespQ2Q11 = 1
            } else if (R.id.Q2Q11opt2 == checkedId) {
                RespQ2Q11 = 2
            } else if (R.id.Q2Q11opt3 == checkedId) {
                RespQ2Q11 = 3
            } else if (R.id.Q2Q11opt4 == checkedId) {
                RespQ2Q11 = 4
            } else if (R.id.Q2Q11opt5 == checkedId) {
                RespQ2Q11 = 5
            } else if (R.id.Q2Q11opt6 == checkedId) {
                RespQ2Q11 = 6
            } else if (R.id.Q2Q11opt7 == checkedId) {
                RespQ2Q11 = 7
            }
        }
    }
    private fun setCheckedrdgQ2Q12() {
        rdgQ2Q12.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q2Q12opt1 == checkedId) {
                RespQ2Q12 = 1
            } else if (R.id.Q2Q12opt2 == checkedId) {
                RespQ2Q12 = 2
            } else if (R.id.Q2Q12opt3 == checkedId) {
                RespQ2Q12 = 3
            } else if (R.id.Q2Q12opt4 == checkedId) {
                RespQ2Q12 = 4
            } else if (R.id.Q2Q12opt5 == checkedId) {
                RespQ2Q12 = 5
            } else if (R.id.Q2Q12opt6 == checkedId) {
                RespQ2Q12 = 6
            } else if (R.id.Q2Q12opt7 == checkedId) {
                RespQ2Q12 = 7
            }
        }
    }
    private fun setCheckedrdgQ2Q13() {
        rdgQ2Q13.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q2Q13opt1 == checkedId) {
                RespQ2Q13 = 1
            } else if (R.id.Q2Q13opt2 == checkedId) {
                RespQ2Q13 = 2
            } else if (R.id.Q2Q13opt3 == checkedId) {
                RespQ2Q13 = 3
            } else if (R.id.Q2Q13opt4 == checkedId) {
                RespQ2Q13 = 4
            } else if (R.id.Q2Q13opt5 == checkedId) {
                RespQ2Q13 = 5
            } else if (R.id.Q2Q13opt6 == checkedId) {
                RespQ2Q13 = 6
            } else if (R.id.Q2Q13opt7 == checkedId) {
                RespQ2Q13 = 7
            }
        }
    }
    private fun setCheckedrdgQ2Q14() {
        rdgQ2Q14.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q2Q14opt1 == checkedId) {
                RespQ2Q14 = 1
            } else if (R.id.Q2Q14opt2 == checkedId) {
                RespQ2Q14 = 2
            } else if (R.id.Q2Q14opt3 == checkedId) {
                RespQ2Q14 = 3
            } else if (R.id.Q2Q14opt4 == checkedId) {
                RespQ2Q14 = 4
            } else if (R.id.Q2Q14opt5 == checkedId) {
                RespQ2Q14 = 5
            } else if (R.id.Q2Q14opt6 == checkedId) {
                RespQ2Q14 = 6
            } else if (R.id.Q2Q14opt7 == checkedId) {
                RespQ2Q14 = 7
            }
        }
    }
    private fun setCheckedrdgQ2Q15() {
        rdgQ2Q15.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q2Q15opt1 == checkedId) {
                RespQ2Q15 = 1
            } else if (R.id.Q2Q15opt2 == checkedId) {
                RespQ2Q15 = 2
            } else if (R.id.Q2Q15opt3 == checkedId) {
                RespQ2Q15 = 3
            } else if (R.id.Q2Q15opt4 == checkedId) {
                RespQ2Q15 = 4
            } else if (R.id.Q2Q15opt5 == checkedId) {
                RespQ2Q15 = 5
            } else if (R.id.Q2Q15opt6 == checkedId) {
                RespQ2Q15 = 6
            } else if (R.id.Q2Q15opt7 == checkedId) {
                RespQ2Q15 = 7
            }
        }
    }
    private fun setCheckedrdgQ2Q16() {
        rdgQ2Q16.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q2Q16opt1 == checkedId) {
                RespQ2Q16 = 1
            } else if (R.id.Q2Q16opt2 == checkedId) {
                RespQ2Q16 = 2
            } else if (R.id.Q2Q16opt3 == checkedId) {
                RespQ2Q16 = 3
            } else if (R.id.Q2Q16opt4 == checkedId) {
                RespQ2Q16 = 4
            } else if (R.id.Q2Q16opt5 == checkedId) {
                RespQ2Q16 = 5
            } else if (R.id.Q2Q16opt6 == checkedId) {
                RespQ2Q16 = 6
            } else if (R.id.Q2Q16opt7 == checkedId) {
                RespQ2Q16 = 7
            }
        }
    }
    private fun setCheckedrdgQ2Q17() {
        rdgQ2Q17.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q2Q17opt1 == checkedId) {
                RespQ2Q17 = 1
            } else if (R.id.Q2Q17opt2 == checkedId) {
                RespQ2Q17 = 2
            } else if (R.id.Q2Q17opt3 == checkedId) {
                RespQ2Q17 = 3
            } else if (R.id.Q2Q17opt4 == checkedId) {
                RespQ2Q17 = 4
            } else if (R.id.Q2Q17opt5 == checkedId) {
                RespQ2Q17 = 5
            } else if (R.id.Q2Q17opt6 == checkedId) {
                RespQ2Q17 = 6
            } else if (R.id.Q2Q17opt7 == checkedId) {
                RespQ2Q17 = 7
            }
        }
    }
    private fun setCheckedrdgQ2Q18() {
        rdgQ2Q18.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q2Q18opt1 == checkedId) {
                RespQ2Q18 = 1
            } else if (R.id.Q2Q18opt2 == checkedId) {
                RespQ2Q18 = 2
            } else if (R.id.Q2Q18opt3 == checkedId) {
                RespQ2Q18 = 3
            } else if (R.id.Q2Q18opt4 == checkedId) {
                RespQ2Q18 = 4
            } else if (R.id.Q2Q18opt5 == checkedId) {
                RespQ2Q18 = 5
            } else if (R.id.Q2Q18opt6 == checkedId) {
                RespQ2Q18 = 6
            } else if (R.id.Q2Q18opt7 == checkedId) {
                RespQ2Q18 = 7
            }
        }
    }
    private fun setFragment(fragment: Fragment){
        val fT = requireActivity().supportFragmentManager.beginTransaction()
        fT.replace(R.id.nav_host_fragment_content_principal, fragment)
        fT.commit()
    }
}