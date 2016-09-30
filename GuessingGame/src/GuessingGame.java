import java.util.Scanner;
import java.util.Random;

public class GuessingGame {

public static void main (String[] args) {
	Scanner input = new Scanner (System.in);
	Random random = new Random();
	int playerGuess = 0;
	int answer = 0;
	int guessright = 0;
	int guesswrong = 0;
	int highguess = 0;
	int lowguess = 0;
	int roundsPlayed = 0;
	int gameType = 1;
	double roundAccuracy = 3.0;  
	boolean validMenuResponse = false;  
	boolean validGameResponse = false; 

	
while ( gameType != 2 ) { 

		answer = 1 + (int) ( Math.random() * 10 );  
		displayMainMenu ();  
		
		while (!validMenuResponse) {  

			gameType = (int)input.nextInt();   

			if (gameType >= 1 && gameType <= 2) {
				validMenuResponse = true;
			} else {
				System.out.println ("Sorry, try again");
			}

		}
		
		
		if (gameType == 2) {
			gameOver(roundsPlayed, guessright, guesswrong);
			break;
		}
		while (!validGameResponse) {  

			System.out.printf ("-- Round: %d --\n", roundsPlayed);
			System.out.println ("Enter a number between 1 and 10: "); 
			playerGuess = (int)input.nextInt(); 

			if (playerGuess >= 1 && playerGuess <= 10) {
				validGameResponse = true;
			} else {
				System.out.println ("Sorry, try again");
			}

		}

		if ( playerGuess == answer ) {  
			System.out.println ("CORRECT!"); 
			guessright++;

		} else {  
			System.out.printf ("Sorry,the correct answer was: %d\n", answer);
			guesswrong++; 
		}

		roundsPlayed++;  

	
		if (playerGuess >= answer){
			roundAccuracy = (double) answer / playerGuess;
		} else {
			roundAccuracy = (double) playerGuess / answer;
		}

		System.out.printf ("Accuracy percentage this round was: %f.\n", roundAccuracy * 100);
		validMenuResponse = false;  
		validGameResponse = false;  

	}

}  

public static void displayMainMenu () {

	System.out.println ("                              Guessing Game                                 ");
	System.out.println ("Press 1 to play");
	System.out.println ("Press 2 to quit");
	System.out.println ("\n Enter an option:  ");
}


public static void gameOver (int rounds, int good, int bad) {

	double winPercentage = (double) good / bad * 100; 

	System.out.println ("                              GAME OVER                                  ");
	System.out.println ("Overall Percentage");
	System.out.printf ("\nTotal of %d rounds.", rounds);
	System.out.printf ("\nWon a total of %d rounds.", good);
	System.out.printf ("\nLost a total of %d rounds.", bad);
	System.out.printf ("\nTotal win / loss ratio was: %f. percent", winPercentage);
	
}

}

