package io.github.math0898.tron.ui;

import suga.engine.graphics.DrawListener;
import suga.engine.graphics.GraphicsPanel;

import java.awt.*;

/**
 * The MapDrawer is used to display the main map portion of the game.
 *
 * @author Sugaku
 */
public class MapDrawer implements DrawListener {

    /**
     * Called every drawing frame so programs have a chance to make their voices heard on what gets drawn.
     *
     * @param width  The width of the pixel map.
     * @param height The height of the pixel map.
     * @param panel  The panel to apply changes to.
     */
    @Override
    public void applyChanges (int width, int height, GraphicsPanel panel) {
        panel.setBigPixel(width / 3, height / 3, 50, Color.RED);
    }
}
