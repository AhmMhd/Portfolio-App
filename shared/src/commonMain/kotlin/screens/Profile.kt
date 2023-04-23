package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import appBlack
import appYellow
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ProfileScreen() {

    val introductionText = buildAnnotatedString {
        withStyle(style = SpanStyle(appBlack, fontSize = 20.sp, fontWeight = FontWeight.Bold)) {
            append("Hi, I am ")
        }
        withStyle(style = SpanStyle(appYellow, fontSize = 28.sp, fontWeight = FontWeight.Bold)) {
            append("Abdul Hakeem")
        }
    }

    val aboutSectionText = buildAnnotatedString {
        withStyle(style = SpanStyle(appBlack, fontSize = 14.sp, fontWeight = FontWeight.Bold)) {
            append("I am a forward-thinking developer with ")
        }

        withStyle(style = SpanStyle(appYellow, fontSize = 16.sp, fontWeight = FontWeight.Bold)) {
            append("6 Years ")
        }
        withStyle(style = SpanStyle(appBlack, fontSize = 14.sp, fontWeight = FontWeight.Bold)) {
            append("of experience building, integrating and supporting ")
        }

        withStyle(style = SpanStyle(appYellow, fontSize = 16.sp, fontWeight = FontWeight.Bold)) {
            append("Android Applications ")
        }
        withStyle(style = SpanStyle(appBlack, fontSize = 14.sp, fontWeight = FontWeight.Bold)) {
            append("for mobile devices.\n\nCurrently living in ")
        }

        withStyle(style = SpanStyle(appYellow, fontSize = 16.sp, fontWeight = FontWeight.Bold)) {
            append("Abu Dhabi (UAE)")
        }
        withStyle(style = SpanStyle(appBlack, fontSize = 14.sp, fontWeight = FontWeight.Bold)) {
            append(", open to new roles for Sr. Software Engineer (Android).")
        }
    }

    MaterialTheme {
        Box {
            Column(
                Modifier.fillMaxSize().padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Box(
                    modifier = Modifier.background(shape = CircleShape, color = appYellow)
                        .clip(CircleShape)
                ) {
                    Image(
                        painter = painterResource("avatar.png"),
                        contentDescription = "",
                        modifier = Modifier.width(152.dp).height(152.dp),
                        contentScale = ContentScale.Crop
                    )
                }
                Box(Modifier.height(18.dp))

                Text(
                    introductionText
                )

                Text(
                    "Sr. Software Engineer (Android)",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = appBlack,
                    ),
                )

                Box(Modifier.height(18.dp))

                Text(
                    aboutSectionText,
                    textAlign = TextAlign.Center
                )

                Box(Modifier.height(18.dp))

                Row {
                    Image(
                        painter = painterResource("ic_medium.png"),
                        contentDescription = "",
                        modifier = Modifier.width(52.dp).height(52.dp).padding(6.dp),
                        contentScale = ContentScale.Crop,
                    )

                    Image(
                        painter = painterResource("ic_linkedin.png"),
                        contentDescription = "",
                        modifier = Modifier.width(52.dp).height(52.dp).padding(6.dp),
                        contentScale = ContentScale.Crop
                    )

                    Image(
                        painter = painterResource("ic_github.png"),
                        contentDescription = "",
                        modifier = Modifier.width(52.dp).height(52.dp).padding(6.dp),
                        contentScale = ContentScale.Crop
                    )

                    Image(
                        painter = painterResource("ic_stakeoverflow.png"),
                        contentDescription = "",
                        modifier = Modifier.width(52.dp).height(52.dp).padding(6.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }


        }
    }
}