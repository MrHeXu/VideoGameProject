/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * A second version of the gas monster that is bigger.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class GasMonsterBigger extends Walker implements Collideable {

    /**
     * The shape of the bigger gas monster.
     */
    private static final Shape gasMonster = new PolygonShape(-0.11f, 1.05f, -1.32f, -0.02f, -1.32f, -0.56f, -0.16f, -1.28f, 1.23f, -0.85f, 1.24f, -0.22f, 0.21f, 1.02f);
    /**
     * The image that the bigger gas monster has.
     */
    private static final BodyImage gasMonsterImage = new BodyImage("data/gasmonster.gif", 3.0f);
    /**
     * An instance of the character in the gas monster class for the collision.
     */
    private Character1 human;
    /**
     * An instance of the game class.
     */
    private Game game;

    /**
     * Sets the parameters of the bigger gas monster.
     *
     * @param w
     * @param human
     * @param game
     */
    public GasMonsterBigger(World w, Character1 human, Game game) {
        super(w, gasMonster);
        addImage(gasMonsterImage);
        this.human = human;
        this.game = game;

    }

    /**
     * Adds collision to the bigger gas monster so it can interact with the
     * character.
     *
     * @param b
     */
    @Override
    public void collisionResponse(Body b) {
        if (b == human) {
            game.decreaseLives();
            destroy();
        }
    }
}
