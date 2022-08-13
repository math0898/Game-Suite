package io.github.math0898.pong.ai;

import suga.engine.game.objects.AIAgent;
import suga.engine.game.objects.GameObject;

/**
 * Wobbly boi.
 *
 * @author Sugaku
 */
public class PaddleAgent implements AIAgent {

    /**
     * The ball in the PongGame.
     */
    protected GameObject ball;

    /**
     * Creates a new AIAgent with control over the given object.
     *
     * @param object The GameObject that this AIAgent has control over.
     * @param ball The ball that's in the same game as the PaddleAgent.
     */
    public PaddleAgent (GameObject object, GameObject ball) {
//        super(object);
//        this.ball = ball;
    }

    /**
     * Runs the logic of the AIAgent.
     */
    @Override
    public void runLogic () {
//        if (object.getPos().getY() > ball.getPos().getY() - 20) object.getAccel().setY(-1 * Paddle.PADDLE_ACCELERATION);
//        else if (object.getPos().getY() < ball.getPos().getY() + 20) object.getAccel().setY(Paddle.PADDLE_ACCELERATION);
    }
}
