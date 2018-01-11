package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * The initial version of the game level.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public abstract class GameLevel extends World {

    /**
     * Creates an instance of the character.
     */
    Character1 human;
    /**
     * Creates an instance of the game.
     */
    Game game;

    /**
     * This method returns the character used in the game.
     *
     * @return the character used in the game.
     */
    public Character1 getPlayer() {
        return human;
    }

    /**
     * This method returns the game instance.
     *
     * @return the game.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Populate the world of this level. Child classes should use this method
     * with additional bodies to initiate a new game level.
     *
     * @param game
     */
    public void populate(Game game) {
        human = new Character1(this);
        human.setPosition(startPosition());
        Portal portal = new Portal(this);
        portal.setPosition(portalPosition());
        portal.addCollisionListener(new PortalListener(game));
    }

    /**
     * The initial position of the player.
     *
     * @return the start position of the player.
     */
    public abstract Vec2 startPosition();

    /**
     * The position of the exit portal.
     *
     * @return the position of the portal used in the respective level.
     */
    public abstract Vec2 portalPosition();

    /**
     * Is this level complete?
     *
     * @param game
     * @return either that the game is completed or not.
     */
    public abstract boolean isCompleted(Game game);
}
