package com.lavita.menofeme.view

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.lavita.menofeme.R
import com.lavita.menofeme.view.ui.contato.ContatoFragment
import com.lavita.menofeme.view.ui.home.HomeFragment
import com.lavita.menofeme.view.ui.perfil.PerfilFragment
import com.lavita.menofeme.view.ui.privacidade.PrivacidadeFragment
import com.lavita.menofeme.view.ui.questionarios.MenqolFragment
import com.lavita.menofeme.view.ui.sobre.SobreFragment
import com.lavita.menofeme.view.ui.tcle1.TcleFragment

private val db = FirebaseFirestore.getInstance()

class Principal : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawerlayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var perfilFragment: PerfilFragment
    private lateinit var homeFragment: HomeFragment
    private lateinit var tcleFragment: TcleFragment
    private lateinit var sobreFragment: SobreFragment
    private lateinit var contatoFragment: ContatoFragment
    private lateinit var privacidadeFragment: PrivacidadeFragment
    private lateinit var menqolFragment: MenqolFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawerlayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        perfilFragment = PerfilFragment()
        homeFragment = HomeFragment()
        sobreFragment = SobreFragment()
        tcleFragment = TcleFragment()
        contatoFragment = ContatoFragment()
        privacidadeFragment = PrivacidadeFragment()
        menqolFragment = MenqolFragment()

        val ss:String = intent.getStringExtra("ACESSO").toString()
        if (ss == "Novo")
        {
            setFragment(menqolFragment)
            toolbar.title = getString(R.string.menqol)
            drawerlayout.closeDrawer(GravityCompat.START)
        }
        else{
            setFragment(homeFragment)
            toolbar.title = getString(R.string.menu_home)
            drawerlayout.closeDrawer(GravityCompat.START)
        }


        val navController = findNavController(R.id.nav_host_fragment_content_principal)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_perfil,
                R.id.nav_excluir,
                R.id.nav_privacidade,
                R.id.nav_home,
                R.id.nav_tcle,
                R.id.nav_sobre,
                R.id.nav_contato,
                R.id.nav_logoff,
                //R.id.nav_sair
            ), drawerlayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_perfil -> {
                    setFragment(perfilFragment)
                    toolbar.title = getString(R.string.menu_perfil)
                    drawerlayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_excluir -> {
                    AlertDialog.Builder(this,R.style.AlertDialogTheme)
                        .setTitle(getString(R.string.menu_app))
                        .setMessage(getString(R.string.txtExcluir))
                        .setPositiveButton(getString(R.string.rbSim)) { _, _ ->
                            //Criando um item de carregamento
                            val builder = android.app.AlertDialog.Builder(this)
                            builder.setView(R.layout.progress_excluir_layout)
                            val progressDialog = builder.create()
                            progressDialog.show()

                            val user = Firebase.auth.currentUser!!
                            user.delete()
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        FirebaseAuth.getInstance().signOut()
                                        val voltarLogin = Intent (this,Login::class.java )
                                        voltarLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                        voltarLogin.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                        startActivity(voltarLogin)
                                        finish()
                                    }
                                }.addOnFailureListener { exception ->
                                    val mensagemErro = when (exception) {
                                        is FirebaseAuthWeakPasswordException -> getString(R.string.erroSenha)
                                        is FirebaseAuthInvalidCredentialsException -> getString((R.string.erroEmail))
                                        is FirebaseAuthUserCollisionException -> getString((R.string.erroConta))
                                        is FirebaseNetworkException -> getString((R.string.erroInternet))
                                        else -> getString(R.string.erroConexao)
                                    }
                                    progressDialog.dismiss()
                                    val mensagem = Snackbar.make(window.decorView, mensagemErro, Snackbar.LENGTH_SHORT)
                                    mensagem.setBackgroundTint(Color.RED)
                                    mensagem.setTextColor(Color.WHITE)
                                    mensagem.show()
                                }
                        }
                        .setNeutralButton(getString(R.string.rbNao)) { _, _ ->
                            drawerlayout.closeDrawer(GravityCompat.START)
                        }
                        .setIcon(R.drawable.ic_menstruacao)
                        .create()
                        .show()
                    true
                }
                R.id.nav_privacidade -> {
                    setFragment(privacidadeFragment)
                    toolbar.title = getString(R.string.menu_privacidade)
                    drawerlayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_home -> {
                    setFragment(homeFragment)
                    toolbar.title = getString(R.string.menu_home)
                    drawerlayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_tcle -> {
                    setFragment(tcleFragment)
                    toolbar.title = getString(R.string.menu_tcle)
                    drawerlayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_sobre -> {
                    setFragment(sobreFragment)
                    toolbar.title = getString(R.string.menu_sobre)
                    drawerlayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_contato -> {
                    //Toast.makeText(this,"Essa função está sendo implementada", Toast.LENGTH_SHORT).show()
                    setFragment(contatoFragment)
                    toolbar.title = getString(R.string.menu_contato)
                    drawerlayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_logoff -> {
                    FirebaseAuth.getInstance().signOut()
                    val voltarLogin = Intent (this,Login::class.java )
                    voltarLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    voltarLogin.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(voltarLogin)
                    finish()
                    true
                }
                /*R.id.nav_sair -> {
                    val intent = Intent(Intent.ACTION_MAIN)
                    intent.addCategory(Intent.CATEGORY_HOME)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                    finish()
                    true
                }
                //codigo do activity_main_drawer.xml
                <item
                    android:id="@+id/nav_sair"
                    android:icon="@drawable/ic_sair"
                    android:title="@string/menu_sair" />
                */
                else -> false
            }
        }
    }

    private fun setFragment(fragment: Fragment){
        val fT = supportFragmentManager.beginTransaction()
        //fT.addToBackStack(fragment.toString())
        fT.replace(R.id.nav_host_fragment_content_principal, fragment)
        fT.commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_principal)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}


