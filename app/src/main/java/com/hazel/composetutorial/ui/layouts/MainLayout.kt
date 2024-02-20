package com.hazel.composetutorial.ui.layouts

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hazel.composetutorial.R
import com.hazel.composetutorial.dto.Message
import com.hazel.composetutorial.ui.theme.ComposeTutorialTheme
import com.hazel.composetutorial.utils.getDummyMessage

@Composable
fun Conversation(messages: ArrayList<Message>) {
    LazyColumn {
        items(messages.size) { index ->
            MessageCard(messages[index])
        }
    }
}

@Composable
fun MessageCard(message: Message) {
    if (message.name == "Hazel") {
        RightMessageCard(message = message)
    } else {
        LeftMessageCard(message = message)
    }
}

@Composable
fun LeftMessageCard(message: Message) {
    var isExpanded by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth(), horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Android Logo",
            colorFilter = ColorFilter.tint(color = Color.Red),
            modifier = Modifier
                .size(size = 48.dp)
                .clip(shape = CircleShape)
                .border(width = 1.dp, color = Color.Red, shape = CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier.clickable(onClick = { isExpanded = !isExpanded }),
            horizontalAlignment = androidx.compose.ui.Alignment.Start
        ) {
            Text(text = message.name, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(2.dp))
            Surface(shape = MaterialTheme.shapes.small, shadowElevation = 2.dp,
                modifier = Modifier.animateContentSize().padding(all = 1.dp)) {
                Text(
                    text = message.message, style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    modifier = Modifier.padding(all = 4.dp)
                )
            }
        }
    }
}

@Composable
fun RightMessageCard(message: Message) {
    var isExpanded by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth(), horizontalArrangement = Arrangement.End
    ) {
        Column(
            modifier = Modifier.clickable(onClick = { isExpanded = !isExpanded })
                .weight(fill = false, weight = 1f),
            horizontalAlignment = androidx.compose.ui.Alignment.End
        ) {
            Text(text = message.name, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(2.dp))
            Surface(shape = MaterialTheme.shapes.small, shadowElevation = 2.dp,
                modifier = Modifier.animateContentSize().padding(all = 1.dp)) {
                Text(
                    text = message.message, style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    modifier = Modifier.padding(all = 4.dp)
                )
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Android Logo",
            colorFilter = ColorFilter.tint(color = Color.Red),
            modifier = Modifier
                .size(size = 48.dp)
                .clip(shape = CircleShape)
                .border(width = 1.dp, color = Color.Red, shape = CircleShape)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTutorialTheme {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.background
        ) {
            Conversation(messages = getDummyMessage())
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreviewDark() {
//    ComposeTutorialTheme(darkTheme = true) {
//        Surface(
//            modifier = Modifier.fillMaxWidth(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            Conversation(messages = getDummyMessage())
//        }
//    }
//}