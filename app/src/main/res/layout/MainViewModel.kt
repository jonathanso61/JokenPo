package com.ifmg.jokenpo

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var playerChoice: String = ""
    var cpuChoice: String = ""
    var playerScore: Int = 0
    var cpuScore: Int = 0

    fun onChoiceSelected(choice: String) {
        playerChoice = choice
        generateCpuChoice()
        determineWinner()
    }

    fun resetChoices() {
        playerChoice = ""
        cpuChoice = ""
    }

    private fun generateCpuChoice() {
        val choices = arrayOf("tesoura", "pedra", "papel")
        cpuChoice = choices.random()
    }

    private fun determineWinner() {
        if ((playerChoice == "tesoura" && cpuChoice == "papel") ||
            (playerChoice == "pedra" && cpuChoice == "tesoura") ||
            (playerChoice == "papel" && cpuChoice == "pedra")
        ) {
            playerScore++
        } else if ((cpuChoice == "tesoura" && playerChoice == "papel") ||
            (cpuChoice == "pedra" && playerChoice == "tesoura") ||
            (cpuChoice == "papel" && playerChoice == "pedra")
        ) {
            cpuScore++
        }
    }
}
