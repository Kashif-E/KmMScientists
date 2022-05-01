package com.kashif.kmmscientists.android.presentation.scientist_details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kashif.kmmscientists.android.R
import com.kashif.kmmscientists.android.presentation.theme.BlackHeader
import com.kashif.kmmscientists.domain.domain_model.ScientistDomainModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ScientistDetails(
    scientist: ScientistDomainModel
) {


    val scrollState = rememberScrollState()
    Column(
        Modifier
            .verticalScroll(scrollState)

    ) {
        Box(modifier = Modifier.height(300.dp)) {

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(scientist.image)
                    .crossfade(true)
                    .build(),

                contentDescription = stringResource(R.string.description),
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)

            )

            Text(
                text = scientist.name ?: "",
                color = Color.White,
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .background(MaterialTheme.colors.primary)
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            )


        }

        Heading(heading = "Title")
        Description(description = scientist.titles!!)
        makeDivider()

        Heading(heading = "Latinized Name:")
        Description(description = scientist.latinizedName!!)
        makeDivider()


        Heading(heading = "Origin:")
        Description(description = scientist.origin!!)
        makeDivider()

        Heading(heading = "Origin:")
        Description(description = scientist.origin!!)
        makeDivider()

        Heading(heading = "Birthplace:")
        Description(description = scientist.birthPlace!!)
        makeDivider()

        Heading(heading = "Date of birth:")
        Description(description = scientist.dob!!)
        makeDivider()

        Heading(heading = "Date of death:")
        Description(description = scientist.dod!!)
        makeDivider()

        Heading(heading = "Books:")

        scientist.books?.forEach {
            Description(description = it)
        }
        makeDivider()

        Heading(heading = "Achievements")
        Description(description = scientist.achievements?.toString() ?: "")


    }


}

@Composable
fun makeDivider() {
    Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier.padding(horizontal = 2.dp))

}

@Composable
fun Heading(heading: String) {

    Text(
        text = heading,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        modifier = Modifier.padding(8.dp)
    )

}

@Composable
fun Description(description: String) {

    Text(
        text = description,
        fontWeight = FontWeight.Medium,
        color = BlackHeader,
        modifier = Modifier.padding(8.dp)

    )

}


@Composable
@Preview(showSystemUi = true, showBackground = true)
fun PreviewDetails() {

    ScientistDetails(
        scientist = ScientistDomainModel(
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
    )
}