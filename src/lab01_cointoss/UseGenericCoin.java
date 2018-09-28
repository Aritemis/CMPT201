/**
 * @name Ariana Fairbanks
 * @name Gabriel Rusk
 * @date January 2017
 *
 *Runs GenericCoin Class.
 */

package lab01_cointoss;

public class UseGenericCoin
{

	public static void main(String[] args)
	{
		GenericCoin coin1 = new GenericCoin();
		int coin1Heads = 0;
		for (int i = 0; i < 100; i++)
		{
			coin1.toss();
			if (coin1.isHeads())
			{
				coin1Heads++;
			}

		}
		if (coin1Heads > 50)
		{
			System.out.println();
		}

		GenericCoin coin2 = new GenericCoin();
		int coin2Heads = 0;
		for (int j = 0; j < 100; j++)
		{
			coin2.toss();
			if (coin2.isHeads())
			{
				coin2Heads++;
			}
		}
		if (coin1Heads == coin2Heads)
		{
			System.out.println("Both coins had the same number of heads.");
		}
		if (coin1Heads > coin2Heads)
		{
			int difference = coin1Heads - coin2Heads;
			System.out.println(
					"The first coin was heads " + difference + " more times.");
		}
		if (coin1Heads < coin2Heads)
		{
			int difference = coin2Heads - coin1Heads;
			System.out.println(
					"The second coin was heads " + difference + " more times.");
		}
	}

	public void flipGenericCoin()
	{

	}

}
