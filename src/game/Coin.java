package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * The instance of a coin.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class Coin extends StaticBody implements Collideable {

    /**
     * Creates the shape of the coin.
     */
    private static final Shape shape = new CircleShape(0.4f);
    /**
     * Creates the body of the coin and adds a image to it.
     */
    private static final BodyImage coinImage = new BodyImage("data/coin.gif");
    /**
     * Adds a instance of the character to the coin class.
     */
    private Character1 human;
    /**
     * Adds a instance of the game to the coin class.
     */
    private Game game;
    /**
     * The sound used when the character picks up a coin.
     */
    private SoundClip coinPickup;

    /**
     * When the character picks up a coin the score count increases by 1 and
     * when the character reaches the desired score it can progress to the next
     * level.
     *
     * @param world
     * @param human
     * @param game
     */
    public Coin(World world, Character1 human, Game game) {
        super(world, shape);
        addImage(coinImage);
        this.human = human;
        this.game = game;
    }

    /**
     * Adds collision to the coin by using the collideable class.
     * @param b
     */
    @Override
    public void collisionResponse(Body b) {
        if (b == human) {
            try {
                coinPickup = new SoundClip("data/coinPickup.wav");
                coinPickup.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
            game.increaseScore();
            destroy();
        }
    }
}
