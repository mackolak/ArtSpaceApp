package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainLayout()
                }
            }
        }
    }
}

@Composable
fun MainLayout(modifier: Modifier = Modifier) {
    var artNumber by remember { mutableIntStateOf(0) }

    val artList = ArtList.getArtList()

    val onPreviousClick: () -> Unit = {
        if (artNumber == 0)  {
            artNumber = artList.size - 1
        } else {
            artNumber--
        }
    }

    val onNextClick: () -> Unit = {
        if (artNumber == artList.size - 1)  {
            artNumber = 0
        } else {
            artNumber++
        }
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        DisplayArt(artId = artList[artNumber].artId)
        ArtTextDetails(
            artTitleId = artList[artNumber].artTitleId,
            artAuthorAndYear = artList[artNumber].artAuthorAndYear,
        )
        ArtChangeButtons(
            onPreviousClick = onPreviousClick,
            onNextClick = onNextClick,
        )
    }
}

@Composable
fun ArtChangeButtons(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row {
        Button(
            onClick = onPreviousClick,
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.Black
            ),
            border = BorderStroke(1.dp,Color.Black),
            modifier = Modifier
                .padding(end = 4.dp)
                .width(120.dp)
        ) {
            Text(text = "Previous")
        }
        Button(
            onClick = onNextClick,
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.Black
            ),
            border = BorderStroke(1.dp,Color.Black),
            modifier = Modifier
                .padding(start = 4.dp)
                .width(120.dp)
        ) {
            Text(
                text = "Next"
            )
        }
    }
}

@Composable
fun DisplayArt(@DrawableRes artId: Int, modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .border(BorderStroke(50.dp, Color.White) )
    ) {
        Image(
            painter = painterResource(artId),
            contentDescription = null,
            modifier = Modifier
                .size(620.dp)
                .padding(16.dp)
        )
    }

}

@Composable
fun ArtTextDetails(
    @StringRes artTitleId: Int,
    @StringRes artAuthorAndYear: Int,
    modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = artTitleId),
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        modifier = Modifier.padding(bottom = 8.dp)
    )
    Text(
        text = stringResource(id = artAuthorAndYear),
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        MainLayout()
    }
}
