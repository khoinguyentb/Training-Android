package com.dev.myapplication

interface CardSendingStrategy {
    fun sendCard(message: String)
}

class EmailStrategy : CardSendingStrategy {
    override fun sendCard(message: String) {
        println("Gửi thiệp qua email: $message")
    }
}

class SMSStrategy : CardSendingStrategy {
    override fun sendCard(message: String) {
        println("Gửi thiệp qua SMS: $message")
    }
}

class MessagingAppStrategy : CardSendingStrategy {
    override fun sendCard(message: String) {
        println("Gửi thiệp qua ứng dụng nhắn tin: $message")
    }
}

class CardSender(private var strategy: CardSendingStrategy) {
    fun setStrategy(newStrategy: CardSendingStrategy) {
        strategy = newStrategy
    }

    fun send(message: String) {
        strategy.sendCard(message)
    }
}
