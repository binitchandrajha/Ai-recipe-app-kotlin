package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.SoupKitchen
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor
import com.example.ai_recipe_app_kotlin.ui.theme.LightPrimaryBackground
import com.example.ai_recipe_app_kotlin.ui.theme.LightPrimaryColor

@Composable
fun SavedRecipeCard(){
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Saved Recipes",
            fontWeight = FontWeight.Bold,
            )
        Spacer(modifier = Modifier.size(10.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
            ){
                Box(
                    modifier = Modifier.background(LightPrimaryColor, shape = RoundedCornerShape(22.dp)).padding(5.dp)
                ) {

                    AsyncImage(
                        model = "https://png.pngtree.com/png-clipart/20230129/original/pngtree-red-fresh-tomato-with-green-leaf-png-image_8933861.png",
                        contentDescription = "Spaghetti Bolognese",
                        modifier = Modifier.size(50.dp)
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth().weight(1f).padding(start = 16.dp)
                ){
                    Text(text = "Tomato Bail Pista")
                    Spacer(modifier = Modifier.size(6.dp))
                    Row(
                      modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                      Row(
                          verticalAlignment = Alignment.CenterVertically
                      ) {
                          Icon(
                              imageVector = Icons.Default.AccessTime,
                              contentDescription = "AcesTimer",
                              modifier = Modifier.size(12.dp),
                              tint = DarkPrimaryColor
                          )
                          Spacer(modifier = Modifier.size(4.dp))
                          Text(text = "30 mins")
                      }
                      Row(
                          verticalAlignment = Alignment.CenterVertically
                      ) {
                          Icon(
                              imageVector = Icons.Outlined.Restaurant,
                              contentDescription = "AcesTimer",
                              modifier = Modifier.size(12.dp),
                              tint = DarkPrimaryColor
                          )
                          Spacer(modifier = Modifier.size(4.dp))
                          Text(text = "30 mins")
                      }

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.SoupKitchen,
                                contentDescription = "AcesTimer",
                                modifier = Modifier.size(12.dp),
                                tint = DarkPrimaryColor
                            )
                            Spacer(modifier = Modifier.size(4.dp))
                            Text(text = "30 mins")
                        }
                    }
                }
                
                IconButton(
                    onClick = {},
                    modifier = Modifier.align(Alignment.Top).size(22.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Bookmark,
                        contentDescription = "Bookmark",
                        modifier = Modifier.size(22.dp),
                        tint = DarkPrimaryColor
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SavedRecipeCardPreview(){
    SavedRecipeCard()
}