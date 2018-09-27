/**
 * @author Ariana Fairbanks
 */

package lab5_bagsandsets;

import java.util.Iterator;

public class UseArrayBag 
{
	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		double total = 0.0;
		String contents = null;
		Bag<String> arrayBag = new ArrayBag<String>();
		String apple = new String("Apple");
		String banana = new String("Banana");
		String cherry = new String("Cherry");
		String donut = new String("Donut");
		String eggs = new String("Eggs");
		arrayBag.add(apple);
		arrayBag.add(banana);
		arrayBag.add(cherry);
		arrayBag.add(donut);
		arrayBag.add(eggs);
		
		Iterator<String> iterator = arrayBag.iterator();
		
		while (iterator.hasNext()) 
		{
            contents = iterator.next();
            System.out.println(contents);
        }
	}
}
