package sugaEngine.threads;

import sugaEngine.graphics.GraphicsPanel;

import java.awt.event.WindowEvent;

import static main.Main.frame;

/**
 * A thread used to refresh the graphics of a panel as fast as possible.
 *
 * @author Sugaku
 */
public class GraphicsThread extends SugaThread {

    /**
     * The panel that should be redrawn every frame.
     */
    private final GraphicsPanel panel;

    /**
     * The time that this graphics thread was started. Used in calculating average frame rate.
     */
    private static long startTime = 0;

    /**
     * The number of frames that have been rendered since the thread started.
     */
    private static long frames = 0;

    /**
     * The target frame rate for this GraphicsThread.
     */
    private final int FRAME_RATE;

    /**
     * Creates a new graphics thread with the given panel.
     *
     * @param panel The panel to refresh for every frame.
     */
    public GraphicsThread (GraphicsPanel panel, int frameRate) {
        this.panel = panel;
        FRAME_RATE = frameRate;
        panel.setThread(this);
    }

    /**
     * Called to run the Graphics thread.
     */
    @Override
    public void run () {
        startTime = System.currentTimeMillis();
        long lastFinished = 0;
        while (!stopped) {
            long drawTime = System.currentTimeMillis() - lastFinished;
            if (drawTime < (1000 / FRAME_RATE)) {
                try {
                    //noinspection BusyWait
                    Thread.sleep((int) ((1000 / FRAME_RATE) - drawTime));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            lastFinished = System.currentTimeMillis();
            if (!paused) panel.repaint();
            frames++;
        }
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    /**
     * Returns the average frame rate while this GraphicsThread has been running.
     *
     * @return The average frame rate of this thread since starting.
     */
    public static double getFPS () {
        return (frames * 1.0) / ((System.currentTimeMillis() - startTime) / 1000.0);
    }
}
