/* CLASS:
 * AUTHOR: EphemeralKap
 * DESCRIPTION:
 ****************************************************************************/
package com.ephemeralkap.adapt.level;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.physics.box2d.World;
import com.ephemeralkap.adapt.interfaces.IMapManager;
import java.util.ArrayList;

public class MapLoader {

    private ArrayList<IMapManager> managers = new ArrayList<IMapManager>();

    public void MapLoader() {
    }

    public void init(World world, Engine engine, float units) {
        managers.clear();
        managers.add(new MapPhysicsManager(world, units));
    }

    public void loadMap(Map map) {
        for (IMapManager manager : managers) {
            manager.createMap(map);
        }
    }

    public void clearMap() {
        for (IMapManager manager : managers) {
            manager.cleanUp();
        }
    }

}
