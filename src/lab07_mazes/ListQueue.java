/**
 * @author Ariana Fairbanks
 */

package lab07_mazes;

import java.util.ArrayList;

public class ListQueue<T> implements Queue<T>
{
	private ArrayList<T> items = new ArrayList<T>();
	
	@Override
	public void add(T item) 
	{
		items.add(item);
	}

	@Override
	public T remove() 
	{
		T item = null;
		if(!isEmpty())
		{
			item = items.get(0);
			items.remove(0);
		}
		return item;
	}

	@Override
	public boolean isEmpty() 
	{
		return items.isEmpty();
	}

	@Override
	public int size() 
	{
		return items.size();
	}
}
