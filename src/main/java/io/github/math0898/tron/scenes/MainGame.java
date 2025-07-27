package io.github.math0898.tron.scenes;

import io.github.math0898.tron.TronGame;
import io.github.math0898.tron.objects.Player;
import io.github.math0898.tron.ui.MapDrawer;
import suga.engine.GameEngine;
import suga.engine.game.Game;
import suga.engine.game.Scene;
import suga.engine.input.keyboard.KeyValue;
import suga.engine.logger.Level;
import suga.engine.physics.Vector;

import java.awt.*;

/**
 * The MainMenuDrawer for Tron. Utilized to draw the entire game including score, enemies, and the player.
 *
 * @author Sugaku
 */
public class MainGame implements Scene {

    /**
     * The player's velocity as determined by the input.
     */
    private Vector playerVelocity = new Vector(0, 1, 0);

    /**
     * The game that this scene is part of.
     */
    private TronGame game;

    /**
     * Loads this scene into the given game.
     *
     * @param game The game to load this scene into.
     * @return True if loading was successful. Otherwise, false.
     */
    @Override
    public boolean load (Game game) {
        GameEngine.getLogger().log("MainGame: Loaded main game.", Level.DEBUG);
        if (game instanceof TronGame tron) this.game = tron;
        assert this.game != null;
        game.addDrawingListener(new MapDrawer());
        game.addGameObject("Player", new Player());
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
            switch (key) {
                case W -> playerVelocity = new Vector(0, -1, 0);
                case S -> playerVelocity = new Vector(0, 1, 0);
                case A -> playerVelocity = new Vector(-1, 0, 0);
                case D -> playerVelocity = new Vector(1, 0, 0);
            }
            Player player = (Player) game.getGameObject("Player");
            player.setVelocity(playerVelocity);
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

    }
}
