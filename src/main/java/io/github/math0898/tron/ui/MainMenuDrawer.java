package io.github.math0898.tron.ui;

import suga.engine.graphics.DrawListener;
import suga.engine.graphics.GraphicsPanel;

import java.awt.*;

/**
 * The MainMenuDrawer for Tron. Utilized to draw the entire MainMenu options.
 *
 * @author Sugaku
 */
public class MainMenuDrawer implements DrawListener {

    /**
     * Called every drawing frame so programs have a chance to make their voices heard on what gets drawn.
     *
     * @param width  The width of the pixel map.
     * @param height The height of the pixel map.
     * @param panel  The panel to apply changes to.
     */
    @Override
    public void applyChanges (int width, int height, GraphicsPanel panel) {
        panel.setBigPixel(width / 2, height / 2, 25, Color.CYAN);
    }
}
