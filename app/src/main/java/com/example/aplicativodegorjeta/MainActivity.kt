package com.example.aplicativodegorjeta

import android.content.Intent
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

        binding.btnDone.setOnClickListener {

            val totalTableTemp = binding.tieTotal.text
            val numPeopleTemp = binding.tieNumPeople.text
            val percentegeTemp = binding.tiePercentege.text


            if (totalTableTemp?.isEmpty() == true ||
                numPeopleTemp?.isEmpty() == true ||
                percentegeTemp?.isEmpty() == true

            ) {
                Snackbar.make(
                    binding.tieTotal,
                    " Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            } else {
                val totalTable: Float = totalTableTemp.toString().toFloat()
                val nPeople: Int = numPeopleTemp.toString().toInt()
                val percentege: Int = percentegeTemp.toString().toInt()
                val totalTemp = totalTable / nPeople
                val tips = totalTemp * percentegeTemp.toString().toInt() / 100
                val totalWithTips = totalTemp + tips

                val intent = Intent(this, SummaryActivity::class.java)
                intent.apply {

                    putExtra("totalTable", totalTable)
                    putExtra("numPeople", nPeople)
                    putExtra("percentege", percentege)
                    putExtra("totalAmount", totalWithTips)
                }
                clean()
                startActivity(intent)
            }

            binding.btnClean.setOnClickListener {
                clean()
            }

        }


    }


    private fun clean() {
        binding.tieTotal.setText("")
        binding.tiePercentege.setText("")
        binding.tieNumPeople.setText("")
    }
}

