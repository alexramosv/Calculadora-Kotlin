package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0

//    var contador = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnUno.setOnClickListener { numeroPresionado("1") }
        btnDos.setOnClickListener { numeroPresionado("2") }
        btnTres.setOnClickListener { numeroPresionado("3") }
        btnCuatro.setOnClickListener { numeroPresionado("4") }
        btnCinco.setOnClickListener { numeroPresionado("5") }
        btnSeis.setOnClickListener { numeroPresionado("6") }
        btnSiete.setOnClickListener { numeroPresionado("7") }
        btnOcho.setOnClickListener { numeroPresionado("8") }
        btnNueve.setOnClickListener { numeroPresionado("9") }
        btnCero.setOnClickListener { numeroPresionado("0") }
        btnComa.setOnClickListener { numeroPresionado(".") }

        btnSuma.setOnClickListener { operacionPresionada(suma) }
        btnMenos.setOnClickListener { operacionPresionada(resta) }
        btnMulti.setOnClickListener { operacionPresionada(multiplicacion) }
        btnDivision.setOnClickListener { operacionPresionada(division) }

        btnReset.setOnClickListener {
            num1 = 0.0
            num2 = 0.0
            textResultado.text = "0"
            operacion = NO_OPERACION
        }

        btnIgual.setOnClickListener {
            var resultado = when (operacion) {
                suma -> num1 + num2
                resta -> num1 - num2
                multiplicacion -> num1 * num2
                division -> num1 / num2
                else -> 0
            }

            textResultado.text = resultado.toString()
            num1 = textResultado.text.toString().toDouble()

            textResultado.text = if ("$resultado".endsWith(".0")) {
                "$resultado".replace(".0", "")
            } else {
                textResultado.text.toString()
            }


        }
    }
        private fun numeroPresionado(digito: String) {

            if(textResultado.text == "0" && digito != "."){
                textResultado.text = "$digito"
            } else {
                textResultado.text = "${textResultado.text}$digito"
            }


            if (operacion == NO_OPERACION) {
                num1 = textResultado.text.toString().toDouble()
            } else {
                num2 = textResultado.text.toString().toDouble()

             /*   if (contador == 0) {
                    textResultado.text = "$digito"
                    contador = 1

                }
            */
            }
        }

        private fun operacionPresionada(operacion: Int) {
            this.operacion = operacion

            textResultado.text = ""

           // contador = 0

        }

        companion object {
            const val suma = 1
            const val resta = 2
            const val multiplicacion = 3
            const val division = 4
            const val NO_OPERACION = 0
        }

    }













































