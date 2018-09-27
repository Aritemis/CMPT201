/**
 * @author Ariana Fairbanks
 */

package lab2_3dpoint;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThreeDimensionalPointTest
{

	@Test
	public void test()
	{
		ThreeDimensionalPoint point1 = new ThreeDimensionalPoint();
		assertEquals(0.0, point1.getX(), .001);
		assertEquals(0.0, point1.getY(), .001);
		assertEquals(0.0, point1.getZ(), .001);

		ThreeDimensionalPoint point2 = new ThreeDimensionalPoint(.2, 4.1, 5.0);
		assertEquals(0.2, point2.getX(), .001);
		assertEquals(4.1, point2.getY(), .001);
		assertEquals(5.0, point2.getZ(), .001);

		point1.shiftX(.6);
		point1.shiftY(9.0);
		point1.shiftZ(-.3);
		assertEquals(0.6, point1.getX(), .001);
		assertEquals(9.0, point1.getY(), .001);
		assertEquals(-0.3, point1.getZ(), .001);

		ThreeDimensionalPoint point3 = new ThreeDimensionalPoint(0.0, 1.0, 5.0);
		point3.rotateX(10.0);
		assertEquals(0.0, point3.getX(), 0.01);
		assertEquals(1.88, point3.getY(), 0.01);
		assertEquals(-4.73, point3.getZ(), 0.01);

		point3 = new ThreeDimensionalPoint(0.0, 1.0, 5.0);
		point3.rotateY(10.0);
		assertEquals(-2.72, point3.getX(), 0.01);
		assertEquals(1.0, point3.getY(), 0.01);
		assertEquals(-4.19, point3.getZ(), 0.01);

		point3 = new ThreeDimensionalPoint(0.0, 1.0, 5.0);
		point3.rotateZ(10.0);
		assertEquals(0.54, point3.getX(), 0.01);
		assertEquals(-0.83, point3.getY(), 0.01);
		assertEquals(5.0, point3.getZ(), 0.01);
	}

}
