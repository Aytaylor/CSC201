import java.util.Scanner;

public class ISBN {

	public static void main(String[] args) {
		//Create Scanner object
		Scanner input = new Scanner(System.in);
		
		int sum = 0; 
		//Prompt for 9 digit integer
		System.out.println("Enter the first 9 digits of an ISBN as an integer: ");
		int isbn = input.nextInt();
		
		//close Scanner
		input.close();
		
		//Format int to string with leading zeroes
		String isbnString = String.format("%09d", isbn);
		
		//Ensure 9 digits are entered
		if (isbnString.length() != 9)
		{
			System.out.println("You have not entered 9 digits. Exiting program...");
			System.exit(0);
		}
		
		//iterate over chars of string. 
		for (int i = 1; i <= 9; ++i)
		{
			//Subtract 48 from ASCII to get actual value before multiplying; Subtract 1 for i since it is incremented at the beginning of the loop
			sum += (i * (isbnString.charAt(i - 1) - 48));
		}
		//Calculate Checksum value
		int checkSum =  sum % 11;
		if (checkSum == 10)
		{
			System.out.println("The ISBN-10 number is " + isbnString + 'X');
		}
		else
		{
			System.out.println("The ISBN-10 number is " + isbnString + checkSum);
		}
		
	}
}
