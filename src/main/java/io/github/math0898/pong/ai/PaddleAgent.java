package io.github.math0898.pong.ai;

import io.github.math0898.pong.objects.Ball;
import io.github.math0898.pong.objects.Paddle;
import suga.engine.game.objects.AIAgent;

/**
 * Wobbly boi.
 *
 * @author Sugaku
 */
public class PaddleAgent implements AIAgent {

    /**
     * The ball from the PongGame.
     */
    private final Ball ball;

    /**
     * The paddle this AIAgent has control over.
     */
    private final Paddle paddle;

    /**
     * Creates a new AIAgent with control over the given object.
     *
     * @param paddle The paddle this AI has control over.
     * @param ball   The ball that's in the same game as the PaddleAgent.
     */
    public PaddleAgent (Paddle paddle, Ball ball) {
        this.paddle = paddle;
        this.ball = ball;
    }

    /**
     * Runs the logic of the AIAgent.
     */
    @Override
    public void runLogic () {
        if (paddle.getPos().getY() > ball.getPos().getY() - 20) paddle.getAcceleration().setY(-1 * Paddle.PADDLE_ACCELERATION);
        else if (paddle.getPos().getY() < ball.getPos().getY() + 20) paddle.getAcceleration().setY(Paddle.PADDLE_ACCELERATION);
    }
}
