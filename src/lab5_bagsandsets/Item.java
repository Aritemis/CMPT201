/**
 * A typical item that we purchase at a store.
 * @author Ariana Fairbanks
 */

package lab5_bagsandsets;

public class Item
{
	@SuppressWarnings("unused")
	private String name;
	private int quantity;
	private double cost;

	public Item(String name, int quantity, double cost)
	{
		this.name = name;
		this.quantity = quantity;
		this.cost = cost;
	}

	public double getTotalCost()
	{
		return quantity * cost;
	}
}
