/**
 * @author Ariana Fairbanks
 */

package lab5_bagsandsets;

import java.util.Iterator;

@SuppressWarnings("unchecked")

public class ListSet<ArrayList> implements Set<ArrayList> 
{
	
	private ArrayList[] elements;
	private int itemsInArray = 0;
	
	
	public ListSet()
	{
		this.elements = (ArrayList[]) new Object[5];
	}
	
	public ListSet(int size)
	{
		if (size < 0) 
		{
			throw new IllegalArgumentException("Capacity must be >= 0");
		}
		this.elements = (ArrayList[]) new Object[size];
	}

	@Override
	public void add(Object element) 
	{
		ensureCapacity();
		if(!this.contains(element))
		{
			elements[itemsInArray] = (ArrayList) element;
			itemsInArray++;
		}
	}

	@Override
	public void addAll(Object[] newElements) 
	{
		for(int i = 0; i < newElements.length; i++)
		{
			this.add(newElements[i]);
		}
	}

	@Override
	public boolean contains(Object element) 
	{
		boolean contains = false;
		for(int i = 0; i < itemsInArray; i++)
		{
			if(elements[i].equals(element))
			{
				contains = true;
			}
		}
		return contains;
	}

	@Override
	public int getSize() 
	{
		return itemsInArray;
	}

	@Override
	public void remove(Object element) 
	{
		for(int i = 0; i < itemsInArray; i++)
		{
			if(elements[i].equals(element))
			{
				elements[i] = elements[itemsInArray-1];
				itemsInArray--;
			}
		}
	}

	@Override
	public Set<ArrayList> union(Set<ArrayList> anotherSet) 
	{
		Set<ArrayList> part1 = anotherSet.difference(this);
		for(int i = 0; i < itemsInArray; i++)
		{
			part1.add(elements[i]);
		}
		return part1;
	}

	@Override
	public Set<ArrayList> intersection(Set<ArrayList> anotherSet) 
	{
		Set<ArrayList> temp = new ListSet<ArrayList>();
		for(int i = 0; i < this.getSize(); i++)
		{
			if(anotherSet.contains(elements[i]))
			{
				temp.add(elements[i]);
			}
		}
		return temp;
	}

	@Override
	public Set<ArrayList> difference(Set<ArrayList> anotherSet) 
	{	
		Set<ArrayList> temp = new ListSet<ArrayList>();
		for(int i = 0; i < this.getSize(); i++)
		{
			if(!anotherSet.contains(elements[i]))
			{
				temp.add(elements[i]);
			}
		}
		return temp;
	}
	
	private void ensureCapacity() 
	{
		if (itemsInArray == elements.length) 
		{
			ArrayList[] newArray = (ArrayList[]) new Object[(itemsInArray + 1) * 2];
			System.arraycopy(elements, 0, newArray, 0, itemsInArray);
			elements = newArray;
		}
	}

	@Override
	public Iterator<ArrayList> iterator() 
	{
		return new SetIterator();
	}
	
	/**
	 * Inner class that generates an iteration of the bag.
	 */
	private class SetIterator implements Iterator<ArrayList>
	{
		private int index = 0;
		
		/**
		 * Determines if there are more elements
		 * in the iteration.
		 * 
		 * @return true if there are more elements, false otherwise.
		 */
		public boolean hasNext() 
		{
			if (index < itemsInArray)
				return true;
			else
				return false;
		}

		/**
		 * Returns the next element in the iteration.
		 * 
		 * @throws java.util.NoSuchElementException if there are no more elements in the iteration.
		 */
		public ArrayList next() 
		{
			if (hasNext()) 
			{
				ArrayList nextItem = elements[index];
				index++;
				
				return nextItem;
			}
			else
				throw new java.util.NoSuchElementException("No items remaining in the iteration.");
		}

		/**
		 * The remove() operation is not supported.
		 * @throws UnsupportedOperationException if involed.
		 */
		public void remove() 
		{
			throw new UnsupportedOperationException();
		}
		
	}

}
