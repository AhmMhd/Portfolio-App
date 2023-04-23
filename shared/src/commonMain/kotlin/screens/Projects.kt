package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import appYellow
import data.ContentProvider
import data.Project
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ProjectsScreen(uriHandler: UriHandler) {

    val projects = ContentProvider.provideListOfProjects()
    MaterialTheme {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(modifier = Modifier.padding(32.dp)) {
                Text(
                    "My Contribution",
                    style = TextStyle(appYellow, fontSize = 28.sp, fontWeight = FontWeight.Bold)
                )
            }

            Divider(
                color = appYellow,
                modifier = Modifier.padding(start = 32.dp, end = 32.dp, bottom = 32.dp)
            )

            Box(modifier = Modifier.padding(bottom = 100.dp).clipToBounds()) {
                LazyColumn {
                    items(projects.size) { index ->
                        ProjectTile(projects[index], urlHandler = uriHandler)
                        Divider(color = Color.LightGray)
                    }

                }
            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ProjectTile(project: Project, urlHandler: UriHandler) {
    Row(
        Modifier.fillMaxSize().padding(12.dp)
            .clickable {
                urlHandler.openUri(project.appURL)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.width(52.dp).height(52.dp)
                .background(Color.White, RoundedCornerShape(12.dp)).clip(RoundedCornerShape(12.dp))
        ) {
            Image(
                painter = painterResource(project.assetName),
                contentDescription = "",
                modifier = Modifier.width(52.dp).height(52.dp),
                contentScale = ContentScale.Crop
            )

        }

        Column(modifier = Modifier.padding(start = 12.dp)) {
            Text(
                project.name,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                project.category,
                fontSize = 12.sp
            )
            Text(
                project.downloads,
                fontSize = 12.sp
            )
            Text(
                project.description,
                fontSize = 12.sp
            )
        }


    }
}