/**
 * @author Ariana Fairbanks
 */

package lab11_dictionary;

@SuppressWarnings("unused")
public class HashDictionaryChained<K, V> implements DictionaryInterface<K, V>
{
	private LinkedList<TableElement<K, V>>[] dictionary;
	private static int DEFAULT_SIZE = 13; 
	private int currentCapacity;
	private int numberOfElements;

	/**
	 * Inner class representing an element in the hash table
	 * This consists of a [Key:Value] mapping
	 *
	 * @param <K> Key
	 * @param <V> Value
	 */
	@SuppressWarnings("hiding")
	private class TableElement<K, V>
	{
		private K key;
		private V value;

		private TableElement(K key, V value) 
		{
			this.key = key;
			this.value = value;
		}

		/**
		 * Two TableElement objects are equals if they both have the same key
		 */
		@SuppressWarnings("unchecked")
		public boolean equals(Object other) 
		{
			boolean flag = false;

			if (other instanceof TableElement) 
			{
				TableElement<K, V> candidate = (TableElement<K, V>)other;

				if ( (this.getKey()).equals(candidate.getKey()) )
					flag = true;
			}

			return flag;
		}


		private K getKey() 
		{
			return key;
		}

		private V getValue() 
		{
			return value;
		}

		private void setKey(K key)
		{
			this.key = key;
		}

		private void setValue(V value)
		{
			this.value = value;
		}
	}

	public HashDictionaryChained() 
	{
		this(DEFAULT_SIZE);
	}

	@SuppressWarnings("unchecked")
	public HashDictionaryChained(int size) 
	{
		if (size < 0)
		{
			throw new IllegalArgumentException();
		}
		dictionary = new LinkedList[size];
		currentCapacity = size;
		numberOfElements = 0;
		for(int i = 0; i < size; i++)
		{
			dictionary[i] = new LinkedList<TableElement<K, V>>();
		}
	}

	/**
	 * Returns the hash value in the range [0 .. currentCapacity-1]
	 * @param key
	 * @return int
	 */
	private int hashValue(K key) 
	{
		return (Math.abs(key.hashCode()) % currentCapacity);
	}

	/**
	 * This calls the appropriate hashing strategy
	 */
	public V put(K key, V value) 
	{
		V result = null;
		if(contains(key))
		{
			int hashValue = hashValue(key);
			TableElement<K, V> element = new TableElement<K,V>(key, null);
			LinkedList<TableElement<K, V>> currentList = dictionary[hashValue];
			for(int i = 0; i < currentList.getLength(); i++)
			{
				TableElement<K, V> currentElement = currentList.get(i);
				if(currentElement.equals(element))
				{
					this.remove(key);
					
				}
			}
			result = chain(key, value);
		}
		else
		{
			result = chain(key, value);
		}
		return result;
	}

	/**
	 * Private helper method that implements appropriate hashing strategy
	 * @param key
	 * @param value
	 * @return
	 */
	private V chain(K key, V value) 
	{

		// create the new element
		TableElement<K, V> element = new TableElement<K,V>(key, value);
		

		// get the hash value for the specified key
		int hash = hashValue(key);
		LinkedList<TableElement<K, V>> currentList = dictionary[hash];
		currentList.add(element);
		numberOfElements++;
		return value;
	}

	public V get(K key) 
	{
		if(contains(key))
		{
			TableElement<K, V> element = new TableElement<K,V>(key, null);
			int hashValue = hashValue(key);
			V returnValue = null;
			for(int i = 0; i < dictionary[hashValue].getLength(); i++)
			{
				TableElement<K, V> currentTable = dictionary[hashValue].get(i);
				if(currentTable.equals(element))
				{
					returnValue = currentTable.value;
				}
			}
			return returnValue;
		}
		else
		{
			return null;
		}
	}

	public boolean contains(K key) 
	{
		boolean result = false;
		int hashValue = hashValue(key);
		if(dictionary[hashValue] != null)
		{
			TableElement<K, V> element = new TableElement<K,V>(key, null);
			if(dictionary[hashValue].contains(element))
			{
				result = true;
			}
		}
		return result;
	}

	public V remove(K key) 
	{
		if(contains(key))
		{
			TableElement<K, V> element = new TableElement<K,V>(key, null);
			int hashValue = hashValue(key);
			V returnValue = null;
			for(int i = 0; i < dictionary[hashValue].getLength(); i++)
			{
				TableElement<K, V> currentTableElement = dictionary[hashValue].get(i);
				if(currentTableElement.equals(element))
				{
					returnValue = currentTableElement.value;
					dictionary[hashValue].remove(currentTableElement);
				}
			}
			numberOfElements--;
			return returnValue;
		}
		else
		{
			return null;
		}
	}

	public int size() 
	{
		return numberOfElements;
	}

	public Set<K> keySet() 
	{
		Set<K> result = new ArraySet<K>();
		for(int i = 0; i < currentCapacity; i++)
		{
			LinkedList<TableElement<K, V>> item = dictionary[i];
			for(int r = 0; r < dictionary[i].getLength(); r++)
			{
				if(dictionary[i].get(r) != null)
				{
					result.add(dictionary[i].get(r).getKey());
				}
			}
		}
		return result;
	}

	public Set<V> valueSet() 
	{
		Set<V> result = new ArraySet<V>();
		for(int i = 0; i < currentCapacity; i++)
		{
			LinkedList<TableElement<K, V>> item = dictionary[i];
			for(int r = 0; r < dictionary[i].getLength(); r++)
			{
				if(dictionary[i].get(r) != null)
				{
					result.add(dictionary[i].get(r).getValue());
				}
			}
		}
		return result;
	}
}
