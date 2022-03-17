package sugaEngine.physics;

import sugaEngine.graphics.Graphics2d;
import sugaEngine.graphics.GraphicsPanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Every collidable object needs a HitBox. This is a box where if a test point overlaps with a box then a collision
 * occurs.
 *
 * @author Sugaku
 */
public abstract class HitBox {

    /**
     * The current position of the game object.
     */
    protected Vector pos;

    /**
     * The width of the HitBox.
     */
    protected final double width;

    /**
     * The height of the HitBox.
     */
    protected final double height;

    /**
     * Creates a new HitBox with the given relative sizes in the horizontal and vertical directions.
     *
     * @param width The width of the HitBox.
     * @param height The height of the HitBox.
     */
    public HitBox (double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Accessor method for the height of this HitBox.
     *
     * @return The height value of this HitBox.
     */
    public double getHeight () {
        return height;
    }

    /**
     * Accessor method for the width of this HitBox.
     *
     * @return The width value of this HitBox.
     */
    public double getWidth () {
        return width;
    }

    /**
     * Tests whether the given point is within this HitBox or not.
     *
     * @param test The point to test. Represented in vector form.
     * @return True if and only if the test point is inside this HitBox.
     */
    public boolean isInside (Vector test) {
        if (test.getX() > pos.getX() - (width / 2.0) && test.getX() < pos.getX() + (width / 2.0))
            return test.getY() > pos.getY() - (height / 2.0) && test.getY() < pos.getY() + (height / 2.0);
        return false;
    }

    /**
     * Tests whether the given point is touching this HitBox or not.
     *
     * @param test The point to test. Represented in vector form.
     * @return True if and only if the test point is on the boundary of this HitBox.
     */
    public boolean touching (Vector test) {
        if (test.getX() >= pos.getX() - (width / 2.0) && test.getX() <= pos.getX() + (width / 2.0))
            return test.getY() >= pos.getY() - (height / 2.0) && test.getY() <= pos.getY() + (height / 2.0);
        return false;
    }

    /**
     * Returns a collection of test points to determine if this HitBox is colliding with another.
     *
     * @return A list of test points to look for collisions at.
     */
    public Collection<Vector> getTestPoints () {
        List<Vector> vectors = new ArrayList<>();
        vectors.add(new Vector(pos.getX() + (width / 2.0), pos.getY() + (height / 2.0), pos.getZ()));
        vectors.add(new Vector(pos.getX() + (width / 2.0), pos.getY() - (height / 2.0), pos.getZ()));
        vectors.add(new Vector(pos.getX() - (width / 2.0), pos.getY() + (height / 2.0), pos.getZ()));
        vectors.add(new Vector(pos.getX() - (width / 2.0), pos.getY() - (height / 2.0), pos.getZ()));
        return  vectors;
    }

    /**
     * Accessor method for the position of the HitBox.
     *
     * @return Returns the current position of this HitBox.
     */
    public Vector getPos () {
        return pos;
    }

    /**
     * Draws the test points for this HitBox on the given 2dGraphics panel.
     *
     * @param panel The panel to draw the HitBox test points to.
     * @param color The color to draw the test points as.
     */
    public void drawHitBox (GraphicsPanel panel, Color color) {
        int y = (int) (pos.getY() + (height / 2.0));
        int x = (int) (pos.getX() - (width / 2.0));
        for (int i = x; i <= (int) (pos.getX() + (width / 2.0)); i++) panel.setPixel(i, y, color);
        for (int i = (int) (pos.getY() - (height / 2.0)); i <= y; i++) panel.setPixel(x, i, color);
        y = (int) (pos.getY() - (height / 2.0));
        x = (int) (pos.getX() + (width / 2.0));
        for (int i = (int) (pos.getX() - (width / 2.0)); i <= x; i++) panel.setPixel(i, y, color);
        for (int i = y; i <= (int) (pos.getY() + (height / 2.0)); i++) panel.setPixel(x, i, color);
    }
}
