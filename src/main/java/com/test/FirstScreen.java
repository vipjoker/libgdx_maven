package com.test;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by oleh on 31.01.17.
 */
public class FirstScreen implements ApplicationListener {
    public void create() {

    }

    public void resize(int width, int height) {

    }

    public void render() {
        Gdx.gl20.glClearColor(255/14f,255/95f,118f,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public void pause() {

    }

    public void resume() {

    }

    public void dispose() {

    }
}
