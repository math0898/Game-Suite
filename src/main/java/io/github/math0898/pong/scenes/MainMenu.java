package io.github.math0898.pong.scenes;

import io.github.math0898.pong.ui.MainMenuDrawer;
import suga.engine.GameEngine;
import suga.engine.game.Game;
import suga.engine.game.Scene;
import suga.engine.input.keyboard.KeyValue;
import suga.engine.logger.Level;

import java.awt.*;
import java.io.IOException;

/**
 * The io.github.math0898.main menu for the PongGame.
 *
 * @author Sugaku
 */
public class MainMenu implements Scene {

    /**
     * The MainMenu drawing listener.
     */
    private MainMenuDrawer menu;

    /**
     * The game this scene is attached to.
     */
    private Game game;

    /**
     * Loads this scene into the given game.
     *
     * @param game The game to load this scene into.
     * @return True if loading was successful. Otherwise, false.
     */
    @Override
    public boolean load (Game game) {
        GameEngine.getLogger().log("MainMenu: Loaded main menu.", Level.DEBUG);
        this.game = game;
        game.clear();
        try {
            menu = new MainMenuDrawer(game.getMouseListener());
            game.addDrawingListener(menu);
        } catch (IOException exception) {
            GameEngine.getLogger().log(exception, Level.EXCEPTION);
            return false;
        }
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
        if (pressed) {
            if (key == KeyValue.ARROW_DOWN || key == KeyValue.ARROW_UP)
                menu.move(key);
        } else {
            if (key == KeyValue.ENTER) menu.enter(game);
        }
    }

    /**
     * Passes a mouse input into the scene.
     *
     * @param pos     The position of the mouse when it was clicked.
     * @param pressed True if the button was pressed, false if it was released.
     */
    @Override
    public void mouseInput (Point pos, boolean pressed) {
        if (pressed)
            menu.enter(game);
    }
}
