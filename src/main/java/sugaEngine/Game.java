package sugaEngine;

import sugaEngine.graphics.GraphicsPanel;
import sugaEngine.graphics.DrawListener;
import sugaEngine.input.GameKeyListener;
import sugaEngine.input.GameMouseListener;
import sugaEngine.input.KeyValues;
import sugaEngine.physics.PhysicsEngine;
import sugaEngine.threads.SugaThread;

import java.awt.event.MouseEvent;
import java.util.*;

/**
 * Games require a main game loop to run along with game components that need to be run every game cycle.
 *
 * @author Sugaku
 */
public abstract class Game {

    /**
     * These are keys that are currently being held. That can be useful information in it of itself but this is used to
     * ignore future key pressed messages.
     */
    protected List<Integer> pressedKeys = new ArrayList<>();

    /**
     * A list of game objects for this game. Their logic should be called every cycle.
     */
    protected Map<String, GameObject> objects = new HashMap<>();

    /**
     * The physics engine that will be used with this game.
     */
    protected PhysicsEngine physics = new PhysicsEngine();

    /**
     * A list of AIAgents that should have their logic run every cycle.
     */
    protected List<AIAgent> agents = new ArrayList<>();

    /**
     * A Map of scenes indexed by name.
     */
    protected Map<String, Scene> scenes = new HashMap<>();

    /**
     * The currently loaded scene object.
     */
    protected Scene loadedScene;

    /**
     * The graphics panel that should be used to register draw listeners to.
     */
    protected GraphicsPanel panel;

    /**
     * The key listener that is being used by this game.
     */
    protected GameKeyListener keyListener;

    /**
     * The mouse listener that is being used by this game.
     */
    protected GameMouseListener mouseListener;

    /**
     * The thread that is currently running this Game. May be null in some cases.
     */
    protected SugaThread thread = null;

    /**
     * Creates a new game with the given panel used to register GameObjects as draw listeners to.
     *
     * @param panel The panel that GameObjects should register as a listener to.
     * @param listener The game key listener being used by this game object.
     * @param mouseListener The mouse listener being using by this game object.
     */
    public Game (GraphicsPanel panel, GameKeyListener listener, GameMouseListener mouseListener) {
        this.panel = panel;
        keyListener = listener;
        this.mouseListener = mouseListener;
    }

    /**
     * Sets the thread that is calling loop() on this Game.
     *
     * @param thread The thread that will be calling loop() on this object.
     */
    public final void setThread (SugaThread thread) {
        this.thread = thread;
    }

    /**
     * Accessor method for the thread that is calling loop(). This can be used to determine whether the game has stopped
     * or paused.
     *
     * @return The thread that is running this game instance.
     */
    public final SugaThread getThread () {
        return thread;
    }

    /**
     * The main logic loop for the game. Will be called depending on the rate of the logic thread.
     */
    public void loop () {
        physics.checkCollisions();
        for (AIAgent a : agents) a.logic();
        for (GameObject gO : objects.values()) gO.runLogic();
    }

    /**
     * Processes inputs given by players. Is run during pause.
     */
    public void processInput () {
        Stack<MouseEvent> mice = mouseListener.getEvents();
        while (mice.size() > 0) {
            MouseEvent e = mice.pop();
            loadedScene.mouseInput(e.getPoint(), e.getButton() == 1);
        }
        Stack<Integer> keys = keyListener.getKeysPressed();
        while (keys.size() > 0) {
            int key = keys.pop();
            if (pressedKeys.contains(key)) continue;
            pressedKeys.add(key);
            loadedScene.keyboardInput(KeyValues.toEnum(key), true);
        }
        keys = keyListener.getKeysDepressed();
        while (keys.size() > 0) {
            int key = keys.pop();
            pressedKeys.remove((Integer) key);
            loadedScene.keyboardInput(KeyValues.toEnum(key), false);
        }
    }

    /**
     * Adds a GameObject by the given name.
     *
     * @param name The name of the game object. Can be used later to remove the item.
     * @param object The game object to add.
     */
    public void addGameObject (String name, GameObject object) {
        objects.put(name, object);
        panel.registerListener(object);
        physics.addObject(object);
    }

    /**
     * Accessor method for game objects.
     *
     * @param name The name of the object to attempt to get.
     * @return The found object or null.
     */
    public GameObject getGameObject (String name) {
        return objects.get(name);
    }

    /**
     * Registers a new AI agent so that it can be called every tick after collisions but before object logic.
     *
     * @param agent The AIAgent to add into the list of agents.
     */
    public void addAgent (AIAgent agent) {
        agents.add(agent);
    }

    /**
     * Registers a new DrawingListener. This will not register anything beyond the draw method. Usually used by UI,
     * hence the name.
     *
     * @param listener The draw listener that should be registered to this panel.
     */
    public void addDrawingListener (DrawListener listener) {
        panel.registerListener(listener);
    }

    /**
     * Clears all AIAgents, physics managers, GameObjects, and PanelListeners.
     */
    public void clear () {
        physics = new PhysicsEngine();
        agents = new ArrayList<>();
        objects = new HashMap<>();
        panel.clearListeners();
    }

    /**
     * Attempts to load the given scene. If successful with return true, if un-found or loading fails, will return
     * false.
     *
     * @param name The name of the scene to attempt loading.
     */
    public boolean loadScene (String name) {
        Scene scene = scenes.get(name);
        if (scene == null) return false;
        if (scene.load(this)) {
            loadedScene = scene;
            return true;
        }
        return false;
    }

    /**
     * Accessor method for the graphics panel used by the server.
     *
     * @return The panel used by the server.
     */
    public GraphicsPanel getPanel () {
        return panel;
    }

    /**
     * Accessor method for the mouse listener used by the server.
     *
     * @return The mouse listener used by the server.
     */
    public GameMouseListener getMouseListener () {
        return mouseListener;
    }
}
