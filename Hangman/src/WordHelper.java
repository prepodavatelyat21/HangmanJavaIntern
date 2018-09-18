import java.util.ArrayList;


public class WordHelper {
	
	public void printWordToGuess(char[] array){
		for (int i = 0; i < array.length; i++){
			if (array[i] == ' '){
				System.out.print(array[i]);
			}	
			else{
				System.out.print(Character.toLowerCase(array[i]) + " ");
			}
				
				
			
			
		}
		System.out.println();
	}
	
	public boolean isTheWordGuessed(char[] array){
		for (int i = 0; i < array.length; i++){
			if (array[i] == '_') return false;
			
		}
		return true;
		
		}
	
		
	
	
	public void printCategories(ArrayList<String> arrList){
		for (String category: arrList){
			System.out.println(category.toLowerCase());
			
			int index = arrList.indexOf(category);
			arrList.set(index, category.toLowerCase());
			
			
			
			
		}
		
	}
	
	
	

}
