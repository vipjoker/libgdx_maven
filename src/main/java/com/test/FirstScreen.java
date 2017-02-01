package com.test;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * Created by oleh on 31.01.17.
 */
public class FirstScreen implements ApplicationListener {

    Button btnPlay;
    Table mStage;
    SpriteBatch batch;

    public void create() {
        batch = new SpriteBatch();
        mStage = new Table();
        Skin skin = new Skin();
        skin.add("btn_press",new Texture("screen/button_pressed.png"));
        skin.add("btn_unpress",new Texture("screen/button_unpressed.png"));
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.down = skin.getDrawable("btn_press");
        style.up = skin.getDrawable("btn_unpress");
        btnPlay = new Button(style);
        mStage.setDebug(true);

        mStage.add().expandX();
        mStage.add(btnPlay);
        mStage.add().expandX();

        mStage.row().expandY();
    }

    public void resize(int width, int height) {

    }

    public void render() {
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl20.glClearColor(14f/255f,95f/255f,118f/255f,1);
        batch.begin();
        mStage.draw(batch,1);
        batch.end();
    }

    public void pause() {

    }

    public void resume() {

    }

    public void dispose() {

    }
}
