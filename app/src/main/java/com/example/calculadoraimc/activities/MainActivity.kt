package com.example.calculadoraimc.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import com.example.calculadoraimc.R
import com.google.android.material.slider.Slider
import java.math.RoundingMode
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    // Declaring the needed variables before the onCreate

    lateinit var heightResult:AppCompatTextView
    lateinit var heightSlider:Slider

    var height:Float = 1.70F

    lateinit var weightResult:AppCompatTextView
    lateinit var btnAdd:AppCompatImageButton
    lateinit var btnSub:AppCompatImageButton

    var weight:Int = 60

    lateinit var btnCalculation:AppCompatButton
    lateinit var finalResult:AppCompatTextView

    var calculation:Float = 0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Call the IDs of the layout to be available to use

        heightResult = findViewById(R.id.heightResult)
        heightSlider = findViewById(R.id.heightSlider)

        weightResult = findViewById(R.id.weightResult)
        btnAdd = findViewById(R.id.btnAdd)
        btnSub = findViewById(R.id.btnSub)

        btnCalculation = findViewById(R.id.btnCalculation)
        finalResult = findViewById(R.id.finalResult)

        // Call the functions to execute them on the application

        heightSelection()
        weightSelection()
        bmiCalculation()
    }

    private fun heightSelection() {

        // Default height on opening the application

        heightResult.text = String.format(getString(R.string.height_result_text), height.toBigDecimal().setScale(2))

        // Update height while move the slide

        heightSlider.addOnChangeListener { _, value, _ ->
            height = value / 100
            heightResult.text = String.format(getString(R.string.height_result_text), height.toBigDecimal().setScale(2))
        }
    }

    private fun weightSelection() {

        // Default weight on opening the application

        weightResult.text = String.format(getString(R.string.weight_result_text), weight)

        // Addition an Subtraction buttons to choose the weight

        btnAdd.setOnClickListener() {
            weight ++
            weightResult.text = String.format(getString(R.string.weight_result_text), weight)
        }

        btnSub.setOnClickListener() {
            weight --
            weightResult.text = String.format(getString(R.string.weight_result_text), weight)
        }
    }

    private fun bmiCalculation() {

        // Final calculation to display result

        btnCalculation.setOnClickListener() {
            calculation = weight / height.pow(2)
            val calculationRounded = calculation.toBigDecimal().setScale(1, RoundingMode.HALF_EVEN)
            finalResult.text = calculationRounded.toFloat().toString()
        }
    }

    private fun bmiInformationText() {

    }
}
