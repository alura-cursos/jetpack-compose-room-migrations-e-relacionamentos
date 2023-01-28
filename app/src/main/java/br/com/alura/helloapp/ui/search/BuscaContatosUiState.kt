package br.com.alura.helloapp.ui.search

import br.com.alura.helloapp.data.Contato

data class BuscaContatosUiState(
    val contatos: List<Contato> = emptyList(),
    val usuarioAtual: String? = null,
    val valorBusca: String = "",
    val onValorBuscaMudou: (String) -> Unit = {}
)