
public class ROT18Cipher {

	private final static int countShiftLetter = 13;
	private final static int countShiftNumber = 5;
	
	public static StringBuilder encryption(StringBuilder plainText) 
	{
		plainText = new StringBuilder(plainText.toString().trim().toLowerCase());
		StringBuilder cipherText=new StringBuilder();
		for(char letterInTheText:plainText.toString().toCharArray())
		{
			cipherText.append(ShiftLetterNumber(letterInTheText));
		}
		return cipherText;
	}
	
	public static StringBuilder decryption(StringBuilder cipherText) 
	{
		StringBuilder plainText=new StringBuilder();
		for(char letterInTheText:cipherText.toString().toCharArray())
		{
			plainText.append(ShiftLetterNumber(letterInTheText));
		}
		return plainText;
	}
	
	public static Character ShiftLetterNumber(Character character)
	{
		if(!Character.isDigit(character) && !Character.isLetter(character))
			return character;
		
		int count = 0;
		int countShift = Character.isLetter(character) ? countShiftLetter : countShiftNumber;
		while(count<countShift) 
		{
			switch(character)
			{
				case 'z' : character='a';character--;break;
				case '9' : character='0';character--;break;
			}
			
			character++;
			count++;		
		}
		return character;
	}

	public static void main(String[] args) 
	{
		StringBuilder plainText = new StringBuilder("software2019-2020");
		System.out.println("Metnin Acik Hali :"+plainText);
		
		StringBuilder cipherText = encryption(plainText);
		System.out.println("Metnin Sifrelenmis Hali :"+cipherText);
		
		plainText = decryption(cipherText);
		System.out.println("Metnin Acik Hali :"+plainText);
	}
}
