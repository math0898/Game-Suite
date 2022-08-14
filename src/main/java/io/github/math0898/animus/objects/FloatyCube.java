//package io.github.math0898.animus.objects;
//
//import sugaEngine.GameObject;
//import sugaEngine.graphics.GraphicsPanel;
//import sugaEngine.physics.HitBox;
//import sugaEngine.physics.Vector;
//
//import java.awt.*;
//
//public class FloatyCube extends GameObject {
//
//    /**
//     * Creates a new FloatyCube game object.
//     */
//    public FloatyCube () {
//        super(false, 20, 20);
//        pos = new Vector(11, 11, 0);
//        velocity = new Vector(-1, -1, 0);
//        accel = new Vector(0,0,0);
//    }
//
//    /**
//     * Called every logic frame to run the logic on this GameObject.
//     */
//    @Override
//    public void runLogic () {
//        if (pos.getX() + 10 >= 1920 || pos.getX() - 10 <= 0) velocity.scale(-1, 1, 1);
//        if (pos.getY() + 10 >= 1080 || pos.getY() - 10 <= 0) velocity.scale(1, -1, 1);
//        super.runLogic();
//    }
//
//    /**
//     * Called every drawing frame so programs have a chance to make their voices heard on what gets drawn.
//     *
//     * @param width  The width of the pixel map.
//     * @param height The height of the pixel map.
//     * @param panel  The panel to apply changes to.
//     */
//    @Override
//    public void applyChanges (int width, int height, GraphicsPanel panel) {
//        for (int i = Math.max(0, (int) pos.getX() - 10); i < Math.min(width, pos.getX() + 10); i++)
//            for (int j = Math.max(0, (int) pos.getY() - 10); j < Math.min(height, pos.getY() + 10); j++)
//                panel.setPixel(i, j, Color.CYAN);
//    }
//
//    /**
//     * Runs collision logic. Should not modify the object passed.
//     *
//     * @param obj The object that this collidable collided with.
//     */
//    @Override
//    public void collision (HitBox obj) {
//        velocity.scale(-1);
//    }
//
//    /**
//     * Runs touching logic. May modify the object passed.
//     *
//     * @param obj The object that this collidable is touching.
//     */
//    @Override
//    public void touch (HitBox obj) {
//        velocity.scale(-1);
//    }
//
//    /**
//     * Returns the name of this object for use during collisions.
//     *
//     * @return The name of this object.
//     */
//    @Override
//    public String getName() {
//        return "Floaty Cube";
//    }
//}
