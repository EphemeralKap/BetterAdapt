/* CLASS:
 * AUTHOR: EphemeralKap
 * DESCRIPTION:
 ****************************************************************************/
package com.ephemeralkap.adapt.screen;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.ephemeralkap.adapt.BetterAdapt;
import com.ephemeralkap.adapt.level.MapLoader;
import com.ephemeralkap.adapt.managers.EntityManager;

public class GameScreen extends AbstractScreen {
    
    private float WIDTH;
    private float HEIGHT;

    private Engine engine;
    private EntityManager entityManager;
    private World world;
    private Box2DDebugRenderer b2dr;
    private MapLoader mapLoader;
    
    private SpriteBatch batch;

    private OrthographicCamera cam;

    public GameScreen(BetterAdapt game) {
        super(game);
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();

        engine = new Engine();
        world = new World(new Vector2(0, -10), true);
        b2dr = new Box2DDebugRenderer();
        mapLoader = new MapLoader();
        batch = new SpriteBatch();
        
        entityManager = new EntityManager(engine, batch);

        cam = new OrthographicCamera(WIDTH, HEIGHT);
        cam.translate(WIDTH / 2, HEIGHT / 2);
        cam.setToOrtho(true, WIDTH, HEIGHT);
        cam.update();
    }

    @Override
    public void update(float delta) {
        world.step(1 / 60f, 6, 2);
        b2dr.render(world, cam.combined);
    }

    @Override
    public void dispose() {
    }
}
