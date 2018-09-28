/**
 * @author Ariana Fairbanks
 */

package lab13_priorityqueues;

public class HeapSort <T extends Comparable<? super T>> extends SortingAlgorithm <T> 
{

	@Override
	public void sort(T[] array) 
	{
		heapSort(array);
	}

	private void heapSort(T[] array)
	{
		MaxHeap<T> heap = new MaxHeap<T>();
		int index = array.length - 1;
		for(T item : array)
		{
			heap.add(item);
		}
		while(!heap.isEmpty())
		{
			array[index] = heap.remove();
			index--;
		}
	}
}
