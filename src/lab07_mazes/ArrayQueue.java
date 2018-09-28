/**
 * @author Ariana Fairbanks
 */

package lab07_mazes;

@SuppressWarnings("unchecked")
public class ArrayQueue<T> implements Queue<T>
{
	private T[] items;
	private int length;
	private int numberOfElements;
	private int startIndex;
	private int endIndex;
	
	public ArrayQueue() 
	{
		items = (T[]) new Object[5];
		length = 0;
		startIndex = 0;
		endIndex = -1;
		numberOfElements = 0;
	}
	
	public ArrayQueue(int length) 
	{
		items = (T[]) new Object[length];
		this.length = length;
		startIndex = 0;
		endIndex = -1;
		numberOfElements = 0;
	}

	@Override
	public void add(T item) 
	{
		if(isEmpty())
		{
			startIndex = 0;
		}
		ensureCapacity();
		endIndex++;
		items[endIndex] = item;
		numberOfElements++;
	}

	@Override
	public T remove() 
	{
		T item = null;
		if(!isEmpty())
		{
			item = items[startIndex];
			startIndex++;
			numberOfElements--;
			if(isEmpty())
			{
				startIndex = 0;
				endIndex = -1;
			}
			if(startIndex == length)
			{
				startIndex = 0;
			}
		}
		return item;
	}

	@Override
	public boolean isEmpty() 
	{
		return numberOfElements < 1;
	}

	@Override
	public int size()
	{
		return numberOfElements;
	}
	
	public void ensureCapacity()
	{
		
		if(numberOfElements + 2 > length)
		{
			T[] newArray = (T[]) new Object[(numberOfElements + 1) * 2];
			for(int i = 0; i < numberOfElements; i++)
			{
				int index = i + startIndex;
				if(index >= length)
				{
					index = index - length;
				}
				newArray[i] = items[index];
			}
			items = newArray;
			length = items.length;
			startIndex = 0;
			endIndex = numberOfElements - 1;
		}
		else if(endIndex == length - 1)
		{
			endIndex = -1;
		}
		
	}
	
	public void print()
	{
		for(int i = 0; i < items.length; i++)
		{
			System.out.println(items[i]);
		}
	}
}
