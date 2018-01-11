package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Key handler to control the character..
 *
 * @author Cosmin Ioan Capatina , cosmin.capatina@city.ac.uk
 * @version 1.0
 */
public class Controller extends KeyAdapter {

    /**
     * The velocity of the character when he jumps.
     */
    private static final float JUMPING_SPEED = 14;
    /**
     * The velocity of the character when he walks.
     */
    private static final float WALKING_SPEED = 7;
    /**
     * Instance of the view used in the controller class.
     */
    private UserView view;
    /**
     * Instance of the character used in the controller class.
     */
    private Walker body;
    /**
     * Sound clip used when the character jump.
     */
    private SoundClip jump;
    /**
     * Sound clip used when the character is running. ( not in the game, very
     * buggy )
     */
    private SoundClip running;
    /**
     * The image of the character when he walks to the left.
     */
    private static final BodyImage wLeft = new BodyImage("data/characterLeft.gif", 5.0f);
    /**
     * Image of the character when he walks to the right.
     */
    private static final BodyImage wRight = new BodyImage("data/characterRight.gif", 5.0f);
    /**
     * Image of the character when he is static to the left.
     */
    private static final BodyImage staticL = new BodyImage("data/characterLeftStatic.gif", 5.0f);
    /**
     * Image of the character when he is static to the right.
     */
    private static final BodyImage staticR = new BodyImage("data/characterRightStatic.gif", 5.0f);

    /**
     * Instance of the controller used in other classes.
     *
     * @param body
     */
    public Controller(Walker body) {
        this.body = body;
    }

    /**
     * Handle key press events for walking and jumping.
     *
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_SPACE) { // SPACE = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
                try {
                    jump = new SoundClip("data/jump.wav");
                    jump.play();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException s) {
                    System.out.println(s);
                }
            }
        } else if (code == KeyEvent.VK_UP) {
            Vec2 v1 = body.getLinearVelocity();
            if (Math.abs(v1.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
                try {
                    jump = new SoundClip("data/jump.wav");
                    jump.play();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException s) {
                    System.out.println(s);
                }
            }
        } else if (code == KeyEvent.VK_LEFT) {
            body.startWalking(-WALKING_SPEED); // LEFT ARROW = walk left
            body.removeAllImages();
            body.addImage(wLeft);
        } else if (code == KeyEvent.VK_RIGHT) {
            body.startWalking(WALKING_SPEED); // RIGHT ARROW = walk right
            body.removeAllImages();
            body.addImage(wRight);
        }
    }

    /**
     * Handle key release events (stop walking).
     *
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            body.removeAllImages();
            body.addImage(staticL);
            body.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            body.removeAllImages();
            body.addImage(staticR);
            body.stopWalking();
        }
    }

    /**
     *
     * @param body
     */
    public void setBody(Walker body) {
        this.body = body;
    }
}
