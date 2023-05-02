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
import androidx.fragment.app.setFragmentResultListener
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.lavita.menofeme.R
import com.lavita.menofeme.view.ui.home.HomeFragment
import java.text.SimpleDateFormat
import java.util.*

class Menqol2Fragment : Fragment() {
    private lateinit var pegarView: View
    private val db = FirebaseFirestore.getInstance()
    private lateinit var btnAnalise:androidx.appcompat.widget.AppCompatButton
    private lateinit var rdgQ1Q16: RadioGroup
    private lateinit var rdgQ1Q17: RadioGroup
    private lateinit var rdgQ1Q18: RadioGroup
    private lateinit var rdgQ1Q19: RadioGroup
    private lateinit var rdgQ1Q20: RadioGroup
    private lateinit var rdgQ1Q21: RadioGroup
    private lateinit var rdgQ1Q22: RadioGroup
    private lateinit var rdgQ1Q23: RadioGroup
    private lateinit var rdgQ1Q24: RadioGroup
    private lateinit var rdgQ1Q25: RadioGroup
    private lateinit var rdgQ1Q26: RadioGroup
    private lateinit var rdgQ1Q27: RadioGroup
    private lateinit var rdgQ1Q28: RadioGroup
    private lateinit var rdgQ1Q29: RadioGroup
    private lateinit var Q1Q16opt0: RadioButton
    private lateinit var Q1Q16opt1: RadioButton
    private lateinit var Q1Q16opt2: RadioButton
    private lateinit var Q1Q16opt3: RadioButton
    private lateinit var Q1Q16opt4: RadioButton
    private lateinit var Q1Q16opt5: RadioButton
    private lateinit var Q1Q16opt6: RadioButton
    private lateinit var Q1Q17opt0: RadioButton
    private lateinit var Q1Q17opt1: RadioButton
    private lateinit var Q1Q17opt2: RadioButton
    private lateinit var Q1Q17opt3: RadioButton
    private lateinit var Q1Q17opt4: RadioButton
    private lateinit var Q1Q17opt5: RadioButton
    private lateinit var Q1Q17opt6: RadioButton
    private lateinit var Q1Q18opt0: RadioButton
    private lateinit var Q1Q18opt1: RadioButton
    private lateinit var Q1Q18opt2: RadioButton
    private lateinit var Q1Q18opt3: RadioButton
    private lateinit var Q1Q18opt4: RadioButton
    private lateinit var Q1Q18opt5: RadioButton
    private lateinit var Q1Q18opt6: RadioButton
    private lateinit var Q1Q19opt0: RadioButton
    private lateinit var Q1Q19opt1: RadioButton
    private lateinit var Q1Q19opt2: RadioButton
    private lateinit var Q1Q19opt3: RadioButton
    private lateinit var Q1Q19opt4: RadioButton
    private lateinit var Q1Q19opt5: RadioButton
    private lateinit var Q1Q19opt6: RadioButton
    private lateinit var Q1Q20opt0: RadioButton
    private lateinit var Q1Q20opt1: RadioButton
    private lateinit var Q1Q20opt2: RadioButton
    private lateinit var Q1Q20opt3: RadioButton
    private lateinit var Q1Q20opt4: RadioButton
    private lateinit var Q1Q20opt5: RadioButton
    private lateinit var Q1Q20opt6: RadioButton
    private lateinit var Q1Q21opt0: RadioButton
    private lateinit var Q1Q21opt1: RadioButton
    private lateinit var Q1Q21opt2: RadioButton
    private lateinit var Q1Q21opt3: RadioButton
    private lateinit var Q1Q21opt4: RadioButton
    private lateinit var Q1Q21opt5: RadioButton
    private lateinit var Q1Q21opt6: RadioButton
    private lateinit var Q1Q22opt0: RadioButton
    private lateinit var Q1Q22opt1: RadioButton
    private lateinit var Q1Q22opt2: RadioButton
    private lateinit var Q1Q22opt3: RadioButton
    private lateinit var Q1Q22opt4: RadioButton
    private lateinit var Q1Q22opt5: RadioButton
    private lateinit var Q1Q22opt6: RadioButton
    private lateinit var Q1Q23opt0: RadioButton
    private lateinit var Q1Q23opt1: RadioButton
    private lateinit var Q1Q23opt2: RadioButton
    private lateinit var Q1Q23opt3: RadioButton
    private lateinit var Q1Q23opt4: RadioButton
    private lateinit var Q1Q23opt5: RadioButton
    private lateinit var Q1Q23opt6: RadioButton
    private lateinit var Q1Q24opt0: RadioButton
    private lateinit var Q1Q24opt1: RadioButton
    private lateinit var Q1Q24opt2: RadioButton
    private lateinit var Q1Q24opt3: RadioButton
    private lateinit var Q1Q24opt4: RadioButton
    private lateinit var Q1Q24opt5: RadioButton
    private lateinit var Q1Q24opt6: RadioButton
    private lateinit var Q1Q25opt0: RadioButton
    private lateinit var Q1Q25opt1: RadioButton
    private lateinit var Q1Q25opt2: RadioButton
    private lateinit var Q1Q25opt3: RadioButton
    private lateinit var Q1Q25opt4: RadioButton
    private lateinit var Q1Q25opt5: RadioButton
    private lateinit var Q1Q25opt6: RadioButton
    private lateinit var Q1Q26opt0: RadioButton
    private lateinit var Q1Q26opt1: RadioButton
    private lateinit var Q1Q26opt2: RadioButton
    private lateinit var Q1Q26opt3: RadioButton
    private lateinit var Q1Q26opt4: RadioButton
    private lateinit var Q1Q26opt5: RadioButton
    private lateinit var Q1Q26opt6: RadioButton
    private lateinit var Q1Q27opt0: RadioButton
    private lateinit var Q1Q27opt1: RadioButton
    private lateinit var Q1Q27opt2: RadioButton
    private lateinit var Q1Q27opt3: RadioButton
    private lateinit var Q1Q27opt4: RadioButton
    private lateinit var Q1Q27opt5: RadioButton
    private lateinit var Q1Q27opt6: RadioButton
    private lateinit var Q1Q28opt0: RadioButton
    private lateinit var Q1Q28opt1: RadioButton
    private lateinit var Q1Q28opt2: RadioButton
    private lateinit var Q1Q28opt3: RadioButton
    private lateinit var Q1Q28opt4: RadioButton
    private lateinit var Q1Q28opt5: RadioButton
    private lateinit var Q1Q28opt6: RadioButton
    private lateinit var Q1Q29opt0: RadioButton
    private lateinit var Q1Q29opt1: RadioButton
    private lateinit var Q1Q29opt2: RadioButton
    private lateinit var Q1Q29opt3: RadioButton
    private lateinit var Q1Q29opt4: RadioButton
    private lateinit var Q1Q29opt5: RadioButton
    private lateinit var Q1Q29opt6: RadioButton
    private lateinit var homeFragment: HomeFragment


