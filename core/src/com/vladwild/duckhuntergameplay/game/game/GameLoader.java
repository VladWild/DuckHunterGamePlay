package com.vladwild.duckhuntergameplay.game.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.GridPoint2;
import com.vladwild.duckhuntergameplay.game.InputProcessors.InputProcessorWeapons;
import com.vladwild.duckhuntergameplay.game.gameplay.BackGround;
import com.vladwild.duckhuntergameplay.game.gameplay.Cloud;
import com.vladwild.duckhuntergameplay.game.gameplay.Lawn;
import com.vladwild.duckhuntergameplay.game.resource.ResourceManager;
import com.vladwild.duckhuntergameplay.game.weapons.Bow;

import java.util.ArrayList;
import java.util.List;

/**
 * Загрузчик в игре
 */

public class GameLoader implements Screen {
    private static final String PROPERTY_GAMEPLAY = "property\\gameplay.properties";       //файл prorerties gameplay
    private static final String PROPERTY_WEAPONS = "property\\weapons.properties";         //файл prorerties оружия
    private static final String CLOUDS = "cloud_0";

    private static final int NUMBER_CLOUD = 4;                                       //количество облаков

    public List<Cloud> clouds = new ArrayList<Cloud>();              //для GamePlay
    public BackGround backgroung;
    public Lawn lawn;

    public Bow bow;                                                  //для оружия

    public static final int SCREEN_WIDTH = 2000;              //размер экрана по высоте
    public static final int SCREEN_HEIGTH = 1200;             //размер экрана по ширине

    public static final int CENTER_POSITION_WEAPON_X = 1000;  //центральная позиция оружия, координата x
    public static final int CENTER_POSITION_WEAPON_Y = 100;   //центральная позиция оружия, координата y
    public static final int RADIUS = 50;                      //радиус

    public SpriteBatch batch;                            //SpriteBatch
    public OrthographicCamera camera;                    //камера
    public InputProcessorWeapons inputProcessorWeapons;  //общий InputProcessor

    private DuckHunterGamePlay game;
    private Sprite loading; //временно

    GameLoader(DuckHunterGamePlay game){

        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGTH);

        batch = new SpriteBatch();
        loading = new Sprite(new Texture("loading.png")); //временно

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(loading, 0, 0, SCREEN_WIDTH, SCREEN_HEIGTH);
        batch.end();

        //------------------------------------------------------
        //для GamePlay

        for (int i = 0; i < NUMBER_CLOUD; i++){
            clouds.add(new Cloud(new Sprite(new Texture(new ResourceManager(PROPERTY_GAMEPLAY).getFileHandle(CLOUDS + String.valueOf(i + 1)))),
                    new GridPoint2(i * 500, 800 + 200 * (i%2) )));
        }
        backgroung = new BackGround();
        lawn = new Lawn();

        //оружие

        bow = new Bow();

        inputProcessorWeapons = new InputProcessorWeapons(new GridPoint2(CENTER_POSITION_WEAPON_X, CENTER_POSITION_WEAPON_Y),
                RADIUS, bow.getHeigth());





        game.setScreen(new GamePlay(this));

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
