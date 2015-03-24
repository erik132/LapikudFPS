package animation;

import javax.media.opengl.GL2;

public class Bullet extends ArtistAssistant{
	
	public static final double reversePii = 57.2957;
	
	public static final int MAX_DISTANCE = 300;
	
	private double posX;
	
	private double posY;
	
	private double posZ;
	
	private double horisontalAngle;
	
	private double verticalAngle;
	
	public static final double speed = 0.2;
	
	private int currentDistance;
	
	public Bullet(double posX, double posY, double posZ, double hAngle, double vAngle){
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.horisontalAngle = hAngle;
		this.verticalAngle = vAngle;
		this.currentDistance = 0;
	}
	
	public void tickBullet(GL2 gl){
		
		if(this.currentDistance> this.MAX_DISTANCE){
			return ;
		}
		this.currentDistance++;
		
		double x2,y2,z2;
		double speed = 0;
		y2=this.speed*Math.sin(this.verticalAngle*(1/this.reversePii));
		speed=this.speed*Math.cos(this.verticalAngle*(1/this.reversePii));
		
		if(speed<0){
			speed = -speed;
		}
		
		x2 = speed * Math.cos(this.horisontalAngle*(1/this.reversePii));
		z2 = speed * Math.sin(this.horisontalAngle*(1/this.reversePii));
		
		this.posX = this.posX + x2;
		this.posY = this.posY + y2;
		this.posZ = this.posZ + z2;
		
		double size = 0.3;
		gl.glColor3d(1, 1, 0);
		this.drawCuboid(gl, this.posX -size, this.posY + size, this.posZ + size, 
				this.posX + size, this.posY - size, this.posZ - size);
	}

}
