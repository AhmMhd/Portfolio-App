import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.ContentProvider
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import screens.BlogsScreen
import screens.ProfileScreen
import screens.ProjectsScreen
import screens.WorkExperienceScreen

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {

    val uriHandler = LocalUriHandler.current
    var state = mutableStateOf<BottomNavigationBarState>(BottomNavigationBarState.Home)

    MaterialTheme(colors = if (isSystemInDarkTheme()) DarkThemeColors else LightThemeColors) {

        Scaffold(
            bottomBar = {
                Box(modifier = Modifier.padding(6.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .background(
                                color = MaterialTheme.colors.background,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .padding(6.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.background(appYellow, CircleShape)
                                .padding(horizontal = 12.dp, vertical = 6.dp).clickable {
                                    state.value = BottomNavigationBarState.Home
                                }
                        ) {
                            AnimatedVisibility(state.value == BottomNavigationBarState.Home) {
                                Text(
                                    "Profile", style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        color = appBlack
                                    ),
                                    fontSize = 20.sp
                                )
                            }

                            Image(
                                painter = painterResource("ic_profile.png"),
                                contentDescription = "",
                                modifier = Modifier.width(42.dp).height(42.dp).padding(6.dp),
                                contentScale = ContentScale.Crop,
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.background(appYellow, CircleShape)
                                .padding(horizontal = 12.dp, vertical = 6.dp).clickable {
                                    state.value = BottomNavigationBarState.Projects
                                }
                        ) {
                            AnimatedVisibility(state.value == BottomNavigationBarState.Projects)
                            {
                                Text(
                                    "Projects", style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        color = appBlack
                                    ),
                                    fontSize = 20.sp
                                )
                            }
                            Image(
                                painter = painterResource("ic_projects.png"),
                                contentDescription = "",
                                modifier = Modifier.width(42.dp).height(42.dp).padding(6.dp),
                                contentScale = ContentScale.Crop,
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.background(appYellow, CircleShape)
                                .padding(horizontal = 12.dp, vertical = 6.dp).clickable {
                                    state.value = BottomNavigationBarState.Experience
                                }
                        ) {
                            AnimatedVisibility(state.value == BottomNavigationBarState.Experience)
                            {
                                Text(
                                    "Experience", style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        color = appBlack
                                    ),
                                    fontSize = 20.sp
                                )
                            }
                            Image(
                                painter = painterResource("ic_experience.png"),
                                contentDescription = "",
                                modifier = Modifier.width(42.dp).height(42.dp).padding(6.dp),
                                contentScale = ContentScale.Crop,
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.background(appYellow, CircleShape)
                                .padding(horizontal = 12.dp, vertical = 6.dp).clickable {
                                    state.value = BottomNavigationBarState.Blogs
                                }
                        ) {
                            AnimatedVisibility(state.value == BottomNavigationBarState.Blogs)
                            {
                                Text(
                                    "Blogs", style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        color = appBlack
                                    ),
                                    fontSize = 20.sp
                                )
                            }
                            Image(
                                painter = painterResource("ic_blogs.png"),
                                contentDescription = "",
                                modifier = Modifier.width(42.dp).height(42.dp).padding(6.dp),
                                contentScale = ContentScale.Crop,
                            )
                        }

                    }
                }
            },

            content = {
                when (state.value) {
                    BottomNavigationBarState.Home -> ProfileScreen(uriHandler)
                    BottomNavigationBarState.Projects -> ProjectsScreen(uriHandler)
                    BottomNavigationBarState.Experience -> WorkExperienceScreen()
                    BottomNavigationBarState.Blogs -> BlogsScreen(uriHandler)
                    else -> ProfileScreen(uriHandler)
                }
            },

            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        uriHandler.openUri(ContentProvider.linkedInURL)
                    },
                    content = {
                        Box(modifier = Modifier.padding(12.dp)) {
                            Image(
                                painter = painterResource("ic_hireme.png"),
                                contentDescription = "",
                                modifier = Modifier.width(91.dp).height(42.dp).padding(6.dp),
                                contentScale = ContentScale.Crop,
                            )
                        }
                    },
                    backgroundColor = appYellow
                )
            }
        )
    }
}
