package game;

import city.cs.engine.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 * Level 1 of the game.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class Level1 extends GameLevel {

    /**
     * This is the score that the player has to reach for him to go to the next
     * level through the portal.
     */
    private static final int NUM_SCORE = 4;

    /**
     * Populate the world.
     *
     * @param game
     */
    @Override
    public void populate(Game game) {
        super.populate(game);
        // make the ground
        Shape groundShape = new BoxShape(11, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));
        ground.setFillColor(new Color(139, 69, 17));
        // walls
        Shape leftWallShape = new BoxShape(999, 20, new Vec2(-1010, 20));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(999, 20, new Vec2(1010, 20.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);

        // make platforms
        Shape boxShapeBig = new BoxShape(4, 0.5f);
        Shape boxShapeSmall = new BoxShape(3, 0.5f);
        Body platform1 = new StaticBody(this, boxShapeSmall);
        platform1.setPosition(new Vec2(8, 2));
        Body platform2 = new StaticBody(this, boxShapeBig);
        platform2.setPosition(new Vec2(0, -2.5f));
        Body platform3 = new StaticBody(this, boxShapeBig);
        platform3.setPosition(new Vec2(-7, -7));
        Body platform4 = new StaticBody(this, boxShapeBig);
        platform4.setPosition(new Vec2(7, -7));
        Body platform5 = new StaticBody(this, boxShapeBig);
        platform5.setPosition(new Vec2(0, 6.5f));
        Body platform6 = new StaticBody(this, boxShapeSmall);
        platform6.setPosition(new Vec2(-8, 11));

        // make grass
        Body grass = new Grass(this);
        grass.setPosition(new Vec2(0, -10.7f));
        Body grass1 = new Grass(this);
        grass1.setPosition(new Vec2(-7, -10.7f));
        Body grass2 = new Grass(this);
        grass2.setPosition(new Vec2(7, -10.7f));

        // make hearts
        Body heart = new Heart(this, human, game); // creates a heart
        heart.setPosition(new Vec2(10, -6)); // sets the position of the heart
        heart.addCollisionListener(new Pickup(getPlayer())); // adds collision to the heart
        // make coins
        for (int i = 0; i < 4; i++) { // creates multiple coins 
            Body coin = new Coin(this, human, game); // creates a coin
            coin.setPosition(new Vec2(-3 + i * 2, -1.5f)); // sets the position of the coins
            coin.addCollisionListener(new Pickup(getPlayer())); // adds collision to the coins
        }

        //make Monster Robot
        RobotMonster monster1 = new RobotMonster(this, human, game);
        monster1.setPosition(new Vec2(-6, 1.5f));
        monster1.addCollisionListener(new Pickup(getPlayer()));
        RobotMonster monster2 = new RobotMonster(this, human, game);
        monster2.setPosition(new Vec2(-8, 1.5f));
        monster2.addCollisionListener(new Pickup(getPlayer()));
    }

    /**
     * This method sets the start position of the player for level 1.
     *
     * @return the stars position of the player.
     */
    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
    }

    /**
     * This method sets the portal position for level 1.
     *
     * @return the portal position.
     */
    @Override
    public Vec2 portalPosition() {
        return new Vec2(-9.5f, 13);
    }

    /**
     * This method checks if the level is completed or not.
     *
     * @param game
     * @return the level is completed when the player reaches the desired score.
     */
    @Override
    public boolean isCompleted(Game game) {
        return game.getScoreCount() >= NUM_SCORE;
    }
}
