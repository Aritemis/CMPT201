/**
 * @author Ariana Fairbanks
 */

package lab05_bagsandsets;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class ArraySet<T> implements Set<T>
{

	private T[] elements;
	private int itemsInArray = 0;

	public ArraySet()
	{
		this.elements = (T[]) new Object[5];
	}

	public ArraySet(int size)
	{
		if (size < 0)
		{
			throw new IllegalArgumentException("Capacity must be >= 0");
		}
		this.elements = (T[]) new Object[size];
	}

	@Override
	public void add(Object element)
	{
		ensureCapacity();
		if (!this.contains(element))
		{
			elements[itemsInArray] = (T) element;
			itemsInArray++;
		}
	}

	@Override
	public void addAll(Object[] newElements)
	{
		for (int i = 0; i < newElements.length; i++)
		{
			this.add(newElements[i]);
		}
	}

	@Override
	public boolean contains(Object element)
	{
		boolean contains = false;
		for (int i = 0; i < itemsInArray; i++)
		{
			if (elements[i].equals(element))
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
		for (int i = 0; i < itemsInArray; i++)
		{
			if (elements[i].equals(element))
			{
				elements[i] = elements[itemsInArray - 1];
				itemsInArray--;
			}
		}
	}

	@Override
	public Set<T> union(Set<T> anotherSet)
	{
		Set<T> part1 = anotherSet.difference(this);
		for (int i = 0; i < itemsInArray; i++)
		{
			part1.add(elements[i]);
		}
		return part1;
	}

	@Override
	public Set<T> intersection(Set<T> anotherSet)
	{
		Set<T> temp = new ArraySet<T>();
		for (int i = 0; i < this.getSize(); i++)
		{
			if (anotherSet.contains(elements[i]))
			{
				temp.add(elements[i]);
			}
		}
		return temp;
	}

	@Override
	public Set<T> difference(Set<T> anotherSet)
	{
		Set<T> temp = new ArraySet<T>();
		for (int i = 0; i < this.getSize(); i++)
		{
			if (!anotherSet.contains(elements[i]))
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
			T[] newArray = (T[]) new Object[(itemsInArray + 1) * 2];
			System.arraycopy(elements, 0, newArray, 0, itemsInArray);
			elements = newArray;
		}
	}

	@Override
	public Iterator<T> iterator()
	{
		return new SetIterator();
	}

	/**
	 * Inner class that generates an iteration of the bag.
	 */
	private class SetIterator implements Iterator<T>
	{
		private int index = 0;

		/**
		 * Determines if there are more elements in the iteration.
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
		 * @throws java.util.NoSuchElementException
		 *             if there are no more elements in the iteration.
		 */
		public T next()
		{
			if (hasNext())
			{
				T nextItem = elements[index];
				index++;

				return nextItem;
			}
			else
				throw new java.util.NoSuchElementException("No items remaining in the iteration.");
		}

		/**
		 * The remove() operation is not supported.
		 * 
		 * @throws UnsupportedOperationException
		 *             if involed.
		 */
		public void remove()
		{
			throw new UnsupportedOperationException();
		}

	}

}
