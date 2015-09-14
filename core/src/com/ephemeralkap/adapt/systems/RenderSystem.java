/* CLASS:
 * AUTHOR: EphemeralKap
 * DESCRIPTION:
 ****************************************************************************/
package com.ephemeralkap.adapt.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ephemeralkap.adapt.components.RenderableComponent;
import com.ephemeralkap.adapt.components.SpriteComponent;


public class RenderSystem extends IteratingSystem {

    private ImmutableArray<Entity> entities;
    private SpriteBatch batch;
    
    private ComponentMapper<SpriteComponent> sm = ComponentMapper.getFor(SpriteComponent.class);
    
    public RenderSystem(SpriteBatch batch) {
        super(Family.all(RenderableComponent.class, SpriteComponent.class).get());
        this.batch = batch;
    }

    @Override
    protected void processEntity(Entity entity, float f) {
        SpriteComponent scom = sm.get(entity);
        scom.sprite.draw(batch);
    }
} 