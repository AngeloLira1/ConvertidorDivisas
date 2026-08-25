package com.example.convertidordivisas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class DivisasActivity : AppCompatActivity() {

    private val viewModel: DivisasViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etMonto = findViewById<EditText>(R.id.etMonto)
        val btnDolaresASoles = findViewById<Button>(R.id.btnDolaresASoles)
        val btnSolesADolares = findViewById<Button>(R.id.btnSolesADolares)
        val tvResultadoDivisas = findViewById<TextView>(R.id.tvResultadoDivisas)

        btnDolaresASoles.setOnClickListener {
            viewModel.convertirDolaresASoles(etMonto.text.toString())
        }

        btnSolesADolares.setOnClickListener {
            viewModel.convertirSolesADolares(etMonto.text.toString())
        }

        viewModel.resultado.observe(this) { resultado ->
            tvResultadoDivisas.text = resultado
        }
    }
}