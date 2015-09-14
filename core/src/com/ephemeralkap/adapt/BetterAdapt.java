/* CLASS: BetterAdapt.java
 * AUTHOR: EphemeralKap
 * DESCRIPTION: 
 ****************************************************************************/
package com.ephemeralkap.adapt;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.ephemeralkap.adapt.screen.AbstractScreen;
import com.ephemeralkap.adapt.screen.GameScreen;
import java.util.ArrayList;

public class BetterAdapt extends Game {
    ArrayList<AbstractScreen> screens = new ArrayList<AbstractScreen>();
    
    @Override
    public void create() {
        init();
    }
    
    public void init() {
        screens.add(new GameScreen(this));
    }
    
    public void changeScreen(AbstractScreen screen) {
        if (screens.contains(screen)) {
            AbstractScreen toMove = screens.get(screens.indexOf(screen));
            screens.remove(screen);
            screens.add(0, toMove);
        } else {
            screens.add(0, screen);
        }
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        screens.get(0).update(delta);
    }
}
