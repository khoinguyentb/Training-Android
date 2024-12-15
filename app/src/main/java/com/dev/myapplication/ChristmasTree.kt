package com.dev.myapplication

interface ChristmasTree {
    fun decorate(): String
}

class BasicChristmasTree : ChristmasTree {
    override fun decorate(): String = "Cây thông"
}

abstract class TreeDecorator(private val tree: ChristmasTree) : ChristmasTree {
    override fun decorate(): String = tree.decorate()
}

class LightsDecorator(tree: ChristmasTree) : TreeDecorator(tree) {
    override fun decorate(): String = super.decorate() + " với đèn"
}

class BallsDecorator(tree: ChristmasTree) : TreeDecorator(tree) {
    override fun decorate(): String = super.decorate() + " với quả cầu"
}

class RibbonsDecorator(tree: ChristmasTree) : TreeDecorator(tree) {
    override fun decorate(): String = super.decorate() + " với dải ruy băng"
}
