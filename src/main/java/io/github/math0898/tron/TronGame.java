package io.github.math0898.tron;

import io.github.math0898.tron.scenes.MainMenu;
import suga.engine.game.BasicGame;

/**
 * Creates a new TronGame instance.
 *
 * @author Sugaku
 */
public class TronGame extends BasicGame {

    /**
     * Creates a new TronGame.
     */
    public TronGame () {
        scenes.put("Title Screen", new MainMenu());
    }
}
