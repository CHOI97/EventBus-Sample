package com.example.eventbus

import TestWidget
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val root = findViewById<ConstraintLayout>(R.id.main)
        val testWidget = TestWidget(this)

        root.addView(testWidget)
    }
}