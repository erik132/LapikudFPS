package animation;

import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import common.Point;

public class ArtistAssistant {
	
	public void drawCuboid(GL2 gl, double x1, double y1, double z1, double x2, double y2, double z2){
		gl.glBegin(GL2.GL_QUADS);
		
		//gl.glColor3f(1, 1, 1);
		gl.glVertex3d(x1, y1, z1);
		gl.glVertex3d(x1, y2, z1);
		gl.glVertex3d(x2, y2, z1);
		gl.glVertex3d(x2, y1, z1);
		
		
		//gl.glColor3f(1, 0, 0);
		gl.glVertex3d(x1, y1, z2);
		gl.glVertex3d(x1, y2, z2);
		gl.glVertex3d(x2, y2, z2);
		gl.glVertex3d(x2, y1, z2);
		
		//gl.glColor3f(0, 1, 0);
		gl.glVertex3d(x1, y1, z1);
		gl.glVertex3d(x1, y1, z2);
		gl.glVertex3d(x2, y1, z2);
		gl.glVertex3d(x2, y1, z1);
		
		//gl.glColor3f(0, 0, 1);
		gl.glVertex3d(x1, y2, z1);
		gl.glVertex3d(x1, y2, z2);
		gl.glVertex3d(x2, y2, z2);
		gl.glVertex3d(x2, y2, z1);
		
		//gl.glColor3f(1, 1, 0);
		gl.glVertex3d(x1, y1, z1);
		gl.glVertex3d(x1, y1, z2);
		gl.glVertex3d(x1, y2, z2);
		gl.glVertex3d(x1, y2, z1);
		
		//gl.glColor3f(1, 0, 1);
		gl.glVertex3d(x2, y1, z1);
		gl.glVertex3d(x2, y1, z2);
		gl.glVertex3d(x2, y2, z2);
		gl.glVertex3d(x2, y2, z1);
		gl.glEnd();
	}
	
	public void drawColoredCuboid(GL2 gl, double x1, double y1, double z1, double x2, double y2, double z2){
		gl.glBegin(GL2.GL_QUADS);
		
		gl.glColor3f(1, 1, 1);
		gl.glVertex3d(x1, y1, z1);
		gl.glVertex3d(x1, y2, z1);
		gl.glVertex3d(x2, y2, z1);
		gl.glVertex3d(x2, y1, z1);
		
		
		gl.glColor3f(1, 0, 0);
		gl.glVertex3d(x1, y1, z2);
		gl.glVertex3d(x1, y2, z2);
		gl.glVertex3d(x2, y2, z2);
		gl.glVertex3d(x2, y1, z2);
		
		gl.glColor3f(0, 1, 0);
		gl.glVertex3d(x1, y1, z1);
		gl.glVertex3d(x1, y1, z2);
		gl.glVertex3d(x2, y1, z2);
		gl.glVertex3d(x2, y1, z1);
		
		gl.glColor3f(0, 0, 1);
		gl.glVertex3d(x1, y2, z1);
		gl.glVertex3d(x1, y2, z2);
		gl.glVertex3d(x2, y2, z2);
		gl.glVertex3d(x2, y2, z1);
		
		gl.glColor3f(1, 1, 0);
		gl.glVertex3d(x1, y1, z1);
		gl.glVertex3d(x1, y1, z2);
		gl.glVertex3d(x1, y2, z2);
		gl.glVertex3d(x1, y2, z1);
		
		gl.glColor3f(1, 0, 1);
		gl.glVertex3d(x2, y1, z1);
		gl.glVertex3d(x2, y1, z2);
		gl.glVertex3d(x2, y2, z2);
		gl.glVertex3d(x2, y2, z1);
		gl.glEnd();
	}
	
	public void drawYRectangle(GL2 gl, double y, double x1, double z1, double x2, double z2){
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3d(x1, y, z1);
		gl.glVertex3d(x1, y, z2);
		gl.glVertex3d(x2, y, z2);
		gl.glVertex3d(x2, y, z1);
		gl.glEnd();
	}
	
	public void drawXRectangle(GL2 gl, double x, double y1, double z1, double y2, double z2){
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3d(x, y1, z1);
		gl.glVertex3d(x, y1, z2);
		gl.glVertex3d(x, y2, z2);
		gl.glVertex3d(x, y2, z1);
		gl.glEnd();
	}
	
