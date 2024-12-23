package com.example.train

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class EventViewModel {
    private val _events = MutableSharedFlow<String>(replay = 1)
    val events: SharedFlow<String> get() = _events

    suspend fun sendEvent(event: String) {
        _events.emit(event)
    }
}

fun main() = runBlocking {
    val viewModel = EventViewModel()

    launch {
        viewModel.events.collect { event ->
            println("Received event: $event")
        }
    }

    repeat(5) {
        delay(500)
        viewModel.sendEvent("Event $it")
    }
}