package com.lavita.menofeme.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import com.lavita.menofeme.R

class Termos : AppCompatActivity() {
    private lateinit var ckbTermos: CheckBox
    private lateinit var btnTermos: androidx.appcompat.widget.AppCompatButton
    private var Resp: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_termos)

        ckbTermos = findViewById(R.id.ckbTermos)
        btnTermos = findViewById(R.id.btnTermos)

        btnTermos.setOnClickListener{
            if(Resp == 1){
                val mIntent = Intent(this, Tcle ::class.java)
                startActivity(mIntent)
                finish()
            }else if(Resp == 0) {
                val mIntent = Intent(this, Cadastrar ::class.java)
                mIntent.putExtra("Termos", "0")
                startActivity(mIntent)
                finish()
            }
        }
    }

    fun onTermosClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.ckbTermos -> {
                    Resp = if (checked) {
                        1
                    } else {
                        0
                    }
                }
            }
        }
    }
}
