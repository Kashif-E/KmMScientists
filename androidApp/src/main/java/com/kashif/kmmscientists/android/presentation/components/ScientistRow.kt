package com.kashif.kmmscientists.android.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kashif.kmmscientists.android.R
import com.kashif.kmmscientists.domain.domain_model.ScientistDomainModel


@Composable
fun ScientistCard(scientist: ScientistDomainModel, onClick :()-> Unit) {

    Card(
        modifier = Modifier
            .padding()
            .height(150.dp).fillMaxWidth()
            .padding(12.dp).clickable {
                           onClick()
            },
        shape = RoundedCornerShape(12.dp),
        elevation = 8.dp
    ) {
        Row(
            Modifier.padding(8.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(scientist.image)
                    .crossfade(true)
                    .build(),

                contentDescription = stringResource(R.string.description),
                contentScale = ContentScale.Crop,
                modifier = Modifier.width(100.dp)

                )
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = scientist.fullName ?: "",
                   fontWeight = FontWeight.Bold
                )
                Text(text = scientist.titles ?:"")
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    ScientistCard(
        ScientistDomainModel(
            id = 0,
            fullName = "Kashif Mehmood",
            name = "kashif mehmood",
            latinizedName = "mehmood",
            description = "Greatest of all,",
            origin = "Pakistani",
            image = "",
            birthPlace = "haripur",
            dob = "12-16-1996",
            dod = "--",
            books = emptyList(),
            titles = "The Greatest Full Stack Mobile Developer",
            achievements = listOf(
                "This repo :P"
            )

        )
    ){

    }
}
