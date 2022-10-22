package io.github.math0898.main;

import io.github.math0898.loz.LOZGame;
import io.github.math0898.pong.PongGame;
import suga.engine.game.Game;

/**
 * Factory to provide the games created in the GameSuite.
 *
 * @author Sugaku
 */
public class GameFactory {

    /**
     * Creates the appropriate game and returns it.
     *
     * @param target The target game to return.
     */
    public Game createGame (String target) {
        return switch (target) {
            case "LOZ" -> new LOZGame();
            case "PONG" -> new PongGame();
            default -> null;
        };
    }
}
