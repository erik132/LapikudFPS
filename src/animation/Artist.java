package animation;

import java.awt.AWTException;
import java.awt.Frame;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import main.Main;



public class Artist implements GLEventListener, MouseListener, MouseMotionListener, KeyListener{
	
	private GLU glu;
	
	private double angle = 0;
	
	private GLUquadric quadric;
	
	private ArtistAssistant assistant = new ArtistAssistant();
	
	private Camera camera;
	
	private double currentMouseX;
	
	private double currentMouseY;
	
	private Frame frame;
	
	private Robot robot;
	
	public Artist(Frame frame){
		this.frame = frame;
		this.currentMouseY = frame.getMousePosition().getY();
		this.currentMouseX = frame.getMousePosition().getX();
		try {
			this.robot = new Robot();
			this.robot.mouseMove(Main.WINDOW_SIZE_X/2, Main.WINDOW_SIZE_Y/2);
		} catch (AWTException e) {
			System.out.println("robot has failed");
		}
	}
	
	@Override
	public void init(GLAutoDrawable drawable) {
	      GL2 gl = drawable.getGL().getGL2();      // get the OpenGL graphics context
	      this.glu = new GLU();
	      gl.glClearColor(0.3f, 0.3f, 0.3f, 0.0f); // set background (clear) color
	      gl.glClearDepth(1.0f);      // set clear depth value to farthest
	      gl.glEnable(GL2.GL_DEPTH_TEST); // enables depth testing
	      gl.glDepthFunc(GL2.GL_LEQUAL);  // the type of depth test to do
	      gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST); // best perspective correction
	      gl.glShadeModel(GL2.GL_SMOOTH); // blends colors nicely, and smoothes out lighting
	      
	      this.quadric = glu.gluNewQuadric(); // create a pointer to the Quadric object ( NEW )
	      glu.gluQuadricNormals(quadric, GLU.GLU_SMOOTH); // create smooth normals ( NEW )
	      glu.gluQuadricTexture(quadric, true); // create texture coords ( NEW )
	      this.camera = new Camera(1, 1, 1, 270 , 0);
		
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(GLAutoDrawable drawable) {
	      GL2 gl = drawable.getGL().getGL2();  // get the OpenGL 2 graphics context
	      gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT); // clear color and depth buffers
	      gl.glLoadIdentity();  // reset the model-view matrix
	      
	      //this.camera.setHorisontalAngle(this.camera.getHorisontalAngle() +1);
	      this.camera.setCameraView(this.glu);
	      // ----- Your OpenGL rendering code here (Render a white triangle for testing) -----
	       // translate into the screen
	      
	      for(Bullet bullet : this.camera.getBullets()){
	    	  bullet.tickBullet(gl);
	      }
	      
	      gl.glTranslatef(0.0f, 0.0f, -20.0f);
	      gl.glColor3d(0, 0, 0);
	      this.assistant.drawCuboid(gl, -30, 30, -10, 30, -0.97, -10.5);
	      this.assistant.drawYRectangle(gl, -0.97, -30, -10, 30, 20);
	      
	      gl.glColor3d(0, 1, 0);
	      this.assistant.drawYRectangle(gl, -1, 50, 50, -50, -50);
	      gl.glColor3d(0, 0, 1);
	      this.assistant.drawYRectangle(gl, -0.99, 5, 50, -5, -50);
	      
	      
	      this.angle++;
	      //gl.glRotated(this.angle, 1, 0.7, 0.5);
	      gl.glRotated(this.angle, 0, 0.7, 0);
	      //this.assistant.drawColoredCuboid(gl, 1, -1, -1, -1, 1, 1);
	      gl.glColor3d(0.961, 0.506, 0.125);
	      this.assistant.drawLAP(gl,this.glu, this.quadric, 0, 0, 0);
	      
	      
	      
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
	      GL2 gl = drawable.getGL().getGL2();  // get the OpenGL 2 graphics context
	      
	      if (height == 0) height = 1;   // prevent divide by zero
	      float aspect = (float)width / height;
	 
	      // Set the view port (display area) to cover the entire window
	      gl.glViewport(0, 0, width, height);
	 
	      // Setup perspective projection, with aspect ratio matches viewport
	      gl.glMatrixMode(GL2.GL_PROJECTION);  // choose projection matrix
	      gl.glLoadIdentity();             // reset projection matrix
	      this.glu.gluPerspective(45.0, aspect, 0.1, 100.0); // fovy, aspect, zNear, zFar
	 
	      // Enable the model-view transform
	      gl.glMatrixMode(GL2.GL_MODELVIEW);
	      gl.glLoadIdentity(); // reset
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		this.camera.walkCamera(arg0.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		//System.out.println("mouse moved " + arg0.getX() + " " + arg0.getY());
		//System.out.println(arg0.getX() + " " + arg0.getY());
		//System.out.println((arg0.getX() - this.currentMouseX) + " " + (arg0.getY() - this.currentMouseY));

		
		/*if(arg0.getX() == Main.WINDOW_SIZE_X/2 && arg0.getY() == Main.WINDOW_SIZE_Y/2){
			System.out.println("not moving");
		}else{
			this.camera.setHorisontalAngle(this.camera.getHorisontalAngle() + ((arg0.getX() - Main.WINDOW_SIZE_X/2)*0.1));
			//this.currentMouseX = arg0.getX();
			//this.currentMouseY = arg0.getY();
			this.robot.mouseMove(Main.WINDOW_SIZE_X/2, Main.WINDOW_SIZE_Y/2);
		}*/
		
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
