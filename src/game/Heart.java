/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Creates the heart used in game that increases the lives of the player.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class Heart extends StaticBody implements Collideable {

    /**
     * The shape used for the heart.
     */
    private static final Shape heart = new PolygonShape(0.457f, 0.45f, -0.469f, 0.426f, -0.545f, 0.071f, -0.002f, -0.486f, 0.545f, 0.076f);
    /**
     * The image of the heart.
     */
    private static final BodyImage heartImage = new BodyImage("data/heart.gif");
    /**
     * An instance of the character for collision purposes.
     */
    private Character1 human;
    /**
     * An instance of the game.
     */
    private Game game;

    /**
     * Sets the parameters of the heart.
     *
     * @param w
     * @param human
     * @param game
     */
    public Heart(World w, Character1 human, Game game) {
        super(w, heart);
        addImage(heartImage);
        this.human = human;
        this.game = game;
    }

    /**
     * Adds collision to the hearts so it can interact with the character wich
     * each time he picks a hearts it increases the lives by one.
     *
     * @param b
     */
    @Override
    public void collisionResponse(Body b) {
        if (b == human) {
            game.increaseLives();
            destroy();
        }
    }
}
