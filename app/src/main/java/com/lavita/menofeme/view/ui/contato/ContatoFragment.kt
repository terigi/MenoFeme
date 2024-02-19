package com.lavita.menofeme.view.ui.contato

import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.lavita.menofeme.R

class ContatoFragment : Fragment() {

    private lateinit var pegarView: View
    //private lateinit var link_email: TextView
    private lateinit var link_instagram: TextView
    private lateinit var link_facebook: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pegarView = inflater.inflate(R.layout.fragment_contato, container, false)
        //link_email = pegarView.findViewById(R.id.link_email)
        //link_email.movementMethod = LinkMovementMethod.getInstance()
        link_instagram = pegarView.findViewById(R.id.link_instagram)
        link_instagram.movementMethod = LinkMovementMethod.getInstance()
        link_facebook = pegarView.findViewById(R.id.link_facebook)
        link_facebook.movementMethod = LinkMovementMethod.getInstance()
        return pegarView
    }
}