package io.github.math0898.tron.scenes;

import io.github.math0898.tron.ui.MainMenuDrawer;
import suga.engine.GameEngine;
import suga.engine.game.Game;
import suga.engine.game.Scene;
import suga.engine.input.keyboard.KeyValue;
import suga.engine.logger.Level;

import java.awt.*;

/**
 * The MainMenu of the Tron game.
 *
 * @author Sugaku
 */
public class MainMenu implements Scene {

    /**
     * Loads this scene into the given game.
     *
     * @param game The game to load this scene into.
     * @return True if loading was successful. Otherwise, false.
     */
    @Override
    public boolean load (Game game) {
        GameEngine.getLogger().log("MainMenu: Loaded main menu.", Level.DEBUG);
        game.addDrawingListener(new MainMenuDrawer());
        return true;
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
