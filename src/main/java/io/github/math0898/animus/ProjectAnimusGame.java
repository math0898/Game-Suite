//package io.github.math0898.animus;
//
//import io.github.math0898.animus.objects.BoxyBox;
//import io.github.math0898.animus.objects.FloatyCube;
//import io.github.math0898.animus.objects.PlayerCharacter;
//import sugaEngine.Game;
//import sugaEngine.input.GameKeyListener;
//import sugaEngine.input.GameMouseListener;
//import sugaEngine.sound.SoundManager;
//import sugaEngine.physics.Vector;
//import sugaEngine.graphics.GraphicsPanel;
//import sugaEngine.threads.GameLogicThread;
//
//import javax.sound.sampled.LineUnavailableException;
//import java.awt.*;
//import java.awt.event.MouseEvent;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
///**
// * Main execution point for the io.github.math0898.animus game including aspects such as the GameLoop.
// *
// * @author Sugaku
// */
//public class ProjectAnimusGame extends Game {
//
//    /**
//     * These are keys that are currently being held. That can be useful information in it of itself but this is used to
//     * ignore future key pressed messages.
//     */
//    List<Integer> pressedKeys = new ArrayList<>();
//
//    /**
//     * The music player for the ProjectAnimusGame.
//     */
//    SoundManager soundManager = new SoundManager();
//
//    /**
//     * Creates a new game with the given panel used to register GameObjects as draw listeners to.
//     *
//     * @param panel The panel that GameObjects should register as a listener to.
//     * @param listener The game key listener being used by this game object.
//     * @param mouseListener The mouse listener being using by this game object.
//     */
//    public ProjectAnimusGame (GraphicsPanel panel, GameKeyListener listener, GameMouseListener mouseListener) {
//        super(panel, listener, mouseListener);
////        soundManager = new SoundManager("/media/music/Itro & Tobu - Cloud 9.wav");
//        soundManager.play("/media/music/Itro & Tobu - Cloud 9.wav");
//        panel.registerListener(new GameUI(this));
//        addGameObject("Floaty Cube", new FloatyCube());
//        addGameObject("Boxy Box", new BoxyBox(new Vector(540, 100, 0), 50, 50, Color.GREEN.darker().darker().darker()));
//        addGameObject("Floor", new BoxyBox(new Vector(960, 1080, 0), 1920, 60, Color.decode("#99cfe0")));
//        addGameObject("Player Character", new PlayerCharacter());
//    }
//
//    /**
//     * The io.github.math0898.main logic loop for the game. Will be called depending on the rate of the logic thread.
//     */
//    @Override
//    public void loop () {
//        super.loop();
//    }
//
//    /**
//     * Processes inputs given by players. Is run during pause.
//     */
//    @Override
//    public void processInput () {
//        Stack<MouseEvent> mice = mouseListener.getEvents();
//        while (mice.size() > 0) mice.pop();
//        Stack<Integer> keys = keyListener.getKeysPressed();
//        while (keys.size() > 0) {
//            int key = keys.pop();
//            if (pressedKeys.contains(key)) continue;
//            else pressedKeys.add(key);
//            switch (key) {
//                case 27 -> { // ESC
//                    boolean paused = thread.getPaused();
////                    if (paused) soundManager.setVolume(1.0f);
////                    else soundManager.setVolume(-0.5f);
//                    thread.setPaused(!paused);
//                }
//                case 40 -> objects.get("Floaty Cube").getAccel().add(new Vector(0, 0.1, 0)); // UP ARROW
//                case 39 -> objects.get("Floaty Cube").getAccel().add(new Vector(0.1, 0, 0)); // RIGHT ARROW
//                case 37 -> objects.get("Floaty Cube").getAccel().add(new Vector(-0.1, 0, 0)); // LEFT ARROW
//                case 38 -> objects.get("Floaty Cube").getAccel().add(new Vector(0, -0.1, 0)); // DOWN ARROW
//                case 65 -> objects.get("Player Character").getAccel().add(new Vector(-0.1, 0, 0)); // A
//                case 68 -> objects.get("Player Character").getAccel().add(new Vector(0.1, 0, 0)); // D
//                case 87 -> ((PlayerCharacter) objects.get("Player Character")).jump(); // W
//                case 76 -> {
//                    System.out.println("Accel => " + objects.get("Player Character").getAccel().toString());
//                    System.out.println("Vel => " + objects.get("Player Character").getVelocity().toString());
//                    System.out.println("Pos => " + objects.get("Player Character").getPos().toString());
//                }
//            }
//        }
//        keys = keyListener.getKeysDepressed();
//        while (keys.size() > 0) {
//            int key = keys.pop();
//            pressedKeys.remove((Integer) key); // Remove Object not Index
//            switch (key) {
//                case 40 -> objects.get("Floaty Cube").getAccel().add(new Vector(0, -0.1, 0)); // UP ARROW
//                case 39 -> objects.get("Floaty Cube").getAccel().add(new Vector(-0.1, 0, 0)); // RIGHT ARROW
//                case 37 -> objects.get("Floaty Cube").getAccel().add(new Vector(0.1, 0, 0)); // LEFT ARROW
//                case 38 -> objects.get("Floaty Cube").getAccel().add(new Vector(0, 0.1, 0)); // DOWN ARROW
//                case 65 -> objects.get("Player Character").getAccel().add(new Vector(0.1, 0, 0)); // A
//                case 68 -> objects.get("Player Character").getAccel().add(new Vector(-0.1, 0, 0)); // D
//            }
//        }
//    }
//}
