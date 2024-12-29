package com.sandeep.listitemmaterial3compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.sandeep.listitemmaterial3compose.ui.theme.ListItemMaterial3ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListItemMaterial3ComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var fruits by remember {
                        mutableStateOf(SAMPLE_FRUIT)
                    }
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentPadding = innerPadding
                    ) {
                        items(items = fruits, key = { it.name }) { fruit ->
                            ListItem(
                                headlineContent = {
                                    Text(fruit.name)
                                },
                                supportingContent = {
                                    Text(fruit.description)
                                },
                                leadingContent = {
                                    Icon(
                                        imageVector = Icons.Default.ShoppingCart,
                                        contentDescription = null,
                                        tint = fruit.color
                                    )
                                },
                                trailingContent = {
                                    Checkbox(
                                        checked = fruit.isSelected,
                                        onCheckedChange = {
                                            fruits = fruits.map { currentFruit ->
                                                if (currentFruit == fruit) {
                                                    currentFruit.copy(
                                                        isSelected = !currentFruit.isSelected
                                                    )
                                                } else currentFruit
                                            }
                                        }
                                    )
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        fruits = fruits.map { currentFruit ->
                                            if (currentFruit == fruit) {
                                                currentFruit.copy(
                                                    isSelected = !currentFruit.isSelected
                                                )
                                            } else currentFruit
                                        }
                                    }
                            )
                            HorizontalDivider()
                        }
                    }
                }
            }
        }
    }
}