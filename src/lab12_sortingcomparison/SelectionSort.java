/**
 * @author Ariana Fairbanks
 */

package lab12_sortingcomparison;

public class SelectionSort<T extends Comparable<? super T>> extends SortingAlgorithm<T>
{
	@Override
	public void sort(T[] array)
	{
		selectionSort(array);
	}

	private void selectionSort(T[] array)
	{
		int n = array.length;
		for (int index = 0; index < n - 1; index++)
		{
			int indexOfNextSmallest = getIndexOfSmallest(array, index, n - 1);
			swap(array, index, indexOfNextSmallest);
		} 
	}

	/** Task: Finds the index of the smallest value in a portion of an 
	 *        array.
	 *  @param a      an array of Comparable objects
	 *  @param first  an integer >= 0 and < a.length that is the index of 
	 *                the first array element to consider
	 *  @param last   an integer >= first and < a.length that is the index 
	 *                of the last array element to consider
	 *  @return the index of the smallest value among
	 *          a[first], a[first + 1], . . . , a[last] */
	@SuppressWarnings("hiding")
	private <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last)
	{
		T min = a[first];
		int indexOfMin = first;
		for (int index = first + 1; index <= last; index++)
		{
			if (a[index].compareTo(min) < 0)
			{
				min = a[index];
				indexOfMin = index;
			} 
		} 
		return indexOfMin;
	} 

	/** Task: Swaps the array elements a[i] and a[j].
	 *  @param a  an array of objects
	 *  @param i  an integer >= 0 and < a.length
	 *  @param j  an integer >= 0 and < a.length */
	@SuppressWarnings("unchecked")
	private void swap(T[] a, int i, int j)
	{
		Object temp = a[i];
		a[i] = a[j];
		a[j] = (T) temp; 
	} 

}
