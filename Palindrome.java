import java.util.*;

public class Palindrome {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Boolean ignoreCaps, letterNumOnly, isPalindrome, repeat;
		Character textAsChar, frontChar, backChar;
		String text;
		Integer frontIndex, backIndex;
		LinkedHashSet <Character> inputCharList, addPalChars;
				
		do{
			ignoreCaps=true;
			letterNumOnly=true;
			isPalindrome=true;
			repeat=false;
			textAsChar='d';
			text="";
			inputCharList=new LinkedHashSet <Character>();
			addPalChars=new LinkedHashSet <Character>();
			
			System.out.println("Define your palindrome.");
			
			System.out.println("Do you want to ignore capitalization?    Default behavior is yes.  Otherwise, type n for no.  Press Enter");
			text=new String();
			text=input.nextLine();
			if( text.isEmpty() != true){
				text.toLowerCase();
				textAsChar=new Character(text.charAt(0));
				if( textAsChar.equals( new Character('n') ) ){
					ignoreCaps=false;
				}
			}
			
			System.out.println("Do you want to add characters (other than letters and numbers) to be considered in the Palindrome?");
			System.out.println("Default behavior is n and any character that is not a letter or number will be ignored.");
			System.out.println("Otherwise, type y for yes.  Press Enter");
			text=new String();
			text=input.nextLine();
			if( text.isEmpty() != true){
				text.toLowerCase();
				textAsChar=new Character(text.charAt(0));
				if( textAsChar.equals( new Character('y') ) ){
					letterNumOnly=false;

					System.out.println("Type each character that you want tested with the letters and numbers");
					text=new String();
					text=input.nextLine();
					if(text.isEmpty()){
						letterNumOnly=true;
					}else{
						int index=0;
						int length=text.length();
						addPalChars=new LinkedHashSet<Character>();
						
						if(ignoreCaps){
							text.toLowerCase();
						}
						for(; index<length; index++ ){
							addPalChars.add(text.charAt(index));
						}
					}
				}
			}
			
			
			
			System.out.print("Enter in text to test as a palindrome:  ");
			System.out.println();
			text=input.nextLine();
			
			if( !text.isEmpty() ){
				System.out.println("You entered in "+text);
				frontIndex=0;
				backIndex=text.length()-1;
				
				if(ignoreCaps){
					text=text.toLowerCase();
				}
				
				for(;frontIndex<text.length();frontIndex++){
					inputCharList.add(text.charAt(frontIndex));
				}
				frontIndex=0;
				
				System.out.println("Your input contains the following characters:  "+inputCharList.toString());
				
				if(letterNumOnly){
					while( frontIndex < backIndex ){
						frontChar=text.charAt(frontIndex);
						backChar=text.charAt(backIndex);
						
						if( ! Character.isLetterOrDigit(frontChar) ){
							backIndex++;
						}else if( ! Character.isLetterOrDigit(backChar) ){
							frontIndex--;
						}else{
							if( ! backChar.equals(frontChar) ){
								isPalindrome=false;
								backIndex=frontIndex;
							}
						}
						
						frontIndex++;
						backIndex--;
					}
				}else{
					while( frontIndex < backIndex ){
						frontChar=text.charAt(frontIndex);
						backChar=text.charAt(backIndex);
						
						if( ! Character.isLetterOrDigit(frontChar) && ! addPalChars.contains(frontChar) ){
							backIndex++;
						}else if( ! Character.isLetterOrDigit(backChar) && ! addPalChars.contains(backChar) ){
							frontIndex--;
						}else{
							if( ! backChar.equals(frontChar) ){
								isPalindrome=false;
								backIndex=frontIndex;
							}
						}
						
						frontIndex++;
						backIndex--;
					}
				}
				
				System.out.println("FrontIndex ended at "+frontIndex);
				System.out.println("BackIndex ended at "+backIndex);
				
				if(isPalindrome){
					System.out.println("Your input is a palindrome.");
				}else{
					System.out.println("Your input is NOT a plaindrome.");
				}
				
			}else{
				System.out.println("You didn't enter in valid input.");
			}
			
			System.out.println("Do you want to test another palindrome?  Default behavior is no.  Type y, then press Enter to continue");
			text=new String();
			text=input.nextLine();
			if( text.isEmpty() != true){
				text.toLowerCase();
				textAsChar=new Character(text.charAt(0));
				if( textAsChar.equals( new Character('y') ) ){
					repeat=true;
				}
			}
			
		}while(repeat);
		
		input.close();
		
	}//end main

}
