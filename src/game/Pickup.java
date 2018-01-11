package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the character to collect things.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class Pickup implements CollisionListener {

    /**
     * An instance of the character.
     */
    private Character1 human;

    /**
     * Sets the parameters of the pickup.
     *
     * @param human
     */
    public Pickup(Character1 human) {
        this.human = human;
    }

    /**
     * Adds the collideable class to be used in the pickup class.
     *
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getReportingBody() instanceof Collideable) {
            Collideable c = (Collideable) e.getReportingBody();
            c.collisionResponse(e.getOtherBody());
        }
    }
}
