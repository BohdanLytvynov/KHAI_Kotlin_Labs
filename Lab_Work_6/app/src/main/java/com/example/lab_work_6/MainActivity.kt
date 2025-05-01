package com.example.lab_work_6

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab_work_6.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val loginButton = binding.loginButton
        val loginInput = binding.loginInput
        val passwordInput = binding.passInput
        val loginResult = binding.loginResult

        loginButton.setOnClickListener {
            if(loginInput.text.isNullOrEmpty() || passwordInput.text.isNullOrEmpty()) {
                loginResult.text = "Login Failed!"
                loginResult.setTextColor(Color.RED)
            }
            else
            {
                loginResult.text = getString(R.string.WelcomeMsg, loginInput.text.toString())
                loginResult.setTextColor(Color.GREEN)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        this.setTheme(R.style.ThemeOverlay_AppTheme_MediumContrast)
    }
}