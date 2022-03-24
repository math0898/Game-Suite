//package animus;
//
//import sugaEngine.Game;
//import sugaEngine.graphics.DrawListener;
//import sugaEngine.graphics.GraphicsPanel;
//
//import java.awt.*;
//
///**
// * The Game UI for the Project Animus game.
// *
// * @author Sugaku
// */
//public record GameUI (Game game) implements DrawListener {
//
//    /**
//     * Called every drawing frame so programs have a chance to make their voices heard on what gets drawn.
//     *
//     * @param width  The width of the pixel map.
//     * @param height The height of the pixel map.
//     * @param panel  The panel to apply changes to.
//     */
//    @Override
//    public void applyChanges(int width, int height, GraphicsPanel panel) {
//        if (game.getThread().getPaused()) {
//            panel.setRectangle((width / 2) - 200, (height / 2) - 50, 400, 100, Color.DARK_GRAY);
//            panel.setRectangle((width / 2) - 190, (height / 2) - 40, 380, 80, Color.DARK_GRAY.brighter());
//        }
//    }
//}
