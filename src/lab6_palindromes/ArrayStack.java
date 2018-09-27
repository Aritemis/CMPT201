/**
 * @author Ariana Fairbanks
 */

package lab6_palindromes;

@SuppressWarnings("unchecked")
public class ArrayStack<T> implements Stack<T>
{
	private T[] items = (T[]) new Object[5];
	private int numberOfElements = 0;
	
	@Override
	public void push(T item)
	{
		ensureCapacity();
		items[numberOfElements] = item;
		numberOfElements++;
	}

	@Override
	public T pop() 
	{
		T item = null;
		if(!isEmpty())
		{
			item = items[numberOfElements - 1];
			items[numberOfElements - 1] = null;
			numberOfElements--;
		}
		return item;
	}

	@Override
	public T peek() 
	{
		T item = null;
		if(!isEmpty())
		{
			item = items[numberOfElements - 1];
		}
		return item;
	}

	@Override
	public boolean isEmpty()
	{
		return items[0] == null;
	}

	private void ensureCapacity() 
	{
		if (numberOfElements == items.length) 
		{
			T[] newArray = (T[]) new Object[(numberOfElements + 1) * 2];
			System.arraycopy(items, 0, newArray, 0, numberOfElements);
			items = newArray;
		}
	}
}
