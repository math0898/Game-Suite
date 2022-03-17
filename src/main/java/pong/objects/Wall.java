package pong.objects;

import pong.PongGame;
import sugaEngine.Game;
import sugaEngine.graphics.GraphicsPanel;
import sugaEngine.physics.HitBox;
import sugaEngine.physics.Vector;

import java.awt.*;

/**
 * Walls are used to prevent paddles from exiting the screen as well as preventing the ball from exiting the screen.
 *
 * @author Sugaku
 */
public class Wall extends PongGameObject {

    /**
     * Creates a new Collidable object with the immutable property set to either true or false.
     *
     * @param width     The width of the HitBox.
     * @param pos       The position of the wall object.
     * @param game      The game that this wall belongs to.
     */
    public Wall (double width, Vector pos, Game game) {
        super(true, width, 100, game);
        this.pos = pos;
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
        if (PongGame.getDevMode()) drawHitBox(panel, Color.GREEN);
    }

    /**
     * Runs collision logic. May, but in general should not modify the object passed.
     *
     * @param obj The object that this collidable collided with.
     */
    @Override
    public void collision (HitBox obj) {

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
        return "Wall";
    }
}
