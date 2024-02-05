package com.eyupyilmaz.kotlinxox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.btn1
import kotlinx.android.synthetic.main.activity_main.btn2
import kotlinx.android.synthetic.main.activity_main.btn3
import kotlinx.android.synthetic.main.activity_main.btn4
import kotlinx.android.synthetic.main.activity_main.btn5
import kotlinx.android.synthetic.main.activity_main.btn6
import kotlinx.android.synthetic.main.activity_main.btn7
import kotlinx.android.synthetic.main.activity_main.btn8
import kotlinx.android.synthetic.main.activity_main.btn9
import kotlinx.android.synthetic.main.activity_main.restartGame

class MainActivity : AppCompatActivity() {

    var player = "P1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            btnClick((btn1))
        }

        btn2.setOnClickListener {
            btnClick((btn2))
        }

        btn3.setOnClickListener {
            btnClick((btn3))
        }

        btn4.setOnClickListener {
            btnClick((btn4))
        }

        btn5.setOnClickListener {
            btnClick((btn5))
        }

        btn6.setOnClickListener {
            btnClick((btn6))
        }

        btn7.setOnClickListener {
            btnClick((btn7))
        }

        btn8.setOnClickListener {
            btnClick((btn8))
        }

        btn9.setOnClickListener {
            btnClick((btn9))
        }

        restartGame.setOnClickListener {
            btnReset()
        }

    }

    fun btnClick(button: Button)
    {
        if (button.text == "")
        {
            if (player == "P1")
            {
                button.text = "X"
                player = "P2"
            }
            else
            {
                button.text = "O"
                player = "P1"
            }

            win()
        }
    }

    fun win()
    {
        if ((btn1.text == "X" && btn2.text == "X" && btn3.text == "X")
            || (btn4.text == "X" && btn5.text == "X" && btn6.text == "X")
            || (btn7.text == "X" && btn8.text == "X" && btn9.text == "X")
            || (btn1.text == "X" && btn4.text == "X" && btn7.text == "X")
            || (btn2.text == "X" && btn5.text == "X" && btn8.text == "X")
            || (btn3.text == "X" && btn6.text == "X" && btn9.text == "X")
            || (btn1.text == "X" && btn5.text == "X" && btn9.text == "X")
            || (btn3.text == "X" && btn5.text == "X" && btn7.text == "X")
            )
        {
            alertX()
            disableButtons()
        }

        else if ((btn1.text == "O" && btn2.text == "O" && btn3.text == "O")
            || (btn4.text == "O" && btn5.text == "O" && btn6.text == "O")
            || (btn7.text == "O" && btn8.text == "O" && btn9.text == "O")
            || (btn1.text == "O" && btn4.text == "O" && btn7.text == "O")
            || (btn2.text == "O" && btn5.text == "O" && btn8.text == "O")
            || (btn3.text == "O" && btn6.text == "O" && btn9.text == "O")
            || (btn1.text == "O" && btn5.text == "O" && btn9.text == "O")
            || (btn3.text == "O" && btn5.text == "O" && btn7.text == "O")
            )
        {
            alertO()
            disableButtons()
        }

        else if ((btn1.text != "") && (btn2.text != "") && (btn3.text != "")
            && (btn4.text != "") && (btn5.text != "") && (btn6.text != "")
            && (btn7.text != "") && (btn8.text != "") && (btn9.text != ""))
        {
            alertTie()
            disableButtons()
        }
    }

    fun alertX()
    {
        var alertX = AlertDialog.Builder(this)
        alertX.setTitle("X Player Wins!!")
        alertX.setMessage("X player Wins!! Play Again?")
        alertX.setPositiveButton("YES"){dialog, which ->
            btnReset()
            //Toast.makeText(applicationContext, "Reset",Toast.LENGTH_SHORT).show()
        }.setNegativeButton("NO"){dialog, which->

        }

        alertX.show()
    }

    fun alertO()
    {
        var alertO = AlertDialog.Builder(this)
        alertO.setTitle("O Player Wins!!")
        alertO.setMessage("O player Wins!! Play Again?")
        alertO.setPositiveButton("YES"){dialog, which ->
            btnReset()
            //Toast.makeText(applicationContext, "Reset",Toast.LENGTH_SHORT).show()
        }.setNegativeButton("NO"){dialog, which->

        }

        alertO.show()
    }

    fun alertTie()
    {
        var alertTie = AlertDialog.Builder(this)
        alertTie.setTitle("Tie!!")
        alertTie.setMessage("Tie!! Play Again!!")
        alertTie.setPositiveButton("YES"){dialog, which->
            //Toast.makeText(applicationContext, "Reset", Toast.LENGTH_SHORT).show()
        }.setNegativeButton("NO"){dialog, which->

        }

        alertTie.show()
    }

    fun btnReset()
    {
        btn1.text = ""
        btn2.text = ""
        btn3.text = ""
        btn4.text = ""
        btn5.text = ""
        btn6.text = ""
        btn7.text = ""
        btn8.text = ""
        btn9.text = ""

        btn1.isEnabled = true
        btn2.isEnabled = true
        btn3.isEnabled = true
        btn4.isEnabled = true
        btn5.isEnabled = true
        btn6.isEnabled = true
        btn7.isEnabled = true
        btn8.isEnabled = true
        btn9.isEnabled = true

        player = "P1"
    }

    fun disableButtons()
    {
        btn1.isEnabled = false
        btn2.isEnabled = false
        btn3.isEnabled = false
        btn4.isEnabled = false
        btn5.isEnabled = false
        btn6.isEnabled = false
        btn7.isEnabled = false
        btn8.isEnabled = false
        btn9.isEnabled = false
    }
}