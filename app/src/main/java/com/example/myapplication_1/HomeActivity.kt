package com.example.myapplication_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    private var btn_sum : Button? = null
    private var btn_minus : Button? = null
    private var btn_divider : Button? = null
    private var btn_multip : Button? = null
    private var txt_view1 :  TextView? = null
    private var edit_number1 : EditText? = null
    private var edit_number2 : EditText? = null
    private var txt_view2 : TextView? = null
    private var btn_calculate : ImageButton? = null

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
        btn_minus = findViewById(R.id.btn_minus)
        btn_divider = findViewById(R.id.btn_divider)
        btn_multip = findViewById(R.id.btn_multip)
        txt_view1 = findViewById(R.id.txt_view1)
        edit_number1 = findViewById(R.id.edit_number_1)
        edit_number2 = findViewById(R.id.edit_number_2)
        txt_view2 = findViewById(R.id.txt_view2)
        btn_calculate = findViewById(R.id.btn_calculate)
        clickOperationButtons()
        clickButtonCalculate()
    }
    // função botões das operações
    private fun clickOperationButtons() {
        btn_sum?.setOnClickListener {
            txt_view1?.text = "Você selecionou somar"
        }
        btn_minus?.setOnClickListener {
            txt_view1?.text = "Você selecionou menos"
        }
        btn_divider?.setOnClickListener {
            txt_view1?.text = "Você selecionou dividir"
        }
        btn_multip?.setOnClickListener {
            txt_view1?.text = "Você selecionou multiplicar"
        }
    }

    private fun checkOperationSelected() {
        when(txt_view1?.text) {
            "Você selecionou somar" -> {
                sumValues(edit_number1?.text.toString(), edit_number2?.text.toString())
            }
            "Você selecionou menos" -> {
                minusValues(edit_number1?.text.toString(), edit_number2?.text.toString())
            }
            "Você selecionou dividir" -> {
                dividerValues(edit_number1?.text.toString(), edit_number2?.text.toString())
            }
            "Você selecionou multiplicar" -> {
                multipValues(edit_number1?.text.toString(), edit_number2?.text.toString())
            }
        }
    }

    private fun clickButtonCalculate() {
        btn_calculate?.setOnClickListener {
            if(checkNubemEmpty() || txtView1Empty()){
                return@setOnClickListener
            }
            checkOperationSelected()
        }
    }
    //funções das operações matemáticas
    private fun sumValues(
        edit1 : String,
        edit2 : String
    ){
            val resultSum = edit1.toInt() + edit2.toInt()
            showResultOperation(resultSum)
    }

    private fun minusValues(
        edit1 : String,
        edit2 : String
    ) {
        val resultMinus = edit1.toInt() - edit2.toInt()
        showResultOperation(resultMinus)
    }

    private fun dividerValues(
        edit1: String,
        edit2: String
    ) {
        val resultDivider = edit1.toInt() / edit2.toInt()
        showResultOperation(resultDivider)
    }

    private fun multipValues(
        edit1 : String,
        edit2: String
    ) {
        val resultMultip = edit1.toInt() * edit2.toInt()
        showResultOperation(resultMultip)
    }

// funções para mostrar mensagens e checar se estão preenchidos os campos
    private fun mensagem(mensage: String) {
        Toast.makeText(this, mensage, Toast.LENGTH_SHORT).show()
    }

    private fun showResultOperation(valueShow : Int) {
        txt_view2?.text = valueShow.toString()
    }

    private fun checkNubemEmpty() : Boolean {
        if(edit_number1?.text.toString().isEmpty() || edit_number2?.text.toString().isEmpty()) {
            mensagem("Digite os Numeros")
            return true
        }
        return false
    }

    private fun txtView1Empty() : Boolean {
        if(txt_view1?.text.toString().isEmpty()){
            mensagem("Selecione a Operação")
            return true
        }
        return false
    }
}