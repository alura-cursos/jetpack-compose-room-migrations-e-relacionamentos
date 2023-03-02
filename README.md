# HelloApp

HelloApp é um aplicativo que permite salvar informações de contatos (como número de telefone, data de aniversário e foto de perfil) em diferentes contas de usuário.

## :hammer: Funcionalidades do projeto

Uma extensão do [App base](https://github.com/alura-cursos/HelloApp), com melhorias de código e adição das funcionalidades:

- Perfis de usuário
- Relacionamento de tabelas
- Gerenciamento de versões do banco com Migrations

<img src="https://user-images.githubusercontent.com/35709152/222444890-70fb523d-758b-41b9-a6c1-1967faaea1cf.gif" alt = "helloApp gif fluxo login" width="300">


## 🏠 Arquitetura

- Navigation com Saved State Handle
- Room Database / DataStore
- Kotlin Coroutines e Flow
- ViewModel com StateFlow
- Hilt (injeção de dependência)

## ✔️ Outras técnicas e tecnologias utilizadas

- Kotlin
- Jetpack Compose
- Compose BOM
- [Coil](https://coil-kt.github.io/coil/)
- [LocalDate](https://developer.android.com/reference/java/time/LocalDate) do Java 8+, compatível com versões abaixo do Android 8 graças ao [desugaring support](https://developer.android.com/studio/write/java8-support#library-desugaring)

## 📂 Acesso ao projeto

- Versão inicial: Veja o [código fonte](https://github.com/alura-cursos/jetpack-compose-room-migrations-e-relacionamentos/tree/projeto-base) ou [baixe o projeto](https://github.com/alura-cursos/jetpack-compose-room-migrations-e-relacionamentos/archive/refs/heads/projeto-base.zip)
- Versão final: Veja o [código fonte](https://github.com/alura-cursos/jetpack-compose-room-migrations-e-relacionamentos/tree/aula-5) ou [baixe o projeto](https://github.com/alura-cursos/jetpack-compose-room-migrations-e-relacionamentos/archive/refs/heads/aula-5.zip)

## 🛠️ Abrir e rodar o projeto

Após baixar o projeto, você pode abri-lo com o Android Studio. Para isso, na tela de launcher clique em:

“Open” (ou alguma opção similar), procure o local onde o projeto está e o selecione (caso o projeto seja baixado via zip, é necessário extraí-lo antes de procurá-lo). Por fim, clique em “OK” o Android Studio deve executar algumas tasks do Gradle para configurar o projeto, aguarde até finalizar. Ao finalizar as tasks, você pode executar o App 🏆

## 🎯 Desafios

- Avatar de usuário no banco - [Veja a solução](https://github.com/alura-cursos/jetpack-compose-room-migrations-e-relacionamentos/commit/ac44a1cf27bc0213947c7c4c8ae28ec6b376c66e)
<img src="https://user-images.githubusercontent.com/35709152/222423462-1ac4c408-3881-4043-9785-cbb1038684e9.gif" alt = "helloApp gif desafio 1" width="200">
