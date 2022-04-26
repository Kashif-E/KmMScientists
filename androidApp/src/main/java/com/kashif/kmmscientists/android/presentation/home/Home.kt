package com.kashif.kmmscientists.android.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.get


@Composable
@Destination(start = true)
fun Home(
    navigator: DestinationsNavigator? = null,
    viewModel: HomeViewModel = get()
) {

    val state by  viewModel.list.collectAsState()
    Scaffold {
        Column(modifier = Modifier.padding(12.dp)) {

            Text(
                text = "Muslim Scientists",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primaryVariant
            )
            LazyColumn(content = {
                
                item { 
                    state.forEach { 
                        Text(text = it.fullName?:"")
                    }
                }

            })

        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun preview() {

    Home()

}
