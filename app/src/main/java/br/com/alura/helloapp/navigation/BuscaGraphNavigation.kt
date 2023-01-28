package br.com.alura.helloapp.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alura.helloapp.ui.search.BuscaContatosTela
import br.com.alura.helloapp.ui.search.BuscaContatosViewModel

fun NavGraphBuilder.buscaContatosGraph(
    onVolta: () -> Unit,
    onClickNavegaParaDetalhesContato: (Long) -> Unit
) {
    composable(route = DestinosHelloApp.BuscaContatos.rota) {
        val viewModel = hiltViewModel<BuscaContatosViewModel>()
        val state by viewModel.uiState.collectAsState()

        BuscaContatosTela(
            state = state,
            onClickVolta = onVolta,
            onClickAbreDetalhes = { idContato ->
                onClickNavegaParaDetalhesContato(idContato)
            })

    }
}