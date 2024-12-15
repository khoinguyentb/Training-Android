package com.dev.myapplication


interface ChristmasGift {
    fun getName(): String
}

class TeddyBear : ChristmasGift {
    override fun getName(): String = "Gấu bông"
}

class ChristmasJacket : ChristmasGift {
    override fun getName(): String = "Áo khoác Giáng Sinh"
}

class ChristmasTreeGift : ChristmasGift {
    override fun getName(): String = "Cây thông Noel"
}

object GiftFactory {
    fun createGift(type: String): ChristmasGift {
        return when (type) {
            "TeddyBear" -> TeddyBear()
            "ChristmasJacket" -> ChristmasJacket()
            "ChristmasTree" -> ChristmasTreeGift()
            else -> throw IllegalArgumentException("Loại quà tặng không hợp lệ")
        }
    }
}
