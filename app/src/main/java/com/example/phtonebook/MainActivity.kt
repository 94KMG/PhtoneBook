package com.example.phtonebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phtonebook.ui.theme.PhtoneBookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PhtoneBookTheme {
                PhtoneBookApp()

            }
        }
    }
}

@Composable
fun PhtoneBookApp(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        var userName by remember { mutableStateOf("") }
        var phoneNumb by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var isInputValid by remember { mutableStateOf(false) }
        var inputEmail by remember { mutableStateOf("") }
        var inputPhone by remember { mutableStateOf("") }
        var inputName by remember { mutableStateOf("") }
        //save
        TextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text("Name: ") }
        )

        TextField(
            value = phoneNumb,
            onValueChange = { phoneNumb = it },
            label = { Text("phone number: ") }
        )

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("input email: ") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if(isInputValid == false){
                inputName = userName
                inputPhone = phoneNumb
                inputEmail = email
                isInputValid = true
            }else{
                inputName = ""
                inputPhone = ""
                inputEmail = ""
                isInputValid = false
            }



        }) {
            Text("Save")
        }//save
        Spacer(modifier = Modifier.height(16.dp))
        Text("User Name: $inputName")
        Text("Phone Number: $inputPhone")
        Text("Email: $inputEmail")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PhtoneBookTheme {
        PhtoneBookApp()
    }
}


