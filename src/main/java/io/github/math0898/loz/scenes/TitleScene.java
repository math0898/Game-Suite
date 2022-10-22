package io.github.math0898.loz.scenes;

import io.github.math0898.loz.ui.TitleScreenUI;
import suga.engine.game.Game;
import suga.engine.game.Scene;
import suga.engine.input.keyboard.KeyValue;

import java.awt.*;

/**
 * The TitleScene is the main scene seen upon loading the game.
 *
 * @author Sugaku
 */
public class TitleScene implements Scene {

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
    @Override
    public boolean load (Game game) {
        this.game = game;
        game.addDrawingListener(new TitleScreenUI());
        return false;
    }

    /**
     * Passes a keyboard input into the scene.
     *
     * @param key     The value of the key pressed.
     * @param pressed True if the key was pressed, false if it was released.
     */
    @Override
    public void keyboardInput (KeyValue key, boolean pressed) {

    }

    /**
     * Passes a mouse input into the scene.
     *
     * @param pos     The position of the mouse when it was clicked.
     * @param pressed True if the button was pressed, false if it was released.
     */
    @Override
    public void mouseInput (Point pos, boolean pressed) {

    }
}
