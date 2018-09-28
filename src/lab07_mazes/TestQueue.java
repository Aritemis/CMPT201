/**
 * Unit tests to test implementation of queue interface.
 * @author Ariana Fairbanks
 */

package lab07_mazes;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestQueue
{

	@Test
	public void testListQueue() 
	{
		Queue<String> q = new ListQueue<String>();
		
		assertTrue(q.isEmpty());
		assertEquals(0,q.size());
		assertNull(q.remove());
		
		q.add("apple");
		q.add("banana");
		q.add("cherry");
		q.add("date");
		
		assertFalse(q.isEmpty());
		assertEquals(4,q.size());
		
		assertEquals("apple", q.remove());
		assertEquals("banana", q.remove());
		assertEquals("cherry", q.remove());
		assertEquals("date", q.remove());
		
		assertTrue(q.isEmpty());
		assertEquals(0,q.size());
		assertNull(q.remove());
	}
	
	@Test
	public void testArrayQueue() 
	{
		Queue<String> q = new ArrayQueue<String>(6);
		
		q.add("apple");
		q.add("banana");
		q.add("cherry");
		q.add("donut");
		q.add("eggplant");
		
		assertEquals("apple", q.remove());
		assertEquals("banana", q.remove());
		
		q.add("fig");
		q.add("grape");
		q.add("honey");
		
		assertEquals("cherry", q.remove());
		assertEquals("donut", q.remove());
		assertEquals("eggplant", q.remove());
		assertEquals("fig", q.remove());
		assertEquals("grape", q.remove());
		assertEquals("honey", q.remove());
		
		
	//check ensure capacity methods that act when there is only one index left in the array
		Queue<String> n = new ArrayQueue<String>(7);
		
		n.add("apple");
		n.add("banana");
		n.add("cherry");
		n.add("donut");
		n.add("eggplant");
		
		assertEquals("apple", n.remove());
		assertEquals("banana", n.remove());
		
		n.add("fig");
		n.add("grape");
		n.add("honey");
		
		assertEquals("cherry", n.remove());
		assertEquals("donut", n.remove());
		assertEquals("eggplant", n.remove());
		assertEquals("fig", n.remove());
		assertEquals("grape", n.remove());
		assertEquals("honey", n.remove());
		
	//check ensure capacity methods that act when the string is full
		@SuppressWarnings("unused")
		Queue<String> p = new ArrayQueue<String>(5);
		
		q.add("apple");
		q.add("banana");
		q.add("cherry");
		q.add("donut");
		q.add("eggplant");
		
		assertEquals("apple", q.remove());
		assertEquals("banana", q.remove());
		
		q.add("fig");
		q.add("grape");
		q.add("honey");
		
		assertEquals("cherry", q.remove());
		assertEquals("donut", q.remove());
		assertEquals("eggplant", q.remove());
		assertEquals("fig", q.remove());
		assertEquals("grape", q.remove());
		assertEquals("honey", q.remove());
		
	}

}
