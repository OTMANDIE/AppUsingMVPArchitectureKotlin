package com.example.activityusingmvpkotlin.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.example.activityusingmvpkotlin.Model.Model
import com.example.activityusingmvpkotlin.Presenter.Presenter
import com.example.activityusingmvpkotlin.R
import com.example.activityusingmvpkotlin.Util.Contract

class MainActivity : AppCompatActivity(), Contract.View {

    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        button = findViewById<Button>(R.id.button)
        progressBar = findViewById(R.id.progressBar)
        presenter = Presenter(this, Model())

        button.setOnClickListener {
            presenter.onButtonClick()
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
        textView.visibility = View.INVISIBLE

    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
        textView.visibility = View.VISIBLE
    }

    override fun setString(string: String?) {
        textView.text = string
    }
}