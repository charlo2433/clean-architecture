package com.zazu.mvvmjetflow

import android.os.Bundle
import android.text.Layout.Alignment
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.zazu.mvvmjetflow.ui.theme.MvvmJetFlowTheme
import com.zazu.mvvmjetflow.presentation.todo_list.TodoScreen
import com.zazu.mvvmjetflow.presentation.view_model.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MvvmJetFlowTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var password by remember {
                        mutableStateOf("")
                    }
                    Greeting(password, onchangePassword = {password = it})
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(password: String, modifier: Modifier = Modifier, onchangePassword: (String)-> Unit, imeAction: ImeAction = ImeAction.Next,  todoViewModel: TodoViewModel = hiltViewModel()) {
    val state = todoViewModel.state.value
    LazyColumn(content = {
        Log.e("user","start")
       items(state.todoList){item->
           Log.e("user","starteds")
           Text(text = item.title, color = Color.Red )
       }
    })
    if(state.isLoading){
        CircularProgressIndicator()
    }
//    var passwordV by remember {
//        mutableStateOf(false)
//    }
//    val icon = if(passwordV) painterResource(id = R.drawable.baseline_visibility_24) else painterResource(
//        id = R.drawable.baseline_visibility_off_24)
////    Text(
////        text = "Hello $name!",
////        modifier = modifier
////    )
//    OutlinedTextField(value =password , onValueChange = onchangePassword, placeholder ={ Text(text = "password")},
//        trailingIcon = {
//                       IconButton(onClick = { passwordV = !passwordV }) {
//                           Icon(painter = icon, contentDescription ="see" )
//                       }
//        },
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = imeAction),
//        visualTransformation =
//        if (passwordV) VisualTransformation.None else PasswordVisualTransformation()
//     )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MvvmJetFlowTheme {
        var password by remember {
            mutableStateOf("")
        }
        Greeting(password, onchangePassword = {password = it})
    }
}