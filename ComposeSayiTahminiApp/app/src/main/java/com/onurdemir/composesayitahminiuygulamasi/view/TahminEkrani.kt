package com.onurdemir.composesayitahminiuygulamasi.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.onurdemir.composesayitahminiuygulamasi.R
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TahminEkrani(navController: NavController) {

    val tfTahmin = remember { mutableStateOf("") }
    val rastgeleSayi = remember { mutableStateOf(0) }
    val kalanHak = remember { mutableStateOf(5) }
    val yonlendirme = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LaunchedEffect(key1 = true,) {
            rastgeleSayi.value = Random.nextInt(101)
            Log.e("Rastgele Sayı", rastgeleSayi.value.toString())
        }

        Text(text = "Kalan Hak : ${kalanHak.value}", fontSize = 36.sp, color = Color.Red)
        Text(text = "Yardım : ${yonlendirme.value}", fontSize = 24.sp,)

        TextField(
            value = tfTahmin.value,
            onValueChange = { tfTahmin.value = it },
            label = { Text(text = "Tahmin") }
        )

        Button(onClick = {

            kalanHak.value = kalanHak.value -1
            val tahmin = tfTahmin.value.toInt()

            if (tahmin == rastgeleSayi.value) {
                navController.navigate("sonuc_ekrani/true") {
                    popUpTo("tahmin_ekrani") {inclusive = true}
                }
                return@Button
            }
            if (tahmin > rastgeleSayi.value) {
                yonlendirme.value = "Azalt"
            }
            if (tahmin < rastgeleSayi.value) {
                yonlendirme.value = "Arttır"
            }
            if (kalanHak.value == 0) {
                navController.navigate("sonuc_ekrani/false") {
                    popUpTo("tahmin_ekrani") {inclusive = true}
                }
            }
            tfTahmin.value = ""

        }, modifier = Modifier.size(250.dp, 50.dp)) {
            Text(text = "TAHMİN ET")
        }
    }
}