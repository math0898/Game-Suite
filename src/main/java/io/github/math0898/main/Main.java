package io.github.math0898.main;

import suga.engine.GameEngine;
import suga.engine.game.Game;
import suga.engine.graphics.Graphics2d;
import suga.engine.graphics.GraphicsPanel;
import suga.engine.input.keyboard.StackGameKeyListener;
import suga.engine.input.mouse.BasicMouseListener;
import suga.engine.logger.Level;

import java.awt.*;
import java.util.Objects;

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
        GameFactory factory = new GameFactory();
        String target = "LOZ";
        if (args.length > 0) target = args[0];
        Game game = factory.createGame(target);
        GameEngine.launchGameWindow(size.width, size.height, "SugaEngine - " + target, false,
                panel, Color.BLACK, 60, 60, new StackGameKeyListener(), new BasicMouseListener(), game);
        game.loadScene(Objects.equals(target, "PONG") ? "Main Menu" : "Title Screen"); // todo: Do games need a start method to call the first scene?
    }
}
