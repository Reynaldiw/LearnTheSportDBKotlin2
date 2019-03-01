package com.reynaldiwijaya.learnthesportdbkotlin2.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.reynaldiwijaya.learnthesportdbkotlin2.Adapter.TeamAdapter
import com.reynaldiwijaya.learnthesportdbkotlin2.Model.TeamItem
import com.reynaldiwijaya.learnthesportdbkotlin2.Presenter.TeamContract
import com.reynaldiwijaya.learnthesportdbkotlin2.Presenter.TeamPresenter
import com.reynaldiwijaya.learnthesportdbkotlin2.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TeamContract.View {

    private lateinit var teamPresenter : TeamPresenter
    private lateinit var league : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        teamPresenter = TeamPresenter(this)

        val spinnerItem = resources.getStringArray(R.array.liga)
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerItem)

        swiperefresh.setOnRefreshListener {
            teamPresenter.getTeam(league)
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                league = spinner.selectedItem.toString()
                teamPresenter.getTeam(league)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}

        }

    }

    override fun showProgress() {
        swiperefresh.isRefreshing = true
    }

    override fun hideProgress() {
        swiperefresh.isRefreshing = false
    }

    override fun showTeamList(teams: List<TeamItem>) {
        rv_team.layoutManager = LinearLayoutManager(this)
        rv_team.adapter = TeamAdapter(this, teams)
    }

    override fun showFailureMessage(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
}
