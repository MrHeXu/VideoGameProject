/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Creates the spikes used in the third level of the game. If the character
 * touches them it loses 2 lives.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class Spikes extends StaticBody implements Collideable {

    /**
     * The shape of the spikes.
     */
    private static final Shape spikesBase = new PolygonShape(-0.92f, 1.42f, -1.26f, -1.44f, 1.24f, -1.44f, 0.94f, 1.42f);
    /**
     * The image of the spikes.
     */
    private static final BodyImage spikesImage = new BodyImage("data/spikes.png", 3.0f);
    /**
     * An instance of the character in the spikes class used for collision.
     */
    private Character1 human;
    /**
     * An instance of the game class.
     */
    private Game game;

    /**
     * Sets the parameters of the spike class.
     *
     * @param w
     * @param human
     * @param game
     */
    public Spikes(World w, Character1 human, Game game) {
        super(w, spikesBase);
        addImage(spikesImage);
        this.human = human;
        this.game = game;
    }

    /**
     * Adds collision to the spikes so that when the character touches them he
     * loses 2 lives.
     *
     * @param b
     */
    @Override
    public void collisionResponse(Body b) {
        if (b == human) {
            game.decreaseLives();
            game.decreaseLives();
        }
    }
}
