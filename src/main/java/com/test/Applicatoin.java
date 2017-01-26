package com.test;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by oleh on 26.01.17.
 */
public class Applicatoin implements ApplicationListener {

    Sprite circle,triangle,square;
    SpriteBatch batch;
    public void create() {
        batch = new SpriteBatch();
        circle = new Sprite(new Texture("circle.png"));
        square = new Sprite(new Texture("rect.png"));
        triangle = new Sprite(new Texture("triangle.png"));
        triangle.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    public void resize(int i, int i1) {

    }
float angle = 1f;
    public void render() {
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        triangle.rotate(angle);
        circle.draw(batch,.2f);

        triangle.draw(batch,.2f);
        square.draw(batch,.2f);
        batch.end();

    }

    public void pause() {

    }

    public void resume() {

    }

    public void dispose() {

    }
}
