package io.github.math0898.pong.objects;

import io.github.math0898.pong.PongGame;
import suga.engine.game.Game;
import suga.engine.game.objects.GameObject;
import suga.engine.graphics.DrawListener;
import suga.engine.graphics.GraphicsPanel;
import suga.engine.physics.Vector;
import suga.engine.physics.collidables.Collidable;
import suga.engine.physics.hitboxes.HitBox;
import suga.engine.physics.hitboxes.SquareHitBox;

import java.awt.*;

/**
 * A paddle is controlled by a player or AI and is used to hit the ball back and forth.
 *
 * @author Sugaku
 */
public class Paddle implements DrawListener, Collidable, GameObject { // todo extend BasicPhysical.

    /**
     * Max velocity of the paddle vertically.
     */
    public static final double MAX_PADDLE_SPEED = 8.0;

    /**
     * The inertia values of the paddle.
     */
    public static final double PADDLE_INERTIA_VALUES = 0.4;

    /**
     * The max acceleration value of the paddle.
     */
    public static final double PADDLE_ACCELERATION = 0.8;

    /**
     * The game this paddle is part of.
     */
    private final Game game;

    /**
     * The current position of this paddle.
     */
    private Vector pos;

    /**
     * The current velocity of this paddle.
     */
    private Vector vel;

    /**
     * The current acceleration of this paddle.
     */
    private Vector accel;

    /**
     * The HitBox of this paddle.
     */
    private HitBox hitBox;

    /**
     * Creates a new Paddle with the given position.
     *
     * @param pos  The starting position of the Paddle.
     * @param game The game that this paddle is a part of.
     */
    public Paddle (Vector pos, Game game) {
        this.pos = pos;
        this.vel = Vector.ZERO.clone();
        this.vel = Vector.ZERO.clone();
        this.game = game;
        this.hitBox = new SquareHitBox(10, 100, pos);
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
     * Called every drawing frame so programs have a chance to make their voices heard on what gets drawn.
     *
     * @param width  The width of the pixel map.
     * @param height The height of the pixel map.
     * @param panel  The panel to apply changes to.
     */
    @Override
    public void applyChanges (int width, int height, GraphicsPanel panel) {
        Color c = game.getThread().getPaused() ? Color.DARK_GRAY : Color.WHITE;
        for (int i = (int)  (pos.getY() - 45); i <= (int) (pos.getY() + 45); i += 10)
            panel.setBigPixel((int) pos.getX(), i, 10, c);
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
        double width = ((SquareHitBox) hitBox).getWidth();
        double height = ((SquareHitBox) hitBox).getHeight();
        final double ballWidth = 40; // todo Could cause problems in the future.
        final double wallHeight = 100;
        if (obj instanceof Ball collided) {
            int x = (int) (collided.getVelocity().getX() > 0 ?
                    (int) (pos.getX() + (width / 2)) + (ballWidth / 2) :
                    (int) (pos.getX() - (width / 2)) - (ballWidth / 2));
            collided.getPos().setX(x);
            collided.getVelocity().setY(obj.getPos().getY() - pos.getY());
            collided.getVelocity().scale(1.0, 0.2, 1.0);
        } else if (obj instanceof Wall collided) {
            if (pos.getY() - collided.getPos().getY() > 0 && vel.getY() < 0) {
                pos.setY(collided.getPos().getY() + (wallHeight / 2.0) + (height / 2.0));
                vel.setY(0);
            }
            else if (pos.getY() - collided.getPos().getY() < 0 && vel.getY() > 0) {
                pos.setY(collided.getPos().getY() - (wallHeight / 2.0) - (height / 2.0));
                vel.setY(0);
            }
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
        return null;
    }

    /**
     * Gets the center position of this collidable object. Modifying this position object will modify the position of
     * the object.
     *
     * @return The center position of this collidable object.
     */
    @Override
    public Vector getPos () {
        return null;
    }

    /**
     * Sets the position of this collidable object. Modifying the position object after passing it will modify the
     * position of the object.
     *
     * @param pos The new position for this collidable object.
     */
    @Override
    public void setPos (Vector pos) {

    }

    /**
     * Gets the current velocity of this physical object. Modifying this velocity object will modify the velocity of the
     * object.
     *
     * @return The current velocity of this object.
     */
    @Override
    public Vector getVelocity () {
        return null;
    }

    /**
     * Sets the current velocity of this physical object. Modifying the velocity object after passing it will modify the
     * velocity of the object.
     *
     * @param vel The new velocity for this object.
     */
    @Override
    public void setVelocity (Vector vel) {

    }

    /**
     * Gets the current acceleration of this physical object. Modifying this acceleration object will modify the
     * acceleration of the object.
     *
     * @return The current acceleration of this object.
     */
    @Override
    public Vector getAcceleration () {
        return null;
    }

    /**
     * Sets the current acceleration of this physical object. Modifying the acceleration object after passing it will
     * modify the acceleration of the object.
     *
     * @param accel The new acceleration for this object.
     */
    @Override
    public void setAcceleration (Vector accel) {

    }

    /**
     * Accessor method for the mass of this object. Mass numbers larger than int max should be considered unmovable.
     *
     * @return The mass of this object.
     */
    @Override
    public double getMass () {
        return 0;
    }

    /**
     * Sets the mass of this object.
     *
     * @param mass The new mass of this object.
     */
    @Override
    public void setMass (double mass) {

    }

    /**
     * Updates this object's location based on the acceleration, velocity, and current position.
     */
    @Override
    public void update () {
        pos.add(vel);
        vel.add(accel);
        if (Math.abs(vel.getY()) > MAX_PADDLE_SPEED) vel.setY(vel.getY() > 0 ? MAX_PADDLE_SPEED : -1 * MAX_PADDLE_SPEED);
        if (accel.getY() == 0 && vel.magnitude() > PADDLE_INERTIA_VALUES)
            vel.setY(vel.getY() > 0 ? vel.getY() - PADDLE_INERTIA_VALUES : vel.getY() + PADDLE_INERTIA_VALUES);
        else if (accel.getY() == 0 && vel.magnitude() <= PADDLE_INERTIA_VALUES) vel.setY(0);
    }
}
