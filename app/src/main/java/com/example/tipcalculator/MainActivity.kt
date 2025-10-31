package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TipCalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var estadoTextField1 by remember { mutableStateOf(" ") }
    var estadoTextField2 by remember { mutableStateOf(" ") }
    var result =0.0



    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(20.dp)
    ) {
        Text(
            text="Calculate Tip",
            fontSize = 20.sp
        )
        Spacer(modifier=Modifier.size(50.dp))

        TextField(
            value = estadoTextField1,
            onValueChange = {
                estadoTextField1 = it
            },
            label = { Text(text = "Cost of Service")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier=Modifier.size(20.dp))
        TextField(
            value = estadoTextField2,
            onValueChange = {
                estadoTextField2 = it
            },
            label = { Text(text = "Tip(%)")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )
        var checked by remember { mutableStateOf(true) }
        Spacer(modifier=Modifier.size(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Round up tip?"

            )
            Switch(
                checked = checked,
                onCheckedChange = {
                    checked = it
                }
            )
        }
        result = (estadoTextField1.toDoubleOrNull() ?: 0.0) / 100 * (estadoTextField2.toDoubleOrNull() ?: 0.0)
        if (checked){
            result=round(result)
        }
        Spacer(modifier=Modifier.size(30.dp))

        Text(
            text = "Tip Amount: $${result}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier=Modifier.size(30.dp))
        Spacer(modifier=Modifier.size(30.dp))
        Spacer(modifier=Modifier.size(30.dp))
        Spacer(modifier=Modifier.size(30.dp))
        Spacer(modifier=Modifier.size(30.dp))






    }
}

