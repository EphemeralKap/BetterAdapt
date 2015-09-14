/* CLASS:
 * AUTHOR: EphemeralKap
 * DESCRIPTION:
 ****************************************************************************/
package com.ephemeralkap.adapt.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ephemeralkap.adapt.BetterAdapt;

public class MenuScreen extends AbstractScreen {
    
    private SpriteBatch batch = new SpriteBatch();
    private Texture texture = new Texture(Gdx.files.internal("test.png"));
    private Sprite sprite = new Sprite(texture);


    public MenuScreen(BetterAdapt game) {
        super(game);
    }

    @Override
    public void update(float delta) {
        batch.begin();
        sprite.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }
    
}
