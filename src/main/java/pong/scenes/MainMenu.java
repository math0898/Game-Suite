package pong.scenes;

import pong.ui.MainMenuDrawer;
import sugaEngine.Game;
import sugaEngine.Scene;
import sugaEngine.input.KeyValues;

import java.awt.*;
import java.io.IOException;

/**
 * The main menu for the PongGame.
 *
 * @author Sugaku
 */
public class MainMenu extends Scene {

    /**
     * Loads this scene into the given game.
     *
     * @param game The game to load this scene into.
     * @return True if loading was successful. Otherwise, false.
     */
    @Override
    public boolean load (Game game) {
        super.load(game);
        game.clear();
        try {
            game.addDrawingListener(new MainMenuDrawer());
        } catch (IOException exception) {
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
    public void keyboardInput (KeyValues key, boolean pressed) {
        if (key == KeyValues.ESC && !pressed) game.loadScene("Main Game");
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
