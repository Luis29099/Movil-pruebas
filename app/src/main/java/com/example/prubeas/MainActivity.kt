/*package com.example.prubeas



import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.prubeas.ui.theme.PrubeasTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items


 */

/*class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrubeasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Meghan",
                        modifier = Modifier.padding(innerPadding)

                    )
                    ArtistCard(modifier = Modifier.padding(

                    ))
                }
            }
        }
    }
}*/

/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = Color.Red, modifier = modifier.fillMaxSize()) {
        // Column para apilar elementos verticalmente
        Column(modifier = Modifier.padding(24.dp)) {

            // Texto
            Text(text = "Hi, my name is $name!")

            // Botón debajo del texto
            Button(
                onClick = { println("¡Botón presionado!") }, // acción al hacer clic
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Haz clic aquí")
            }
        }

    }

}

@Composable
fun ArtistCard(modifier:Modifier= Modifier){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ){
        Image(painter = painterResource(id = R.drawable.artist),
        contentDescription="Artist Image")
        Column {
            Text(text = "Alfred Sisley")
            Text(text="3 minutes ago")
        }

    }
}

 */
/*@Preview(showBackground = true)
@Composable
fun ArtistCardPreview() {
    PrubeasTheme {

    }
}
*/
package com.example.prubeas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prubeas.ui.theme.PrubeasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrubeasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = { BottomNavBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(
                text = "Good morning, Luis 👋",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar()
            Spacer(modifier = Modifier.height(24.dp))
            BodyRow() // 👈 Aquí van los círculos
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text="Favoritos",
                style=MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
            FavoriteCollectionsGrid()
        }
    }
}

@Composable
fun SearchBar() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        placeholder = { Text("Search") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search icon"
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    )
}

@Composable
fun BodyRow() {
    val items = listOf(
        Pair(R.drawable.inversion, "Inversions"),
        Pair(R.drawable.yoga, "Quick yoga"),
        Pair(R.drawable.stretching, "Stretching"),
        Pair(R.drawable.tabata, "Tabata")
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(items.size) { index ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = items[index].first),
                    contentDescription = items[index].second,
                    modifier = Modifier
                        .size(90.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = items[index].second,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun FavoriteCollectionsGrid(modifier: Modifier = Modifier) {
    val favoriteData = listOf(
        Pair(R.drawable.inversion, "Short mantras"),
        Pair(R.drawable.stretching, "Nature meditations"),
        Pair(R.drawable.yoga, "Stress relief"),
        Pair(R.drawable.tabata, "Mind focus")
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(140.dp)
    ) {
        items(favoriteData.size) { index ->
            FavoriteCollectionCard(
                drawable = favoriteData[index].first,
                text = favoriteData[index].second,
                modifier = Modifier
                    .width(160.dp)
                    .height(120.dp)
            )
        }
    }
}

@Composable
fun FavoriteCollectionCard(drawable: Int, text: String, modifier: Modifier = Modifier) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = Color(0xFFDADADA),
        modifier = modifier


    )
    {
        Row(verticalAlignment = Alignment.CenterVertically) {

            Image(
                painter = painterResource(id = drawable),
                contentDescription = text,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun BottomNavBar() {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search") },
            label = { Text("Search") },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Profile") },
            label = { Text("Profile") },
            selected = false,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    PrubeasTheme {
        HomeScreen()
    }
}
