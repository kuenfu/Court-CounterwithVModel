package com.example.android.courtcounter

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main3.*


class Main3Activity : AppCompatActivity() {
    // Tracks the score for Team A
    internal var scoreTeamA = 0

    // Tracks the score for Team B
    internal var scoreTeamB = 0
    private lateinit var mViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        mViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)
        val nameObserver =  Observer<String> { value ->
            value?.let {  team_a_score.text =it }
        }
        mViewModel.getscoreTeamA().observe(this, nameObserver)
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    fun addOneForTeamA(v: View) {
        mViewModel.getscoreTeamA().value= (mViewModel.getscoreTeamA().value?.toInt()?.plus(1)).toString()
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    fun addTwoForTeamA(v: View) {
        mViewModel.getscoreTeamA().value= (mViewModel.getscoreTeamA().value?.toInt()?.plus(2)).toString()
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    fun addThreeForTeamA(v: View) {
        mViewModel.getscoreTeamA().value= (mViewModel.getscoreTeamA().value?.toInt()?.plus(3)).toString()
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    fun addOneForTeamB(v: View) {
        scoreTeamB = scoreTeamB + 1
        displayForTeamB(scoreTeamB)
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    fun addTwoForTeamB(v: View) {
        scoreTeamB = scoreTeamB + 2
        displayForTeamB(scoreTeamB)
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    fun addThreeForTeamB(v: View) {
        scoreTeamB = scoreTeamB + 3
        displayForTeamB(scoreTeamB)
    }

    /**
     * Resets the score for both teams back to 0.
     */
    fun resetScore(v: View) {
        mViewModel.getscoreTeamA().value= "0"
        scoreTeamB = 0
//        displayForTeamA(mViewModel.scoreTeamA)
        displayForTeamB(scoreTeamB)
    }

    /**
     * Displays the given score for Team A.
     */
    fun displayForTeamA(score: Int) {
        team_a_score.text = score.toString()
    }

    /**
     * Displays the given score for Team B.
     */
    fun displayForTeamB(score: Int) {
        team_b_score.text = score.toString()
    }

}
