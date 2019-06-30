
public class ROT47Cipher {
	
	static char[] characters = "!\"#$%&\\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~".toCharArray(); 
	
	final static int countShiftCharacter = characters.length / 2;
	
	public static StringBuilder encryption(StringBuilder plainText) 
	{
		plainText = new StringBuilder(plainText.toString().trim().toLowerCase());
		StringBuilder cipherText=new StringBuilder();
		for(char characterInTheText:plainText.toString().toCharArray())
		{
			cipherText.append(ShiftCharacter(characterInTheText));
		}
		return cipherText;
	}
	
	public static StringBuilder decryption(StringBuilder cipherText) 
	{
		StringBuilder plainText=new StringBuilder();
		for(char characterInTheText:cipherText.toString().toCharArray())
		{
			plainText.append(ShiftCharacter(characterInTheText));
		}
		return plainText;
	}
	
	public static Character ShiftCharacter(Character character)
	{
		int count=0;
		while(count<countShiftCharacter) 
		{
			if(character==characters[characters.length-1])
				character=characters[0];
			else
				character++;

			count++;		
		}
		return character;
	}
	
	public static void main(String[] args) 
	{
		StringBuilder plainText = new StringBuilder("[software engineering 2018-2019] !!");
		System.out.println("Metnin Acik Hali :"+plainText);
		
		StringBuilder cipherText = encryption(plainText);
		System.out.println("Metnin Sifrelenmis Hali :"+cipherText);
		
		plainText = decryption(cipherText);
		System.out.println("Metnin Acik Hali :"+plainText);
	}
}
