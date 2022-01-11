package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var board: Array<Array<Button>>

    var boardStatus = Array(3) { IntArray(3) }
    var count = 0
    var PLAYER = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        board = arrayOf(
            arrayOf(button1,button2,button3),
            arrayOf(button4,button5,button6),
            arrayOf(button7,button8,button9)
        )

        initializeBoardStatus()

        for (i in board)
            for (btn in i)
                btn.setOnClickListener(this)

        resetBtn.setOnClickListener {
            count = 0
            PLAYER = true
            initializeBoardStatus()
            updateDisplay("PLAYER X TURN")
        }
    }

    private fun initializeBoardStatus() {
        for (i in 0..2)
            for (j in 0..2) {
                boardStatus[i][j] = -1
            }

        for (i in board)
            for (btn in i) {
                btn.isEnabled = true
                btn.text = ""
            }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.button1 -> {
                updateValue(row = 0, col = 0, player = PLAYER)
            }
            R.id.button2 -> {
                updateValue(row = 0, col = 1, player = PLAYER)
            }
            R.id.button3 -> {
                updateValue(row = 0, col = 2, player = PLAYER)
            }
            R.id.button4 -> {
                updateValue(row = 1, col = 0, player = PLAYER)
            }
            R.id.button5 -> {
                updateValue(row = 1, col = 1, player = PLAYER)
            }
            R.id.button6 -> {
                updateValue(row = 1, col = 2, player = PLAYER)
            }
            R.id.button7 -> {
                updateValue(row = 2, col = 0, player = PLAYER)
            }
            R.id.button8 -> {
                updateValue(row = 2, col = 1, player = PLAYER)
            }
            R.id.button9 -> {
                updateValue(row = 2, col = 2, player = PLAYER)
            }
        }

        PLAYER = !PLAYER
        count++

        if(PLAYER)
            updateDisplay("PLAYER X TURN")
        else
            updateDisplay("PLAYER O TURN")

        if(count == 9)
            updateDisplay("GAME DRAW")

        checkWinner()
    }

    private fun checkWinner() {
        for(i in 0..2)
            if(boardStatus[i][0] != -1 && boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2]) {
                if(boardStatus[i][0] == 1) {
                    updateDisplay("PLAYER X WINNER")
                    break
                }
                else if(boardStatus[i][0] == 1) {
                    updateDisplay("PLAYER O WINNER")
                    break
                }
            }

        for(i in 0..2)
            if(boardStatus[0][i] != -1 && boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i]) {
                if(boardStatus[0][i] == 1) {
                    updateDisplay("PLAYER X WINNER")
                    break
                }
                else if(boardStatus[0][i] == 0) {
                    updateDisplay("PLAYER O WINNER")
                    break
                }
            }

        if(boardStatus[0][0] != -1 && boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]) {
            if (boardStatus[0][0] == 1) {
                updateDisplay("PLAYER X WINNER")
            } else if (boardStatus[0][0] == 0) {
                updateDisplay("PLAYER O WINNER")
            }
        }

        if(boardStatus[0][2] != -1 && (boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0])) {
            if (boardStatus[0][2] == 1) {
                updateDisplay("PLAYER X WINNER")
            } else if (boardStatus[0][2] == 0) {
                updateDisplay("PLAYER O WINNER")
            }
        }
    }

    private fun updateDisplay(s: String) {
        displayTv.text = s
        if(s.contains("WINNER"))
            disableBtns()
    }

    private fun disableBtns() {
        for (i in board)
            for (btn in i)
                btn.isEnabled = false
    }

    private fun updateValue(row: Int, col: Int, player: Boolean) {
        val tex = if (player) "X" else "O"
        val value = if (player) 1 else 0

        board[row][col].apply {
            text = tex
            isEnabled = false
        }

        boardStatus[row][col] = value
    }
}