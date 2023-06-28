package com.example.creatingimagecardcomposableandroidjetpackcomposephilipplackner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.shivbhagwan) // this will fetch the photo from the drawable folder using painterResource class.
            val description = "Lord SHiva, also knows as the Mahakal, of this universe, destroyes the world on his own will"
            val title = "Shiv Bhagwan, the Destroyer of the World."
            Box(modifier = Modifier
                .fillMaxWidth(0.5f) // from stopping using the full max width..
                .padding(16.dp)){// this box is necessary for the fulfilment of the desired elevation and proper functioning of the elevation property
                ImageCard(painter = painter, contentDescriptor = description, title = title) // this is a user made function for calling image.
            }
        }
    }
}

@Composable // this annotation is necessary as it invokes a composable class called, "Card"
fun ImageCard(
    painter : Painter, // for photo reference.
    contentDescriptor: String, // for description of the photo
    title: String, // for the title.
    modifier:Modifier = Modifier // for any type of modification.
){
    Card( // this is used, as it has elevation property by showing shadow effects.
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp), // this line is different in philipp Lackner video, used for giving elevation effect.
    ){
        Box(modifier = Modifier.height(200.dp)){ // see notes section (down below), why Box is used.
            Image(painter = painter, contentDescription = contentDescriptor, contentScale = ContentScale.Crop)
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(colors = listOf(Color.Transparent,Color.Black), startY = 250f) // Brush class is used to give gradient
                )) // this box is used for applying the black gradient
            Box(modifier = Modifier
                .fillMaxSize() // fill the max size of parent container.
                .padding(12.dp),
                contentAlignment = Alignment.BottomStart // make the text at the bottom, as only text is inside this box.
            ){
                Text(text = title, style = TextStyle(color= Color.White, fontSize = 16.sp))
            }
        }
    }
}

/*
NOTES:
-> Composable can be applied to a function or lambda to indicate that the function/lambda can be used as part of a composition to describe a transformation
from application data into a tree or hierarchy.
-> Card is a container, we can place single composable in card. It has elevation property, we can display shadow effect using the card. We can add the
border with a rounded corner radius.

-> Why Box is used?
SOl: Since, here we want to stack the component into each other, for example, text stacked on the image, along with the gradient and can also align the item.
Since first written are on bottom of the stack, we need image at behind all, thus, image is written first.
and as Rows, Column Card attributes, place the attributes on the side or on the top of each other, it will not be used,

YT Link: https://www.youtube.com/watch?v=KPVoQjwmWX4&list=PLQkwcJG4YTCSpJ2NLhDTHhi6XBNfk9WiC&index=4&pp=iAQB
 */