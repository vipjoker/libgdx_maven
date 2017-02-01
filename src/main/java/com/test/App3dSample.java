package com.test;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;

public class App3dSample implements ApplicationListener {
    PerspectiveCamera camera;
    ModelBatch batch;
    Model model;
    ModelInstance instance;
    ModelInstance instanceBlender;
    ModelInstance instanceCapsule;
    CameraInputController controller;
    Environment environment;

    public void create() {

        initCamera();
        ModelBuilder builder = new ModelBuilder();
        model = builder.createBox(5, 5, 5, new Material(ColorAttribute.createDiffuse(Color.RED)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        instance = new ModelInstance(model);

        ModelLoader loader = new ObjLoader();

        instanceBlender = new ModelInstance(loader.loadModel(Gdx.files.internal("untitled.obj")));
        Model capsule  = builder.createCapsule(2,6,10,new Material(ColorAttribute.createDiffuse(Color.GREEN)), VertexAttributes.Usage.Position| VertexAttributes.Usage.Normal);

        instanceCapsule =  new ModelInstance(capsule);
        Material material = instanceCapsule.materials.first();


        batch = new ModelBatch();
        initEnvironment();
        controller = new CameraInputController(camera);
        Gdx.input.setInputProcessor(controller);
    }

    private void initEnvironment() {
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.4f, 0.8f, 0.8f, -1, -0.8f, -0.2f));
    }

    private void initCamera() {
        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(10, 10, 10);
        camera.lookAt(0, 0, 0);
        camera.near = 1f;
        camera.far = 300;
        camera.update();
    }

    public void resize(int width, int height) {

    }

    public void render() {
        controller.update();
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batch.begin(camera);
       // batch.render(instance, environment);
        if (Gdx.input.isKeyPressed(Input.Keys.G)) {
            instanceBlender.transform.translate(.1f, 0, 0);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.H)) {
            instanceBlender.transform.translate(-.1f, 0, 0);
        }


        instanceBlender.transform.rotate(Vector3.Y, 1);
        batch.render(instanceCapsule,environment);
        batch.render(instanceBlender, environment);
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