    private var RespQ1Q16: Int = 9
    private var RespQ1Q17: Int = 9
    private var RespQ1Q18: Int = 9
    private var RespQ1Q19: Int = 9
    private var RespQ1Q20: Int = 9
    private var RespQ1Q21: Int = 9
    private var RespQ1Q22: Int = 9
    private var RespQ1Q23: Int = 9
    private var RespQ1Q24: Int = 9
    private var RespQ1Q25: Int = 9
    private var RespQ1Q26: Int = 9
    private var RespQ1Q27: Int = 9
    private var RespQ1Q28: Int = 9
    private var RespQ1Q29: Int = 9
    private var valorQ1Q16: Int = 9
    private var valorQ1Q17: Int = 9
    private var valorQ1Q18: Int = 9
    private var valorQ1Q19: Int = 9
    private var valorQ1Q20: Int = 9
    private var valorQ1Q21: Int = 9
    private var valorQ1Q22: Int = 9
    private var valorQ1Q23: Int = 9
    private var valorQ1Q24: Int = 9
    private var valorQ1Q25: Int = 9
    private var valorQ1Q26: Int = 9
    private var valorQ1Q27: Int = 9
    private var valorQ1Q28: Int = 9
    private var valorQ1Q29: Int = 9

    private lateinit var valorQ1Q1: String
    private lateinit var valorQ1Q2: String
    private lateinit var valorQ1Q3: String
    private lateinit var valorQ1Q4: String
    private lateinit var valorQ1Q5: String
    private lateinit var valorQ1Q6: String
    private lateinit var valorQ1Q7: String
    private lateinit var valorQ1Q8: String
    private lateinit var valorQ1Q9: String
    private lateinit var valorQ1Q10: String
    private lateinit var valorQ1Q11: String
    private lateinit var valorQ1Q12: String
    private lateinit var valorQ1Q13: String
    private lateinit var valorQ1Q14: String
    private lateinit var valorQ1Q15: String



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        pegarView = inflater.inflate(R.layout.fragment_menqol2, container, false)
        rdgQ1Q16 = pegarView.findViewById(R.id.rdgQ1Q16)
        rdgQ1Q17 = pegarView.findViewById(R.id.rdgQ1Q17)
        rdgQ1Q18 = pegarView.findViewById(R.id.rdgQ1Q18)
        rdgQ1Q19 = pegarView.findViewById(R.id.rdgQ1Q19)
        rdgQ1Q20 = pegarView.findViewById(R.id.rdgQ1Q20)
        rdgQ1Q21 = pegarView.findViewById(R.id.rdgQ1Q21)
        rdgQ1Q22 = pegarView.findViewById(R.id.rdgQ1Q22)
        rdgQ1Q23 = pegarView.findViewById(R.id.rdgQ1Q23)
        rdgQ1Q24 = pegarView.findViewById(R.id.rdgQ1Q24)
        rdgQ1Q25 = pegarView.findViewById(R.id.rdgQ1Q25)
        rdgQ1Q26 = pegarView.findViewById(R.id.rdgQ1Q26)
        rdgQ1Q27 = pegarView.findViewById(R.id.rdgQ1Q27)
        rdgQ1Q28 = pegarView.findViewById(R.id.rdgQ1Q28)
        rdgQ1Q29 = pegarView.findViewById(R.id.rdgQ1Q29)
        Q1Q16opt0 = pegarView.findViewById(R.id.Q1Q16opt0)
        Q1Q16opt1 = pegarView.findViewById(R.id.Q1Q16opt1)
        Q1Q16opt2 = pegarView.findViewById(R.id.Q1Q16opt2)
        Q1Q16opt3 = pegarView.findViewById(R.id.Q1Q16opt3)
        Q1Q16opt4 = pegarView.findViewById(R.id.Q1Q16opt4)
        Q1Q16opt5 = pegarView.findViewById(R.id.Q1Q16opt5)
        Q1Q16opt6 = pegarView.findViewById(R.id.Q1Q16opt6)
        Q1Q17opt0 = pegarView.findViewById(R.id.Q1Q17opt0)
        Q1Q17opt1 = pegarView.findViewById(R.id.Q1Q17opt1)
        Q1Q17opt2 = pegarView.findViewById(R.id.Q1Q17opt2)
        Q1Q17opt3 = pegarView.findViewById(R.id.Q1Q17opt3)
        Q1Q17opt4 = pegarView.findViewById(R.id.Q1Q17opt4)
        Q1Q17opt5 = pegarView.findViewById(R.id.Q1Q17opt5)
        Q1Q17opt6 = pegarView.findViewById(R.id.Q1Q17opt6)
        Q1Q18opt0 = pegarView.findViewById(R.id.Q1Q18opt0)
        Q1Q18opt1 = pegarView.findViewById(R.id.Q1Q18opt1)
        Q1Q18opt2 = pegarView.findViewById(R.id.Q1Q18opt2)
        Q1Q18opt3 = pegarView.findViewById(R.id.Q1Q18opt3)
        Q1Q18opt4 = pegarView.findViewById(R.id.Q1Q18opt4)
        Q1Q18opt5 = pegarView.findViewById(R.id.Q1Q18opt5)
        Q1Q18opt6 = pegarView.findViewById(R.id.Q1Q18opt6)
        Q1Q19opt0 = pegarView.findViewById(R.id.Q1Q19opt0)
        Q1Q19opt1 = pegarView.findViewById(R.id.Q1Q19opt1)
        Q1Q19opt2 = pegarView.findViewById(R.id.Q1Q19opt2)
        Q1Q19opt3 = pegarView.findViewById(R.id.Q1Q19opt3)
        Q1Q19opt4 = pegarView.findViewById(R.id.Q1Q19opt4)
        Q1Q19opt5 = pegarView.findViewById(R.id.Q1Q19opt5)
        Q1Q19opt6 = pegarView.findViewById(R.id.Q1Q19opt6)
        Q1Q20opt0 = pegarView.findViewById(R.id.Q1Q20opt0)
        Q1Q20opt1 = pegarView.findViewById(R.id.Q1Q20opt1)
        Q1Q20opt2 = pegarView.findViewById(R.id.Q1Q20opt2)
        Q1Q20opt3 = pegarView.findViewById(R.id.Q1Q20opt3)
        Q1Q20opt4 = pegarView.findViewById(R.id.Q1Q20opt4)
        Q1Q20opt5 = pegarView.findViewById(R.id.Q1Q20opt5)
        Q1Q20opt6 = pegarView.findViewById(R.id.Q1Q20opt6)
        Q1Q21opt0 = pegarView.findViewById(R.id.Q1Q21opt0)
        Q1Q21opt1 = pegarView.findViewById(R.id.Q1Q21opt1)
        Q1Q21opt2 = pegarView.findViewById(R.id.Q1Q21opt2)
        Q1Q21opt3 = pegarView.findViewById(R.id.Q1Q21opt3)
        Q1Q21opt4 = pegarView.findViewById(R.id.Q1Q21opt4)
        Q1Q21opt5 = pegarView.findViewById(R.id.Q1Q21opt5)
        Q1Q21opt6 = pegarView.findViewById(R.id.Q1Q21opt6)
        Q1Q22opt0 = pegarView.findViewById(R.id.Q1Q22opt0)
        Q1Q22opt1 = pegarView.findViewById(R.id.Q1Q22opt1)
        Q1Q22opt2 = pegarView.findViewById(R.id.Q1Q22opt2)
        Q1Q22opt3 = pegarView.findViewById(R.id.Q1Q22opt3)
        Q1Q22opt4 = pegarView.findViewById(R.id.Q1Q22opt4)
        Q1Q22opt5 = pegarView.findViewById(R.id.Q1Q22opt5)
        Q1Q22opt6 = pegarView.findViewById(R.id.Q1Q22opt6)
        Q1Q23opt0 = pegarView.findViewById(R.id.Q1Q23opt0)
        Q1Q23opt1 = pegarView.findViewById(R.id.Q1Q23opt1)
        Q1Q23opt2 = pegarView.findViewById(R.id.Q1Q23opt2)
        Q1Q23opt3 = pegarView.findViewById(R.id.Q1Q23opt3)
        Q1Q23opt4 = pegarView.findViewById(R.id.Q1Q23opt4)
        Q1Q23opt5 = pegarView.findViewById(R.id.Q1Q23opt5)
        Q1Q23opt6 = pegarView.findViewById(R.id.Q1Q23opt6)
        Q1Q24opt0 = pegarView.findViewById(R.id.Q1Q24opt0)
        Q1Q24opt1 = pegarView.findViewById(R.id.Q1Q24opt1)
        Q1Q24opt2 = pegarView.findViewById(R.id.Q1Q24opt2)
        Q1Q24opt3 = pegarView.findViewById(R.id.Q1Q24opt3)
        Q1Q24opt4 = pegarView.findViewById(R.id.Q1Q24opt4)
        Q1Q24opt5 = pegarView.findViewById(R.id.Q1Q24opt5)
        Q1Q24opt6 = pegarView.findViewById(R.id.Q1Q24opt6)
        Q1Q25opt0 = pegarView.findViewById(R.id.Q1Q25opt0)
        Q1Q25opt1 = pegarView.findViewById(R.id.Q1Q25opt1)
        Q1Q25opt2 = pegarView.findViewById(R.id.Q1Q25opt2)
        Q1Q25opt3 = pegarView.findViewById(R.id.Q1Q25opt3)
        Q1Q25opt4 = pegarView.findViewById(R.id.Q1Q25opt4)
        Q1Q25opt5 = pegarView.findViewById(R.id.Q1Q25opt5)
        Q1Q25opt6 = pegarView.findViewById(R.id.Q1Q25opt6)
        Q1Q26opt0 = pegarView.findViewById(R.id.Q1Q26opt0)
        Q1Q26opt1 = pegarView.findViewById(R.id.Q1Q26opt1)
        Q1Q26opt2 = pegarView.findViewById(R.id.Q1Q26opt2)
        Q1Q26opt3 = pegarView.findViewById(R.id.Q1Q26opt3)
        Q1Q26opt4 = pegarView.findViewById(R.id.Q1Q26opt4)
        Q1Q26opt5 = pegarView.findViewById(R.id.Q1Q26opt5)
        Q1Q26opt6 = pegarView.findViewById(R.id.Q1Q26opt6)
        Q1Q27opt0 = pegarView.findViewById(R.id.Q1Q27opt0)
        Q1Q27opt1 = pegarView.findViewById(R.id.Q1Q27opt1)
        Q1Q27opt2 = pegarView.findViewById(R.id.Q1Q27opt2)
        Q1Q27opt3 = pegarView.findViewById(R.id.Q1Q27opt3)
        Q1Q27opt4 = pegarView.findViewById(R.id.Q1Q27opt4)
        Q1Q27opt5 = pegarView.findViewById(R.id.Q1Q27opt5)
        Q1Q27opt6 = pegarView.findViewById(R.id.Q1Q27opt6)
        Q1Q28opt0 = pegarView.findViewById(R.id.Q1Q28opt0)
        Q1Q28opt1 = pegarView.findViewById(R.id.Q1Q28opt1)
        Q1Q28opt2 = pegarView.findViewById(R.id.Q1Q28opt2)
        Q1Q28opt3 = pegarView.findViewById(R.id.Q1Q28opt3)
        Q1Q28opt4 = pegarView.findViewById(R.id.Q1Q28opt4)
        Q1Q28opt5 = pegarView.findViewById(R.id.Q1Q28opt5)
        Q1Q28opt6 = pegarView.findViewById(R.id.Q1Q28opt6)
        Q1Q29opt0 = pegarView.findViewById(R.id.Q1Q29opt0)
        Q1Q29opt1 = pegarView.findViewById(R.id.Q1Q29opt1)
        Q1Q29opt2 = pegarView.findViewById(R.id.Q1Q29opt2)
        Q1Q29opt3 = pegarView.findViewById(R.id.Q1Q29opt3)
        Q1Q29opt4 = pegarView.findViewById(R.id.Q1Q29opt4)
        Q1Q29opt5 = pegarView.findViewById(R.id.Q1Q29opt5)
        Q1Q29opt6 = pegarView.findViewById(R.id.Q1Q29opt6)
        btnAnalise = pegarView.findViewById(R.id.btnAnaliseMenqol)
        homeFragment = HomeFragment()


