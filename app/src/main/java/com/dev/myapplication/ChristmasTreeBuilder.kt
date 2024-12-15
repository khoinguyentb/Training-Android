package com.dev.myapplication

// Builder cho cây thông
class ChristmasTreeBuilder {
    private var tree: ChristmasTree = BasicChristmasTree()

    fun addLights(): ChristmasTreeBuilder {
        tree = LightsDecorator(tree)
        return this
    }

    fun addBalls(): ChristmasTreeBuilder {
        tree = BallsDecorator(tree)
        return this
    }

    fun addRibbons(): ChristmasTreeBuilder {
        tree = RibbonsDecorator(tree)
        return this
    }

    fun build(): ChristmasTree = tree
}
