package io.github.math0898.pong.objects;

import io.github.math0898.pong.PongGame;
import suga.engine.GameEngine;
import suga.engine.game.objects.GameObject;
import suga.engine.graphics.DrawListener;
import suga.engine.graphics.GraphicsPanel;
import suga.engine.logger.Level;
import suga.engine.physics.BasicPhysical;
import suga.engine.physics.Vector;
import suga.engine.physics.collidables.Collidable;
import suga.engine.physics.hitboxes.HitBox;
import suga.engine.physics.hitboxes.SquareHitBox;

/**
 * The goal is used to add points to the score of a player when the ball makes contact.
 *
 * @author Sugaku
 */
public class Goal extends BasicPhysical implements Collidable, GameObject, DrawListener {

    /**
     * The game this goal is part of.
     */
    private final PongGame game;

    /**
     * The HitBox of this goal.
     */
    private HitBox hitBox;

    /**
     * Creates a new Goal at the given position as part of the given game.
     *
     * @param pos    The position of this goal.
     * @param height The height of this goal.
     * @param game   The PongGame instance this goal is tied to.
     */
    public Goal (Vector pos, int height, PongGame game) {
        super(pos, Vector.ZERO.clone(), Vector.ZERO.clone(), Integer.MAX_VALUE);
        this.game = game;
        hitBox = new SquareHitBox(200, height, pos);
    }

    /**
     * Called every logic frame to run the logic on this GameObject.
     */
    @Override
    public void runLogic () {

    }

    /**
     * Attaches a DrawListener to this GameObject.
     *
     * @param listener The DrawListener to attach to this GameObject.
     */
    @Override
    public void setDrawListener (DrawListener listener) {

    }

    /**
     * If present, returns the DrawListener associated with this GameObject. May be null.
     *
     * @return Either the DrawListener attached to this GameObject or null.
     */
    @Override
    public DrawListener getDrawListener () {
        return this;
    }

    /**
     * Assigns a collider to this GameObject.
     *
     * @param collider The collider to assign to this GameObject.
     */
    @Override
    public void setCollider (Collidable collider) {

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
        if (obj instanceof Ball collided) {
            String target = collided.getVelocity().getX() < 0 ? "AI" : "Player";
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                GameEngine.getLogger().log(e, Level.WARNING);
            }
            game.addScore(target);
            game.serve(target); // For some reason this is getting raced to.
        }
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
        } catch (CloneNotSupportedException ignored) {}
        return new Goal(pos.clone(), 1080, game); // Generally the height of the goal won't matter when determining collision results.
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
        if (PongGame.getDevMode()) hitBox.drawHitBox(panel);
    }
}
