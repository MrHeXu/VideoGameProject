package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Creates the gold coin that increases the score value.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class GoldCoin extends StaticBody implements Collideable {

    /**
     * The shape of the gold coin.
     */
    private static final Shape shape = new CircleShape(0.4f);
    /**
     * The image of the gold coin.
     */
    private static final BodyImage coinImage = new BodyImage("data/goldcoin.gif");
    /**
     * An instance of the character used in the gold coin class for collision
     * purposes.
     */
    private Character1 human;
    /**
     * An instance of the game class.
     */
    private Game game;
    /**
     * The sound used when the character picks up the gold coin.
     */
    private SoundClip goldCoinPickup;

    /**
     * Sets the parameters used in the gold coin class.
     *
     * @param world
     * @param human
     * @param game
     */
    public GoldCoin(World world, Character1 human, Game game) {
        super(world, shape);
        setFillColor(Color.orange);
        addImage(coinImage);
        this.human = human;
        this.game = game;

    }

    /**
     * Adds collision response to the gold coin to interact with the character
     * and to play a sound each time one is picked up.
     *
     * @param b
     */
    @Override
    public void collisionResponse(Body b) {
        if (b == human) {
            try {
                goldCoinPickup = new SoundClip("data/goldCoinPickup.wav");
                goldCoinPickup.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
            game.increaseScoreGold();
            destroy();
        }
    }
}
