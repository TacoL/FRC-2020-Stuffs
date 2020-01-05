
public class CalculateAngleAndVelocity {
	
	public static double heightOfTurret = 10; // Y initial
	public static double heightOfWall = 15; // Y final
	
	/** Takes the horizontal and vertical distance to the target and returns a double array with the values necessary to perform a ballistic trajectory to the target
    *
    * @param xDist = horizontal distance (the leg of the triangle adjacent the hypotenuse)
    * @param yDist = vertical distance (the leg of the triangle opposite the hypotenuse)
    * @return double[0] = vertical angle that the cannon is aimed to achieve a ballistic trajectory (equal to the arctan of y/x + the inscribed angle in the circle) &
    *         double[1] = velocity to fire the projectile so that it follows a ballistic trajectory along a semi circle with diameter z
    */
	public static double[] calcAandV(double distX) {
		double theta = Math.atan2(heightOfWall, distX);
		double finalAngle = (theta <= 72 ? theta * 1.25 : theta);
		
		double velocity = 0;
		double u = ((2.0/9.81) * (distX * Math.tan(finalAngle) + heightOfTurret - heightOfWall));
		
		velocity = (distX / (Math.cos(finalAngle) * Math.sqrt(u)));
		return new double[] {finalAngle, velocity};
	}
	
	/*public static double[] getZeroes(double a, double b, double c) {
		double zero1 = ((-b + Math.sqrt(Math.pow(b, 2) - (4.0 * a * c))) / (2 * a));
		double zero2 = ((-b - Math.sqrt(Math.pow(b, 2) - (4.0 * a * c))) / (2 * a));
		
		return new double[] {zero1, zero2};
	}*/
	
	public static double physicsProblemCalcY(double distX, double velocity, double angle) {
		double timeToHitWall = distX / (velocity * Math.cos(angle));
		return .5 * (-9.81) * Math.pow(timeToHitWall, 2) + velocity * Math.sin(angle) * timeToHitWall + heightOfTurret;
	}
	
	public static void main(String[] args) {
		System.out.println(Math.toDegrees(calcAandV(10)[0]));
		System.out.println(calcAandV(10)[1]);
		System.out.print(physicsProblemCalcY(10, calcAandV(10)[1], calcAandV(10)[0]));
	}
}
