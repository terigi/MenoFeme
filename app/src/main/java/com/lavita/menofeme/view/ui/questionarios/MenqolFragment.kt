package com.lavita.menofeme.view.ui.questionarios

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.lavita.menofeme.R

@Suppress("NAME_SHADOWING")
class MenqolFragment : Fragment() {
    private lateinit var pegarView: View
    private lateinit var btnProximo: androidx.appcompat.widget.AppCompatButton
    private lateinit var rdgQ1Q1: RadioGroup
    private lateinit var rdgQ1Q2: RadioGroup
    private lateinit var rdgQ1Q3: RadioGroup
    private lateinit var rdgQ1Q4: RadioGroup
    private lateinit var rdgQ1Q5: RadioGroup
    private lateinit var rdgQ1Q6: RadioGroup
    private lateinit var rdgQ1Q7: RadioGroup
    private lateinit var rdgQ1Q8: RadioGroup
    private lateinit var rdgQ1Q9: RadioGroup
    private lateinit var rdgQ1Q10: RadioGroup
    private lateinit var rdgQ1Q11: RadioGroup
    private lateinit var rdgQ1Q12: RadioGroup
    private lateinit var rdgQ1Q13: RadioGroup
    private lateinit var rdgQ1Q14: RadioGroup
    private lateinit var rdgQ1Q15: RadioGroup
    private lateinit var Q1Q1opt0: RadioButton
    private lateinit var Q1Q1opt1: RadioButton
    private lateinit var Q1Q1opt2: RadioButton
    private lateinit var Q1Q1opt3: RadioButton
    private lateinit var Q1Q1opt4: RadioButton
    private lateinit var Q1Q1opt5: RadioButton
    private lateinit var Q1Q1opt6: RadioButton
    private lateinit var Q1Q2opt0: RadioButton
    private lateinit var Q1Q2opt1: RadioButton
    private lateinit var Q1Q2opt2: RadioButton
    private lateinit var Q1Q2opt3: RadioButton
    private lateinit var Q1Q2opt4: RadioButton
    private lateinit var Q1Q2opt5: RadioButton
    private lateinit var Q1Q2opt6: RadioButton
    private lateinit var Q1Q3opt0: RadioButton
    private lateinit var Q1Q3opt1: RadioButton
    private lateinit var Q1Q3opt2: RadioButton
    private lateinit var Q1Q3opt3: RadioButton
    private lateinit var Q1Q3opt4: RadioButton
    private lateinit var Q1Q3opt5: RadioButton
    private lateinit var Q1Q3opt6: RadioButton
    private lateinit var Q1Q4opt0: RadioButton
    private lateinit var Q1Q4opt1: RadioButton
    private lateinit var Q1Q4opt2: RadioButton
    private lateinit var Q1Q4opt3: RadioButton
    private lateinit var Q1Q4opt4: RadioButton
    private lateinit var Q1Q4opt5: RadioButton
    private lateinit var Q1Q4opt6: RadioButton
    private lateinit var Q1Q5opt0: RadioButton
    private lateinit var Q1Q5opt1: RadioButton
    private lateinit var Q1Q5opt2: RadioButton
    private lateinit var Q1Q5opt3: RadioButton
    private lateinit var Q1Q5opt4: RadioButton
    private lateinit var Q1Q5opt5: RadioButton
    private lateinit var Q1Q5opt6: RadioButton
    private lateinit var Q1Q6opt0: RadioButton
    private lateinit var Q1Q6opt1: RadioButton
    private lateinit var Q1Q6opt2: RadioButton
    private lateinit var Q1Q6opt3: RadioButton
    private lateinit var Q1Q6opt4: RadioButton
    private lateinit var Q1Q6opt5: RadioButton
    private lateinit var Q1Q6opt6: RadioButton
    private lateinit var Q1Q7opt0: RadioButton
    private lateinit var Q1Q7opt1: RadioButton
    private lateinit var Q1Q7opt2: RadioButton
    private lateinit var Q1Q7opt3: RadioButton
    private lateinit var Q1Q7opt4: RadioButton
    private lateinit var Q1Q7opt5: RadioButton
    private lateinit var Q1Q7opt6: RadioButton
    private lateinit var Q1Q8opt0: RadioButton
    private lateinit var Q1Q8opt1: RadioButton
    private lateinit var Q1Q8opt2: RadioButton
    private lateinit var Q1Q8opt3: RadioButton
    private lateinit var Q1Q8opt4: RadioButton
    private lateinit var Q1Q8opt5: RadioButton
    private lateinit var Q1Q8opt6: RadioButton
    private lateinit var Q1Q9opt0: RadioButton
    private lateinit var Q1Q9opt1: RadioButton
    private lateinit var Q1Q9opt2: RadioButton
    private lateinit var Q1Q9opt3: RadioButton
    private lateinit var Q1Q9opt4: RadioButton
    private lateinit var Q1Q9opt5: RadioButton
    private lateinit var Q1Q9opt6: RadioButton
    private lateinit var Q1Q10opt0: RadioButton
    private lateinit var Q1Q10opt1: RadioButton
    private lateinit var Q1Q10opt2: RadioButton
    private lateinit var Q1Q10opt3: RadioButton
    private lateinit var Q1Q10opt4: RadioButton
    private lateinit var Q1Q10opt5: RadioButton
    private lateinit var Q1Q10opt6: RadioButton
    private lateinit var Q1Q11opt0: RadioButton
    private lateinit var Q1Q11opt1: RadioButton
    private lateinit var Q1Q11opt2: RadioButton
    private lateinit var Q1Q11opt3: RadioButton
    private lateinit var Q1Q11opt4: RadioButton
    private lateinit var Q1Q11opt5: RadioButton
    private lateinit var Q1Q11opt6: RadioButton
    private lateinit var Q1Q12opt0: RadioButton
    private lateinit var Q1Q12opt1: RadioButton
    private lateinit var Q1Q12opt2: RadioButton
    private lateinit var Q1Q12opt3: RadioButton
    private lateinit var Q1Q12opt4: RadioButton
    private lateinit var Q1Q12opt5: RadioButton
    private lateinit var Q1Q12opt6: RadioButton
    private lateinit var Q1Q13opt0: RadioButton
    private lateinit var Q1Q13opt1: RadioButton
    private lateinit var Q1Q13opt2: RadioButton
    private lateinit var Q1Q13opt3: RadioButton
    private lateinit var Q1Q13opt4: RadioButton
    private lateinit var Q1Q13opt5: RadioButton
    private lateinit var Q1Q13opt6: RadioButton
    private lateinit var Q1Q14opt0: RadioButton
    private lateinit var Q1Q14opt1: RadioButton
    private lateinit var Q1Q14opt2: RadioButton
    private lateinit var Q1Q14opt3: RadioButton
    private lateinit var Q1Q14opt4: RadioButton
    private lateinit var Q1Q14opt5: RadioButton
    private lateinit var Q1Q14opt6: RadioButton
    private lateinit var Q1Q15opt0: RadioButton
    private lateinit var Q1Q15opt1: RadioButton
    private lateinit var Q1Q15opt2: RadioButton
    private lateinit var Q1Q15opt3: RadioButton
    private lateinit var Q1Q15opt4: RadioButton
    private lateinit var Q1Q15opt5: RadioButton
    private lateinit var Q1Q15opt6: RadioButton
    private lateinit var menqol2Fragment: Menqol2Fragment


