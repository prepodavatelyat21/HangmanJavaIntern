import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class MainClass {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		Random rand = new Random();
		FileReader f = new FileReader("src/words.txt");
		BufferedReader br = new BufferedReader(f);
		String line = br.readLine();
		String currentCategory = "";
		ArrayList<String> categories = new ArrayList<String>();
		ArrayList<Word> words = new ArrayList<Word>();
		ArrayList<Word> playingWords = new ArrayList<Word>();
		WordHelper wordHelper = new WordHelper();
		while (line != null){
			
			if(line.charAt(0) == '_'){
				currentCategory = line.substring(1);
				categories.add(currentCategory);
			}
			else{
				words.add(new Word(line, currentCategory));
			}
			
			
			line = br.readLine();
			
			
		}
		
		
		
		
		
		boolean weAreplaying = true;
		int score = 0;
		
		while(weAreplaying) {
			
			playingWords.clear();
			System.out.println("Choose a category:");
			wordHelper.printCategories(categories);
			
			String enteredCategory = scanner.nextLine();
			
			if(!categories.contains(enteredCategory.toLowerCase())){
				
				System.out.println("Please choose an existing category!");
				continue;
				
			}
				
			
			for (Word word: words){
				if (word.getCategory().toLowerCase().equals(enteredCategory.toLowerCase())){
					
					playingWords.add(new Word(word.getWordString(), word.getCategory()));
					
				}
				
				
			}
			
			
			int id = rand.nextInt(playingWords.size());
			Word randWord = playingWords.get(id);
			char[] wordToGuess = randWord.getWordString().toCharArray();
		  
			  int amountOfGuesses = 10;
			  char[] playerGuess = new char[wordToGuess.length];
			  
			  for(int i = 0; i < wordToGuess.length; i++){
				  if (wordToGuess[i] == ' '){
					  playerGuess[i] = ' ';
				  }
				  else
				  {
					  playerGuess[i] = '_';
				  }
				  
			  }
			  
			  boolean wordIsGuessed = false;
			  int tries = 0;
			  
			  while(!wordIsGuessed && tries != amountOfGuesses){
				  System.out.printf("Score: %d\n", score);
				  System.out.printf("Attempts left: %d\n",amountOfGuesses - tries );
				  System.out.println("Current word/phrase: ");
				  wordHelper.printWordToGuess(playerGuess);
				  System.out.println("Please enter a letter:");
				  char input = scanner.nextLine().charAt(0);
				  
				  
				  
				  if((input >= 'a' && input <= 'z') || (input >= 'A' && input <= 'Z')){
					  
					  tries ++;
					  for(int i = 0; i < wordToGuess.length; i++){
						  if ( Character.toLowerCase(wordToGuess[i]) == Character.toLowerCase(input)){
							  playerGuess[i] = input;
						  }
						  
						  if (wordHelper.isTheWordGuessed(playerGuess)){
							  wordIsGuessed = true;
							  
							  
						  }
						  
					  }
					  
				  }
				  else{
					  System.out.println("Please enter only a latin letter!");
				  }
				  
				  if (wordIsGuessed)
				  {
					  score ++;
					  System.out.println("Congratulations! You have revealed the word: ");
					  wordHelper.printWordToGuess(playerGuess);
				  }
				  
				  
			  }
			  
			  if (tries == 10){
				  System.out.println("Sorry, you lost!");
				  weAreplaying = false;
			  }
		
		
		
		
		}
		
		System.out.println("Game is over!");
		scanner.close();
		br.close();
	}
	
	
	

}
