package com.test;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by oleh on 30.01.17.
 */
public class VectorExample implements ApplicationListener {
    public void create() {
//        http://blog.wolfire.com/2009/07/linear-algebra-for-game-developers-part-2/

        Vector2 a = new Vector2(1,3);

    }

    public void resize(int width, int height) {

    }

    public void render() {

    }

    public void pause() {

    }

    public void resume() {

    }

    public void dispose() {

    }


    private static float cross(Vector2 a,Vector2 b){
        return (a.x * b.x - a.y * b.y);
    }

    public static void main(String[] args) {
        Vector2 a = new Vector2(1,3);
        Vector2 b = new Vector2(2,5);
        float myCrs  = cross(a,b);
        float crs = b.crs(a);

        System.out.printf("My custom %f from library %f\n",myCrs,crs);
    }
}
