package com.santosgo.artecolorido

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //función para colorear, dependiendo del botón pulsado se coloreará de uno u otro color.
    fun colorear(view : View) {
        /*
        //PRÁCICA POR DEFECTO.
        when(view.id) {
            R.id.tvCaja1 -> view.setBackgroundColor(Color.DKGRAY)
            R.id.tvCaja2 -> view.setBackgroundColor(Color.GRAY)
            R.id.tvCaja3 -> view.setBackgroundColor(Color.BLUE)
            R.id.tvCaja4 -> view.setBackgroundColor(Color.MAGENTA)
            R.id.tvCaja5 -> view.setBackgroundColor(Color.BLUE)
            R.id.btnRojo -> findViewById<TextView>(R.id.tvCaja3).setBackgroundColor(resources.getColor(R.color.mi_rojo))
            R.id.btnVerde -> findViewById<TextView>(R.id.tvCaja4).setBackgroundColor(resources.getColor(R.color.mi_verde))
            R.id.btnAmarillo -> findViewById<TextView>(R.id.tvCaja5).setBackgroundColor(resources.getColor(R.color.mi_amarillo))
            else -> view.setBackgroundColor(Color.LTGRAY)
        }*/
        /*
        //MODIFICACIÓN1: CAMBIA DE COLORES DE FORMA ALEATORIA DENTRO DE UNA LISTA.
        val colores : List<Int> = listOf(Color.BLACK, Color.BLUE, Color.MAGENTA, Color.CYAN, Color.RED, Color.GREEN, Color.YELLOW)
        if(view.id==R.id.constraint_layout)
            view.setBackgroundColor(Color.LTGRAY)
        else
            view.setBackgroundColor(colores[(0..colores.lastIndex).random()])
         */

        //MODIFICACIÓN2: LLENA LA VENTANA DE BOTONES Y HAZ QUE CAMBIEN DE COLOR DE FORMA TOTALMENTE ALEATORIA.
        //genero un número aleatorio que dará un valor hexadecimal entre 0 y FFFFFF.
        var aleatorio : String = Integer.toHexString((0..16777214).random())
        var i : Int = 6
        //a la cadena le añado ceros hasta completar 6 caracteres de longitud.
        while (i-->aleatorio.length){
            aleatorio = '0' + aleatorio
        }
        //por último le añado #FF por el formato del color y el valor alfa al máximo.
        aleatorio = "#FF" + aleatorio
        // otra manera de generar el color aleatorio mediante sus componentes RGB, desde 0 a 255.
        aleatorio="#FF"
        i=0
        while (i++<3) {
            var generado = (0..255).random()
            if(generado<16)
                aleatorio += '0' + Integer.toHexString(generado)
            else
                aleatorio += Integer.toHexString(generado)
        }
        //println(aleatorio)
        //si el elemento es el fondo se pinta de gris, si no se pinta de un color aleatorio.
        if(view.id==R.id.constraint_layout)
            view.setBackgroundColor(Color.LTGRAY)
        else
            view.setBackgroundColor(Color.parseColor(aleatorio))
    }
}