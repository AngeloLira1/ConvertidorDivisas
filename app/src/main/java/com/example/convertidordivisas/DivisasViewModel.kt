package com.example.convertidordivisas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DivisasViewModel : ViewModel() {

    private val tipoDeCambio = 3.75

    private val _resultado = MutableLiveData<String>()
    val resultado: LiveData<String> get() = _resultado

    fun convertirDolaresASoles(montoTexto: String) {
        val monto = montoTexto.toDoubleOrNull()
        if (monto == null) {
            _resultado.value = "Ingresa un monto válido"
            return
        }
        val total = monto * tipoDeCambio
        _resultado.value = String.format("S/ %.2f", total)
    }

    fun convertirSolesADolares(montoTexto: String) {
        val monto = montoTexto.toDoubleOrNull()
        if (monto == null) {
            _resultado.value = "Ingresa un monto válido"
            return
        }
        // Lógica de división encapsulada exclusivamente en el ViewModel
        val total = monto / tipoDeCambio
        _resultado.value = String.format("$ %.2f", total)
    }
}
