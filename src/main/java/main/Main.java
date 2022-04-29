package main;

import pong.PongGame;
import suga.engine.GameEngine;
import suga.engine.graphics.Graphics2d;
import suga.engine.input.keyboard.StackGameKeyListener;
import suga.engine.input.mouse.BasicMouseListener;

import java.awt.*;

/**
 * Main execution class for testing the Graphics Library.
 *
 * @author Sugaku
 */
public class Main {

    /**
     * Runs the testing program for the graphics engine.
     *
     * @param args The arguments given to the java program.
     */
    public static void main (String[] args) {
        Graphics2d panel = new Graphics2d();
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        GameEngine.launchGameWindow(size.width, size.height, "SugaEngine - PONG", false,
                panel, Color.BLACK, 60, 60, new StackGameKeyListener(frame), new BasicMouseListener(frame), new PongGame());
    }
}