    private var RespQ1Q1: Int = 9
    private var RespQ1Q2: Int = 9
    private var RespQ1Q3: Int = 9
    private var RespQ1Q4: Int = 9
    private var RespQ1Q5: Int = 9
    private var RespQ1Q6: Int = 9
    private var RespQ1Q7: Int = 9
    private var RespQ1Q8: Int = 9
    private var RespQ1Q9: Int = 9
    private var RespQ1Q10: Int = 9
    private var RespQ1Q11: Int = 9
    private var RespQ1Q12: Int = 9
    private var RespQ1Q13: Int = 9
    private var RespQ1Q14: Int = 9
    private var RespQ1Q15: Int = 9




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        pegarView = inflater.inflate(R.layout.fragment_menqol, container, false)
        btnProximo = pegarView.findViewById(R.id.btnProximoMenqol)
        rdgQ1Q1 = pegarView.findViewById(R.id.rdgQ1Q1)
        rdgQ1Q2 = pegarView.findViewById(R.id.rdgQ1Q2)
        rdgQ1Q3 = pegarView.findViewById(R.id.rdgQ1Q3)
        rdgQ1Q4 = pegarView.findViewById(R.id.rdgQ1Q4)
        rdgQ1Q5 = pegarView.findViewById(R.id.rdgQ1Q5)
        rdgQ1Q6 = pegarView.findViewById(R.id.rdgQ1Q6)
        rdgQ1Q7 = pegarView.findViewById(R.id.rdgQ1Q7)
        rdgQ1Q8 = pegarView.findViewById(R.id.rdgQ1Q8)
        rdgQ1Q9 = pegarView.findViewById(R.id.rdgQ1Q9)
        rdgQ1Q10 = pegarView.findViewById(R.id.rdgQ1Q10)
        rdgQ1Q11 = pegarView.findViewById(R.id.rdgQ1Q11)
        rdgQ1Q12 = pegarView.findViewById(R.id.rdgQ1Q12)
        rdgQ1Q13 = pegarView.findViewById(R.id.rdgQ1Q13)
        rdgQ1Q14 = pegarView.findViewById(R.id.rdgQ1Q14)
        rdgQ1Q15 = pegarView.findViewById(R.id.rdgQ1Q15)
        Q1Q1opt0 = pegarView.findViewById(R.id.Q1Q1opt0)
        Q1Q1opt1 = pegarView.findViewById(R.id.Q1Q1opt1)
        Q1Q1opt2 = pegarView.findViewById(R.id.Q1Q1opt2)
        Q1Q1opt3 = pegarView.findViewById(R.id.Q1Q1opt3)
        Q1Q1opt4 = pegarView.findViewById(R.id.Q1Q1opt4)
        Q1Q1opt5 = pegarView.findViewById(R.id.Q1Q1opt5)
        Q1Q1opt6 = pegarView.findViewById(R.id.Q1Q1opt6)
        Q1Q2opt0 = pegarView.findViewById(R.id.Q1Q2opt0)
        Q1Q2opt1 = pegarView.findViewById(R.id.Q1Q2opt1)
        Q1Q2opt2 = pegarView.findViewById(R.id.Q1Q2opt2)
        Q1Q2opt3 = pegarView.findViewById(R.id.Q1Q2opt3)
        Q1Q2opt4 = pegarView.findViewById(R.id.Q1Q2opt4)
        Q1Q2opt5 = pegarView.findViewById(R.id.Q1Q2opt5)
        Q1Q2opt6 = pegarView.findViewById(R.id.Q1Q2opt6)
        Q1Q3opt0 = pegarView.findViewById(R.id.Q1Q3opt0)
        Q1Q3opt1 = pegarView.findViewById(R.id.Q1Q3opt1)
        Q1Q3opt2 = pegarView.findViewById(R.id.Q1Q3opt2)
        Q1Q3opt3 = pegarView.findViewById(R.id.Q1Q3opt3)
        Q1Q3opt4 = pegarView.findViewById(R.id.Q1Q3opt4)
        Q1Q3opt5 = pegarView.findViewById(R.id.Q1Q3opt5)
        Q1Q3opt6 = pegarView.findViewById(R.id.Q1Q3opt6)
        Q1Q4opt0 = pegarView.findViewById(R.id.Q1Q4opt0)
        Q1Q4opt1 = pegarView.findViewById(R.id.Q1Q4opt1)
        Q1Q4opt2 = pegarView.findViewById(R.id.Q1Q4opt2)
        Q1Q4opt3 = pegarView.findViewById(R.id.Q1Q4opt3)
        Q1Q4opt4 = pegarView.findViewById(R.id.Q1Q4opt4)
        Q1Q4opt5 = pegarView.findViewById(R.id.Q1Q4opt5)
        Q1Q4opt6 = pegarView.findViewById(R.id.Q1Q4opt6)
        Q1Q5opt0 = pegarView.findViewById(R.id.Q1Q5opt0)
        Q1Q5opt1 = pegarView.findViewById(R.id.Q1Q5opt1)
        Q1Q5opt2 = pegarView.findViewById(R.id.Q1Q5opt2)
        Q1Q5opt3 = pegarView.findViewById(R.id.Q1Q5opt3)
        Q1Q5opt4 = pegarView.findViewById(R.id.Q1Q5opt4)
        Q1Q5opt5 = pegarView.findViewById(R.id.Q1Q5opt5)
        Q1Q5opt6 = pegarView.findViewById(R.id.Q1Q5opt6)
        Q1Q6opt0 = pegarView.findViewById(R.id.Q1Q6opt0)
        Q1Q6opt1 = pegarView.findViewById(R.id.Q1Q6opt1)
        Q1Q6opt2 = pegarView.findViewById(R.id.Q1Q6opt2)
        Q1Q6opt3 = pegarView.findViewById(R.id.Q1Q6opt3)
        Q1Q6opt4 = pegarView.findViewById(R.id.Q1Q6opt4)
        Q1Q6opt5 = pegarView.findViewById(R.id.Q1Q6opt5)
        Q1Q6opt6 = pegarView.findViewById(R.id.Q1Q6opt6)
        Q1Q7opt0 = pegarView.findViewById(R.id.Q1Q7opt0)
        Q1Q7opt1 = pegarView.findViewById(R.id.Q1Q7opt1)
        Q1Q7opt2 = pegarView.findViewById(R.id.Q1Q7opt2)
        Q1Q7opt3 = pegarView.findViewById(R.id.Q1Q7opt3)
        Q1Q7opt4 = pegarView.findViewById(R.id.Q1Q7opt4)
        Q1Q7opt5 = pegarView.findViewById(R.id.Q1Q7opt5)
        Q1Q7opt6 = pegarView.findViewById(R.id.Q1Q7opt6)
        Q1Q8opt0 = pegarView.findViewById(R.id.Q1Q8opt0)
        Q1Q8opt1 = pegarView.findViewById(R.id.Q1Q8opt1)
        Q1Q8opt2 = pegarView.findViewById(R.id.Q1Q8opt2)
        Q1Q8opt3 = pegarView.findViewById(R.id.Q1Q8opt3)
        Q1Q8opt4 = pegarView.findViewById(R.id.Q1Q8opt4)
        Q1Q8opt5 = pegarView.findViewById(R.id.Q1Q8opt5)
        Q1Q8opt6 = pegarView.findViewById(R.id.Q1Q8opt6)
        Q1Q9opt0 = pegarView.findViewById(R.id.Q1Q9opt0)
        Q1Q9opt1 = pegarView.findViewById(R.id.Q1Q9opt1)
        Q1Q9opt2 = pegarView.findViewById(R.id.Q1Q9opt2)
        Q1Q9opt3 = pegarView.findViewById(R.id.Q1Q9opt3)
        Q1Q9opt4 = pegarView.findViewById(R.id.Q1Q9opt4)
        Q1Q9opt5 = pegarView.findViewById(R.id.Q1Q9opt5)
        Q1Q9opt6 = pegarView.findViewById(R.id.Q1Q9opt6)
        Q1Q10opt0 = pegarView.findViewById(R.id.Q1Q10opt0)
        Q1Q10opt1 = pegarView.findViewById(R.id.Q1Q10opt1)
        Q1Q10opt2 = pegarView.findViewById(R.id.Q1Q10opt2)
        Q1Q10opt3 = pegarView.findViewById(R.id.Q1Q10opt3)
        Q1Q10opt4 = pegarView.findViewById(R.id.Q1Q10opt4)
        Q1Q10opt5 = pegarView.findViewById(R.id.Q1Q10opt5)
        Q1Q10opt6 = pegarView.findViewById(R.id.Q1Q10opt6)
        Q1Q11opt0 = pegarView.findViewById(R.id.Q1Q11opt0)
        Q1Q11opt1 = pegarView.findViewById(R.id.Q1Q11opt1)
        Q1Q11opt2 = pegarView.findViewById(R.id.Q1Q11opt2)
        Q1Q11opt3 = pegarView.findViewById(R.id.Q1Q11opt3)
        Q1Q11opt4 = pegarView.findViewById(R.id.Q1Q11opt4)
        Q1Q11opt5 = pegarView.findViewById(R.id.Q1Q11opt5)
        Q1Q11opt6 = pegarView.findViewById(R.id.Q1Q11opt6)
        Q1Q12opt0 = pegarView.findViewById(R.id.Q1Q12opt0)
        Q1Q12opt1 = pegarView.findViewById(R.id.Q1Q12opt1)
        Q1Q12opt2 = pegarView.findViewById(R.id.Q1Q12opt2)
        Q1Q12opt3 = pegarView.findViewById(R.id.Q1Q12opt3)
        Q1Q12opt4 = pegarView.findViewById(R.id.Q1Q12opt4)
        Q1Q12opt5 = pegarView.findViewById(R.id.Q1Q12opt5)
        Q1Q12opt6 = pegarView.findViewById(R.id.Q1Q12opt6)
        Q1Q13opt0 = pegarView.findViewById(R.id.Q1Q13opt0)
        Q1Q13opt1 = pegarView.findViewById(R.id.Q1Q13opt1)
        Q1Q13opt2 = pegarView.findViewById(R.id.Q1Q13opt2)
        Q1Q13opt3 = pegarView.findViewById(R.id.Q1Q13opt3)
        Q1Q13opt4 = pegarView.findViewById(R.id.Q1Q13opt4)
        Q1Q13opt5 = pegarView.findViewById(R.id.Q1Q13opt5)
        Q1Q13opt6 = pegarView.findViewById(R.id.Q1Q13opt6)
        Q1Q14opt0 = pegarView.findViewById(R.id.Q1Q14opt0)
        Q1Q14opt1 = pegarView.findViewById(R.id.Q1Q14opt1)
        Q1Q14opt2 = pegarView.findViewById(R.id.Q1Q14opt2)
        Q1Q14opt3 = pegarView.findViewById(R.id.Q1Q14opt3)
        Q1Q14opt4 = pegarView.findViewById(R.id.Q1Q14opt4)
        Q1Q14opt5 = pegarView.findViewById(R.id.Q1Q14opt5)
        Q1Q14opt6 = pegarView.findViewById(R.id.Q1Q14opt6)
        Q1Q15opt0 = pegarView.findViewById(R.id.Q1Q15opt0)
        Q1Q15opt1 = pegarView.findViewById(R.id.Q1Q15opt1)
        Q1Q15opt2 = pegarView.findViewById(R.id.Q1Q15opt2)
        Q1Q15opt3 = pegarView.findViewById(R.id.Q1Q15opt3)
        Q1Q15opt4 = pegarView.findViewById(R.id.Q1Q15opt4)
        Q1Q15opt5 = pegarView.findViewById(R.id.Q1Q15opt5)
        Q1Q15opt6 = pegarView.findViewById(R.id.Q1Q15opt6)
        menqol2Fragment = Menqol2Fragment()

