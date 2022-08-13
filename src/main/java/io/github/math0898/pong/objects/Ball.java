package io.github.math0898.pong.objects;

import suga.engine.game.Game;
import suga.engine.graphics.DrawListener;
import suga.engine.graphics.GraphicsPanel;
import suga.engine.physics.Vector;
import suga.engine.physics.collidables.Collidable;
import suga.engine.physics.hitboxes.HitBox;

public class Ball extends PongGameObject {

    /**
     * Creates a new Collidable object with the immutable property set to either true or false.
     *
     * @param pos The starting position of the ball.
     * @param vel The starting velocity of the ball.
     * @param game The game that this ball belongs to.
     */
    public Ball (Vector pos, Vector vel, Game game) {
        super(false, 20, 20, game);
//        this.pos = pos;
//        this.velocity = vel;
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
//        Color c = game.getThread().getPaused() ? Color.DARK_GRAY : Color.WHITE;
//        panel.setBigPixel((int) pos.getX(), (int) pos.getY(), 20, c);
//        if (PongGame.getDevMode()) drawHitBox(panel, Color.BLUE.brighter());
    }

    /**
     * Runs collision logic. May, but in general should not modify the object passed.
     *
     * @param obj The object that this collidable collided with.
     */
//    @Override
    public void collision (HitBox obj) {
//        if (obj instanceof Collidable collided)
//            if (collided.getName().equals("Paddle")) {
//                velocity.scale(-1.0, 1.0, 1.0);
//                velocity.add(new Vector(velocity.getX() > 0 ? 0.2 : -0.2, 0, 0));
//            } else if (collided.getName().equals("Wall")) velocity.scale(1.0, -1.0, 1.0);
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
        return "Ball";
    }

    @Override
    public void runLogic() {

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
