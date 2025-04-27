package com.example.lab_work3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HelloDroidActivity : AppCompatActivity()
{
    private var textMessage : TextView? = null
    private var clickButton : Button? = null
    private var counter : Int = 0;

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main))
        { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Setup initial bindings
        textMessage = findViewById(R.id.welcometext)
        clickButton = findViewById(R.id.click)

        clickButton?.setOnClickListener { OnClick() }

    }

    private fun OnClick()
    {
        textMessage?.setText(String.format("Lytvynov clicked the button %s times!", ++counter))
    }
}