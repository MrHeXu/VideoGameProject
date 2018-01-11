/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Creates a enemy used in the game called gas monster.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class GasMonster extends Walker implements Collideable {

    /**
     * The shape of the gas monster.
     */
    private static final Shape gasMonster = new PolygonShape(-0.077f, 0.714f, -0.952f, -0.167f, -0.137f, -0.871f, 0.747f, -0.648f, 0.865f, -0.149f);
    /**
     * The image that the gas monster has.
     */
    private static final BodyImage gasMonsterImage = new BodyImage("data/gasmonster.gif", 2.0f);
    /**
     * An instance of the character in the gas monster class for the collision.
     */
    private Character1 human;
    /**
     * An instance of the game class.
     */
    private Game game;

    /**
     * Sets the parameters of the gas monster.
     *
     * @param w
     * @param human
     * @param game
     */
    public GasMonster(World w, Character1 human, Game game) {
        super(w, gasMonster);
        addImage(gasMonsterImage);
        this.human = human;
        this.game = game;

    }

    /**
     * Adds collision to the gas monster so it can interact with the character.
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
