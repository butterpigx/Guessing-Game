/*
1.14.19
Guessing Game
Description: Has you play a game where you have to guess
a number between 1-100. It will tell you if your guess is
higher or lower than the randomly generated number.
*/

import java.util.Scanner;

class GuessingGame{
   //Making the global variables.
   private int guesses;
   private static int allGuesses = 0;
   // LowestGuess is used to determine the fastest time it took you to get from the games you played.
   private static int LowestGuess = Integer.MAX_VALUE;// can just be 9999
   // Change this to easily set the max number that the guessing game can go up to.
   private static int COUNT = 100;
 	 
   public static void main(String args[]){
     	Intoduction();
     	commands();
   }
   // introduces the game for the first time that you start the game.
   private static void Intoduction(){
     	int begin = 0;
     	if(begin == 0){
        	System.out.println("This program allows you to play a guessing game. \nI will think of a number between 1 and \n" +
        	COUNT + " and will allow you to guess until \nyou get it. For each guess, " +
        	"I will tell you \nwhether the right answer is higher or lower \nthan your guess.\n");
        	begin++;
     	}
     	else{
        	System.out.print("");
     	}
   }
   // You have to input a number between 1-100.
   private int guessNumber(){
 	 
     	int guess = 0;
     	Scanner type = new Scanner(System.in);
     	System.out.print("Your guess?");
        	//Type in a number for your guess.
     	guess = type.nextInt();
     	guesses++;
     	return guess;
   }
   // Place where you choose to play or not. Also tells you the results if you choose not to play.
   private static void commands(){
     	String command = "";
     	Scanner in = new Scanner(System.in);
     	/* Need to add this line because static methods belong to class, and non-static methods belong to instances of the class
     	[class_name] [any_name] = new [class_name]();*/
     	GuessingGame play = new GuessingGame();
     	int countGames = 0;
 	 
     	do{
        	play.random();
        	++countGames;
        	System.out.print("Do you want to play again?");
        	command = in.nextLine();
     	}
  	while(command.toLowerCase().startsWith("Y".toLowerCase()));
  	// If you type in no or a word that starts with "n" it will show the 5 printlns.
     	if(command.toLowerCase().startsWith("N".toLowerCase())){
        	System.out.println("Thanks for playing!\n");
        	System.out.println("Total games played:   	" +countGames);
        	System.out.println("Total guesses:        	" + allGuesses);
        	System.out.println("Average guesses a game:   " + (allGuesses/countGames));
        	System.out.println("Lowest number of guesses: " + LowestGuess); 	 
        	}
      else{
         System.out.println("Not a valid input.");
      }
   }
   //Tells you if your guess is higher or lower than the random number.
   private void random(){
     	//Generates a random number. You have to put (int) to change it from double to int.
     	int randomNum = (int)Math.floor(Math.random() * COUNT + 1);
     	int guess = guessNumber();
    	 
     	while(guess != randomNum){
        	if(guess > randomNum)
           	System.out.println("It's Lower.");
        	else if(guess < randomNum)
           	System.out.println("It's Higher.");
        	else{
           	return;
        	}
        	/*Set guess equal to guessNumber so that the guesses do not get reset everytime you
        	start a new game, because guess is always equal to 0 in the beginning.*/
        	guess = guessNumber();
     	}
     	// Finds what guess was the lowest from all of the games you played.
     	if(guesses < LowestGuess){
        	LowestGuess = guesses;
        	System.out.println("You got it! It was: " + randomNum + "!\n");
     	}
     	allGuesses = allGuesses + guesses;
  }
}
