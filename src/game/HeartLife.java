/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;

/**
 * Hearts used in the GUI as a representation of how many lives the character
 * has.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class HeartLife extends StaticBody {

    /**
     * The image used for the heart.
     */
    private static final BodyImage heartImage = new BodyImage("data/heart.gif");

    /**
     * Sets the parameters of the hearts.
     *
     * @param w
     */
    public HeartLife(World w) {
        super(w);
        Shape heart = new CircleShape(0.1f);
        GhostlyFixture heartFixture = new GhostlyFixture(this, heart);
        addImage(heartImage);
    }
}
