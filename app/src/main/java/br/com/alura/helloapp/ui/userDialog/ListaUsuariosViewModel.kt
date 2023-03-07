package br.com.alura.helloapp.ui.userDialog

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.helloapp.database.UsuarioDao
import br.com.alura.helloapp.preferences.PreferencesKey
import br.com.alura.helloapp.util.ID_USUARIO_ATUAL
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListaUsuariosViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val dataStore: DataStore<Preferences>,
    private val usuarioDao: UsuarioDao
) : ViewModel() {

    private val usuarioAtual = savedStateHandle.get<String>(ID_USUARIO_ATUAL)

    private val _uiState = MutableStateFlow(ListaUsuariosUiState())
    val uiState: StateFlow<ListaUsuariosUiState>
        get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            carregaDados()
        }
    }

    private suspend fun carregaDados() {
        usuarioAtual?.let {
            val usuarioLogado = usuarioDao.buscaPorId(usuarioAtual).first()
            usuarioLogado?.let {
                _uiState.value = _uiState.value.copy(
                    nomeDeUsuario = usuarioLogado.idUsuario,
                    nome = usuarioLogado.nome
                )
            }
        }

        usuarioDao.buscaTodos().collect { outrasContas ->
            _uiState.value = _uiState.value.copy(
                outrasContas = outrasContas.filter {
                    it.idUsuario != usuarioAtual
                }
            )
        }
    }

    suspend fun atualizaUsuarioLogado(novoUsuario: String) {
        dataStore.edit {
            it[PreferencesKey.USUARIO_ATUAL] = novoUsuario
        }
    }
}