/**
 * @author Ariana Fairbanks
 * @author Harrison Crisman
 */

package lab06_palindromes;

import java.util.Scanner;

public class PalindromeCheckerV1
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		boolean cont = true;
		PalindromeCheckerV1 checker = new PalindromeCheckerV1();
		do
		{
			checker.compare(scan);
		} while (cont);
		scan.close();
	}

	private void compare(Scanner scan)
	{
		String message = null;
		ArrayStack<String> characters = new ArrayStack<String>();
		int middle;
		int currentPosition = 0;
		System.out.println("Enter a string:");

		message = scan.nextLine();

		if (message.length() % 2 == 1)
		{
			middle = (message.length() - 1) / 2;
			message = new String(message.substring(0, middle) + message.substring(middle + 1));
		}
		middle = message.length() / 2;

		while (currentPosition < message.length())
		{

			if (currentPosition < middle)
			{
				String newChar = new String(message.charAt(currentPosition) + "");
				characters.push(newChar);
				currentPosition++;
			}
			else
			{
				String currentChar = new String(message.charAt(currentPosition) + "");
				// System.out.println(currentChar + " " + characters.peek());
				if (currentChar.equals(characters.peek()))
				{
					characters.pop();
				}
				currentPosition++;
			}
		}

		if (characters.isEmpty())
		{
			System.out.println("\nThis is a palindrome\n");
		}
		else
		{
			System.out.println("\nThis is not a palindrome\n");
		}
		characters = new ArrayStack<String>();
	}
}
