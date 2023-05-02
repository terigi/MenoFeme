package com.lavita.menofeme.view

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.firestore.FirebaseFirestore
import com.lavita.menofeme.R
import java.text.SimpleDateFormat
import java.util.*


class Cadastrar : AppCompatActivity() {
    private lateinit var txtNome: EditText
    private lateinit var txtEmail: EditText
    private lateinit var txtSenha: EditText
    private lateinit var btnNasc: ImageButton
    private lateinit var txtNasc: TextView
    private lateinit var txtPrimeira: EditText
    private lateinit var txtProfissao: EditText
    private lateinit var txtEtnia: Spinner
    lateinit var auxEtnia: String
    private lateinit var btnCadastrar: androidx.appcompat.widget.AppCompatButton
    private var dataNasc: Calendar = Calendar.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar)

        txtNome = findViewById(R.id.txtNome)
        txtEmail = findViewById(R.id.txtEmail)
        txtSenha = findViewById(R.id.txtSenha)
        btnNasc = findViewById(R.id.btnNasc)
        txtNasc = findViewById(R.id.txtNasc)
        txtPrimeira = findViewById(R.id.txtPrimeira)
        txtProfissao = findViewById(R.id.txtProf)
        txtEtnia = findViewById(R.id.menuEtnia)
        btnCadastrar = findViewById(R.id.btnCadastro)

        val teste = intent.extras

        val txtTermos = teste?.getString("Termos")

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
                this@Cadastrar, dateSetListener,
                dataNasc.get(Calendar.YEAR),
                dataNasc.get(Calendar.MONTH),
                dataNasc.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        //Spinner

        ArrayAdapter.createFromResource(this, R.array.spinner_lista, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            txtEtnia.adapter = adapter

            txtEtnia.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    auxEtnia = txtEtnia.selectedItem.toString()
                }
                override fun onNothingSelected(p1: AdapterView<*>?) {
                }
            }
        }
        btnCadastrar.setOnClickListener { view ->
            if (txtNome.text.isEmpty() || txtEmail.text.isEmpty() || txtSenha.text.isEmpty() || txtPrimeira.text.isEmpty() || txtProfissao.text.isEmpty()) {
                val textoErro = getString(R.string.erroDados)
                val mensagem =
                    Snackbar.make(
                        view,
                        textoErro,
                        Snackbar.LENGTH_SHORT
                    )
                mensagem.setBackgroundTint((Color.RED))
                mensagem.show()
            } else if (txtNasc.text == getString(R.string.debugNasc)) {
                val textoErro = getString(R.string.erroNasc)
                val mensagem =
                    Snackbar.make(
                        view,
                        textoErro,
                        Snackbar.LENGTH_SHORT
                    )
                mensagem.setBackgroundTint((Color.RED))
                mensagem.show()
            } else if (auxEtnia == getString((R.string.debugEtnia))) {
                val textoErro = getString(R.string.erroEtnia)
                val mensagem =
                    Snackbar.make(
                        view,
                        textoErro
                        , Snackbar.LENGTH_SHORT
                    )
                mensagem.setBackgroundTint((Color.RED))
                mensagem.show()
            } else {
                auth.createUserWithEmailAndPassword(
                    txtEmail.text.toString(),
                    txtSenha.text.toString()
                ).addOnCompleteListener { cadastro ->
                    if (cadastro.isSuccessful) {
                        val textoOk = getString(R.string.txtCadastroOk)
                        val mensagem =
                            Snackbar.make(view, textoOk, Snackbar.LENGTH_SHORT)
                        mensagem.setBackgroundTint(Color.BLUE)
                        mensagem.show()

                        //Criando um coleção

                        val txtData = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(System.currentTimeMillis())
                        val txtHora = SimpleDateFormat("HH:mm", Locale.getDefault()).format(System.currentTimeMillis())

                        val usuariosMap = hashMapOf(
                            "Termos" to txtTermos.toString(),
                            "Nome" to txtNome.text.toString(),
                            "Email" to txtEmail.text.toString(),
                            "dataNasc" to txtNasc.text.toString(),
                            "Primeira" to txtPrimeira.text.toString(),
                            "Profissao" to txtProfissao.text.toString(),
                            "Etnia" to auxEtnia,
                            "Data" to txtData.toString(),
                            "Hora" to txtHora.toString()

                        )
                        db.collection("User").document(txtEmail.text.toString())
                            .set(usuariosMap).addOnCompleteListener {

                            }.addOnFailureListener {

                            }
                        val intent = Intent(this, Principal::class.java)
                        startActivity(intent)
                        finish()
                    }

                }.addOnFailureListener { exception ->
                    val mensagemErro = when (exception) {
                        is FirebaseAuthWeakPasswordException -> getString(R.string.erroSenha)
                        is FirebaseAuthInvalidCredentialsException -> getString((R.string.erroEmail))
                        is FirebaseAuthUserCollisionException -> getString((R.string.erroConta))
                        is FirebaseNetworkException -> getString((R.string.erroInternet))
                        else -> getString(R.string.erroOutros)
                    }
                    val mensagem =
                        Snackbar.make(view, mensagemErro, Snackbar.LENGTH_SHORT)
                    mensagem.setBackgroundTint(Color.RED)
                    mensagem.show()
                }
            }
        }
    }

    private fun dataNasc(){
        val meuFormato = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(meuFormato, Locale.getDefault())
        txtNasc.text = sdf.format(dataNasc.time)
        txtNasc.visibility = View.VISIBLE
    }
}
