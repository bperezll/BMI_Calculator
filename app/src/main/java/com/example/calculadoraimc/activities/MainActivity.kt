package com.example.calculadoraimc.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.Formatter
import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.example.calculadoraimc.R
import com.google.android.material.slider.Slider
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    lateinit var alturaResult:AppCompatTextView
    lateinit var alturaSlider:Slider

    var altura:Float = 170F

    lateinit var pesoResult:AppCompatTextView
    lateinit var btnSumar:AppCompatButton
    lateinit var btnRestar:AppCompatButton

    var peso:Float = 60F

    lateinit var btnCalcularIMC:AppCompatButton
    lateinit var resultadoIMC:AppCompatTextView

    var calculoFinal:Float = 0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //alturaSeekBar.setOnClickListener() {
            // Log.i("Testing", "El usuario ha introducido: ${userEditText.text}")
        //}

        alturaResult = findViewById(R.id.alturaResult)
        alturaSlider = findViewById(R.id.alturaSlider)

        pesoResult = findViewById(R.id.pesoResult)
        btnSumar = findViewById(R.id.btnSumar)
        btnRestar = findViewById(R.id.btnRestar)

        btnCalcularIMC = findViewById(R.id.btnCalcularIMC)
        resultadoIMC = findViewById(R.id.resultadoIMC)

        modificarAltura()
        modificarPeso()
        calcularIMC()

    }

    fun modificarAltura() {

        // Falta colocar formato para poner los decimales bien

        alturaSlider.addOnChangeListener { _, value, _ ->
            altura = value
            alturaResult.text = value.toString()
            //alturaSlider.valueFrom = 1.20F
        }

    }

    fun modificarPeso() {

        pesoResult.text = peso.toString()

        btnSumar.setOnClickListener() {
            peso ++
            pesoResult.text = peso.toString()
        }

        btnRestar.setOnClickListener() {
            peso --
            pesoResult.text = peso.toString()
        }

    }

    fun calcularIMC() {

        //resultadoIMC.text =

        btnCalcularIMC.setOnClickListener() {
            calculoFinal = peso / altura.pow(2).toString()
            Log.i("IMC", "El IMC es ${resultadoIMC.text}")
        }
    }

}