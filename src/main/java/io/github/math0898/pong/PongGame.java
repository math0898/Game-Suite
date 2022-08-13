package io.github.math0898.pong;

import io.github.math0898.pong.scenes.MainGame;
import io.github.math0898.pong.scenes.MainMenu;
import suga.engine.game.BasicGame;
import suga.engine.game.objects.GameObject;
import suga.engine.graphics.GraphicsPanel;
import suga.engine.physics.Physical;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Main game class for the Pong game.
 *
 * @author Sugaku
 */
public class PongGame extends BasicGame {

    /**
     * The player score counter.
     */
    private AtomicInteger playerScore = new AtomicInteger(0);

    /**
     * The AI score counter.
     */
    private AtomicInteger aiScore = new AtomicInteger(0);

    /**
     * Whether the game io.github.math0898.pong is currently in dev mode or not.
     */
    private static boolean devMode = false;

    /**
     * Creates a new PongGame. Relies on setters for the GraphicsPanel and input listeners.
     */
    public PongGame () {
        super();
        scenes.put("Main Game", new MainGame());
        scenes.put("Main Menu", new MainMenu());
//        loadScene("Main Menu");
    }

    /**
     * Accessor method for the atomic int used for the player's score.
     *
     * @return The atomic integer used for player scoring.
     */
    public AtomicInteger getPlayerScorer () {
        return playerScore;
    }

    /**
     * Accessor method for the atomic int used for the AI's score.
     *
     * @return The atomic integer used for AI scoring.
     */
    public AtomicInteger getAiScorer () {
        return aiScore;
    }

    /**
     * Clears all AIAgents, physics managers, GameObjects, and PanelListeners.
     */
    @Override
    public void clear () {
        super.clear();
        playerScore = new AtomicInteger(0);
        aiScore = new AtomicInteger(0);
    }

    /**
     * Adds to the given player's score.
     *
     * @param target The player that gets 1 added to their score.
     */
    public void addScore (String target) {
        if (target.equals("AI")) aiScore.incrementAndGet();
        else if (target.equals("Player")) playerScore.incrementAndGet();
    }

    /**
     * Serves the pong ball towards the given player.
     *
     * @param target The player that is 'serving' the ball.
     */
    public void serve (String target) {
        double posY = new Random().nextDouble() * ((GraphicsPanel) panel).getHeight() / 4.0;
        double velY = new Random().nextBoolean() ? 6.0 : -6.0;
        if (velY < 0) posY += ((GraphicsPanel) panel).getHeight() / 2.0;
        GameObject ball = objects.get("Ball");
        if (ball == null) return;
        ((Physical) ball).getPos().setY(posY);
        ((Physical) ball).getPos().setX(((GraphicsPanel) panel).getWidth() / 2.0);
        ((Physical) ball).getVelocity().setY(velY);
        ((Physical) ball).getVelocity().setX(target.equals("AI") ? -6.0 : 6.0);
    }

    /**
     * Returns whether this PongGame is in dev mode or not.
     *
     * @return True if Pong is in dev mode. Otherwise, false.
     */
    public static boolean getDevMode () {
        return devMode;
    }

    /**
     * Sets the value of dev mode to the given value.
     *
     * @param dev The new value for whether the game is in dev mode or not.
     */
    public static void setDevMode (boolean dev) {
        devMode = dev;
    }
}
