package com.example.aplicativodegorjeta

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aplicativodegorjeta.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val totalTable = intent.getFloatExtra("totalTable", 0.0f)
        val numPeople = intent.getIntExtra("numPeople", 0)
        val percentege = intent.getIntExtra("percentege", 0)
        val totalAmount = intent.getFloatExtra("totalAmount", 0.0f)

        binding.tvPercentege.text = percentege.toString() + "%"
        binding.tvTotalAmount.text = totalAmount.toString()
        binding.tvTotalTable.text = totalTable.toString()
        binding.tvNumPeopleTable.text = numPeople.toString()

        binding.btnNovoCalculo.setOnClickListener {
            finish()
        }

    }

}
