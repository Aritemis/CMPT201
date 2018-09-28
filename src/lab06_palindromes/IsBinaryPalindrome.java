/**
 * @author Ariana Fairbanks (Just Me On This One)
 */

package lab06_palindromes;

import java.util.Scanner;

public class IsBinaryPalindrome 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		boolean cont = true;
		IsBinaryPalindrome checker = new IsBinaryPalindrome();
		do {
		 checker.compare(scan);
		}
		while (cont);
		scan.close();
	}
	
	private void compare(Scanner scan)
	{
			String message = null;
			ArrayStack<String> characters = new ArrayStack<String>();
			int middle;
			int currentPosition = 0;
			System.out.println("Enter a number:");
			int next = scan.nextInt();
			message = findBinary(next);
//			message = scan.nextLine();

			if(message.length()%2 == 1)
			{
				middle = (message.length() - 1)/2;
				message = new String(message.substring(0, middle) + message.substring(middle + 1));
			}
			middle = message.length()/2;
			
			while(currentPosition < message.length())
			{

				if(currentPosition < middle)
				{
					String newChar = new String(message.charAt(currentPosition) + "");
					characters.push(newChar);
					currentPosition++;
				}
				else
				{
					String currentChar = new String(message.charAt(currentPosition) + "");
//					System.out.println(currentChar + " " + characters.peek());
					if(currentChar.equals(characters.peek()))
					{
						characters.pop();
					}
					currentPosition++;
				}
			}
			
			if(characters.isEmpty())
			{
				System.out.println("This is a binary palindrome.\n");
			}
			else
			{
				System.out.println("This is not a binary palindrome.\n");
			}
			characters = new ArrayStack<String>();
	}
	
	private String findBinary(int number)
	{
		int half = number;
		String result = "";
		do
		{
			int remainder = half % 2;
			half = half/2;
			result = new String(remainder + result);
		}while(half != 0);
			
		System.out.println("The binary form of " + number + " is " + result + ".");
		return result;
	}
}
