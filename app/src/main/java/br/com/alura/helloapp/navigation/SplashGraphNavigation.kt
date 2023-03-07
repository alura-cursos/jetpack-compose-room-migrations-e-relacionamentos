package br.com.alura.helloapp.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alura.helloapp.ui.splashscreen.AppState
import br.com.alura.helloapp.ui.splashscreen.SplashScreenViewModel

fun NavGraphBuilder.splashGraph(
    onNavegaParaLogin: () -> Unit,
    onNavegaParaHome: () -> Unit
) {
    composable(
        route = DestinosHelloApp.SplashScreen.rota
    ) {
        val viewModel = hiltViewModel<SplashScreenViewModel>()
        val state by viewModel.uiState.collectAsState()

        when (state.appState) {
            AppState.Carregando -> Box(Modifier.fillMaxSize()) {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
            AppState.Deslogado -> {
                LaunchedEffect(Unit) {
                    onNavegaParaLogin()
                }
            }
            AppState.Logado -> {
                LaunchedEffect(Unit) {
                    onNavegaParaHome()
                }
            }
        }
    }
}