        setCheckedrdgQ1Q1()
        setCheckedrdgQ1Q2()
        setCheckedrdgQ1Q3()
        setCheckedrdgQ1Q4()
        setCheckedrdgQ1Q5()
        setCheckedrdgQ1Q6()
        setCheckedrdgQ1Q7()
        setCheckedrdgQ1Q8()
        setCheckedrdgQ1Q9()
        setCheckedrdgQ1Q10()
        setCheckedrdgQ1Q11()
        setCheckedrdgQ1Q12()
        setCheckedrdgQ1Q13()
        setCheckedrdgQ1Q14()
        setCheckedrdgQ1Q15()

        btnProximo.setOnClickListener {
           if (RespQ1Q1 == 9) {
                Toast.makeText(requireContext(), getString(R.string.txtQ1), Toast.LENGTH_SHORT)
                    .show()
            } else {
               val result =RespQ1Q1.toString()
               setFragmentResult("requestKey1", bundleOf("Menqol" to result))
                if (RespQ1Q2 == 9) {
                    Toast.makeText(requireContext(), getString(R.string.txtQ2), Toast.LENGTH_SHORT).show()
                } else {
                    val result =RespQ1Q2.toString()
                    setFragmentResult("requestKey2", bundleOf("Menqol" to result))
                    if (RespQ1Q3 == 9) {
                        Toast.makeText(requireContext(),getString(R.string.txtQ3), Toast.LENGTH_SHORT).show()
                    } else {
                        val result =RespQ1Q3.toString()
                        setFragmentResult("requestKey3", bundleOf("Menqol" to result))
                        if (RespQ1Q4 == 9) { Toast.makeText(requireContext(),getString(R.string.txtQ4), Toast.LENGTH_SHORT).show()
                        } else {
                            val result =RespQ1Q4.toString()
                            setFragmentResult("requestKey4", bundleOf("Menqol" to result))
                            if (RespQ1Q5 == 9) {
                                Toast.makeText(requireContext(),getString(R.string.txtQ5),Toast.LENGTH_SHORT).show()
                            } else {
                                val result =RespQ1Q5.toString()
                                setFragmentResult("requestKey5", bundleOf("Menqol" to result))
                                if (RespQ1Q6 == 9) {
                                    Toast.makeText(requireContext(), getString(R.string.txtQ6), Toast.LENGTH_SHORT).show()
                                } else {
                                    val result =RespQ1Q6.toString()
                                    setFragmentResult("requestKey6", bundleOf("Menqol" to result))
                                    if (RespQ1Q7 == 9) { Toast.makeText(requireContext(), getString(R.string.txtQ7), Toast.LENGTH_SHORT).show()
                                    } else {
                                        val result =RespQ1Q7.toString()
                                        setFragmentResult("requestKey7", bundleOf("Menqol" to result))
                                        if (RespQ1Q8 == 9) {
                                            Toast.makeText(requireContext(),getString(R.string.txtQ8),Toast.LENGTH_SHORT).show()
                                        } else {
                                            val result =RespQ1Q8.toString()
                                            setFragmentResult("requestKey8", bundleOf("Menqol" to result))
                                            if (RespQ1Q9 == 9) {
                                                Toast.makeText(requireContext(), getString(R.string.txtQ9), Toast.LENGTH_SHORT).show()
                                            } else {
                                                val result =RespQ1Q9.toString()
                                                setFragmentResult("requestKey9", bundleOf("Menqol" to result))
                                                if (RespQ1Q10 == 9) {
                                                    Toast.makeText(requireContext(), getString(R.string.txtQ10), Toast.LENGTH_SHORT).show()
                                                } else {
                                                    val result =RespQ1Q10.toString()
                                                    setFragmentResult("requestKey10", bundleOf("Menqol" to result))
                                                    if (RespQ1Q11 == 9) {
                                                        Toast.makeText(requireContext(), getString(R.string.txtQ11), Toast.LENGTH_SHORT).show()
                                                    } else {
                                                        val result =RespQ1Q11.toString()
                                                        setFragmentResult("requestKey11", bundleOf("Menqol" to result))
                                                        if (RespQ1Q12 == 9) {
                                                            Toast.makeText(requireContext(), getString(R.string.txtQ12), Toast.LENGTH_SHORT).show()
                                                        } else {
                                                            val result =RespQ1Q12.toString()
                                                            setFragmentResult("requestKey12", bundleOf("Menqol" to result))
                                                            if (RespQ1Q13 == 9) {
                                                                Toast.makeText(requireContext(), getString(R.string.txtQ13), Toast.LENGTH_SHORT).show()
                                                            } else {
                                                                val result =RespQ1Q13.toString()
                                                                setFragmentResult("requestKey13", bundleOf("Menqol" to result))
                                                                if (RespQ1Q14 == 9) {
                                                                    Toast.makeText(requireContext(), getString(R.string.txtQ14), Toast.LENGTH_SHORT).show()
                                                                } else {
                                                                    val result =RespQ1Q14.toString()
                                                                    setFragmentResult("requestKey14", bundleOf("Menqol" to result))
                                                                    if (RespQ1Q15 == 9) {
                                                                        Toast.makeText(requireContext(), getString(R.string.txtQ15), Toast.LENGTH_SHORT).show()
                                                                    } else {
                                                                        val result =RespQ1Q15.toString()
                                                                        setFragmentResult("requestKey15", bundleOf("Menqol" to result))
                                                                        setFragment(menqol2Fragment)
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
    private fun setCheckedrdgQ1Q1() {
        rdgQ1Q1.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q1opt0 == checkedId) {
                RespQ1Q1 = 0
            } else if (R.id.Q1Q1opt1 == checkedId) {
                RespQ1Q1 = 1
            } else if (R.id.Q1Q1opt2 == checkedId) {
                RespQ1Q1 = 2
            } else if (R.id.Q1Q1opt3 == checkedId) {
                RespQ1Q1 = 3
            } else if (R.id.Q1Q1opt4 == checkedId) {
                RespQ1Q1 = 4
            } else if (R.id.Q1Q1opt5 == checkedId) {
                RespQ1Q1 = 5
            } else if (R.id.Q1Q1opt6 == checkedId) {
                RespQ1Q1 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q2() {
        rdgQ1Q2.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q2opt0 == checkedId){
                RespQ1Q2 = 0
            }else if (R.id.Q1Q2opt1 == checkedId){
                RespQ1Q2 = 1
            }else if (R.id.Q1Q2opt2 == checkedId){
                RespQ1Q2 = 2
            }else if (R.id.Q1Q2opt3 == checkedId){
                RespQ1Q2 = 3
            }else if (R.id.Q1Q2opt4 == checkedId){
                RespQ1Q2 = 4
            }else if (R.id.Q1Q2opt5 == checkedId){
                RespQ1Q2 = 5
            }else if (R.id.Q1Q2opt6 == checkedId){
                RespQ1Q2 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q3() {
        rdgQ1Q3.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q3opt0 == checkedId){
                RespQ1Q3 = 0
            }else if (R.id.Q1Q3opt1 == checkedId){
                RespQ1Q3 = 1
            }else if (R.id.Q1Q3opt2 == checkedId){
                RespQ1Q3 = 2
            }else if (R.id.Q1Q3opt3 == checkedId){
                RespQ1Q3 = 3
            }else if (R.id.Q1Q3opt4 == checkedId){
                RespQ1Q3 = 4
            }else if (R.id.Q1Q3opt5 == checkedId){
                RespQ1Q3 = 5
            }else if (R.id.Q1Q3opt6 == checkedId){
                RespQ1Q3 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q4() {
        rdgQ1Q4.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q4opt0 == checkedId){
                RespQ1Q4 = 0
            }else if (R.id.Q1Q4opt1 == checkedId){
                RespQ1Q4 = 1
            }else if (R.id.Q1Q4opt2 == checkedId){
                RespQ1Q4 = 2
            }else if (R.id.Q1Q4opt3 == checkedId){
                RespQ1Q4 = 3
            }else if (R.id.Q1Q4opt4 == checkedId){
                RespQ1Q4 = 4
            }else if (R.id.Q1Q4opt5 == checkedId){
                RespQ1Q4 = 5
            }else if (R.id.Q1Q4opt6 == checkedId){
                RespQ1Q4 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q5() {
        rdgQ1Q5.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q5opt0 == checkedId){
                RespQ1Q5 = 0
            }else if (R.id.Q1Q5opt1 == checkedId){
                RespQ1Q5 = 1
            }else if (R.id.Q1Q5opt2 == checkedId){
                RespQ1Q5 = 2
            }else if (R.id.Q1Q5opt3 == checkedId){
                RespQ1Q5 = 3
            }else if (R.id.Q1Q5opt4 == checkedId){
                RespQ1Q5 = 4
            }else if (R.id.Q1Q5opt5 == checkedId){
                RespQ1Q5 = 5
            }else if (R.id.Q1Q5opt6 == checkedId){
                RespQ1Q5 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q6() {
        rdgQ1Q6.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q6opt0 == checkedId){
                RespQ1Q6 = 0
            }else if (R.id.Q1Q6opt1 == checkedId){
                RespQ1Q6 = 1
            }else if (R.id.Q1Q6opt2 == checkedId){
                RespQ1Q6 = 2
            }else if (R.id.Q1Q6opt3 == checkedId){
                RespQ1Q6 = 3
            }else if (R.id.Q1Q6opt4 == checkedId){
                RespQ1Q6 = 4
            }else if (R.id.Q1Q6opt5 == checkedId){
                RespQ1Q6 = 5
            }else if (R.id.Q1Q6opt6 == checkedId){
                RespQ1Q6 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q7() {
        rdgQ1Q7.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q7opt0 == checkedId){
                RespQ1Q7 = 0
            }else if (R.id.Q1Q7opt1 == checkedId){
                RespQ1Q7 = 1
            }else if (R.id.Q1Q7opt2 == checkedId){
                RespQ1Q7 = 2
            }else if (R.id.Q1Q7opt3 == checkedId){
                RespQ1Q7 = 3
            }else if (R.id.Q1Q7opt4 == checkedId){
                RespQ1Q7 = 4
            }else if (R.id.Q1Q7opt5 == checkedId){
                RespQ1Q7 = 5
            }else if (R.id.Q1Q7opt6 == checkedId){
                RespQ1Q7 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q8() {
        rdgQ1Q8.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q8opt0 == checkedId){
                RespQ1Q8 = 0
            }else if (R.id.Q1Q8opt1 == checkedId){
                RespQ1Q8 = 1
            }else if (R.id.Q1Q8opt2 == checkedId){
                RespQ1Q8 = 2
            }else if (R.id.Q1Q8opt3 == checkedId){
                RespQ1Q8 = 3
            }else if (R.id.Q1Q8opt4 == checkedId){
                RespQ1Q8 = 4
            }else if (R.id.Q1Q8opt5 == checkedId){
                RespQ1Q8 = 5
            }else if (R.id.Q1Q8opt6 == checkedId){
                RespQ1Q8 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q9() {
        rdgQ1Q9.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q9opt0 == checkedId){
                RespQ1Q9 = 0
            }else if (R.id.Q1Q9opt1 == checkedId){
                RespQ1Q9 = 1
            }else if (R.id.Q1Q9opt2 == checkedId){
                RespQ1Q9 = 2
            }else if (R.id.Q1Q9opt3 == checkedId){
                RespQ1Q9 = 3
            }else if (R.id.Q1Q9opt4 == checkedId){
                RespQ1Q9 = 4
            }else if (R.id.Q1Q9opt5 == checkedId){
                RespQ1Q9 = 5
            }else if (R.id.Q1Q9opt6 == checkedId){
                RespQ1Q9 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q10() {
        rdgQ1Q10.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q10opt0 == checkedId){
                RespQ1Q10 = 0
            }else if (R.id.Q1Q10opt1 == checkedId){
                RespQ1Q10 = 1
            }else if (R.id.Q1Q10opt2 == checkedId){
                RespQ1Q10 = 2
            }else if (R.id.Q1Q10opt3 == checkedId){
                RespQ1Q10 = 3
            }else if (R.id.Q1Q10opt4 == checkedId){
                RespQ1Q10 = 4
            }else if (R.id.Q1Q10opt5 == checkedId){
                RespQ1Q10 = 5
            }else if (R.id.Q1Q10opt6 == checkedId){
                RespQ1Q10 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q11() {
        rdgQ1Q11.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q11opt0 == checkedId){
                RespQ1Q11 = 0
            }else if (R.id.Q1Q11opt1 == checkedId){
                RespQ1Q11 = 1
            }else if (R.id.Q1Q11opt2 == checkedId){
                RespQ1Q11 = 2
            }else if (R.id.Q1Q11opt3 == checkedId){
                RespQ1Q11 = 3
            }else if (R.id.Q1Q11opt4 == checkedId){
                RespQ1Q11 = 4
            }else if (R.id.Q1Q11opt5 == checkedId){
                RespQ1Q11 = 5
            }else if (R.id.Q1Q11opt6 == checkedId){
                RespQ1Q11 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q12() {
        rdgQ1Q12.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q12opt0 == checkedId){
                RespQ1Q12 = 0
            }else if (R.id.Q1Q12opt1 == checkedId){
                RespQ1Q12 = 1
            }else if (R.id.Q1Q12opt2 == checkedId){
                RespQ1Q12 = 2
            }else if (R.id.Q1Q12opt3 == checkedId){
                RespQ1Q12 = 3
            }else if (R.id.Q1Q12opt4 == checkedId){
                RespQ1Q12 = 4
            }else if (R.id.Q1Q12opt5 == checkedId){
                RespQ1Q12 = 5
            }else if (R.id.Q1Q12opt6 == checkedId){
                RespQ1Q12 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q13() {
        rdgQ1Q13.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q13opt0 == checkedId){
                RespQ1Q13 = 0
            }else if (R.id.Q1Q13opt1 == checkedId){
                RespQ1Q13 = 1
            }else if (R.id.Q1Q13opt2 == checkedId){
                RespQ1Q13 = 2
            }else if (R.id.Q1Q13opt3 == checkedId){
                RespQ1Q13 = 3
            }else if (R.id.Q1Q13opt4 == checkedId){
                RespQ1Q13 = 4
            }else if (R.id.Q1Q13opt5 == checkedId){
                RespQ1Q13 = 5
            }else if (R.id.Q1Q13opt6 == checkedId){
                RespQ1Q13 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q14() {
        rdgQ1Q14.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q14opt0 == checkedId){
                RespQ1Q14 = 0
            }else if (R.id.Q1Q14opt1 == checkedId){
                RespQ1Q14 = 1
            }else if (R.id.Q1Q14opt2 == checkedId){
                RespQ1Q14 = 2
            }else if (R.id.Q1Q14opt3 == checkedId){
                RespQ1Q14 = 3
            }else if (R.id.Q1Q14opt4 == checkedId){
                RespQ1Q14 = 4
            }else if (R.id.Q1Q14opt5 == checkedId){
                RespQ1Q14 = 5
            }else if (R.id.Q1Q14opt6 == checkedId){
                RespQ1Q14 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q15() {
        rdgQ1Q15.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q15opt0 == checkedId){
                RespQ1Q15 = 0
            }else if (R.id.Q1Q15opt1 == checkedId){
                RespQ1Q15 = 1
            }else if (R.id.Q1Q15opt2 == checkedId){
                RespQ1Q15 = 2
            }else if (R.id.Q1Q15opt3 == checkedId){
                RespQ1Q15 = 3
            }else if (R.id.Q1Q15opt4 == checkedId){
                RespQ1Q15 = 4
            }else if (R.id.Q1Q15opt5 == checkedId){
                RespQ1Q15 = 5
            }else if (R.id.Q1Q15opt6 == checkedId){
                RespQ1Q15 = 6
            }
        }
    }
    private fun setFragment(fragment: Fragment){
        val fT = requireActivity().supportFragmentManager.beginTransaction()
        fT.replace(R.id.nav_host_fragment_content_principal, fragment)
        fT.commit()
    }
}