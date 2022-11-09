package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {//define o layout da atividade
            MessageCard(Message("Android", "Jetpack Compose"))
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {//adiciona padding
        Image(//adiciona imagem
            painter = painterResource(R.drawable.avatar),//caminho da imagem
            contentDescription = "Contact profile picture",//descricao da imagem
            modifier = Modifier
                .size(40.dp)//tamanho da imagem
                .clip(CircleShape) //deixa imagem redonda
        )

        Spacer(modifier = Modifier.width(8.dp)) //adiciona espaco horizontal entre a imagem e a coluna

        Column {//adiciona uma coluna
            Text(text = msg.author)//adiciona texto da variavel author (funcao PreviewMessageCard)
            Spacer(modifier = Modifier.height(4.dp)) //adiciona espaço entre o author e a mensagem
            Text(text = msg.body)//mostra a mensagem da variavel body (funcao PreviewMessageCard)
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard(){//funcao PreviewMessageCard
    MessageCard(//define a variavel author e body
        msg = Message("João", "Hey, take a look at Jetpack Compose, it's great!")
    )
}


