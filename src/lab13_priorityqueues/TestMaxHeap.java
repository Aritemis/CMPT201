/**
 * @author Ariana Fairbanks
 */

package lab13_priorityqueues;

import static org.junit.Assert.*;
import org.junit.Test;

@SuppressWarnings("unchecked")
public class TestMaxHeap 
{

	@SuppressWarnings("rawtypes")
	@Test
	public void test() 
	{
		MaxHeap heap = new MaxHeap();
		
		heap.add(3);
		heap.add(2);
		heap.add(1);
		assertEquals(3, heap.front());
		
		heap = new MaxHeap();
		heap.add(1);
		heap.add(2);
		heap.add(3);
		assertEquals(3, heap.front());
		
		heap = new MaxHeap(5);
		heap.add(1);
		heap.add(3);
		heap.add(2);
		assertEquals(3, heap.front());
		
		heap.remove();
		assertEquals(2, heap.front());
		heap.remove();
		assertEquals(1, heap.front());
		heap.add(6);
		heap.add(15);
		heap.add(3);
		heap.add(2);
		heap.add(13);
		heap.add(5);
		heap.add(8);
		heap.add(10);
		heap.add(7);
		heap.add(4);
		assertEquals(15, heap.front());
		heap.print();
		heap.add(12);
		heap.print();
		
	}

}
