package com.dev.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        main()
    }

    fun main() {
        // **1. Tạo và trang trí cây thông (Decorator + Builder Pattern)**
        val christmasTree = ChristmasTreeBuilder()
            .addBalls()
            .addLights()
            .addRibbons()
            .build()

        println("Cây thông: ${christmasTree.decorate()}")

        // **2. Gửi thiệp Giáng Sinh (Strategy Pattern)**
        val cardSender = CardSender(EmailStrategy())
        println("Gửi thiệp Giáng Sinh:")
        cardSender.send("Chúc bạn Giáng Sinh an lành và hạnh phúc!")

        // Chuyển sang gửi qua SMS
        cardSender.setStrategy(SMSStrategy())
        cardSender.send("Chúc bạn và gia đình một mùa Giáng Sinh ấm áp!")

        // **3. Quan sát trạng thái cây thông (Observer Pattern)**
        val treeState = ChristmasTreeState()
        val user1 = User("Người dùng A")
        val user2 = User("Người dùng B")

        // Đăng ký người dùng nhận thông báo
        treeState.addObserver(user1)
        treeState.addObserver(user2)

        println("\nCập nhật trạng thái cây thông:")
        treeState.state = "Cây thông được trang trí với đèn và quả cầu."
        treeState.state = "Cây thông được thêm dải ruy băng!"

        // **4. Tạo quà tặng Giáng Sinh (Factory Pattern)**
        println("\nDanh sách quà tặng:")
        val teddyBear = GiftFactory.createGift("TeddyBear")
        val christmasJacket = GiftFactory.createGift("ChristmasJacket")
        val christmasTreeGift = GiftFactory.createGift("ChristmasTree")

        println("- ${teddyBear.getName()}")
        println("- ${christmasJacket.getName()}")
        println("- ${christmasTreeGift.getName()}")
    }

}