package com.example.myapplication_1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    private var btn_sum : Button? = null
    private var txt_view1 :  TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btn_sum = findViewById(R.id.btn_sum)
        txt_view1 = findViewById(R.id.txt_view1)
        clickOperationButtons()
    }

    private fun clickOperationButtons() {
        btn_sum?.setOnClickListener {
            txt_view1?.text = "Você selecionou somar"
        }
    }

    private fun mensagem(mensage: String) {
        Toast.makeText(this, mensage, Toast.LENGTH_SHORT).show()
    }
}