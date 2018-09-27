/**
 * @author Ariana Fairbanks
 */

package lab2_3dpoint;

public class ThreeDimensionalPoint
{

	private double x, y, z;

	public ThreeDimensionalPoint()
	{
		this.x = 0.0;
		this.y = 0.0;
		this.z = 0.0;
	}

	public ThreeDimensionalPoint(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public double getZ()
	{
		return z;
	}

	public double shiftX(double amount)
	{
		x += amount;
		return x;

	}

	public double shiftY(double amount)
	{
		y += amount;
		return y;
	}

	public double shiftZ(double amount)
	{
		z += amount;
		return z;
	}

	public void rotateX(double theta)
	{
		double y2 = (y * Math.cos(theta)) - (z * Math.sin(theta));
		double z2 = (y * Math.sin(theta)) + (z * Math.cos(theta));
		y = y2;
		z = z2;
	}

	public void rotateY(double theta)
	{
		double x2 = (x * Math.cos(theta)) + (z * Math.sin(theta));
		double z2 = (-x * Math.sin(theta)) + (z * Math.cos(theta));
		x = x2;
		z = z2;
	}
	public void rotateZ(double theta)
	{
		double x2 = (x * Math.cos(theta)) - (y * Math.sin(theta));
		double y2 = (x * Math.sin(theta)) + (y * Math.cos(theta));
		x = x2;
		y = y2;
	}
}
