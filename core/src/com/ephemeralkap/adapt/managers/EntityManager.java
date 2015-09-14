/* CLASS:
 * AUTHOR: EphemeralKap
 * DESCRIPTION:
 ****************************************************************************/
package com.ephemeralkap.adapt.managers;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ephemeralkap.adapt.systems.MovementSystem;
import com.ephemeralkap.adapt.systems.RenderSystem;

public class EntityManager {

    private Engine engine;
    private SpriteBatch batch;
    
    public EntityManager(Engine engine, SpriteBatch batch) {
        this.engine = engine;
        this.batch = batch;
    }
    
    public void init() {
        engine.addSystem(new RenderSystem(batch));
        engine.addSystem(new MovementSystem());
    }
} 