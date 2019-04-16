
public class PolybiusSquareCipher
{
	static char polybiusBoard[][] = {  {'A','B','C','D','E','F'} , {'G','H','I','J','K','L'} , {'M','N','O','P','Q','R'} , 
			 					       {'S','T','U','V','W','X'} , {'Y','Z','0','1','2','3'} , {'4','5','6','7','8','9'} }; // Alfabe matrisi
	
	static String encryption(String plainText) // Sifreleme metodu 
	{
		StringBuilder cipherText = new StringBuilder();
		
		for(int i = 0 ; i<plainText.length();i++) // Bu dongu ile metnin her karakterine karsilik gelen satir ve sutun degerleri elde edilir.
		{
			if(Character.isLetter(plainText.charAt(i)) || Character.isDigit(plainText.charAt(i))) 
				cipherText.append(turnPolybius(plainText.charAt(i)));
			else 
				cipherText.append(plainText.charAt(i));
		}
		
		return cipherText.toString();
	}
	
	static String decryption(String cipherText) // Sifre cozme metodu.
	{
		StringBuilder plainText = new StringBuilder();
		
		for(int i=0;i<cipherText.length();i+=2)
		{
			if(Character.isDigit(cipherText.charAt(i)))
				plainText.append(unTurnPolybius(Character.getNumericValue(cipherText.charAt(i)),Character.getNumericValue(cipherText.charAt(i+1))));
			else
			{
				plainText.append(Character.toUpperCase(cipherText.charAt(i)));
				i--;
			}			
		}
		
		return plainText.toString();
	}
	
	static String turnPolybius(char character) // Icerisine gelen karaktere karsilik gelen satir ve sutun degerlerini bulur ve bu degerleri birlestirip dondurur.
	{
		for(int i=0;i<polybiusBoard.length;i++)
		{
			for(int j=0;j<polybiusBoard[0].length;j++)
			{
				if(polybiusBoard[i][j] == Character.toUpperCase(character))
				{
					return (i+1)+""+(j+1);
				}
			}
		}
		return String.valueOf(character);
	}
	
	static char unTurnPolybius(int i,int j) // Icerisine gelen satir ve sutun degerlerine karsilik gelen karakteri bulur ve bu karakteri dondurur.
	{
		return polybiusBoard[i-1][j-1];
	}
	
	public static void main(String args[])
	{
		String plainText = "KIRKLARELI UNIVERSITESI YAZILIM MUHENDISLIGI";
		System.out.println("Metnin Acik Hali :"+plainText);
		
		String cipherText = encryption(plainText);
		System.out.println("Metnin Sifrelenmis Hali :"+cipherText);
		
		plainText = decryption(cipherText);
		System.out.println("Metnin Cozulmus Hali :"+plainText);
	}
}