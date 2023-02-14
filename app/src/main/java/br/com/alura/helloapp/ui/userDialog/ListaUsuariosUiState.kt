package br.com.alura.helloapp.ui.userDialog

import br.com.alura.helloapp.data.Usuario

data class ListaUsuariosUiState(
    val nomeDeUsuario: String? = null,
    val nome: String? = null,
    val outrasContas: List<Usuario> = emptyList()
)