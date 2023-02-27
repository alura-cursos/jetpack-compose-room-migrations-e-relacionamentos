package br.com.alura.helloapp.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.helloapp.R
import br.com.alura.helloapp.ui.components.CaixaDialogoImagem
import br.com.alura.helloapp.ui.theme.HelloAppTheme
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun FormularioLoginTela(
    state: FormularioLoginUiState,
    modifier: Modifier = Modifier,
    onSalva: () -> Unit = {},
    onCarregaImagem: (String) -> Unit = {}
) {
    Column(Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(180.dp)
                    .clip(CircleShape)
                    .clickable {
                        state.onMostrarCaixaDialogoImagem(true)
                    },
                model = ImageRequest.Builder(LocalContext.current)
                    .data(state.fotoPerfil).build(),
                placeholder = painterResource(R.drawable.default_profile_picture),
                error = painterResource(R.drawable.default_profile_picture),
                contentScale = ContentScale.Crop,
                contentDescription = null,
            )
            Text(
                text = stringResource(R.string.adicionar_foto),
                style = MaterialTheme.typography.subtitle1
            )
        }
        Column(
            modifier
                .padding(16.dp)
                .weight(2f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            val focuAtual = LocalFocusManager.current
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Face, contentDescription = null
                    )
                },
                value = state.nome,
                onValueChange = state.onNomeMudou,
                label = { Text(stringResource(id = R.string.nome)) },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = (KeyboardActions(onNext = {
                    focuAtual.moveFocus(FocusDirection.Next)
                }))
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person, contentDescription = null
                    )
                },
                value = state.usuario,
                onValueChange = state.onUsuarioMudou,
                label = { Text(stringResource(id = R.string.usuario)) },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = (KeyboardActions(onNext = {
                    focuAtual.moveFocus(FocusDirection.Next)
                }))
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock, contentDescription = null
                    )
                },
                value = state.senha,
                onValueChange = state.onSenhaMudou,
                label = { Text(stringResource(id = R.string.senha)) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password, imeAction = ImeAction.Next
                ),
                keyboardActions = (KeyboardActions(onNext = { focuAtual.moveFocus(FocusDirection.Next) }))
            )

            Spacer(Modifier.height(16.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(56.dp),
                onClick = onSalva
            ) {
                Text(text = stringResource(R.string.criar))
            }

            if (state.mostrarCaixaDialogoImagem) {
                CaixaDialogoImagem(
                    state.fotoPerfil,
                    onFotoPerfilMudou = state.onFotoPerfilMudou,
                    onClickDispensar = { state.onMostrarCaixaDialogoImagem(false) },
                    onClickSalvar = { onCarregaImagem(it) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CadastroLoginScreenPreview() {
    HelloAppTheme {
        FormularioLoginTela(FormularioLoginUiState())
    }
}