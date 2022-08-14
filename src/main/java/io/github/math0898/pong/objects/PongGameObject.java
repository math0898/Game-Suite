package io.github.math0898.pong.objects;

import suga.engine.game.Game;
import suga.engine.game.objects.GameObject;
import suga.engine.physics.Physical;

/**
 * A PongGameObject functions exactly the same as a normal game object except that it has a reference to the instance of
 * io.github.math0898.pong being run.
 *
 * @author Sugaku
 */
public abstract class PongGameObject implements GameObject, Physical {

    /**
     * The game that this object belongs to.
     */
    protected final Game game;

    /**
     * Creates a new Collidable object with the immutable property set to either true or false.
     *
     * @param immutable Whether this object moves during collisions or not.
     * @param width     The width of the HitBox.
     * @param height    The height of the HitBox.
     * @param game      The game that this object is being run in.
     */
    public PongGameObject (boolean immutable, double width, double height, Game game) {
        this.game = game;
    }
}