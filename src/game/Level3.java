/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Level 2 of the game.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class Level3 extends GameLevel {

    /**
     * This is the score that the player has to reach for him to go to the next
     * level through the portal.
     */
    private static final int NUM_SCORE = 24;
    /**
     * An instance of the game.
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
        Shape platformShape = new BoxShape(5, 0.5f);
        Shape spikePlatform = new BoxShape(2.5f, 0.5f);
        Shape angledPlatform = new BoxShape(4, 0.5f);
        Shape platformShape2 = new BoxShape(1 , 0.5f);
        Body platform50 = new StaticBody(this,platformShape2);
        platform50.setPosition(new Vec2(20,-3));
        Body platform51 = new StaticBody(this,platformShape2);
        platform51.setPosition(new Vec2(-26,4.5f));
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-4.5f, -6));
        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(5.5f, -6));
        Body platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(-21.5f, -6));
        Body platform4 = new StaticBody(this, platformShape);
        platform4.setPosition(new Vec2(-21.5f, 1));
        Body platform5 = new StaticBody(this, platformShape);
        platform5.setPosition(new Vec2(-11.5f, 1));
        Body platform6 = new StaticBody(this, platformShape);
        platform6.setPosition(new Vec2(-1.5f, 1));
        Body platform7 = new StaticBody(this, platformShape);
        platform7.setPosition(new Vec2(8.5f, 1));
        Body platform8 = new StaticBody(this, platformShape);
        platform8.setPosition(new Vec2(15.5f, -6));
        Body platform9 = new StaticBody(this, platformShape);
        platform9.setPosition(new Vec2(15.5f, 9));
        Body platform10 = new StaticBody(this, platformShape);
        platform10.setPosition(new Vec2(5.5f, 9));
        Body platform11 = new StaticBody(this, platformShape);
        platform11.setPosition(new Vec2(-4.5f, 9));
        Body platform12 = new StaticBody(this, platformShape);
        platform12.setPosition(new Vec2(-14.5f, 9));
        Body platform13 = new StaticBody(this, platformShape);
        platform13.setPosition(new Vec2(15.5f, 17));
        Body platform14 = new StaticBody(this, platformShape);
        platform14.setPosition(new Vec2(5.5f, 17));
        Body platform15 = new StaticBody(this, platformShape);
        platform15.setPosition(new Vec2(-4.5f, 17));
        Body platform16 = new StaticBody(this, platformShape);
        platform16.setPosition(new Vec2(-14.5f, 17));
        Body platform17 = new StaticBody(this, platformShape);
        platform17.setPosition(new Vec2(-21.5f, 17));
        Body spikePlatform2 = new StaticBody(this, spikePlatform);
        spikePlatform2.setPosition(new Vec2(13.5f, 1));
        Body angledPlatform4 = new StaticBody(this, angledPlatform);
        angledPlatform4.setPosition(new Vec2(21, -2.5f));
        angledPlatform4.setAngleDegrees(90);
        Body angledPlatform1 = new StaticBody(this, angledPlatform);
        angledPlatform1.setPosition(new Vec2(-10, -9.5f));
        angledPlatform1.setAngleDegrees(90);
        Body spikePlatform1 = new StaticBody(this, spikePlatform);
        spikePlatform1.setPosition(new Vec2(-13, -13));
        Body spikePlatform3 = new StaticBody(this, spikePlatform);
        spikePlatform3.setPosition(new Vec2(-19.5f, 9));
        Body angledPlatform2 = new StaticBody(this, angledPlatform);
        angledPlatform2.setPosition(new Vec2(-16, -9.5f));
        angledPlatform2.setAngleDegrees(90);
        Body angledPlatform3 = new StaticBody(this, angledPlatform);
        angledPlatform3.setPosition(new Vec2(-27, -2.5f));
        angledPlatform3.setAngleDegrees(90);
        Body angledPlatform5 = new StaticBody(this, angledPlatform);
        angledPlatform5.setPosition(new Vec2(-27, 5.5f));
        angledPlatform5.setAngleDegrees(90);
        Body angledPlatform8 = new StaticBody(this, angledPlatform);
        angledPlatform8.setPosition(new Vec2(-27, 13.5f));
        angledPlatform8.setAngleDegrees(90);
        Body angledPlatform6 = new StaticBody(this, angledPlatform);
        angledPlatform6.setPosition(new Vec2(21, 5.5f));
        angledPlatform6.setAngleDegrees(90);
        Body angledPlatform7 = new StaticBody(this, angledPlatform);
        angledPlatform7.setPosition(new Vec2(21, 13.5f));
        angledPlatform7.setAngleDegrees(90);
        Spikes spikes = new Spikes(this, human, game);
        spikes.setPosition(new Vec2(-11.9f, -11.1f));
        spikes.addCollisionListener(new Pickup(getPlayer()));
        Spikes spikes2 = new Spikes(this, human, game);
        spikes2.setPosition(new Vec2(-14.1f, -11.1f));
        spikes2.addCollisionListener(new Pickup(getPlayer()));
        RobotMonster rMonster1 = new RobotMonster(this, human, game);
        rMonster1.setPosition(new Vec2(-19, -5));
        rMonster1.addCollisionListener(new Pickup(getPlayer()));
        RandomHeart rHeart1 = new RandomHeart(this, human, game);
        rHeart1.setPosition(new Vec2(-26, -5));
        rHeart1.addCollisionListener(new Pickup(getPlayer()));
        GoldCoin gCoin1 = new GoldCoin(this, human, game);
        gCoin1.setPosition(new Vec2(0, 2));
        gCoin1.addCollisionListener(new Pickup(getPlayer()));
        Coin coin2 = new Coin(this, human, game);
        coin2.setPosition(new Vec2(0, 0));
        coin2.addCollisionListener(new Pickup(getPlayer()));
        for (int i = 0; i < 6; i++) { // creates multiple coins 
            Body coin1 = new Coin(this, human, game); // creates a coin
            coin1.setPosition(new Vec2(-25 + i, -5)); // sets the position of the coins
            coin1.addCollisionListener(new Pickup(getPlayer())); // adds collision to the coins
        }
        for (int i = 0; i < 2; i++) { // creates multiple coins 
            Body coin3 = new Coin(this, human, game); // creates a coin
            coin3.setPosition(new Vec2(3 + i, -5)); // sets the position of the coins
            coin3.addCollisionListener(new Pickup(getPlayer())); // adds collision to the coins
        }
        GasMonster gas1 = new GasMonster(this, human, game);
        gas1.setPosition(new Vec2(0, -5));
        gas1.addCollisionListener(new Pickup(getPlayer()));
        GasMonster gas2 = new GasMonster(this, human, game);
        gas2.setPosition(new Vec2(7, -5));
        gas2.addCollisionListener(new Pickup(getPlayer()));
        RobotMonster r1 = new RobotMonster(this, human, game);
        r1.setPosition(new Vec2(-5, 2));
        r1.addCollisionListener(new Pickup(getPlayer()));
        RobotMonster r2 = new RobotMonster(this, human, game);
        r2.setPosition(new Vec2(4, 2));
        r2.addCollisionListener(new Pickup(getPlayer()));
    }

    /**
     * This method sets the start position of the player for level 3.
     *
     * @return the stars position of the player.
     */
    @Override
    public Vec2 startPosition() {
        return new Vec2(-6, -4);
    }

    /**
     * This method sets the portal position for level 3.
     *
     * @return the portal position.
     */
    @Override
    public Vec2 portalPosition() {
        return new Vec2(19, 11);
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
