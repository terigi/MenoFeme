package com.lavita.menofeme.view

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.util.FileUtils
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.firestore.FirebaseFirestore
import com.lavita.menofeme.R
import com.lavita.menofeme.view.adapters.AppExecutors
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Locale
import javax.activation.DataHandler
import javax.activation.DataSource
import javax.activation.FileDataSource
import javax.mail.Authenticator
import javax.mail.Message
import javax.mail.MessagingException
import javax.mail.Multipart
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeBodyPart
import javax.mail.internet.MimeMessage
import javax.mail.internet.MimeMultipart

lateinit var appExecutors: AppExecutors
const val EMAIL = "menofemeapp@gmail.com"
const val SENHA = "vqrusphxxlajkqai"

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
    private lateinit var btnVoltar: ImageButton
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
        btnVoltar = findViewById(R.id.btnVoltar)

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
                this@Cadastrar, R.style.DatePickerTheme, dateSetListener,
                dataNasc.get(Calendar.YEAR),
                dataNasc.get(Calendar.MONTH),
                dataNasc.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        //Spinner

        ArrayAdapter.createFromResource(this, R.array.spinner_lista, R.layout.color_spinner_layout
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout)
            txtEtnia.adapter = adapter

            txtEtnia.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    auxEtnia = txtEtnia.selectedItem.toString()
                }
                override fun onNothingSelected(p1: AdapterView<*>?) {
                }
            }
        }
        btnVoltar.setOnClickListener{
            val mIntent = Intent(this, Termos ::class.java)
            startActivity(mIntent)
            finish()
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
                mensagem.setTextColor(Color.WHITE)
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
                mensagem.setTextColor(Color.WHITE)
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
                mensagem.setTextColor(Color.WHITE)
                mensagem.show()
            } else {
                //Criando um item de carregamento

                val builder = AlertDialog.Builder(this)
                builder.setView(R.layout.progress_layout)
                val progressDialog = builder.create()
                progressDialog.show()

                auth.createUserWithEmailAndPassword(
                    txtEmail.text.toString(),
                    txtSenha.text.toString()
                ).addOnCompleteListener { cadastro ->
                    if (cadastro.isSuccessful) {
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
                            "Hora" to txtHora.toString(),
                            "Data_Menqol" to txtData.toString()
                        )
                        db.collection("User").document(txtEmail.text.toString())
                            .set(usuariosMap).addOnCompleteListener {
                                appExecutors = AppExecutors()
                                enviar(txtEmail.text.toString())
                                progressDialog.dismiss()
                                val textoOk = getString(R.string.txtCadastroOk)
                                val mensagem =
                                    Snackbar.make(view, textoOk, Snackbar.LENGTH_SHORT)
                                mensagem.setBackgroundTint(Color.GREEN)
                                mensagem.setTextColor(Color.WHITE)
                                mensagem.show()
                            }.addOnFailureListener {

                            }
                        val intent = Intent(this, Principal::class.java)
                        intent.putExtra("ACESSO","Novo")
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
                    progressDialog.dismiss()
                    val mensagem =
                        Snackbar.make(view, mensagemErro, Snackbar.LENGTH_SHORT)
                    mensagem.setBackgroundTint(Color.RED)
                    mensagem.setTextColor(Color.WHITE)
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

    private fun enviar(destino: String)
    {
        appExecutors.diskIO().execute {
            val props = System.getProperties()
            props["mail.smtp.host"] = "smtp.gmail.com"
            props["mail.smtp.socketFactory.port"] = "465"
            props["mail.smtp.socketFactory.class"] = "javax.net.ssl.SSLSocketFactory"
            props["mail.smtp.auth"] = "true"
            props["mail.smtp.port"] = "465"

            val session =  Session.getInstance(props,
                object: Authenticator() {
                    //Autenticando o e-mail e a senha
                    override fun getPasswordAuthentication(): PasswordAuthentication? {
                        return PasswordAuthentication(EMAIL, SENHA)
                    }
                })

            try {
                //Criando a mensagem
                val mm = MimeMessage(session)
                //Configurando quem está enviando
                mm.setFrom(InternetAddress(EMAIL))
                //Adicionando o endereço de destibo
                mm.addRecipient(
                    Message.RecipientType.TO,
                    InternetAddress(destino))
                //Adicionando o assunto ao e-mail
                mm.subject = "${txtNome.text.toString()}, seja bem-vinda ao aplicativo Meno Feme!"

                val messageBodyPart = MimeBodyPart()
                messageBodyPart.setText("Sabemos que o período do climatério pode ser desafiador para algumas mulheres, por isso, estamos engajados em fornecer informações úteis para que você transcorra por este período de forma tranquila!\n" +
                        "A correta utilização e preenchimento de dados e questionários nos permitirá entender às necessidades das usuárias e assim efetuar melhorias no aplicativo.\n" +
                        "Desejamos que Meno Feme possa te ajudar a diminuir as incertezas deste período, trazendo assim uma melhor qualidade de vida!\n")

                // Criar uma mensagem com múltiplas partes
                val multipart: Multipart = MimeMultipart()
                multipart.addBodyPart(messageBodyPart)

                //Exemplo se o arquivo estiver na pasta downloads
                //val mFilePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()

                /*val texto = "Enviando e-mail..."
                val duracao = Toast.LENGTH_SHORT
                val aviso = Toast.makeText(this, texto, duracao)
                aviso.show()*/

                //Nome do arquivo
                val f = File(filesDir, "TCLE.pdf")
                if (!f.exists()) {
                    try {
                        FileUtils.copy(assets.open("TCLE.pdf"), f)
                    } catch (e: IOException) {
                        Log.e("FileProvider", "Exception copying from assets", e)
                    }
                }
                val anexo = MimeBodyPart()
                val source: DataSource = FileDataSource(f)
                anexo.dataHandler = DataHandler(source)
                anexo.fileName = "TCLE.pdf"
                multipart.addBodyPart(anexo)
                mm.setContent(multipart)

                //Enviar e-mail
                Transport.send(mm)
                appExecutors.mainThread().execute {
                }

            } catch (e: MessagingException) {
                e.printStackTrace()
            }
        }
    }
}
