package com.vladwild.duckhuntergameplay.game.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.vladwild.duckhuntergameplay.game.gameplay.Cloud;

/**
 * Created by Lenovo on 19.09.2017.
 */

public class GamePlay implements Screen {

    private GameLoader loader;
    private Sprite center;                  //временно

    GamePlay(GameLoader loader){
        this.loader = loader;
        center = new Sprite(new Texture("point.png"));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        loader.camera.update();
        loader.batch.setProjectionMatrix(loader.camera.combined);

        Gdx.input.setInputProcessor(loader.inputProcessorWeapons);

        loader.batch.begin();
        loader.batch.draw(loader.backgroung.getSprite(), 0, 0);
        for (Cloud cloud : loader.clouds){
            loader.batch.draw(cloud.getSprite(), cloud.getPosition().x, cloud.getPosition().y);
        }
        loader.batch.draw(loader.lawn.getSprite(), loader.lawn.getPosition().x, loader.lawn.getPosition().y);
        //loader.batch.draw(loader.bow.getSprite(), loader.bow.getPosition().x, loader.bow.getPosition().y);
        loader.bow.getSprite().draw(loader.batch);

        loader.batch.draw(center, 1000, 200);        //временно
        loader.batch.end();

        //обновление координат оружия
        loader.bow.setPosition(loader.inputProcessorWeapons.getPoint().x, loader.inputProcessorWeapons.getPoint().y);
        loader.bow.setRotation(loader.inputProcessorWeapons.getAlpha());

        //loader.bow.getSprite().setRotation(i);
        //if (Gdx.input.justTouched()){
        //    ++i;
        //    System.out.println(i);
        // }




    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
