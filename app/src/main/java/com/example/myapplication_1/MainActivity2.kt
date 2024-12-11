package com.example.myapplication_1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private var btn_login : Button? = null
    private var txt_nome : EditText? = null
    private var txt_senha : EditText? = null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btn_login = findViewById(R.id.btn_login)
        txt_nome = findViewById(R.id.edit_nome)
        txt_senha = findViewById(R.id.edit_senha)
        clickBotao()

    }

    fun verificaLogin () : Boolean {
        val nome = txt_nome?.text.toString()
        val senha = txt_senha?.text.toString()

        if (nome == "douglas" && senha == "123") {
            return true
        }else {
            return false
        }
    }

    fun clickBotao () {
        btn_login?.setOnClickListener {
            var checaLogin = false
            checaLogin = verificaLogin()

            if (checaLogin == true){
                Toast.makeText(this,"Usuario Correto", Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(this,"Usuario Incorreto", Toast.LENGTH_SHORT).show()
            }

        }
    }
}