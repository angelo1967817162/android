import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.CoursUiState
import com.example.myapplication.mooveScreen
import com.example.myapplication.ui.CoursViewModel
import com.example.myapplication.ui.Datasource


//@Composable
//fun mooveApp(){
//    PageAccueil(
//        modifier = Modifier
//            .fillMaxSize()
//            .wrapContentSize(Alignment.Center)
//    )
//}
@Composable
fun mooveApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = mooveScreen.Start.name,
        modifier = Modifier
    ) {
        composable(route = mooveScreen.Start.name) {
            PageAccueil(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                navController = navController
            )
        }
        composable(route = mooveScreen.Login.name) {
            FormulaireLogin(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                navController = navController
            )
        }
        composable(route = mooveScreen.AfficherCours.name) {
            ListeCours(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
//pokeViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
                navController = navController
            )
        }
//            ListePokemon(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .wrapContentSize(Alignment.Center),
////pokeViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
//                navController = navController
//            )
//        }
        }
    }
    //@Composable
//fun PageAccueil(modifier: Modifier=Modifier){
//    Text("hello")
//    Button(onClick={}){
//        Text("Consulter les cours")
//    }
//}
//@Composable
//fun PageAccueil(
//    modifier: Modifier=Modifier,
//    coursViewModel: CoursViewModel= viewModel()
//){
//    val coursUiState by coursViewModel.uiState.collectAsState()
//    Text(coursUiState.nom)
////    Button(onClick={}){
////        Text("Consulter les cours")
////    }
//}}
//
//
//
//@Composable
//fun PageAccueil(modifier: Modifier=Modifier,
//                navController: NavHostController= rememberNavController()
//){
//    Button(onClick = {
//        navController.navigate(mooveScreen.Login.name){
//            popUpTo(mooveScreen.Start.name) { inclusive = false }
//        }


//@Composable
//fun ListePokemon(
//    modifier: Modifier = Modifier,
//    pokeViewModel: PokeViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
//    navController: NavHostController = rememberNavController()
//){
//    val listePokemon by pokeViewModel.pokeUi.collectAsState(initial = emptyList())
//    Column(
//        modifier = modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ){
//        Text(text = "Liste des Pokémon", modifier = Modifier.align(Alignment.CenterHorizontally))
//        LazyColumn {
//            items(listePokemon) { pokemon ->
//                Text(text = pokemon.name)
//            }
//        }





//@Composable
//fun ListeCours(
//    modifier: Modifier,
//    navController1: List<CoursUiState>,
//    navController: NavHostController
//) {
//    ListeCours(
//        modifier = Modifier
//            .fillMaxSize()
//            .wrapContentSize(Alignment.Center),
//        Datasource.retourneListeCours(),
//        navController=navController
//    )
//val listeCours = Datasource.retourneListeCours()
//    LazyColumn(modifier = modifier.fillMaxSize()) {
//        items(listeCours) { cours ->
//            Text(text = cours.nom)
//        }
//    }
//}
@Composable
fun ListeCours(
    modifier: Modifier = Modifier,
    coursViewModel: CoursViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavHostController = rememberNavController()
){
    val listePokemon by coursViewModel.coursUi.collectAsState()
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Liste des cours", modifier = Modifier.align(Alignment.CenterHorizontally))
        LazyColumn {
            items(listeCours) { cours ->
                Text(text = " ${cours.username}")
            }
        }
    }
}


@Composable
    fun PageAccueil(
        modifier: Modifier = Modifier,
        navController: NavHostController = rememberNavController()
    ) {

//        val coursViewModel: CoursViewModel = viewModel()
//        val coursUiState by coursViewModel.uiState.collectAsState()

        Button(onClick = {
            navController.navigate(mooveScreen.Login.name) {

                popUpTo(mooveScreen.Start.name) { inclusive = false }
            }
        }) {
            Text("Naviguer vers Login")
        }
    }



@Composable
        fun FormulaireLogin(modifier: Modifier = Modifier,
                            navController: NavHostController = rememberNavController()) {
            var login by remember { mutableStateOf("") }
            val backgroundColor = if (login.length >= 10) {
                Color.Red
            } else {
                Color.White
            }
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                TextField(
                    label = {Text("Entrez votre login")},
                    value = login,
                    onValueChange = {login = it},
                    colors = TextFieldDefaults.colors(focusedContainerColor = backgroundColor),
                )
            }
        }





