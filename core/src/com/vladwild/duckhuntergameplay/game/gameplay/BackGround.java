package com.vladwild.duckhuntergameplay.game.gameplay;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.GridPoint2;
import com.vladwild.duckhuntergameplay.game.resource.ResourceManager;

/**
 * Фон
 */

public final class BackGround {
    private static final String PROPERTY_GAMEPLAY = "property\\gameplay.properties";       //файл prorerties gameplay
    private static final String BACKGROUND = "background";
    private static final int POSITION_X = 0;
    private static final int POSITION_Y = 0;
    private Sprite backgroundSprite;
    private GridPoint2 position;

    public BackGround(){
        backgroundSprite = new Sprite(new Texture(new ResourceManager(PROPERTY_GAMEPLAY).getFileHandle(BACKGROUND)));
        position = new GridPoint2(POSITION_X, POSITION_Y);
    }

    public Sprite getSprite(){
        return backgroundSprite;
    }

    public GridPoint2 getPosition(){
        return position;
    }


}

