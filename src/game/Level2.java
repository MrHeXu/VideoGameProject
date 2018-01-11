package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Level 2 of the game.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class Level2 extends GameLevel {

    /**
     * This is the score that the player has to reach for him to go to the next
     * level through the portal.
     */
    private static final int NUM_SCORE = 12;
    /**
     * An instance of the game class.
     */
    private Game game;

    /**
     * Populate the world.
     *
     * @param game
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Shape groundShape = new BoxShape(100, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));

        // walls
        Shape leftWallShape = new BoxShape(0.5f, 6, new Vec2(-11.5f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 6, new Vec2(39, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);

        // make some platforms
        Shape platformShape = new BoxShape(5, 0.5f);
        Shape anglePlatform = new BoxShape(3.5f, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-7, -6));
        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(13.5f, -6));
        Body platform3 = new StaticBody(this, anglePlatform);
        platform3.setPosition(new Vec2(1, -4));
        platform3.setAngleDegrees(35);
        Body platform4 = new StaticBody(this, anglePlatform);
        platform4.setPosition(new Vec2(5.5f, -4));
        platform4.setAngleDegrees(-35);
        Body platform7 = new StaticBody(this, anglePlatform);
        platform7.setPosition(new Vec2(21.5f, -4));
        platform7.setAngleDegrees(35);
        Body platform8 = new StaticBody(this, anglePlatform);
        platform8.setPosition(new Vec2(26.5f, -4));
        platform8.setAngleDegrees(-35);
        Body platform9 = new StaticBody(this, platformShape);
        platform9.setPosition(new Vec2(34, -6));
        GasMonsterBigger gasMonster1 = new GasMonsterBigger(this, human, game);
        gasMonster1.setPosition(new Vec2(3, -11));
        gasMonster1.addCollisionListener(new Pickup(getPlayer()));
        GasMonsterBigger gasMonster2 = new GasMonsterBigger(this, human, game);
        gasMonster2.setPosition(new Vec2(24, -11));
        gasMonster2.addCollisionListener(new Pickup(getPlayer()));
        for (int i = 0; i < 4; i++) { // creates multiple coins 
            Body coin = new Coin(this, human, game); // creates a coin
            coin.setPosition(new Vec2(10 + i * 2, -10.5f)); // sets the position of the coins
            coin.addCollisionListener(new Pickup(getPlayer())); // adds collision to the coins
        }
        for (int i = 0; i < 3; i++) { // creates multiple coins 
            Body coin = new Coin(this, human, game); // creates a coin
            coin.setPosition(new Vec2(32 + i * 2, -10.5f)); // sets the position of the coins
            coin.addCollisionListener(new Pickup(getPlayer())); // adds collision to the coins
        }
        Body goldCoin = new GoldCoin(this, human, game);
        goldCoin.setPosition(new Vec2(30, -10.5f));
        goldCoin.addCollisionListener(new Pickup(getPlayer()));
    }

    /**
     * This method sets the start position of the player for level 2.
     *
     * @return the stars position of the player.
     */
    @Override
    public Vec2 startPosition() {
        return new Vec2(-10.4f, -9.6f);
    }

    /**
     * This method sets the portal position for level 2.
     *
     * @return the portal position.
     */
    @Override
    public Vec2 portalPosition() {
        return new Vec2(38, -9);
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
