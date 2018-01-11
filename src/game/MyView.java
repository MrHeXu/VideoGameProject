package game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Extended view of the UI viewed in game.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class MyView extends UserView {

    /**
     * An instance of the character.
     */
    private Character1 human;
    /**
     * An instance of the game.
     */
    private Game game;
    /**
     * An instance of the world.
     */
    private World world;
    /**
     * The image of the hearts displayed on the screen.
     */
    private Image heart;
    /**
     * The image of the background from level 1,2 and 3.
     */
    private Image backgroundLevel1, backgroundLevel2, backgroundLevel3;

    /**
     * Sets the parameters of the view.
     *
     * @param world
     * @param human
     * @param game
     * @param width
     * @param height
     */
    public MyView(World world, Character1 human, Game game, int width, int height) {
        super(world, width, height);
        this.human = human;
        this.game = game;
        this.world = world;
        this.heart = new ImageIcon("data/heart.gif").getImage();
        backgroundLevel1 = new ImageIcon("data/background1.jpg").getImage();
        backgroundLevel2 = new ImageIcon("data/background2.jpg").getImage();
        backgroundLevel3 = new ImageIcon("data/background3.jpg").getImage();
    }

    /**
     * This method sets the background of the game.
     *
     * @param g
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        if (game.getLevel() == 1) {
            g.drawImage(backgroundLevel1, 0, 0, this);
        } else if (game.getLevel() == 2) {
            g.drawImage(backgroundLevel2, 0, 0, this);
        } else if (game.getLevel() == 3) {
            g.drawImage(backgroundLevel3, 0, 0, this);
        }
    }

    /**
     * This method sets the foreground ( UI ) of the game.
     *
     * @param g
     */
    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawString("Score:" + game.getScoreCount(), 430, 10);
        if (game.getLives() == 4) {
            g.drawImage(heart, 10, 5, 30, 30, this);
            g.drawImage(heart, 42, 5, 30, 30, this);
            g.drawImage(heart, 74, 5, 30, 30, this);
            g.drawImage(heart, 106, 5, 30, 30, this);
        } else if (game.getLives() == 3) {
            g.drawImage(heart, 10, 5, 30, 30, this);
            g.drawImage(heart, 42, 5, 30, 30, this);
            g.drawImage(heart, 74, 5, 30, 30, this);
        } else if (game.getLives() == 2) {
            g.drawImage(heart, 10, 5, 30, 30, this);
            g.drawImage(heart, 42, 5, 30, 30, this);
        } else if (game.getLives() == 1) {
            g.drawImage(heart, 10, 5, 30, 30, this);
        }
    }

}
