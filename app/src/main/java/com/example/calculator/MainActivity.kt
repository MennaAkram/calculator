package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var binaryButton: Button
    private lateinit var decimalButton: Button
    private lateinit var octalButton: Button
    private lateinit var hexaDecimalButton: Button
    private lateinit var clearAllButton: Button
    private lateinit var inputNumber: TextView
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        addCallbacks()

    }

    private fun initView(){
        binaryButton = findViewById(R.id.binary_button)
        decimalButton = findViewById(R.id.decimal_button)
        octalButton = findViewById(R.id.octal_button)
        hexaDecimalButton = findViewById(R.id.hexaDecimal_button)
        clearAllButton = findViewById(R.id.clearAll_button)
        inputNumber = findViewById(R.id.input_number)
        resultText = findViewById(R.id.tv_result)
    }

    fun onClickNumber(v: View){
        val newDigit = (v as Button).text.toString()
        val oldDigit = inputNumber.text.toString()
        val newTextNumber = oldDigit + newDigit
        inputNumber.text = newTextNumber
    }

    private fun  addCallbacks(){
        clearAllButton.setOnClickListener{
            clearInput()
        }
        binaryButton.setOnClickListener {
          val result = convertDecimalToBinary(inputNumber.text.toString())
            resultText.text = result
        }
        octalButton.setOnClickListener {
          val result =  convertDecimalToOctal(inputNumber.text.toString())
            resultText.text = result
        }
        hexaDecimalButton.setOnClickListener {
          val result =  convertDecimalToHexaDecimal(inputNumber.text.toString())
            resultText.text = result
        }
        decimalButton.setOnClickListener {
            val result =  convertDecimalToDecimal(inputNumber.text.toString())
            resultText.text = result
        }
    }

    private fun convertDecimalToHexaDecimal(num: String): String {
        val hexaDecimal = Integer.toHexString(num.toInt())
        return hexaDecimal
    }

    private fun convertDecimalToOctal(num: String): String {
        val decimal = Integer.toOctalString(num.toInt())
        return decimal
    }

    private fun convertDecimalToBinary(num :String): String {
        val binary = Integer.toBinaryString(num.toInt())
        return binary
    }

    private fun convertDecimalToDecimal(num: String): String {
        return num
    }

    private fun clearInput(){
        inputNumber.text = ""
    }
}

