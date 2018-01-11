/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;

/**
 * Grass texture.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class Grass extends StaticBody {

    /**
     * The image of the grass.
     */
    private static final BodyImage grassImage = new BodyImage("data/grass.png");

    /**
     * Sets the parameters of the grass. The image is attached to a ghostly
     * fixture so the player doesn't interact with it this way it can be used as
     * prop in game.
     *
     * @param w
     */
    public Grass(World w) {
        super(w);
        Shape grass = new CircleShape(0.1f);
        GhostlyFixture grassFixture = new GhostlyFixture(this, grass);
        addImage(grassImage);
    }
}
