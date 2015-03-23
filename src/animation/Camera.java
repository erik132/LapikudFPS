package animation;

import javax.media.opengl.glu.GLU;

public class Camera {
	
	public static final double reversePii = 57.2957;
	
	public static final double viewRange = 2;
	
	public static final double walkRange = 0.5;
	
	public static final int FORWARD = 87;
	
	public static final int BACKWARD = 83;
	
	public static final int LEFT = 65;
	
	public static final int RIGHT = 68;
	
	public static final int UP = 38;
	
	public static final int DOWN = 40;
	
	public static final int LOOK_LEFT = 37;
	
	public static final int LOOK_RIGHT = 39;
	
	private double positionX;
	
	private double positionY;
	
	private double positionZ;
	
	private double viewX;
	
	private double viewY;
	
	private double viewZ;
	
	private double horisontalAngle;
	
	private double verticalAngle;
	
	public Camera(double positionX, double positionY, double positionZ, double horisontalAngle, double verticalAngle){
		this.positionX = positionX;
		this.positionY = positionY;
		this.positionZ = positionZ;
		this.horisontalAngle = horisontalAngle;
		this.verticalAngle = verticalAngle;
		this.correctView();
	}
	
	public void setCameraView(GLU glu){
		
		glu.gluLookAt(this.positionX, this.positionY, this.positionZ, 
				this.positionX+this.viewX, this.positionY+this.viewY, this.positionZ+this.viewZ, 0.0f, 1.0f, 0.0f);

	}
	
	private void correctView(){
		double viewRange2 = 0;
		this.viewY=this.viewRange*Math.sin(this.verticalAngle*(1/this.reversePii));
		viewRange2=this.viewRange*Math.cos(this.verticalAngle*(1/this.reversePii));
		
		if(viewRange2<0){
			viewRange2 = -viewRange2;
		}
		
		this.viewX = viewRange2 * Math.cos(this.horisontalAngle*(1/this.reversePii));
		this.viewZ = viewRange2 * Math.sin(this.horisontalAngle*(1/this.reversePii));

		System.out.println("horisontal angle " + this.horisontalAngle);
		System.out.println("vertical angle " + this.verticalAngle);
		System.out.println("x view " + this.viewX);
		System.out.println("z view " + this.viewZ);
		System.out.println("y ciew " + this.viewY);
		
		System.out.println("x position " + this.positionX);
		System.out.println("z position " + this.positionZ);
		System.out.println("y position " + this.positionY);
		System.out.println(" ");
		
	}
	
	private double correctHAngle(double angle){
		if(angle < 360){
			angle += 360;
		}
		if(angle > 360){
			angle -= 360;
		}
		return angle;
	}
	
	private double correctVAngle(double angle){
		if(angle < -89){
			angle = -89;
		}
		if(angle > 89){
			angle = 89;
		}
		return angle;
	}
	
	public void setHorisontalAngle(double angle){

		this.horisontalAngle = this.correctHAngle(angle);
		//this.correctView();
	}
	
	public void setVerticalAngle(double angle){
		this.verticalAngle = this.correctVAngle(angle);
		//this.correctView();
	}
	
	public double getVerticalAngle(){
		return this.verticalAngle;
	}
	
	public double getHorisontalAngle(){
		return this.horisontalAngle;
	}
	
	public synchronized void walkCamera(int direction){
		//System.out.println(direction);
		switch(direction){
		case FORWARD:

			this.positionX = this.positionX + (this.walkRange * Math.cos(this.horisontalAngle * (1/this.reversePii)));
			this.positionZ = this.positionZ + (this.walkRange * Math.sin(this.horisontalAngle * (1/this.reversePii)));
			break;
		case BACKWARD:

			this.positionX = this.positionX - (this.walkRange * Math.cos(this.horisontalAngle * (1/this.reversePii)));
			this.positionZ = this.positionZ - (this.walkRange * Math.sin(this.horisontalAngle * (1/this.reversePii)));
			break;
		case LEFT:

			this.positionX = this.positionX + (this.walkRange * Math.cos((this.horisontalAngle-90) * (1/this.reversePii)));
			this.positionZ = this.positionZ + (this.walkRange * Math.sin((this.horisontalAngle-90) * (1/this.reversePii)));
			break;
		case RIGHT:

			this.positionX = this.positionX + (this.walkRange * Math.cos((this.horisontalAngle+90) * (1/this.reversePii)));
			this.positionZ = this.positionZ + (this.walkRange * Math.sin((this.horisontalAngle+90) * (1/this.reversePii)));
			break;
		case LOOK_LEFT:
			this.setHorisontalAngle(this.getHorisontalAngle() -1);
			break;
		case LOOK_RIGHT:
			this.setHorisontalAngle(this.getHorisontalAngle() +1);
			break;
		case UP:
			this.setVerticalAngle(this.getVerticalAngle() +1);
			break;
		case DOWN:
			this.setVerticalAngle(this.getVerticalAngle() -1);
			break;
		}
		this.correctView();
	}
}
