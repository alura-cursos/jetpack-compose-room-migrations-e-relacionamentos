package br.com.alura.helloapp.ui.login

import androidx.lifecycle.ViewModel
import br.com.alura.helloapp.data.Usuario
import br.com.alura.helloapp.database.UsuarioDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FormularioLoginViewModel @Inject constructor(
    private val usuarioDao: UsuarioDao
) : ViewModel() {

    private val _uiState = MutableStateFlow(FormularioLoginUiState())
    val uiState: StateFlow<FormularioLoginUiState>
        get() = _uiState.asStateFlow()

    init {
        _uiState.update { state ->
            state.copy(
                onNomeMudou = {
                    _uiState.value = _uiState.value.copy(
                        nome = it
                    )
                },
                onUsuarioMudou = {
                    _uiState.value = _uiState.value.copy(
                        usuario = it
                    )
                },
                onSenhaMudou = {
                    _uiState.value = _uiState.value.copy(
                        senha = it
                    )
                }
            )
        }
    }

    suspend fun salvaLogin() {
        with(_uiState.value) {
            usuarioDao.insere(
                Usuario(
                    idUsuario = usuario,
                    senha = senha,
                    nome = nome
                )
            )
        }
    }
}