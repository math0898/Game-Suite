package io.github.math0898.launcher;

import suga.engine.GameEngine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;

/**
 * Creates a new LaunchGameButton based on the parameters given by calling methods.
 *
 * @author Sugaku
 */
public class LaunchGameButtonBuilder {

    /**
     * The image to display on the created JButton.
     */
    private ImageIcon img = null;

    /**
     * The first argument to pass to the startGame method.
     */
    private String arg = "";

    /**
     * Sets the frame that this button will be attached to.
     */
    private JFrame frame;

    /**
     * Creates a default LaunchGameButtonBuilder.
     */
    public LaunchGameButtonBuilder () {

    }

    /**
     * Adds the image at the given location to this LaunchGameButtonBuilder.
     *
     * @param path The path to grab the image at.
     */
    public void addIcon (String path) {
        URL url = getClass().getResource(path);
        if (url == null) return;
        try {
            img = new ImageIcon(ImageIO.read(url));
        } catch (IOException e) {
            GameEngine.getLogger().log(e);
        }
    }

    /**
     * Sets the first argument to pass to the startGame method.
     *
     * @param arg The first argument to pass to the startGame method.
     */
    public void setArgument (String arg) {
        this.arg = arg;
    }

    /**
     * Sets the JFrame that the resulting button will be attached to.
     *
     * @param frame The JFrame that the resulting button will be attached to.
     */
    public void setJFrame (JFrame frame) {
        this.frame = frame;
    }

    /**
     * Creates and returns the resulting JButton.
     *
     * @return The JButton which results from the current values.
     */
    public JButton createButton () {
        JButton button = new JButton("", img);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setContentAreaFilled(true);
        final String a = arg;
        button.addActionListener((e) -> {
            GameLauncher.startGame(new String[]{ a }); // todo This feels funny to me.
            GameEngine.getLogger().log("Launcher: Hiding game launcher.");
            frame.setVisible(false);
        });
        return button;
    }
}
