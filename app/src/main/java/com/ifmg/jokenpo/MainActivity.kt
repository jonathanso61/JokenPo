package com.ifmg.jokenpo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ifmg.jokenpo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this // Para LiveData atualizar a interface do usuário automaticamente

        val tesouraButton = binding.botaotesoura
        val pedraButton = binding.botaopedra
        val papelButton = binding.botaopapel
        val novaPartidaButton = binding.botaonovapartida

        tesouraButton.setOnClickListener { viewModel.onChoiceSelected("tesoura") }
        pedraButton.setOnClickListener { viewModel.onChoiceSelected("pedra") }
        papelButton.setOnClickListener { viewModel.onChoiceSelected("papel") }

        novaPartidaButton.setOnClickListener { viewModel.resetChoices() }
    }
}


