package com.hazel.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.hazel.composetutorial.ui.layouts.Conversation
import com.hazel.composetutorial.utils.getDummyMessage
import com.hazel.composetutorial.utils.setContentView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView { Conversation(messages = getDummyMessage()) }
    }
}