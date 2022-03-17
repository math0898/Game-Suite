package pong.ui;

import sugaEngine.graphics.DrawListener;
import sugaEngine.graphics.GraphicsPanel;
import sugaEngine.physics.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The ScoreCounter draws the current score value to the screen.
 *
 * @author Sugaku
 */
@SuppressWarnings("ClassCanBeRecord")
public class ScoreCounter implements DrawListener {

    /**
     * The counter for the ScoreCounter.
     */
    private final AtomicInteger score;

    /**
     * The position to display this ScoreCounter.
     */
    private final Vector pos;

    /**
     * Creates a new ScoreCounter object with the given score, and centered at the given position.
     *
     * @param score The score that should be displayed by this score counter.
     * @param pos The center position that this score counter should be displayed at.
     */
    public ScoreCounter (AtomicInteger score, Vector pos) {
        this.score = score;
        this.pos = pos;
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
        List<Integer> digits = new ArrayList<>();
        int score = this.score.get();
        digits.add(score % 10);
        score = (int) (score / 10.0);
        while (score > 0) {
            digits.add(score % 10);
            score = (int) (score / 10.0);
        }
        Vector origin = pos.clone();
        for (Integer i : digits) {
            drawDigit(panel, origin, i);
            origin.add(new Vector(-40, 0, 0));
        }
    }

    /**
     * Draws the given digit to the screen, centered on the given position.
     *
     * @param panel The panel to draw the number to.
     * @param origin The origin point to draw the number relative to.
     * @param digit The digit to draw to the screen.
     */
    public void drawDigit (GraphicsPanel panel, Vector origin, int digit) {
        switch (digit) {
            case 0 -> panel.addImage((int) origin.getX(), (int) origin.getY(), 30, 50, "/pong/Number0.png");
            case 1 -> panel.addImage((int) origin.getX(), (int) origin.getY(), 30, 50, "/pong/Number1.png");
            case 2 -> panel.addImage((int) origin.getX(), (int) origin.getY(), 30, 50, "/pong/Number2.png");
            case 3 -> panel.addImage((int) origin.getX(), (int) origin.getY(), 30, 50, "/pong/Number3.png");
            case 4 -> panel.addImage((int) origin.getX(), (int) origin.getY(), 30, 50, "/pong/Number4.png");
            case 5 -> panel.addImage((int) origin.getX(), (int) origin.getY(), 30, 50, "/pong/Number5.png");
            case 6 -> panel.addImage((int) origin.getX(), (int) origin.getY(), 30, 50, "/pong/Number6.png");
            case 7 -> panel.addImage((int) origin.getX(), (int) origin.getY(), 30, 50, "/pong/Number7.png");
            case 8 -> panel.addImage((int) origin.getX(), (int) origin.getY(), 30, 50, "/pong/Number8.png");
            case 9 -> panel.addImage((int) origin.getX(), (int) origin.getY(), 30, 50, "/pong/Number9.png");
        }
    }
}
