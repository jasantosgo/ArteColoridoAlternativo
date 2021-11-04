package com.santosgo.artecoloridoalternativo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //variable con el color a pintar
    private var color : Int = 0
    private lateinit var tvMuestra : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        color = Color.rgb(0,0,0)
        tvMuestra = findViewById(R.id.tvMuestra)
        tvMuestra.setBackgroundColor(color)

        val elemColoreables : List<View> = listOf(
            findViewById<View>(R.id.constraint_layout),
            findViewById<View>(R.id.tvCaja1),
            findViewById<View>(R.id.tvCaja2),
            findViewById<View>(R.id.tvCaja3),
            findViewById<View>(R.id.tvCaja4),
            findViewById<View>(R.id.tvCaja5),
            findViewById<View>(R.id.tvCaja6),
            findViewById<View>(R.id.tvCaja7),
            findViewById<View>(R.id.tvCaja8),
            findViewById<View>(R.id.tvCaja9),
            findViewById<View>(R.id.tvCaja10)
            )

        val botones : List<Button> = listOf(
            findViewById(R.id.btnRojo),
            findViewById(R.id.btnVerde),
            findViewById(R.id.btnAzul),
            findViewById(R.id.btnAleatorio)
        )

        for (elemento in botones) {
            elemento.setOnClickListener {
                setColor(it)
            }
        }

        for (coloreable in elemColoreables) {
            coloreable.setOnClickListener{
                colorear(it)
            }
        }
    }

    private fun setColor(view : View) {
        when(view.id) {
            R.id.btnRojo -> color=Color.RED
            R.id.btnVerde -> color=Color.GREEN
            R.id.btnAzul -> color=Color.BLUE
            R.id.btnAleatorio -> color=Color.rgb((0..255).random(),(0..255).random(),(0..255).random())
        }
        tvMuestra.setBackgroundColor(color)
    }
    //función para colorear, dependiendo del botón pulsado se coloreará de uno u otro color.
    private fun colorear(view : View) {
        if(view.id==R.id.constraint_layout)
            view.setBackgroundColor(Color.LTGRAY)
        else
            view.setBackgroundColor(color)
    }
}