package com.lavita.menofeme.view.ui.perfil

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.lavita.menofeme.R
import com.lavita.menofeme.view.ui.home.HomeFragment
import java.text.SimpleDateFormat
import java.util.*

class PerfilFragment : Fragment() {

    private lateinit var pegarView: View
    private lateinit var txtNome: EditText
    private lateinit var txtEmail: EditText
    private lateinit var btnNasc: ImageButton
    private lateinit var txtNasc: TextView
    private lateinit var txtPrimeira: EditText
    private lateinit var txtProfissao: EditText
    private lateinit var txtEtnia: Spinner
    private lateinit var auxEtnia: String
    private lateinit var btnAlterar: androidx.appcompat.widget.AppCompatButton
    private lateinit var btnAtualizar: androidx.appcompat.widget.AppCompatButton
    private val db = FirebaseFirestore.getInstance()
    private var dataNasc: Calendar = Calendar.getInstance()
    private lateinit var dbEmail:String
    private lateinit var homeFragment: HomeFragment


    override fun onCreateView(
       inflater: LayoutInflater,
       container: ViewGroup?,
       savedInstanceState: Bundle?): View {

        pegarView = inflater.inflate(R.layout.fragment_perfil, container, false)

        txtNome = pegarView.findViewById(R.id.txtNome)
        txtNome.isEnabled = false
        txtEmail = pegarView.findViewById(R.id.txtEmail)
        txtEmail.isEnabled = false
        btnNasc = pegarView.findViewById(R.id.btnNasc)
        btnNasc.isEnabled = false
        txtNasc = pegarView.findViewById(R.id.txtNasc)
        txtPrimeira = pegarView.findViewById(R.id.txtPrimeira)
        txtPrimeira.isEnabled = false
        txtProfissao = pegarView.findViewById(R.id.txtProf)
        txtProfissao.isEnabled = false
        txtEtnia = pegarView.findViewById(R.id.menuEtnia)
        txtEtnia.isEnabled = false
        btnAlterar = pegarView.findViewById(R.id.btnAlterar)
        btnAtualizar = pegarView.findViewById(R.id.btnAtualizar)
        txtNasc.visibility = View.VISIBLE
        homeFragment = HomeFragment()
        btnAtualizar.isEnabled = false
        btnAlterar.isEnabled = true

        lerDados()

        btnAtualizar.setTextColor(resources.getColor(R.color.gray))

        btnAlterar.setOnClickListener {
            txtNome.isEnabled = true
            btnNasc.isEnabled = true
            txtPrimeira.isEnabled = true
            txtProfissao.isEnabled = true
            txtEtnia.isEnabled = true
            btnAtualizar.isEnabled = true
            btnAlterar.isEnabled = false
            btnAtualizar.setTextColor(resources.getColor(R.color.padrao))
            btnAlterar.setTextColor(resources.getColor(R.color.gray))

            //Spinner

             /*   ArrayAdapter.createFromResource(requireContext(),  R.array.spinner_lista, android.R.layout.simple_spinner_item
                ).also { adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    txtEtnia.adapter = adapter

                    txtEtnia.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                            auxEtnia = txtEtnia.selectedItem.toString()
                        }
                        override fun onNothingSelected(p0: AdapterView<*>?) {
                        }
                    }
                }*/

            // Calendário

            val dateSetListener =
                DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                dataNasc.set(Calendar.YEAR,year)
                dataNasc.set(Calendar.MONTH, monthOfYear)
                dataNasc.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                dataNasc()
                }

            btnNasc.setOnClickListener {
                DatePickerDialog(
                requireContext(), R.style.DatePickerTheme, dateSetListener,
                dataNasc.get(Calendar.YEAR),
                dataNasc.get(Calendar.MONTH),
                dataNasc.get(Calendar.DAY_OF_MONTH))
                .show()
                }
        }

        btnAtualizar.setOnClickListener {
            db.collection("User").document(dbEmail).update("Nome", txtNome.text.toString())
            db.collection("User").document(dbEmail).update("dataNasc", txtNasc.text.toString())
            db.collection("User").document(dbEmail).update("Primeira", txtPrimeira.text.toString())
            db.collection("User").document(dbEmail).update("Profissao", txtProfissao.text.toString())
            setFragment(homeFragment)
        }

        return pegarView
   }

    private fun dataNasc(){
        val meuFormato = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(meuFormato, Locale.getDefault())
        txtNasc.text = sdf.format(dataNasc.time)
        txtNasc.visibility = View.VISIBLE
    }

    private fun lerDados() {
        val user = Firebase.auth.currentUser
        user?.let {
            val email = it.email
            db.collection("User")
                .whereEqualTo("Email", email.toString())
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        txtNome.setText(document.getString("Nome"))
                        txtEmail.setText(document.getString("Email"))
                        txtNasc.text = document.getString("dataNasc")
                        txtPrimeira.setText(document.getString("Primeira"))
                        txtProfissao.setText(document.getString("Profissao"))
                        auxEtnia = document.getString("Etnia").toString()
                        val email1 = document.getString(("Email"))
                        dbEmail = email1.toString()

                        ArrayAdapter.createFromResource(requireContext(), R.array.spinner_lista, android.R.layout.simple_spinner_item
                        ).also { adapter ->
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            txtEtnia.adapter = adapter

                            txtEtnia.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                                    when (auxEtnia) {
                                        "Branca" -> {
                                            txtEtnia.setSelection(1)
                                        }
                                        "Parda" -> {
                                            txtEtnia.setSelection(2)
                                        }
                                        "Negra" -> {
                                            txtEtnia.setSelection(3)
                                        }
                                        "Amarela" -> {
                                            txtEtnia.setSelection(4)
                                        }
                                        "Indígena" -> {
                                            txtEtnia.setSelection(5)
                                        }
                                        "Outra" -> {
                                            txtEtnia.setSelection(6)
                                        }
                                    }
                                }
                                override fun onNothingSelected(p1: AdapterView<*>?) {
                                }
                            }
                        }

                    }
                }
        }
    }
    private fun setFragment(fragment: Fragment){

        val fT = requireActivity().supportFragmentManager.beginTransaction()
        fT.replace(R.id.nav_host_fragment_content_principal, fragment)
        fT.commit()
    }
}