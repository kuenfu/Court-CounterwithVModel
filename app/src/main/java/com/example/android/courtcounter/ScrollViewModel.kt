package com.example.android.courtcounter

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.MutableLiveData

class ScoreViewModel : ViewModel() {
    // Tracks the score for Team A\

    private var scoreTeamA = MutableLiveData<String>()
    /* Called on app launch */
    init {
        /* expensive operation, e.g. network request */
        scoreTeamA.value = "0"
    }
    fun getscoreTeamA(): MutableLiveData<String> {
        return scoreTeamA
    }


    // Tracks the score for Team B
    var scoreTeamB = 0
}