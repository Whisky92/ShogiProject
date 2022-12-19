package com.example.rockpaperscissors.model

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shogiproject.databinding.FragmentRpsGameBinding
import java.util.concurrent.ThreadLocalRandom

class RockPaperScissors(drawNumber: Int) : ViewModel() {


    private var _playerWins: MutableLiveData<Int> = MutableLiveData<Int>()
    val playerWins: LiveData<Int>
        get() = _playerWins
    private var _botWins: MutableLiveData<Int> = MutableLiveData<Int>()
    val botWins: LiveData<Int>
        get() = _botWins
    private var _draws: MutableLiveData<Int> = MutableLiveData<Int>()
    val draws: LiveData<Int>
        get() = _draws

    init {
        _playerWins.value = 0

        _botWins.value = 0
        if (drawNumber > 0) {
            _draws.value = drawNumber
        } else {
            _draws.value = 0
        }
    }

    fun rollBotNumber(): Int {
        return ThreadLocalRandom.current().nextInt(3) + 1
    }

    fun chooseWinner(playerChoice: Int, botChoice: Int) { //1: rock, 2: paper, 3: scissors
        if (playerChoice == botChoice) {
            _draws.value?.let { a ->
                _draws.value = a + 1
            }
        } else if ((botChoice == 1 && playerChoice == 3) || (botChoice == 2 && playerChoice == 1) || (botChoice == 3 && playerChoice == 2)) {
            _botWins.value?.let { a ->
                _botWins.value = a + 1
            }
        } else {
           _playerWins.value?.let { a ->
               _playerWins.value = a + 1
           }
        }
    }

    fun newTurn() {
        _playerWins.value = 0
        _botWins.value = 0
        _draws.value = 5
    }

}