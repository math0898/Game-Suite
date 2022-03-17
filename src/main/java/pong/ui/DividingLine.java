package pong.ui;

import sugaEngine.Game;
import sugaEngine.graphics.DrawListener;
import sugaEngine.graphics.GraphicsPanel;

import java.awt.*;

/**
 * The DividingLine class's job is simply to draw the dividing line seen in the center of pong games.
 *
 * @author Sugaku
 */
public class DividingLine implements DrawListener {

    /**
     * Reference to the run time instance of game this listener is working for.
     */
    private final Game game;

    /**
     * Creates a new DividingLine Drawer which requires access to the PongGame instance for pause screen color changes.
     *
     * @param game The game this DrawListener is attached to.
     */
    public DividingLine (Game game) {
        super();
        this.game = game;
    }

    /**
     * Called every drawing frame so programs have a chance to make their voices heard on what gets drawn.
     *
     * @param width  The width of the pixel map.
     * @param height The height of the pixel map.
     * @param panel  The panel to apply changes to.
     */
    @Override
    public void applyChanges (int width, int height, GraphicsPanel panel) {
        Color c = game.getThread().getPaused() ? Color.DARK_GRAY : Color.WHITE;
        for (int y = 10; y < height; y += 20)
            panel.setBigPixel(width / 2, y, 5, c);
    }
}
