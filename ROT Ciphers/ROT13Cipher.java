
public class ROT13Cipher {
	
	private final static int countShiftLetter = 13;
	
	public static StringBuilder encryption(StringBuilder plainText) 
	{
		plainText = new StringBuilder(plainText.toString().trim().toLowerCase());
		StringBuilder cipherText=new StringBuilder();
		for(char letterInTheText:plainText.toString().toCharArray())
		{
			cipherText.append(ShiftLetter(letterInTheText));
		}
		return cipherText;
	}
	
	public static StringBuilder decryption(StringBuilder cipherText) 
	{
		StringBuilder plainText=new StringBuilder();
		for(char letterInTheText:cipherText.toString().toCharArray())
		{
			plainText.append(ShiftLetter(letterInTheText));
		}
		return plainText;
	}
	
	public static Character ShiftLetter(Character letter)
	{
		if(!Character.isLetter(letter))
			return letter;

		int count=0;
		while(count<countShiftLetter) 
		{
			if(letter=='z')
				letter='a';
			else
				letter++;

			count++;		
		}
		return letter;
	}

	public static void main(String[] args) 
	{
		StringBuilder plainText = new StringBuilder("software");
		System.out.println("Metnin Acik Hali :"+plainText);
		
		StringBuilder cipherText = encryption(plainText);
		System.out.println("Metnin Sifrelenmis Hali :"+cipherText);
		
		plainText = decryption(cipherText);
		System.out.println("Metnin Acik Hali :"+plainText);
	}
}
