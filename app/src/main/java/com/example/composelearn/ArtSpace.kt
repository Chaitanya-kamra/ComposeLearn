package com.example.composelearn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelearn.ui.theme.ComposeLearnTheme


@Composable
fun ArtSpaceScreen() {
    val testList = listOf(Pair("moneyhjgvjhvjhvjhbkhjbvjhkbvjhvjhvjhvhvhjhjvhjvhvjhjv",R.drawable.money),Pair("percent",R.drawable.percent),Pair("launcher",R.drawable.ic_launcher_foreground))
   var count by remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier = Modifier
            .background(Color.White)
            .statusBarsPadding()
            .padding(horizontal = 10.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        ArtWorkWall(modifier = Modifier
            .padding(bottom = 32.dp)
            .fillMaxWidth(),testList,count
        )
        ArtWorkDesc(
            modifier = Modifier.weight(1f)
                .padding(bottom = 32.dp)
                .fillMaxWidth(),testList,count
        )
        Row(modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth().align(Alignment.End)) {
            Button(onClick = { if (count>0)count-- }) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { if (count<testList.size-1)count++ }
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Composable
fun ArtWorkDesc(modifier: Modifier = Modifier, testList: List<Pair<String, Int>>, count: Int) {
    Column(modifier = modifier
        .padding(horizontal = 20.dp)
        .background(Color(0xFF754B9C))
        .padding(10.dp)) {
        Text(
            text = testList[count].first,
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Light
        )

        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 4.dp)
                .align(alignment = Alignment.Start)
                ,
            fontWeight = FontWeight.Bold,

        )
    }
}

@Composable
fun ArtWorkWall(modifier: Modifier = Modifier, testList: List<Pair<String, Int>>, count: Int) {
    Surface(
        modifier = modifier
            .size(300.dp, 500.dp)
            .background(Color.White)
            .padding(20.dp),
        shadowElevation = 20.dp

    ) {
        Image(painter = painterResource(id = testList[count].second), contentDescription = null
        ,modifier = Modifier.background(Color.White))
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ComposeLearnTheme {
        ArtSpaceScreen()
    }
}