package sugaEngine;

import sugaEngine.input.KeyValues;
import java.awt.*;

/**
 * The Scene object is a collection of objects, AIAgents, and a physics engine. Each game likely has multiple scenes.
 *
 * @author Sugaku
 */
public abstract class Scene {

    /**
     * The game instance that this scene is associated with.
     */
    protected Game game;

    /**
     * Loads this scene into the given game.
     *
     * @param game The game to load this scene into.
     * @return True if loading was successful. Otherwise, false.
     */
    public boolean load (Game game) {
        this.game = game;
        return true;
    }

    /**
     * Passes a keyboard input into the scene.
     *
     * @param key     The value of the key pressed.
     * @param pressed True if the key was pressed, false if it was released.
     */
    public abstract void keyboardInput (KeyValues key, boolean pressed);

    /**
     * Passes a mouse input into the scene.
     *
     * @param pos     The position of the mouse when it was clicked.
     * @param pressed True if the button was pressed, false if it was released.
     */
    public abstract void mouseInput (Point pos, boolean pressed);
}
