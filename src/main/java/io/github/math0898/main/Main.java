package io.github.math0898.main;

import io.github.math0898.pong.PongGame;
import suga.engine.GameEngine;
import suga.engine.graphics.Graphics2d;
import suga.engine.graphics.GraphicsPanel;
import suga.engine.input.keyboard.StackGameKeyListener;
import suga.engine.input.mouse.BasicMouseListener;
import suga.engine.logger.Level;

import java.awt.*;

/**
 * Main execution class for testing the Graphics Library.
 *
 * @author Sugaku
 */
public class Main extends GameEngine {

    /**
     * Runs the testing program for the graphics engine.
     *
     * @param args The arguments given to the java program.
     */
    public static void main (String[] args) {
        GameEngine.getLogger().setLevel(Level.DEBUG);
        GraphicsPanel panel = new Graphics2d();
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        PongGame game = new PongGame();
        GameEngine.launchGameWindow(size.width, size.height, "SugaEngine - PONG", false,
                panel, Color.BLACK, 60, 60, new StackGameKeyListener(), new BasicMouseListener(), game);
        game.loadScene("Main Menu");
    }
}
