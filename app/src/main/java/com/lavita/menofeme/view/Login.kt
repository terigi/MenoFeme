package com.lavita.menofeme.view

import android.app.AlertDialog
import android.app.Application
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.lavita.menofeme.R

class Login : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()
    private lateinit var txtEmail: EditText
    private lateinit var txtSenha: EditText
    private lateinit var btnEntrar: androidx.appcompat.widget.AppCompatButton
    private lateinit var btnCadastrarLogin: androidx.appcompat.widget.AppCompatButton
    //private lateinit var btnSair: androidx.appcompat.widget.AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        txtEmail = findViewById(R.id.txtEmailLogin)
        txtSenha = findViewById(R.id.txtSenhaLogin)
        btnEntrar = findViewById(R.id.btnEntrarLogin)
        btnCadastrarLogin = findViewById(R.id.btnCadastrarLogin)
        //btnSair = findViewById(R.id.btnSair)

        btnEntrar.setOnClickListener {view->
            val email = txtEmail.text.toString()
            val senha = txtSenha.text.toString()


            if (email.isEmpty() || senha.isEmpty()){
                val mensagem1 = Snackbar.make(view, getString(R.string.erroDados), Snackbar.LENGTH_SHORT)
                mensagem1.setBackgroundTint((Color.RED))
                mensagem1.setTextColor(Color.WHITE)
                mensagem1.show()
            }else{
                //Criando um item de carregamento
                val builder = AlertDialog.Builder(this)
                builder.setView(R.layout.progress_carregando_layout)
                val progressDialog = builder.create()
                progressDialog.show()

                auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener {autenticacao->
                    if(autenticacao.isSuccessful){
                        progressDialog.dismiss()
                        val intent = Intent(this, Principal::class.java)
                        startActivity(intent)
                        finish()
                    }
                }.addOnFailureListener{exception ->
                    val mensagemErro = when (exception){
                        is FirebaseAuthWeakPasswordException -> getString(R.string.erroSenha)
                        is FirebaseAuthInvalidCredentialsException -> getString((R.string.erroEmail))
                        is FirebaseNetworkException -> getString((R.string.erroInternet))
                        is FirebaseAuthInvalidUserException -> getString((R.string.erroUsuaria))
                        else -> getString(R.string.erroOutros)
                    }
                    progressDialog.dismiss()
                    val mensagem =
                        Snackbar.make(view, mensagemErro, Snackbar.LENGTH_SHORT)
                    mensagem.setBackgroundTint(Color.RED)
                    mensagem.setTextColor(Color.WHITE)
                    mensagem.show()
                }
            }
        }
        btnCadastrarLogin.setOnClickListener{
            val mIntent = Intent(this, Termos ::class.java)
            mIntent.putExtra("Termos", "0")
            mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(mIntent)
            //finish()

        }

        /*btnSair.setOnClickListener{
            val intent = Intent(this, Principal::class.java)
            startActivity(intent)
            finish()
        }*/
    }
   override fun onStart() {
       super.onStart()

       val usuarioAtual = FirebaseAuth.getInstance().currentUser

        if (usuarioAtual != null){
            val intent = Intent(this, Principal::class.java)
            startActivity(intent)
            finish()
        }
    }
}
/*
class globalVar : Application() {
    var ACESSO: String = "Velho"
}*/
