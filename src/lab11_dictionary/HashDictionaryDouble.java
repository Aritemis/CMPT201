/**
 * @author Ariana Fairbanks
 */

package lab11_dictionary;

public class HashDictionaryDouble<K, V> implements DictionaryInterface<K, V>
{
	// initial size of hash table
	private static int DEFAULT_SIZE = 13;

	// When capacity exceeds this threshold, a new addition will trigger
	// rehashing
	private static double CAPACITY_THRESHOLD = 0.67;

	// the number of elements in the hash table
	private int numberOfElements;

	// the hash table
	private TableElement<K, V>[] dictionary;
	private boolean[] rewrite;

	// the current capacity of the hash table
	// this is a prime number
	private int currentCapacity;
	private int doubleHash;

	/**
	 * Inner class representing an element in the hash table This consists of a
	 * [Key:Value] mapping
	 *
	 * @param <K>
	 *            Key
	 * @param <V>
	 *            Value
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
				TableElement<K, V> candidate = (TableElement<K, V>) other;

				if ((this.getKey()).equals(candidate.getKey()))
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

		@SuppressWarnings("unused")
		private void setKey(K key)
		{
			this.key = key;
		}

		private void setValue(V value)
		{
			this.value = value;
		}
	}

	public HashDictionaryDouble()
	{
		this(DEFAULT_SIZE);
	}

	@SuppressWarnings("unchecked")
	public HashDictionaryDouble(int size)
	{
		if (size < 0)
		{
			throw new IllegalArgumentException();
		}

		dictionary = (TableElement<K, V>[]) new TableElement[size];
		rewrite = new boolean[size];
		numberOfElements = 0;
		currentCapacity = size;
		doubleHash = findDoubleHash();
	}

	/**
	 * Returns the hash value in the range [0 .. currentCapacity-1]
	 * 
	 * @param key
	 * @return int
	 */
	private int hashValue(K key, int time)
	{
		return ((firstValue(key)) + (time * doubleValue(key))) % currentCapacity;
	}

	private int firstValue(K key)
	{
		return (Math.abs(key.hashCode()) % currentCapacity);
	}

	private int doubleValue(K key)
	{
		return 1 + (Math.abs(key.hashCode()) % doubleHash);
	}

	private int findDoubleHash()
	{
		int current = currentCapacity - 1;
		while (!isPrime(current) && current > 0)
		{
			current--;
		}
		return current;
	}

	/**
	 * This calls the appropriate hashing strategy
	 */
	public V put(K key, V value)
	{
		V result = null;
		if (contains(key))
		{
			int time = 1;
			int hashValue = hashValue(key, time);

			while (!dictionary[hashValue].getKey().equals(key))
			{
				time++;
				hashValue = hashValue(key, time);
			}
			dictionary[hashValue].setValue(value);
			result = value;
		}
		else
		{
			result = doubleHash(key, value);
		}
		return result;
	}

