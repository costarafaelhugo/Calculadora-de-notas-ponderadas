package com.hugorafaelcosta.agendadenotasponderadas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hugorafaelcosta.agendadenotasponderadas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCalcular.setOnClickListener {
            val num1 = binding.nota1
            val num2 = binding.nota2
            val peso1 = binding.PesoNota1
            val peso2 = binding.PesoNota2
            val resultado = binding.resultado

            val nota1 = Integer.parseInt(num1.text.toString())
            val nota2 = Integer.parseInt(num2.text.toString())
            val pesoN1 = Integer.parseInt(peso1.text.toString())
            val pesoN2 = Integer.parseInt(peso2.text.toString())

            val media = (nota1 * pesoN1 + nota2 * pesoN2) / (pesoN1 + pesoN2)

            if (media >= 5) {
                resultado.setText("A nota final é $media \n Aluno Aprovado")
                resultado.setTextColor(getColor(R.color.green))
            } else {
                resultado.setText("A nota final é $media \nAluno Reprovado")
                resultado.setTextColor(getColor(R.color.red))
            }
        }
    }
}