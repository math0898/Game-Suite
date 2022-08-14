package io.github.math0898.pong.objects;

import io.github.math0898.pong.PongGame;
import suga.engine.game.Game;
import suga.engine.game.objects.GameObject;
import suga.engine.graphics.DrawListener;
import suga.engine.graphics.GraphicsPanel;
import suga.engine.physics.BasicPhysical;
import suga.engine.physics.Vector;
import suga.engine.physics.collidables.Collidable;
import suga.engine.physics.hitboxes.HitBox;
import suga.engine.physics.hitboxes.SquareHitBox;

import java.awt.*;

/**
 * The ball for the game of pong. Simply bounces when hitting any object.
 *
 * @author Sugaku
 */
public class Ball extends BasicPhysical implements Collidable, DrawListener, GameObject {

    /**
     * The game this ball is part of.
     */
    private final Game game;

    /**
     * The HitBox of this ball.
     */
    private HitBox hitBox;

    /**
     * Creates a new Ball for the game Pong.
     *
     * @param pos  The position of the pong ball.
     * @param vel  The velocity of the pong ball.
     * @param game The game that this ball is part of.
     */
    public Ball (Vector pos, Vector vel, Game game) {
        super(pos, vel, Vector.ZERO.clone(), 1);
        this.game = game;
        hitBox = new SquareHitBox(20, 20, pos);
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
        Color c = game.getThread().getPaused() ? Color.DARK_GRAY : Color.WHITE;
        panel.setBigPixel((int) pos.getX(), (int) pos.getY(), 20, c);
        if (PongGame.getDevMode()) hitBox.drawHitBox(panel);
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
        if (obj instanceof Paddle) {
            vel.scale(-1.0, 1.0, 1.0);
            vel.add(new Vector(vel.getX() > 0 ? 0.2 : -0.2, 0, 0));
            int x = obj.getPos().getX() <= 540 ? // todo This depends on screen size.
                    (int) (pos.getX() + (10 / 2)) + (20 / 2) :
                    (int) (pos.getX() - (10 / 2)) - (20 / 2);
            pos.setX(x);
            vel.setY(pos.getY() - obj.getPos().getY()); // Change vertical velocity depending on where the ball hit the paddle.
            vel.scale(1.0, 0.2, 1.0);
        } else if (obj instanceof Wall) vel.scale(1.0, -1.0, 1.0);
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
        return new Ball(pos.clone(), vel.clone(), game);
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
    public DrawListener getDrawListener() {
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
}
