package io.github.math0898.main;

import suga.engine.GameEngine;
import suga.engine.game.Game;
import suga.engine.graphics.Graphics2d;
import suga.engine.graphics.GraphicsPanel;
import suga.engine.input.keyboard.StackGameKeyListener;
import suga.engine.input.mouse.BasicMouseListener;
import suga.engine.logger.Level;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

/**
 * Main execution class for the Game Suite.
 *
 * @author Sugaku
 */
public class Main {

    /**
     * Runs a game included in the sweet depending on arguments.
     *
     * @param args The arguments given to the game.
     */
    public static void startGame (String[] args) {
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

    /**
     * Main execution point for Game Suite. Starts a basic game launcher to display options.
     *
     * @param args The arguments given to the java program.
     */
    public static void main (String[] args) throws IOException {
        GameEngine.getLogger().log("Launcher: Starting game launcher...");
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(480, 395);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Game Suite Launcher");
        JButton loz = new JButton("", new ImageIcon(ImageIO.read(Main.class.getResource("/loz/Poster.png"))));
        loz.setBorder(BorderFactory.createEmptyBorder());
        loz.setContentAreaFilled(true);
        loz.addActionListener((e) -> {
            startGame(new String[]{ "LOZ" });
            GameEngine.getLogger().log("Launcher: Hiding game launcher.");
            frame.setVisible(false);
        });
        JButton pong = new JButton("" , new ImageIcon(ImageIO.read(Main.class.getResource("/pong/Poster.png"))));
        pong.addActionListener((e) -> {
            startGame(new String[]{ "PONG" });
            GameEngine.getLogger().log("Launcher: Hiding game launcher.");
            frame.setVisible(false);
        });
        pong.setBorder(BorderFactory.createEmptyBorder());
        pong.setContentAreaFilled(true);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.insets = new Insets(0, 10, 0, 10);
        panel.add(loz, c);
        c.gridx = 1;
        panel.add(pong, c);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.BLACK);
        panel.setBackground(Color.BLACK);
        frame.add(panel);
        frame.setUndecorated(false);
        frame.setVisible(true);
        GameEngine.getLogger().log("Launcher: Launcher started.");
    }
}
