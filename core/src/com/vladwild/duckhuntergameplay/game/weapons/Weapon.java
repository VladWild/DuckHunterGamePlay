package com.vladwild.duckhuntergameplay.game.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.GridPoint2;
import com.vladwild.duckhuntergameplay.game.resource.ResourceManager;

/**
 * абстрактный класс Weapon
 */

public abstract class Weapon {
    private static final String PROPERTY_WEAPONS = "property\\weapons.properties";       //файл prorerties weapons
    private static final int POSITION_X = 1050;
    private static final int POSITION_Y = 150;
    private GridPoint2 currentPosition;
    private Sprite spriteWeapon;

    protected Weapon(String NAME_WEAPON){
        spriteWeapon = new Sprite(new Texture(new ResourceManager(PROPERTY_WEAPONS).getFileHandle(NAME_WEAPON)));
        spriteWeapon.setPosition(POSITION_X, POSITION_Y);
        spriteWeapon.setOrigin(0, 0);
        currentPosition = new GridPoint2(POSITION_X, POSITION_Y);
    }

    public void setPosition(float x, float y){
        spriteWeapon.setPosition(x, y);
    }

    public void setRotation(float alpha){
        spriteWeapon.setRotation(alpha);
    }

    public Sprite getSprite(){
        return spriteWeapon;
    }

    public GridPoint2 getPosition(){
        return currentPosition;
    }

    public int getHeigth() {
        return (int) spriteWeapon.getHeight();
    }

    abstract public Sprite getSpriteAim();

}

