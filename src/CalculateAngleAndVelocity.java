
public class CalculateAngleAndVelocity {
	
	public static float heightOfTurret = 10; // Y initial
	public static float heightOfWall = 15; // Y final
	
	/** Takes the horizontal and vertical distance to the target and returns a float array with the values necessary to perform a ballistic trajectory to the target
    *
    * @param xDist = horizontal distance (the leg of the triangle adjacent the hypotenuse)
    * @param yDist = vertical distance (the leg of the triangle opposite the hypotenuse)
    * @return float[0] = vertical angle that the cannon is aimed to achieve a ballistic trajectory (equal to the arctan of y/x + the inscribed angle in the circle) &
    *         float[1] = velocity to fire the projectile so that it follows a ballistic trajectory along a semi circle with diameter z
    */
	public static float[] calcAandV(float distX, float distY) {
		float theta = (float) Math.atan2(distY, distX);
		float finalAngle = (float) (theta <= 72 ? theta * 1.25 : theta);
		
		float velocity = 0;
		float u = (float)((2.0/9.81) * (distX * Math.tan(finalAngle) + heightOfTurret - heightOfWall));
		
		velocity = (float) (distX / (Math.cos(finalAngle) * Math.sqrt(u)));
		return new float[] {finalAngle, velocity};
	}
}
