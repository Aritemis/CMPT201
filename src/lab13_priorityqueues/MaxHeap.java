/**
 * Implementation of the HeapInterface as a maximum heap (max heap)
 * @author Ariana Fairbanks
 */

package lab13_priorityqueues;

public class MaxHeap <T extends Comparable<? super T>> implements HeapInterface<T> 
{
	private T[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	private int currentCapacity;
	private int numberOfElements;

	
	public MaxHeap()
	{
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public MaxHeap(int capacity) 
	{
		elements = (T[]) new Comparable[capacity + 1];
		currentCapacity = capacity + 1;
		numberOfElements = 0;
	}

	public void add(T item)
	{
		ensureCapacity();
		numberOfElements++;
		elements[numberOfElements] = item;
		swapLargest(numberOfElements);
	}

	public T remove()
	{
		T result = null;
		if(!isEmpty())
		{
			result = elements[1];
			if(numberOfElements == 1)
			{
				numberOfElements = 0;
			}
			else
			{
				elements[1] = elements[numberOfElements];
				numberOfElements--;
				swapLowest(1);
			}
		}
		return result;
	}
	
	private void swapLowest(int rootIndex)
	{
		while(rootIndex <= numberOfElements)
		{
			if(rootIndex*2 <= numberOfElements && elements[rootIndex*2] != null && elements[rootIndex*2].compareTo(elements[rootIndex]) > 0)
			{
				T temp = elements[rootIndex];
				elements[rootIndex] = elements[rootIndex*2];
				elements[rootIndex*2] = temp;
				rootIndex = rootIndex*2;
			
			}
			else if((rootIndex*2) + 1 <= numberOfElements && elements[(rootIndex*2) + 1] != null && elements[(rootIndex*2) + 1].compareTo(elements[rootIndex]) > 0)
			{
				T temp = elements[rootIndex];
				elements[rootIndex] = elements[(rootIndex*2) + 1];
				elements[(rootIndex*2) + 1] = temp;
				rootIndex =(rootIndex*2) + 1;
			}
			else
			{
				rootIndex = numberOfElements + 1;
			}
		}
	}
	
	private void swapLargest(int leafIndex)
	{
		while(leafIndex > 1)
		{
			if(leafIndex/2 >= 1 && elements[leafIndex/2].compareTo(elements[leafIndex]) < 0)
			{
				T temp = elements[leafIndex];
				elements[leafIndex] = elements[leafIndex/2];
				elements[leafIndex/2] = temp;
				leafIndex = leafIndex/2;
			}
			else
			{
				leafIndex = 1;
			}
		}
	}

	public T front() 
	{
		return elements[1];
	}

	public boolean isEmpty() 
	{
		return numberOfElements < 1;
	}

	public int getSize()
	{
		return numberOfElements;
	}

	public void print()
	{
		System.out.println();
		for(int i = 1; i <= numberOfElements; i++)
		{
			System.out.print(elements[i] + " ");
		}
	}
	
	private void ensureCapacity() 
	{
		if(numberOfElements + 3 > currentCapacity)
		{
			elements = java.util.Arrays.copyOf(elements, 2 * elements.length);
			currentCapacity = elements.length + 1;
		}
	}

}