	private List<Point> YRectanglePoints(double y, double x1, double z1, double x2, double z2){
		List<Point> points = new ArrayList<>();
		
		points.add(new Point(x1, y, z1));
		points.add(new Point(x1, y, z2));
		points.add(new Point(x2, y, z2));
		points.add(new Point(x2, y, z1));
		
		return points;
	}
	
	private List<Point> XRectanglePoints(double x, double y1, double z1, double y2, double z2){
		List<Point> points = new ArrayList<>();
		
		points.add(new Point(x, y1, z1));
		points.add(new Point(x, y1, z2));
		points.add(new Point(x, y2, z2));
		points.add(new Point(x, y2, z1));
		
		return points;
	}
	
	public void drawLAP(GL2 gl, GLU glu, GLUquadric quadric, double x1, double y1, double z1){
		this.drawCuboid(gl, x1-5, y1+2.5, z1-0.5, x1-4, y1-1.5, z1+0.5);
		this.drawCuboid(gl, x1-4, y1-0.5, z1-0.5, x1-3, y1-1.5, z1+0.5);
		
		this.drawLetterA(gl, x1, y1, z1, 1);
		
		this.drawCuboid(gl, x1+5, y1+2.5, z1-0.5, x1+4, y1-1.5, z1+0.5);
		gl.glTranslatef(5.3f, 1.5f, -0.5f);
		glu.gluCylinder(quadric, 1.0f, 1.0f, 1.0f, 32, 32);
		glu.gluCylinder(quadric, 0.8f, 0.8f, 1.0f, 32, 32);
		glu.gluDisk(quadric, 0.8f, 1.0f, 32, 32);
		gl.glTranslatef(0f, 0f, 1f);
		glu.gluDisk(quadric, 0.8f, 1.0f, 32, 32);
		gl.glTranslatef(-5.3f, -1.5f, -0.5f);
	}
	
	private void drawIrregularCuboid(GL2 gl,List<Point> points){
		int i=0, u=0;
		
		gl.glBegin(GL2.GL_QUADS);
		
		for(i=0;i<4;i++){
			points.get(i).setGLPoint(gl);
		}
		
		//gl.glColor3d(1,0,0);
		points.get(0).setGLPoint(gl);
		points.get(1).setGLPoint(gl);
		points.get(6).setGLPoint(gl);
		points.get(7).setGLPoint(gl);
		
		
		//gl.glColor3d(0,1,0);
		points.get(1).setGLPoint(gl);
		points.get(2).setGLPoint(gl);
		points.get(5).setGLPoint(gl);
		points.get(6).setGLPoint(gl);
		
		//gl.glColor3d(0,0,1);
		points.get(2).setGLPoint(gl);
		points.get(3).setGLPoint(gl);
		points.get(4).setGLPoint(gl);
		points.get(5).setGLPoint(gl);
		
		//gl.glColor3d(1, 1, 0);
		points.get(3).setGLPoint(gl);
		points.get(0).setGLPoint(gl);
		points.get(7).setGLPoint(gl);
		points.get(4).setGLPoint(gl);
		
		
		gl.glEnd();
	}
	
	public void drawLetterA(GL2 gl, double x1, double y1, double z1, double thickness){
		List<Point> sidePoints = new ArrayList<>();
		
		sidePoints.addAll(this.YRectanglePoints(y1-1.5*thickness, x1-2*thickness, z1-0.5*thickness, x1-1*thickness, z1+0.5*thickness));
		sidePoints.addAll(this.XRectanglePoints(x1, y1+1.5*thickness, z1-0.5*thickness, y1+2.5*thickness, z1+0.5*thickness));
		
		this.drawIrregularCuboid(gl, sidePoints);
		gl.glRotated(180, 0, 1, 0);
		this.drawIrregularCuboid(gl, sidePoints);
		gl.glRotated(-180, 0, 1, 0);
		
		this.drawCuboid(gl, x1-1, y1, z1-0.49, x1+1, y1-0.5, z1+0.49);
		
		/*this.drawYRectangle(gl, y1-1.5*thickness, x1-2*thickness, z1-0.5*thickness, x1-1*thickness, z1+0.5*thickness);
		this.drawYRectangle(gl, y1-1.5*thickness, x1+2*thickness, z1-0.5*thickness, x1+1*thickness, z1+0.5*thickness);
		
		this.drawXRectangle(gl, x1, y1+1.5*thickness, z1-0.5*thickness, y1+2.5*thickness, z1+0.5*thickness);*/
	}
	

	
}
