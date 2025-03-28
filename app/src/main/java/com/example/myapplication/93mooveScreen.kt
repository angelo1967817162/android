import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import androidx.compose.ui.unit.dp
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

            val coursViewModel:CoursViewModel= viewModel()
            ListeCours(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
               // Datasource.retourneListeCours(),
                coursViewModel,
                navController = navController
            )
        }

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

@Composable
fun ListeCours(
    modifier: Modifier = Modifier,
    //listeCours: List<CoursUiState>,
    coursViewModel: CoursViewModel,
    navController: NavHostController = rememberNavController(),
){
    val listeCours by coursViewModel.coursUi.collectAsState()
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Liste des Cours")
        LazyColumn {
            items(listeCours.size) { index ->
                val cours = listeCours[index]
                Text(text = " ${cours.nom}")
                Text(text = " ${cours.description}")
//               Text(text = cours.email)
//              Text(text = cours.password)
//               Text(text = cours.salaire.toString())
            }
        }
    }



//    LazyColumn(modifier = modifier.fillMaxSize()) {
//        items(listeCours.size) { index ->
//            val cours = listeCours[index]
//            Card(modifier = Modifier.padding(8.dp)) {
//                Column(modifier = Modifier.padding(8.dp)) {
//
//                    Text(text = cours.username)
//                    Text(text = cours.email)
//                    Text(text = cours.password)
//                    Text(text = cours.salaire.toString())
//
//                }
//            }
//        }
//    }
}

@Composable
    fun PageAccueil(
        modifier: Modifier = Modifier,
        navController: NavHostController = rememberNavController()
    ) {

//        val coursViewModel: CoursViewModel = viewModel()
//        val coursUiState by coursViewModel.uiState.collectAsState()
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = { navController.navigate(mooveScreen.AfficherCours.name) {

            popUpTo(mooveScreen.Start.name) { inclusive = false }
        } }) {
            Text("Consulter les cours")
        }

        Button(onClick = {
            navController.navigate(mooveScreen.Login.name) {

                popUpTo(mooveScreen.Start.name) { inclusive = false }
            }
        }) {
            Text("Naviguer vers Login")
        }
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