	/**
	 * Private helper method that implements appropriate hashing strategy
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	private V doubleHash(K key, V value)
	{

		// re-hash if necessary
		ensureCapacity();

		// create the new element
		TableElement<K, V> element = new TableElement<K, V>(key, value);

		// get the hash value for the specified key
		int time = 1;
		int hash = hashValue(key, time);
		boolean somethingToReplace = false;
		int actualHash = 0;

		while (dictionary[hash] != null)
		{
			if (rewrite[hash] == true)
			{
				somethingToReplace = true;
				actualHash = hash;
			}
			time++;
			hash = hashValue(key, time);
		}

		if (somethingToReplace)
		{
			hash = actualHash;
		}
		dictionary[hash] = element;
		rewrite[hash] = false;
		numberOfElements++;
		return value;

	}

	public V get(K key)
	{
		if (contains(key))
		{
			int time = 1;
			int hashValue = hashValue(key, time);
			while (dictionary[hashValue] != null && !dictionary[hashValue].getKey().equals(key))
			{
				time++;
				hashValue = hashValue(key, time);
			}
			return dictionary[hashValue].getValue();
		}
		else
		{
			return null;
		}
	}

	public boolean contains(K key)
	{
		boolean result = false;
		int time = 1;
		int hashValue = hashValue(key, time);

		while (dictionary[hashValue] != null && !dictionary[hashValue].getKey().equals(key))
		{
			time++;
			hashValue = hashValue(key, time);
		}

		if (dictionary[hashValue] != null && rewrite[hashValue] != true)
		{
			result = true;
		}

		return result;
	}

	public V remove(K key)
	{
		V result = null;
		if (contains(key))
		{
			result = get(key);
			int time = 1;
			int hashValue = hashValue(key, time);

			while (!dictionary[hashValue].getKey().equals(key))
			{
				time++;
				hashValue = hashValue(key, time);
			}

			rewrite[hashValue] = true;
			numberOfElements--;
		}
		return result;
	}

	public int size()
	{
		return numberOfElements;
	}

	/**
	 * returns the next prime number that is least 2 larger than the current
	 * prime number.
	 */
	private int getNextPrime(int currentPrime)
	{
		// first we double the size of the current prime + 1
		currentPrime *= 2;
		currentPrime += 1;

		while (!isPrime(currentPrime))
		{
			currentPrime++;
		}

		return currentPrime;
	}

	/**
	 * Helper method that tests if an integer value is prime.
	 * 
	 * @param candidate
	 * @return True if candidate is prime, false otherwise.
	 */
	private boolean isPrime(int candidate)
	{
		boolean isPrime = true;

		// numbers <= 1 or even are not prime
		if ((candidate <= 1))
			isPrime = false;
		// 2 or 3 are prime
		else if ((candidate == 2) || (candidate == 3))
			isPrime = true;
		// even numbers are not prime
		else if ((candidate % 2) == 0)
			isPrime = false;
		// an odd integer >= 5 is prime if not evenly divisible
		// by every odd integer up to its square root
		// Source: Carrano.
		else
		{
			for (int i = 3; i <= Math.sqrt(candidate) + 1; i += 2)
				if (candidate % i == 0)
				{
					isPrime = false;
					break;
				}
		}

		return isPrime;
	}

	/**
	 * re-hash the elements in the dictionary
	 */
	@SuppressWarnings("unchecked")
	private void rehash()
	{
		int oldCapacity = currentCapacity;
		currentCapacity = getNextPrime(currentCapacity);
		boolean[] oldRewrite = rewrite;
		rewrite = new boolean[currentCapacity];
		TableElement<K, V>[] temp = dictionary;
		dictionary = (HashDictionaryDouble<K, V>.TableElement<K, V>[]) new TableElement[currentCapacity];
		numberOfElements = 0;
		// HashDictionaryLinear temp = new HashDictionaryLinear(newSize);
		for (int i = 0; i < oldCapacity; i++)
		{
			TableElement<K, V> item = temp[i];
			if (item != null && oldRewrite[i] == false)
			{
				put(item.getKey(), item.getValue());
			}
		}
	}

	/**
	 * Return the current load factor
	 * 
	 * @return
	 */
	private double getLoadFactor()
	{
		return numberOfElements / (double) currentCapacity;
	}

	/**
	 * Ensure there is capacity to perform an addition
	 */
	private void ensureCapacity()
	{
		double loadFactor = getLoadFactor();

		if (loadFactor >= CAPACITY_THRESHOLD)
		{
			rehash();
		}
	}

	public Set<K> keySet()
	{
		Set<K> result = new ArraySet<K>();
		for (int i = 0; i < currentCapacity; i++)
		{
			TableElement<K, V> item = dictionary[i];
			if (item != null && rewrite[i] == false)
			{
				result.add(item.getKey());
			}
		}
		return result;
	}

	public Set<V> valueSet()
	{
		Set<V> result = new ArraySet<V>();
		for (int i = 0; i < currentCapacity; i++)
		{
			TableElement<K, V> item = dictionary[i];
			if (item != null && rewrite[i] == false)
			{
				result.add(item.getValue());
			}
		}
		return result;
	}

}
