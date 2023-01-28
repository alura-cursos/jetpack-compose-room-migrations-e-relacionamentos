package br.com.alura.helloapp.ui.home

import br.com.alura.helloapp.data.Contato

data class ListaContatosUiState(
    val contatos: List<Contato> = emptyList(),
    val logado: Boolean = true
)