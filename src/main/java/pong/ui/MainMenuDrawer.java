package pong.ui;

import sugaEngine.Game;
import sugaEngine.graphics.DrawListener;
import sugaEngine.graphics.GraphicsPanel;
import sugaEngine.input.GameMouseListener;
import sugaEngine.input.KeyValues;
import sugaEngine.threads.SugaThread;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * The MainMenuDrawer handles the drawing of the main menu elements such as title, start, settings, and quit buttons.
 *
 * @author Sugaku
 */
public class MainMenuDrawer implements DrawListener {

    /**
     * The currently highlighted menu option.
     */
    private MenuOptions current = MenuOptions.START;

    /**
     * A point which represents the last time the mouse position was read.
     */
    private Point lastPos = new Point(0, 0);

    /**
     * The mouse listener being used to highlight active elements of the MainMenu and get when the player clicks on an
     * element.
     */
    private final GameMouseListener mouseListener;

    /**
     * The title image as a BufferedImage, so it can remain in RAM.
     */
    private final BufferedImage title;

    /**
     * The start image as a BufferedImage, so it can remain in RAM.
     */
    private final BufferedImage start;

    /**
     * The settings image as a BufferedImage, so it can remain in RAM.
     */
    private final BufferedImage settings;

    /**
     * The quit image as a BufferedImage, so it can remain in RAM.
     */
    private final BufferedImage quit;

    /**
     * An enum of menu options that can be highlighted.
     *
     * @author Sugaku
     */
    private enum MenuOptions {

        /**
         * The 'start' option in the main menu.
         */
        START,

        /**
         * The 'settings' option in the main menu.
         */
        SETTINGS,

        /**
         * The 'quit' option in the main menu.
         */
        QUIT
    }

    /**
     * Creates a new MainMenuDrawer by loading the needed images from jar resources.
     *
     * @param listener The GameMouseListener being used by the game so that we know where the mouse's position.
     */
    public MainMenuDrawer (GameMouseListener listener) throws IOException {
        mouseListener = listener;
        InputStream stream = this.getClass().getResourceAsStream("/pong/Title.png");
        if (stream != null) title = ImageIO.read(stream);
        else throw new IOException("Failed to access /pong/Title.png resource!");
        stream = this.getClass().getResourceAsStream("/pong/Start.png");
        if (stream != null) start = ImageIO.read(stream);
        else throw new IOException("Failed to access /pong/Start.png resource!");
        stream = this.getClass().getResourceAsStream("/pong/Settings.png");
        if (stream != null) settings = ImageIO.read(stream);
        else throw new IOException("Failed to access /pong/Settings.png resource!");
        stream = this.getClass().getResourceAsStream("/pong/Quit.png");
        if (stream != null) quit = ImageIO.read(stream);
        else throw new IOException("Failed to access /pong/Quit.png resource!");
    }

    /**
     * Called by the scene whenever enter or click is called.
     *
     * @param game Sometimes scenes need to be loaded from this method. Hence, the need to pass the game instance.
     */
    public void enter (Game game) {
        SugaThread thread = game.getThread();
        switch (current) {
            case START -> {
                System.out.println("Attempted to load!");
                game.loadScene("Main Game");
                thread.setPaused(false);
            }
            case SETTINGS -> game.loadScene("Settings");
            case QUIT -> thread.setStopped(true); // TODO: Stop graphics thread.
        }
    }

    /**
     * Moves the currently highlighted menu option up or down depending on the value given.
     *
     * @param input The key that was pressed to move the menu selection.
     */
    public void move (KeyValues input) {
        if (input == KeyValues.ARROW_DOWN) {
            switch (current) {
                case QUIT -> current = MenuOptions.START;
                case START -> current = MenuOptions.SETTINGS;
                case SETTINGS -> current = MenuOptions.QUIT;
            }
        } else if (input == KeyValues.ARROW_UP) {
            switch (current) {
                case START -> current = MenuOptions.QUIT;
                case SETTINGS -> current = MenuOptions.START;
                case QUIT -> current = MenuOptions.SETTINGS;
            }
        }
    }

    /**
     * Called when trying to determine which main menu element to highlight.
     */
    public void checkMouse () {
        Point current = mouseListener.getMousePos(); // 450 600 750
        if (current == null) return;
        if (current.distance(lastPos) < 20) return;
        lastPos = (Point) current.clone();
        if (lastPos.y <= 525) this.current = MenuOptions.START;
        else if (lastPos.y <= 675) this.current = MenuOptions.SETTINGS;
        else this.current = MenuOptions.QUIT;
    }

    /**
     * Called every drawing frame so programs have a chance to make their voices heard on what gets drawn.
     *
     * @param width  The width of the pixel map.
     * @param height The height of the pixel map.
     * @param panel  The panel to apply changes to.
     */
    @Override
    public void applyChanges (int width, int height, GraphicsPanel panel) { // todo change pixel sizes to be dynamic to screen, implement menu stuffs.
        checkMouse();
        int dx;
        int offset = 0;
        int y = 0;
        int[] scales = new int[]{ 5, 5, 5 };
        switch (current) {
            case START -> {
                offset = 21 * 8;
                y = 450 + 20;
                scales[0] = 8;
            }
            case SETTINGS -> {
                offset = 34 * 8;
                y = 600 + 20;
                scales[1] = 8;
            }
            case QUIT -> {
                offset = 17 * 8;
                y = 750 + 20;
                scales[2] = 8;
            }
        }
        dx = offset + 40;
        for (int dy = -16; dy <= 56; dy += 8) {
            panel.setBigPixel((width / 10) + dx + offset, y + dy, 16, Color.WHITE);
            panel.setBigPixel((width / 10) - dx + offset, y + dy, 16, Color.WHITE);
        }
        panel.addImage(width / 10, 50, 400, 100, title);
        panel.addImage(width / 10, 450, 42 * scales[0], 10 * scales[0], start);
        panel.addImage(width / 10, 600, 68 * scales[1], 10 * scales[1], settings);
        panel.addImage(width / 10, 750, 34 *  scales[2], 10 * scales[2], quit);
    }
}
