package com.niko.kmm.newsappdemocomposemultiplatform.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seiko.imageloader.rememberImagePainter

@Composable
fun NewsHeadLineItem(newsHeadLine: NewsHeadlineUI) {

    Column(modifier = Modifier.fillMaxWidth().padding(20.dp)) {
        val painter =
            rememberImagePainter(newsHeadLine.urlToImage)
        Image(
            painter, null,
            modifier = Modifier.fillMaxSize().padding(4.dp),
        )


        Text(
            text = newsHeadLine.title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
        )

        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = newsHeadLine.description,
            fontSize = 16.sp,
        )
    }

//    Row(
//        modifier = Modifier.fillMaxWidth().padding(16.dp)
//    ) {
//        Column(modifier = Modifier) {
//            val painter =
//                rememberImagePainter(newsHeadLine.urlToImage)
//            Image(
//                painter, null,
//                modifier = Modifier.weight(0.5f),
//            )
//
//
//            Text(
//                text = newsHeadLine.title,
//                fontSize = 18.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.Black,
//            )
//
//            Text(
//                modifier = Modifier.padding(top = 4.dp),
//                text = newsHeadLine.description,
//                fontSize = 16.sp,
//            )
//        }
//
////        Spacer(modifier = Modifier.fillMaxWidth().weight(1f))
//
//    }
}


//@Preview
//@Composable
//fun preview() {
//    //NewsHeadLineItem(state.newsHeadlinesUi.get(it))
//}