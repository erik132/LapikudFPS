package animation;

import javax.media.opengl.GL2;

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
	
	public void drawLAP(GL2 gl, double x1, double y1, double z1){
		this.drawCuboid(gl, x1-5, y1+1.5, z1-0.5, x1-4, y1-1.5, z1+0.5);
		this.drawCuboid(gl, x1-4, y1-0.5, z1-0.5, x1-3, y1-1.5, z1+0.5);
		this.drawLetterA(gl, x1, y1, z1, 1);
	}
	
	public void drawLetterA(GL2 gl, double x1, double y1, double z1, double thickness){
		this.drawYRectangle(gl, y1-1.5*thickness, x1-2*thickness, z1-0.5*thickness, x1-1*thickness, z1+0.5*thickness);
		this.drawYRectangle(gl, y1-1.5*thickness, x1+2*thickness, z1-0.5*thickness, x1+1*thickness, z1+0.5*thickness);
	}
	

	
}
