package com.test;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;

/**
 * Created by oleh on 31.01.17.
 */
public class FirstScreen implements ApplicationListener {

    Button btnPlay;
    Stage stage ;
    Table table;
    SpriteBatch batch;

    public void create() {
        stage = new Stage();
        batch = new SpriteBatch();
        table = new Table();
        Skin skin = new Skin();
        Gdx.input.setInputProcessor(stage);
        skin.add("btn_press",new Texture("screen/button_pressed.png"));
        skin.add("btn_unpress",new Texture("screen/button_unpressed.png"));
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.down = skin.getDrawable("btn_unpress");
        style.up = skin.getDrawable("btn_press");
        btnPlay = new Button(style);
        btnPlay.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("clicked");
            }
        });

        table.setDebug(true);
        table.setFillParent(true);


        stage.addActor(table);
        stage.addActor(btnPlay);

        table.add(getTextButton("One")).center().colspan(2);

        table.row().expandY();
        table.add(getTextButton("Two"));
        table.add(getTextButton("Three"));
        table.row();
        table.add(getTextButton("Four"));
        table.add(getTextButton("Five"));
    }

    private Button getTextButton(String btnText){
        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = new BitmapFont();
        buttonStyle.fontColor = Color.RED;
        NinePatch patch = new NinePatch(new Texture("button.png"));
        buttonStyle.up = new NinePatchDrawable(patch);
        return new TextButton(btnText,buttonStyle);
    }

    public void resize(int width, int height) {

    }

    public void render() {
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl20.glClearColor(14f/255f,95f/255f,118f/255f,1);

        stage.draw();

    }

    public void pause() {

    }

    public void resume() {

    }

    public void dispose() {

    }
}
