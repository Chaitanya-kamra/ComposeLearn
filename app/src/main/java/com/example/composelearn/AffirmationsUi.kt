package com.example.composelearn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelearn.data.Datasource
import com.example.composelearn.model.Affirmation
import com.example.composelearn.ui.theme.ComposeLearnTheme

@Composable
fun AffirmationsUi(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn(modifier) {
        items(affirmationList){
            AffirmationCard(affirmation = it,
                modifier = modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp))
        }
    }
}

@Composable
fun AffirmationCard(affirmation: Affirmation,modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
    ) {
        Column {
            Image(
                painter = painterResource(id = affirmation.imageResourceId),
                contentDescription = stringResource(id = affirmation.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = stringResource(id = affirmation.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall)
        }

    }
}

@Preview(showBackground = false)
@Composable
fun AffirmationPreview() {
    ComposeLearnTheme {
        AffirmationsUi(affirmationList = Datasource.loadAffirmations())
    }
}