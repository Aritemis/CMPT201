/**
 * Unit tests to test implementation of Stack interface.
 * @author Ariana Fairbanks
 */

package lab06_palindromes;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestStack
{

	@Test
	public void testArrayStack()
	{
		Stack<String> s = new ArrayStack<String>();

		assertTrue(s.isEmpty());
		assertNull(s.peek());
		assertNull(s.pop());

		s.push("apple");
		s.push("banana");
		s.push("cherry");

		assertFalse(s.isEmpty());

		assertEquals("cherry", s.peek());
		assertEquals("cherry", s.pop());
		assertEquals("banana", s.peek());
		assertEquals("banana", s.pop());
		assertEquals("apple", s.peek());
		assertEquals("apple", s.pop());

		assertTrue(s.isEmpty());
		assertNull(s.pop());

		s.push("donut");

		assertFalse(s.isEmpty());

		assertEquals("donut", s.pop());
	}

	@Test
	public void testListStack()
	{
		Stack<String> s = new ListStack<String>();

		assertTrue(s.isEmpty());
		assertNull(s.peek());
		assertNull(s.pop());

		s.push("apple");
		s.push("banana");
		s.push("cherry");

		assertFalse(s.isEmpty());

		assertEquals("cherry", s.peek());
		assertEquals("cherry", s.pop());
		assertEquals("banana", s.peek());
		assertEquals("banana", s.pop());
		assertEquals("apple", s.peek());
		assertEquals("apple", s.pop());

		assertTrue(s.isEmpty());
		assertNull(s.pop());

		s.push("donut");

		assertFalse(s.isEmpty());

		assertEquals("donut", s.pop());
	}

}
