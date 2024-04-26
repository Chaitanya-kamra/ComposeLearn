package com.example.composelearn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelearn.data.Datasource
import com.example.composelearn.model.Topic
import com.example.composelearn.ui.theme.ComposeLearnTheme

@Composable
fun CoursesScreen(topicList: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Fixed(2),modifier) {
        items(topicList){
            CoursesCard(topic = it,
                modifier = modifier.padding(8.dp))
        }
    }
}

@Composable
fun CoursesCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
    ) {
        Row {
            Image(
                painter = painterResource(id = topic.image),
                contentDescription = stringResource(id = topic.name),
                modifier = Modifier
                    .size(68.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(text = stringResource(id = topic.name),
                    modifier = Modifier.padding(bottom = 8.dp, top = 16.dp),
                    style = MaterialTheme.typography.bodyMedium)
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = stringResource(id = topic.name),
                        modifier = Modifier,
                        contentScale = ContentScale.Crop,
                        colorFilter = ColorFilter.tint(Color.Black)
                    )
                    Text(text = topic.number.toString(),
                        modifier = Modifier.align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.labelMedium)
                }
            }

        }

    }
}

@Preview(showBackground = false)
@Composable
fun CoursesPreview() {
    ComposeLearnTheme {
        CoursesScreen(topicList = Datasource.topics)
    }
}