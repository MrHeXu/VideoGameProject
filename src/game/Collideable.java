/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Body;

/**
 * This is the collideable interface.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public interface Collideable {

    /**
     * Adds collision response to the class.
     *
     * @param b
     */
    public void collisionResponse(Body b);
}
