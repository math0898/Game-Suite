package io.github.math0898.loz.ui;

import suga.engine.graphics.DrawListener;
import suga.engine.graphics.GraphicsPanel;

/**
 * The UI and display part of the TitleScreen.
 *
 * @author Sugaku
 */
public class TitleScreenUI implements DrawListener {

    /**
     * Called every drawing frame so programs have a chance to make their voices heard on what gets drawn.
     *
     * @param width The width of the pixel map.
     * @param height The height of the pixel map.
     * @param panel The panel to apply changes to.
     */
    @Override
    public void applyChanges (int width, int height, GraphicsPanel panel) {
        panel.addImage(0, 0, 512, 512, "/loz/TitleScreenSplash.png");
    }
}
