
public class ROT5Cipher {
	
	private final static int countShiftNumber = 5;
	
	public static StringBuilder encryption(StringBuilder plainText) 
	{
		plainText = new StringBuilder(plainText.toString().trim());
		StringBuilder cipherText=new StringBuilder();
		for(char letterInTheNumber:plainText.toString().toCharArray())
		{
			cipherText.append(ShiftNumber(letterInTheNumber));
		}
		return cipherText;
	}
	
	public static StringBuilder decryption(StringBuilder cipherText) 
	{
		StringBuilder plainText=new StringBuilder();
		for(char letterInTheNumber:cipherText.toString().toCharArray())
		{
			plainText.append(ShiftNumber(letterInTheNumber));
		}
		return plainText;
	}
	
	public static Character ShiftNumber(Character number)
	{
		if(!Character.isDigit(number))
			return number;

		int count=0;
		while(count<countShiftNumber) 
		{
			if(number=='9')
				number='0';
			else
				number++;

			count++;		
		}
		return number;
	}

	public static void main(String[] args)
	{
		StringBuilder plainText = new StringBuilder("0123456789");
		System.out.println("Metnin Acik Hali :"+plainText);
		
		StringBuilder cipherText = encryption(plainText);
		System.out.println("Metnin Sifrelenmis Hali :"+cipherText);
		
		plainText = decryption(cipherText);
		System.out.println("Metnin Acik Hali :"+plainText);
	}
}
