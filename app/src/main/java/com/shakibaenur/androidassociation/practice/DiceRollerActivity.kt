package com.shakibaenur.androidassociation.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shakibaenur.androidassociation.R
import com.shakibaenur.androidassociation.ui.theme.AndroidAssociationTheme
import java.text.NumberFormat

class DiceRollerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidAssociationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceRoller(modifier=Modifier.fillMaxSize().wrapContentSize(Alignment.Center))
                }
            }
        }
    }
}

@Composable
fun DiceRoller(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    var imageResource = when (result) {
        1 -> R.drawable.diice_1
        2 -> R.drawable.diice_2
        3 -> R.drawable.diice_3
        4 -> R.drawable.diice_4
        5 -> R.drawable.diice_5
        else -> {
            R.drawable.diice_6
        }
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = imageResource), contentDescription = null,
            modifier = Modifier.size(128.dp)
        )
        Button(onClick = { result = (1..6).random() }) {
            Text(stringResource(id = R.string.roll))
        }

    }
}


@Preview(showBackground = true)
@Composable
fun DiceRollerzPreview() {
    AndroidAssociationTheme {
        DiceRoller(modifier=Modifier.fillMaxSize().wrapContentSize(Alignment.Center))
    }
}