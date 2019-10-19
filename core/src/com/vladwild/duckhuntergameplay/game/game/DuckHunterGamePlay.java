package com.vladwild.duckhuntergameplay.game.game;

import com.badlogic.gdx.Game;

public class DuckHunterGamePlay extends Game {
	
	@Override
	public void create () {
		this.setScreen(new GameLoader(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {

	}
}
