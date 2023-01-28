package br.com.alura.helloapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import br.com.alura.helloapp.navigation.*

@Composable
fun HelloAppNavHost(
    navController: NavHostController, modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinosHelloApp.SplashScreen.rota,
        modifier = modifier
    ) {
        splashGraph(
            onNavegaParaLogin = {
                navController.NavegaParaLoginElimpaBackStack()
            },
            onNavegaParaHome = {
                navController.navegaParaHome()
            },
        )
        loginGraph(
            onNavegaParaHome = {
                navController.navegaParaHome()
            },
            onNavegaParaFormularioLogin = {
                navController.navegaParaFormlarioLogin()
            },
            onNavegaParaLogin = {
                navController.NavegaParaLoginElimpaBackStack()
            },
        )
        homeGraph(
            onNavegaParaDetalhes = { idContato ->
                navController.navegaParaDetalhes(idContato)
            },
            onNavegaParaFormularioContato = {
                navController.navegaParaFormularioContato()
            },
            onNavegaParaDialgoUsuarios = { idUsuario ->
                navController.navegaParaDialgoUsuarios(idUsuario)
            },
            onNavegaParaBuscaContatos = {
                navController.navegaParaBuscaContatos()
            }
        )
        formularioContatoGraph(
            onVolta = {
                navController.popBackStack()
            },
        )
        detalhesContatoGraph(
            onVolta = {
                navController.popBackStack()
            },
            onNavegaParaDialgoUsuarios = { idContato ->
                navController.navegaParaFormularioContato(idContato)
            },
        )
        usuariosGraph(
            onVolta = {
                navController.popBackStack()
            },
            onNavegaParaLogin = {
                navController.navegaParaLogin()
            },
            onNavegaParaHome = {
                navController.navegaParaHome()
            },
            onNavegaGerenciaUsuarios = {
                navController.navegaParaGerenciaUsuarios()
            },
            onNavegaParaFormularioUsuario = { idUsuario ->
                navController.navegaParaFormularioUsuario(idUsuario)
            },
        )
        buscaContatosGraph(
            onVolta = {
                navController.popBackStack()
            },
            onClickNavegaParaDetalhesContato = { idContato ->
                navController.navegaParaDetalhes(idContato)
            },
        )
    }
}


fun NavHostController.navegaDireto(rota: String) = this.navigate(rota) {
    popUpTo(this@navegaDireto.graph.findStartDestination().id) {
        saveState = true
    }
    launchSingleTop = true
    restoreState = true
}

fun NavHostController.navegaLimpo(rota: String) = this.navigate(rota) {
    popUpTo(0)
}

fun NavHostController.navegaParaDetalhes(idContato: Long) {
    navegaDireto("${DetalhesContato.rota}/$idContato")
}

fun NavHostController.navegaParaFormularioContato(idContato: Long = 0L) {
    navigate("${FormularioContato.rota}/$idContato")
}

fun NavHostController.NavegaParaLoginElimpaBackStack() {
    navegaLimpo(DestinosHelloApp.LoginGraph.rota)
}

fun NavHostController.navegaParaDialgoUsuarios(idUsuario: String) {
    navigate("${ListaUsuarios.rota}/$idUsuario")
}

fun NavHostController.navegaParaFormularioUsuario(idUsuario: String) {
    navigate("${FormularioUsuario.rota}/$idUsuario")
}

fun NavHostController.navegaParaLogin() {
    navigate(DestinosHelloApp.Login.rota)
}

fun NavHostController.navegaParaHome() {
    navegaLimpo(DestinosHelloApp.HomeGraph.rota)
}

fun NavHostController.navegaParaFormlarioLogin() {
    navigate(DestinosHelloApp.FormularioLogin.rota)
}

fun NavHostController.navegaParaGerenciaUsuarios() {
    navigate(DestinosHelloApp.GerenciaUsuarios.rota)
}

fun NavHostController.navegaParaBuscaContatos() {
    navigate(DestinosHelloApp.BuscaContatos.rota)
}
