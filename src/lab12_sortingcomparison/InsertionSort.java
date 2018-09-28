/**
 * @author Ariana Fairbanks
 */

package lab12_sortingcomparison;

public class InsertionSort <T extends Comparable<? super T>> extends SortingAlgorithm<T> 
{

	@Override
	public void sort(T[] array)
	{
		insertionSort(array);
	}
	
	private void insertionSort(T[] array)
	{
		int n = array.length;
		if(n > 0)
		{
			for(int i = 1; i < n; i++)
			{
				T key = array[i];
				int j = i - 1;
				
				while(j >= 0 && array[j].compareTo(key) > 0)
				{
					array[j+1] = array[j];
					j--;
				}
				array[j+1] = key;
			}
		}
	}

}
