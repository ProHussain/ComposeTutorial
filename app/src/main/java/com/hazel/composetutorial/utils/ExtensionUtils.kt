package com.hazel.composetutorial.utils

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hazel.composetutorial.dto.Message
import com.hazel.composetutorial.ui.theme.ComposeTutorialTheme

fun ComponentActivity.setContentView(unit: @Composable () -> Unit) {
    this.setContent {
        ComposeTutorialTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.surface
            ) {
                unit()
            }
        }
    }
}

fun getDummyMessage(): ArrayList<Message> {
    val list = arrayListOf<Message>()
    list.add(Message("Hazel", "Hello"))
    list.add(Message("Hazel", "How are you?"))
    list.add(Message("User", "I'm fine, thank you."))
    list.add(Message("User", "And you?"))
    list.add(Message("Hazel", "I'm fine too."))
    list.add(Message("Hazel", "What are you doing?"))
    list.add(Message("User", "I'm learning Jetpack Compose and found it very interesting and easy to use. My first app is a chat app that use Jetpack Compose and I'm using it to talk to you."))
    list.add(Message("Hazel", "Oh, that's great."))
    list.add(Message("Hazel", "I'm learning Jetpack Compose too and My first app is a news app. I'm using it to read news from all over the world with Realtime Database."))
    list.add(Message("User", "Really?"))
    list.add(Message("Hazel", "Yes."))
    list.add(Message("Hazel", "What do you think about Jetpack Compose? Will it be the future of Android UI? What do you think?"))
    list.add(Message("User", "I think it's great. It's very easy to learn. I learned it in just a few days from the official documentation."))
    list.add(Message("User", "It's easy to use."))
    list.add(Message("User", "And it's very powerful."))
    list.add(Message("Hazel", "I think so too."))
    list.add(Message("Hazel", "I think it's the future of Android UI."))
    list.add(Message("User", "I think so too."))
    return list
}