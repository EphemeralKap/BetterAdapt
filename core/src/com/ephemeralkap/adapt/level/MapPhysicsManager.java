/* CLASS:
 * AUTHOR: EphemeralKap
 * DESCRIPTION:
 ****************************************************************************/
package com.ephemeralkap.adapt.level;

import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.ephemeralkap.adapt.interfaces.IMapManager;
import java.util.Iterator;

public class MapPhysicsManager implements IMapManager {

    private World world;
    private float units;
    private Array<Body> bodies;
    final short CATEGORY_OBSTACLES = 0x0004;
    final short MASK_OBSTACLES = -1;

    public MapPhysicsManager(World world, float unitsPerPixel) {
        this.bodies = new Array<Body>();
        this.world = world;
        this.units = unitsPerPixel;

    }

    public void createPhysics(Map map) {
        MapLayer layer = map.getLayers().get("MAP_PHYSICS");

        if (layer == null) {
            return;
        }

        MapObjects objects = layer.getObjects();
        Iterator<MapObject> objectIt = objects.iterator();

        while (objectIt.hasNext()) {
            MapObject object = objectIt.next();

            if (object instanceof TextureMapObject) {
                continue;
            }

            Shape shape;
            BodyDef bodyDef = new BodyDef();
            bodyDef.type = BodyDef.BodyType.StaticBody;

            if (object instanceof RectangleMapObject) {
                RectangleMapObject rectangle = (RectangleMapObject) object;
                shape = getRectangle(rectangle);
            } else {
                continue;
            }

            FixtureDef fixtureDef = new FixtureDef();
            fixtureDef.shape = shape;
            fixtureDef.density = 1.0f;
            fixtureDef.friction = 1.0f;
            fixtureDef.restitution = 0.0f;

            Body body = world.createBody(bodyDef);
            body.createFixture(fixtureDef);

            Filter filter = new Filter();
            filter.categoryBits = CATEGORY_OBSTACLES;
            filter.maskBits = MASK_OBSTACLES;

            body.getFixtureList().first().setFilterData(filter);

            bodies.add(body);

            fixtureDef.shape = null;
            shape.dispose();
        }
    }

    /**
     * Destroys every static body that has been created using the manager.
     */
    public void destroyPhysics() {
        for (Body body : bodies) {
            world.destroyBody(body);
        }
        bodies.clear();
    }

    private Shape getRectangle(RectangleMapObject rectangleObject) {
        Rectangle rectangle = rectangleObject.getRectangle();
        PolygonShape polygon = new PolygonShape();
        Vector2 size = new Vector2((rectangle.x + rectangle.width * 0.5f) / units,
                (rectangle.y + rectangle.height * 0.5f) / units);
        polygon.setAsBox(rectangle.width * 0.5f / units,
                rectangle.height * 0.5f / units,
                size,
                0.0f);
        return polygon;
    }

    @Override
    public void cleanUp() {
        destroyPhysics();
    }

    @Override
    public void createMap(Map map) {
        createPhysics(map);
    }

}