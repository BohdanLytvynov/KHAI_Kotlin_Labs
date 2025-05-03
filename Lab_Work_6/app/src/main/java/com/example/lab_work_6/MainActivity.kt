package com.example.lab_work_6

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab_work_6.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            onLoginButtonClick()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        this.setTheme(R.style.ThemeOverlay_AppTheme_MediumContrast)
    }

    fun onLoginButtonClick () {

        if(binding.loginInput.text.isNullOrEmpty() &&
            binding.passInput.text.isNullOrEmpty()) {

            binding.loginResult.text = "Login Failed!"
            binding.loginResult.setTextColor(Color.RED)
        }
        else
        {
            binding.loginResult.text = "Welcome! ${binding.loginInput.text}"
            binding.loginResult.setTextColor(Color.GREEN)
        }
    }
}