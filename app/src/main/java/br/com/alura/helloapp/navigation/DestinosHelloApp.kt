package br.com.alura.helloapp.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument
import br.com.alura.helloapp.util.ID_CONTATO
import br.com.alura.helloapp.util.ID_USUARIO_ATUAL

sealed class DestinosHelloApp(val rota: String) {
    object LoginGraph : DestinosHelloApp("grafico_login")
    object HomeGraph : DestinosHelloApp("grafico_home")
    object UsuariosGraph : DestinosHelloApp("grafico_usuarios")
    object SplashScreen : DestinosHelloApp("splashScreen")
    object ListaContatos : DestinosHelloApp("lista_contatos")
    object FormularioLogin : DestinosHelloApp("formulario_login")
    object Login : DestinosHelloApp("login")
    object BuscaContatos : DestinosHelloApp("busca_contatos")
    object GerenciaUsuarios : DestinosHelloApp("gerencia_usuarios")
}

object FormularioContato {
    const val rota = "formulario_contato"
    const val rotaComArgumentos = "$rota/{$ID_CONTATO}"
    val argumentos = listOf(
        navArgument(ID_CONTATO) {
            defaultValue = 0L
            type = NavType.LongType
        }
    )
}

object DetalhesContato {
    const val rota = "detalhes_contato"
    const val rotaComArgumentos = "$rota/{$ID_CONTATO}"
    val argumentos = listOf(
        navArgument(ID_CONTATO) {
            defaultValue = 0L
            type = NavType.LongType
        }
    )
}

object ListaUsuarios {
    const val rota = "lista_usuarios"
    const val rotaComArgumentos = "$rota/{$ID_USUARIO_ATUAL}"
    val argumentos = listOf(
        navArgument(ID_USUARIO_ATUAL) {
            type = NavType.StringType
        }
    )
}

object FormularioUsuario {
    const val rota = "formulario_usuario"
    const val rotaComArgumentos = "$rota/{$ID_USUARIO_ATUAL}"
    val argumentos = listOf(
        navArgument(ID_USUARIO_ATUAL) {
            type = NavType.StringType
        }
    )
}