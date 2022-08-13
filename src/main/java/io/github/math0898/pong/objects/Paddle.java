package io.github.math0898.pong.objects;

import suga.engine.game.Game;
import suga.engine.game.objects.GameObject;
import suga.engine.graphics.DrawListener;
import suga.engine.graphics.GraphicsPanel;
import suga.engine.physics.Vector;
import suga.engine.physics.collidables.Collidable;
import suga.engine.physics.hitboxes.HitBox;

import java.awt.*;

/**
 * A paddle is controlled by a player or AI and is used to hit the ball back and forth.
 *
 * @author Sugaku
 */
public class Paddle extends PongGameObject {

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
     * Creates a new Collidable object with the immutable property set to either true or false.
     *
     * @param pos The starting position of the Paddle.
     * @param game The game that this paddle belongs to.
     */
    public Paddle (Vector pos, Game game) {
        super(false, 10, 100, game);
//        this.pos = pos;
    }

    /**
     * Called every logic frame to run the logic on this GameObject.
     */
    @Override
    public void runLogic () {
//        pos.add(velocity);
//        velocity.add(accel);
//        if (Math.abs(velocity.getY()) > MAX_PADDLE_SPEED) velocity.setY(velocity.getY() > 0 ? MAX_PADDLE_SPEED : -1 * MAX_PADDLE_SPEED);
//        if (accel.getY() == 0 && velocity.magnitude() > PADDLE_INERTIA_VALUES)
//            velocity.setY(velocity.getY() > 0 ? velocity.getY() - PADDLE_INERTIA_VALUES : velocity.getY() + PADDLE_INERTIA_VALUES);
//        else if (accel.getY() == 0 && velocity.magnitude() <= PADDLE_INERTIA_VALUES) velocity.setY(0);
    }

    @Override
    public void setDrawListener(DrawListener drawListener) {

    }

    @Override
    public DrawListener getDrawListener() {
        return null;
    }

    @Override
    public void setCollider(Collidable collidable) {

    }

    @Override
    public Collidable getCollider() {
        return null;
    }

    /**
     * Called every drawing frame so programs have a chance to make their voices heard on what gets drawn.
     *
     * @param width  The width of the pixel map.
     * @param height The height of the pixel map.
     * @param panel  The panel to apply changes to.
     */
//    @Override
    public void applyChanges (int width, int height, GraphicsPanel panel) {
        Color c = game.getThread().getPaused() ? Color.DARK_GRAY : Color.WHITE;
//        for (int i = (int)  (pos.getY() - 45); i <= (int) (pos.getY() + 45); i += 10)
//            panel.setBigPixel((int) pos.getX(), i, 10, c);
//        if (PongGame.getDevMode()) drawHitBox(panel, Color.RED);
    }

    /**
     * Runs collision logic. May, but in general should not modify the object passed.
     *
     * @param obj The object that this collidable collided with.
     */
//    @Override
    public void collision (HitBox obj) {
        if (obj instanceof GameObject collided) {
//            if (collided.getName().equals("Ball")) {
//                int x = (int) (collided.getVelocity().getX() > 0 ?
//                        (int) (pos.getX() + (this.width / 2)) + (obj.getWidth() / 2) :
//                        (int) (pos.getX() - (this.width / 2)) - (obj.getWidth() / 2));
//                collided.getPos().setX(x);
//                collided.getVelocity().setY(obj.getPos().getY() - pos.getY());
//                collided.getVelocity().scale(1.0, 0.2, 1.0);
//            } else if (collided.getName().equals("Wall")) {
//                if (pos.getY() - collided.getPos().getY() > 0 && velocity.getY() < 0) {
//                    pos.setY(collided.getPos().getY() + (collided.getHeight() / 2.0) + (height / 2.0));
//                    velocity.setY(0);
//                }
//                else if (pos.getY() - collided.getPos().getY() < 0 && velocity.getY() > 0) {
//                    pos.setY(collided.getPos().getY() - (collided.getHeight() / 2.0) - (height / 2.0));
//                    velocity.setY(0);
//                }
//            }
        }
    }

    /**
     * Runs touching logic. May modify the object passed.
     *
     * @param obj The object that this collidable is touching.
     */
//    @Override
    public void touch (HitBox obj) {

    }

    /**
     * Returns the name of this object for use during collisions.
     *
     * @return The name of this object.
     */
//    @Override
    public String getName () {
        return "Paddle";
    }

    @Override
    public Vector getPos() {
        return null;
    }

    @Override
    public void setPos(Vector vector) {

    }

    @Override
    public Vector getVelocity() {
        return null;
    }

    @Override
    public void setVelocity(Vector vector) {

    }

    @Override
    public Vector getAcceleration() {
        return null;
    }

    @Override
    public void setAcceleration(Vector vector) {

    }

    @Override
    public double getMass() {
        return 0;
    }

    @Override
    public void setMass(double v) {

    }

    @Override
    public void update() {

    }
}
