package com.vladwild.duckhuntergameplay.game.InputProcessors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.GridPoint2;

/**
 * Общий InputProcessor для всех оружий
 */

public class InputProcessorWeapons implements InputProcessor {
    private GridPoint2 start;
    private GridPoint2 position;
    private float radius;
    private float heigth;

    private float alpha;
    private GridPoint2 point;

    public InputProcessorWeapons(GridPoint2 start, float radius, float heigth){
        this.start = start;
        this.radius = radius;
        this.heigth = heigth;
        position = new GridPoint2();
        point = new GridPoint2();
    }

    private void parametrsCalculation(int screenX, int screenY){
        position.set(screenX, Gdx.graphics.getHeight() - screenY);
        alpha = (float) Math.atan(((float) (position.y - start.y))/ ((float) (position.x - start.x)));
        if (alpha < 0) {
            alpha += Math.PI;
        }
        point.set((int) (Math.sqrt(Math.pow(radius, 2) + Math.pow(heigth / 2, 2)) *
                    Math.cos(alpha - Math.atan(heigth / (2 * radius))) + start.x),
                (int) (Math.sqrt(Math.pow(radius, 2) + Math.pow(heigth / 2, 2)) *
                    Math.sin(alpha - Math.atan(heigth / (2 * radius))) + start.y));
    }

    private void selectCoeff(int screenX, int screenY){
        if (Gdx.graphics.getHeight() - screenY < start.y) {
            if (screenX < start.x) {
                alpha = (float) Math.PI;
                point.set(start.x - (int) radius, start.y + (int) heigth / 2);
            } else {
                alpha = 0;
                point.set(start.x + (int) radius, start.y - (int) heigth / 2);
            }
        } else {
            parametrsCalculation(screenX, screenY);
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        selectCoeff(screenX, screenY);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        selectCoeff(screenX, screenY);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        selectCoeff(screenX, screenY);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public float getAlpha(){
        return (float) Math.toDegrees(alpha);
        //return 0;
    }

    public GridPoint2 getPoint(){
        return point;
    }


}
