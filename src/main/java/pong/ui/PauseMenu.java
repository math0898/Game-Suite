package pong.ui;

import pong.PongGame;
import sugaEngine.graphics.flat.DrawListener;
import sugaEngine.graphics.flat.Graphics2d;
import sugaEngine.input.GameMouseListener;

import java.awt.*;

/**
 * The PauseMenu is used by players to restart the game, exit pong, return to main menu, or to resume the game. Should
 * support mouse clicks and buttons should change on hover.
 *
 * @author Sugaku
 */
public class PauseMenu implements DrawListener { // todo add changing highlighted based on arrow keys. Add triggers to clicks and enter.

    /**
     * The mouse listener being used to highlight active elements of the PauseMenu and get when the player clicks on an
     * element.
     */
    private final GameMouseListener mouseListener;

    /**
     * The currently highlighted element of the pause menu.
     */
    private MenuOptions highlighted = MenuOptions.CONTINUE;

    /**
     * The mouse position last time it was checked.
     */
    private Point lastPos = new Point(0,0);

    /**
     * An enum of menu options that can be highlighted.
     *
     * @author Sugaku
     */
    private enum MenuOptions {

        /**
         * The 'continue' option in the pause menu.
         */
        CONTINUE,

        /**
         * The 'restart' option in the pause menu.
         */
        RESTART,

        /**
         * The 'settings' option in the pause menu.
         */
        SETTINGS,

        /**
         * The 'main menu' option in the pause menu.
         */
        MAIN_MENU,

        /**
         * The 'quit' option in the pause menu.
         */
        QUIT
    }

    /**
     * Creates a new PauseMenu instance with the given GameMouseListener.
     *
     * @param mouseListener The mouse listener that will be associated with this PauseMenu.
     */
    public PauseMenu (GameMouseListener mouseListener) {
        this.mouseListener = mouseListener;
    }

    /**
     * Called when trying to determine which pause screen element to highlight.
     *
     * @param height The height of the screen.
     */
    public void checkMouse (int height) {
        height = height / 2;
        Point current = mouseListener.getMousePos();
        if (current == null) return;
        if (current.distance(lastPos) < 20) return;
        lastPos = (Point) current.clone();
        if (lastPos.y <= height - 198) highlighted = MenuOptions.CONTINUE;
        else if (lastPos.y <= height - 78) highlighted = MenuOptions.RESTART;
        else if (lastPos.y <= height + 42) highlighted = MenuOptions.SETTINGS;
        else if (lastPos.y <= height + 162) highlighted = MenuOptions.MAIN_MENU;
        else highlighted = MenuOptions.QUIT;
    }

    /**
     * Called every drawing frame so programs have a chance to make their voices heard on what gets drawn.
     *
     * @param width  The width of the pixel map.
     * @param height The height of the pixel map.
     * @param panel  The panel to apply changes to.
     */
    @Override
    public void applyChanges (int width, int height, Graphics2d panel) {
        if (PongGame.getPaused()) {
            checkMouse(height);
            int dx = 0;
            int y = 0;
            int[] scales = new int[]{ 6, 6, 6, 6, 6};
            switch (highlighted) {
                case CONTINUE -> {
                    dx = (38 * 4) + 20;
                    y = (height / 2) - 258 + 20;
                    scales[0] = 8;
                }
                case RESTART -> {
                    dx = (29 * 4) + 20;
                    y = (height / 2) - 138 + 20;
                    scales[1] = 8;
                }
                case SETTINGS -> {
                    dx = (34 * 4) + 20;
                    y = (height / 2) - 18 + 20;
                    scales[2] = 8;
                }
                case MAIN_MENU -> {
                    dx = (43 * 4) + 20;
                    y = (height / 2) + 102 + 20;
                    scales[3] = 8;
                }
                case QUIT -> {
                    dx = (17 * 4) + 20;
                    y = (height / 2) + 222 + 20;
                    scales[4] = 8;
                }
            }
            for (int dy = -16; dy <= 16; dy += 8) {
                panel.setBigPixel((width / 2) + dx, y + dy, 8, Color.WHITE);
                panel.setBigPixel((width / 2) - dx, y + dy, 8, Color.WHITE);
            }
            panel.addImage((width / 2) - (38 * (scales[0] / 2)), (height / 2) - 258, 38 * scales[0], 5 * scales[0], "/pong/Continue.png");
            panel.addImage((width / 2) - (29 * (scales[1] / 2)), (height / 2) - 138, 29 * scales[1], 5 * scales[1], "/pong/Restart.png");
            panel.addImage((width / 2) - (34 * (scales[2] / 2)), (height / 2) - 18, 34 * scales[2], 5 * scales[2],"/pong/Settings.png");
            panel.addImage((width / 2) - (43 * (scales[3] / 2)), (height / 2) + 102, 43 * scales[3], 5 * scales[3],"/pong/MainMenu.png");
            panel.addImage((width / 2) - (17 * (scales[4] / 2)), (height / 2) + 222, 17 * scales[4], 5 * scales[4],"/pong/Quit.png");
        }
    }
}
