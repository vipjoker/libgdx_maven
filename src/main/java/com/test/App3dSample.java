package com.test;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class App3dSample implements ApplicationListener {
    PerspectiveCamera camera;
    ModelBatch batch;
    Model model;
    ModelInstance instance;
    CameraInputController controller;
    Environment environment;

    public void create() {

        initCamera();
        ModelBuilder builder = new ModelBuilder();
        model = builder.createBox(5, 5, 5, new Material(ColorAttribute.createDiffuse(Color.RED)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        instance = new ModelInstance(model);
        batch = new ModelBatch();
        initEnvironment();
        controller = new CameraInputController(camera);
        Gdx.input.setInputProcessor(controller);
    }

    private void initEnvironment(){
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight,0.4f,0.4f,0.4f,1f));
        environment.add(new DirectionalLight().set(0.4f,0.8f,0.8f,-1,-0.8f,-0.2f));
    }

    private void initCamera() {
        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camera.position.set(10,10,10);
        camera.lookAt(0,0,0);
        camera.near = 1f;
        camera.far = 300;
        camera.update();
    }

    public void resize(int width, int height) {

    }

    public void render() {
        controller.update();
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT|GL20.GL_DEPTH_BUFFER_BIT);
        batch.begin(camera);
        batch.render(instance,environment);
        batch.end();
    }

    public void pause() {

    }

    public void resume() {
        model.dispose();
    }

    public void dispose() {

    }
}
