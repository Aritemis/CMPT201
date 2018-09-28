/**
 * @author Ariana Fairbanks
 */

package lab12_sortingcomparison;

public class QuickSort<T extends Comparable<? super T>> extends SortingAlgorithm<T> 
{

	@Override
	public void sort(T[] array) 
	{
		quickSort(array, 0, array.length - 1);
	}

	private void quickSort(T[] array, int left, int right)
	{
		int l = left;
		int r = right;
		T pivot = array[right];

		while (l <= r)
		{
			while (array[l].compareTo(pivot) < 0)
			{
				l++;
			}
			while (array[r].compareTo(pivot) > 0)
			{
				r--;
			}

			if (l <= r)
			{
				T temp = array[l];
				array[l] = array[r];
				array[r] = temp;
				l++;
				r--;
			}
		}

		if (left < r)
		{
			quickSort(array, left, r);
		}

		if (l < right)
		{
			quickSort(array, l, right);
		}

	}

}
