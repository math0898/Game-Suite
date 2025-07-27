package io.github.math0898.tron.objects;

import suga.engine.game.objects.BasicGameObject;
import suga.engine.graphics.GraphicsPanel;
import suga.engine.physics.Vector;
import suga.engine.physics.collidables.Collidable;
import suga.engine.physics.hitboxes.HitBox;
import suga.engine.physics.hitboxes.SquareHitBox;

import java.awt.*;

/**
 * This GameObject represents the player's car in the game of Tron.
 *
 * @author Sugaku
 */
public class Player extends BasicGameObject implements Collidable {

    /**
     * The rate at which the player moves across the screen.
     */
    public final static double PLAYER_MOVE_SPEED = 5.0;

    /**
     * The player's HitBox.
     */
    private HitBox hitBox;

    /**
     * Creates a new Player object.
     */
    public Player () {
        this.hitBox = new SquareHitBox(10, 10, pos);
    }

    /**
     * Gets a collider that is present on this object. If none are present returns null.
     *
     * @return Either the Collider attached to this GameObject or null.
     */
    @Override
    public Collidable getCollider () {
        return this;
    }

    /**
     * Called every drawing frame so programs have a chance to make their voices heard on what gets drawn.
     *
     * @param width  The width of the pixel map.
     * @param height The height of the pixel map.
     * @param panel  The panel to apply changes to.
     */
    @Override
    public void applyChanges (int width, int height, GraphicsPanel panel) {
        panel.setBigPixel((int) pos.getX(), (int) pos.getY(), 30, Color.GREEN);
    }

    /**
     * Sets the current velocity of this physical object. Modifying the velocity object after passing it will modify the
     * velocity of the object.
     *
     * @param vel The new velocity for this object.
     */
    @Override
    public void setVelocity (Vector vel) {
        this.vel = vel.clone();
        this.vel.scale(PLAYER_MOVE_SPEED);
    }

    /**
     * Updates this object's location based on the acceleration, velocity, and current position.
     */
    @Override
    public void update () {
        pos.add(vel);
        vel.add(accel);
    }

    /**
     * Gets the HitBox currently being used by this collidable object.
     *
     * @return The hit box being used by this collidable object.
     */
    @Override
    public HitBox getHitBox () {
        return hitBox;
    }

    /**
     * Assigns the given HitBox to this collidable object. Will likely result in the modification of HitBox location.
     *
     * @param hitBox The new HitBox to assign to this Collidable object.
     */
    @Override
    public void setHitBox (HitBox hitBox) {
        this.hitBox = hitBox;
    }

    /**
     * Runs collision logic. May, but in general should not modify the object passed.
     *
     * @param obj The object that this collidable collided with.
     */
    @Override
    public void collision (Collidable obj) {

    }

    /**
     * Runs touching logic. May modify the object passed.
     *
     * @param obj The object that this collidable is touching.
     */
    @Override
    public void touch (Collidable obj) {

    }

    /**
     * Returns a deep copy of this collidable object. Used to preserve values of velocity, position, and acceleration
     * during collision calculations.
     *
     * @return A copy of this object with the same position, velocity, and acceleration.
     */
    @Override
    public Collidable clone () {
        try {
            return (Collidable) super.clone();
        } catch (CloneNotSupportedException ignored) { }
        return new Player(); // todo: Collisions will be wonky.
    }
}
