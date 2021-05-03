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

            val nota1 = num1.text.toString().toInt()
            val nota2 = num2.text.toString().toInt()
            val pesoN1 = peso1.text.toString().toInt()
            val pesoN2 = peso2.text.toString().toInt()

            calculaMedia(nota1, nota2, pesoN1, pesoN2)
        }
    }

    fun calculaMedia(nota1: Int, nota2: Int, pesoN1: Int, pesoN2: Int) {
        val media = (nota1 * pesoN1 + nota2 * pesoN2) / (pesoN1 + pesoN2)
        val resultado = binding.resultado
//        if(pesoN1 <= 1 || pesoN2 <= 1){
//         resultado.text = "Digite o peso válido"
//        }
        if (media >= 5) {
            resultado.text = "A nota final é $media \n Aluno Aprovado"
            resultado.setTextColor(getColor(R.color.green))
        } else {
            resultado.text = "A nota final é $media \n Aluno Reprovado"
            resultado.setTextColor(getColor(R.color.red))
        }
    }



}