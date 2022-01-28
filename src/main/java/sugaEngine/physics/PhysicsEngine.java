package sugaEngine.physics;

import java.util.ArrayList;
import java.util.List;

/**
 * The PhysicsEngine has a list of all the objects currently in the world and checks every logic cycle whether any are
 * currently colliding. If they are they the appropriate method is called.
 *
 * @author Sugaku
 */
public class PhysicsEngine {

    /**
     * A list of objects that should be called for collision logic.
     */
    protected List<Collidable> objects = new ArrayList<>();

    /**
     * Checks all objects in the list for collisions with other objects. Quite a costly method may require optimization.
     */
    public void checkCollisions () {
        for (int i = 0; i < objects.size(); i++) {
            Collidable master = objects.get(i);
            for (int j = i; j < objects.size(); j++) {
                if (i == j) continue;
                Collidable temp = objects.get(j);
                boolean touching = false;
                for (Vector v : temp.getTestPoints()) if (master.isInside(v)) touching = true;
                if (touching) {
                    master.collision(temp);
                    temp.collision(master);
                }
            }
        }
    }

    /**
     * Adds a new object to the Physics Engine.
     *
     * @param object The object to add to the physics engine.
     */
    public void addObject (Collidable object) {
        objects.add(object);
    }
}
