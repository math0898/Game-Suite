package io.github.math0898.pong.scenes;

import io.github.math0898.pong.PongGame;
import io.github.math0898.pong.ai.PaddleAgent;
import io.github.math0898.pong.objects.Ball;
import io.github.math0898.pong.objects.Goal;
import io.github.math0898.pong.objects.Paddle;
import io.github.math0898.pong.objects.Wall;
import io.github.math0898.pong.ui.DividingLine;
import io.github.math0898.pong.ui.PauseMenu;
import io.github.math0898.pong.ui.ScoreCounter;
import suga.engine.GameEngine;
import suga.engine.game.Game;
import suga.engine.game.Scene;
import suga.engine.graphics.Graphics2d;
import suga.engine.input.keyboard.KeyValue;
import suga.engine.logger.Level;
import suga.engine.physics.Physical;
import suga.engine.physics.Vector;
import suga.engine.threads.GraphicsThread;

import java.awt.*;

/**
 * The main game is the game with two paddles, a ball, goals, walls etc.
 *
 * @author Sugaku
 */
public class MainGame implements Scene {

    /**
     * The pause screen instance.
     */
    private PauseMenu pauseScreen;

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
        this.game = game;
        game.clear();
        game.addDrawingListener(new DividingLine(game));
        Graphics2d panel = (Graphics2d) game.getPanel();
        game.addDrawingListener(
                new ScoreCounter(((PongGame) game).getPlayerScorer(), new Vector((panel.getWidth() * 3.0) / 8.0, panel.getHeight() / 32.0, 0)));
        game.addDrawingListener(
                new ScoreCounter(((PongGame) game).getAiScorer(), new Vector((panel.getWidth() * 5.0) / 8.0, panel.getHeight() / 32.0, 0)));
        Paddle aiPaddle = new Paddle(new Vector(panel.getWidth() / 8.0, panel.getHeight() / 2.0, 0), game);
        Ball ball = new Ball(new Vector((panel.getWidth() * 3.0) / 4.0, panel.getHeight() / 2.0, 0), new Vector(-6.0, 0, 0), game);
        game.addGameObject("Ball", ball);
        game.addGameObject("AI Paddle", aiPaddle);
        game.addAgent(new PaddleAgent(aiPaddle, ball));
        game.addGameObject("Player Paddle", new Paddle(new Vector((panel.getWidth() * 7.0) / 8.0, panel.getHeight() / 2.0, 0), game));
        game.addGameObject("Wall1", new Wall(panel.getWidth(), new Vector(panel.getWidth() / 2.0, -50, 0)));
        game.addGameObject("Wall2", new Wall(panel.getWidth(), new Vector(panel.getWidth() / 2.0,  panel.getHeight() + 49, 0)));
        game.addGameObject("Player Goal",
                new Goal(new Vector(((panel.getWidth() * 7.0) / 8.0) + 150, panel.getHeight() / 2.0, 0), panel.getHeight(), (PongGame) game));
        game.addGameObject("AI Goal",
                new Goal(new Vector((panel.getWidth() / 8.0) - 150, panel.getHeight() / 2.0, 0), panel.getHeight(), (PongGame) game));
        pauseScreen = new PauseMenu(game.getMouseListener(), game);
        game.addDrawingListener(pauseScreen);
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
            if (game.getThread().getPaused())
                if (key == KeyValue.ARROW_UP || key == KeyValue.ARROW_DOWN)
                    pauseScreen.move(key);
            switch (key) {
                case L -> {
                    GameEngine.getLogger().log(String.format("Average fps: %.1f", GraphicsThread.getFPS()), Level.DEBUG);
                    ((PongGame) game).reportObjects();
                }
                case I -> PongGame.setDevMode(!PongGame.getDevMode());
                case ARROW_UP -> ((Physical) game.getGameObject("Player Paddle")).getAcceleration().add(new Vector(0, -1 * Paddle.PADDLE_ACCELERATION, 0));
                case ARROW_DOWN -> ((Physical) game.getGameObject("Player Paddle")).getAcceleration().add(new Vector(0, Paddle.PADDLE_ACCELERATION, 0));
            }
        } else { // Depressed key
            if (game.getThread().getPaused())
                if (key == KeyValue.ENTER) pauseScreen.enter(game);
            switch (key) {
                case ESC -> game.getThread().setPaused(!game.getThread().getPaused());
                case ARROW_UP -> ((Physical) game.getGameObject("Player Paddle")).getAcceleration().add(new Vector(0, Paddle.PADDLE_ACCELERATION, 0));
                case ARROW_DOWN -> ((Physical) game.getGameObject("Player Paddle")).getAcceleration().add(new Vector(0, -1 * Paddle.PADDLE_ACCELERATION, 0));
            }
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
            if (game.getThread().getPaused())
                pauseScreen.enter(game);
    }
}
