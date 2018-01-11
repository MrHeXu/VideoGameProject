package game;

import city.cs.engine.*;

/**
 * Portal in a game. When the character collides with a portal, if the current
 * level is complete the game is advanced to the next level.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class Portal extends StaticBody {

    /**
     * The image used for the portal.
     */
    private static final BodyImage portalI = new BodyImage("data/portal.gif", 2.8f);

    /**
     * Sets the parameters of the portal.
     *
     * @param world the world.
     */
    public Portal(World world) {
        super(world, new BoxShape(0.55f, 1.4f));
        addImage(portalI);
    }
}
