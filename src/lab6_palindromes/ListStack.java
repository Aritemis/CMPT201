/**
 * @author Ariana Fairbanks
 * @author Harrison Crisman
 */

package lab6_palindromes;

import java.util.ArrayList;

public class ListStack<T> implements Stack<T>
{
	private ArrayList<T> items = new ArrayList<T>();
	private int numberOfElements = -1;
		
	@Override
	public void push(T item) 
	{
		items.add(item);
		numberOfElements++;
	}

	@Override
	public T pop() 
	{
		T item = null;
		if(!items.isEmpty())
		{
			item = items.get(numberOfElements);
			items.remove(numberOfElements);
			numberOfElements--;
		}
		return item;
	}

	@Override
	public T peek() 
	{
		T item = null;
		if(!items.isEmpty())
		{
			item = items.get(numberOfElements);
		}
		return item;
	}

	@Override
	public boolean isEmpty() 
	{
		return items.isEmpty();
	}
}
