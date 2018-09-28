/**
 * @name Ariana Fairbanks
 * @name Gabriel Rusk
 * @date January 2017
 * 
 * This class provides a generic coin.
 */

package lab01_cointoss;

public class GenericCoin
{

	public enum CoinSide
	{
		HEADS, TAILS
	};
	private CoinSide side;

	public GenericCoin()
	{
		side = CoinSide.HEADS;
	}

	public void setToHeads()
	{
		this.side = CoinSide.HEADS;
	}

	public void setToTails()
	{
		this.side = CoinSide.TAILS;
	}

	public void toss()
	{
		int rng = (int) (Math.random() * 10);
		if (rng < 6)
		{
			this.side = CoinSide.HEADS;
		}
		else
		{
			this.side = CoinSide.TAILS;
		}
	}

	public boolean isHeads()
	{
		boolean heads = false;
		if (this.side == CoinSide.HEADS)
		{
			heads = true;
		}
		return heads;
	}

	public boolean isTails()
	{
		boolean tails = false;
		if (this.side == CoinSide.TAILS)
		{
			tails = true;
		}
		return tails;
	}

	public String toString()
	{
		if (this.side == CoinSide.HEADS)
		{
			return "heads";
		}
		return "tails";
	}
}
