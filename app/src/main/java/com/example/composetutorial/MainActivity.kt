package com.example.composetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {//define o layout da atividade
            ComposeTutorialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                }
            }
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {//adiciona linha com padding
        Image(//adiciona imagem
            painter = painterResource(R.drawable.avatar),//caminho da imagem
            contentDescription = null,//descricao da imagem
            modifier = Modifier
                .size(40.dp)//tamanho da imagem
                .clip(CircleShape)//deixa imagem redonda
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)//adiciona borda na imagem
        )
        Spacer(modifier = Modifier.width(8.dp))//adiciona espaco

        Column {//cria uma coluna
            Text(
                text = msg.author,//coloca texto na tela
                color = MaterialTheme.colors.secondary, //muda cor do texto
                style = MaterialTheme.typography.subtitle1 //tipo do texto
            )

            Spacer(modifier = Modifier.height(4.dp))//adiciona espaco

            Surface(shape = MaterialTheme.shapes.medium) {
                Text(//adiciona texto na tela
                    text = msg.body, //pega texto da variavel body
                    modifier = Modifier.padding(all = 4.dp), //adiciona paddind
                    style = MaterialTheme.typography.body1 //tipo do texto
                )
            }
        }
    }
}

@Preview(name = "Light Mode")//modo light
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"//modo dark
)

@Preview
@Composable
fun PreviewMessageCard() {
    ComposeTutorialTheme {
        Surface {
            MessageCard(
                msg = Message("João", "Hey, take a look at Jetpack Compose, it's great!")//define variavel author e body
            )
        }
    }
}


