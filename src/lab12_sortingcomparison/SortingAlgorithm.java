/**
 * @author Ariana Fairbanks
 */

package lab12_sortingcomparison;

@SuppressWarnings("rawtypes")
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
	public static <T extends Comparable<? super T>> boolean isSorted(Comparable[] array)
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

	@SuppressWarnings("unchecked")
	public static void compareSorts(int n)
	{
		final int NUMBER = 5;

		SortingAlgorithm[] sorts = new SortingAlgorithm[NUMBER];

		sorts[0] = new SelectionSort();
		sorts[1] = new InsertionSort();
		sorts[2] = new MergeSort();
		sorts[3] = new QuickSort();
		sorts[4] = new HeapSort();

		Integer[][] sortArray = new Integer[NUMBER][n];
		sortArray[0] = createRandomArray(n);

		System.arraycopy(sortArray[0], 0, sortArray[1], 0, sortArray[0].length);
		System.arraycopy(sortArray[0], 0, sortArray[2], 0, sortArray[0].length);
		System.arraycopy(sortArray[0], 0, sortArray[3], 0, sortArray[0].length);
		System.arraycopy(sortArray[0], 0, sortArray[4], 0, sortArray[0].length);
		
		for (int i = 0; i < sorts.length; i++) 
		{
			System.out.println(sorts[i].time(sortArray[i]));
		}
	}

}
