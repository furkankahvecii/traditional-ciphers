
public class BifidCipher {
	
	static char alphabetsMatrix[][] = {  {'A','B','C','D','E','F'} , {'G','H','I','J','K','L'} , {'M','N','O','P','Q','R'} , 
		       							 {'S','T','U','V','W','X'} , {'Y','Z','0','1','2','3'} , {'4','5','6','7','8','9'} };
	// Sifreleme metodu
	public static String encryption(String plainText)
	{
		if(plainText.length()%2!=0)
			plainText+="Q";
		plainText= plainText.toUpperCase();
		StringBuilder cipherText = new StringBuilder();
		Integer[][] cipherTextMatrix = new Integer[2][plainText.length()];
		for(int i=0;i<plainText.length();i++)
		{
			String indexs = turn(plainText.charAt(i));
			cipherTextMatrix[0][i] = Integer.parseInt(String.valueOf(indexs.charAt(0))); 
			cipherTextMatrix[1][i] = Integer.parseInt(String.valueOf(indexs.charAt(1))); 
		}
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<plainText.length();j++)
			{
				cipherText.append(alphabetsMatrix[cipherTextMatrix[i][j]][cipherTextMatrix[i][++j]]);
			}
		}
		return cipherText.toString();
	}
	
	// Sifre cozme metodu
	public static String decryption(String cipherText)
	{
		StringBuilder plainText = new StringBuilder();
		Integer[][] plainTextMatrix = new Integer[2][cipherText.length()];
		int column=0;
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<cipherText.length();j++)
			{
				String a = turn(cipherText.charAt(column++));
				plainTextMatrix[i][j] = Integer.parseInt(String.valueOf(a.charAt(0))); 
				plainTextMatrix[i][++j] = Integer.parseInt(String.valueOf(a.charAt(1))); 
			}
		}
		
		for(int i=0;i<cipherText.length();i++)
		{
			plainText.append(alphabetsMatrix[plainTextMatrix[0][i]][plainTextMatrix[1][i]]);
		}
		
		return plainText.toString();
	}
	
	// Metod icerisine gelen harfin index karsiligini dondurur.
	public static String turn(char c)
	{
		for(int i=0;i<alphabetsMatrix.length;i++)
		{
			for(int j=0;j<alphabetsMatrix[0].length;j++)
			{
				if(alphabetsMatrix[i][j]==c)
					return i+""+j;
			}
		}
		return "";
	}

	public static void main(String[] args) 
	{
		String plainText = "KLUYAZILIMMUHENDISLIGI";
		System.out.println("Metnin Acik Hali :"+plainText);
		
		String cipherText = encryption(plainText);
		System.out.println("Metnin Sifrelenmis Hali :"+cipherText);
		
		plainText = decryption(cipherText);
		System.out.println("Metnin Cozulmus Hali :"+plainText);
	}
}
