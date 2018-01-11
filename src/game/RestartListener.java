package game;

import city.cs.engine.*;

/**
 * Creates the listener for the restart button.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class RestartListener implements CollisionListener {
    /**
     * An instance of the game class.
     */
    private Game game;

    /**
     * Sets the parameters of the restart button.
     * @param game
     */
    public RestartListener(Game game) {
        this.game = game;
    }

    /**
     * 
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        Character1 player = game.getPlayer();
        if (e.getOtherBody() == player) {
            System.out.println("Going to next level...");
            game.ifYouDie();
        }
    }
}
