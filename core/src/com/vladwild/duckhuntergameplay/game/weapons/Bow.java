package com.vladwild.duckhuntergameplay.game.weapons;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * лук
 */

public class Bow extends Weapon {
    private static final String BOW = "bow";

    public Bow(){
        super(BOW);
    }


    @Override
    public Sprite getSpriteAim() {
        return null;
    }
}
