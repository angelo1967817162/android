package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.myapplication.ui.theme.MyApplicationTheme
import mooveApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                mooveApp()

            }
        }
    }
}
enum class mooveScreen() {
    Start,
    AfficherCours,
    Login
}
/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}
@Preview
@Composable
fun HelloPreview() {
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.surfaceBright
        ){
            Greeting("Mme Brodard")
        }
    }

    val image = painterResource(R.drawable.smiley)
    @Composable
    fun Hello(name: String, modifier : Modifier=Modifier) {
        val image = painterResource(R.drawable.smiley)
        Column (verticalArrangement = Arrangement.Center,
        )
        {
            Text(
                text = "Hello $name!",
                fontSize = 36.sp,
                lineHeight = 116.sp,
            )
            Image(
                painter = image,
                contentDescription = "Smiley qui sourit"
            )
        }
    }

}*/