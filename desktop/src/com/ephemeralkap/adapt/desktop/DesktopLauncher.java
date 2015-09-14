package com.ephemeralkap.adapt.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ephemeralkap.adapt.BetterAdapt;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.title = "BetterAdapt";
                config.width = 800;
                config.height = 600;
		new LwjglApplication(new BetterAdapt(), config);
	}
}
