package com.example.lab_work_5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab_work_5.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        this.setTheme(R.style.ThemeOverlay_AppTheme_HighContrast)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonCalculate.setOnClickListener { onCalculateClicked() }
    }

    fun onCalculateClicked ()
    {
        val costStr = binding.costOfService.text.toString();
        val cost : Double? = costStr.toDoubleOrNull();
        if(cost == null)
        {
            binding.tipResult.text = "";
            return;
        }
        val slectedRadioButton = binding.tipOptions.checkedRadioButtonId

        val tipPercent = when(slectedRadioButton)
        {
            R.id.option_twenty_percent -> 0.20
            R.id.option_ten_percent -> 0.10
            else -> 0.05
        }

        var tip = cost * tipPercent
        val roundUp = binding.roundUpSwitch.isChecked

        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.calculated_result_hint, formattedTip)


    }
}