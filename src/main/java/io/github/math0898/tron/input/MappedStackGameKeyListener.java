package io.github.math0898.tron.input;

import suga.engine.input.keyboard.StackGameKeyListener;

import java.awt.event.KeyEvent;

/**
 * An implementation of StackGameKeyListener that also utilizes the KeyMapper.
 *
 * @author Sugaku
 */
public class MappedStackGameKeyListener extends StackGameKeyListener {

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyTyped (KeyEvent e) {
        e.setKeyCode(mapper.convert(e.getKeyCode()).getValue());
        super.keyTyped(e);
    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyPressed (KeyEvent e) {
        e.setKeyCode(mapper.convert(e.getKeyCode()).getValue());
        super.keyPressed(e);
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyReleased (KeyEvent e) {
        e.setKeyCode(mapper.convert(e.getKeyCode()).getValue());
        super.keyReleased(e);
    }
}
