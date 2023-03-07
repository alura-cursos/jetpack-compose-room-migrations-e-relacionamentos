package br.com.alura.helloapp.ui.userDialog

import br.com.alura.helloapp.data.Usuario

data class GerenciaUsuariosUiState(
    val usuarios: List<Usuario> = emptyList()
)