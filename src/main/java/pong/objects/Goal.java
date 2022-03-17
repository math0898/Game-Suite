package pong.objects;

import pong.PongGame;
import sugaEngine.GameObject;
import sugaEngine.graphics.GraphicsPanel;
import sugaEngine.physics.HitBox;
import sugaEngine.physics.Vector;

import java.awt.*;

/**
 * The goal is used to add points to the score of a player when the ball makes contact.
 *
 * @author Sugaku
 */
public class Goal extends PongGameObject {

    /**
     * A pointer to the PongGame instance which is used to add to scores and re-serve the ball.
     */
    private final PongGame game;

    /**
     * Creates a new Collidable object with the immutable property set to either true or false.
     *
     * @param pos       The position of this goal.
     * @param height    The height of the HitBox.
     * @param game      The pong game instance.
     */
    public Goal (Vector pos, double height, PongGame game) {
        super(true, 200, height, game);
        this.pos = pos;
        this.game = game;
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
        if (PongGame.getDevMode()) drawHitBox(panel, Color.MAGENTA);
    }

    /**
     * Runs collision logic. May, but in general should not modify the object passed.
     *
     * @param obj The object that this collidable collided with.
     */
    @Override
    public void collision (HitBox obj) {
        if (obj instanceof GameObject collided)
            if (collided.getName().equals("Ball")) {
                String target = collided.getVelocity().getX() < 0 ? "AI" : "Player";
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
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
    public void touch (HitBox obj) {

    }

    /**
     * Returns the name of this object for use during collisions.
     *
     * @return The name of this object.
     */
    @Override
    public String getName () {
        return "Goal";
    }
}