        setFragmentResultListener("requestKey1") { _, bundle ->
            val result = bundle.getString(("Menqol"))
            valorQ1Q1 = result.toString()
        }
        setFragmentResultListener("requestKey2") { _, bundle ->
            val result = bundle.getString(("Menqol"))
            valorQ1Q2 = result.toString()
        }
        setFragmentResultListener("requestKey3") { _, bundle ->
            val result = bundle.getString(("Menqol"))
            valorQ1Q3 = result.toString()
        }
        setFragmentResultListener("requestKey4") { _, bundle ->
            val result = bundle.getString(("Menqol"))
            valorQ1Q4 = result.toString()
        }
        setFragmentResultListener("requestKey5") { _, bundle ->
            val result = bundle.getString(("Menqol"))
            valorQ1Q5 = result.toString()
        }
        setFragmentResultListener("requestKey6") { _, bundle ->
            val result = bundle.getString(("Menqol"))
            valorQ1Q6 = result.toString()
        }
        setFragmentResultListener("requestKey7") { _, bundle ->
            val result = bundle.getString(("Menqol"))
            valorQ1Q7 = result.toString()
        }
        setFragmentResultListener("requestKey8") { _, bundle ->
            val result = bundle.getString(("Menqol"))
            valorQ1Q8 = result.toString()
        }
        setFragmentResultListener("requestKey9") { _, bundle ->
            val result = bundle.getString(("Menqol"))
            valorQ1Q9 = result.toString()
        }
        setFragmentResultListener("requestKey10") { _, bundle ->
            val result = bundle.getString(("Menqol"))
            valorQ1Q10 = result.toString()
        }
        setFragmentResultListener("requestKey11") { _, bundle ->
            val result = bundle.getString(("Menqol"))
            valorQ1Q11 = result.toString()
        }
        setFragmentResultListener("requestKey12") { _, bundle ->
            val result = bundle.getString(("Menqol"))
            valorQ1Q12 = result.toString()
        }
        setFragmentResultListener("requestKey13") { _, bundle ->
            val result = bundle.getString(("Menqol"))
            valorQ1Q13 = result.toString()
        }
        setFragmentResultListener("requestKey14") { _, bundle ->
            val result = bundle.getString(("Menqol"))
            valorQ1Q14 = result.toString()
        }
        setFragmentResultListener("requestKey15") { _, bundle ->
            val result = bundle.getString(("Menqol"))
            valorQ1Q15 = result.toString()
        }

