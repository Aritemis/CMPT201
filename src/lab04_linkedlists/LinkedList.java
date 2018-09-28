/**
 * Implementation of the List interface.
 * 
 * This implementation involves a single-linked list.
 * 
 * @author Greg Gagne - February 2017
 */

package lab04_linkedlists;

public class LinkedList implements List
{
	private Node head;
	private int numberOfElements;

	public LinkedList()
	{
		head = null;
	}

	/**
	 * Inner class representing a node in the linked list
	 */
	private class Node
	{
		private Object data;
		private Node next;

		private Node(Object data)
		{
			this(data, null);
		}

		private Node(Object data, Node next)
		{
			this.data = data;
			this.next = next;
		}
	}

	@Override
	public void add(Object item)
	{
		// adds (appends) an item to the rear of the list
		Node newNode = new Node(item);
		Node current = head;

		if (isEmpty())
		{
			// special case - first element being added to the list
			head = newNode;
		}
		else
		{
			while (current.next != null)
			{
				current = current.next;
			}
			// current now references the last item in the list
			current.next = newNode;
		}

		newNode.next = null;
		++numberOfElements;
	}

	@Override
	public boolean add(Object item, int index)
	{
		boolean valid = true;
		Node newNode = new Node(item);
		if (isEmpty())
		{
			head = newNode;
			numberOfElements = 1;
		}
		else if (index == 0)
		{
			newNode.next = head;
			head = newNode;
			numberOfElements++;
		}
		else if (index + 1 > numberOfElements || index < 0)
		{
			System.out.println("invalid index");
			valid = false;
		}
		else
		{
			int currentIndex = 0;
			Node current = head;
			Node nextNode = null;

			while (currentIndex < (index - 1))
			{
				current = current.next;
				currentIndex++;
			}
			nextNode = current.next;
			current.next = newNode;
			newNode.next = nextNode;
			numberOfElements++;
		}
		return valid;
	}

	@Override
	public boolean contains(Object item)
	{
		Node current = head;
		boolean found = false;

		while (current != null && !found)
		{
			if (current.data.equals(item))
			{
				found = true;
			}

			current = current.next;
		}

		return found;

	}

	@Override
	public Object get(int index)
	{
		if (index < 0 || index + 1 > numberOfElements)
		{
			return null;
		}
		Node current = head;
		for (int i = 0; i < index; i++)
		{
			current = current.next;
		}
		return current.data;
	}

	@Override
	public boolean remove(Object item)
	{
		boolean valid = true;
		Node current = head;
		Node lastNode = null;
		if (isEmpty())
		{
			valid = false;
		}
		else if (head.data == item)
		{
			if (head.next == null)
			{
				head = null;
			}
			else
			{
				head = head.next;
			}
			numberOfElements--;
		}
		else
		{
			if (contains(item))
			{
				while (current.data != item)
				{
					lastNode = current;
					current = current.next;
				}
				lastNode.next = current.next;
				numberOfElements--;
			}
			else
			{
				valid = false;
			}
		}
		return valid;
	}

	@Override
	public Object remove(int index)
	{
		Object rv = null;

		if (isEmpty() || index >= numberOfElements)
		{
			rv = null;
		}
		else if (index == 0)
		{
			// special case - first element in the list
			rv = head.data;
			head = head.next;
			numberOfElements--;
		}
		else
		{
			int currentIndex = 0;
			Node current = head;

			while (currentIndex < (index - 1))
			{
				current = current.next;
				currentIndex++;
			}

			// current references the node we want to remove
			rv = current.next.data;
			current.next = current.next.next;
			numberOfElements--;
		}

		return rv;
	}

	@Override
	public int getLength()
	{
		return numberOfElements;
	}

	@Override
	public boolean isEmpty()
	{
		return head == null;
	}

	@Override
	public int getFrequency(Object item)
	{
		int frequency = 0;
		if (contains(item))
		{
			Node current = head;
			boolean hasNext = !isEmpty();
			while (hasNext)
			{
				if (current.data == item)
				{
					frequency++;
				}

				if (current.next != null)
				{
					current = current.next;
				}
				else
				{
					hasNext = false;
				}
			}
		}
		return frequency;
	}

	@Override
	public void clear()
	{
		head = null;
		numberOfElements = 0;
	}

}
