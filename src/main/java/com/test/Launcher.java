package com.test;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Launcher {


    public static void main(String[] args) {
        LwjglApplicationConfiguration configuration = new LwjglApplicationConfiguration();
        configuration.width = 480;
        configuration.height = 800;
        LwjglApplication lwjglApplication = new LwjglApplication(new Applicatoin(),configuration);

    }
}