        setCheckedrdgQ1Q16()
        setCheckedrdgQ1Q17()
        setCheckedrdgQ1Q18()
        setCheckedrdgQ1Q19()
        setCheckedrdgQ1Q20()
        setCheckedrdgQ1Q21()
        setCheckedrdgQ1Q22()
        setCheckedrdgQ1Q23()
        setCheckedrdgQ1Q24()
        setCheckedrdgQ1Q25()
        setCheckedrdgQ1Q26()
        setCheckedrdgQ1Q27()
        setCheckedrdgQ1Q28()
        setCheckedrdgQ1Q29()

        btnAnalise.setOnClickListener {
            if (RespQ1Q16 == 9) {
                Toast.makeText(requireContext(), getString(R.string.txtQ16), Toast.LENGTH_SHORT)
                    .show()
            } else {
                valorQ1Q16 = RespQ1Q16
                if (RespQ1Q17 == 9) {
                    Toast.makeText(requireContext(), getString(R.string.txtQ17), Toast.LENGTH_SHORT)
                        .show()
                } else {
                    valorQ1Q17 = RespQ1Q17
                    if (RespQ1Q18 == 9) {
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.txtQ18),
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        valorQ1Q18 = RespQ1Q18
                        if (RespQ1Q19 == 9) {
                            Toast.makeText(
                                requireContext(),
                                getString(R.string.txtQ19),
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            valorQ1Q19 = RespQ1Q19
                            if (RespQ1Q20 == 9) {
                                Toast.makeText(
                                    requireContext(),
                                    getString(R.string.txtQ20),
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                valorQ1Q20 = RespQ1Q20
                                if (RespQ1Q21 == 9) {
                                    Toast.makeText(
                                        requireContext(),
                                        getString(R.string.txtQ21),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    valorQ1Q21 = RespQ1Q21
                                    if (RespQ1Q22 == 9) {
                                        Toast.makeText(
                                            requireContext(),
                                            getString(R.string.txtQ22),
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    } else {
                                        valorQ1Q22 = RespQ1Q22
                                        if (RespQ1Q23 == 9) {
                                            Toast.makeText(
                                                requireContext(),
                                                getString(R.string.txtQ23),
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        } else {
                                            valorQ1Q23 = RespQ1Q23
                                            if (RespQ1Q24 == 9) {
                                                Toast.makeText(
                                                    requireContext(),
                                                    getString(R.string.txtQ24),
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            } else {
                                                valorQ1Q24 = RespQ1Q24
                                                if (RespQ1Q25 == 9) {
                                                    Toast.makeText(
                                                        requireContext(),
                                                        getString(R.string.txtQ25),
                                                        Toast.LENGTH_SHORT
                                                    ).show()
                                                } else {
                                                    valorQ1Q25 = RespQ1Q25
                                                    if (RespQ1Q26 == 9) {
                                                        Toast.makeText(
                                                            requireContext(),
                                                            getString(R.string.txtQ26),
                                                            Toast.LENGTH_SHORT
                                                        ).show()
                                                    } else {
                                                        valorQ1Q26 = RespQ1Q26
                                                        if (RespQ1Q27 == 9) {
                                                            Toast.makeText(
                                                                requireContext(),
                                                                getString(R.string.txtQ27),
                                                                Toast.LENGTH_SHORT
                                                            ).show()
                                                        } else {
                                                            valorQ1Q27 = RespQ1Q27
                                                            if (RespQ1Q28 == 9) {
                                                                Toast.makeText(
                                                                    requireContext(),
                                                                    getString(R.string.txtQ28),
                                                                    Toast.LENGTH_SHORT
                                                                ).show()
                                                            } else {
                                                                valorQ1Q28 = RespQ1Q28
                                                                if (RespQ1Q29 == 9) {
                                                                    Toast.makeText(
                                                                        requireContext(),
                                                                        getString(R.string.txtQ29),
                                                                        Toast.LENGTH_SHORT
                                                                    ).show()
                                                                } else {
                                                                    valorQ1Q29 = RespQ1Q29
                                                                    AlertDialog.Builder(requireContext())
                                                                        .setTitle(R.string.menu_app)
                                                                        .setMessage(R.string.txtFinal1)
                                                                        .setPositiveButton(R.string.btnOk) { _, _ ->
                                                                            //Criando um coleção
                                                                            val user =
                                                                                Firebase.auth.currentUser
                                                                            user?.let {
                                                                                val email = it.email
                                                                                db.collection("User")
                                                                                    .document(email.toString())
                                                                                    .addSnapshotListener { documento, _ ->
                                                                                        if (documento != null) {
                                                                                            val nome =
                                                                                                documento.getString(
                                                                                                    "Nome"
                                                                                                )
                                                                                            val emailMenqol =
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
                                                                                            val idMenqol =
                                                                                                db.collection(
                                                                                                    "Menqol"
                                                                                                )
                                                                                                    .document().id

                                                                                            val menqolMap =
                                                                                                hashMapOf(
                                                                                                    "idMenqol" to idMenqol,
                                                                                                    "Nome" to nome.toString(),
                                                                                                    "Email" to emailMenqol.toString(),
                                                                                                    "Data" to txtData.toString(),
                                                                                                    "Hora" to txtHora.toString(),
                                                                                                    "Questao_01" to valorQ1Q1.toString(),
                                                                                                    "Questao_02" to valorQ1Q2.toString(),
                                                                                                    "Questao_03" to valorQ1Q3.toString(),
                                                                                                    "Questao_04" to valorQ1Q4.toString(),
                                                                                                    "Questao_05" to valorQ1Q5.toString(),
                                                                                                    "Questao_06" to valorQ1Q6.toString(),
                                                                                                    "Questao_07" to valorQ1Q7.toString(),
                                                                                                    "Questao_08" to valorQ1Q8.toString(),
                                                                                                    "Questao_09" to valorQ1Q9.toString(),
                                                                                                    "Questao_10" to valorQ1Q10.toString(),
                                                                                                    "Questao_11" to valorQ1Q11.toString(),
                                                                                                    "Questao_12" to valorQ1Q12.toString(),
                                                                                                    "Questao_13" to valorQ1Q13.toString(),
                                                                                                    "Questao_14" to valorQ1Q14.toString(),
                                                                                                    "Questao_15" to valorQ1Q15.toString(),
                                                                                                    "Questao_16" to valorQ1Q16.toString(),
                                                                                                    "Questao_17" to valorQ1Q17.toString(),
                                                                                                    "Questao_18" to valorQ1Q18.toString(),
                                                                                                    "Questao_19" to valorQ1Q19.toString(),
                                                                                                    "Questao_20" to valorQ1Q20.toString(),
                                                                                                    "Questao_21" to valorQ1Q21.toString(),
                                                                                                    "Questao_22" to valorQ1Q22.toString(),
                                                                                                    "Questao_23" to valorQ1Q23.toString(),
                                                                                                    "Questao_24" to valorQ1Q24.toString(),
                                                                                                    "Questao_25" to valorQ1Q25.toString(),
                                                                                                    "Questao_26" to valorQ1Q26.toString(),
                                                                                                    "Questao_27" to valorQ1Q27.toString(),
                                                                                                    "Questao_28" to valorQ1Q28.toString(),
                                                                                                    "Questao_29" to valorQ1Q29.toString()
                                                                                                )
                                                                                            db.collection("Menqol").document(idMenqol).set(menqolMap)
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

        return pegarView
    }
    private fun setCheckedrdgQ1Q16() {
        rdgQ1Q16.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q16opt0 == checkedId) {
                RespQ1Q16 = 0
            } else if (R.id.Q1Q16opt1 == checkedId) {
                RespQ1Q16 = 1
            } else if (R.id.Q1Q16opt2 == checkedId) {
                RespQ1Q16 = 2
            } else if (R.id.Q1Q16opt3 == checkedId) {
                RespQ1Q16 = 3
            } else if (R.id.Q1Q16opt4 == checkedId) {
                RespQ1Q16 = 4
            } else if (R.id.Q1Q16opt5 == checkedId) {
                RespQ1Q16 = 5
            } else if (R.id.Q1Q16opt6 == checkedId) {
                RespQ1Q16 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q17() {
        rdgQ1Q17.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q17opt0 == checkedId) {
                RespQ1Q17 = 0
            } else if (R.id.Q1Q17opt1 == checkedId) {
                RespQ1Q17 = 1
            } else if (R.id.Q1Q17opt2 == checkedId) {
                RespQ1Q17 = 2
            } else if (R.id.Q1Q17opt3 == checkedId) {
                RespQ1Q17 = 3
            } else if (R.id.Q1Q17opt4 == checkedId) {
                RespQ1Q17 = 4
            } else if (R.id.Q1Q17opt5 == checkedId) {
                RespQ1Q17 = 5
            } else if (R.id.Q1Q17opt6 == checkedId) {
                RespQ1Q17 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q18() {
        rdgQ1Q18.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q18opt0 == checkedId) {
                RespQ1Q18 = 0
            } else if (R.id.Q1Q18opt1 == checkedId) {
                RespQ1Q18 = 1
            } else if (R.id.Q1Q18opt2 == checkedId) {
                RespQ1Q18 = 2
            } else if (R.id.Q1Q18opt3 == checkedId) {
                RespQ1Q18 = 3
            } else if (R.id.Q1Q18opt4 == checkedId) {
                RespQ1Q18 = 4
            } else if (R.id.Q1Q18opt5 == checkedId) {
                RespQ1Q18 = 5
            } else if (R.id.Q1Q18opt6 == checkedId) {
                RespQ1Q18 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q19() {
        rdgQ1Q19.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q19opt0 == checkedId) {
                RespQ1Q19 = 0
            } else if (R.id.Q1Q19opt1 == checkedId) {
                RespQ1Q19 = 1
            } else if (R.id.Q1Q19opt2 == checkedId) {
                RespQ1Q19 = 2
            } else if (R.id.Q1Q19opt3 == checkedId) {
                RespQ1Q19 = 3
            } else if (R.id.Q1Q19opt4 == checkedId) {
                RespQ1Q19 = 4
            } else if (R.id.Q1Q19opt5 == checkedId) {
                RespQ1Q19 = 5
            } else if (R.id.Q1Q19opt6 == checkedId) {
                RespQ1Q19 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q20() {
        rdgQ1Q20.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q20opt0 == checkedId) {
                RespQ1Q20 = 0
            } else if (R.id.Q1Q20opt1 == checkedId) {
                RespQ1Q20 = 1
            } else if (R.id.Q1Q20opt2 == checkedId) {
                RespQ1Q20 = 2
            } else if (R.id.Q1Q20opt3 == checkedId) {
                RespQ1Q20 = 3
            } else if (R.id.Q1Q20opt4 == checkedId) {
                RespQ1Q20 = 4
            } else if (R.id.Q1Q20opt5 == checkedId) {
                RespQ1Q20 = 5
            } else if (R.id.Q1Q20opt6 == checkedId) {
                RespQ1Q20 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q21() {
        rdgQ1Q21.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q21opt0 == checkedId) {
                RespQ1Q21 = 0
            } else if (R.id.Q1Q21opt1 == checkedId) {
                RespQ1Q21 = 1
            } else if (R.id.Q1Q21opt2 == checkedId) {
                RespQ1Q21 = 2
            } else if (R.id.Q1Q21opt3 == checkedId) {
                RespQ1Q21 = 3
            } else if (R.id.Q1Q21opt4 == checkedId) {
                RespQ1Q21 = 4
            } else if (R.id.Q1Q21opt5 == checkedId) {
                RespQ1Q21 = 5
            } else if (R.id.Q1Q21opt6 == checkedId) {
                RespQ1Q21 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q22() {
        rdgQ1Q22.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q22opt0 == checkedId) {
                RespQ1Q22 = 0
            } else if (R.id.Q1Q22opt1 == checkedId) {
                RespQ1Q22 = 1
            } else if (R.id.Q1Q22opt2 == checkedId) {
                RespQ1Q22 = 2
            } else if (R.id.Q1Q22opt3 == checkedId) {
                RespQ1Q22 = 3
            } else if (R.id.Q1Q22opt4 == checkedId) {
                RespQ1Q22 = 4
            } else if (R.id.Q1Q22opt5 == checkedId) {
                RespQ1Q22 = 5
            } else if (R.id.Q1Q22opt6 == checkedId) {
                RespQ1Q22 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q23() {
        rdgQ1Q23.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q23opt0 == checkedId) {
                RespQ1Q23 = 0
            } else if (R.id.Q1Q23opt1 == checkedId) {
                RespQ1Q23 = 1
            } else if (R.id.Q1Q23opt2 == checkedId) {
                RespQ1Q23 = 2
            } else if (R.id.Q1Q23opt3 == checkedId) {
                RespQ1Q23 = 3
            } else if (R.id.Q1Q23opt4 == checkedId) {
                RespQ1Q23 = 4
            } else if (R.id.Q1Q23opt5 == checkedId) {
                RespQ1Q23 = 5
            } else if (R.id.Q1Q23opt6 == checkedId) {
                RespQ1Q23 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q24() {
        rdgQ1Q24.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q24opt0 == checkedId) {
                RespQ1Q24 = 0
            } else if (R.id.Q1Q24opt1 == checkedId) {
                RespQ1Q24 = 1
            } else if (R.id.Q1Q24opt2 == checkedId) {
                RespQ1Q24 = 2
            } else if (R.id.Q1Q24opt3 == checkedId) {
                RespQ1Q24 = 3
            } else if (R.id.Q1Q24opt4 == checkedId) {
                RespQ1Q24 = 4
            } else if (R.id.Q1Q24opt5 == checkedId) {
                RespQ1Q24 = 5
            } else if (R.id.Q1Q24opt6 == checkedId) {
                RespQ1Q24 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q25() {
        rdgQ1Q25.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q25opt0 == checkedId) {
                RespQ1Q25 = 0
            } else if (R.id.Q1Q25opt1 == checkedId) {
                RespQ1Q25 = 1
            } else if (R.id.Q1Q25opt2 == checkedId) {
                RespQ1Q25 = 2
            } else if (R.id.Q1Q25opt3 == checkedId) {
                RespQ1Q25 = 3
            } else if (R.id.Q1Q25opt4 == checkedId) {
                RespQ1Q25 = 4
            } else if (R.id.Q1Q25opt5 == checkedId) {
                RespQ1Q25 = 5
            } else if (R.id.Q1Q25opt6 == checkedId) {
                RespQ1Q25 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q26() {
        rdgQ1Q26.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q26opt0 == checkedId) {
                RespQ1Q26 = 0
            } else if (R.id.Q1Q26opt1 == checkedId) {
                RespQ1Q26 = 1
            } else if (R.id.Q1Q26opt2 == checkedId) {
                RespQ1Q26 = 2
            } else if (R.id.Q1Q26opt3 == checkedId) {
                RespQ1Q26 = 3
            } else if (R.id.Q1Q26opt4 == checkedId) {
                RespQ1Q26 = 4
            } else if (R.id.Q1Q26opt5 == checkedId) {
                RespQ1Q26 = 5
            } else if (R.id.Q1Q26opt6 == checkedId) {
                RespQ1Q26 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q27() {
        rdgQ1Q27.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q27opt0 == checkedId) {
                RespQ1Q27 = 0
            } else if (R.id.Q1Q27opt1 == checkedId) {
                RespQ1Q27 = 1
            } else if (R.id.Q1Q27opt2 == checkedId) {
                RespQ1Q27 = 2
            } else if (R.id.Q1Q27opt3 == checkedId) {
                RespQ1Q27 = 3
            } else if (R.id.Q1Q27opt4 == checkedId) {
                RespQ1Q27 = 4
            } else if (R.id.Q1Q27opt5 == checkedId) {
                RespQ1Q27 = 5
            } else if (R.id.Q1Q27opt6 == checkedId) {
                RespQ1Q27 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q28() {
        rdgQ1Q28.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q28opt0 == checkedId) {
                RespQ1Q28 = 0
            } else if (R.id.Q1Q28opt1 == checkedId) {
                RespQ1Q28 = 1
            } else if (R.id.Q1Q28opt2 == checkedId) {
                RespQ1Q28 = 2
            } else if (R.id.Q1Q28opt3 == checkedId) {
                RespQ1Q28 = 3
            } else if (R.id.Q1Q28opt4 == checkedId) {
                RespQ1Q28 = 4
            } else if (R.id.Q1Q28opt5 == checkedId) {
                RespQ1Q28 = 5
            } else if (R.id.Q1Q28opt6 == checkedId) {
                RespQ1Q28 = 6
            }
        }
    }
    private fun setCheckedrdgQ1Q29() {
        rdgQ1Q29.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.Q1Q29opt0 == checkedId) {
                RespQ1Q29 = 0
            } else if (R.id.Q1Q29opt1 == checkedId) {
                RespQ1Q29 = 1
            } else if (R.id.Q1Q29opt2 == checkedId) {
                RespQ1Q29 = 2
            } else if (R.id.Q1Q29opt3 == checkedId) {
                RespQ1Q29 = 3
            } else if (R.id.Q1Q29opt4 == checkedId) {
                RespQ1Q29 = 4
            } else if (R.id.Q1Q29opt5 == checkedId) {
                RespQ1Q29 = 5
            } else if (R.id.Q1Q29opt6 == checkedId) {
                RespQ1Q29 = 6
            }
        }
    }
    private fun setFragment(fragment: Fragment){
        val fT = requireActivity().supportFragmentManager.beginTransaction()
        fT.replace(R.id.nav_host_fragment_content_principal, fragment)
        fT.commit()
    }
}