package br.com.alura.helloapp.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alura.helloapp.R
import br.com.alura.helloapp.extensions.mostraMensagem
import br.com.alura.helloapp.ui.details.DetalhesContatoTela
import br.com.alura.helloapp.ui.details.DetalhesContatoViewlModel
import br.com.alura.helloapp.util.ID_CONTATO
import kotlinx.coroutines.launch

fun NavGraphBuilder.detalhesContatoGraph(
    onVolta: () -> Unit,
    onNavegaParaDialgoUsuarios: (Long) -> Unit,
) {
    composable(
        route = DetalhesContato.rotaComArgumentos,
        arguments = DetalhesContato.argumentos
    ) { navBackStackEntry ->
        navBackStackEntry.arguments?.getLong(
            ID_CONTATO
        )?.let { idContato ->

            val viewModel = hiltViewModel<DetalhesContatoViewlModel>()
            val state by viewModel.uiState.collectAsState()

            val scope = rememberCoroutineScope()
            val context = LocalContext.current

            DetalhesContatoTela(
                state = state,
                onClickVolta = onVolta,
                onApagaContato = {
                    scope.launch {
                        viewModel.removeContato()
                        context.mostraMensagem(context.getString(R.string.contato_apagado))
                    }
                    onVolta()
                },
                onClickEdita = {
                    onNavegaParaDialgoUsuarios(idContato)
                })
        }
    }
}