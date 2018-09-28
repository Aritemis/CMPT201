/**
 * @author Ariana Fairbanks
 */

package lab12_sortingcomparison;

import java.util.Random;

public abstract class Algorithm < T extends Comparable < ? super T > >
{

	public abstract void apply(T[] array);

	public long  time(T[] array) 
	{
		long start, end;
		start = System.currentTimeMillis();

		// invoke the apply method
		this.apply(array);

		end = System.currentTimeMillis();

		// returns elapsed time
		return  (end - start);
	}
	
	public static Integer[] createRandomArray(int n)
	{
		Integer[] result = new Integer[n];
		Random random = new Random();
		for(int i = 0; i < n; i++)
		{
			result[i] = (Integer) random.nextInt();
			//System.out.println(result[i]);
		}
		return result;
	}
	
	public static void print(Object[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.println((int)array[i]); 
		}
	}
	
}
