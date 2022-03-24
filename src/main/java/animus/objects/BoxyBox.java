//package animus.objects;
//
//import sugaEngine.GameObject;
//import sugaEngine.graphics.GraphicsPanel;
//import sugaEngine.physics.HitBox;
//import sugaEngine.physics.Vector;
//
//import java.awt.*;
//
//public class BoxyBox extends GameObject {
//
//    /**
//     * The color of this cube.
//     */
//    private final Color color;
//
//    /**
//     * Creates a new Collidable object with the immutable property set to either true or false.
//     *
//     * @param pos       The position of the object.
//     * @param width     The width of the HitBox.
//     * @param height    The height of the HitBox.
//     * @param color     The color of the box.
//     */
//    public BoxyBox (Vector pos, double width, double height, Color color) {
//        super(false, width, height);
//        this.pos = pos;
//        this.color = color;
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
//        panel.setRectangle((int) pos.getX() - (int) (this.width / 2), (int) pos.getY() - (int) (this.height / 2), (int) this.width, (int) this.height, color);
//    }
//
//    /**
//     * Runs collision logic. Should not modify the object passed.
//     *
//     * @param obj The object that this collidable collided with.
//     */
//    @Override
//    public void collision (HitBox obj) {
//        obj.getPos().setY((pos.getY() - (this.height / 2)) - (obj.getHeight() / 2));
//    }
//
//    /**
//     * Runs touching logic. May modify the object passed.
//     *
//     * @param obj The object that this collidable is touching.
//     */
//    @Override
//    public void touch (HitBox obj) {
//
//    }
//
//    /**
//     * Returns the name of this object for use during collisions.
//     *
//     * @return The name of this object.
//     */
//    @Override
//    public String getName() {
//        return "Box";
//    }
//}
