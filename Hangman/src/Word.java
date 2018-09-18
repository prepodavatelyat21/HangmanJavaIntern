
public class Word {
	
	private String wordString;
	private String category;
	
	public String getWordString(){
		return this.wordString;
	}
	
	public void setWordString(String wordString){
		this.wordString = wordString;
	}
	
	public String getCategory(){
		return this.category;
		
	}
	
	public void setCategory(String category){
		this.category = category;
	}
	
	public Word(String wordString, String category) {
		this.wordString = wordString;
		this.category = category;
	}
	

}
