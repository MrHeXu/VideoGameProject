package game;

import city.cs.engine.*;

/**
 * Creates the robot monster used in the game.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class RobotMonster extends Walker implements Collideable {

    /**
     * The shape of the robot.
     */
    private static final Shape robotShape = new PolygonShape(-0.391f, 0.667f, -0.296f, -0.552f, 0.31f, -0.556f, 0.397f, 0.663f);
    /**
     * The image that the robot has.
     */
    private static final BodyImage image = new BodyImage("data/robot.png", 2.0f);
    /**
     * An instance of the game.
     */
    private Game game;
    /**
     * An instance of the character.
     */
    private Character1 human;

    /**
     * Sets the parameters of the robot.
     *
     * @param world
     * @param human
     * @param game
     */
    public RobotMonster(World world, Character1 human, Game game) {
        super(world, robotShape);
        addImage(image);
        this.game = game;
        this.human = human;
        Shape robotLegs = new PolygonShape(-0.253f, -0.562f, -0.431f, -0.99f, 0.455f, -0.99f, 0.283f, -0.559f);
        SolidFixture robotRightLegFixture = new SolidFixture(this, robotLegs);
        Shape robotLeftArm = new PolygonShape(-0.296f, -0.024f, -0.785f, -0.552f, -0.63f, -0.694f, -0.306f, -0.189f);
        SolidFixture robotLeftArmFixture = new SolidFixture(this, robotLeftArm);
        Shape robotRightArm = new PolygonShape(0.31f, -0.024f, 0.774f, -0.559f, 0.653f, -0.69f, 0.31f, -0.189f);
        SolidFixture robotRightArmFixture = new SolidFixture(this, robotRightArm);
    }

    /**
     * Adds collision to the robot monster so it can interact with the
     * character. When the character touches the robot loses 2 lives.
     *
     * @param b
     */
    @Override
    public void collisionResponse(Body b) {
        if (b == human) {
            game.decreaseLives();
            game.decreaseLives();
            destroy();
        }
    }
}
