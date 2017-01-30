package com.test;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Interpolation;

/**
 * Created by oleh on 26.01.17.
 */
public class Applicatoin implements ApplicationListener {

    ModelBuilder modelBuilder;
    PerspectiveCamera camera;
        ModelInstance instance;
        ModelBatch modelBatch;
    Sprite circle,triangle,square,star;
    SpriteBatch batch;
    public void create() {

        camera = new PerspectiveCamera(67,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camera.position.set(10,10,10);
        camera.lookAt(0,0,0);
        camera.near = 1;
        camera.far = 300;
        camera.update();


        Model box = modelBuilder.createBox(10, 10, 10, new Material(ColorAttribute.createDiffuse(Color.GREEN)), VertexAttributes.Usage.Normal | VertexAttributes.Usage.Position);
        instance = new ModelInstance(box);
        modelBatch = new ModelBatch();
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
//        Gdx.graphics.setWindowedMode(i,i1);
    }
float angle = 1f;
    float transalatex = 1f;
    float speed = 1f;
    public void render() {
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        triangle.rotate(0.1f);
        circle.draw(batch,.2f);
        star.draw(batch);
        triangle.draw(batch,.2f);
        square.draw(batch,.2f);
        if(transalatex > Gdx.graphics.getWidth()){
            transalatex = Gdx.graphics.getWidth();
            speed *= -1;
        }
        if(transalatex  < 0 ){
            transalatex  = 0;
            speed *= -1;
        }

        transalatex+=speed;

        float apply = Interpolation.bounce.apply(transalatex/Gdx.graphics.getWidth());

        square.setX(apply *Gdx.graphics.getWidth());
        batch.end();

    }

    public void pause() {

    }

    public void resume() {


    }

    public void dispose() {

    }
}
