package screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import appYellow
import data.ContentProvider
import data.Publication
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun BlogsScreen(uriHandler: UriHandler) {

    val publications = ContentProvider.providePublications()
    MaterialTheme {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(modifier = Modifier.padding(32.dp)) {
                Text(
                    "Publications",
                    style = TextStyle(appYellow, fontSize = 28.sp, fontWeight = FontWeight.Bold)
                )
            }

            Divider(
                color = appYellow,
                modifier = Modifier.padding(start = 32.dp, end = 32.dp, bottom = 32.dp)
            )

            Box(modifier = Modifier.padding(bottom = 100.dp).clipToBounds()) {
                LazyColumn {
                    items(publications.size) { index ->
                        PublicationTile(publications[index], uriHandler)
                        Divider()
                    }

                }
            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun PublicationTile(publication: Publication, uriHandler: UriHandler) {


    Column(modifier = Modifier.padding(16.dp)
        .clickable {
            uriHandler.openUri(publication.link)
        }) {
        Text(
            publication.title,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            publication.postedIn,
            fontSize = 12.sp
        )
        Text(
            publication.shortDescription,
            fontSize = 12.sp
        )

    }
}
