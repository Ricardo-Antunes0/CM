package com.example.homework2

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.homework2.ui.theme.Homework2Theme
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Icon
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.core.content.ContextCompat.startActivity



class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Homework2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    dialer(this@MainActivity)
                }
            }
        }
    }
}



@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun dialer(activity: ComponentActivity) {
    var phoneNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        TextField(
            value = phoneNumber,
            onValueChange = {
                phoneNumber = it
            },
            textStyle = LocalTextStyle.current.copy(fontSize = 24.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            singleLine = true,
            maxLines = 1,
        )

        Spacer(modifier = Modifier.height(32.dp)) // Espaçador vertical
        // Linha 1 para os botões: 1, 2 e 3
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            for (i in 1..3) {
                DialerButton(text = i.toString(), onClick = { phoneNumber += i.toString() })
            }
        }


        // Linha 2 de botões: 4, 5 e 6
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            for (i in 4..6) {
                DialerButton(text = i.toString(), onClick = { phoneNumber += i.toString() })
            }
        }
        //Spacer(modifier = Modifier.height(.dp)) // Espaçador vertical

        // Linha 3 de botões: 7, 8 e 9
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            for (i in 7..9) {
                DialerButton(text = i.toString(), onClick = { phoneNumber += i.toString() })
            }
        }
        //Spacer(modifier = Modifier.height(0.dp)) // Espaçador vertical

        // Linha 4 de botões: *, 0 e #
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            DialerButton(
                text = "*",
                onClick = { phoneNumber += "*" }
            )
            DialerButton(
                text = "0",
                onClick = { phoneNumber += "0" }
            )
            DialerButton(
                text = "#",
                onClick = { phoneNumber += "#" }
            )
        }
        //Spacer(modifier = Modifier.height(128.dp)) // Espaçador vertical
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            DialerButton(text = "Não Faz Nada", onClick = {})

            Button(
                onClick = {
                    if (phoneNumber.isNotEmpty()) {
                        val dialUri = "tel:$phoneNumber"
                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse(dialUri))
                        //startActivity(intent)
                    }
                },
                modifier = Modifier.size(64.dp),
            ) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "Chamar",
                    tint = Color.White,
                )
            }

            Button(
                onClick = {
                    if (phoneNumber.isNotEmpty()) {
                        phoneNumber = phoneNumber.dropLast(1)
                    }
                },
                modifier = Modifier.size(64.dp),
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Apagar",
                    tint = Color.White,
                )
            }
        }
    }
}

@Composable
fun DialerButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .size(64.dp)
    ) {
        Text(text = text, fontSize = 24.sp)
    }
}

//@RequiresApi(Build.VERSION_CODES.O)
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
    //Homework2Theme {
        //dialer(this@MainActivity)
    //}
//}