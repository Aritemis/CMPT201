/**
 * @author Ariana Fairbanks
 * @author Isaiah Herrara
 */

package lab13_priorityqueues;

public abstract class SortingAlgorithm< T extends Comparable < ? super T > > extends Algorithm <T>
{

	/**
	 * sorts the parameter array in ascending order (from smallest to largest)
	 */
	public abstract void sort (T[] array);

	/**
	 * Invoke the appropriate sorting algorithm.
	 */
	public void apply(T[] array) 
	{
		this.sort(array);
	}

	@SuppressWarnings("unchecked")
	public static <T extends Comparable<? super T>> boolean isSorted(@SuppressWarnings("rawtypes") Comparable[] array)
	{
		boolean result = false;
		if(array.length > 0)
		{
			result = true;
			for(int i = 0; i < array.length - 1; i++)
			{
				if(array[i].compareTo(array[i+1]) > 0)
				{
					result = false;
				}
			}
		}
		return result;
	}

}
