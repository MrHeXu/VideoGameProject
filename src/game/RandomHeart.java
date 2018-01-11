/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Creates the random heart. This heart either give the player 2 lives or takes
 * 1 ( is a 50/50 chance ) .
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class RandomHeart extends StaticBody implements Collideable {

    /**
     * The shape of the heart.
     */
    private static final Shape randomHeart = new PolygonShape(0.457f, 0.45f, -0.469f, 0.426f, -0.545f, 0.071f, -0.002f, -0.486f, 0.545f, 0.076f);
    /**
     * The image that the heart has.
     */
    private static final BodyImage randomHeartImage = new BodyImage("data/randomheart.gif", 3.0f);
    /**
     * An instance of the character.
     */
    private Character1 human;
    /**
     * An instance of the game.
     */
    private Game game;

    /**
     * Sets the parameters of the random heart.
     *
     * @param w
     * @param human
     * @param game
     */
    public RandomHeart(World w, Character1 human, Game game) {
        super(w, randomHeart);
        addImage(randomHeartImage);
        this.human = human;
        this.game = game;
    }

    /**
     * Adds collision to the heart to interact with the character.
     *
     * @param b
     */
    @Override
    public void collisionResponse(Body b) {
        if (b == human) {
            game.randomLives();
            destroy();
        }
    }
}
