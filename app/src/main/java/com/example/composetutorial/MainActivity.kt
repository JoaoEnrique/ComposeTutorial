package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {//define o layout da atividade
            Text("Hello Word!")//mostra uma mensagem na tela
        }
    }
}

@Composable // função composta
fun MessageCard(name: String) { //função MessageCard que recebe um nome
    Text(text = "Hello $name!")//mostrar um texto com o nome
}

//@Preview  permite visualizar as funções de composição, não pode ser usada na MessageCard por ela
// possiuir parametros, então é criado a função PreviewMessageCard
@Preview
@Composable // função composta
fun PreviewMessageCard() {//Função PreviewMessageCard
    MessageCard("Android")//Chama Função MessageCard passando um nome como parametro
}
