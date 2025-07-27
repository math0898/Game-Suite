package io.github.math0898.tron;

import io.github.math0898.main.Main;
import io.github.math0898.tron.input.MappedStackGameKeyListener;
import io.github.math0898.tron.scenes.MainGame;
import io.github.math0898.tron.scenes.MainMenu;
import suga.engine.GameEngine;
import suga.engine.game.BasicGame;
import suga.engine.input.keyboard.KeyValue;
import suga.engine.input.keyboard.StackGameKeyListener;
import suga.engine.physics.PhysicsEngine;

import javax.swing.*;

/**
 * Creates a new TronGame instance.
 *
 * @author Sugaku
 */
public class TronGame extends BasicGame {

    /**
     * Creates a new TronGame.
     */
    public TronGame () {
        scenes.put("Title Screen", new MainMenu());
        scenes.put("Main Game", new MainGame());
    }

    /**
     * Attempts to load the given scene. If successful with return true, if un-found or loading fails, will return
     * false.
     *
     * @param name The name of the scene to attempt loading.
     */
    @Override
    public boolean loadScene (String name) {
        if (name.equalsIgnoreCase("Title Screen")) {
            keyListener = new MappedStackGameKeyListener();
            keyListener.getKeyMapping().set(KeyValue.W.getValue(), KeyValue.ARROW_UP);
            keyListener.getKeyMapping().set(KeyValue.S.getValue(), KeyValue.ARROW_DOWN);
            keyListener.getKeyMapping().set(KeyValue.D.getValue(), KeyValue.ARROW_RIGHT);
            keyListener.getKeyMapping().set(KeyValue.A.getValue(), KeyValue.ARROW_LEFT);
            Main.registerKeyListener(keyListener);
        }
        clear();
        return super.loadScene(name);
    }

    /**
     * Accessor method for this game's physics engine.
     *
     * @return This games physics engine.
     */
    public PhysicsEngine getPhysics () {
        return physics;
    }
}
