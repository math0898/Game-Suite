package pong.objects;

import pong.PongGame;
import sugaEngine.Game;
import sugaEngine.graphics.GraphicsPanel;
import sugaEngine.physics.Collidable;
import sugaEngine.physics.HitBox;
import sugaEngine.physics.Vector;

import java.awt.*;

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
        this.pos = pos;
        this.velocity = vel;
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
        if (PongGame.getDevMode()) drawHitBox(panel, Color.BLUE.brighter());
    }

    /**
     * Runs collision logic. May, but in general should not modify the object passed.
     *
     * @param obj The object that this collidable collided with.
     */
    @Override
    public void collision (HitBox obj) {
        if (obj instanceof Collidable collided)
            if (collided.getName().equals("Paddle")) {
                velocity.scale(-1.0, 1.0, 1.0);
                velocity.add(new Vector(velocity.getX() > 0 ? 0.2 : -0.2, 0, 0));
            } else if (collided.getName().equals("Wall")) velocity.scale(1.0, -1.0, 1.0);
    }

    /**
     * Runs touching logic. May modify the object passed.
     *
     * @param obj The object that this collidable is touching.
     */
    @Override
    public void touch (HitBox obj) {

    }

    /**
     * Returns the name of this object for use during collisions.
     *
     * @return The name of this object.
     */
    @Override
    public String getName () {
        return "Ball";
    }
}
