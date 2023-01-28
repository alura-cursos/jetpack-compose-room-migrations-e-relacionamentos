package br.com.alura.helloapp.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import br.com.alura.helloapp.ui.home.ListaContatosTela
import br.com.alura.helloapp.ui.home.ListaContatosViewModel

fun NavGraphBuilder.homeGraph(
    onNavegaParaDetalhes: (Long) -> Unit,
    onNavegaParaFormularioContato: () -> Unit,
    onNavegaParaDialgoUsuarios: (String) -> Unit,
    onNavegaParaBuscaContatos: () -> Unit
) {
    navigation(
        startDestination = DestinosHelloApp.ListaContatos.rota,
        route = DestinosHelloApp.HomeGraph.rota,
    ) {
        composable(route = DestinosHelloApp.ListaContatos.rota) {
            val viewModel = hiltViewModel<ListaContatosViewModel>()
            val state by viewModel.uiState.collectAsState()

            ListaContatosTela(
                state = state,
                onClickAbreDetalhes = { idContato ->
                    onNavegaParaDetalhes(idContato)
                },
                onClickAbreCadastro = {
                    onNavegaParaFormularioContato()
                },
                onClickListaUsuarios = {
                    // state.usuarioAtual?.let { usuarioAtual ->
                    onNavegaParaDialgoUsuarios("usuarioAtual")
                    // }
                },
                onClickBuscaContatos = onNavegaParaBuscaContatos
            )
        }
    }
}
