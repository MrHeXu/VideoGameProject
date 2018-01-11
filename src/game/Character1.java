package game;

import city.cs.engine.*;
import static java.lang.Math.random;

/**
 * The character from the game.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class Character1 extends Walker {

    /**
     * The torso shape of the character.
     */
    private static final Shape shape = new PolygonShape(0.11f, 0.6f, -0.46f, 0.48f, -0.23f, -0.52f, 0.33f, -0.45f);
    /**
     * The the static image of the character.
     */
    private static final BodyImage image = new BodyImage("data/characterLeftStatic.gif", 5.0f);
    /**
     * Keeps track of the score count.
     */
    private int scoreCount;

    /**
     * Initialises the game character.
     *
     * @param world
     */
    public Character1(World world) {
        super(world, shape);
        addImage(image);
        scoreCount = 0;

        /**
         * Creates the left leg.
         */
        Shape leftLeg = new PolygonShape(-0.26f, -0.65f, -0.55f, -1.62f, -0.26f, -1.69f, -0.02f, -0.73f);
        SolidFixture leftLegFixture = new SolidFixture(this, leftLeg);
        leftLegFixture.setFriction(150);
        /**
         * Creates the right leg.
         */
        Shape rightLeg = new PolygonShape(-0.02f, -0.73f, 0.2f, -1.77f, 0.48f, -1.7f, 0.23f, -0.69f);
        SolidFixture rightLegFixture = new SolidFixture(this, rightLeg);
        rightLegFixture.setFriction(150);
        /**
         * Creates the head.
         */
        Shape head = new PolygonShape(-0.35f, 0.55f, 0.11f, 0.6f, 0.0f, 1.31f, -0.53f, 1.22f);
        SolidFixture headFixture = new SolidFixture(this, head);
        /**
         * Creates the left hand.
         */
        Shape leftHand = new PolygonShape(-0.42f, 0.29f, -0.75f, -0.02f, -0.59f, -0.16f, -0.29f, 0.09f);
        SolidFixture leftHandFixture = new SolidFixture(this, leftHand);
        /**
         * Creates the right hand.
         */
        Shape rightHand = new PolygonShape(0.2f, 0.49f, 0.68f, 0.24f, 0.22f, -0.4f);
        SolidFixture rightHandFixture = new SolidFixture(this, rightHand);
    }

}
