package com.example.aplicativodegorjeta

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aplicativodegorjeta.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var percentage: Int = 0
        binding.rgOptionOne.setOnCheckedChangeListener { _, isChecked ->
            println(" opcao um:$isChecked")
            if (isChecked) {
                percentage = 10
            }
        }

        binding.rgOptionTwo.setOnCheckedChangeListener { _, isChecked ->
            println(" opcao dois:$isChecked")
            if (isChecked) {
                percentage = 15
            }
        }

        binding.rgOptionThree.setOnCheckedChangeListener { _, isChecked ->
            println(" opcao tres:$isChecked")
            if (isChecked) {
                percentage = 20
            }
        }

        binding.btnDone.setOnClickListener {

            val totalTableTemp = binding.tieNumberTotal.text
            val nPeopleTemp = binding.tieNumberPeople.text

            if (totalTableTemp?.isEmpty() == true ||
                nPeopleTemp?.isEmpty() == true
            ) {
                Snackbar.make(
                    binding.tieNumberTotal,
                    " Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            } else {
                val totalTable: Float = binding.tieNumberTotal.text.toString().toFloat()
                val nPeople: Int = binding.tieNumberPeople.text.toString().toInt()

                val totalTemp = totalTable / nPeople
                val tips = totalTemp * percentage / 100
                val totalWithTips = totalTemp + tips
                binding.tvResult.text = "Total with tips: $totalWithTips"
            }

            binding.btnClean.setOnClickListener {
                binding.tvResult.text = ""
                binding.tieNumberPeople.setText("")
                binding.tieNumberTotal.setText("")
                binding.rgOptionOne.isChecked = false
                binding.rgOptionTwo.isChecked = false
                binding.rgOptionThree.isChecked = false
            }

        }


    }

}

