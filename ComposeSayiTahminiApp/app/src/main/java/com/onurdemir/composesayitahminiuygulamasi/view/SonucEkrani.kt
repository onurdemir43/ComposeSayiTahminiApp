package com.onurdemir.composesayitahminiuygulamasi.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onurdemir.composesayitahminiuygulamasi.R

@Composable
fun SonucEkrani(sonuc : Boolean) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (sonuc) {
            Text(text = "Kazandınız", fontSize = 36.sp)

            Image(painter = painterResource(id = R.drawable.mutlu_resim), contentDescription = "")
        } else {
            Text(text = "Kaybettiniz", fontSize = 36.sp)

            Image(painter = painterResource(id = R.drawable.uzgun_resim), contentDescription = "")
        }


    }
}