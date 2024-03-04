package com.gadwissberg.example

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2

class LibktxHelloWorld : ApplicationAdapter() {

    private var batch: SpriteBatch? = null
    private var image: Texture? = null
    private val position: Vector2 = Vector2(140f, 210f)
    private val velocity: Vector2 = Vector2(1F, 0F)

    override fun create() {
        batch = SpriteBatch()
        image = Texture("smiley.png")
    }

    override fun render() {
        position.add(velocity)


        if (position.x <= 0F || position.x + image!!.width >= Gdx.graphics.width) {
            velocity.scl(-1F)
        }


        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)


        batch!!.begin()
        batch!!.draw(image, position.x, position.y)
        batch!!.end()
    }

    override fun dispose() {
        batch!!.dispose()
        image!!.dispose()
    }
}
