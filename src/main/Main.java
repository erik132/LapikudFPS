package main;

import java.awt.Frame;
import java.awt.Robot;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;

import animation.Artist;
import animation.Camera;

import com.jogamp.opengl.util.FPSAnimator;

public class Main {
	
	public static final String GAME_NAME = "The chamber";
	
	public static final int WINDOW_SIZE_X = 800;
	
	public static final int WINDOW_SIZE_Y = 800;

	public static void main(String[] args) {

		
		GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        GLCanvas canvas = new GLCanvas(caps);

        Frame frame = new Frame(GAME_NAME);
        frame.setSize(WINDOW_SIZE_X, WINDOW_SIZE_Y);
        frame.add(canvas);
        //frame.setUndecorated(true);
        //frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        
        Artist artist = new Artist(frame);
        
        canvas.addGLEventListener(artist);
        canvas.addKeyListener(artist);
        canvas.addMouseListener(artist);
        canvas.addMouseMotionListener(artist);
        
        
        
        FPSAnimator animator = new FPSAnimator(canvas, 60);
        animator.start();

	}

}
