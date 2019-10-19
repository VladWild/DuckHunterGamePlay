package com.vladwild.duckhuntergameplay.game.gameplay;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.GridPoint2;
import com.vladwild.duckhuntergameplay.game.resource.ResourceManager;

/**
 * Лужайка
 */

public final class Lawn {
    private static final String PROPERTY_GAMEPLAY = "property\\gameplay.properties";       //файл prorerties gameplay
    private static final String LAWN = "lawn";
    private static final int POSITION_X = 600;
    private static final int POSITION_Y = 0;
    private Sprite lawnSprite;
    private GridPoint2 position;

    public Lawn(){
        lawnSprite = new Sprite(new Texture(new ResourceManager(PROPERTY_GAMEPLAY).getFileHandle(LAWN)));
        position = new GridPoint2(POSITION_X, POSITION_Y);
    }

    public Sprite getSprite(){
        return lawnSprite;
    }

    public GridPoint2 getPosition(){
        return position;
    }


}
