package com.malaika18khan.visithyderabad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.malaika18khan.visithyderabad.data.Place
import com.malaika18khan.visithyderabad.data.places
import com.malaika18khan.visithyderabad.ui.theme.VisitHyderabadTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VisitHyderabadTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    VisitHyderabadApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisitHyderabadApp() {
    Scaffold(
        topBar = {
            VisitHyderabadTopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(places) {
                PlaceItem(
                    place = it,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
                )
            }

    }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisitHyderabadTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        },
        modifier = modifier
    )

}


@Composable
fun PlaceItem(
    place: Place,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.primaryContainer,
    )

    Card(modifier = modifier) {
        Column(
            modifier = Modifier
                .background(color = color)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                PlaceIcon(placeIcon = place.imageResourceId)
            }
            Row(modifier= Modifier) {
                PlaceName(placeName = place.name,  modifier = Modifier.wrapContentWidth())
                Spacer(modifier = Modifier.weight(0.5f))

                PlaceItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded }
                )
            }
            if (expanded){
               Column(modifier = Modifier.padding(10.dp)) {
                   PlaceDescription(
                       placeDescription = place.description
                    )
                }
            }
        }
    }
}

@Composable
fun PlaceIcon(
    @DrawableRes placeIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.FillBounds,
        painter = painterResource(placeIcon),

        // Content Description is not needed here - image is decorative, and setting a null content
        // description allows accessibility services to skip this element during navigation.

        contentDescription = null
    )
}

@Composable
fun PlaceName(
    @StringRes placeName: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(10.dp)) {
        Text(
            text = stringResource(placeName),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier
                .padding(top = dimensionResource(R.dimen.padding_small))
                .widthIn(0.dp, 250.dp),
        )
    }
}

@Composable
fun PlaceItemButton(
    expanded: Boolean,
    onClick : () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(id = R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun PlaceDescription(
    @StringRes placeDescription: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(
            text = stringResource(id = R.string.description),
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = stringResource(id = placeDescription),
            style = MaterialTheme.typography.bodyLarge
        )
    }

}


@Preview(showBackground = true)
@Composable
fun VisitHyderabadItem() {
    val place = Place(
        R.drawable.sindh_museum,
        R.string.p1_name,
        R.string.p1_description

    )
    VisitHyderabadTheme() {
    PlaceItem(place = place)
}
}

@Preview(showBackground = true)
@Composable
fun VisitHyderabad() {
    VisitHyderabadTheme {
        VisitHyderabadApp()
    }
}