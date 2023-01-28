package br.com.alura.helloapp.ui.userDialog

data class FormularioUsuarioUiState(
    val nomeUsuario: String = "",
    val nome: String = "",
    val senha: String = "",
    val onNomeMudou: (String) -> Unit = {},
    val mostraMensagemExclusao: Boolean = false,
    val mostraMensagemExclusaoMudou: (Boolean) -> Unit = {},
)