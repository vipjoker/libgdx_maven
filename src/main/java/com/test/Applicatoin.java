package com.test;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;

/**
 * Created by oleh on 26.01.17.
 */
public class Applicatoin implements ApplicationListener {

    Sprite circle,triangle,square,star;
    SpriteBatch batch;
    public void create() {
        batch = new SpriteBatch();
        circle = new Sprite(new Texture("circle.png"));
        square = new Sprite(new Texture("rect.png"));
        triangle = new Sprite(new Texture("triangle.png"));
        star = new Sprite(new Texture("star.png"));
        star.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        triangle.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        star.setX(Gdx.graphics.getWidth()/2);
        star.setY(Gdx.graphics.getHeight()/2);
    }

    public void resize(int i, int i1) {

    }
float angle = 1f;
    public void render() {
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        float apply = Interpolation.elasticIn.apply(angle);
        triangle.rotate(0.1f);
        circle.draw(batch,.2f);
        star.draw(batch);
        triangle.draw(batch,.2f);
        square.draw(batch,.2f);
        square.translateX(apply);
        batch.end();

    }

    public void pause() {

    }

    public void resume() {

    }

    public void dispose() {

    }
}
