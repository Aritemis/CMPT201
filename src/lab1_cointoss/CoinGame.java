/**
 * @author Ariana Fairbanks
 * 
 * Play a coin game.
 */

package lab1_cointoss;

import java.util.Scanner;

public class CoinGame
{

	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		boolean play = true;
		do
		{
			System.out.println(
					"We will flip a coin. Will it land on heads or tails? \n1: Heads\n2: Tails");
			boolean validInput = false;
			boolean userGuess = false;
			do
			{
				int input = scan.nextInt();
				if (input == 1)
				{
					userGuess = true;
					validInput = true;
				}
				else if (input == 2)
				{
					userGuess = false;
					validInput = true;
				}
				else
				{
					System.out.println(
							"Sorry, but that input wasn't valid.\n\nWe will flip a coin. Will it land on heads or tails? \n1: Heads\n2: Tails");
				}
			} while (!validInput);

			GenericCoin gameCoin = new GenericCoin();
			gameCoin.toss();
			boolean result = gameCoin.isHeads();
			if (result)
			{
				System.out.println("It was heads");
			}
			else
			{
				System.out.println("It was tails.");
			}
			if (userGuess == result)
			{
				System.out.println("You were correct!");
			}
			else
			{
				System.out.println("Your guess was incorrect.");
			}

			System.out.println("Press 1 to play again.");
			if (scan.nextInt() != 1)
			{
				play = false;
			}
		} while (play);
		System.exit(0);
	}
}
