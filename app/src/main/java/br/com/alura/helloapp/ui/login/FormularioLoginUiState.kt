package br.com.alura.helloapp.ui.login

data class FormularioLoginUiState(
    val nome: String = "",
    val usuario: String = "",
    val senha: String = "",
    val onNomeMudou: (String) -> Unit = {},
    val onUsuarioMudou: (String) -> Unit = {},
    val onSenhaMudou: (String) -> Unit = {},
    val onClickSalvar: () -> Unit = {},

    val fotoPerfil: String = "",
    val mostrarCaixaDialogoImagem: Boolean = false,
    val onFotoPerfilMudou: (String) -> Unit = {},
    val onMostrarCaixaDialogoImagem: (mostrar: Boolean) -> Unit = {},
)