package common;

import javax.media.opengl.GL2;

public class Point {
	
	private double x;
	
	private double y;
	
	private double z;
	
	public Point(double x, double y, double z){
		this.setX(x);
		this.setY(y);
		this.setZ(z);
	}
	
	public void setGLPoint(GL2 gl){
		gl.glVertex3d(this.x, this.y, this.z);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
}
