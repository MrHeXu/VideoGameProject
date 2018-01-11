package game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Listener for collision with a portal. When the player collides with a portal,
 * if the current level is complete the game is advanced to the next level.
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class PortalListener implements CollisionListener {

    /**
     * An instance of the game.
     */
    private Game game;
    /**
     * The sound that plays when the player goes to the next level .
     */
    private SoundClip portalS;

    /**
     * The collision listener of the portal.
     *
     * @param game
     */
    public PortalListener(Game game) {
        this.game = game;
    }

    /**
     * Adds collision to the portal with the player. When the player collides
     * with a portal, if the current level is complete the game is advanced to
     * the next level.
     *
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        Character1 player = game.getPlayer();
        if (e.getOtherBody() == player && game.isCurrentLevelCompleted()) {
            System.out.println("Going to next level...");
            try {
            portalS = new SoundClip("data/portalSound.wav");
            portalS.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException z) {
            System.out.println(e);
        }
            game.goNextLevel();
        }
    }
}
