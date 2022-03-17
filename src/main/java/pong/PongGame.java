package pong;

import pong.scenes.MainGame;
import pong.scenes.MainMenu;
import sugaEngine.AIAgent;
import sugaEngine.Game;
import sugaEngine.GameObject;
import sugaEngine.input.GameKeyListener;
import sugaEngine.input.GameMouseListener;
import sugaEngine.graphics.GraphicsPanel;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Main game class for the Pong game.
 *
 * @author Sugaku
 */
public class PongGame extends Game {

    /**
     * The player score counter.
     */
    private AtomicInteger playerScore = new AtomicInteger(0);

    /**
     * The AI score counter.
     */
    private AtomicInteger aiScore = new AtomicInteger(0);

    /**
     * Whether the game pong is currently in dev mode or not.
     */
    private static boolean devMode = false;

    /**
     * Creates a new game with the given panel used to register GameObjects as draw listeners to.
     *
     * @param panel The panel that GameObjects should register as a listener to.
     * @param listener The game key listener being used by this game object.
     * @param mouseListener The mouse listener being using by this game object.
     */
    public PongGame (GraphicsPanel panel, GameKeyListener listener, GameMouseListener mouseListener) {
        super(panel, listener, mouseListener);
        scenes.put("Main Game", new MainGame());
        scenes.put("Main Menu", new MainMenu());
        loadScene("Main Menu");
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
     * The main logic loop for the game. Will be called depending on the rate of the logic thread.
     */
    @Override
    public void loop () {
        physics.checkCollisions();
        for (AIAgent a : agents) a.logic();
        for (GameObject gO : objects.values()) gO.runLogic();
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
        double posY = new Random().nextDouble() * (panel.getHeight() / 4.0);
        double velY = new Random().nextBoolean() ? 6.0 : -6.0;
        if (velY < 0) posY += panel.getHeight() / 2.0;
        GameObject ball = objects.get("Ball");
        if (ball == null) return;
        ball.getPos().setY(posY);
        ball.getPos().setX(panel.getWidth() / 2.0);
        ball.getVelocity().setY(velY);
        ball.getVelocity().setX(target.equals("AI") ? -6.0 : 6.0);
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
