package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var board: Array<Array<Button>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        board = arrayOf(
            arrayOf(button1,button2,button3),
            arrayOf(button4,button5,button6),
            arrayOf(button7,button8,button9)
        )

        for (i in board)
            for (btn in i)
                btn.setOnClickListener(this)

        resetBtn.setOnClickListener {

        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.button1 -> {

            }
            R.id.button2 -> {

            }
            R.id.button3 -> {

            }
            R.id.button4 -> {

            }
            R.id.button5 -> {

            }
            R.id.button6 -> {

            }
            R.id.button7 -> {

            }
            R.id.button8 -> {

            }
            R.id.button9 -> {

            }
        }


    }
}