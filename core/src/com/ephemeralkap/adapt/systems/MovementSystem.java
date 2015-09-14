/* CLASS:
 * AUTHOR: EphemeralKap
 * DESCRIPTION:
 ****************************************************************************/
package com.ephemeralkap.adapt.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.ephemeralkap.adapt.components.PositionComponent;
import com.ephemeralkap.adapt.components.RenderableComponent;
import com.ephemeralkap.adapt.components.VelocityComponent;

public class MovementSystem extends EntitySystem {
    private ImmutableArray<Entity> entities;
    
    private ComponentMapper<RenderableComponent> rm = ComponentMapper.getFor(RenderableComponent.class);
    
    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(PositionComponent.class, VelocityComponent.class).get());
    }
    
    @Override
    public void update(float deltaTime) {
        for (Entity entity : entities) {
            
        }
    }
} 