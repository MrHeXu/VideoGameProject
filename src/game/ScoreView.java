package game;

import java.awt.Graphics2D;
import city.cs.engine.*;

/**
 * Keeps track of the score in the view ( UI ) .
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class ScoreView extends UserView {

    /**
     * An instance of the game class.
     */
    private Game game;

    /**
     * Sets the parameters of the score view .
     *
     * @param world
     * @param game
     * @param width
     * @param height
     */
    public ScoreView(World world, Game game, int width, int height) {
        super(world, width, height);
        this.game = game;
    }

    /**
     * Keeps track of the score in the top right corner of the screen.
     *
     * @param g
     */
    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawString("Score: " + game.getScoreCount(), 10, 10);
    }
}
