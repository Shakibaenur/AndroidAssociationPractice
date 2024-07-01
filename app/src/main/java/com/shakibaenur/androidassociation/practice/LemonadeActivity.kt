package com.shakibaenur.androidassociation.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shakibaenur.androidassociation.R
import com.shakibaenur.androidassociation.ui.theme.AndroidAssociationTheme
import java.text.NumberFormat

class LemonadeActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidAssociationTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(
                                    text = "Lemonade",
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            colors = TopAppBarDefaults.largeTopAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer
                            )
                        )
                    }
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        LemonApp()
                    }
                }

            }
        }
    }
}

@Composable
fun LemonApp() {
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }
    when (currentStep) {
        1 -> {
           LemonTextAndImage(
               textLabelId = R.string.lemon_select,
               drawableId = R.drawable.lemon_tree,
               contentDescriptionId = R.string.lemon_content_description,
               onImageClick = {
                   currentStep = 2
                   squeezeCount=(2..4).random()
               })
        }
        2->{
            LemonTextAndImage(
                textLabelId = R.string.lemon_squeeze,
                drawableId = R.drawable.lemon_squeeze,
                contentDescriptionId = R.string.lemon_content_description,
                onImageClick = {
                    squeezeCount--
                    if(squeezeCount==0){
                        currentStep=3
                    }
                })
        }
        3->{
            LemonTextAndImage(
                textLabelId = R.string.lemon_drink,
                drawableId = R.drawable.lemon_drink,
                contentDescriptionId = R.string.lemonade_content_description,
                onImageClick = {
                    currentStep=4
                })
        }
        4->{
            LemonTextAndImage(
                textLabelId = R.string.lemon_empty_glass,
                drawableId = R.drawable.lemon_restart,
                contentDescriptionId = R.string.empty_glass_content_description,
                onImageClick = {
                    currentStep=1
                })
        }

    }
}

@Composable
fun LemonTextAndImage(
    textLabelId: Int, drawableId: Int, contentDescriptionId: Int,
    onImageClick: () -> Unit, modifier: Modifier = Modifier
) {

    Box(modifier = Modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Image(painter= painterResource(id = drawableId),
                    contentDescription= stringResource(contentDescriptionId),
                    modifier= Modifier
                        .width(160.dp)
                        .height(84.dp)
                        .padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(text= stringResource(id = textLabelId),
                style=MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    AndroidAssociationTheme {
        //DiceRoller(modifier=Modifier.fillMaxSize().wrapContentSize(Alignment.Center))
    }
}