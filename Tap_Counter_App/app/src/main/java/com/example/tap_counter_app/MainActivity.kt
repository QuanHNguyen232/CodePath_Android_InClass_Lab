package com.example.tap_counter_app

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val upgradeBtn = findViewById<Button>(R.id.upgradeBtn)
        val addBtb = findViewById<Button>(R.id.addBtn)

        addBtb.setOnClickListener {
            Toast.makeText(it.context, "Clicked Button!", Toast.LENGTH_SHORT).show()

            counter++
            textView.text = counter.toString()

            if (counter >= 10){
                // Show upgrade button and set onClickListener
                upgradeBtn.visibility = View.VISIBLE
                upgradeBtn.setOnClickListener {
                    addBtb.text = "Add 2"
                    // Update original button to add 2 instead of 1
                    addBtb.setOnClickListener {
                        counter += 2
                        textView.text = counter.toString()
                    }
                    // Hide upgrade button again
                    upgradeBtn.visibility = View.INVISIBLE
                    // or upgradeBtn.visibility = true
                }
            }
        }
//        Use Log to debug if needed
//        Log.i("my_tag", "my_msg")
    }
}