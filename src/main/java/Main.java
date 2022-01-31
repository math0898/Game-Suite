import pong.PongGame;
import sugaEngine.input.GameKeyListener;
import sugaEngine.input.GameMouseListener;
import sugaEngine.graphics.flat.Graphics2d;
import sugaEngine.threads.GameLogicThread;
import sugaEngine.threads.GraphicsThread;

import javax.swing.*;
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
        panel.setBackground(Color.BLACK);
        JFrame frame = new JFrame("SugaEngine - PONG");
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(size.width, size.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
        new GraphicsThread(panel, 60).start();
        try { // We do this to prevent paintImmediately() from calling draw listeners while they're being added.
              //  It's a non-fatal error but still should be avoided whenever possible.
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new GameLogicThread(new PongGame(panel, new GameKeyListener(frame), new GameMouseListener(frame)), 60).start();
    }
}
