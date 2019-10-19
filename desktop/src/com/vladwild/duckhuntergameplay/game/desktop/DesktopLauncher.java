package com.vladwild.duckhuntergameplay.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.vladwild.duckhuntergameplay.game.game.DuckHunterGamePlay;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new DuckHunterGamePlay(), config);
	}
}
