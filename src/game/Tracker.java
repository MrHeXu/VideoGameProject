package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Pan the view to follow a particular body, in this case the character.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class Tracker implements StepListener {

    /**
     * The view
     */
    private WorldView view;

    /**
     * The body
     */
    private Body body;

    /**
     * Sets the parameters of the tracker.
     *
     * @param view
     * @param body
     */
    public Tracker(WorldView view, Body body) {
        this.view = view;
        this.body = body;
    }

    /**
     *
     * @param e
     */
    @Override
    public void preStep(StepEvent e) {
    }

    /**
     * Keeps the camera on the player.F
     * @param e
     */
    @Override
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(body.getPosition()));
    }

}
