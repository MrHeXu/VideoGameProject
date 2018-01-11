package game;

import city.cs.engine.*;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

import javax.swing.JFrame;

/**
 * Initialises the game.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel world;
    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private UserView view;
    /**
     * The level at wich the user is in.
     */
    private int level;
    /**
     * A counter that keeps track of the player score.
     */
    private int scoreCount;
    /**
     * A counter that keeps track of the player lives.
     */
    private int lives;
    /**
     * A instance of the game.
     */
    private Game game;
    /**
     * A sound clip that is used for the first level of the game ( background
     * music ) .
     */
    private SoundClip gameMusic1;
    /**
     * A sound clip that is used for the second and the third level of the game
     * ( background music ) .
     */
    private SoundClip gameMusic2;
    /**
     * A sound clip used when the random heart gives you lives.
     */
    private SoundClip winLives;
    /**
     * A sound clip used when the random heart takes 1 life from you.
     */
    private SoundClip loseLives;
    /**
     * Instance of the controlled used to control the player.
     */
    private Controller controller;

    /**
     * Initialise a new Game.
     */
    public Game() {
        // make the world
        level = 1;
        lives = 3;
        world = new Level1();
        world.populate(this);
        world.setGravity(20);
        // make a view
        view = new MyView(world, world.getPlayer(), this, 500, 500);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);
        // display the view in a frame
        JFrame frame = new JFrame("Multi-level game");
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        GuiPannel colorPanel = new GuiPannel(view, this, world);
        frame.add(colorPanel, BorderLayout.SOUTH);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // debug viewer
        JFrame debugView = new DebugViewer(world, 500, 500);
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
        world.addStepListener(new Tracker(view, world.getPlayer()));
        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);
        try {
            gameMusic1 = new SoundClip("data/beatMusic.wav");
            gameMusic1.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        // start!
        world.start();
    }

    /**
     * The player in the current level.
     *
     * @return the player from the current level.
     */
    public Character1 getPlayer() {
        return world.getPlayer();
    }

    /**
     * Is the current level of the game finished?
     *
     * @return the isCompleted method. This checks if the level is completed or
     * not.
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted(this);
    }

    /**
     * Advance to the next levels of the game level 2 or level 3.
     */
    public void goNextLevel() {
        world.stop();
        if (level == 2) {
            gameMusic1.stop();
            level++;          
            // get a new world
            JFrame frame = new JFrame("Multi-level game");
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            world.setGravity(20);
            GuiPannel colorPanel = new GuiPannel(view, this, world);
            frame.add(colorPanel, BorderLayout.SOUTH);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            world.addStepListener(new Tracker(view, world.getPlayer()));
            world.start();
        } else if (level == 1) {
            gameMusic1.stop();
            try {
                gameMusic2 = new SoundClip("data/beatMusic2.wav");
                gameMusic2.loop();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
            level++;
            // get a new world
            world = new Level2();
            JFrame frame = new JFrame("Multi-level game");
            // fill it with bodies
            world.populate(this);
            world.setGravity(20);
            GuiPannel colorPanel = new GuiPannel(view, this, world);
            frame.add(colorPanel, BorderLayout.SOUTH);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            world.addStepListener(new Tracker(view, world.getPlayer()));
            world.start();
        } else if (level == 3) {
            System.exit(0);
        }
    }

    /**
     * Run the game.
     *
     * @param args
     */
    public static void main(String[] args) {
        new Game();
    }

    /**
     * This method increases the number of lives the player has each time is
     * called and keeps the lives at 3.
     */
    public void increaseLives() {
        lives++;
        if (lives == 4) {
            lives--;
        }
        System.out.println("Your total life is = " + lives);
    }

    /**
     * Decrease the number of lives the player has each time is called.
     */
    public void decreaseLives() {
        lives--;
        if (lives <= 0) {
            game.ifYouDie();
        }
        System.out.println("Your total life is = " + lives);
    }

    /**
     * This method returns the number of lives the player has.
     * <p>
     * You can use this method when you need to know the number of lives the
     * player has.
     * </p>
     *
     * @return The method returns the number of lives the character has.
     */
    public int getLives() {
        return lives;
    }

    /**
     * The method is suppose to restart the level that the character is in but i
     * didn't get it to work.
     */
    public void ifYouDie() {
        world.stop();
        if (level == 1) {
            // get a new world
            world = new Level1();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            world.setGravity(20);
            world.addStepListener(new Tracker(view, world.getPlayer()));
            world.start();
        } else if (level == 2) {
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            world.setGravity(20);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            world.addStepListener(new Tracker(view, world.getPlayer()));
            world.start();
        } else if (level == 3) {
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            world.setGravity(20);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            world.addStepListener(new Tracker(view, world.getPlayer()));
            world.start();
        }
    }

    /**
     * This is a feature of the new heart. Each time the player picks up this
     * heart there is a 50/50 chance of either receiving 2 hearts or losing 1
     * heart. Also this is the only way of the player to have more that 3 hearts
     * allowing him to have a maximum of 4 hearts.
     */
    public void randomLives() {
        if ((float) (Math.random() * 10 + 1) < 5) {
            lives = lives + 2;
            try {
                winLives = new SoundClip("data/winSound.wav");
                winLives.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
            if (lives >= 5) {
                lives--;
            }
            System.out.println("Your total life is = " + lives);
        } else {
            lives--;
            try {
                loseLives = new SoundClip("data/loseSound.wav");
                loseLives.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
            System.out.println("Your total life is = " + lives);
            if (lives <= 0) {
                game.ifYouDie();
            }
        }
    }

    /**
     * This method returns the score count of the player.
     *
     * @return the score count of the player.
     */
    public int getScoreCount() {
        return scoreCount;
    }

    /**
     * This method returns the level that the player is currently at.
     *
     * @return the level that the game is in.
     */
    public int getLevel() {
        return level;
    }

    /**
     * This method sets the level of the game.
     */
    public int setLevel(int level) {
        this.level = level;
        return level;
    }

    /**
     * This method sets the score count of the player to the new one.
     *
     * @param scoreCount
     * @return the score count of the player.
     */
    public int setScore(int scoreCount) {
        this.scoreCount = scoreCount;
        return scoreCount;
    }

    /**
     * This method increases the score by one each time is called.
     */
    public void increaseScore() {
        scoreCount++;
        System.out.println("Your score is  = " + scoreCount);
    }

    /**
     * This method increases the score by 5 each time the gold coin is picked
     * up.
     */
    public void increaseScoreGold() {
        scoreCount = scoreCount + 5;
        System.out.println("Your score is  = " + scoreCount);
    }
}
