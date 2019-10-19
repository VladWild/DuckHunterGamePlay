package com.vladwild.duckhuntergameplay.game.gameplay;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.GridPoint2;

/**
 * Облако
 */

public final class Cloud {
    private Sprite sprite;
    private GridPoint2 position;

    public Cloud(Sprite sprite, GridPoint2 position){
        this.sprite = sprite;
        this.position = position;
    }

    public Sprite getSprite(){
        return sprite;
    }

    public GridPoint2 getPosition(){
        return position;
    }

}
